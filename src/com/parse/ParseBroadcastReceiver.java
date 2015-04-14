package com.parse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ParseBroadcastReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "com.parse.ParseBroadcastReceiver";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Parse.logD("com.parse.ParseBroadcastReceiver", "received " + paramIntent.getAction());
    PushService.startServiceIfRequired(paramContext);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */