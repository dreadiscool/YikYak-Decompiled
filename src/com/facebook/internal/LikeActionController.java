package com.facebook.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.AppEventsLogger;
import com.facebook.FacebookRequestError;
import com.facebook.RequestBatch;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.Settings;
import com.facebook.widget.FacebookDialog;
import com.facebook.widget.FacebookDialog.Callback;
import com.facebook.widget.FacebookDialog.PendingCall;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class LikeActionController
{
  public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR = "com.facebook.sdk.LikeActionController.DID_ERROR";
  public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_RESET = "com.facebook.sdk.LikeActionController.DID_RESET";
  public static final String ACTION_LIKE_ACTION_CONTROLLER_UPDATED = "com.facebook.sdk.LikeActionController.UPDATED";
  public static final String ACTION_OBJECT_ID_KEY = "com.facebook.sdk.LikeActionController.OBJECT_ID";
  private static final int ERROR_CODE_OBJECT_ALREADY_LIKED = 3501;
  public static final String ERROR_INVALID_OBJECT_ID = "Invalid Object Id";
  public static final String ERROR_PUBLISH_ERROR = "Unable to publish the like/unlike action";
  private static final String JSON_BOOL_IS_OBJECT_LIKED_KEY = "is_object_liked";
  private static final String JSON_BUNDLE_PENDING_CALL_ANALYTICS_BUNDLE = "pending_call_analytics_bundle";
  private static final String JSON_INT_VERSION_KEY = "com.facebook.internal.LikeActionController.version";
  private static final String JSON_STRING_LIKE_COUNT_WITHOUT_LIKE_KEY = "like_count_string_without_like";
  private static final String JSON_STRING_LIKE_COUNT_WITH_LIKE_KEY = "like_count_string_with_like";
  private static final String JSON_STRING_OBJECT_ID_KEY = "object_id";
  private static final String JSON_STRING_PENDING_CALL_ID_KEY = "pending_call_id";
  private static final String JSON_STRING_SOCIAL_SENTENCE_WITHOUT_LIKE_KEY = "social_sentence_without_like";
  private static final String JSON_STRING_SOCIAL_SENTENCE_WITH_LIKE_KEY = "social_sentence_with_like";
  private static final String JSON_STRING_UNLIKE_TOKEN_KEY = "unlike_token";
  private static final String LIKE_ACTION_CONTROLLER_STORE = "com.facebook.LikeActionController.CONTROLLER_STORE_KEY";
  private static final String LIKE_ACTION_CONTROLLER_STORE_OBJECT_SUFFIX_KEY = "OBJECT_SUFFIX";
  private static final String LIKE_ACTION_CONTROLLER_STORE_PENDING_OBJECT_ID_KEY = "PENDING_CONTROLLER_KEY";
  private static final int LIKE_ACTION_CONTROLLER_VERSION = 2;
  private static final String LIKE_DIALOG_RESPONSE_LIKE_COUNT_STRING_KEY = "like_count_string";
  private static final String LIKE_DIALOG_RESPONSE_OBJECT_IS_LIKED_KEY = "object_is_liked";
  private static final String LIKE_DIALOG_RESPONSE_SOCIAL_SENTENCE_KEY = "social_sentence";
  private static final String LIKE_DIALOG_RESPONSE_UNLIKE_TOKEN_KEY = "unlike_token";
  private static final int MAX_CACHE_SIZE = 128;
  private static final int MAX_OBJECT_SUFFIX = 1000;
  private static final String TAG = LikeActionController.class.getSimpleName();
  private static Context applicationContext;
  private static final ConcurrentHashMap<String, LikeActionController> cache = new ConcurrentHashMap();
  private static FileLruCache controllerDiskCache;
  private static WorkQueue diskIOWorkQueue = new WorkQueue(1);
  private static Handler handler;
  private static boolean isInitialized;
  private static boolean isPendingBroadcastReset;
  private static WorkQueue mruCacheWorkQueue = new WorkQueue(1);
  private static String objectIdForPendingController;
  private static volatile int objectSuffix;
  private AppEventsLogger appEventsLogger;
  private boolean isObjectLiked;
  private boolean isObjectLikedOnServer;
  private boolean isPendingLikeOrUnlike;
  private String likeCountStringWithLike;
  private String likeCountStringWithoutLike;
  private String objectId;
  private boolean objectIsPage;
  private Bundle pendingCallAnalyticsBundle;
  private UUID pendingCallId;
  private Session session;
  private String socialSentenceWithLike;
  private String socialSentenceWithoutLike;
  private String unlikeToken;
  private String verifiedObjectId;
  
  private LikeActionController(Session paramSession, String paramString)
  {
    this.session = paramSession;
    this.objectId = paramString;
    this.appEventsLogger = AppEventsLogger.newLogger(applicationContext, paramSession);
  }
  
  private static void broadcastAction(LikeActionController paramLikeActionController, String paramString)
  {
    broadcastAction(paramLikeActionController, paramString, null);
  }
  
  private static void broadcastAction(LikeActionController paramLikeActionController, String paramString, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramString);
    if (paramLikeActionController != null)
    {
      if (paramBundle == null) {
        paramBundle = new Bundle();
      }
      paramBundle.putString("com.facebook.sdk.LikeActionController.OBJECT_ID", paramLikeActionController.getObjectId());
    }
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    LocalBroadcastManager.getInstance(applicationContext).sendBroadcast(localIntent);
  }
  
  private boolean canUseOGPublish()
  {
    if ((!this.objectIsPage) && (this.verifiedObjectId != null) && (this.session != null) && (this.session.getPermissions() != null) && (this.session.getPermissions().contains("publish_actions"))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static void createControllerForObjectId(String paramString, LikeActionController.CreationCallback paramCreationCallback)
  {
    LikeActionController localLikeActionController1 = getControllerFromInMemoryCache(paramString);
    if (localLikeActionController1 != null) {
      invokeCallbackWithController(paramCreationCallback, localLikeActionController1);
    }
    for (;;)
    {
      return;
      LikeActionController localLikeActionController2 = deserializeFromDiskSynchronously(paramString);
      if (localLikeActionController2 == null)
      {
        localLikeActionController2 = new LikeActionController(Session.getActiveSession(), paramString);
        serializeToDiskAsync(localLikeActionController2);
      }
      putControllerInMemoryCache(paramString, localLikeActionController2);
      handler.post(new LikeActionController.2(localLikeActionController2));
      invokeCallbackWithController(paramCreationCallback, localLikeActionController2);
    }
  }
  
  /* Error */
  private static LikeActionController deserializeFromDiskSynchronously(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: invokestatic 367	com/facebook/internal/LikeActionController:getCacheKeyForObjectId	(Ljava/lang/String;)Ljava/lang/String;
    //   6: astore 6
    //   8: getstatic 273	com/facebook/internal/LikeActionController:controllerDiskCache	Lcom/facebook/internal/FileLruCache;
    //   11: aload 6
    //   13: invokevirtual 373	com/facebook/internal/FileLruCache:get	(Ljava/lang/String;)Ljava/io/InputStream;
    //   16: astore 7
    //   18: aload 7
    //   20: astore_3
    //   21: aload_3
    //   22: ifnull +27 -> 49
    //   25: aload_3
    //   26: invokestatic 379	com/facebook/internal/Utility:readStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   29: astore 9
    //   31: aload 9
    //   33: invokestatic 383	com/facebook/internal/Utility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   36: ifne +13 -> 49
    //   39: aload 9
    //   41: invokestatic 386	com/facebook/internal/LikeActionController:deserializeFromJson	(Ljava/lang/String;)Lcom/facebook/internal/LikeActionController;
    //   44: astore 10
    //   46: aload 10
    //   48: astore_1
    //   49: aload_3
    //   50: ifnull +7 -> 57
    //   53: aload_3
    //   54: invokestatic 390	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   57: aload_1
    //   58: areturn
    //   59: astore 5
    //   61: aconst_null
    //   62: astore_3
    //   63: aload_3
    //   64: ifnull -7 -> 57
    //   67: aload_3
    //   68: invokestatic 390	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   71: goto -14 -> 57
    //   74: astore_2
    //   75: aconst_null
    //   76: astore_3
    //   77: aload_2
    //   78: astore 4
    //   80: aload_3
    //   81: ifnull +7 -> 88
    //   84: aload_3
    //   85: invokestatic 390	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   88: aload 4
    //   90: athrow
    //   91: astore 4
    //   93: goto -13 -> 80
    //   96: astore 8
    //   98: goto -35 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramString	String
    //   1	57	1	localObject1	Object
    //   74	4	2	localObject2	Object
    //   20	65	3	localInputStream1	java.io.InputStream
    //   78	11	4	localObject3	Object
    //   91	1	4	localObject4	Object
    //   59	1	5	localIOException1	java.io.IOException
    //   6	6	6	str1	String
    //   16	3	7	localInputStream2	java.io.InputStream
    //   96	1	8	localIOException2	java.io.IOException
    //   29	11	9	str2	String
    //   44	3	10	localLikeActionController	LikeActionController
    // Exception table:
    //   from	to	target	type
    //   2	18	59	java/io/IOException
    //   2	18	74	finally
    //   25	46	91	finally
    //   25	46	96	java/io/IOException
  }
  
  private static LikeActionController deserializeFromJson(String paramString)
  {
    Object localObject = null;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      if (localJSONObject1.optInt("com.facebook.internal.LikeActionController.version", -1) == 2)
      {
        localLikeActionController = new LikeActionController(Session.getActiveSession(), localJSONObject1.getString("object_id"));
        localLikeActionController.likeCountStringWithLike = localJSONObject1.optString("like_count_string_with_like", null);
        localLikeActionController.likeCountStringWithoutLike = localJSONObject1.optString("like_count_string_without_like", null);
        localLikeActionController.socialSentenceWithLike = localJSONObject1.optString("social_sentence_with_like", null);
        localLikeActionController.socialSentenceWithoutLike = localJSONObject1.optString("social_sentence_without_like", null);
        localLikeActionController.isObjectLiked = localJSONObject1.optBoolean("is_object_liked");
        localLikeActionController.unlikeToken = localJSONObject1.optString("unlike_token", null);
        String str = localJSONObject1.optString("pending_call_id", null);
        if (!Utility.isNullOrEmpty(str)) {
          localLikeActionController.pendingCallId = UUID.fromString(str);
        }
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("pending_call_analytics_bundle");
        if (localJSONObject2 != null) {
          localLikeActionController.pendingCallAnalyticsBundle = BundleJSONConverter.convertToBundle(localJSONObject2);
        }
        localObject = localLikeActionController;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        LikeActionController localLikeActionController = null;
      }
    }
    return localObject;
  }
  
  private static void ensureApplicationContextExists(Context paramContext)
  {
    try
    {
      if (applicationContext == null) {
        applicationContext = paramContext.getApplicationContext();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void fetchVerifiedObjectId(LikeActionController.RequestCompletionCallback paramRequestCompletionCallback)
  {
    if (!Utility.isNullOrEmpty(this.verifiedObjectId)) {
      if (paramRequestCompletionCallback != null) {
        paramRequestCompletionCallback.onComplete();
      }
    }
    for (;;)
    {
      return;
      LikeActionController.GetOGObjectIdRequestWrapper localGetOGObjectIdRequestWrapper = new LikeActionController.GetOGObjectIdRequestWrapper(this, this.objectId);
      LikeActionController.GetPageIdRequestWrapper localGetPageIdRequestWrapper = new LikeActionController.GetPageIdRequestWrapper(this, this.objectId);
      RequestBatch localRequestBatch = new RequestBatch();
      localGetOGObjectIdRequestWrapper.addToBatch(localRequestBatch);
      localGetPageIdRequestWrapper.addToBatch(localRequestBatch);
      localRequestBatch.addCallback(new LikeActionController.10(this, localGetOGObjectIdRequestWrapper, localGetPageIdRequestWrapper, paramRequestCompletionCallback));
      localRequestBatch.executeAsync();
    }
  }
  
  private static String getCacheKeyForObjectId(String paramString)
  {
    String str = null;
    Session localSession = Session.getActiveSession();
    if ((localSession != null) && (localSession.isOpened())) {
      str = localSession.getAccessToken();
    }
    if (str != null) {
      str = Utility.md5hash(str);
    }
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = paramString;
    arrayOfObject[1] = Utility.coerceValueIfNullOrEmpty(str, "");
    arrayOfObject[2] = Integer.valueOf(objectSuffix);
    return String.format("%s|%s|com.fb.sdk.like|%d", arrayOfObject);
  }
  
  public static void getControllerForObjectId(Context paramContext, String paramString, LikeActionController.CreationCallback paramCreationCallback)
  {
    ensureApplicationContextExists(paramContext);
    if (!isInitialized) {
      performFirstInitialize();
    }
    LikeActionController localLikeActionController = getControllerFromInMemoryCache(paramString);
    if (localLikeActionController != null) {
      invokeCallbackWithController(paramCreationCallback, localLikeActionController);
    }
    for (;;)
    {
      return;
      diskIOWorkQueue.addActiveWorkItem(new LikeActionController.CreateLikeActionControllerWorkItem(paramString, paramCreationCallback));
    }
  }
  
  private static LikeActionController getControllerFromInMemoryCache(String paramString)
  {
    String str = getCacheKeyForObjectId(paramString);
    LikeActionController localLikeActionController = (LikeActionController)cache.get(str);
    if (localLikeActionController != null) {
      mruCacheWorkQueue.addActiveWorkItem(new LikeActionController.MRUCacheWorkItem(str, false));
    }
    return localLikeActionController;
  }
  
  private FacebookDialog.Callback getFacebookDialogCallback(Bundle paramBundle)
  {
    return new LikeActionController.5(this, paramBundle);
  }
  
  public static boolean handleOnActivityResult(Context paramContext, int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    ensureApplicationContextExists(paramContext);
    UUID localUUID = NativeProtocol.getCallIdFromIntent(paramIntent);
    if (localUUID == null) {}
    for (;;)
    {
      return bool;
      if (Utility.isNullOrEmpty(objectIdForPendingController)) {
        objectIdForPendingController = applicationContext.getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).getString("PENDING_CONTROLLER_KEY", null);
      }
      if (!Utility.isNullOrEmpty(objectIdForPendingController))
      {
        getControllerForObjectId(applicationContext, objectIdForPendingController, new LikeActionController.1(paramInt1, paramInt2, paramIntent, localUUID));
        bool = true;
      }
    }
  }
  
  private static void invokeCallbackWithController(LikeActionController.CreationCallback paramCreationCallback, LikeActionController paramLikeActionController)
  {
    if (paramCreationCallback == null) {}
    for (;;)
    {
      return;
      handler.post(new LikeActionController.3(paramCreationCallback, paramLikeActionController));
    }
  }
  
  private void logAppEventForError(String paramString, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle(paramBundle);
    localBundle.putString("object_id", this.objectId);
    localBundle.putString("current_action", paramString);
    this.appEventsLogger.logSdkEvent("fb_like_control_error", null, localBundle);
  }
  
  private void logAppEventForError(String paramString, FacebookRequestError paramFacebookRequestError)
  {
    Bundle localBundle = new Bundle();
    if (paramFacebookRequestError != null)
    {
      JSONObject localJSONObject = paramFacebookRequestError.getRequestResult();
      if (localJSONObject != null) {
        localBundle.putString("error", localJSONObject.toString());
      }
    }
    logAppEventForError(paramString, localBundle);
  }
  
  private boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent, UUID paramUUID)
  {
    boolean bool = false;
    if ((this.pendingCallId == null) || (!this.pendingCallId.equals(paramUUID))) {}
    for (;;)
    {
      return bool;
      FacebookDialog.PendingCall localPendingCall = PendingCallStore.getInstance().getPendingCallById(this.pendingCallId);
      if (localPendingCall != null)
      {
        FacebookDialog.handleActivityResult(applicationContext, localPendingCall, paramInt1, paramIntent, getFacebookDialogCallback(this.pendingCallAnalyticsBundle));
        stopTrackingPendingCall();
        bool = true;
      }
    }
  }
  
  /* Error */
  private static void performFirstInitialize()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 505	com/facebook/internal/LikeActionController:isInitialized	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: new 357	android/os/Handler
    //   18: dup
    //   19: invokestatic 609	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   22: invokespecial 612	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   25: putstatic 281	com/facebook/internal/LikeActionController:handler	Landroid/os/Handler;
    //   28: getstatic 152	com/facebook/internal/LikeActionController:applicationContext	Landroid/content/Context;
    //   31: ldc 59
    //   33: iconst_0
    //   34: invokevirtual 544	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   37: ldc 62
    //   39: iconst_1
    //   40: invokeinterface 615 3 0
    //   45: putstatic 258	com/facebook/internal/LikeActionController:objectSuffix	I
    //   48: new 369	com/facebook/internal/FileLruCache
    //   51: dup
    //   52: getstatic 152	com/facebook/internal/LikeActionController:applicationContext	Landroid/content/Context;
    //   55: getstatic 128	com/facebook/internal/LikeActionController:TAG	Ljava/lang/String;
    //   58: new 617	com/facebook/internal/FileLruCache$Limits
    //   61: dup
    //   62: invokespecial 618	com/facebook/internal/FileLruCache$Limits:<init>	()V
    //   65: invokespecial 621	com/facebook/internal/FileLruCache:<init>	(Landroid/content/Context;Ljava/lang/String;Lcom/facebook/internal/FileLruCache$Limits;)V
    //   68: putstatic 273	com/facebook/internal/LikeActionController:controllerDiskCache	Lcom/facebook/internal/FileLruCache;
    //   71: invokestatic 624	com/facebook/internal/LikeActionController:registerSessionBroadcastReceivers	()V
    //   74: iconst_1
    //   75: putstatic 505	com/facebook/internal/LikeActionController:isInitialized	Z
    //   78: goto -67 -> 11
    //   81: astore_0
    //   82: ldc 2
    //   84: monitorexit
    //   85: aload_0
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   81	5	0	localObject	Object
    //   6	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	81	finally
    //   15	78	81	finally
  }
  
  private void presentLikeDialog(Activity paramActivity, Fragment paramFragment, Bundle paramBundle)
  {
    LikeActionController.LikeDialogBuilder localLikeDialogBuilder = new LikeActionController.LikeDialogBuilder(paramActivity, this.objectId);
    localLikeDialogBuilder.setFragment(paramFragment);
    if (localLikeDialogBuilder.canPresent())
    {
      trackPendingCall(localLikeDialogBuilder.build().present(), paramBundle);
      this.appEventsLogger.logSdkEvent("fb_like_control_did_present_dialog", null, paramBundle);
    }
    for (;;)
    {
      return;
      String str = localLikeDialogBuilder.getWebFallbackUrl();
      if ((!Utility.isNullOrEmpty(str)) && (FacebookWebFallbackDialog.presentWebFallback(paramActivity, str, localLikeDialogBuilder.getApplicationId(), localLikeDialogBuilder.getAppCall(), getFacebookDialogCallback(paramBundle)))) {
        this.appEventsLogger.logSdkEvent("fb_like_control_did_present_fallback_dialog", null, paramBundle);
      }
    }
  }
  
  private void publishAgainIfNeeded(Bundle paramBundle)
  {
    if ((this.isObjectLiked != this.isObjectLikedOnServer) && (!publishLikeOrUnlikeAsync(this.isObjectLiked, paramBundle))) {
      if (this.isObjectLiked) {
        break label38;
      }
    }
    label38:
    for (boolean bool = true;; bool = false)
    {
      publishDidError(bool);
      return;
    }
  }
  
  private void publishDidError(boolean paramBoolean)
  {
    updateLikeState(paramBoolean);
    Bundle localBundle = new Bundle();
    localBundle.putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Unable to publish the like/unlike action");
    broadcastAction(this, "com.facebook.sdk.LikeActionController.DID_ERROR", localBundle);
  }
  
  private void publishLikeAsync(Bundle paramBundle)
  {
    this.isPendingLikeOrUnlike = true;
    fetchVerifiedObjectId(new LikeActionController.6(this, paramBundle));
  }
  
  private boolean publishLikeOrUnlikeAsync(boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool = true;
    if (canUseOGPublish()) {
      if (paramBoolean) {
        publishLikeAsync(paramBundle);
      }
    }
    for (;;)
    {
      return bool;
      if (!Utility.isNullOrEmpty(this.unlikeToken)) {
        publishUnlikeAsync(paramBundle);
      } else {
        bool = false;
      }
    }
  }
  
  private void publishUnlikeAsync(Bundle paramBundle)
  {
    this.isPendingLikeOrUnlike = true;
    RequestBatch localRequestBatch = new RequestBatch();
    LikeActionController.PublishUnlikeRequestWrapper localPublishUnlikeRequestWrapper = new LikeActionController.PublishUnlikeRequestWrapper(this, this.unlikeToken);
    localPublishUnlikeRequestWrapper.addToBatch(localRequestBatch);
    localRequestBatch.addCallback(new LikeActionController.7(this, localPublishUnlikeRequestWrapper, paramBundle));
    localRequestBatch.executeAsync();
  }
  
  private static void putControllerInMemoryCache(String paramString, LikeActionController paramLikeActionController)
  {
    String str = getCacheKeyForObjectId(paramString);
    mruCacheWorkQueue.addActiveWorkItem(new LikeActionController.MRUCacheWorkItem(str, true));
    cache.put(str, paramLikeActionController);
  }
  
  private void refreshStatusAsync()
  {
    if ((this.session == null) || (this.session.isClosed()) || (SessionState.CREATED.equals(this.session.getState()))) {
      refreshStatusViaService();
    }
    for (;;)
    {
      return;
      if (this.session.isOpened()) {
        fetchVerifiedObjectId(new LikeActionController.8(this));
      }
    }
  }
  
  private void refreshStatusViaService()
  {
    LikeStatusClient localLikeStatusClient = new LikeStatusClient(applicationContext, Settings.getApplicationId(), this.objectId);
    if (!localLikeStatusClient.start()) {}
    for (;;)
    {
      return;
      localLikeStatusClient.setCompletedListener(new LikeActionController.9(this));
    }
  }
  
  private static void registerSessionBroadcastReceivers()
  {
    LocalBroadcastManager localLocalBroadcastManager = LocalBroadcastManager.getInstance(applicationContext);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.facebook.sdk.ACTIVE_SESSION_UNSET");
    localIntentFilter.addAction("com.facebook.sdk.ACTIVE_SESSION_CLOSED");
    localIntentFilter.addAction("com.facebook.sdk.ACTIVE_SESSION_OPENED");
    localLocalBroadcastManager.registerReceiver(new LikeActionController.4(), localIntentFilter);
  }
  
  private static void serializeToDiskAsync(LikeActionController paramLikeActionController)
  {
    String str1 = serializeToJson(paramLikeActionController);
    String str2 = getCacheKeyForObjectId(paramLikeActionController.objectId);
    if ((!Utility.isNullOrEmpty(str1)) && (!Utility.isNullOrEmpty(str2))) {
      diskIOWorkQueue.addActiveWorkItem(new LikeActionController.SerializeToDiskWorkItem(str2, str1));
    }
  }
  
  /* Error */
  private static void serializeToDiskSynchronously(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: getstatic 273	com/facebook/internal/LikeActionController:controllerDiskCache	Lcom/facebook/internal/FileLruCache;
    //   5: aload_0
    //   6: invokevirtual 772	com/facebook/internal/FileLruCache:openPutStream	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   9: astore 7
    //   11: aload 7
    //   13: astore_2
    //   14: aload_2
    //   15: aload_1
    //   16: invokevirtual 776	java/lang/String:getBytes	()[B
    //   19: invokevirtual 782	java/io/OutputStream:write	([B)V
    //   22: aload_2
    //   23: ifnull +7 -> 30
    //   26: aload_2
    //   27: invokestatic 390	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   30: return
    //   31: astore 6
    //   33: aload_2
    //   34: ifnull -4 -> 30
    //   37: aload_2
    //   38: invokestatic 390	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   41: goto -11 -> 30
    //   44: astore_3
    //   45: aconst_null
    //   46: astore 4
    //   48: aload_3
    //   49: astore 5
    //   51: aload 4
    //   53: ifnull +8 -> 61
    //   56: aload 4
    //   58: invokestatic 390	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   61: aload 5
    //   63: athrow
    //   64: astore 8
    //   66: aload_2
    //   67: astore 4
    //   69: aload 8
    //   71: astore 5
    //   73: goto -22 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	paramString1	String
    //   0	76	1	paramString2	String
    //   1	66	2	localObject1	Object
    //   44	5	3	localObject2	Object
    //   46	22	4	localObject3	Object
    //   49	23	5	localObject4	Object
    //   31	1	6	localIOException	java.io.IOException
    //   9	3	7	localOutputStream	java.io.OutputStream
    //   64	6	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	31	java/io/IOException
    //   14	22	31	java/io/IOException
    //   2	11	44	finally
    //   14	22	64	finally
  }
  
  private static String serializeToJson(LikeActionController paramLikeActionController)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("com.facebook.internal.LikeActionController.version", 2);
      localJSONObject1.put("object_id", paramLikeActionController.objectId);
      localJSONObject1.put("like_count_string_with_like", paramLikeActionController.likeCountStringWithLike);
      localJSONObject1.put("like_count_string_without_like", paramLikeActionController.likeCountStringWithoutLike);
      localJSONObject1.put("social_sentence_with_like", paramLikeActionController.socialSentenceWithLike);
      localJSONObject1.put("social_sentence_without_like", paramLikeActionController.socialSentenceWithoutLike);
      localJSONObject1.put("is_object_liked", paramLikeActionController.isObjectLiked);
      localJSONObject1.put("unlike_token", paramLikeActionController.unlikeToken);
      if (paramLikeActionController.pendingCallId != null) {
        localJSONObject1.put("pending_call_id", paramLikeActionController.pendingCallId.toString());
      }
      if (paramLikeActionController.pendingCallAnalyticsBundle != null)
      {
        JSONObject localJSONObject2 = BundleJSONConverter.convertToJSON(paramLikeActionController.pendingCallAnalyticsBundle);
        if (localJSONObject2 != null) {
          localJSONObject1.put("pending_call_analytics_bundle", localJSONObject2);
        }
      }
      str = localJSONObject1.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        String str = null;
      }
    }
    return str;
  }
  
  private void stopTrackingPendingCall()
  {
    PendingCallStore.getInstance().stopTrackingPendingCall(this.pendingCallId);
    this.pendingCallId = null;
    this.pendingCallAnalyticsBundle = null;
    storeObjectIdForPendingController(null);
  }
  
  private void storeObjectIdForPendingController(String paramString)
  {
    objectIdForPendingController = paramString;
    applicationContext.getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putString("PENDING_CONTROLLER_KEY", objectIdForPendingController).apply();
  }
  
  private void trackPendingCall(FacebookDialog.PendingCall paramPendingCall, Bundle paramBundle)
  {
    PendingCallStore.getInstance().trackPendingCall(paramPendingCall);
    this.pendingCallId = paramPendingCall.getCallId();
    storeObjectIdForPendingController(this.objectId);
    this.pendingCallAnalyticsBundle = paramBundle;
    serializeToDiskAsync(this);
  }
  
  private void updateLikeState(boolean paramBoolean)
  {
    updateState(paramBoolean, this.likeCountStringWithLike, this.likeCountStringWithoutLike, this.socialSentenceWithLike, this.socialSentenceWithoutLike, this.unlikeToken);
  }
  
  private void updateState(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    String str1 = Utility.coerceValueIfNullOrEmpty(paramString1, null);
    String str2 = Utility.coerceValueIfNullOrEmpty(paramString2, null);
    String str3 = Utility.coerceValueIfNullOrEmpty(paramString3, null);
    String str4 = Utility.coerceValueIfNullOrEmpty(paramString4, null);
    String str5 = Utility.coerceValueIfNullOrEmpty(paramString5, null);
    int i;
    if ((paramBoolean != this.isObjectLiked) || (!Utility.areObjectsEqual(str1, this.likeCountStringWithLike)) || (!Utility.areObjectsEqual(str2, this.likeCountStringWithoutLike)) || (!Utility.areObjectsEqual(str3, this.socialSentenceWithLike)) || (!Utility.areObjectsEqual(str4, this.socialSentenceWithoutLike)) || (!Utility.areObjectsEqual(str5, this.unlikeToken)))
    {
      i = 1;
      if (i != 0) {
        break label121;
      }
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label121:
      this.isObjectLiked = paramBoolean;
      this.likeCountStringWithLike = str1;
      this.likeCountStringWithoutLike = str2;
      this.socialSentenceWithLike = str3;
      this.socialSentenceWithoutLike = str4;
      this.unlikeToken = str5;
      serializeToDiskAsync(this);
      broadcastAction(this, "com.facebook.sdk.LikeActionController.UPDATED");
    }
  }
  
  public String getLikeCountString()
  {
    if (this.isObjectLiked) {}
    for (String str = this.likeCountStringWithLike;; str = this.likeCountStringWithoutLike) {
      return str;
    }
  }
  
  public String getObjectId()
  {
    return this.objectId;
  }
  
  public String getSocialSentence()
  {
    if (this.isObjectLiked) {}
    for (String str = this.socialSentenceWithLike;; str = this.socialSentenceWithoutLike) {
      return str;
    }
  }
  
  public boolean isObjectLiked()
  {
    return this.isObjectLiked;
  }
  
  public void toggleLike(Activity paramActivity, Fragment paramFragment, Bundle paramBundle)
  {
    boolean bool1 = true;
    this.appEventsLogger.logSdkEvent("fb_like_control_did_tap", null, paramBundle);
    boolean bool2;
    if (!this.isObjectLiked)
    {
      bool2 = bool1;
      if (!canUseOGPublish()) {
        break label102;
      }
      updateLikeState(bool2);
      if (!this.isPendingLikeOrUnlike) {
        break label65;
      }
      this.appEventsLogger.logSdkEvent("fb_like_control_did_undo_quickly", null, paramBundle);
    }
    for (;;)
    {
      return;
      bool2 = false;
      break;
      label65:
      if (!publishLikeOrUnlikeAsync(bool2, paramBundle))
      {
        if (!bool2) {}
        for (;;)
        {
          updateLikeState(bool1);
          presentLikeDialog(paramActivity, paramFragment, paramBundle);
          break;
          bool1 = false;
        }
        label102:
        presentLikeDialog(paramActivity, paramFragment, paramBundle);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.LikeActionController
 * JD-Core Version:    0.7.0.1
 */