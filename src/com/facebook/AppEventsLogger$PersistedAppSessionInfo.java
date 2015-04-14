package com.facebook;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class AppEventsLogger$PersistedAppSessionInfo
{
  private static final String PERSISTED_SESSION_INFO_FILENAME = "AppEventsLogger.persistedsessioninfo";
  private static final Runnable appSessionInfoFlushRunnable = new AppEventsLogger.PersistedAppSessionInfo.1();
  private static Map<AppEventsLogger.AccessTokenAppIdPair, FacebookTimeSpentData> appSessionInfoMap;
  private static boolean hasChanges;
  private static boolean isLoaded;
  private static final Object staticLock = new Object();
  
  static
  {
    hasChanges = false;
    isLoaded = false;
  }
  
  private static FacebookTimeSpentData getTimeSpentData(Context paramContext, AppEventsLogger.AccessTokenAppIdPair paramAccessTokenAppIdPair)
  {
    restoreAppSessionInformation(paramContext);
    FacebookTimeSpentData localFacebookTimeSpentData = (FacebookTimeSpentData)appSessionInfoMap.get(paramAccessTokenAppIdPair);
    if (localFacebookTimeSpentData == null)
    {
      localFacebookTimeSpentData = new FacebookTimeSpentData();
      appSessionInfoMap.put(paramAccessTokenAppIdPair, localFacebookTimeSpentData);
    }
    return localFacebookTimeSpentData;
  }
  
  static void onResume(Context paramContext, AppEventsLogger.AccessTokenAppIdPair paramAccessTokenAppIdPair, AppEventsLogger paramAppEventsLogger, long paramLong, String paramString)
  {
    synchronized (staticLock)
    {
      getTimeSpentData(paramContext, paramAccessTokenAppIdPair).onResume(paramAppEventsLogger, paramLong, paramString);
      onTimeSpentDataUpdate();
      return;
    }
  }
  
  static void onSuspend(Context paramContext, AppEventsLogger.AccessTokenAppIdPair paramAccessTokenAppIdPair, AppEventsLogger paramAppEventsLogger, long paramLong)
  {
    synchronized (staticLock)
    {
      getTimeSpentData(paramContext, paramAccessTokenAppIdPair).onSuspend(paramAppEventsLogger, paramLong);
      onTimeSpentDataUpdate();
      return;
    }
  }
  
  private static void onTimeSpentDataUpdate()
  {
    if (!hasChanges)
    {
      hasChanges = true;
      AppEventsLogger.access$1400().schedule(appSessionInfoFlushRunnable, 30L, TimeUnit.SECONDS);
    }
  }
  
  /* Error */
  private static void restoreAppSessionInformation(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: getstatic 25	com/facebook/AppEventsLogger$PersistedAppSessionInfo:staticLock	Ljava/lang/Object;
    //   5: astore_2
    //   6: aload_2
    //   7: monitorenter
    //   8: getstatic 29	com/facebook/AppEventsLogger$PersistedAppSessionInfo:isLoaded	Z
    //   11: istore 4
    //   13: iload 4
    //   15: ifne +75 -> 90
    //   18: new 96	java/io/ObjectInputStream
    //   21: dup
    //   22: aload_0
    //   23: ldc 8
    //   25: invokevirtual 102	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   28: invokespecial 105	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   31: astore 5
    //   33: aload 5
    //   35: invokevirtual 109	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   38: checkcast 111	java/util/HashMap
    //   41: putstatic 42	com/facebook/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
    //   44: getstatic 117	com/facebook/LoggingBehavior:APP_EVENTS	Lcom/facebook/LoggingBehavior;
    //   47: ldc 119
    //   49: ldc 121
    //   51: invokestatic 127	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload 5
    //   56: invokestatic 133	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   59: aload_0
    //   60: ldc 8
    //   62: invokevirtual 137	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   65: pop
    //   66: getstatic 42	com/facebook/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
    //   69: ifnonnull +13 -> 82
    //   72: new 111	java/util/HashMap
    //   75: dup
    //   76: invokespecial 138	java/util/HashMap:<init>	()V
    //   79: putstatic 42	com/facebook/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
    //   82: iconst_1
    //   83: putstatic 29	com/facebook/AppEventsLogger$PersistedAppSessionInfo:isLoaded	Z
    //   86: iconst_0
    //   87: putstatic 27	com/facebook/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
    //   90: aload_2
    //   91: monitorexit
    //   92: return
    //   93: aload_1
    //   94: invokestatic 133	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   97: aload_0
    //   98: ldc 8
    //   100: invokevirtual 137	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   103: pop
    //   104: getstatic 42	com/facebook/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
    //   107: ifnonnull +13 -> 120
    //   110: new 111	java/util/HashMap
    //   113: dup
    //   114: invokespecial 138	java/util/HashMap:<init>	()V
    //   117: putstatic 42	com/facebook/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
    //   120: iconst_1
    //   121: putstatic 29	com/facebook/AppEventsLogger$PersistedAppSessionInfo:isLoaded	Z
    //   124: iconst_0
    //   125: putstatic 27	com/facebook/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
    //   128: goto -38 -> 90
    //   131: astore_3
    //   132: aload_2
    //   133: monitorexit
    //   134: aload_3
    //   135: athrow
    //   136: astore 16
    //   138: aconst_null
    //   139: astore 5
    //   141: aload 16
    //   143: astore 8
    //   145: invokestatic 142	com/facebook/AppEventsLogger:access$1300	()Ljava/lang/String;
    //   148: pop
    //   149: new 144	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   156: ldc 147
    //   158: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload 8
    //   163: invokevirtual 154	java/lang/Exception:toString	()Ljava/lang/String;
    //   166: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: pop
    //   173: aload 5
    //   175: invokestatic 133	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   178: aload_0
    //   179: ldc 8
    //   181: invokevirtual 137	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   184: pop
    //   185: getstatic 42	com/facebook/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
    //   188: ifnonnull +13 -> 201
    //   191: new 111	java/util/HashMap
    //   194: dup
    //   195: invokespecial 138	java/util/HashMap:<init>	()V
    //   198: putstatic 42	com/facebook/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
    //   201: iconst_1
    //   202: putstatic 29	com/facebook/AppEventsLogger$PersistedAppSessionInfo:isLoaded	Z
    //   205: iconst_0
    //   206: putstatic 27	com/facebook/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
    //   209: goto -119 -> 90
    //   212: aload 5
    //   214: invokestatic 133	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   217: aload_0
    //   218: ldc 8
    //   220: invokevirtual 137	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   223: pop
    //   224: getstatic 42	com/facebook/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
    //   227: ifnonnull +13 -> 240
    //   230: new 111	java/util/HashMap
    //   233: dup
    //   234: invokespecial 138	java/util/HashMap:<init>	()V
    //   237: putstatic 42	com/facebook/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
    //   240: iconst_1
    //   241: putstatic 29	com/facebook/AppEventsLogger$PersistedAppSessionInfo:isLoaded	Z
    //   244: iconst_0
    //   245: putstatic 27	com/facebook/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
    //   248: aload 9
    //   250: athrow
    //   251: astore 9
    //   253: goto -41 -> 212
    //   256: astore 8
    //   258: goto -113 -> 145
    //   261: astore 6
    //   263: aload 5
    //   265: astore_1
    //   266: goto -173 -> 93
    //   269: astore 17
    //   271: goto -178 -> 93
    //   274: astore 15
    //   276: aconst_null
    //   277: astore 5
    //   279: aload 15
    //   281: astore 9
    //   283: goto -71 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	paramContext	Context
    //   1	265	1	localObject1	Object
    //   5	128	2	localObject2	Object
    //   131	4	3	localObject3	Object
    //   11	3	4	bool	boolean
    //   31	247	5	localObjectInputStream	java.io.ObjectInputStream
    //   261	1	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   143	19	8	localException1	java.lang.Exception
    //   256	1	8	localException2	java.lang.Exception
    //   248	1	9	localObject4	Object
    //   251	1	9	localObject5	Object
    //   281	1	9	localObject6	Object
    //   274	6	15	localObject7	Object
    //   136	6	16	localException3	java.lang.Exception
    //   269	1	17	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   8	13	131	finally
    //   54	134	131	finally
    //   173	251	131	finally
    //   18	33	136	java/lang/Exception
    //   33	54	251	finally
    //   145	173	251	finally
    //   33	54	256	java/lang/Exception
    //   33	54	261	java/io/FileNotFoundException
    //   18	33	269	java/io/FileNotFoundException
    //   18	33	274	finally
  }
  
  /* Error */
  static void saveAppSessionInformation(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 25	com/facebook/AppEventsLogger$PersistedAppSessionInfo:staticLock	Ljava/lang/Object;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: getstatic 27	com/facebook/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
    //   9: istore_3
    //   10: iload_3
    //   11: ifeq +53 -> 64
    //   14: new 158	java/io/ObjectOutputStream
    //   17: dup
    //   18: new 160	java/io/BufferedOutputStream
    //   21: dup
    //   22: aload_0
    //   23: ldc 8
    //   25: iconst_0
    //   26: invokevirtual 164	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   29: invokespecial 167	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: invokespecial 168	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   35: astore 4
    //   37: aload 4
    //   39: getstatic 42	com/facebook/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
    //   42: invokevirtual 172	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   45: iconst_0
    //   46: putstatic 27	com/facebook/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
    //   49: getstatic 117	com/facebook/LoggingBehavior:APP_EVENTS	Lcom/facebook/LoggingBehavior;
    //   52: ldc 119
    //   54: ldc 174
    //   56: invokestatic 127	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload 4
    //   61: invokestatic 133	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   64: aload_1
    //   65: monitorexit
    //   66: return
    //   67: astore 5
    //   69: aconst_null
    //   70: astore 4
    //   72: invokestatic 142	com/facebook/AppEventsLogger:access$1300	()Ljava/lang/String;
    //   75: pop
    //   76: new 144	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   83: ldc 147
    //   85: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload 5
    //   90: invokevirtual 154	java/lang/Exception:toString	()Ljava/lang/String;
    //   93: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: pop
    //   100: aload 4
    //   102: invokestatic 133	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   105: goto -41 -> 64
    //   108: astore_2
    //   109: aload_1
    //   110: monitorexit
    //   111: aload_2
    //   112: athrow
    //   113: astore 6
    //   115: aconst_null
    //   116: astore 4
    //   118: aload 4
    //   120: invokestatic 133	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   123: aload 6
    //   125: athrow
    //   126: astore 6
    //   128: goto -10 -> 118
    //   131: astore 5
    //   133: goto -61 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramContext	Context
    //   3	107	1	localObject1	Object
    //   108	4	2	localObject2	Object
    //   9	2	3	bool	boolean
    //   35	84	4	localObjectOutputStream	java.io.ObjectOutputStream
    //   67	22	5	localException1	java.lang.Exception
    //   131	1	5	localException2	java.lang.Exception
    //   113	11	6	localObject3	Object
    //   126	1	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   14	37	67	java/lang/Exception
    //   6	10	108	finally
    //   59	66	108	finally
    //   100	111	108	finally
    //   118	126	108	finally
    //   14	37	113	finally
    //   37	59	126	finally
    //   72	100	126	finally
    //   37	59	131	java/lang/Exception
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.AppEventsLogger.PersistedAppSessionInfo
 * JD-Core Version:    0.7.0.1
 */