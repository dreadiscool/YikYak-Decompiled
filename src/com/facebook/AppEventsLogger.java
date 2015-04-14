package com.facebook;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.FetchedAppSettings;
import com.facebook.internal.Validate;
import g;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Currency;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;

public class AppEventsLogger
{
  public static final String ACTION_APP_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_FLUSHED";
  public static final String APP_EVENTS_EXTRA_FLUSH_RESULT = "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT";
  public static final String APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED";
  static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";
  private static final int APP_SUPPORTS_ATTRIBUTION_ID_RECHECK_PERIOD_IN_SECONDS = 86400;
  private static final int FLUSH_APP_SESSION_INFO_IN_SECONDS = 30;
  private static final int FLUSH_PERIOD_IN_SECONDS = 15;
  private static final int NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER = 100;
  private static final String SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT = "_fbSourceApplicationHasBeenSet";
  private static final String TAG = AppEventsLogger.class.getCanonicalName();
  private static String anonymousAppDeviceGUID;
  private static Context applicationContext;
  private static ScheduledThreadPoolExecutor backgroundExecutor;
  private static AppEventsLogger.FlushBehavior flushBehavior = AppEventsLogger.FlushBehavior.AUTO;
  private static boolean isOpenedByApplink;
  private static boolean requestInFlight;
  private static String sourceApplication;
  private static Map<AppEventsLogger.AccessTokenAppIdPair, AppEventsLogger.SessionEventsState> stateMap = new ConcurrentHashMap();
  private static Object staticLock = new Object();
  private final AppEventsLogger.AccessTokenAppIdPair accessTokenAppId;
  private final Context context;
  
  private AppEventsLogger(Context paramContext, String paramString, Session paramSession)
  {
    Validate.notNull(paramContext, "context");
    this.context = paramContext;
    if (paramSession == null) {
      paramSession = Session.getActiveSession();
    }
    if ((paramSession != null) && ((paramString == null) || (paramString.equals(paramSession.getApplicationId())))) {
      this.accessTokenAppId = new AppEventsLogger.AccessTokenAppIdPair(paramSession);
    }
    synchronized (staticLock)
    {
      if (applicationContext == null) {
        applicationContext = paramContext.getApplicationContext();
      }
      initializeTimersIfNeeded();
      return;
      if (paramString == null) {
        paramString = Utility.getMetadataApplicationId(paramContext);
      }
      this.accessTokenAppId = new AppEventsLogger.AccessTokenAppIdPair(null, paramString);
    }
  }
  
