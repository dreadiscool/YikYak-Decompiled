package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObject.Factory;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

public final class Settings
{
  private static final String ANALYTICS_EVENT = "event";
  public static final String APPLICATION_ID_PROPERTY = "com.facebook.sdk.ApplicationId";
  private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
  private static final Uri ATTRIBUTION_ID_CONTENT_URI;
  private static final String ATTRIBUTION_PREFERENCES = "com.facebook.sdk.attributionTracking";
  public static final String CLIENT_TOKEN_PROPERTY = "com.facebook.sdk.ClientToken";
  private static final int DEFAULT_CORE_POOL_SIZE = 5;
  private static final int DEFAULT_KEEP_ALIVE = 1;
  private static final int DEFAULT_MAXIMUM_POOL_SIZE = 128;
  private static final ThreadFactory DEFAULT_THREAD_FACTORY = new Settings.1();
  private static final BlockingQueue<Runnable> DEFAULT_WORK_QUEUE;
  private static final String FACEBOOK_COM = "facebook.com";
  private static final Object LOCK;
  private static final String MOBILE_INSTALL_EVENT = "MOBILE_APP_INSTALL";
  private static final String PUBLISH_ACTIVITY_PATH = "%s/activities";
  private static final String TAG = Settings.class.getCanonicalName();
  private static volatile String appClientToken;
  private static volatile String appVersion;
  private static volatile String applicationId;
  private static volatile boolean defaultsLoaded;
  private static volatile Executor executor;
  private static volatile String facebookDomain;
  private static volatile boolean isDebugEnabled;
  private static final HashSet<LoggingBehavior> loggingBehaviors;
  private static AtomicLong onProgressThreshold;
  private static volatile boolean platformCompatibilityEnabled;
  private static Boolean sdkInitialized = Boolean.valueOf(false);
  
  static
  {
    LoggingBehavior[] arrayOfLoggingBehavior = new LoggingBehavior[1];
    arrayOfLoggingBehavior[0] = LoggingBehavior.DEVELOPER_ERRORS;
    loggingBehaviors = new HashSet(Arrays.asList(arrayOfLoggingBehavior));
    defaultsLoaded = false;
    facebookDomain = "facebook.com";
    onProgressThreshold = new AtomicLong(65536L);
    isDebugEnabled = false;
    LOCK = new Object();
    ATTRIBUTION_ID_CONTENT_URI = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
    DEFAULT_WORK_QUEUE = new LinkedBlockingQueue(10);
  }
  
  public static final void addLoggingBehavior(LoggingBehavior paramLoggingBehavior)
  {
    synchronized (loggingBehaviors)
    {
      loggingBehaviors.add(paramLoggingBehavior);
      return;
    }
  }
  
  public static final void clearLoggingBehaviors()
  {
    synchronized (loggingBehaviors)
    {
      loggingBehaviors.clear();
      return;
    }
  }
  
  public static String getAppVersion()
  {
    return appVersion;
  }
  
  public static String getApplicationId()
  {
    return applicationId;
  }
  
  /* Error */
  public static String getApplicationSignature(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ifnonnull +5 -> 8
    //   6: aload_1
    //   7: areturn
    //   8: aload_0
    //   9: invokevirtual 170	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   12: astore_2
    //   13: aload_2
    //   14: ifnull -8 -> 6
    //   17: aload_0
    //   18: invokevirtual 173	android/content/Context:getPackageName	()Ljava/lang/String;
    //   21: astore_3
    //   22: aload_2
    //   23: aload_3
    //   24: bipush 64
    //   26: invokevirtual 179	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   29: astore 5
    //   31: aload 5
    //   33: getfield 185	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   36: astore 6
    //   38: aload 6
    //   40: ifnull -34 -> 6
    //   43: aload 6
    //   45: arraylength
    //   46: ifeq -40 -> 6
    //   49: ldc 187
    //   51: invokestatic 193	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   54: astore 8
    //   56: aload 8
    //   58: aload 5
    //   60: getfield 185	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   63: iconst_0
    //   64: aaload
    //   65: invokevirtual 199	android/content/pm/Signature:toByteArray	()[B
    //   68: invokevirtual 203	java/security/MessageDigest:update	([B)V
    //   71: aload 8
    //   73: invokevirtual 206	java/security/MessageDigest:digest	()[B
    //   76: bipush 9
    //   78: invokestatic 212	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   81: astore_1
    //   82: goto -76 -> 6
    //   85: astore 4
    //   87: goto -81 -> 6
    //   90: astore 7
    //   92: goto -86 -> 6
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramContext	Context
    //   1	81	1	str1	String
    //   12	11	2	localPackageManager	PackageManager
    //   21	3	3	str2	String
    //   85	1	4	localNameNotFoundException	PackageManager.NameNotFoundException
    //   29	30	5	localPackageInfo	android.content.pm.PackageInfo
    //   36	8	6	arrayOfSignature	android.content.pm.Signature[]
    //   90	1	7	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   54	18	8	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   22	31	85	android/content/pm/PackageManager$NameNotFoundException
    //   49	56	90	java/security/NoSuchAlgorithmException
  }
  
