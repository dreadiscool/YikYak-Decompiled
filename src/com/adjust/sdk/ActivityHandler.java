package com.adjust.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.preference.PreferenceManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ActivityHandler
  extends HandlerThread
{
  private static final String ADJUST_PREFIX = "adjust_";
  private static long SESSION_INTERVAL = 0L;
  private static long SUBSESSION_INTERVAL = 0L;
  private static long TIMER_INTERVAL = 0L;
  private static final String TIME_TRAVEL = "Time travel!";
  private static ScheduledExecutorService timer;
  private ActivityState activityState;
  private String androidId;
  private String appToken;
  private String clientSdk;
  private Context context;
  private String defaultTracker;
  private boolean dropOfflineActivities;
  private boolean enabled;
  private String environment;
  private boolean eventBuffering;
  private String fbAttributionId;
  private Logger logger;
  private String macSha1;
  private String macShortMd5;
  private OnFinishedListener onFinishedListener;
  private IPackageHandler packageHandler;
  private Map<String, String> pluginKeys;
  private ActivityHandler.SessionHandler sessionHandler;
  private String userAgent;
  
  public ActivityHandler(Context paramContext)
  {
    super("Adjust", 1);
    initActivityHandler(paramContext);
    Message localMessage = Message.obtain();
    localMessage.arg1 = 72630;
    this.sessionHandler.sendMessage(localMessage);
  }
  
  public ActivityHandler(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    super("Adjust", 1);
    initActivityHandler(paramContext);
    this.environment = paramString2;
    this.eventBuffering = paramBoolean;
    this.logger.setLogLevelString(paramString3);
    Message localMessage = Message.obtain();
    localMessage.arg1 = 72633;
    localMessage.obj = paramString1;
    this.sessionHandler.sendMessage(localMessage);
  }
  
  private boolean canInit(String paramString)
  {
    if ((checkAppTokenNotNull(paramString)) && (checkAppTokenLength(paramString)) && (checkContext(this.context)) && (checkPermissions(this.context))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean canTrackEvent(PackageBuilder paramPackageBuilder)
  {
    if ((checkAppTokenNotNull(this.appToken)) && (checkActivityState(this.activityState)) && (paramPackageBuilder.isValidForEvent())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean canTrackRevenue(PackageBuilder paramPackageBuilder)
  {
    if ((checkAppTokenNotNull(this.appToken)) && (checkActivityState(this.activityState)) && (paramPackageBuilder.isValidForRevenue())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean checkActivityState(ActivityState paramActivityState)
  {
    boolean bool = false;
    if (paramActivityState == null) {
      this.logger.error("Missing activity state.", new Object[0]);
    }
    for (;;)
    {
      return bool;
      bool = true;
    }
  }
  
  private boolean checkAppTokenLength(String paramString)
  {
    boolean bool = false;
    if (12 != paramString.length())
    {
      Logger localLogger = this.logger;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[bool] = paramString;
      localLogger.error("Malformed App Token '%s'", arrayOfObject);
    }
    for (;;)
    {
      return bool;
      bool = true;
    }
  }
  
  private boolean checkAppTokenNotNull(String paramString)
  {
    boolean bool = false;
    if (paramString == null) {
      this.logger.error("Missing App Token.", new Object[0]);
    }
    for (;;)
    {
      return bool;
      bool = true;
    }
  }
  
  private boolean checkContext(Context paramContext)
  {
    boolean bool = false;
    if (paramContext == null) {
      this.logger.error("Missing context", new Object[0]);
    }
    for (;;)
    {
      return bool;
      bool = true;
    }
  }
  
  private static boolean checkPermission(Context paramContext, String paramString)
  {
    if (paramContext.checkCallingOrSelfPermission(paramString) == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean checkPermissions(Context paramContext)
  {
    boolean bool = true;
    if (!checkPermission(paramContext, "android.permission.INTERNET"))
    {
      this.logger.error("Missing permission: INTERNET", new Object[0]);
      bool = false;
    }
    if (!checkPermission(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
      this.logger.warn("Missing permission: ACCESS_WIFI_STATE", new Object[0]);
    }
    return bool;
  }
  
  public static Boolean deleteActivityState(Context paramContext)
  {
    return Boolean.valueOf(paramContext.deleteFile("AdjustIoActivityState"));
  }
  
  private void endInternal()
  {
    if (!checkAppTokenNotNull(this.appToken)) {}
    for (;;)
    {
      return;
      this.packageHandler.pauseSending();
      stopTimer();
      updateActivityState(System.currentTimeMillis());
      writeActivityState();
    }
  }
  
  private void initActivityHandler(Context paramContext)
  {
    setDaemon(true);
    start();
    TIMER_INTERVAL = AdjustFactory.getTimerInterval();
    SESSION_INTERVAL = AdjustFactory.getSessionInterval();
    SUBSESSION_INTERVAL = AdjustFactory.getSubsessionInterval();
    this.sessionHandler = new ActivityHandler.SessionHandler(getLooper(), this);
    this.context = paramContext.getApplicationContext();
    this.clientSdk = "android3.6.1";
    this.pluginKeys = Util.getPluginKeys(this.context);
    this.enabled = true;
    this.logger = AdjustFactory.getLogger();
  }
  
  private void initInternal(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      paramString = processApplicationBundle();
      if (canInit(paramString)) {
        break label37;
      }
    }
    for (;;)
    {
      return;
      setEnvironment(this.environment);
      setEventBuffering(this.eventBuffering);
      break;
      label37:
      this.appToken = paramString;
      this.androidId = Util.getAndroidId(this.context);
      this.fbAttributionId = Util.getAttributionId(this.context);
      this.userAgent = Util.getUserAgent(this.context);
      if (Util.getPlayAdId(this.context) == null) {
        this.logger.info("Unable to get Google Play Services Advertising ID at start time", new Object[0]);
      }
      if (!Util.isGooglePlayServicesAvailable(this.context))
      {
        String str = Util.getMacAddress(this.context);
        this.macSha1 = Util.getMacSha1(str);
        this.macShortMd5 = Util.getMacShortMd5(str);
      }
      this.packageHandler = AdjustFactory.getPackageHandler(this, this.context, this.dropOfflineActivities);
      readActivityState();
    }
  }
  
  private void injectGeneralAttributes(PackageBuilder paramPackageBuilder)
  {
    paramPackageBuilder.setAppToken(this.appToken);
    paramPackageBuilder.setMacShortMd5(this.macShortMd5);
    paramPackageBuilder.setMacSha1(this.macSha1);
    paramPackageBuilder.setAndroidId(this.androidId);
    paramPackageBuilder.setFbAttributionId(this.fbAttributionId);
    paramPackageBuilder.setUserAgent(this.userAgent);
    paramPackageBuilder.setClientSdk(this.clientSdk);
    paramPackageBuilder.setEnvironment(this.environment);
    paramPackageBuilder.setDefaultTracker(this.defaultTracker);
    paramPackageBuilder.setPluginKeys(this.pluginKeys);
  }
  
  private void injectReferrer(PackageBuilder paramPackageBuilder)
  {
    try
    {
      paramPackageBuilder.setReferrer(PreferenceManager.getDefaultSharedPreferences(this.context).getString("AdjustInstallReferrer", null));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger localLogger = this.logger;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = localException;
        localLogger.error("Failed to inject referrer (%s)", arrayOfObject);
      }
    }
  }
  
  private void launchDeepLinkMain(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      localIntent.setFlags(268435456);
      if (this.context.getPackageManager().queryIntentActivities(localIntent, 0).size() > 0) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label94;
        }
        Logger localLogger2 = this.logger;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = paramString;
        localLogger2.error("Unable to open deep link (%s)", arrayOfObject2);
        break;
      }
      label94:
      Logger localLogger1 = this.logger;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = paramString;
      localLogger1.info("Open deep link (%s)", arrayOfObject1);
      this.context.startActivity(localIntent);
    }
  }
  
  private String processApplicationBundle()
  {
    Bundle localBundle = Util.getApplicationBundle(this.context, this.logger);
    String str;
    if (localBundle == null) {
      str = null;
    }
    for (;;)
    {
      return str;
      str = localBundle.getString("AdjustAppToken");
      setEnvironment(localBundle.getString("AdjustEnvironment"));
      setDefaultTracker(localBundle.getString("AdjustDefaultTracker"));
      setEventBuffering(localBundle.getBoolean("AdjustEventBuffering"));
      this.logger.setLogLevelString(localBundle.getString("AdjustLogLevel"));
      setDropOfflineActivities(localBundle.getBoolean("AdjustDropOfflineActivities"));
    }
  }
  
  /* Error */
  private void readActivityState()
  {
    // Byte code:
    //   0: new 504	java/io/ObjectInputStream
    //   3: dup
    //   4: new 506	java/io/BufferedInputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 151	com/adjust/sdk/ActivityHandler:context	Landroid/content/Context;
    //   12: ldc 223
    //   14: invokevirtual 510	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   17: invokespecial 513	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   20: invokespecial 514	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   23: astore_1
    //   24: aload_0
    //   25: aload_1
    //   26: invokevirtual 518	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   29: checkcast 520	com/adjust/sdk/ActivityState
    //   32: putfield 164	com/adjust/sdk/ActivityHandler:activityState	Lcom/adjust/sdk/ActivityState;
    //   35: aload_0
    //   36: getfield 83	com/adjust/sdk/ActivityHandler:logger	Lcom/adjust/sdk/Logger;
    //   39: astore 11
    //   41: iconst_2
    //   42: anewarray 182	java/lang/Object
    //   45: astore 12
    //   47: aload 12
    //   49: iconst_0
    //   50: aload_0
    //   51: getfield 164	com/adjust/sdk/ActivityHandler:activityState	Lcom/adjust/sdk/ActivityState;
    //   54: aastore
    //   55: aload 12
    //   57: iconst_1
    //   58: aload_0
    //   59: getfield 164	com/adjust/sdk/ActivityHandler:activityState	Lcom/adjust/sdk/ActivityState;
    //   62: getfield 523	com/adjust/sdk/ActivityState:uuid	Ljava/lang/String;
    //   65: aastore
    //   66: aload 11
    //   68: ldc_w 525
    //   71: aload 12
    //   73: invokeinterface 528 3 0
    //   78: aload_1
    //   79: invokevirtual 531	java/io/ObjectInputStream:close	()V
    //   82: return
    //   83: astore 10
    //   85: aload_0
    //   86: getfield 83	com/adjust/sdk/ActivityHandler:logger	Lcom/adjust/sdk/Logger;
    //   89: ldc_w 533
    //   92: iconst_0
    //   93: anewarray 182	java/lang/Object
    //   96: invokeinterface 186 3 0
    //   101: aload_1
    //   102: invokevirtual 531	java/io/ObjectInputStream:close	()V
    //   105: aload_0
    //   106: aconst_null
    //   107: putfield 164	com/adjust/sdk/ActivityHandler:activityState	Lcom/adjust/sdk/ActivityState;
    //   110: goto -28 -> 82
    //   113: astore 9
    //   115: aload_1
    //   116: invokevirtual 531	java/io/ObjectInputStream:close	()V
    //   119: goto -14 -> 105
    //   122: astore 6
    //   124: aload_0
    //   125: getfield 83	com/adjust/sdk/ActivityHandler:logger	Lcom/adjust/sdk/Logger;
    //   128: ldc_w 535
    //   131: iconst_0
    //   132: anewarray 182	java/lang/Object
    //   135: invokeinterface 538 3 0
    //   140: goto -35 -> 105
    //   143: astore 8
    //   145: aload_0
    //   146: getfield 83	com/adjust/sdk/ActivityHandler:logger	Lcom/adjust/sdk/Logger;
    //   149: ldc_w 540
    //   152: iconst_0
    //   153: anewarray 182	java/lang/Object
    //   156: invokeinterface 186 3 0
    //   161: aload_1
    //   162: invokevirtual 531	java/io/ObjectInputStream:close	()V
    //   165: goto -60 -> 105
    //   168: astore_3
    //   169: aload_0
    //   170: getfield 83	com/adjust/sdk/ActivityHandler:logger	Lcom/adjust/sdk/Logger;
    //   173: astore 4
    //   175: iconst_1
    //   176: anewarray 182	java/lang/Object
    //   179: astore 5
    //   181: aload 5
    //   183: iconst_0
    //   184: aload_3
    //   185: aastore
    //   186: aload 4
    //   188: ldc_w 542
    //   191: aload 5
    //   193: invokeinterface 186 3 0
    //   198: goto -93 -> 105
    //   201: astore 7
    //   203: aload_0
    //   204: getfield 83	com/adjust/sdk/ActivityHandler:logger	Lcom/adjust/sdk/Logger;
    //   207: ldc_w 544
    //   210: iconst_0
    //   211: anewarray 182	java/lang/Object
    //   214: invokeinterface 186 3 0
    //   219: aload_1
    //   220: invokevirtual 531	java/io/ObjectInputStream:close	()V
    //   223: goto -118 -> 105
    //   226: astore_2
    //   227: aload_1
    //   228: invokevirtual 531	java/io/ObjectInputStream:close	()V
    //   231: aload_2
    //   232: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	ActivityHandler
    //   23	205	1	localObjectInputStream	java.io.ObjectInputStream
    //   226	6	2	localObject	Object
    //   168	17	3	localException	Exception
    //   173	14	4	localLogger1	Logger
    //   179	13	5	arrayOfObject1	Object[]
    //   122	1	6	localFileNotFoundException	java.io.FileNotFoundException
    //   201	1	7	localClassCastException	java.lang.ClassCastException
    //   143	1	8	localIOException	java.io.IOException
    //   113	1	9	localOptionalDataException	java.io.OptionalDataException
    //   83	1	10	localClassNotFoundException	java.lang.ClassNotFoundException
    //   39	28	11	localLogger2	Logger
    //   45	27	12	arrayOfObject2	Object[]
    // Exception table:
    //   from	to	target	type
    //   24	78	83	java/lang/ClassNotFoundException
    //   24	78	113	java/io/OptionalDataException
    //   0	24	122	java/io/FileNotFoundException
    //   78	82	122	java/io/FileNotFoundException
    //   101	105	122	java/io/FileNotFoundException
    //   115	119	122	java/io/FileNotFoundException
    //   161	165	122	java/io/FileNotFoundException
    //   219	233	122	java/io/FileNotFoundException
    //   24	78	143	java/io/IOException
    //   0	24	168	java/lang/Exception
    //   78	82	168	java/lang/Exception
    //   101	105	168	java/lang/Exception
    //   115	119	168	java/lang/Exception
    //   161	165	168	java/lang/Exception
    //   219	233	168	java/lang/Exception
    //   24	78	201	java/lang/ClassCastException
    //   24	78	226	finally
    //   85	101	226	finally
    //   145	161	226	finally
    //   203	219	226	finally
  }
  
  private void readOpenUrlInternal(Uri paramUri)
  {
    if (paramUri == null) {}
    for (;;)
    {
      return;
      String str1 = paramUri.getQuery();
      if (str1 != null)
      {
        HashMap localHashMap = new HashMap();
        String[] arrayOfString1 = str1.split("&");
        int i = arrayOfString1.length;
        int j = 0;
        if (j < i)
        {
          String[] arrayOfString2 = arrayOfString1[j].split("=");
          if (arrayOfString2.length != 2) {}
          for (;;)
          {
            j++;
            break;
            String str2 = arrayOfString2[0];
            if (str2.startsWith("adjust_"))
            {
              String str3 = arrayOfString2[1];
              if (str3.length() != 0)
              {
                String str4 = str2.substring("adjust_".length());
                if (str4.length() != 0) {
                  localHashMap.put(str4, str3);
                }
              }
            }
          }
        }
        if (localHashMap.size() != 0)
        {
          PackageBuilder localPackageBuilder = new PackageBuilder(this.context);
          localPackageBuilder.setDeepLinkParameters(localHashMap);
          injectGeneralAttributes(localPackageBuilder);
          ActivityPackage localActivityPackage = localPackageBuilder.buildReattributionPackage();
          this.packageHandler.addPackage(localActivityPackage);
          this.packageHandler.sendFirstPackage();
          Logger localLogger = this.logger;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = localHashMap.toString();
          localLogger.debug("Reattribution %s", arrayOfObject);
        }
      }
    }
  }
  
  private void runDelegateMain(ResponseData paramResponseData)
  {
    if (this.onFinishedListener == null) {}
    for (;;)
    {
      return;
      if (paramResponseData != null) {
        this.onFinishedListener.onFinishedTracking(paramResponseData);
      }
    }
  }
  
  private void setDefaultTracker(String paramString)
  {
    this.defaultTracker = paramString;
    if (this.defaultTracker != null)
    {
      Logger localLogger = this.logger;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.defaultTracker;
      localLogger.info("Default tracker: '%s'", arrayOfObject);
    }
  }
  
  private void setDropOfflineActivities(boolean paramBoolean)
  {
    this.dropOfflineActivities = paramBoolean;
    if (this.dropOfflineActivities) {
      this.logger.info("Offline activities will get dropped", new Object[0]);
    }
  }
  
  private void setEnvironment(String paramString)
  {
    this.environment = paramString;
    if (this.environment == null)
    {
      this.logger.Assert("Missing environment", new Object[0]);
      this.logger.setLogLevel(Logger.LogLevel.ASSERT);
      this.environment = "unknown";
    }
    for (;;)
    {
      return;
      if ("sandbox".equalsIgnoreCase(this.environment))
      {
        this.logger.Assert("SANDBOX: Adjust is running in Sandbox mode. Use this setting for testing. Don't forget to set the environment to `production` before publishing!", new Object[0]);
      }
      else if ("production".equalsIgnoreCase(this.environment))
      {
        this.logger.Assert("PRODUCTION: Adjust is running in Production mode. Use this setting only for the build that you want to publish. Set the environment to `sandbox` if you want to test your app!", new Object[0]);
        this.logger.setLogLevel(Logger.LogLevel.ASSERT);
      }
      else
      {
        Logger localLogger = this.logger;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = this.environment;
        localLogger.Assert("Malformed environment '%s'", arrayOfObject);
        this.logger.setLogLevel(Logger.LogLevel.ASSERT);
        this.environment = "malformed";
      }
    }
  }
  
  private void setEventBuffering(boolean paramBoolean)
  {
    this.eventBuffering = paramBoolean;
    if (this.eventBuffering) {
      this.logger.info("Event buffering is enabled", new Object[0]);
    }
  }
  
  private void startInternal()
  {
    if (!checkAppTokenNotNull(this.appToken)) {}
    for (;;)
    {
      return;
      if ((this.activityState == null) || (this.activityState.enabled.booleanValue()))
      {
        this.packageHandler.resumeSending();
        startTimer();
        long l1 = System.currentTimeMillis();
        if (this.activityState == null)
        {
          this.activityState = new ActivityState();
          this.activityState.sessionCount = 1;
          this.activityState.createdAt = l1;
          transferSessionPackage();
          this.activityState.resetSessionAttributes(l1);
          this.activityState.enabled = Boolean.valueOf(this.enabled);
          writeActivityState();
          this.logger.info("First session", new Object[0]);
        }
        else
        {
          long l2 = l1 - this.activityState.lastActivity;
          if (l2 < 0L)
          {
            this.logger.error("Time travel!", new Object[0]);
            this.activityState.lastActivity = l1;
            writeActivityState();
          }
          else if (l2 > SESSION_INTERVAL)
          {
            ActivityState localActivityState3 = this.activityState;
            localActivityState3.sessionCount = (1 + localActivityState3.sessionCount);
            this.activityState.createdAt = l1;
            this.activityState.lastInterval = l2;
            transferSessionPackage();
            this.activityState.resetSessionAttributes(l1);
            writeActivityState();
            Logger localLogger2 = this.logger;
            Object[] arrayOfObject2 = new Object[1];
            arrayOfObject2[0] = Integer.valueOf(this.activityState.sessionCount);
            localLogger2.debug("Session %d", arrayOfObject2);
          }
          else
          {
            if (l2 > SUBSESSION_INTERVAL)
            {
              ActivityState localActivityState2 = this.activityState;
              localActivityState2.subsessionCount = (1 + localActivityState2.subsessionCount);
              Logger localLogger1 = this.logger;
              Object[] arrayOfObject1 = new Object[2];
              arrayOfObject1[0] = Integer.valueOf(this.activityState.subsessionCount);
              arrayOfObject1[1] = Integer.valueOf(this.activityState.sessionCount);
              localLogger1.info("Started subsession %d of session %d", arrayOfObject1);
            }
            ActivityState localActivityState1 = this.activityState;
            localActivityState1.sessionLength = (l2 + localActivityState1.sessionLength);
            this.activityState.lastActivity = l1;
            writeActivityState();
          }
        }
      }
    }
  }
  
  private void startTimer()
  {
    if (timer != null) {
      stopTimer();
    }
    timer = Executors.newSingleThreadScheduledExecutor();
    timer.scheduleWithFixedDelay(new ActivityHandler.2(this), 1000L, TIMER_INTERVAL, TimeUnit.MILLISECONDS);
  }
  
  private void stopTimer()
  {
    try
    {
      timer.shutdown();
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        this.logger.error("No timer found", new Object[0]);
      }
    }
  }
  
  private void timerFired()
  {
    if ((this.activityState != null) && (!this.activityState.enabled.booleanValue())) {}
    for (;;)
    {
      return;
      this.packageHandler.sendFirstPackage();
      updateActivityState(System.currentTimeMillis());
      writeActivityState();
    }
  }
  
  private void trackEventInternal(PackageBuilder paramPackageBuilder)
  {
    if (!canTrackEvent(paramPackageBuilder)) {
      return;
    }
    if (this.activityState.enabled.booleanValue())
    {
      long l = System.currentTimeMillis();
      this.activityState.createdAt = l;
      ActivityState localActivityState = this.activityState;
      localActivityState.eventCount = (1 + localActivityState.eventCount);
      updateActivityState(l);
      injectGeneralAttributes(paramPackageBuilder);
      this.activityState.injectEventAttributes(paramPackageBuilder);
      ActivityPackage localActivityPackage = paramPackageBuilder.buildEventPackage();
      this.packageHandler.addPackage(localActivityPackage);
      if (!this.eventBuffering) {
        break label172;
      }
      Logger localLogger2 = this.logger;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = localActivityPackage.getSuffix();
      localLogger2.info("Buffered event %s", arrayOfObject2);
    }
    for (;;)
    {
      writeActivityState();
      Logger localLogger1 = this.logger;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(this.activityState.eventCount);
      localLogger1.debug("Event %d", arrayOfObject1);
      break;
      break;
      label172:
      this.packageHandler.sendFirstPackage();
    }
  }
  
  private void trackRevenueInternal(PackageBuilder paramPackageBuilder)
  {
    if (!canTrackRevenue(paramPackageBuilder)) {
      return;
    }
    if (this.activityState.enabled.booleanValue())
    {
      long l = System.currentTimeMillis();
      this.activityState.createdAt = l;
      ActivityState localActivityState = this.activityState;
      localActivityState.eventCount = (1 + localActivityState.eventCount);
      updateActivityState(l);
      injectGeneralAttributes(paramPackageBuilder);
      this.activityState.injectEventAttributes(paramPackageBuilder);
      ActivityPackage localActivityPackage = paramPackageBuilder.buildRevenuePackage();
      this.packageHandler.addPackage(localActivityPackage);
      if (!this.eventBuffering) {
        break label172;
      }
      Logger localLogger2 = this.logger;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = localActivityPackage.getSuffix();
      localLogger2.info("Buffered revenue %s", arrayOfObject2);
    }
    for (;;)
    {
      writeActivityState();
      Logger localLogger1 = this.logger;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(this.activityState.eventCount);
      localLogger1.debug("Event %d (revenue)", arrayOfObject1);
      break;
      break;
      label172:
      this.packageHandler.sendFirstPackage();
    }
  }
  
  private void transferSessionPackage()
  {
    PackageBuilder localPackageBuilder = new PackageBuilder(this.context);
    injectGeneralAttributes(localPackageBuilder);
    injectReferrer(localPackageBuilder);
    this.activityState.injectSessionAttributes(localPackageBuilder);
    ActivityPackage localActivityPackage = localPackageBuilder.buildSessionPackage();
    this.packageHandler.addPackage(localActivityPackage);
    this.packageHandler.sendFirstPackage();
  }
  
  private void updateActivityState(long paramLong)
  {
    if (!checkActivityState(this.activityState)) {}
    for (;;)
    {
      return;
      long l = paramLong - this.activityState.lastActivity;
      if (l < 0L)
      {
        this.logger.error("Time travel!", new Object[0]);
        this.activityState.lastActivity = paramLong;
      }
      else if (l <= SESSION_INTERVAL)
      {
        ActivityState localActivityState1 = this.activityState;
        localActivityState1.sessionLength = (l + localActivityState1.sessionLength);
        ActivityState localActivityState2 = this.activityState;
        localActivityState2.timeSpent = (l + localActivityState2.timeSpent);
        this.activityState.lastActivity = paramLong;
      }
    }
  }
  
  /* Error */
  private void writeActivityState()
  {
    // Byte code:
    //   0: new 766	java/io/ObjectOutputStream
    //   3: dup
    //   4: new 768	java/io/BufferedOutputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 151	com/adjust/sdk/ActivityHandler:context	Landroid/content/Context;
    //   12: ldc 223
    //   14: iconst_0
    //   15: invokevirtual 772	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   18: invokespecial 775	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   21: invokespecial 776	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: astore_1
    //   25: aload_1
    //   26: aload_0
    //   27: getfield 164	com/adjust/sdk/ActivityHandler:activityState	Lcom/adjust/sdk/ActivityState;
    //   30: invokevirtual 780	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   33: aload_0
    //   34: getfield 83	com/adjust/sdk/ActivityHandler:logger	Lcom/adjust/sdk/Logger;
    //   37: astore 7
    //   39: iconst_1
    //   40: anewarray 182	java/lang/Object
    //   43: astore 8
    //   45: aload 8
    //   47: iconst_0
    //   48: aload_0
    //   49: getfield 164	com/adjust/sdk/ActivityHandler:activityState	Lcom/adjust/sdk/ActivityState;
    //   52: aastore
    //   53: aload 7
    //   55: ldc_w 782
    //   58: aload 8
    //   60: invokeinterface 528 3 0
    //   65: aload_1
    //   66: invokevirtual 783	java/io/ObjectOutputStream:close	()V
    //   69: return
    //   70: astore 6
    //   72: aload_0
    //   73: getfield 83	com/adjust/sdk/ActivityHandler:logger	Lcom/adjust/sdk/Logger;
    //   76: ldc_w 785
    //   79: iconst_0
    //   80: anewarray 182	java/lang/Object
    //   83: invokeinterface 186 3 0
    //   88: aload_1
    //   89: invokevirtual 783	java/io/ObjectOutputStream:close	()V
    //   92: goto -23 -> 69
    //   95: astore_3
    //   96: aload_0
    //   97: getfield 83	com/adjust/sdk/ActivityHandler:logger	Lcom/adjust/sdk/Logger;
    //   100: astore 4
    //   102: iconst_1
    //   103: anewarray 182	java/lang/Object
    //   106: astore 5
    //   108: aload 5
    //   110: iconst_0
    //   111: aload_3
    //   112: aastore
    //   113: aload 4
    //   115: ldc_w 787
    //   118: aload 5
    //   120: invokeinterface 186 3 0
    //   125: goto -56 -> 69
    //   128: astore_2
    //   129: aload_1
    //   130: invokevirtual 783	java/io/ObjectOutputStream:close	()V
    //   133: aload_2
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	ActivityHandler
    //   24	106	1	localObjectOutputStream	java.io.ObjectOutputStream
    //   128	6	2	localObject	Object
    //   95	17	3	localException	Exception
    //   100	14	4	localLogger1	Logger
    //   106	13	5	arrayOfObject1	Object[]
    //   70	1	6	localNotSerializableException	java.io.NotSerializableException
    //   37	17	7	localLogger2	Logger
    //   43	16	8	arrayOfObject2	Object[]
    // Exception table:
    //   from	to	target	type
    //   25	65	70	java/io/NotSerializableException
    //   0	25	95	java/lang/Exception
    //   65	69	95	java/lang/Exception
    //   88	92	95	java/lang/Exception
    //   129	135	95	java/lang/Exception
    //   25	65	128	finally
    //   72	88	128	finally
  }
  
  public void finishedTrackingActivity(ResponseData paramResponseData, String paramString)
  {
    if ((this.onFinishedListener == null) && (paramString == null)) {}
    for (;;)
    {
      return;
      new Handler(this.context.getMainLooper()).post(new ActivityHandler.1(this, paramResponseData, paramString));
    }
  }
  
  public Boolean isEnabled()
  {
    if (checkActivityState(this.activityState)) {}
    for (Boolean localBoolean = this.activityState.enabled;; localBoolean = Boolean.valueOf(this.enabled)) {
      return localBoolean;
    }
  }
  
  public void readOpenUrl(Uri paramUri)
  {
    Message localMessage = Message.obtain();
    localMessage.arg1 = 72680;
    localMessage.obj = paramUri;
    this.sessionHandler.sendMessage(localMessage);
  }
  
  public void setEnabled(Boolean paramBoolean)
  {
    this.enabled = paramBoolean.booleanValue();
    if (checkActivityState(this.activityState)) {
      this.activityState.enabled = paramBoolean;
    }
    if (paramBoolean.booleanValue()) {
      trackSubsessionStart();
    }
    for (;;)
    {
      return;
      trackSubsessionEnd();
    }
  }
  
  public void setOnFinishedListener(OnFinishedListener paramOnFinishedListener)
  {
    this.onFinishedListener = paramOnFinishedListener;
  }
  
  public void setSdkPrefix(String paramString)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramString;
    arrayOfObject[1] = this.clientSdk;
    this.clientSdk = String.format("%s@%s", arrayOfObject);
  }
  
  public void trackEvent(String paramString, Map<String, String> paramMap)
  {
    PackageBuilder localPackageBuilder = new PackageBuilder(this.context);
    localPackageBuilder.setEventToken(paramString);
    localPackageBuilder.setCallbackParameters(paramMap);
    Message localMessage = Message.obtain();
    localMessage.arg1 = 72660;
    localMessage.obj = localPackageBuilder;
    this.sessionHandler.sendMessage(localMessage);
  }
  
  public void trackRevenue(double paramDouble, String paramString, Map<String, String> paramMap)
  {
    PackageBuilder localPackageBuilder = new PackageBuilder(this.context);
    localPackageBuilder.setAmountInCents(paramDouble);
    localPackageBuilder.setEventToken(paramString);
    localPackageBuilder.setCallbackParameters(paramMap);
    Message localMessage = Message.obtain();
    localMessage.arg1 = 72670;
    localMessage.obj = localPackageBuilder;
    this.sessionHandler.sendMessage(localMessage);
  }
  
  public void trackSubsessionEnd()
  {
    Message localMessage = Message.obtain();
    localMessage.arg1 = 72650;
    this.sessionHandler.sendMessage(localMessage);
  }
  
  public void trackSubsessionStart()
  {
    Message localMessage = Message.obtain();
    localMessage.arg1 = 72640;
    this.sessionHandler.sendMessage(localMessage);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.adjust.sdk.ActivityHandler
 * JD-Core Version:    0.7.0.1
 */