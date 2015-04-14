package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

final class LikeActionController$4
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (LikeActionController.access$200()) {
      return;
    }
    String str = paramIntent.getAction();
    if ((Utility.areObjectsEqual("com.facebook.sdk.ACTIVE_SESSION_UNSET", str)) || (Utility.areObjectsEqual("com.facebook.sdk.ACTIVE_SESSION_CLOSED", str))) {}
    for (boolean bool = true;; bool = false)
    {
      LikeActionController.access$202(true);
      LikeActionController.access$800().postDelayed(new LikeActionController.4.1(this, bool), 100L);
      break;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.LikeActionController.4
 * JD-Core Version:    0.7.0.1
 */