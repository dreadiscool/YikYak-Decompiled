package com.parse;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.IBinder;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import k;
import m;

public final class PushService
  extends Service
{
  static final String CANNOT_USE_PUSH_V1_ERROR_MESSAGE = "PushService.subscribe, PushService.unsubscribe, and PushService.setDefaultPushCallback methods cannot be used in conjunction with ParsePushBroadcastReceiver. See ParsePush.subscribe and ParsePush.unsubscribe.";
  private static final String START_IF_REQUIRED_ACTION = "com.parse.PushService.startIfRequired";
  private static final String TAG = "com.parse.PushService";
  private static final int WAKE_LOCK_TIMEOUT_MS = 20000;
  private static String host = "push.parse.com";
  private static PushService.LifecycleListener lifecycleListener = null;
  private static boolean loggedStartError;
  private static int port = 8253;
  private PushConnection connection;
  private ExecutorService executor;
  
  static
  {
    loggedStartError = false;
  }
  
  private static void checkManifestAndThrowExceptionIfNeeded()
  {
    if (ManifestInfo.getPushUsesBroadcastReceivers()) {
      throw new IllegalStateException("PushService.subscribe, PushService.unsubscribe, and PushService.setDefaultPushCallback methods cannot be used in conjunction with ParsePushBroadcastReceiver. See ParsePush.subscribe and ParsePush.unsubscribe.");
    }
  }
  
  @Deprecated
  public static Set<String> getSubscriptions(Context paramContext)
  {
    try
    {
      Set localSet = (Set)Parse.waitForTask(PushRouter.getSubscriptionsAsync(false));
      return localSet;
    }
    catch (ParseException localParseException)
    {
      throw new RuntimeException(localParseException);
    }
  }
  
  private int onGcmStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    this.executor.execute(new PushService.7(this, paramIntent, paramInt2));
    return 2;
  }
  
  private void onHandleGcmIntent(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (!GcmRegistrar.getInstance().isRegistrationIntent(paramIntent)) {
        break label22;
      }
      GcmRegistrar.getInstance().handleRegistrationIntent(paramIntent);
    }
    for (;;)
    {
      return;
      label22:
      if (PushRouter.isGcmPushIntent(paramIntent)) {
        PushRouter.handleGcmPushIntent(paramIntent);
      } else {
        Parse.logE("com.parse.PushService", "PushService got unknown intent in GCM mode: " + paramIntent);
      }
    }
  }
  
  private int onPpnsStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    PushConnection localPushConnection = this.connection;
    if ((paramIntent == null) || (paramIntent.getAction() == null) || (paramIntent.getAction().equals("com.parse.PushService.startIfRequired")))
    {
      Parse.logI("com.parse.PushService", "Received request to start service if required");
      k localk = new k();
      PushRouter.getForceEnabledStateAsync().d(new PushService.6(this, localk)).c(new PushService.5(this, localk, localPushConnection));
    }
    return 1;
  }
  
  static void runGcmIntentInService(Context paramContext, Intent paramIntent)
  {
    ServiceUtils.runWakefulIntentInService(paramContext, paramIntent, PushService.class, 20000L);
  }
  
  @Deprecated
  public static void setDefaultPushCallback(Context paramContext, Class<? extends Activity> paramClass)
  {
    setDefaultPushCallback(paramContext, paramClass, paramContext.getApplicationInfo().icon);
  }
  
  @Deprecated
  public static void setDefaultPushCallback(Context paramContext, Class<? extends Activity> paramClass, int paramInt)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("Must subscribe to channel with a valid icon identifier.");
    }
    if (paramClass == null) {
      unsubscribeInternal(null);
    }
    for (;;)
    {
      return;
      PushRouter.subscribeAsync(null, paramClass, paramInt).c(new PushService.4());
    }
  }
  
  static void setLifecycleListener(PushService.LifecycleListener paramLifecycleListener)
  {
    lifecycleListener = paramLifecycleListener;
  }
  
  private static void startPpnsServiceIfRequired(Context paramContext)
  {
    if (ManifestInfo.getPushType() == PushType.PPNS)
    {
      ParseInstallation localParseInstallation = ParseInstallation.getCurrentInstallation();
      if (localParseInstallation.getPushType() == PushType.GCM)
      {
        Parse.logW("com.parse.PushService", "Detected a client that used to use GCM and is now using PPNS.");
        localParseInstallation.removePushType();
        localParseInstallation.removeDeviceToken();
        localParseInstallation.saveEventually();
      }
      ServiceUtils.runIntentInService(paramContext, new Intent("com.parse.PushService.startIfRequired"), PushService.class);
    }
  }
  
  public static void startServiceIfRequired(Context paramContext)
  {
    switch (PushService.8.$SwitchMap$com$parse$PushType[ManifestInfo.getPushType().ordinal()])
    {
    default: 
      if (!loggedStartError)
      {
        Parse.logE("com.parse.PushService", "Tried to use push, but this app is not configured for push due to: " + ManifestInfo.getNonePushTypeLogMessage());
        loggedStartError = true;
      }
      break;
    }
    for (;;)
    {
      return;
      startPpnsServiceIfRequired(paramContext);
      continue;
      GcmRegistrar.getInstance().register();
    }
  }
  
  static void stopPpnsService(Context paramContext)
  {
    if (ManifestInfo.getPushType() == PushType.PPNS) {
      paramContext.stopService(new Intent(paramContext, PushService.class));
    }
  }
  
  @Deprecated
  public static void subscribe(Context paramContext, String paramString, Class<? extends Activity> paramClass)
  {
    subscribe(paramContext, paramString, paramClass, paramContext.getApplicationInfo().icon);
  }
  
  @Deprecated
  public static void subscribe(Context paramContext, String paramString, Class<? extends Activity> paramClass, int paramInt)
  {
    try
    {
      checkManifestAndThrowExceptionIfNeeded();
      if (paramString == null) {
        throw new IllegalArgumentException("Can't subscribe to null channel.");
      }
    }
    finally {}
    PushRouter.subscribeAsync(paramString, paramClass, paramInt).c(new PushService.1());
  }
  
  @Deprecated
  public static void unsubscribe(Context paramContext, String paramString)
  {
    if (paramString == null) {
      try
      {
        throw new IllegalArgumentException("Can't unsubscribe from null channel.");
      }
      finally {}
    }
    unsubscribeInternal(paramString);
  }
  
  private static void unsubscribeInternal(String paramString)
  {
    checkManifestAndThrowExceptionIfNeeded();
    PushRouter.unsubscribeAsync(paramString).d(new PushService.3()).c(new PushService.2());
  }
  
  static void useServer(String paramString, int paramInt)
  {
    host = paramString;
    port = paramInt;
  }
  
  private void wipeRoutingAndUpgradePushStateIfNeeded()
  {
    if (ManifestInfo.getPushUsesBroadcastReceivers()) {
      PushRouter.wipeRoutingAndUpgradePushStateAsync();
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    throw new IllegalArgumentException("You cannot bind directly to the PushService. Use PushService.subscribe instead.");
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (Parse.applicationContext == null)
    {
      Parse.logE("com.parse.PushService", "The Parse push service cannot start because Parse.initialize has not yet been called. If you call Parse.initialize from an Activity's onCreate, that call should instead be in the Application.onCreate. Be sure your Application class is registered in your AndroidManifest.xml with the android:name property of your <application> tag.");
      stopSelf();
      return;
    }
    switch (PushService.8.$SwitchMap$com$parse$PushType[ManifestInfo.getPushType().ordinal()])
    {
    default: 
      Parse.logE("com.parse.PushService", "PushService somehow started even though this device doesn't support push.");
    }
    while (lifecycleListener != null)
    {
      lifecycleListener.onServiceCreated(this);
      break;
      this.connection = new PushConnection(this, host, port);
      continue;
      this.executor = Executors.newSingleThreadExecutor();
    }
  }
  
  public void onDestroy()
  {
    if (this.connection != null) {
      this.connection.stop();
    }
    if (this.executor != null) {
      this.executor.shutdown();
    }
    if (lifecycleListener != null) {
      lifecycleListener.onServiceDestroyed(this);
    }
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    wipeRoutingAndUpgradePushStateIfNeeded();
    int i;
    switch (PushService.8.$SwitchMap$com$parse$PushType[ManifestInfo.getPushType().ordinal()])
    {
    default: 
      Parse.logE("com.parse.PushService", "Started push service even though no push service is enabled: " + paramIntent);
      ServiceUtils.completeWakefulIntent(paramIntent);
      i = 2;
    }
    for (;;)
    {
      return i;
      i = onPpnsStartCommand(paramIntent, paramInt1, paramInt2);
      continue;
      i = onGcmStartCommand(paramIntent, paramInt1, paramInt2);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushService
 * JD-Core Version:    0.7.0.1
 */