package com.mobileapptracker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.net.URLDecoder;
import wV;

public class Tracker
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null) {}
    for (;;)
    {
      try
      {
        if (paramIntent.getAction().equals("com.android.vending.INSTALL_REFERRER"))
        {
          String str1 = paramIntent.getStringExtra("referrer");
          if (str1 != null)
          {
            String str2 = URLDecoder.decode(str1, "UTF-8");
            new StringBuilder("MAT received referrer ").append(str2).toString();
            paramContext.getSharedPreferences("mat_referrer", 0).edit().putString("referrer", str2).commit();
            localwV = wV.a();
            if (localwV != null)
            {
              localwV.e = true;
              if ((!localwV.d) || (localwV.g)) {}
            }
          }
        }
      }
      catch (Exception localException)
      {
        wV localwV;
        localException.printStackTrace();
        continue;
      }
      synchronized (localwV.k)
      {
        localwV.k.notifyAll();
        localwV.g = true;
        return;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.mobileapptracker.Tracker
 * JD-Core Version:    0.7.0.1
 */