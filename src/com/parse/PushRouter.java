package com.parse;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class PushRouter
{
  private static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor();
  public static final String GCM_RECEIVE_ACTION = "com.google.android.c2dm.intent.RECEIVE";
  private static final String LEGACY_ROUTE_LOCATION = "persistentCallbacks";
  static int MAX_HISTORY_LENGTH = 10;
  private static final String STATE_LOCATION = "pushState";
  private static final String TAG = "com.parse.ParsePushRouter";
  private static final Integer V1_LATEST_PUSH_STATE_VERSION;
  public static final Integer V2_PUSH_STATE_VERSION = Integer.valueOf(4);
  private static PushRouter instance;
  private static m<Void> lastTask;
  private static PushRouter.PushListener pushListener;
  private Boolean forceEnabled;
  private final PushHistory history;
  private final AtomicBoolean isRefreshingInstallation = new AtomicBoolean(false);
  private int pushStateVersion;
  private final PushRoutes routes;
  private final String stateLocation;
  
  static
  {
    V1_LATEST_PUSH_STATE_VERSION = Integer.valueOf(3);
  }
  
  public PushRouter(String paramString, PushRoutes paramPushRoutes, PushHistory paramPushHistory)
  {
    this.stateLocation = paramString;
    this.routes = paramPushRoutes;
    this.history = paramPushHistory;
    this.forceEnabled = null;
    this.pushStateVersion = V1_LATEST_PUSH_STATE_VERSION.intValue();
  }
  
  private static JSONArray getChannelsArrayFromInstallation(ParseInstallation paramParseInstallation)
  {
    JSONArray localJSONArray = null;
    List localList = paramParseInstallation.getList("channels");
    if (localList != null) {
      localJSONArray = (JSONArray)Parse.encode(localList, PointerOrLocalIdEncodingStrategy.get());
    }
    if (localJSONArray != null) {}
    for (;;)
    {
      return localJSONArray;
      localJSONArray = new JSONArray();
    }
  }
  
  public static m<Boolean> getForceEnabledStateAsync()
  {
    try
    {
      m localm = getLastTask().c(new PushRouter.4(), EXECUTOR);
      lastTask = makeUnhandledExceptionsFatal(localm.j());
      return localm;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static PushRouter getInstance()
  {
    JSONObject localJSONObject1;
    if (instance == null)
    {
      localJSONObject1 = migrateV1toV3("persistentCallbacks", "pushState");
      if (localJSONObject1 == null) {
        localJSONObject1 = migrateV2toV3("pushState", "pushState");
      }
      if (localJSONObject1 != null) {
        break label111;
      }
    }
    label111:
    for (JSONObject localJSONObject2 = Parse.getDiskObject(Parse.applicationContext, "pushState");; localJSONObject2 = localJSONObject1)
    {
      instance = new PushRouter("pushState", new PushRoutes(localJSONObject2), new PushHistory(MAX_HISTORY_LENGTH, localJSONObject2));
      if (localJSONObject2 != null)
      {
        instance.forceEnabled = ((Boolean)localJSONObject2.opt("forceEnabled"));
        instance.pushStateVersion = localJSONObject2.optInt("version", V1_LATEST_PUSH_STATE_VERSION.intValue());
      }
      return instance;
    }
  }
  
  private static m<Void> getLastTask()
  {
    try
    {
      if (lastTask == null) {
        lastTask = m.a(null).j();
      }
      m localm = lastTask;
      return localm;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static m<JSONObject> getPushRequestJSONAsync()
  {
    try
    {
      m localm = getLastTask().c(new PushRouter.7(), EXECUTOR);
      lastTask = makeUnhandledExceptionsFatal(localm.j());
      return localm;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static m<Integer> getPushStateVersionAsync()
  {
    try
    {
      m localm = getLastTask().c(new PushRouter.12(), EXECUTOR);
      lastTask = makeUnhandledExceptionsFatal(localm.j());
      return localm;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static PushRoutes.Route getRoute(String paramString)
  {
    try
    {
      localRoute = (PushRoutes.Route)Parse.waitForTask(getRouteAsync(paramString));
      return localRoute;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        PushRoutes.Route localRoute = null;
      }
    }
  }
  
  private static m<PushRoutes.Route> getRouteAsync(String paramString)
  {
    try
    {
      m localm = getLastTask().c(new PushRouter.5(paramString), EXECUTOR);
      lastTask = makeUnhandledExceptionsFatal(localm.j());
      return localm;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static m<Set<String>> getSubscriptionsAsync(boolean paramBoolean)
  {
    try
    {
      m localm = getLastTask().c(new PushRouter.6(paramBoolean), EXECUTOR);
      lastTask = makeUnhandledExceptionsFatal(localm.j());
      return localm;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void handleGcmPushIntent(Intent paramIntent)
  {
    Semaphore localSemaphore = new Semaphore(0);
    EXECUTOR.submit(new PushRouter.8(paramIntent, localSemaphore));
    localSemaphore.acquireUninterruptibly();
  }
  
  public static m<Void> handlePpnsPushAsync(JSONObject paramJSONObject)
  {
    try
    {
      m localm = getLastTask().c(new PushRouter.9(paramJSONObject), EXECUTOR);
      lastTask = makeUnhandledExceptionsFatal(localm);
      return localm;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void handlePushInternal(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("data");
    if (localJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    getInstance();
    String str = paramJSONObject.optString("channel", null);
    Bundle localBundle = new Bundle();
    localBundle.putString("com.parse.Data", localJSONObject.toString());
    localBundle.putString("com.parse.Channel", str);
    Context localContext = Parse.applicationContext;
    Intent localIntent = new Intent("com.parse.push.intent.RECEIVE");
    localIntent.putExtras(localBundle);
    localIntent.setPackage(localContext.getPackageName());
    localContext.sendBroadcast(localIntent);
  }
  
  private PushRouter.HandlePushResult handlePushLegacy(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("data");
    if (localJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    String str1 = paramJSONObject.optString("channel", null);
    String str2 = localJSONObject.optString("action", null);
    Bundle localBundle = new Bundle();
    localBundle.putString("com.parse.Data", localJSONObject.toString());
    localBundle.putString("com.parse.Channel", str1);
    PushRouter.HandlePushResult localHandlePushResult;
    if (str2 != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtras(localBundle);
      localIntent.setAction(str2);
      localIntent.setPackage(Parse.applicationContext.getPackageName());
      Parse.applicationContext.sendBroadcast(localIntent);
      if ((!localJSONObject.has("alert")) && (!localJSONObject.has("title"))) {
        localHandlePushResult = PushRouter.HandlePushResult.BROADCAST_INTENT;
      }
    }
    for (;;)
    {
      return localHandlePushResult;
      PushRoutes.Route localRoute = this.routes.get(str1);
      if ((localRoute == null) && (str1 != null)) {
        localRoute = this.routes.get(null);
      }
      if (localRoute == null)
      {
        Parse.logW("com.parse.ParsePushRouter", "Received push that has no handler. Did you call PushService.setDefaultPushCallback or PushService.subscribe? Push payload: " + paramJSONObject);
        if (str2 != null) {
          localHandlePushResult = PushRouter.HandlePushResult.BROADCAST_INTENT;
        } else {
          localHandlePushResult = PushRouter.HandlePushResult.NO_ROUTE_FOUND;
        }
      }
      else
      {
        Class localClass = localRoute.getActivityClass();
        int i = localRoute.getIconId();
        String str3 = localJSONObject.optString("title", ManifestInfo.getDisplayName());
        String str4 = localJSONObject.optString("alert", "Notification received.");
        if (i == 0)
        {
          i = ManifestInfo.getIconId();
          Parse.logW("com.parse.ParsePushRouter", "Icon ID associated with channel " + str1 + "is invalid; defaulting to package icon");
        }
        Context localContext = Parse.applicationContext;
        ParseNotificationManager.getInstance().showNotification(localContext, str3, str4, localClass, i, localBundle);
        if (str2 != null) {
          localHandlePushResult = PushRouter.HandlePushResult.SHOW_NOTIFICATION_AND_BROADCAST_INTENT;
        } else {
          localHandlePushResult = PushRouter.HandlePushResult.SHOW_NOTIFICATION;
        }
      }
    }
  }
  
  public static boolean isGcmPushIntent(Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.google.android.c2dm.intent.RECEIVE".equals(paramIntent.getAction()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static m<Void> makeUnhandledExceptionsFatal(m<Void> paramm)
  {
    return paramm.a(new PushRouter.13(), EXECUTOR);
  }
  
  private void maybeRefreshInstallation(Date paramDate)
  {
    Date localDate = ParseInstallation.getCurrentInstallation().getUpdatedAt();
    if ((localDate != null) && (paramDate != null) && (localDate.compareTo(paramDate) < 0) && (this.isRefreshingInstallation.compareAndSet(false, true))) {
      ParseInstallation.getCurrentInstallation().fetchInBackground().a(new PushRouter.15(this));
    }
  }
  
  private static JSONObject merge(JSONObject... paramVarArgs)
  {
    JSONObject localJSONObject1 = new JSONObject();
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      JSONObject localJSONObject2 = paramVarArgs[j];
      Iterator localIterator = localJSONObject2.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject1.put(str, localJSONObject2.get(str));
      }
    }
    return localJSONObject1;
  }
  
  static JSONObject migrateV1toV3(String paramString1, String paramString2)
  {
    ParseInstallation localParseInstallation = ParseInstallation.getCurrentInstallation();
    JSONObject localJSONObject1 = Parse.getDiskObject(Parse.applicationContext, paramString1);
    if (localJSONObject1 != null)
    {
      Parse.logD("com.parse.ParsePushRouter", "Migrating push state from V1 to V3: " + localJSONObject1);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = localJSONObject1.keys();
      while (localIterator.hasNext()) {
        localArrayList.add(localIterator.next());
      }
      localParseInstallation.addAllUnique("channels", localArrayList);
      localParseInstallation.saveEventually();
    }
    for (;;)
    {
      try
      {
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("version", 3);
        localJSONObject2.put("routes", localJSONObject1);
        localJSONObject2.put("channels", getChannelsArrayFromInstallation(localParseInstallation));
        Parse.saveDiskObject(Parse.applicationContext, paramString2, localJSONObject2);
        if (!paramString1.equals(paramString2)) {
          Parse.deleteDiskObject(Parse.applicationContext, paramString1);
        }
        return localJSONObject2;
      }
      catch (JSONException localJSONException)
      {
        Parse.logE("com.parse.ParsePushRouter", "Unexpected JSONException when serializing upgraded v1 push state: ", localJSONException);
        localJSONObject2 = null;
        continue;
      }
      JSONObject localJSONObject2 = null;
    }
  }
  
  static JSONObject migrateV2toV3(String paramString1, String paramString2)
  {
    int i = 0;
    ParseInstallation localParseInstallation = ParseInstallation.getCurrentInstallation();
    JSONObject localJSONObject1 = Parse.getDiskObject(Parse.applicationContext, paramString1);
    Object localObject = null;
    if (localJSONObject1 != null)
    {
      if (localJSONObject1.optInt("version") != 2) {
        break label334;
      }
      Parse.logD("com.parse.ParsePushRouter", "Migrating push state from V2 to V3: " + localJSONObject1);
      JSONArray localJSONArray1 = localJSONObject1.optJSONArray("addChannels");
      if (localJSONArray1 != null)
      {
        ArrayList localArrayList1 = new ArrayList();
        for (int j = 0; j < localJSONArray1.length(); j++) {
          localArrayList1.add(localJSONArray1.optString(j));
        }
        localParseInstallation.addAllUnique("channels", localArrayList1);
        localParseInstallation.saveEventually();
      }
      JSONArray localJSONArray2 = localJSONObject1.optJSONArray("removeChannels");
      if (localJSONArray2 != null)
      {
        ArrayList localArrayList2 = new ArrayList();
        while (i < localJSONArray2.length())
        {
          localArrayList2.add(localJSONArray2.optString(i));
          i++;
        }
        localParseInstallation.removeAll("channels", localArrayList2);
        localParseInstallation.saveEventually();
      }
      if (localJSONObject1.has("installation"))
      {
        ParseDecoder localParseDecoder = new ParseDecoder();
        localParseInstallation.mergeAfterFetch(localJSONObject1.optJSONObject("installation"), localParseDecoder, true);
        localParseInstallation.saveEventually();
      }
    }
    try
    {
      localJSONObject1.put("version", 3);
      localJSONObject1.remove("addChannels");
      localJSONObject1.remove("removeChannels");
      localJSONObject1.remove("installation");
      localJSONObject1.put("channels", getChannelsArrayFromInstallation(localParseInstallation));
      Parse.saveDiskObject(Parse.applicationContext, paramString2, localJSONObject1);
      localJSONObject2 = localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Parse.logE("com.parse.ParsePushRouter", "Unexpected JSONException when serializing upgraded v2 push state: ", localJSONException);
        JSONObject localJSONObject2 = null;
      }
    }
    if (!paramString1.equals(paramString2)) {
      Parse.deleteDiskObject(Parse.applicationContext, paramString1);
    }
    localObject = localJSONObject2;
    for (;;)
    {
      return localObject;
      label334:
      if (localJSONObject1.optInt("version") == 3) {
        localObject = localJSONObject1;
      }
    }
  }
  
  static void noteHandlePushResult(JSONObject paramJSONObject, PushRouter.HandlePushResult paramHandlePushResult)
  {
    try
    {
      PushRouter.PushListener localPushListener = pushListener;
      if (localPushListener != null) {
        getLastTask().a(new PushRouter.14(localPushListener, paramJSONObject, paramHandlePushResult), EXECUTOR);
      }
      return;
    }
    finally {}
  }
  
  public static m<Void> reloadFromDiskAsync(boolean paramBoolean)
  {
    try
    {
      m localm = getLastTask().c(new PushRouter.10(paramBoolean), EXECUTOR);
      lastTask = makeUnhandledExceptionsFatal(localm);
      return localm;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static PushRouter reloadInstance(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Parse.deleteDiskObject(Parse.applicationContext, "persistentCallbacks");
      Parse.deleteDiskObject(Parse.applicationContext, "pushState");
    }
    instance = null;
    return getInstance();
  }
  
  private Date serverInstallationUpdatedAt(JSONObject paramJSONObject)
  {
    Date localDate = null;
    String str = paramJSONObject.optString("installation_updated_at", null);
    if (str != null) {
      localDate = Parse.stringToDate(str);
    }
    return localDate;
  }
  
  public static m<Void> setForceEnabledAsync(Boolean paramBoolean)
  {
    try
    {
      m localm = getLastTask().c(new PushRouter.3(paramBoolean), EXECUTOR);
      lastTask = makeUnhandledExceptionsFatal(localm);
      return localm;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static void setGlobalPushListener(PushRouter.PushListener paramPushListener)
  {
    try
    {
      pushListener = paramPushListener;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static m<Void> subscribeAsync(String paramString, Class<? extends Activity> paramClass, int paramInt)
  {
    if ((paramString != null) && (!PushRoutes.isValidChannelName(paramString))) {
      throw new IllegalArgumentException("Invalid channel name: + " + paramString + " (must be empty " + "string or a letter followed by alphanumerics or hyphen)");
    }
    if (paramClass == null) {
      throw new IllegalArgumentException("Can't subscribe to channel with null activity class.");
    }
    if (paramInt == 0) {
      throw new IllegalArgumentException("Must subscribe to channel with a valid icon identifier.");
    }
    try
    {
      m localm = getLastTask().c(new PushRouter.1(paramString, paramClass, paramInt), EXECUTOR);
      lastTask = makeUnhandledExceptionsFatal(localm);
      return localm;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static m<Void> unsubscribeAsync(String paramString)
  {
    try
    {
      m localm = getLastTask().c(new PushRouter.2(paramString), EXECUTOR);
      lastTask = makeUnhandledExceptionsFatal(localm);
      return localm;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static m<Void> wipeRoutingAndUpgradePushStateAsync()
  {
    try
    {
      m localm = getLastTask().c(new PushRouter.11(), EXECUTOR);
      lastTask = makeUnhandledExceptionsFatal(localm);
      return localm;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  JSONObject convertGcmIntentToJSONObject(Intent paramIntent)
  {
    Object localObject = null;
    if (paramIntent != null)
    {
      String str1 = paramIntent.getStringExtra("message_type");
      if (str1 != null) {
        Parse.logI("com.parse.ParsePushRouter", "Ignored special message type " + str1 + " from GCM via intent" + paramIntent);
      }
    }
    else
    {
      return localObject;
    }
    String str2 = paramIntent.getStringExtra("data");
    String str3 = paramIntent.getStringExtra("channel");
    String str4 = paramIntent.getStringExtra("installation_updated_at");
    int i = 0;
    if (str2 != null) {}
    for (;;)
    {
      try
      {
        localJSONObject1 = new JSONObject(str2);
        if (i != 0) {
          break;
        }
      }
      catch (JSONException localJSONException2)
      {
        try
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.putOpt("data", localJSONObject1);
          localJSONObject2.putOpt("channel", str3);
          localJSONObject2.putOpt("installation_updated_at", str4);
          localObject = localJSONObject2;
        }
        catch (JSONException localJSONException1)
        {
          Parse.logE("com.parse.ParsePushRouter", "Ignoring push because of JSON exception while building payload", localJSONException1);
        }
        localJSONException2 = localJSONException2;
        Parse.logE("com.parse.ParsePushRouter", "Ignoring push because of JSON exception while processing: " + str2, localJSONException2);
        i = 1;
        localJSONObject1 = null;
        continue;
      }
      break;
      JSONObject localJSONObject1 = null;
    }
  }
  
  public JSONObject getPushRequestJSON()
  {
    localJSONObject = new JSONObject();
    ParseInstallation localParseInstallation = ParseInstallation.getCurrentInstallation();
    try
    {
      localJSONObject.put("installation_id", localParseInstallation.getInstallationId());
      localJSONObject.put("oauth_key", ParseObject.getApplicationId());
      localJSONObject.put("v", "a1.7.1");
      Object localObject = this.history.getLastReceivedTimestamp();
      if (localObject != null) {}
      for (;;)
      {
        localJSONObject.put("last", localObject);
        Set localSet = this.history.getPushIds();
        if (localSet.size() > 0) {
          localJSONObject.put("last_seen", new JSONArray(localSet));
        }
        localJSONObject.put("ack_keep_alive", true);
        localJSONObject.putOpt("ignore_after", this.history.getCutoffTimestamp());
        break;
        localObject = JSONObject.NULL;
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      Parse.logE("com.parse.ParsePushRouter", "Unexpected JSONException serializing push handshake", localJSONException);
      localJSONObject = null;
    }
  }
  
  public Set<String> getSubscriptions(boolean paramBoolean)
  {
    HashSet localHashSet = new HashSet();
    List localList = ParseInstallation.getCurrentInstallation().getList("channels");
    if (localList != null) {
      localHashSet.addAll(localList);
    }
    localHashSet.addAll(this.routes.getChannels());
    if (!paramBoolean) {
      localHashSet.remove(null);
    }
    return Collections.unmodifiableSet(localHashSet);
  }
  
  public PushRouter.HandlePushResult handleGcmPush(Intent paramIntent)
  {
    JSONObject localJSONObject = convertGcmIntentToJSONObject(paramIntent);
    if (localJSONObject != null) {}
    for (PushRouter.HandlePushResult localHandlePushResult = handlePush(localJSONObject);; localHandlePushResult = PushRouter.HandlePushResult.INVALID_DATA) {
      return localHandlePushResult;
    }
  }
  
  public PushRouter.HandlePushResult handlePpnsPush(JSONObject paramJSONObject)
  {
    PushRouter.HandlePushResult localHandlePushResult = PushRouter.HandlePushResult.FAILED_HISTORY_TEST;
    String str1 = paramJSONObject.optString("push_id", null);
    String str2 = paramJSONObject.optString("time", null);
    if ((str2 != null) && (this.history.tryInsertPush(str1, str2)))
    {
      localHandlePushResult = handlePush(paramJSONObject);
      saveStateToDisk();
    }
    return localHandlePushResult;
  }
  
  public PushRouter.HandlePushResult handlePush(JSONObject paramJSONObject)
  {
    if (ManifestInfo.getPushUsesBroadcastReceivers()) {
      handlePushInternal(paramJSONObject);
    }
    for (PushRouter.HandlePushResult localHandlePushResult = PushRouter.HandlePushResult.INVOKED_PARSE_PUSH_BROADCAST_RECEIVER;; localHandlePushResult = handlePushLegacy(paramJSONObject))
    {
      maybeRefreshInstallation(serverInstallationUpdatedAt(paramJSONObject));
      noteHandlePushResult(paramJSONObject, localHandlePushResult);
      return localHandlePushResult;
    }
  }
  
  public boolean saveStateToDisk()
  {
    boolean bool = false;
    try
    {
      JSONObject localJSONObject = toJSON();
      Parse.saveDiskObject(Parse.applicationContext, this.stateLocation, localJSONObject);
      bool = true;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Parse.logE("com.parse.ParsePushRouter", "Error serializing push state to json", localJSONException);
      }
    }
    return bool;
  }
  
  public void setForceEnabledState(Boolean paramBoolean)
  {
    Boolean localBoolean = this.forceEnabled;
    if ((localBoolean != null) && (localBoolean == paramBoolean)) {}
    for (;;)
    {
      return;
      this.forceEnabled = paramBoolean;
      saveStateToDisk();
    }
  }
  
  public void setPushStateVersion(int paramInt)
  {
    if (paramInt != this.pushStateVersion)
    {
      this.pushStateVersion = paramInt;
      saveStateToDisk();
    }
  }
  
  public void subscribe(String paramString, Class<? extends Activity> paramClass, int paramInt)
  {
    ParseInstallation localParseInstallation = ParseInstallation.getCurrentInstallation();
    PushRoutes.Route localRoute1 = new PushRoutes.Route(paramClass.getName(), paramInt);
    PushRoutes.Route localRoute2 = this.routes.put(paramString, localRoute1);
    if (!localRoute1.equals(localRoute2)) {
      saveStateToDisk();
    }
    if ((localRoute2 == null) && (paramString != null)) {
      localParseInstallation.addUnique("channels", paramString);
    }
    localParseInstallation.saveEventually();
  }
  
  public JSONObject toJSON()
  {
    JSONObject localJSONObject;
    if (V2_PUSH_STATE_VERSION.equals(Integer.valueOf(this.pushStateVersion))) {
      localJSONObject = this.history.toJSON();
    }
    for (;;)
    {
      localJSONObject.put("version", this.pushStateVersion);
      localJSONObject.putOpt("forceEnabled", this.forceEnabled);
      return localJSONObject;
      JSONObject[] arrayOfJSONObject = new JSONObject[2];
      arrayOfJSONObject[0] = this.routes.toJSON();
      arrayOfJSONObject[1] = this.history.toJSON();
      localJSONObject = merge(arrayOfJSONObject);
      localJSONObject.put("channels", getChannelsArrayFromInstallation(ParseInstallation.getCurrentInstallation()));
    }
  }
  
  public void unsubscribe(String paramString)
  {
    if (this.routes.remove(paramString) != null)
    {
      saveStateToDisk();
      if (paramString != null)
      {
        ParseInstallation localParseInstallation = ParseInstallation.getCurrentInstallation();
        String[] arrayOfString = new String[1];
        arrayOfString[0] = paramString;
        localParseInstallation.removeAll("channels", Arrays.asList(arrayOfString));
        localParseInstallation.saveEventually();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushRouter
 * JD-Core Version:    0.7.0.1
 */