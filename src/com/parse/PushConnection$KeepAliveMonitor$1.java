package com.parse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicLong;

class PushConnection$KeepAliveMonitor$1
  extends BroadcastReceiver
{
  PushConnection$KeepAliveMonitor$1(PushConnection.KeepAliveMonitor paramKeepAliveMonitor) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    long l = SystemClock.elapsedRealtime() - PushConnection.access$1100(this.this$1.this$0).get();
    if (l > 2L * PushConnection.KEEP_ALIVE_ACK_INTERVAL)
    {
      Parse.logV("com.parse.PushConnection", "Keep alive failure: last read was " + l + " ms ago.");
      PushConnection.KeepAliveMonitor.access$1200(this.this$1);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushConnection.KeepAliveMonitor.1
 * JD-Core Version:    0.7.0.1
 */