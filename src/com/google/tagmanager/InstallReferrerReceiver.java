package com.google.tagmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import rA;

public final class InstallReferrerReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("referrer");
    if ((!"com.android.vending.INSTALL_REFERRER".equals(paramIntent.getAction())) || (str == null)) {}
    for (;;)
    {
      return;
      rA.a(str);
      Intent localIntent = new Intent(paramContext, InstallReferrerService.class);
      localIntent.putExtra("referrer", str);
      paramContext.startService(localIntent);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.tagmanager.InstallReferrerReceiver
 * JD-Core Version:    0.7.0.1
 */