package com.parse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class GcmBroadcastReceiver
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    PushService.runGcmIntentInService(paramContext, paramIntent);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.GcmBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */