package com.parse;

import android.content.Intent;

class PushConnection$ReachabilityMonitor$1
  implements ConnectivityNotifier.ConnectivityListener
{
  PushConnection$ReachabilityMonitor$1(PushConnection.ReachabilityMonitor paramReachabilityMonitor) {}
  
  public void networkConnectivityStatusChanged(Intent paramIntent)
  {
    synchronized (this.this$1)
    {
      if (!PushConnection.ReachabilityMonitor.access$900(this.this$1)) {
        PushConnection.access$300(this.this$1.this$0).signalEvent(PushConnection.Event.CONNECTIVITY_CHANGED);
      }
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushConnection.ReachabilityMonitor.1
 * JD-Core Version:    0.7.0.1
 */