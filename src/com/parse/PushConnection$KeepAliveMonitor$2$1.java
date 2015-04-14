package com.parse;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicLong;
import l;
import m;

class PushConnection$KeepAliveMonitor$2$1
  implements l<Void, Void>
{
  PushConnection$KeepAliveMonitor$2$1(PushConnection.KeepAliveMonitor.2 param2, ParseWakeLock paramParseWakeLock) {}
  
  public Void then(m<Void> paramm)
  {
    int i = 0;
    if (!PushConnection.access$700(PushConnection.KeepAliveMonitor.access$1400(this.this$2.this$1), "{}")) {
      PushConnection.KeepAliveMonitor.access$1200(this.this$2.this$1);
    }
    if (PushConnection.ENABLE_QUICK_ACK_CHECK) {}
    try
    {
      Thread.sleep(2500L);
      label42:
      if (SystemClock.elapsedRealtime() - PushConnection.access$1100(this.this$2.this$1.this$0).get() <= 2500L * 2L) {
        i = 1;
      }
      if (i == 0)
      {
        PendingIntent localPendingIntent = PendingIntent.getBroadcast(this.this$2.val$appContext, System.identityHashCode(this), this.this$2.val$readIntent, 1342177280);
        PushConnection.KeepAliveMonitor.access$1500(this.this$2.this$1).set(2, SystemClock.elapsedRealtime() + PushConnection.KEEP_ALIVE_ACK_INTERVAL, localPendingIntent);
      }
      for (;;)
      {
        this.val$wl.release();
        return null;
        Parse.logV("com.parse.PushConnection", "Keep alive ack was received quickly.");
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      break label42;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushConnection.KeepAliveMonitor.2.1
 * JD-Core Version:    0.7.0.1
 */