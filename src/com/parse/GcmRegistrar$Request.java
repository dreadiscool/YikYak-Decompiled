package com.parse;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import m;
import y;

class GcmRegistrar$Request
{
  private static final int BACKOFF_INTERVAL_MS = 3000;
  private static final int MAX_RETRIES = 5;
  private static final String RETRY_ACTION = "com.parse.RetryGcmRegistration";
  private final PendingIntent appIntent;
  private final Context context;
  private final int identifier;
  private final Random random;
  private final PendingIntent retryIntent;
  private final BroadcastReceiver retryReceiver;
  private final String senderId;
  private final m<String>.y tcs;
  private final AtomicInteger tries;
  
  private GcmRegistrar$Request(Context paramContext, String paramString)
  {
    this.context = paramContext;
    this.senderId = paramString;
    this.random = new Random();
    this.identifier = this.random.nextInt();
    this.tcs = m.a();
    this.appIntent = PendingIntent.getBroadcast(this.context, this.identifier, new Intent(), 0);
    this.tries = new AtomicInteger(0);
    String str = this.context.getPackageName();
    Intent localIntent = new Intent("com.parse.RetryGcmRegistration").setPackage(str);
    localIntent.addCategory(str);
    localIntent.putExtra("random", this.identifier);
    this.retryIntent = PendingIntent.getBroadcast(this.context, this.identifier, localIntent, 0);
    this.retryReceiver = new GcmRegistrar.Request.1(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.parse.RetryGcmRegistration");
    localIntentFilter.addCategory(str);
    paramContext.registerReceiver(this.retryReceiver, localIntentFilter);
  }
  
  public static Request createAndSend(Context paramContext, String paramString)
  {
    Request localRequest = new Request(paramContext, paramString);
    localRequest.send();
    return localRequest;
  }
  
  private void finish(String paramString1, String paramString2)
  {
    if (paramString1 != null) {}
    for (boolean bool = this.tcs.a(paramString1);; bool = this.tcs.a(new Exception("GCM registration error: " + paramString2)))
    {
      if (bool)
      {
        this.appIntent.cancel();
        this.retryIntent.cancel();
        this.context.unregisterReceiver(this.retryReceiver);
      }
      return;
    }
  }
  
  private void send()
  {
    Intent localIntent = new Intent("com.google.android.c2dm.intent.REGISTER");
    localIntent.setPackage("com.google.android.gsf");
    localIntent.putExtra("sender", this.senderId);
    localIntent.putExtra("app", this.appIntent);
    try
    {
      ComponentName localComponentName2 = this.context.startService(localIntent);
      localComponentName1 = localComponentName2;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        ComponentName localComponentName1 = null;
      }
    }
    if (localComponentName1 == null) {
      finish(null, "GSF_PACKAGE_NOT_AVAILABLE");
    }
    this.tries.incrementAndGet();
    Parse.logV("com.parse.GcmRegistrar", "Sending GCM registration intent");
  }
  
  public m<String> getTask()
  {
    return this.tcs.a();
  }
  
  public void onReceiveResponseIntent(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("registration_id");
    String str2 = paramIntent.getStringExtra("error");
    if ((str1 == null) && (str2 == null)) {
      Parse.logE("com.parse.GcmRegistrar", "Got no registration info in GCM onReceiveResponseIntent");
    }
    for (;;)
    {
      return;
      if (("SERVICE_NOT_AVAILABLE".equals(str2)) && (this.tries.get() < 5)) {
        ((AlarmManager)this.context.getSystemService("alarm")).set(2, 3000 * (1 << this.tries.get()) + this.random.nextInt(3000) + SystemClock.elapsedRealtime(), this.retryIntent);
      } else {
        finish(str1, str2);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.GcmRegistrar.Request
 * JD-Core Version:    0.7.0.1
 */