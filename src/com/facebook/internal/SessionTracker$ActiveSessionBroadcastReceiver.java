package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.Session;

class SessionTracker$ActiveSessionBroadcastReceiver
  extends BroadcastReceiver
{
  private SessionTracker$ActiveSessionBroadcastReceiver(SessionTracker paramSessionTracker) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.facebook.sdk.ACTIVE_SESSION_SET".equals(paramIntent.getAction()))
    {
      Session localSession = Session.getActiveSession();
      if (localSession != null) {
        localSession.addCallback(SessionTracker.access$100(this.this$0));
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.SessionTracker.ActiveSessionBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */