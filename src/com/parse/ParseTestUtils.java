package com.parse;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import m;
import org.json.JSONObject;

class ParseTestUtils
{
  private static final String TAG = "com.parse.ParseTestUtils";
  private static final Object TEST_SERVER_LOCK = new Object();
  private static volatile Semaphore awaitStartSemaphore;
  private static volatile Semaphore awaitStopSemaphore;
  private static ParseTestUtils.PushRoutedListener globalListener;
  private static ParseTestUtils.StateTransitionListener listener;
  static final AtomicBoolean strictModeEnabled = new AtomicBoolean(false);
  private static Synchronizer synchronizer;
  private static String testServer;
  private static int totalBroadcastReceiverInvocations = 0;
  
  public static void assertFinishes()
  {
    synchronizer.assertFinishes();
  }
  
  public static boolean awaitConnectionStarted()
  {
    return awaitStartSemaphore.tryAcquire(5L, TimeUnit.SECONDS);
  }
  
  public static boolean awaitConnectionStopped()
  {
    if (awaitStopSemaphore == null) {
      awaitStopSemaphore = new Semaphore(0);
    }
    return awaitStopSemaphore.tryAcquire(5L, TimeUnit.SECONDS);
  }
  
  public static void clearApp()
  {
    ParseCommand localParseCommand = new ParseCommand("clear_app", null);
    try
    {
      Parse.waitForTask(localParseCommand.executeAsync());
      return;
    }
    catch (ParseException localParseException)
    {
      throw new RuntimeException(localParseException.getMessage());
    }
  }
  
  public static void clearCurrentInstallationFromMemory()
  {
    ParseInstallation.currentInstallation = null;
  }
  
  public static void clearFiles()
  {
    recursiveDelete(Parse.getParseDir());
    recursiveDelete(Parse.getKeyValueCacheDir());
    if (Parse.eventuallyQueue != null)
    {
      Parse.eventuallyQueue.pause();
      Parse.eventuallyQueue = null;
    }
  }
  
  public static int commandCacheUnexpectedEvents()
  {
    return Parse.getEventuallyQueue().getTestHelper().unexpectedEvents();
  }
  
  public static void deleteCurrentInstallation()
  {
    try
    {
      ParseInstallation.getCurrentInstallation().delete();
      label6:
      return;
    }
    catch (ParseException localParseException)
    {
      break label6;
    }
  }
  
  public static void disconnectCommandCache()
  {
    Parse.getEventuallyQueue().setConnected(false);
  }
  
  public static void finish()
  {
    synchronizer.finish();
  }
  
  public static String getInstallationId(Context paramContext)
  {
    return ParseInstallation.getCurrentInstallation().getInstallationId();
  }
  
  public static ParseObject getObjectFromDisk(Context paramContext, String paramString)
  {
    return ParseObject.getFromDisk(paramContext, paramString);
  }
  
  static File getParseDir(Context paramContext)
  {
    return paramContext.getDir("Parse", 0);
  }
  
