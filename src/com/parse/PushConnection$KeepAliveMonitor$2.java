package com.parse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import m;

class PushConnection$KeepAliveMonitor$2
  extends BroadcastReceiver
{
  PushConnection$KeepAliveMonitor$2(PushConnection.KeepAliveMonitor paramKeepAliveMonitor, Context paramContext, Intent paramIntent) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ParseWakeLock localParseWakeLock = ParseWakeLock.acquireNewWakeLock(PushConnection.access$1000(this.this$1.this$0), 1, "push-keep-alive", 20000L);
    if (PushConnection.KeepAliveMonitor.access$1300(this.this$1) == null) {
      PushConnection.KeepAliveMonitor.access$1302(this.this$1, m.a(null).j());
    }
    PushConnection.KeepAliveMonitor.access$1302(this.this$1, PushConnection.KeepAliveMonitor.access$1300(this.this$1).a(new PushConnection.KeepAliveMonitor.2.1(this, localParseWakeLock), ParseCommand.NETWORK_EXECUTOR));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushConnection.KeepAliveMonitor.2
 * JD-Core Version:    0.7.0.1
 */