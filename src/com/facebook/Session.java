package com.facebook;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.facebook.internal.SessionAuthorizationType;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphMultiResult;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

public class Session
  implements Serializable
{
  public static final String ACTION_ACTIVE_SESSION_CLOSED = "com.facebook.sdk.ACTIVE_SESSION_CLOSED";
  public static final String ACTION_ACTIVE_SESSION_OPENED = "com.facebook.sdk.ACTIVE_SESSION_OPENED";
  public static final String ACTION_ACTIVE_SESSION_SET = "com.facebook.sdk.ACTIVE_SESSION_SET";
  public static final String ACTION_ACTIVE_SESSION_UNSET = "com.facebook.sdk.ACTIVE_SESSION_UNSET";
  private static final String AUTH_BUNDLE_SAVE_KEY = "com.facebook.sdk.Session.authBundleKey";
  public static final int DEFAULT_AUTHORIZE_ACTIVITY_CODE = 64206;
  private static final String MANAGE_PERMISSION_PREFIX = "manage";
  private static final Set<String> OTHER_PUBLISH_PERMISSIONS = new Session.1();
  private static final String PUBLISH_PERMISSION_PREFIX = "publish";
  private static final String SESSION_BUNDLE_SAVE_KEY = "com.facebook.sdk.Session.saveSessionKey";
  private static final Object STATIC_LOCK;
  public static final String TAG = Session.class.getCanonicalName();
  private static final int TOKEN_EXTEND_RETRY_SECONDS = 3600;
  private static final int TOKEN_EXTEND_THRESHOLD_SECONDS = 86400;
  public static final String WEB_VIEW_ERROR_CODE_KEY = "com.facebook.sdk.WebViewErrorCode";
  public static final String WEB_VIEW_FAILING_URL_KEY = "com.facebook.sdk.FailingUrl";
  private static Session activeSession;
  private static final long serialVersionUID = 1L;
  private static volatile Context staticContext;
  private AppEventsLogger appEventsLogger;
  private String applicationId;
  private volatile Bundle authorizationBundle;
  private AuthorizationClient authorizationClient;
  private final List<Session.StatusCallback> callbacks;
  private volatile Session.TokenRefreshRequest currentTokenRefreshRequest;
  private Handler handler;
  private Date lastAttemptedTokenExtendDate = new Date(0L);
  private final Object lock = new Object();
  private Session.AuthorizationRequest pendingAuthorizationRequest;
  private SessionState state;
  private TokenCachingStrategy tokenCachingStrategy;
  private AccessToken tokenInfo;
  
  static
  {
    STATIC_LOCK = new Object();
  }
  
  public Session(Context paramContext)
  {
    this(paramContext, null, null, true);
  }
  
  Session(Context paramContext, String paramString, TokenCachingStrategy paramTokenCachingStrategy)
  {
    this(paramContext, paramString, paramTokenCachingStrategy, true);
  }
  
  Session(Context paramContext, String paramString, TokenCachingStrategy paramTokenCachingStrategy, boolean paramBoolean)
  {
    if ((paramContext != null) && (paramString == null)) {
      paramString = Utility.getMetadataApplicationId(paramContext);
    }
    Validate.notNull(paramString, "applicationId");
    initializeStaticContext(paramContext);
    if (paramTokenCachingStrategy == null) {
      paramTokenCachingStrategy = new SharedPreferencesTokenCachingStrategy(staticContext);
    }
    this.applicationId = paramString;
    this.tokenCachingStrategy = paramTokenCachingStrategy;
    this.state = SessionState.CREATED;
    this.pendingAuthorizationRequest = null;
    this.callbacks = new ArrayList();
    this.handler = new Handler(Looper.getMainLooper());
    if (paramBoolean) {
      localBundle = paramTokenCachingStrategy.load();
    }
    if (TokenCachingStrategy.hasTokenInformation(localBundle))
    {
      Date localDate1 = TokenCachingStrategy.getDate(localBundle, "com.facebook.TokenCachingStrategy.ExpirationDate");
      Date localDate2 = new Date();
      if ((localDate1 == null) || (localDate1.before(localDate2)))
      {
        paramTokenCachingStrategy.clear();
        this.tokenInfo = AccessToken.createEmptyToken();
      }
    }
    for (;;)
    {
      return;
      this.tokenInfo = AccessToken.createFromCache(localBundle);
      this.state = SessionState.CREATED_TOKEN_LOADED;
      continue;
      this.tokenInfo = AccessToken.createEmptyToken();
    }
  }
  
  private Session(String paramString, SessionState paramSessionState, AccessToken paramAccessToken, Date paramDate, boolean paramBoolean, Session.AuthorizationRequest paramAuthorizationRequest)
  {
    this.applicationId = paramString;
    this.state = paramSessionState;
    this.tokenInfo = paramAccessToken;
    this.lastAttemptedTokenExtendDate = paramDate;
    this.pendingAuthorizationRequest = paramAuthorizationRequest;
    this.handler = new Handler(Looper.getMainLooper());
    this.currentTokenRefreshRequest = null;
    this.tokenCachingStrategy = null;
    this.callbacks = new ArrayList();
  }
  
  private Session(String paramString, SessionState paramSessionState, AccessToken paramAccessToken, Date paramDate, boolean paramBoolean, Session.AuthorizationRequest paramAuthorizationRequest, Set<String> paramSet)
  {
    this.applicationId = paramString;
    this.state = paramSessionState;
    this.tokenInfo = paramAccessToken;
    this.lastAttemptedTokenExtendDate = paramDate;
    this.pendingAuthorizationRequest = paramAuthorizationRequest;
    this.handler = new Handler(Looper.getMainLooper());
    this.currentTokenRefreshRequest = null;
    this.tokenCachingStrategy = null;
    this.callbacks = new ArrayList();
  }
  
  private static boolean areEqual(Object paramObject1, Object paramObject2)
  {
    boolean bool;
    if (paramObject1 == null) {
      if (paramObject2 == null) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      bool = paramObject1.equals(paramObject2);
    }
  }
  
  private void finishAuthorization(AccessToken paramAccessToken, Exception paramException)
  {
    SessionState localSessionState = this.state;
    if (paramAccessToken != null)
    {
      this.tokenInfo = paramAccessToken;
      saveTokenToCache(paramAccessToken);
      this.state = SessionState.OPENED;
    }
    for (;;)
    {
      this.pendingAuthorizationRequest = null;
      postStateChange(localSessionState, this.state, paramException);
      return;
      if (paramException != null) {
        this.state = SessionState.CLOSED_LOGIN_FAILED;
      }
    }
  }
  
  private void finishReauthorization(AccessToken paramAccessToken, Exception paramException)
  {
    SessionState localSessionState = this.state;
    if (paramAccessToken != null)
    {
      this.tokenInfo = paramAccessToken;
      saveTokenToCache(paramAccessToken);
      this.state = SessionState.OPENED_TOKEN_UPDATED;
    }
    this.pendingAuthorizationRequest = null;
    postStateChange(localSessionState, this.state, paramException);
  }
  
  public static final Session getActiveSession()
  {
    synchronized (STATIC_LOCK)
    {
      Session localSession = activeSession;
      return localSession;
    }
  }
  
  private AppEventsLogger getAppEventsLogger()
  {
    synchronized (this.lock)
    {
      if (this.appEventsLogger == null) {
        this.appEventsLogger = AppEventsLogger.newLogger(staticContext, this.applicationId);
      }
      AppEventsLogger localAppEventsLogger = this.appEventsLogger;
      return localAppEventsLogger;
    }
  }
  
  private Intent getLoginActivityIntent(Session.AuthorizationRequest paramAuthorizationRequest)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(getStaticContext(), LoginActivity.class);
    localIntent.setAction(paramAuthorizationRequest.getLoginBehavior().toString());
    localIntent.putExtras(LoginActivity.populateIntentExtras(paramAuthorizationRequest.getAuthorizationClientRequest()));
    return localIntent;
  }
  
  static Context getStaticContext()
  {
    return staticContext;
  }
  
  private void handleAuthorizationResult(int paramInt, AuthorizationClient.Result paramResult)
  {
    AccessToken localAccessToken;
    Object localObject;
    if (paramInt == -1) {
      if (paramResult.code == AuthorizationClient.Result.Code.SUCCESS)
      {
        localAccessToken = paramResult.token;
        localObject = null;
      }
    }
    for (;;)
    {
      logAuthorizationComplete(paramResult.code, paramResult.loggingExtras, (Exception)localObject);
      this.authorizationClient = null;
      finishAuthOrReauth(localAccessToken, (Exception)localObject);
      return;
      localObject = new FacebookAuthorizationException(paramResult.errorMessage);
      localAccessToken = null;
      continue;
      if (paramInt == 0)
      {
        localObject = new FacebookOperationCanceledException(paramResult.errorMessage);
        localAccessToken = null;
      }
      else
      {
        localObject = null;
        localAccessToken = null;
      }
    }
  }
  
  static Session.PermissionsPair handlePermissionResponse(Response paramResponse)
  {
    Session.PermissionsPair localPermissionsPair;
    if (paramResponse.getError() != null) {
      localPermissionsPair = null;
    }
    for (;;)
    {
      return localPermissionsPair;
      GraphMultiResult localGraphMultiResult = (GraphMultiResult)paramResponse.getGraphObjectAs(GraphMultiResult.class);
      if (localGraphMultiResult == null)
      {
        localPermissionsPair = null;
      }
      else
      {
        GraphObjectList localGraphObjectList = localGraphMultiResult.getData();
        if ((localGraphObjectList == null) || (localGraphObjectList.size() == 0))
        {
          localPermissionsPair = null;
        }
        else
        {
          ArrayList localArrayList1 = new ArrayList(localGraphObjectList.size());
          ArrayList localArrayList2 = new ArrayList(localGraphObjectList.size());
          GraphObject localGraphObject1 = (GraphObject)localGraphObjectList.get(0);
          if (localGraphObject1.getProperty("permission") != null)
          {
            Iterator localIterator2 = localGraphObjectList.iterator();
            while (localIterator2.hasNext())
            {
              GraphObject localGraphObject2 = (GraphObject)localIterator2.next();
              String str1 = (String)localGraphObject2.getProperty("permission");
              if (!str1.equals("installed"))
              {
                String str2 = (String)localGraphObject2.getProperty("status");
                if (str2.equals("granted")) {
                  localArrayList1.add(str1);
                } else if (str2.equals("declined")) {
                  localArrayList2.add(str1);
                }
              }
            }
          }
          Iterator localIterator1 = localGraphObject1.asMap().entrySet().iterator();
          while (localIterator1.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator1.next();
            if ((!((String)localEntry.getKey()).equals("installed")) && (((Integer)localEntry.getValue()).intValue() == 1)) {
              localArrayList1.add(localEntry.getKey());
            }
          }
          localPermissionsPair = new Session.PermissionsPair(localArrayList1, localArrayList2);
        }
      }
    }
  }
  
  static void initializeStaticContext(Context paramContext)
  {
    if ((paramContext != null) && (staticContext == null))
    {
      Context localContext = paramContext.getApplicationContext();
      if (localContext != null) {
        paramContext = localContext;
      }
      staticContext = paramContext;
    }
  }
  
  public static boolean isPublishPermission(String paramString)
  {
    if ((paramString != null) && ((paramString.startsWith("publish")) || (paramString.startsWith("manage")) || (OTHER_PUBLISH_PERMISSIONS.contains(paramString)))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void logAuthorizationComplete(AuthorizationClient.Result.Code paramCode, Map<String, String> paramMap, Exception paramException)
  {
    Object localObject2;
    if (this.pendingAuthorizationRequest == null)
    {
      localObject2 = AuthorizationClient.newAuthorizationLoggingBundle("");
      ((Bundle)localObject2).putString("2_result", AuthorizationClient.Result.Code.ERROR.getLoggingValue());
      ((Bundle)localObject2).putString("5_error_message", "Unexpected call to logAuthorizationComplete with null pendingAuthorizationRequest.");
      ((Bundle)localObject2).putLong("1_timestamp_ms", System.currentTimeMillis());
      getAppEventsLogger().logSdkEvent("fb_mobile_login_complete", null, (Bundle)localObject2);
      return;
    }
    Bundle localBundle = AuthorizationClient.newAuthorizationLoggingBundle(this.pendingAuthorizationRequest.getAuthId());
    if (paramCode != null) {
      localBundle.putString("2_result", paramCode.getLoggingValue());
    }
    if ((paramException != null) && (paramException.getMessage() != null)) {
      localBundle.putString("5_error_message", paramException.getMessage());
    }
    if (!Session.AuthorizationRequest.access$500(this.pendingAuthorizationRequest).isEmpty()) {}
    for (Object localObject1 = new JSONObject(Session.AuthorizationRequest.access$500(this.pendingAuthorizationRequest));; localObject1 = null)
    {
      if (paramMap != null) {
        if (localObject1 != null) {
          break label264;
        }
      }
      label264:
      for (Object localObject3 = new JSONObject();; localObject3 = localObject1)
      {
        try
        {
          Iterator localIterator = paramMap.entrySet().iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)localIterator.next();
              ((JSONObject)localObject3).put((String)localEntry.getKey(), localEntry.getValue());
              continue;
              if (localObject1 == null) {
                break;
              }
            }
          }
        }
        catch (JSONException localJSONException)
        {
          localObject1 = localObject3;
        }
        for (;;)
        {
          localBundle.putString("6_extras", ((JSONObject)localObject1).toString());
          localObject2 = localBundle;
          break;
          localObject1 = localObject3;
        }
      }
    }
  }
  
  private void logAuthorizationStart()
  {
    Bundle localBundle = AuthorizationClient.newAuthorizationLoggingBundle(this.pendingAuthorizationRequest.getAuthId());
    localBundle.putLong("1_timestamp_ms", System.currentTimeMillis());
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("login_behavior", Session.AuthorizationRequest.access$700(this.pendingAuthorizationRequest).toString());
      localJSONObject.put("request_code", Session.AuthorizationRequest.access$800(this.pendingAuthorizationRequest));
      localJSONObject.put("is_legacy", Session.AuthorizationRequest.access$600(this.pendingAuthorizationRequest));
      localJSONObject.put("permissions", TextUtils.join(",", Session.AuthorizationRequest.access$900(this.pendingAuthorizationRequest)));
      localJSONObject.put("default_audience", Session.AuthorizationRequest.access$1000(this.pendingAuthorizationRequest).toString());
      localBundle.putString("6_extras", localJSONObject.toString());
      label127:
      getAppEventsLogger().logSdkEvent("fb_mobile_login_start", null, localBundle);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label127;
    }
  }
  
  /* Error */
  private void open(Session.OpenRequest paramOpenRequest, SessionAuthorizationType paramSessionAuthorizationType)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: invokespecial 612	com/facebook/Session:validatePermissions	(Lcom/facebook/Session$AuthorizationRequest;Lcom/facebook/internal/SessionAuthorizationType;)V
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial 616	com/facebook/Session:validateLoginBehavior	(Lcom/facebook/Session$AuthorizationRequest;)V
    //   11: aload_0
    //   12: getfield 117	com/facebook/Session:lock	Ljava/lang/Object;
    //   15: astore_3
    //   16: aload_3
    //   17: monitorenter
    //   18: aload_0
    //   19: getfield 152	com/facebook/Session:pendingAuthorizationRequest	Lcom/facebook/Session$AuthorizationRequest;
    //   22: ifnull +30 -> 52
    //   25: aload_0
    //   26: aload_0
    //   27: getfield 150	com/facebook/Session:state	Lcom/facebook/SessionState;
    //   30: aload_0
    //   31: getfield 150	com/facebook/Session:state	Lcom/facebook/SessionState;
    //   34: new 618	java/lang/UnsupportedOperationException
    //   37: dup
    //   38: ldc_w 620
    //   41: invokespecial 621	java/lang/UnsupportedOperationException:<init>	(Ljava/lang/String;)V
    //   44: invokevirtual 267	com/facebook/Session:postStateChange	(Lcom/facebook/SessionState;Lcom/facebook/SessionState;Ljava/lang/Exception;)V
    //   47: aload_3
    //   48: monitorexit
    //   49: goto +203 -> 252
    //   52: aload_0
    //   53: getfield 150	com/facebook/Session:state	Lcom/facebook/SessionState;
    //   56: astore 5
    //   58: getstatic 627	com/facebook/Session$5:$SwitchMap$com$facebook$SessionState	[I
    //   61: aload_0
    //   62: getfield 150	com/facebook/Session:state	Lcom/facebook/SessionState;
    //   65: invokevirtual 630	com/facebook/SessionState:ordinal	()I
    //   68: iaload
    //   69: tableswitch	default:+27 -> 96, 1:+45->114, 2:+27->96, 3:+115->184
    //   97: iconst_m1
    //   98: fmul
    //   99: dup
    //   100: ldc_w 632
    //   103: invokespecial 621	java/lang/UnsupportedOperationException:<init>	(Ljava/lang/String;)V
    //   106: athrow
    //   107: astore 4
    //   109: aload_3
    //   110: monitorexit
    //   111: aload 4
    //   113: athrow
    //   114: getstatic 635	com/facebook/SessionState:OPENING	Lcom/facebook/SessionState;
    //   117: astore 6
    //   119: aload_0
    //   120: aload 6
    //   122: putfield 150	com/facebook/Session:state	Lcom/facebook/SessionState;
    //   125: aload_1
    //   126: ifnonnull +14 -> 140
    //   129: new 637	java/lang/IllegalArgumentException
    //   132: dup
    //   133: ldc_w 639
    //   136: invokespecial 640	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   139: athrow
    //   140: aload_0
    //   141: aload_1
    //   142: putfield 152	com/facebook/Session:pendingAuthorizationRequest	Lcom/facebook/Session$AuthorizationRequest;
    //   145: aload_1
    //   146: ifnull +11 -> 157
    //   149: aload_0
    //   150: aload_1
    //   151: invokevirtual 646	com/facebook/Session$OpenRequest:getCallback	()Lcom/facebook/Session$StatusCallback;
    //   154: invokevirtual 650	com/facebook/Session:addCallback	(Lcom/facebook/Session$StatusCallback;)V
    //   157: aload_0
    //   158: aload 5
    //   160: aload 6
    //   162: aconst_null
    //   163: invokevirtual 267	com/facebook/Session:postStateChange	(Lcom/facebook/SessionState;Lcom/facebook/SessionState;Ljava/lang/Exception;)V
    //   166: aload_3
    //   167: monitorexit
    //   168: aload 6
    //   170: getstatic 635	com/facebook/SessionState:OPENING	Lcom/facebook/SessionState;
    //   173: if_acmpne +79 -> 252
    //   176: aload_0
    //   177: aload_1
    //   178: invokevirtual 653	com/facebook/Session:authorize	(Lcom/facebook/Session$AuthorizationRequest;)V
    //   181: goto +71 -> 252
    //   184: aload_1
    //   185: ifnull +32 -> 217
    //   188: aload_1
    //   189: invokevirtual 657	com/facebook/Session$OpenRequest:getPermissions	()Ljava/util/List;
    //   192: invokestatic 661	com/facebook/internal/Utility:isNullOrEmpty	(Ljava/util/Collection;)Z
    //   195: ifne +22 -> 217
    //   198: aload_1
    //   199: invokevirtual 657	com/facebook/Session$OpenRequest:getPermissions	()Ljava/util/List;
    //   202: aload_0
    //   203: invokevirtual 662	com/facebook/Session:getPermissions	()Ljava/util/List;
    //   206: invokestatic 666	com/facebook/internal/Utility:isSubset	(Ljava/util/Collection;Ljava/util/Collection;)Z
    //   209: ifne +8 -> 217
    //   212: aload_0
    //   213: aload_1
    //   214: putfield 152	com/facebook/Session:pendingAuthorizationRequest	Lcom/facebook/Session$AuthorizationRequest;
    //   217: aload_0
    //   218: getfield 152	com/facebook/Session:pendingAuthorizationRequest	Lcom/facebook/Session$AuthorizationRequest;
    //   221: ifnonnull +17 -> 238
    //   224: getstatic 263	com/facebook/SessionState:OPENED	Lcom/facebook/SessionState;
    //   227: astore 6
    //   229: aload_0
    //   230: aload 6
    //   232: putfield 150	com/facebook/Session:state	Lcom/facebook/SessionState;
    //   235: goto -90 -> 145
    //   238: getstatic 635	com/facebook/SessionState:OPENING	Lcom/facebook/SessionState;
    //   241: astore 6
    //   243: aload_0
    //   244: aload 6
    //   246: putfield 150	com/facebook/Session:state	Lcom/facebook/SessionState;
    //   249: goto -104 -> 145
    //   252: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	Session
    //   0	253	1	paramOpenRequest	Session.OpenRequest
    //   0	253	2	paramSessionAuthorizationType	SessionAuthorizationType
    //   15	152	3	localObject1	Object
    //   107	5	4	localObject2	Object
    //   56	103	5	localSessionState1	SessionState
    //   117	128	6	localSessionState2	SessionState
    // Exception table:
    //   from	to	target	type
    //   18	111	107	finally
    //   114	168	107	finally
    //   188	249	107	finally
  }
  
  public static Session openActiveSession(Activity paramActivity, boolean paramBoolean, Session.StatusCallback paramStatusCallback)
  {
    return openActiveSession(paramActivity, paramBoolean, new Session.OpenRequest(paramActivity).setCallback(paramStatusCallback));
  }
  
  public static Session openActiveSession(Activity paramActivity, boolean paramBoolean, List<String> paramList, Session.StatusCallback paramStatusCallback)
  {
    return openActiveSession(paramActivity, paramBoolean, new Session.OpenRequest(paramActivity).setCallback(paramStatusCallback).setPermissions(paramList));
  }
  
  public static Session openActiveSession(Context paramContext, Fragment paramFragment, boolean paramBoolean, Session.StatusCallback paramStatusCallback)
  {
    return openActiveSession(paramContext, paramBoolean, new Session.OpenRequest(paramFragment).setCallback(paramStatusCallback));
  }
  
  public static Session openActiveSession(Context paramContext, Fragment paramFragment, boolean paramBoolean, List<String> paramList, Session.StatusCallback paramStatusCallback)
  {
    return openActiveSession(paramContext, paramBoolean, new Session.OpenRequest(paramFragment).setCallback(paramStatusCallback).setPermissions(paramList));
  }
  
  private static Session openActiveSession(Context paramContext, boolean paramBoolean, Session.OpenRequest paramOpenRequest)
  {
    Session localSession = new Session.Builder(paramContext).build();
    if ((SessionState.CREATED_TOKEN_LOADED.equals(localSession.getState())) || (paramBoolean))
    {
      setActiveSession(localSession);
      localSession.openForRead(paramOpenRequest);
    }
    for (;;)
    {
      return localSession;
      localSession = null;
    }
  }
  
  public static Session openActiveSessionFromCache(Context paramContext)
  {
    return openActiveSession(paramContext, false, null);
  }
  
  public static Session openActiveSessionWithAccessToken(Context paramContext, AccessToken paramAccessToken, Session.StatusCallback paramStatusCallback)
  {
    Session localSession = new Session(paramContext, null, null, false);
    setActiveSession(localSession);
    localSession.open(paramAccessToken, paramStatusCallback);
    return localSession;
  }
  
  static void postActiveSessionAction(String paramString)
  {
    Intent localIntent = new Intent(paramString);
    LocalBroadcastManager.getInstance(getStaticContext()).sendBroadcast(localIntent);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    throw new InvalidObjectException("Cannot readObject, serialization proxy required");
  }
  
  /* Error */
  private void requestNewPermissions(Session.NewPermissionsRequest paramNewPermissionsRequest, SessionAuthorizationType paramSessionAuthorizationType)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: invokespecial 612	com/facebook/Session:validatePermissions	(Lcom/facebook/Session$AuthorizationRequest;Lcom/facebook/internal/SessionAuthorizationType;)V
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial 616	com/facebook/Session:validateLoginBehavior	(Lcom/facebook/Session$AuthorizationRequest;)V
    //   11: aload_1
    //   12: ifnull +73 -> 85
    //   15: aload_0
    //   16: getfield 117	com/facebook/Session:lock	Ljava/lang/Object;
    //   19: astore_3
    //   20: aload_3
    //   21: monitorenter
    //   22: aload_0
    //   23: getfield 152	com/facebook/Session:pendingAuthorizationRequest	Lcom/facebook/Session$AuthorizationRequest;
    //   26: ifnull +21 -> 47
    //   29: new 618	java/lang/UnsupportedOperationException
    //   32: dup
    //   33: ldc_w 737
    //   36: invokespecial 621	java/lang/UnsupportedOperationException:<init>	(Ljava/lang/String;)V
    //   39: athrow
    //   40: astore 4
    //   42: aload_3
    //   43: monitorexit
    //   44: aload 4
    //   46: athrow
    //   47: aload_0
    //   48: getfield 150	com/facebook/Session:state	Lcom/facebook/SessionState;
    //   51: invokevirtual 740	com/facebook/SessionState:isOpened	()Z
    //   54: ifeq +32 -> 86
    //   57: aload_0
    //   58: aload_1
    //   59: putfield 152	com/facebook/Session:pendingAuthorizationRequest	Lcom/facebook/Session$AuthorizationRequest;
    //   62: aload_3
    //   63: monitorexit
    //   64: aload_1
    //   65: aload_0
    //   66: invokevirtual 743	com/facebook/Session:getAccessToken	()Ljava/lang/String;
    //   69: invokevirtual 748	com/facebook/Session$NewPermissionsRequest:setValidateSameFbidAsToken	(Ljava/lang/String;)V
    //   72: aload_0
    //   73: aload_1
    //   74: invokevirtual 749	com/facebook/Session$NewPermissionsRequest:getCallback	()Lcom/facebook/Session$StatusCallback;
    //   77: invokevirtual 650	com/facebook/Session:addCallback	(Lcom/facebook/Session$StatusCallback;)V
    //   80: aload_0
    //   81: aload_1
    //   82: invokevirtual 653	com/facebook/Session:authorize	(Lcom/facebook/Session$AuthorizationRequest;)V
    //   85: return
    //   86: aload_0
    //   87: getfield 150	com/facebook/Session:state	Lcom/facebook/SessionState;
    //   90: invokevirtual 752	com/facebook/SessionState:isClosed	()Z
    //   93: ifeq +14 -> 107
    //   96: new 618	java/lang/UnsupportedOperationException
    //   99: dup
    //   100: ldc_w 754
    //   103: invokespecial 621	java/lang/UnsupportedOperationException:<init>	(Ljava/lang/String;)V
    //   106: athrow
    //   107: new 618	java/lang/UnsupportedOperationException
    //   110: dup
    //   111: ldc_w 756
    //   114: invokespecial 621	java/lang/UnsupportedOperationException:<init>	(Ljava/lang/String;)V
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	Session
    //   0	118	1	paramNewPermissionsRequest	Session.NewPermissionsRequest
    //   0	118	2	paramSessionAuthorizationType	SessionAuthorizationType
    //   19	44	3	localObject1	Object
    //   40	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   22	44	40	finally
    //   47	64	40	finally
    //   86	118	40	finally
  }
  
  private boolean resolveIntent(Intent paramIntent)
  {
    boolean bool = false;
    if (getStaticContext().getPackageManager().resolveActivity(paramIntent, 0) == null) {}
    for (;;)
    {
      return bool;
      bool = true;
    }
  }
  
  public static final Session restoreSession(Context paramContext, TokenCachingStrategy paramTokenCachingStrategy, Session.StatusCallback paramStatusCallback, Bundle paramBundle)
  {
    Session localSession;
    if (paramBundle == null) {
      localSession = null;
    }
    for (;;)
    {
      return localSession;
      byte[] arrayOfByte = paramBundle.getByteArray("com.facebook.sdk.Session.saveSessionKey");
      if (arrayOfByte != null)
      {
        ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
        try
        {
          localSession = (Session)new ObjectInputStream(localByteArrayInputStream).readObject();
          initializeStaticContext(paramContext);
          if (paramTokenCachingStrategy != null) {}
          for (localSession.tokenCachingStrategy = paramTokenCachingStrategy;; localSession.tokenCachingStrategy = new SharedPreferencesTokenCachingStrategy(paramContext))
          {
            if (paramStatusCallback != null) {
              localSession.addCallback(paramStatusCallback);
            }
            localSession.authorizationBundle = paramBundle.getBundle("com.facebook.sdk.Session.authBundleKey");
            break;
          }
          localSession = null;
        }
        catch (IOException localIOException) {}catch (ClassNotFoundException localClassNotFoundException) {}
      }
    }
  }
  
  private static void runWithHandlerOrExecutor(Handler paramHandler, Runnable paramRunnable)
  {
    if (paramHandler != null) {
      paramHandler.post(paramRunnable);
    }
    for (;;)
    {
      return;
      Settings.getExecutor().execute(paramRunnable);
    }
  }
  
  public static final void saveSession(Session paramSession, Bundle paramBundle)
  {
    ByteArrayOutputStream localByteArrayOutputStream;
    if ((paramBundle != null) && (paramSession != null) && (!paramBundle.containsKey("com.facebook.sdk.Session.saveSessionKey"))) {
      localByteArrayOutputStream = new ByteArrayOutputStream();
    }
    try
    {
      new ObjectOutputStream(localByteArrayOutputStream).writeObject(paramSession);
      paramBundle.putByteArray("com.facebook.sdk.Session.saveSessionKey", localByteArrayOutputStream.toByteArray());
      paramBundle.putBundle("com.facebook.sdk.Session.authBundleKey", paramSession.authorizationBundle);
      return;
    }
    catch (IOException localIOException)
    {
      throw new FacebookException("Unable to save session.", localIOException);
    }
  }
  
  private void saveTokenToCache(AccessToken paramAccessToken)
  {
    if ((paramAccessToken != null) && (this.tokenCachingStrategy != null)) {
      this.tokenCachingStrategy.save(paramAccessToken.toCacheBundle());
    }
  }
  
  public static final void setActiveSession(Session paramSession)
  {
    synchronized (STATIC_LOCK)
    {
      if (paramSession != activeSession)
      {
        Session localSession = activeSession;
        if (localSession != null) {
          localSession.close();
        }
        activeSession = paramSession;
        if (localSession != null) {
          postActiveSessionAction("com.facebook.sdk.ACTIVE_SESSION_UNSET");
        }
        if (paramSession != null)
        {
          postActiveSessionAction("com.facebook.sdk.ACTIVE_SESSION_SET");
          if (paramSession.isOpened()) {
            postActiveSessionAction("com.facebook.sdk.ACTIVE_SESSION_OPENED");
          }
        }
      }
      return;
    }
  }
  
  private void tryLegacyAuth(Session.AuthorizationRequest paramAuthorizationRequest)
  {
    this.authorizationClient = new AuthorizationClient();
    this.authorizationClient.setOnCompletedListener(new Session.3(this));
    this.authorizationClient.setContext(getStaticContext());
    this.authorizationClient.startOrContinueAuth(paramAuthorizationRequest.getAuthorizationClientRequest());
  }
  
  private boolean tryLoginActivity(Session.AuthorizationRequest paramAuthorizationRequest)
  {
    boolean bool = false;
    Intent localIntent = getLoginActivityIntent(paramAuthorizationRequest);
    if (!resolveIntent(localIntent)) {}
    for (;;)
    {
      return bool;
      try
      {
        paramAuthorizationRequest.getStartActivityDelegate().startActivityForResult(localIntent, paramAuthorizationRequest.getRequestCode());
        bool = true;
      }
      catch (ActivityNotFoundException localActivityNotFoundException) {}
    }
  }
  
  private void validateLoginBehavior(Session.AuthorizationRequest paramAuthorizationRequest)
  {
    if ((paramAuthorizationRequest != null) && (!Session.AuthorizationRequest.access$600(paramAuthorizationRequest)))
    {
      Intent localIntent = new Intent();
      localIntent.setClass(getStaticContext(), LoginActivity.class);
      if (!resolveIntent(localIntent))
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramAuthorizationRequest.getLoginBehavior();
        arrayOfObject[1] = LoginActivity.class.getName();
        throw new FacebookException(String.format("Cannot use SessionLoginBehavior %s when %s is not declared as an activity in AndroidManifest.xml", arrayOfObject));
      }
    }
  }
  
  private void validatePermissions(Session.AuthorizationRequest paramAuthorizationRequest, SessionAuthorizationType paramSessionAuthorizationType)
  {
    if ((paramAuthorizationRequest == null) || (Utility.isNullOrEmpty(paramAuthorizationRequest.getPermissions())))
    {
      if (SessionAuthorizationType.PUBLISH.equals(paramSessionAuthorizationType)) {
        throw new FacebookException("Cannot request publish or manage authorization with no permissions.");
      }
    }
    else
    {
      Iterator localIterator = paramAuthorizationRequest.getPermissions().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (isPublishPermission(str))
        {
          if (SessionAuthorizationType.READ.equals(paramSessionAuthorizationType))
          {
            Object[] arrayOfObject2 = new Object[1];
            arrayOfObject2[0] = str;
            throw new FacebookException(String.format("Cannot pass a publish or manage permission (%s) to a request for read authorization", arrayOfObject2));
          }
        }
        else if (SessionAuthorizationType.PUBLISH.equals(paramSessionAuthorizationType))
        {
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = str;
          String.format("Should not pass a read permission (%s) to a request for publish or manage authorization", arrayOfObject1);
        }
      }
    }
  }
  
  private Object writeReplace()
  {
    return new Session.SerializationProxyV1(this.applicationId, this.state, this.tokenInfo, this.lastAttemptedTokenExtendDate, false, this.pendingAuthorizationRequest);
  }
  
  public final void addCallback(Session.StatusCallback paramStatusCallback)
  {
    List localList = this.callbacks;
    if (paramStatusCallback != null) {}
    try
    {
      if (!this.callbacks.contains(paramStatusCallback)) {
        this.callbacks.add(paramStatusCallback);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void authorize(Session.AuthorizationRequest paramAuthorizationRequest)
  {
    paramAuthorizationRequest.setApplicationId(this.applicationId);
    logAuthorizationStart();
    boolean bool = tryLoginActivity(paramAuthorizationRequest);
    Map localMap = Session.AuthorizationRequest.access$500(this.pendingAuthorizationRequest);
    String str;
    if (bool)
    {
      str = "1";
      label35:
      localMap.put("try_login_activity", str);
      if ((bool) || (!Session.AuthorizationRequest.access$600(paramAuthorizationRequest))) {
        break label207;
      }
      Session.AuthorizationRequest.access$500(this.pendingAuthorizationRequest).put("try_legacy", "1");
      tryLegacyAuth(paramAuthorizationRequest);
    }
    label207:
    for (int i = 1;; i = bool) {
      for (;;)
      {
        if (i == 0) {}
        synchronized (this.lock)
        {
          SessionState localSessionState = this.state;
          switch (Session.5.$SwitchMap$com$facebook$SessionState[this.state.ordinal()])
          {
          default: 
            this.state = SessionState.CLOSED_LOGIN_FAILED;
            FacebookException localFacebookException = new FacebookException("Log in attempt failed: LoginActivity could not be started, and not legacy request");
            logAuthorizationComplete(AuthorizationClient.Result.Code.ERROR, null, localFacebookException);
            postStateChange(localSessionState, this.state, localFacebookException);
            return;
            str = "0";
            break label35;
          }
        }
      }
    }
  }
  
  /* Error */
  public final void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 117	com/facebook/Session:lock	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 150	com/facebook/Session:state	Lcom/facebook/SessionState;
    //   11: astore_3
    //   12: getstatic 627	com/facebook/Session$5:$SwitchMap$com$facebook$SessionState	[I
    //   15: aload_0
    //   16: getfield 150	com/facebook/Session:state	Lcom/facebook/SessionState;
    //   19: invokevirtual 630	com/facebook/SessionState:ordinal	()I
    //   22: iaload
    //   23: tableswitch	default:+33 -> 56, 1:+36->59, 2:+36->59, 3:+70->93, 4:+70->93, 5:+70->93
    //   57: monitorexit
    //   58: return
    //   59: aload_0
    //   60: getstatic 270	com/facebook/SessionState:CLOSED_LOGIN_FAILED	Lcom/facebook/SessionState;
    //   63: putfield 150	com/facebook/Session:state	Lcom/facebook/SessionState;
    //   66: aload_0
    //   67: aload_3
    //   68: aload_0
    //   69: getfield 150	com/facebook/Session:state	Lcom/facebook/SessionState;
    //   72: new 841	com/facebook/FacebookException
    //   75: dup
    //   76: ldc_w 955
    //   79: invokespecial 906	com/facebook/FacebookException:<init>	(Ljava/lang/String;)V
    //   82: invokevirtual 267	com/facebook/Session:postStateChange	(Lcom/facebook/SessionState;Lcom/facebook/SessionState;Ljava/lang/Exception;)V
    //   85: goto -29 -> 56
    //   88: astore_2
    //   89: aload_1
    //   90: monitorexit
    //   91: aload_2
    //   92: athrow
    //   93: aload_0
    //   94: getstatic 958	com/facebook/SessionState:CLOSED	Lcom/facebook/SessionState;
    //   97: putfield 150	com/facebook/Session:state	Lcom/facebook/SessionState;
    //   100: aload_0
    //   101: aload_3
    //   102: aload_0
    //   103: getfield 150	com/facebook/Session:state	Lcom/facebook/SessionState;
    //   106: aconst_null
    //   107: invokevirtual 267	com/facebook/Session:postStateChange	(Lcom/facebook/SessionState;Lcom/facebook/SessionState;Ljava/lang/Exception;)V
    //   110: goto -54 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	Session
    //   4	86	1	localObject1	Object
    //   88	4	2	localObject2	Object
    //   11	91	3	localSessionState	SessionState
    // Exception table:
    //   from	to	target	type
    //   7	91	88	finally
    //   93	110	88	finally
  }
  
  public final void closeAndClearTokenInformation()
  {
    if (this.tokenCachingStrategy != null) {
      this.tokenCachingStrategy.clear();
    }
    Utility.clearFacebookCookies(staticContext);
    Utility.clearCaches(staticContext);
    close();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (!(paramObject instanceof Session)) {}
    for (;;)
    {
      return bool;
      Session localSession = (Session)paramObject;
      if ((areEqual(localSession.applicationId, this.applicationId)) && (areEqual(localSession.authorizationBundle, this.authorizationBundle)) && (areEqual(localSession.state, this.state)) && (areEqual(localSession.getExpirationDate(), getExpirationDate()))) {
        bool = true;
      }
    }
  }
  
  void extendAccessToken()
  {
    Session.TokenRefreshRequest localTokenRefreshRequest = null;
    synchronized (this.lock)
    {
      if (this.currentTokenRefreshRequest == null)
      {
        localTokenRefreshRequest = new Session.TokenRefreshRequest(this);
        this.currentTokenRefreshRequest = localTokenRefreshRequest;
      }
      if (localTokenRefreshRequest != null) {
        localTokenRefreshRequest.bind();
      }
      return;
    }
  }
  
  void extendAccessTokenIfNeeded()
  {
    if (shouldExtendAccessToken()) {
      extendAccessToken();
    }
  }
  
  void extendTokenCompleted(Bundle paramBundle)
  {
    synchronized (this.lock)
    {
      SessionState localSessionState = this.state;
      switch (Session.5.$SwitchMap$com$facebook$SessionState[this.state.ordinal()])
      {
      default: 
        new StringBuilder().append("refreshToken ignored in state ").append(this.state).toString();
        break;
      case 4: 
        this.state = SessionState.OPENED_TOKEN_UPDATED;
        postStateChange(localSessionState, this.state, null);
      case 5: 
        this.tokenInfo = AccessToken.createFromRefresh(this.tokenInfo, paramBundle);
        if (this.tokenCachingStrategy != null) {
          this.tokenCachingStrategy.save(this.tokenInfo.toCacheBundle());
        }
        break;
      }
    }
  }
  
  /* Error */
  void finishAuthOrReauth(AccessToken paramAccessToken, Exception paramException)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +23 -> 24
    //   4: aload_1
    //   5: invokevirtual 1005	com/facebook/AccessToken:isInvalid	()Z
    //   8: ifeq +16 -> 24
    //   11: aconst_null
    //   12: astore_1
    //   13: new 841	com/facebook/FacebookException
    //   16: dup
    //   17: ldc_w 1007
    //   20: invokespecial 906	com/facebook/FacebookException:<init>	(Ljava/lang/String;)V
    //   23: astore_2
    //   24: aload_0
    //   25: getfield 117	com/facebook/Session:lock	Ljava/lang/Object;
    //   28: astore_3
    //   29: aload_3
    //   30: monitorenter
    //   31: getstatic 627	com/facebook/Session$5:$SwitchMap$com$facebook$SessionState	[I
    //   34: aload_0
    //   35: getfield 150	com/facebook/Session:state	Lcom/facebook/SessionState;
    //   38: invokevirtual 630	com/facebook/SessionState:ordinal	()I
    //   41: iaload
    //   42: tableswitch	default:+42 -> 84, 1:+70->112, 2:+45->87, 3:+70->112, 4:+61->103, 5:+61->103, 6:+70->112, 7:+70->112
    //   85: monitorexit
    //   86: return
    //   87: aload_0
    //   88: aload_1
    //   89: aload_2
    //   90: invokespecial 1009	com/facebook/Session:finishAuthorization	(Lcom/facebook/AccessToken;Ljava/lang/Exception;)V
    //   93: goto -9 -> 84
    //   96: astore 4
    //   98: aload_3
    //   99: monitorexit
    //   100: aload 4
    //   102: athrow
    //   103: aload_0
    //   104: aload_1
    //   105: aload_2
    //   106: invokespecial 1011	com/facebook/Session:finishReauthorization	(Lcom/facebook/AccessToken;Ljava/lang/Exception;)V
    //   109: goto -25 -> 84
    //   112: new 987	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 988	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 1013
    //   122: invokevirtual 994	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_0
    //   126: getfield 150	com/facebook/Session:state	Lcom/facebook/SessionState;
    //   129: invokevirtual 997	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 998	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: pop
    //   136: goto -52 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	Session
    //   0	139	1	paramAccessToken	AccessToken
    //   0	139	2	paramException	Exception
    //   28	71	3	localObject1	Object
    //   96	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   31	100	96	finally
    //   103	136	96	finally
  }
  
  public final String getAccessToken()
  {
    synchronized (this.lock)
    {
      if (this.tokenInfo == null)
      {
        str = null;
        return str;
      }
      String str = this.tokenInfo.getToken();
    }
  }
  
  public final String getApplicationId()
  {
    return this.applicationId;
  }
  
  public final Bundle getAuthorizationBundle()
  {
    synchronized (this.lock)
    {
      Bundle localBundle = this.authorizationBundle;
      return localBundle;
    }
  }
  
  public final List<String> getDeclinedPermissions()
  {
    synchronized (this.lock)
    {
      if (this.tokenInfo == null)
      {
        localObject3 = null;
        return localObject3;
      }
      Object localObject3 = this.tokenInfo.getDeclinedPermissions();
    }
  }
  
  public final Date getExpirationDate()
  {
    synchronized (this.lock)
    {
      if (this.tokenInfo == null)
      {
        localDate = null;
        return localDate;
      }
      Date localDate = this.tokenInfo.getExpires();
    }
  }
  
  Date getLastAttemptedTokenExtendDate()
  {
    return this.lastAttemptedTokenExtendDate;
  }
  
  public final List<String> getPermissions()
  {
    synchronized (this.lock)
    {
      if (this.tokenInfo == null)
      {
        localObject3 = null;
        return localObject3;
      }
      Object localObject3 = this.tokenInfo.getPermissions();
    }
  }
  
  public final SessionState getState()
  {
    synchronized (this.lock)
    {
      SessionState localSessionState = this.state;
      return localSessionState;
    }
  }
  
  AccessToken getTokenInfo()
  {
    return this.tokenInfo;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public final boolean isClosed()
  {
    synchronized (this.lock)
    {
      boolean bool = this.state.isClosed();
      return bool;
    }
  }
  
  public final boolean isOpened()
  {
    synchronized (this.lock)
    {
      boolean bool = this.state.isOpened();
      return bool;
    }
  }
  
  public boolean isPermissionGranted(String paramString)
  {
    List localList = getPermissions();
    if (localList != null) {}
    for (boolean bool = localList.contains(paramString);; bool = false) {
      return bool;
    }
  }
  
  public final boolean onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    Validate.notNull(paramActivity, "currentActivity");
    initializeStaticContext(paramActivity);
    boolean bool;
    Object localObject3;
    synchronized (this.lock)
    {
      if ((this.pendingAuthorizationRequest == null) || (paramInt1 != this.pendingAuthorizationRequest.getRequestCode()))
      {
        bool = false;
      }
      else
      {
        localObject3 = AuthorizationClient.Result.Code.ERROR;
        if (paramIntent != null)
        {
          AuthorizationClient.Result localResult = (AuthorizationClient.Result)paramIntent.getSerializableExtra("com.facebook.LoginActivity:Result");
          if (localResult != null)
          {
            handleAuthorizationResult(paramInt2, localResult);
            bool = true;
          }
        }
      }
    }
    if (this.authorizationClient != null)
    {
      this.authorizationClient.onActivityResult(paramInt1, paramInt2, paramIntent);
      bool = true;
    }
    else
    {
      Object localObject4 = null;
      for (;;)
      {
        if (localObject4 == null) {
          localObject4 = new FacebookException("Unexpected call to Session.onActivityResult");
        }
        logAuthorizationComplete((AuthorizationClient.Result.Code)localObject3, null, (Exception)localObject4);
        finishAuthOrReauth(null, (Exception)localObject4);
        bool = true;
        break;
        if (paramInt2 == 0)
        {
          FacebookOperationCanceledException localFacebookOperationCanceledException = new FacebookOperationCanceledException("User canceled operation.");
          AuthorizationClient.Result.Code localCode = AuthorizationClient.Result.Code.CANCEL;
          localObject4 = localFacebookOperationCanceledException;
          localObject3 = localCode;
        }
        else
        {
          localObject4 = null;
        }
      }
    }
    return bool;
  }
  
  /* Error */
  public final void open(AccessToken paramAccessToken, Session.StatusCallback paramStatusCallback)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 117	com/facebook/Session:lock	Ljava/lang/Object;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 152	com/facebook/Session:pendingAuthorizationRequest	Lcom/facebook/Session$AuthorizationRequest;
    //   11: ifnull +21 -> 32
    //   14: new 618	java/lang/UnsupportedOperationException
    //   17: dup
    //   18: ldc_w 620
    //   21: invokespecial 621	java/lang/UnsupportedOperationException:<init>	(Ljava/lang/String;)V
    //   24: athrow
    //   25: astore 4
    //   27: aload_3
    //   28: monitorexit
    //   29: aload 4
    //   31: athrow
    //   32: aload_0
    //   33: getfield 150	com/facebook/Session:state	Lcom/facebook/SessionState;
    //   36: invokevirtual 752	com/facebook/SessionState:isClosed	()Z
    //   39: ifeq +14 -> 53
    //   42: new 618	java/lang/UnsupportedOperationException
    //   45: dup
    //   46: ldc_w 1051
    //   49: invokespecial 621	java/lang/UnsupportedOperationException:<init>	(Ljava/lang/String;)V
    //   52: athrow
    //   53: aload_0
    //   54: getfield 150	com/facebook/Session:state	Lcom/facebook/SessionState;
    //   57: getstatic 148	com/facebook/SessionState:CREATED	Lcom/facebook/SessionState;
    //   60: if_acmpeq +24 -> 84
    //   63: aload_0
    //   64: getfield 150	com/facebook/Session:state	Lcom/facebook/SessionState;
    //   67: getstatic 209	com/facebook/SessionState:CREATED_TOKEN_LOADED	Lcom/facebook/SessionState;
    //   70: if_acmpeq +14 -> 84
    //   73: new 618	java/lang/UnsupportedOperationException
    //   76: dup
    //   77: ldc_w 632
    //   80: invokespecial 621	java/lang/UnsupportedOperationException:<init>	(Ljava/lang/String;)V
    //   83: athrow
    //   84: aload_2
    //   85: ifnull +8 -> 93
    //   88: aload_0
    //   89: aload_2
    //   90: invokevirtual 650	com/facebook/Session:addCallback	(Lcom/facebook/Session$StatusCallback;)V
    //   93: aload_0
    //   94: aload_1
    //   95: putfield 202	com/facebook/Session:tokenInfo	Lcom/facebook/AccessToken;
    //   98: aload_0
    //   99: getfield 143	com/facebook/Session:tokenCachingStrategy	Lcom/facebook/TokenCachingStrategy;
    //   102: ifnull +14 -> 116
    //   105: aload_0
    //   106: getfield 143	com/facebook/Session:tokenCachingStrategy	Lcom/facebook/TokenCachingStrategy;
    //   109: aload_1
    //   110: invokevirtual 849	com/facebook/AccessToken:toCacheBundle	()Landroid/os/Bundle;
    //   113: invokevirtual 853	com/facebook/TokenCachingStrategy:save	(Landroid/os/Bundle;)V
    //   116: aload_0
    //   117: getfield 150	com/facebook/Session:state	Lcom/facebook/SessionState;
    //   120: astore 5
    //   122: aload_0
    //   123: getstatic 263	com/facebook/SessionState:OPENED	Lcom/facebook/SessionState;
    //   126: putfield 150	com/facebook/Session:state	Lcom/facebook/SessionState;
    //   129: aload_0
    //   130: aload 5
    //   132: aload_0
    //   133: getfield 150	com/facebook/Session:state	Lcom/facebook/SessionState;
    //   136: aconst_null
    //   137: invokevirtual 267	com/facebook/Session:postStateChange	(Lcom/facebook/SessionState;Lcom/facebook/SessionState;Ljava/lang/Exception;)V
    //   140: aload_3
    //   141: monitorexit
    //   142: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	Session
    //   0	143	1	paramAccessToken	AccessToken
    //   0	143	2	paramStatusCallback	Session.StatusCallback
    //   4	137	3	localObject1	Object
    //   25	5	4	localObject2	Object
    //   120	11	5	localSessionState	SessionState
    // Exception table:
    //   from	to	target	type
    //   7	29	25	finally
    //   32	142	25	finally
  }
  
  public final void openForPublish(Session.OpenRequest paramOpenRequest)
  {
    open(paramOpenRequest, SessionAuthorizationType.PUBLISH);
  }
  
  public final void openForRead(Session.OpenRequest paramOpenRequest)
  {
    open(paramOpenRequest, SessionAuthorizationType.READ);
  }
  
  void postStateChange(SessionState paramSessionState1, SessionState paramSessionState2, Exception paramException)
  {
    if ((paramSessionState1 == paramSessionState2) && (paramSessionState1 != SessionState.OPENED_TOKEN_UPDATED) && (paramException == null)) {}
    for (;;)
    {
      return;
      if (paramSessionState2.isClosed()) {
        this.tokenInfo = AccessToken.createEmptyToken();
      }
      Session.4 local4 = new Session.4(this, paramSessionState2, paramException);
      runWithHandlerOrExecutor(this.handler, local4);
      if ((this == activeSession) && (paramSessionState1.isOpened() != paramSessionState2.isOpened())) {
        if (paramSessionState2.isOpened()) {
          postActiveSessionAction("com.facebook.sdk.ACTIVE_SESSION_OPENED");
        } else {
          postActiveSessionAction("com.facebook.sdk.ACTIVE_SESSION_CLOSED");
        }
      }
    }
  }
  
  public final void refreshPermissions()
  {
    Request localRequest = new Request(this, "me/permissions");
    localRequest.setCallback(new Session.2(this));
    localRequest.executeAsync();
  }
  
  public final void removeCallback(Session.StatusCallback paramStatusCallback)
  {
    synchronized (this.callbacks)
    {
      this.callbacks.remove(paramStatusCallback);
      return;
    }
  }
  
  public final void requestNewPublishPermissions(Session.NewPermissionsRequest paramNewPermissionsRequest)
  {
    requestNewPermissions(paramNewPermissionsRequest, SessionAuthorizationType.PUBLISH);
  }
  
  public final void requestNewReadPermissions(Session.NewPermissionsRequest paramNewPermissionsRequest)
  {
    requestNewPermissions(paramNewPermissionsRequest, SessionAuthorizationType.READ);
  }
  
  void setCurrentTokenRefreshRequest(Session.TokenRefreshRequest paramTokenRefreshRequest)
  {
    this.currentTokenRefreshRequest = paramTokenRefreshRequest;
  }
  
  void setLastAttemptedTokenExtendDate(Date paramDate)
  {
    this.lastAttemptedTokenExtendDate = paramDate;
  }
  
  void setTokenInfo(AccessToken paramAccessToken)
  {
    this.tokenInfo = paramAccessToken;
  }
  
  boolean shouldExtendAccessToken()
  {
    boolean bool = false;
    if (this.currentTokenRefreshRequest != null) {}
    for (;;)
    {
      return bool;
      Date localDate = new Date();
      if ((this.state.isOpened()) && (this.tokenInfo.getSource().canExtendToken()) && (localDate.getTime() - this.lastAttemptedTokenExtendDate.getTime() > 3600000L) && (localDate.getTime() - this.tokenInfo.getLastRefresh().getTime() > 86400000L)) {
        bool = true;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append("{Session").append(" state:").append(this.state).append(", token:");
    Object localObject;
    StringBuilder localStringBuilder2;
    if (this.tokenInfo == null)
    {
      localObject = "null";
      localStringBuilder2 = localStringBuilder1.append(localObject).append(", appId:");
      if (this.applicationId != null) {
        break label92;
      }
    }
    label92:
    for (String str = "null";; str = this.applicationId)
    {
      return str + "}";
      localObject = this.tokenInfo;
      break;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.Session
 * JD-Core Version:    0.7.0.1
 */