  public static List<Long> getPushConnectionRetryDelays()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getPushConnectionStateTransitions().iterator();
    while (localIterator.hasNext())
    {
      ParseTestUtils.StateTransition localStateTransition = (ParseTestUtils.StateTransition)localIterator.next();
      if ((localStateTransition.fromState instanceof PushConnection.WaitRetryState)) {
        localArrayList.add(Long.valueOf(((PushConnection.WaitRetryState)localStateTransition.fromState).getDelay()));
      }
    }
    return localArrayList;
  }
  
  public static List<ParseTestUtils.StateTransition> getPushConnectionStateTransitions()
  {
    return listener.getTransitions();
  }
  
  public static JSONObject getPushRequestJSON()
  {
    m localm = PushRouter.getPushRequestJSONAsync();
    try
    {
      localm.g();
      localJSONObject = (JSONObject)localm.e();
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        JSONObject localJSONObject = null;
      }
    }
    return localJSONObject;
  }
  
  public static JSONObject getSerializedPushStateJSON()
  {
    return Parse.getDiskObject(Parse.applicationContext, "pushState");
  }
  
  public static String getTestServer(Context paramContext)
  {
    if (testServer == null) {}
    for (;;)
    {
      synchronized (TEST_SERVER_LOCK)
      {
        String str = testServer;
        if (str == null) {}
        try
        {
          testServer = new BufferedReader(new InputStreamReader(paramContext.getAssets().open("server.config"))).readLine();
          return testServer;
        }
        catch (Exception localException)
        {
          if (!Build.PRODUCT.contains("vbox")) {
            break label84;
          }
        }
        testServer = "http://192.168.56.1:3000";
      }
      label84:
      if ((Build.PRODUCT.contains("sdk")) || (Build.PRODUCT.contains("full_x86"))) {
        testServer = "http://10.0.2.2:3000";
      } else {
        testServer = "http://localhost:3000";
      }
    }
  }
  
  public static ParseUser getUserObjectFromDisk(Context paramContext, String paramString)
  {
    return (ParseUser)ParseObject.getFromDisk(paramContext, paramString);
  }
  
  public static void initSynchronizer()
  {
    synchronizer = new Synchronizer();
  }
  
  public static Set<String> keySet(ParseObject paramParseObject)
  {
    return paramParseObject.keySet();
  }
  
  public static ServerSocket mockPushServer()
  {
    try
    {
      ServerSocket localServerSocket = new ServerSocket(0);
      InetSocketAddress localInetSocketAddress = (InetSocketAddress)localServerSocket.getLocalSocketAddress();
      PushService.useServer(localInetSocketAddress.getHostName(), localInetSocketAddress.getPort());
      Parse.logI("com.parse.ParseTestUtils", "running mockPushServer on port " + localInetSocketAddress);
      return localServerSocket;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException.getMessage());
    }
  }
  
  public static void mockV8Client()
  {
    ParseCommand localParseCommand = new ParseCommand("mock_v8_client", null);
    try
    {
      Parse.waitForTask(localParseCommand.executeAsync());
      return;
    }
    catch (ParseException localParseException)
    {
      throw new RuntimeException(localParseException);
    }
  }
  
  public static int numKeyValueCacheFiles()
  {
    return Parse.getKeyValueCacheDir().listFiles().length;
  }
  
  public static Set<String> pushRoutes(Context paramContext)
  {
    m localm = PushRouter.getSubscriptionsAsync(false);
    try
    {
      localm.g();
      label9:
      return (Set)localm.e();
    }
    catch (InterruptedException localInterruptedException)
    {
      break label9;
    }
  }
  
  public static void reconnectCommandCache()
  {
    Parse.getEventuallyQueue().setConnected(true);
  }
  
  public static void recursiveDelete(File paramFile)
  {
    if (!paramFile.exists()) {}
    for (;;)
    {
      return;
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        int i = arrayOfFile.length;
        for (int j = 0; j < i; j++) {
          recursiveDelete(arrayOfFile[j]);
        }
      }
      paramFile.delete();
    }
  }
  
  public static void reloadPushRouter()
  {
    PushRouter.reloadFromDiskAsync(false);
  }
  
  public static void resetAwaitConnectionStarted()
  {
    awaitStartSemaphore = new Semaphore(0);
  }
  
  public static void resetAwaitConnectionStopped()
  {
    awaitStopSemaphore = new Semaphore(0);
  }
  
  public static void resetCommandCache()
  {
    ParseEventuallyQueue localParseEventuallyQueue = Parse.getEventuallyQueue();
    ParseEventuallyQueue.TestHelper localTestHelper = localParseEventuallyQueue.getTestHelper();
    localParseEventuallyQueue.clear();
    localTestHelper.clear();
  }
  
  public static void saveObjectToDisk(ParseObject paramParseObject, Context paramContext, String paramString)
  {
    paramParseObject.saveToDisk(paramContext, paramString);
  }
  
  public static void saveStringToDisk(String paramString1, Context paramContext, String paramString2)
  {
    File localFile = new File(getParseDir(paramContext), paramString2);
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
      localFileOutputStream.write(paramString1.getBytes("UTF-8"));
      localFileOutputStream.close();
      label40:
      return;
    }
    catch (IOException localIOException)
    {
      break label40;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label40;
    }
  }
  
  public static void setCommandInitialDelay(long paramLong)
  {
    ParseCommand.setDefaultInitialRetryDelay(paramLong);
  }
  
  public static void setMaxKeyValueCacheBytes(int paramInt)
  {
    Parse.maxKeyValueCacheBytes = paramInt;
  }
  
  public static void setMaxKeyValueCacheFiles(int paramInt)
  {
    Parse.maxKeyValueCacheFiles = paramInt;
  }
  
  public static int setPushHistoryLength(int paramInt)
  {
    int i = PushRouter.MAX_HISTORY_LENGTH;
    PushRouter.MAX_HISTORY_LENGTH = paramInt;
    return i;
  }
  
  public static void setPushRoutedListener(ParseTestUtils.PushRoutedListener paramPushRoutedListener)
  {
    try
    {
      globalListener = paramPushRoutedListener;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void setRetryDelayEnabled(boolean paramBoolean)
  {
    PushConnection.ENABLE_RETRY_DELAY = paramBoolean;
  }
  
  public static void setStrictModeEnabledForMainThread(boolean paramBoolean)
  {
    AtomicBoolean localAtomicBoolean = strictModeEnabled;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      if (localAtomicBoolean.compareAndSet(bool, paramBoolean))
      {
        Semaphore localSemaphore = new Semaphore(0);
        new Handler(Looper.getMainLooper()).post(new ParseTestUtils.2(paramBoolean, localSemaphore));
        localSemaphore.acquireUninterruptibly();
      }
      return;
    }
  }
  
  public static void setStrictModeEnabledForThisThread(boolean paramBoolean)
  {
    try
    {
      ClassLoader localClassLoader = Thread.currentThread().getContextClassLoader();
      Class localClass1 = Class.forName("android.os.StrictMode", true, localClassLoader);
      if (paramBoolean)
      {
        Class localClass2 = Class.forName("android.os.StrictMode$ThreadPolicy", true, localClassLoader);
        Class localClass3 = Class.forName("android.os.StrictMode$ThreadPolicy$Builder", true, localClassLoader);
        Object localObject1 = localClass3.getConstructor(new Class[0]).newInstance(new Object[0]);
        Object localObject2 = localClass3.getMethod("detectNetwork", new Class[0]).invoke(localObject1, new Object[0]);
        Object localObject3 = localClass3.getMethod("penaltyDeath", new Class[0]).invoke(localObject2, new Object[0]);
        Object localObject4 = localClass3.getMethod("build", new Class[0]).invoke(localObject3, new Object[0]);
        Class[] arrayOfClass = new Class[1];
        arrayOfClass[0] = localClass2;
        Method localMethod = localClass1.getMethod("setThreadPolicy", arrayOfClass);
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = localObject4;
        localMethod.invoke(localClass1, arrayOfObject);
      }
      else
      {
        localClass1.getMethod("enableDefaults", new Class[0]).invoke(localClass1, new Object[0]);
      }
    }
    catch (Exception localException) {}
  }
  
  public static void setTestServer(String paramString)
  {
    synchronized (TEST_SERVER_LOCK)
    {
      testServer = paramString;
      return;
    }
  }
  
  public static void setUpPushTest(Context paramContext)
  {
    ManifestInfo.setPushType(PushType.PPNS);
    awaitStartSemaphore = null;
    awaitStopSemaphore = null;
    listener = new ParseTestUtils.StateTransitionListener();
    PushConnection.setStateTransitionListener(listener);
    ParseNotificationManager.getInstance().setShouldShowNotifications(false);
    useTestServer(paramContext);
    ParseInstallation.clearCurrentInstallationFromDisk(paramContext);
    PushRouter.reloadFromDiskAsync(true);
    initSynchronizer();
    totalBroadcastReceiverInvocations = 0;
    PushRouter.setGlobalPushListener(new ParseTestUtils.1());
  }
  
  public static void start(int paramInt)
  {
    synchronizer.start(paramInt);
  }
  
  public static void startServiceIfRequired(Context paramContext)
  {
    PushService.startServiceIfRequired(paramContext);
  }
  
  public static void tearDownPushTest(Context paramContext)
  {
    PushConnection.setStateTransitionListener(null);
    PushConnection.KEEP_ALIVE_INTERVAL = 900000L;
    PushConnection.ENABLE_RETRY_DELAY = true;
    ParseNotificationManager.getInstance().setShouldShowNotifications(true);
    clearFiles();
    ParseInstallation.clearCurrentInstallationFromDisk(paramContext);
    PushRouter.reloadFromDiskAsync(true);
    setPushRoutedListener(null);
    awaitStartSemaphore = null;
    awaitStopSemaphore = null;
  }
  
  public static int totalBroadcastReceiverInvocations()
  {
    return totalBroadcastReceiverInvocations;
  }
  
  public static void unmockV8Client()
  {
    ParseCommand localParseCommand = new ParseCommand("unmock_v8_client", null);
    try
    {
      Parse.waitForTask(localParseCommand.executeAsync());
      return;
    }
    catch (ParseException localParseException)
    {
      throw new RuntimeException(localParseException);
    }
  }
  
  public static String useBadServerPort()
  {
    return useBadServerPort(ParseObject.server);
  }
  
  public static String useBadServerPort(String paramString)
  {
    Object localObject = "http://10.0.2.2:6000";
    try
    {
      URL localURL = new URL(paramString);
      String str = localURL.getProtocol() + "://" + localURL.getHost() + ":" + (999 + localURL.getPort());
      localObject = str;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      label65:
      break label65;
    }
    return useServer((String)localObject);
  }
  
  public static void useDevPushServer()
  {
    PushService.useServer("10.0.2.2", 8253);
  }
  
  public static String useInvalidServer()
  {
    return useServer("http://invalid.server:3000");
  }
  
  public static String useServer(String paramString)
  {
    String str = ParseObject.server;
    ParseObject.server = paramString;
    return str;
  }
  
  public static String useTestServer(Context paramContext)
  {
    return useServer(getTestServer(paramContext));
  }
  
  public static boolean waitForCommandCacheEnqueue()
  {
    return Parse.getEventuallyQueue().getTestHelper().waitFor(3);
  }
  
  public static boolean waitForCommandCacheFailure()
  {
    return Parse.getEventuallyQueue().getTestHelper().waitFor(2);
  }
  
  public static boolean waitForCommandCacheSuccess()
  {
    int i = 1;
    if ((Parse.getEventuallyQueue().getTestHelper().waitFor(i)) && (Parse.getEventuallyQueue().getTestHelper().waitFor(5))) {}
    for (;;)
    {
      return i;
      int j = 0;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseTestUtils
 * JD-Core Version:    0.7.0.1
 */