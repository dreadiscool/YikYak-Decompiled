package com.parse;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import java.net.Socket;
import m;

class PushConnection$KeepAliveMonitor
{
  private PendingIntent broadcast;
  private final long interval;
  private m<Void> keepAliveTask;
  private AlarmManager manager;
  private BroadcastReceiver readReceiver;
  private final Socket socket;
  private boolean unregistered;
  private BroadcastReceiver writeReceiver;
  
  public PushConnection$KeepAliveMonitor(PushConnection paramPushConnection, Socket paramSocket, long paramLong)
  {
    this.socket = paramSocket;
    this.interval = paramLong;
  }
  
  private void signalKeepAliveFailure()
  {
    try
    {
      if (!this.unregistered) {
        PushConnection.access$300(this.this$0).signalEvent(PushConnection.Event.KEEP_ALIVE_ERROR);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void register()
  {
    Context localContext = Parse.applicationContext;
    String str = localContext.getPackageName();
    Intent localIntent1 = new Intent("com.parse.PushConnection.readKeepAlive");
    localIntent1.setPackage(str);
    localIntent1.addCategory(str);
    Intent localIntent2 = new Intent("com.parse.PushConnection.writeKeepAlive");
    localIntent2.setPackage(str);
    localIntent2.addCategory(str);
    this.manager = ((AlarmManager)localContext.getSystemService("alarm"));
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(localContext, 0, localIntent1, 0);
    if (localPendingIntent != null)
    {
      this.manager.cancel(localPendingIntent);
      localPendingIntent.cancel();
    }
    for (;;)
    {
      this.broadcast = PendingIntent.getBroadcast(localContext, 0, localIntent2, 0);
      this.manager.cancel(this.broadcast);
      long l = SystemClock.elapsedRealtime();
      this.manager.setInexactRepeating(2, l, this.interval, this.broadcast);
      this.readReceiver = new PushConnection.KeepAliveMonitor.1(this);
      this.writeReceiver = new PushConnection.KeepAliveMonitor.2(this, localContext, localIntent1);
      IntentFilter localIntentFilter1 = new IntentFilter("com.parse.PushConnection.readKeepAlive");
      localIntentFilter1.addCategory(str);
      localContext.registerReceiver(this.readReceiver, localIntentFilter1);
      IntentFilter localIntentFilter2 = new IntentFilter("com.parse.PushConnection.writeKeepAlive");
      localIntentFilter2.addCategory(str);
      localContext.registerReceiver(this.writeReceiver, localIntentFilter2);
      return;
      Parse.logE("com.parse.PushConnection", "oldReadBroadcast was null");
    }
  }
  
  public void unregister()
  {
    Parse.applicationContext.unregisterReceiver(this.readReceiver);
    Parse.applicationContext.unregisterReceiver(this.writeReceiver);
    this.manager.cancel(this.broadcast);
    this.broadcast.cancel();
    try
    {
      this.unregistered = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushConnection.KeepAliveMonitor
 * JD-Core Version:    0.7.0.1
 */