  private static Executor getAsyncTaskExecutor()
  {
    try
    {
      localField = AsyncTask.class.getField("THREAD_POOL_EXECUTOR");
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        Field localField;
        label22:
        localExecutor = null;
      }
    }
    try
    {
      localObject = localField.get(null);
      if (localObject != null) {
        break label36;
      }
      localExecutor = null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localExecutor = null;
      break label22;
      if ((localObject instanceof Executor)) {
        break label49;
      }
      localExecutor = null;
      break label22;
      localExecutor = (Executor)localObject;
      break label22;
    }
    return localExecutor;
  }
  
  /* Error */
  public static String getAttributionId(android.content.ContentResolver paramContentResolver)
  {
    // Byte code:
    //   0: iconst_1
    //   1: anewarray 240	java/lang/String
    //   4: astore 6
    //   6: aload 6
    //   8: iconst_0
    //   9: ldc 14
    //   11: aastore
    //   12: aload_0
    //   13: getstatic 122	com/facebook/Settings:ATTRIBUTION_ID_CONTENT_URI	Landroid/net/Uri;
    //   16: aload 6
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: invokevirtual 246	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore 7
    //   26: aload 7
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull +16 -> 46
    //   33: aload_2
    //   34: invokeinterface 252 1 0
    //   39: istore 8
    //   41: iload 8
    //   43: ifne +19 -> 62
    //   46: aload_2
    //   47: ifnull +9 -> 56
    //   50: aload_2
    //   51: invokeinterface 255 1 0
    //   56: aconst_null
    //   57: astore 5
    //   59: aload 5
    //   61: areturn
    //   62: aload_2
    //   63: aload_2
    //   64: ldc 14
    //   66: invokeinterface 259 2 0
    //   71: invokeinterface 263 2 0
    //   76: astore 9
    //   78: aload 9
    //   80: astore 5
    //   82: aload_2
    //   83: ifnull -24 -> 59
    //   86: aload_2
    //   87: invokeinterface 255 1 0
    //   92: goto -33 -> 59
    //   95: astore_3
    //   96: aconst_null
    //   97: astore_2
    //   98: new 265	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   105: ldc_w 268
    //   108: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_3
    //   112: invokevirtual 275	java/lang/Exception:toString	()Ljava/lang/String;
    //   115: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: pop
    //   122: aload_2
    //   123: ifnull +9 -> 132
    //   126: aload_2
    //   127: invokeinterface 255 1 0
    //   132: aconst_null
    //   133: astore 5
    //   135: goto -76 -> 59
    //   138: astore_1
    //   139: aconst_null
    //   140: astore_2
    //   141: aload_2
    //   142: ifnull +9 -> 151
    //   145: aload_2
    //   146: invokeinterface 255 1 0
    //   151: aload_1
    //   152: athrow
    //   153: astore_1
    //   154: goto -13 -> 141
    //   157: astore_3
    //   158: goto -60 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramContentResolver	android.content.ContentResolver
    //   138	14	1	localObject1	Object
    //   153	1	1	localObject2	Object
    //   28	118	2	localCursor1	android.database.Cursor
    //   95	17	3	localException1	Exception
    //   157	1	3	localException2	Exception
    //   57	77	5	localObject3	Object
    //   4	13	6	arrayOfString	String[]
    //   24	3	7	localCursor2	android.database.Cursor
    //   39	3	8	bool	boolean
    //   76	3	9	str	String
    // Exception table:
    //   from	to	target	type
    //   0	26	95	java/lang/Exception
    //   0	26	138	finally
    //   33	41	153	finally
    //   62	78	153	finally
    //   98	122	153	finally
    //   33	41	157	java/lang/Exception
    //   62	78	157	java/lang/Exception
  }
  
  public static String getClientToken()
  {
    return appClientToken;
  }
  
  public static Executor getExecutor()
  {
    synchronized (LOCK)
    {
      if (executor == null)
      {
        Object localObject3 = getAsyncTaskExecutor();
        if (localObject3 == null) {
          localObject3 = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, DEFAULT_WORK_QUEUE, DEFAULT_THREAD_FACTORY);
        }
        executor = (Executor)localObject3;
      }
      return executor;
    }
  }
  
  public static String getFacebookDomain()
  {
    return facebookDomain;
  }
  
  public static boolean getLimitEventAndDataUsage(Context paramContext)
  {
    return paramContext.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
  }
  
  public static final Set<LoggingBehavior> getLoggingBehaviors()
  {
    synchronized (loggingBehaviors)
    {
      Set localSet = Collections.unmodifiableSet(new HashSet(loggingBehaviors));
      return localSet;
    }
  }
  
  public static long getOnProgressThreshold()
  {
    return onProgressThreshold.get();
  }
  
  public static boolean getPlatformCompatibilityEnabled()
  {
    return platformCompatibilityEnabled;
  }
  
  public static String getSdkVersion()
  {
    return "3.23.1";
  }
  
  public static final boolean isDebugEnabled()
  {
    return isDebugEnabled;
  }
  
  public static final boolean isLoggingBehaviorEnabled(LoggingBehavior paramLoggingBehavior)
  {
    for (;;)
    {
      synchronized (loggingBehaviors)
      {
        if ((isDebugEnabled()) && (loggingBehaviors.contains(paramLoggingBehavior)))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  @Deprecated
  public static final boolean isLoggingEnabled()
  {
    return isDebugEnabled();
  }
  
  public static void loadDefaultsFromMetadata(Context paramContext)
  {
    defaultsLoaded = true;
    if (paramContext == null) {}
    for (;;)
    {
      return;
      try
      {
        ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
        if ((localApplicationInfo != null) && (localApplicationInfo.metaData != null))
        {
          if (applicationId == null) {
            applicationId = localApplicationInfo.metaData.getString("com.facebook.sdk.ApplicationId");
          }
          if (appClientToken == null) {
            appClientToken = localApplicationInfo.metaData.getString("com.facebook.sdk.ClientToken");
          }
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    }
  }
  
  static void loadDefaultsFromMetadataIfNeeded(Context paramContext)
  {
    if (!defaultsLoaded) {
      loadDefaultsFromMetadata(paramContext);
    }
  }
  
  static Response publishInstallAndWaitForResponse(Context paramContext, String paramString)
  {
    Response localResponse;
    if ((paramContext == null) || (paramString == null))
    {
      try
      {
        throw new IllegalArgumentException("Both context and applicationId must be non-null");
      }
      catch (Exception localException)
      {
        Utility.logd("Facebook-publish", localException);
        localResponse = new Response(null, null, new FacebookRequestError(null, localException));
      }
      return localResponse;
    }
    AttributionIdentifiers localAttributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(paramContext);
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
    String str1 = paramString + "ping";
    String str2 = paramString + "json";
    long l = localSharedPreferences.getLong(str1, 0L);
    String str3 = localSharedPreferences.getString(str2, null);
    GraphObject localGraphObject1 = GraphObject.Factory.create();
    localGraphObject1.setProperty("event", "MOBILE_APP_INSTALL");
    Utility.setAppEventAttributionParameters(localGraphObject1, localAttributionIdentifiers, AppEventsLogger.getAnonymousAppDeviceGUID(paramContext), getLimitEventAndDataUsage(paramContext));
    localGraphObject1.setProperty("application_package_name", paramContext.getPackageName());
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramString;
    Request localRequest = Request.newPostRequest(null, String.format("%s/activities", arrayOfObject), localGraphObject1, null);
    if ((l == 0L) || (str3 != null)) {}
    for (;;)
    {
      try
      {
        GraphObject localGraphObject4 = GraphObject.Factory.create(new JSONObject(str3));
        localGraphObject2 = localGraphObject4;
        localGraphObject3 = localGraphObject2;
      }
      catch (JSONException localJSONException)
      {
        GraphObject localGraphObject2;
        Request[] arrayOfRequest;
        SharedPreferences.Editor localEditor;
        GraphObject localGraphObject3 = null;
        continue;
      }
      if (localGraphObject3 == null)
      {
        arrayOfRequest = new Request[1];
        arrayOfRequest[0] = localRequest;
        localResponse = (Response)Response.createResponsesFromString("true", null, new RequestBatch(arrayOfRequest), true).get(0);
        break;
      }
      localResponse = new Response(null, null, null, localGraphObject3, true);
      break;
      localResponse = localRequest.executeAndWait();
      localEditor = localSharedPreferences.edit();
      localEditor.putLong(str1, System.currentTimeMillis());
      if ((localResponse.getGraphObject() != null) && (localResponse.getGraphObject().getInnerJSONObject() != null)) {
        localEditor.putString(str2, localResponse.getGraphObject().getInnerJSONObject().toString());
      }
      localEditor.apply();
      break;
      localGraphObject2 = null;
    }
  }
  
  static void publishInstallAsync(Context paramContext, String paramString, Request.Callback paramCallback)
  {
    Context localContext = paramContext.getApplicationContext();
    getExecutor().execute(new Settings.2(localContext, paramString, paramCallback));
  }
  
  public static final void removeLoggingBehavior(LoggingBehavior paramLoggingBehavior)
  {
    synchronized (loggingBehaviors)
    {
      loggingBehaviors.remove(paramLoggingBehavior);
      return;
    }
  }
  
  /* Error */
  public static void sdkInitialize(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 142	com/facebook/Settings:sdkInitialized	Ljava/lang/Boolean;
    //   6: invokevirtual 523	java/lang/Boolean:booleanValue	()Z
    //   9: istore_2
    //   10: iload_2
    //   11: iconst_1
    //   12: if_icmpne +7 -> 19
    //   15: ldc 2
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: invokestatic 525	com/facebook/Settings:loadDefaultsFromMetadataIfNeeded	(Landroid/content/Context;)V
    //   23: aload_0
    //   24: invokestatic 527	com/facebook/Settings:getApplicationId	()Ljava/lang/String;
    //   27: invokestatic 531	com/facebook/internal/Utility:loadAppSettingsAsync	(Landroid/content/Context;Ljava/lang/String;)V
    //   30: aload_0
    //   31: invokevirtual 505	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   34: invokestatic 536	com/facebook/BoltsMeasurementEventListener:getInstance	(Landroid/content/Context;)Lcom/facebook/BoltsMeasurementEventListener;
    //   37: pop
    //   38: iconst_1
    //   39: invokestatic 140	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   42: putstatic 142	com/facebook/Settings:sdkInitialized	Ljava/lang/Boolean;
    //   45: goto -30 -> 15
    //   48: astore_1
    //   49: ldc 2
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	paramContext	Context
    //   48	5	1	localObject	Object
    //   9	4	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	10	48	finally
    //   19	45	48	finally
  }
  
  public static void setAppVersion(String paramString)
  {
    appVersion = paramString;
  }
  
  public static void setApplicationId(String paramString)
  {
    applicationId = paramString;
  }
  
  public static void setClientToken(String paramString)
  {
    appClientToken = paramString;
  }
  
  public static void setExecutor(Executor paramExecutor)
  {
    Validate.notNull(paramExecutor, "executor");
    synchronized (LOCK)
    {
      executor = paramExecutor;
      return;
    }
  }
  
  public static void setFacebookDomain(String paramString)
  {
    facebookDomain = paramString;
  }
  
  public static final void setIsDebugEnabled(boolean paramBoolean)
  {
    isDebugEnabled = paramBoolean;
  }
  
  @Deprecated
  public static final void setIsLoggingEnabled(boolean paramBoolean)
  {
    setIsDebugEnabled(paramBoolean);
  }
  
  public static void setLimitEventAndDataUsage(Context paramContext, boolean paramBoolean)
  {
    paramContext.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putBoolean("limitEventUsage", paramBoolean).apply();
  }
  
  public static void setOnProgressThreshold(long paramLong)
  {
    onProgressThreshold.set(paramLong);
  }
  
  public static void setPlatformCompatibilityEnabled(boolean paramBoolean)
  {
    platformCompatibilityEnabled = paramBoolean;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.Settings
 * JD-Core Version:    0.7.0.1
 */