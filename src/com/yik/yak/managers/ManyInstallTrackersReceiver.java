package com.yik.yak.managers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.mixpanel.android.mpmetrics.InstallReferrerReceiver;
import com.mobileapptracker.Tracker;

public class ManyInstallTrackersReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    new InstallReferrerReceiver().onReceive(paramContext, paramIntent);
    new Tracker().onReceive(paramContext, paramIntent);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.managers.ManyInstallTrackersReceiver
 * JD-Core Version:    0.7.0.1
 */