  private static int accumulatePersistedEvents()
  {
    AppEventsLogger.PersistedEvents localPersistedEvents = AppEventsLogger.PersistedEvents.readAndClearStore(applicationContext);
    Iterator localIterator = localPersistedEvents.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      AppEventsLogger.AccessTokenAppIdPair localAccessTokenAppIdPair = (AppEventsLogger.AccessTokenAppIdPair)localIterator.next();
      AppEventsLogger.SessionEventsState localSessionEventsState = getSessionEventsState(applicationContext, localAccessTokenAppIdPair);
      List localList = localPersistedEvents.getEvents(localAccessTokenAppIdPair);
      localSessionEventsState.accumulatePersistedEvents(localList);
      i += localList.size();
    }
    return i;
  }
  
  public static void activateApp(Context paramContext)
  {
    Settings.sdkInitialize(paramContext);
    activateApp(paramContext, Utility.getMetadataApplicationId(paramContext));
  }
  
  public static void activateApp(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {
      throw new IllegalArgumentException("Both context and applicationId must be non-null");
    }
    if ((paramContext instanceof Activity)) {
      setSourceApplication((Activity)paramContext);
    }
    for (;;)
    {
      Settings.publishInstallAsync(paramContext, paramString, null);
      AppEventsLogger localAppEventsLogger = new AppEventsLogger(paramContext, paramString, null);
      long l = System.currentTimeMillis();
      String str = getSourceApplication();
      backgroundExecutor.execute(new AppEventsLogger.1(localAppEventsLogger, l, str));
      return;
      resetSourceApplication();
      AppEventsLogger.class.getName();
    }
  }
  
  private static AppEventsLogger.FlushStatistics buildAndExecuteRequests(AppEventsLogger.FlushReason paramFlushReason, Set<AppEventsLogger.AccessTokenAppIdPair> paramSet)
  {
    AppEventsLogger.FlushStatistics localFlushStatistics1 = new AppEventsLogger.FlushStatistics(null);
    boolean bool = Settings.getLimitEventAndDataUsage(applicationContext);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramSet.iterator();
    while (localIterator1.hasNext())
    {
      AppEventsLogger.AccessTokenAppIdPair localAccessTokenAppIdPair = (AppEventsLogger.AccessTokenAppIdPair)localIterator1.next();
      AppEventsLogger.SessionEventsState localSessionEventsState = getSessionEventsState(localAccessTokenAppIdPair);
      if (localSessionEventsState != null)
      {
        Request localRequest = buildRequestForSession(localAccessTokenAppIdPair, localSessionEventsState, bool, localFlushStatistics1);
        if (localRequest != null) {
          localArrayList.add(localRequest);
        }
      }
    }
    if (localArrayList.size() > 0)
    {
      LoggingBehavior localLoggingBehavior = LoggingBehavior.APP_EVENTS;
      String str = TAG;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(localFlushStatistics1.numEvents);
      arrayOfObject[1] = paramFlushReason.toString();
      Logger.log(localLoggingBehavior, str, "Flushing %d events due to %s.", arrayOfObject);
      Iterator localIterator2 = localArrayList.iterator();
      while (localIterator2.hasNext()) {
        ((Request)localIterator2.next()).executeAndWait();
      }
    }
    for (AppEventsLogger.FlushStatistics localFlushStatistics2 = localFlushStatistics1;; localFlushStatistics2 = null) {
      return localFlushStatistics2;
    }
  }
  
  private static Request buildRequestForSession(AppEventsLogger.AccessTokenAppIdPair paramAccessTokenAppIdPair, AppEventsLogger.SessionEventsState paramSessionEventsState, boolean paramBoolean, AppEventsLogger.FlushStatistics paramFlushStatistics)
  {
    String str = paramAccessTokenAppIdPair.getApplicationId();
    Utility.FetchedAppSettings localFetchedAppSettings = Utility.queryAppSettings(str, false);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = str;
    Request localRequest1 = Request.newPostRequest(null, String.format("%s/activities", arrayOfObject), null, null);
    Bundle localBundle = localRequest1.getParameters();
    if (localBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("access_token", paramAccessTokenAppIdPair.getAccessToken());
    localRequest1.setParameters(localBundle);
    Request localRequest2;
    if (localFetchedAppSettings == null) {
      localRequest2 = null;
    }
    for (;;)
    {
      return localRequest2;
      int i = paramSessionEventsState.populateRequest(localRequest1, localFetchedAppSettings.supportsImplicitLogging(), paramBoolean);
      if (i == 0)
      {
        localRequest2 = null;
      }
      else
      {
        paramFlushStatistics.numEvents = (i + paramFlushStatistics.numEvents);
        localRequest1.setCallback(new AppEventsLogger.7(paramAccessTokenAppIdPair, localRequest1, paramSessionEventsState, paramFlushStatistics));
        localRequest2 = localRequest1;
      }
    }
  }
  
  public static void deactivateApp(Context paramContext)
  {
    deactivateApp(paramContext, Utility.getMetadataApplicationId(paramContext));
  }
  
  public static void deactivateApp(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {
      throw new IllegalArgumentException("Both context and applicationId must be non-null");
    }
    resetSourceApplication();
    AppEventsLogger localAppEventsLogger = new AppEventsLogger(paramContext, paramString, null);
    long l = System.currentTimeMillis();
    backgroundExecutor.execute(new AppEventsLogger.2(localAppEventsLogger, l));
  }
  
  static void eagerFlush()
  {
    if (getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
      flush(AppEventsLogger.FlushReason.EAGER_FLUSHING_EVENT);
    }
  }
  
  private static void flush(AppEventsLogger.FlushReason paramFlushReason)
  {
    Settings.getExecutor().execute(new AppEventsLogger.6(paramFlushReason));
  }
  
  private static void flushAndWait(AppEventsLogger.FlushReason paramFlushReason)
  {
    HashSet localHashSet;
    Object localObject3;
    synchronized (staticLock)
    {
      if (requestInFlight) {
        return;
      }
      requestInFlight = true;
      localHashSet = new HashSet(stateMap.keySet());
      accumulatePersistedEvents();
      localObject3 = null;
    }
    try
    {
      AppEventsLogger.FlushStatistics localFlushStatistics = buildAndExecuteRequests(paramFlushReason, localHashSet);
      localObject3 = localFlushStatistics;
      Intent localIntent;
      return;
    }
    catch (Exception localException)
    {
      synchronized (staticLock)
      {
        requestInFlight = false;
        if (localObject3 != null)
        {
          localIntent = new Intent("com.facebook.sdk.APP_EVENTS_FLUSHED");
          localIntent.putExtra("com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED", localObject3.numEvents);
          localIntent.putExtra("com.facebook.sdk.APP_EVENTS_FLUSH_RESULT", localObject3.result);
          LocalBroadcastManager.getInstance(applicationContext).sendBroadcast(localIntent);
          return;
          localObject2 = finally;
          throw localObject2;
          localException = localException;
          Utility.logd(TAG, "Caught unexpected exception while flushing: ", localException);
        }
      }
    }
  }
  
  private static void flushIfNecessary()
  {
    synchronized (staticLock)
    {
      if ((getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) && (getAccumulatedEventCount() > 100)) {
        flush(AppEventsLogger.FlushReason.EVENT_THRESHOLD);
      }
      return;
    }
  }
  
  private static int getAccumulatedEventCount()
  {
    synchronized (staticLock)
    {
      Iterator localIterator = stateMap.values().iterator();
      int i = 0;
      while (localIterator.hasNext()) {
        i += ((AppEventsLogger.SessionEventsState)localIterator.next()).getAccumulatedEventCount();
      }
      return i;
    }
  }
  
  static String getAnonymousAppDeviceGUID(Context paramContext)
  {
    if (anonymousAppDeviceGUID == null) {}
    synchronized (staticLock)
    {
      if (anonymousAppDeviceGUID == null)
      {
        anonymousAppDeviceGUID = paramContext.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString("anonymousAppDeviceGUID", null);
        if (anonymousAppDeviceGUID == null)
        {
          anonymousAppDeviceGUID = "XZ" + UUID.randomUUID().toString();
          paramContext.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putString("anonymousAppDeviceGUID", anonymousAppDeviceGUID).apply();
        }
      }
      return anonymousAppDeviceGUID;
    }
  }
  
  public static AppEventsLogger.FlushBehavior getFlushBehavior()
  {
    synchronized (staticLock)
    {
      AppEventsLogger.FlushBehavior localFlushBehavior = flushBehavior;
      return localFlushBehavior;
    }
  }
  
  @Deprecated
  public static boolean getLimitEventUsage(Context paramContext)
  {
    return Settings.getLimitEventAndDataUsage(paramContext);
  }
  
  private static AppEventsLogger.SessionEventsState getSessionEventsState(Context paramContext, AppEventsLogger.AccessTokenAppIdPair paramAccessTokenAppIdPair)
  {
    AppEventsLogger.SessionEventsState localSessionEventsState1 = (AppEventsLogger.SessionEventsState)stateMap.get(paramAccessTokenAppIdPair);
    AttributionIdentifiers localAttributionIdentifiers = null;
    if (localSessionEventsState1 == null) {
      localAttributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(paramContext);
    }
    synchronized (staticLock)
    {
      AppEventsLogger.SessionEventsState localSessionEventsState2 = (AppEventsLogger.SessionEventsState)stateMap.get(paramAccessTokenAppIdPair);
      if (localSessionEventsState2 == null)
      {
        localSessionEventsState2 = new AppEventsLogger.SessionEventsState(localAttributionIdentifiers, paramContext.getPackageName(), getAnonymousAppDeviceGUID(paramContext));
        stateMap.put(paramAccessTokenAppIdPair, localSessionEventsState2);
      }
      return localSessionEventsState2;
    }
  }
  
  private static AppEventsLogger.SessionEventsState getSessionEventsState(AppEventsLogger.AccessTokenAppIdPair paramAccessTokenAppIdPair)
  {
    synchronized (staticLock)
    {
      AppEventsLogger.SessionEventsState localSessionEventsState = (AppEventsLogger.SessionEventsState)stateMap.get(paramAccessTokenAppIdPair);
      return localSessionEventsState;
    }
  }
  
  static String getSourceApplication()
  {
    String str = "Unclassified";
    if (isOpenedByApplink) {
      str = "Applink";
    }
    if (sourceApplication != null) {
      str = str + "(" + sourceApplication + ")";
    }
    return str;
  }
  
  private static void handleResponse(AppEventsLogger.AccessTokenAppIdPair paramAccessTokenAppIdPair, Request paramRequest, Response paramResponse, AppEventsLogger.SessionEventsState paramSessionEventsState, AppEventsLogger.FlushStatistics paramFlushStatistics)
  {
    FacebookRequestError localFacebookRequestError = paramResponse.getError();
    AppEventsLogger.FlushResult localFlushResult1 = AppEventsLogger.FlushResult.SUCCESS;
    Object localObject1;
    Object localObject2;
    if (localFacebookRequestError != null) {
      if (localFacebookRequestError.getErrorCode() == -1)
      {
        AppEventsLogger.FlushResult localFlushResult3 = AppEventsLogger.FlushResult.NO_CONNECTIVITY;
        localObject1 = "Failed: No Connectivity";
        localObject2 = localFlushResult3;
      }
    }
    for (;;)
    {
      String str1;
      if (Settings.isLoggingBehaviorEnabled(LoggingBehavior.APP_EVENTS)) {
        str1 = (String)paramRequest.getTag();
      }
      try
      {
        String str4 = new JSONArray(str1).toString(2);
        str2 = str4;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          LoggingBehavior localLoggingBehavior;
          String str3;
          Object[] arrayOfObject1;
          Object[] arrayOfObject2;
          String str5;
          AppEventsLogger.FlushResult localFlushResult2;
          String str2 = "<Can't encode events for debug logging>";
          continue;
          boolean bool = false;
        }
      }
      localLoggingBehavior = LoggingBehavior.APP_EVENTS;
      str3 = TAG;
      arrayOfObject1 = new Object[3];
      arrayOfObject1[0] = paramRequest.getGraphObject().toString();
      arrayOfObject1[1] = localObject1;
      arrayOfObject1[2] = str2;
      Logger.log(localLoggingBehavior, str3, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", arrayOfObject1);
      if (localFacebookRequestError != null)
      {
        bool = true;
        paramSessionEventsState.clearInFlightAndStats(bool);
        if (localObject2 == AppEventsLogger.FlushResult.NO_CONNECTIVITY) {
          AppEventsLogger.PersistedEvents.persistEvents(applicationContext, paramAccessTokenAppIdPair, paramSessionEventsState);
        }
        if ((localObject2 != AppEventsLogger.FlushResult.SUCCESS) && (paramFlushStatistics.result != AppEventsLogger.FlushResult.NO_CONNECTIVITY)) {
          paramFlushStatistics.result = ((AppEventsLogger.FlushResult)localObject2);
        }
        return;
        arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = paramResponse.toString();
        arrayOfObject2[1] = localFacebookRequestError.toString();
        str5 = String.format("Failed:\n  Response: %s\n  Error %s", arrayOfObject2);
        localFlushResult2 = AppEventsLogger.FlushResult.SERVER_ERROR;
        localObject1 = str5;
        localObject2 = localFlushResult2;
      }
      else
      {
        localObject1 = "Success";
        localObject2 = localFlushResult1;
      }
    }
  }
  
  private static void initializeTimersIfNeeded()
  {
    synchronized (staticLock)
    {
      if (backgroundExecutor == null)
      {
        backgroundExecutor = new ScheduledThreadPoolExecutor(1);
        AppEventsLogger.3 local3 = new AppEventsLogger.3();
        backgroundExecutor.scheduleAtFixedRate(local3, 0L, 15L, TimeUnit.SECONDS);
        AppEventsLogger.4 local4 = new AppEventsLogger.4();
        backgroundExecutor.scheduleAtFixedRate(local4, 0L, 86400L, TimeUnit.SECONDS);
      }
    }
  }
  
  private void logAppSessionResumeEvent(long paramLong, String paramString)
  {
    AppEventsLogger.PersistedAppSessionInfo.onResume(applicationContext, this.accessTokenAppId, this, paramLong, paramString);
  }
  
  private void logAppSessionSuspendEvent(long paramLong)
  {
    AppEventsLogger.PersistedAppSessionInfo.onSuspend(applicationContext, this.accessTokenAppId, this, paramLong);
  }
  
  private static void logEvent(Context paramContext, AppEventsLogger.AppEvent paramAppEvent, AppEventsLogger.AccessTokenAppIdPair paramAccessTokenAppIdPair)
  {
    Settings.getExecutor().execute(new AppEventsLogger.5(paramContext, paramAccessTokenAppIdPair, paramAppEvent));
  }
  
  private void logEvent(String paramString, Double paramDouble, Bundle paramBundle, boolean paramBoolean)
  {
    AppEventsLogger.AppEvent localAppEvent = new AppEventsLogger.AppEvent(this.context, paramString, paramDouble, paramBundle, paramBoolean);
    logEvent(this.context, localAppEvent, this.accessTokenAppId);
  }
  
  public static AppEventsLogger newLogger(Context paramContext)
  {
    return new AppEventsLogger(paramContext, null, null);
  }
  
  public static AppEventsLogger newLogger(Context paramContext, Session paramSession)
  {
    return new AppEventsLogger(paramContext, null, paramSession);
  }
  
  public static AppEventsLogger newLogger(Context paramContext, String paramString)
  {
    return new AppEventsLogger(paramContext, paramString, null);
  }
  
  public static AppEventsLogger newLogger(Context paramContext, String paramString, Session paramSession)
  {
    return new AppEventsLogger(paramContext, paramString, paramSession);
  }
  
  private static void notifyDeveloperError(String paramString)
  {
    Logger.log(LoggingBehavior.DEVELOPER_ERRORS, "AppEvents", paramString);
  }
  
  public static void onContextStop()
  {
    AppEventsLogger.PersistedEvents.persistEvents(applicationContext, stateMap);
  }
  
  static void resetSourceApplication()
  {
    sourceApplication = null;
    isOpenedByApplink = false;
  }
  
  public static void setFlushBehavior(AppEventsLogger.FlushBehavior paramFlushBehavior)
  {
    synchronized (staticLock)
    {
      flushBehavior = paramFlushBehavior;
      return;
    }
  }
  
  @Deprecated
  public static void setLimitEventUsage(Context paramContext, boolean paramBoolean)
  {
    Settings.setLimitEventAndDataUsage(paramContext, paramBoolean);
  }
  
  private static void setSourceApplication(Activity paramActivity)
  {
    ComponentName localComponentName = paramActivity.getCallingActivity();
    String str;
    if (localComponentName != null)
    {
      str = localComponentName.getPackageName();
      if (str.equals(paramActivity.getPackageName())) {
        resetSourceApplication();
      }
    }
    for (;;)
    {
      return;
      sourceApplication = str;
      Intent localIntent = paramActivity.getIntent();
      if ((localIntent == null) || (localIntent.getBooleanExtra("_fbSourceApplicationHasBeenSet", false)))
      {
        resetSourceApplication();
      }
      else
      {
        Bundle localBundle1 = g.a(localIntent);
        if (localBundle1 == null)
        {
          resetSourceApplication();
        }
        else
        {
          isOpenedByApplink = true;
          Bundle localBundle2 = localBundle1.getBundle("referer_app_link");
          if (localBundle2 == null)
          {
            sourceApplication = null;
          }
          else
          {
            sourceApplication = localBundle2.getString("package");
            localIntent.putExtra("_fbSourceApplicationHasBeenSet", true);
          }
        }
      }
    }
  }
  
  static void setSourceApplication(String paramString, boolean paramBoolean)
  {
    sourceApplication = paramString;
    isOpenedByApplink = paramBoolean;
  }
  
  public void flush()
  {
    flush(AppEventsLogger.FlushReason.EXPLICIT);
  }
  
  public String getApplicationId()
  {
    return this.accessTokenAppId.getApplicationId();
  }
  
  boolean isValidForSession(Session paramSession)
  {
    AppEventsLogger.AccessTokenAppIdPair localAccessTokenAppIdPair = new AppEventsLogger.AccessTokenAppIdPair(paramSession);
    return this.accessTokenAppId.equals(localAccessTokenAppIdPair);
  }
  
  public void logEvent(String paramString)
  {
    logEvent(paramString, null);
  }
  
  public void logEvent(String paramString, double paramDouble)
  {
    logEvent(paramString, paramDouble, null);
  }
  
  public void logEvent(String paramString, double paramDouble, Bundle paramBundle)
  {
    logEvent(paramString, Double.valueOf(paramDouble), paramBundle, false);
  }
  
  public void logEvent(String paramString, Bundle paramBundle)
  {
    logEvent(paramString, null, paramBundle, false);
  }
  
  public void logPurchase(BigDecimal paramBigDecimal, Currency paramCurrency)
  {
    logPurchase(paramBigDecimal, paramCurrency, null);
  }
  
  public void logPurchase(BigDecimal paramBigDecimal, Currency paramCurrency, Bundle paramBundle)
  {
    if (paramBigDecimal == null) {
      notifyDeveloperError("purchaseAmount cannot be null");
    }
    for (;;)
    {
      return;
      if (paramCurrency == null)
      {
        notifyDeveloperError("currency cannot be null");
      }
      else
      {
        if (paramBundle == null) {
          paramBundle = new Bundle();
        }
        paramBundle.putString("fb_currency", paramCurrency.getCurrencyCode());
        logEvent("fb_mobile_purchase", paramBigDecimal.doubleValue(), paramBundle);
        eagerFlush();
      }
    }
  }
  
  public void logSdkEvent(String paramString, Double paramDouble, Bundle paramBundle)
  {
    logEvent(paramString, paramDouble, paramBundle, true);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.AppEventsLogger
 * JD-Core Version:    0.7.0.1
 */