package android.support.v4.net;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;

public class ConnectivityManagerCompat
{
  private static final ConnectivityManagerCompat.ConnectivityManagerCompatImpl IMPL;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16) {
      IMPL = new ConnectivityManagerCompat.JellyBeanConnectivityManagerCompatImpl();
    }
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT >= 13) {
        IMPL = new ConnectivityManagerCompat.HoneycombMR2ConnectivityManagerCompatImpl();
      } else if (Build.VERSION.SDK_INT >= 8) {
        IMPL = new ConnectivityManagerCompat.GingerbreadConnectivityManagerCompatImpl();
      } else {
        IMPL = new ConnectivityManagerCompat.BaseConnectivityManagerCompatImpl();
      }
    }
  }
  
  public static NetworkInfo getNetworkInfoFromBroadcast(ConnectivityManager paramConnectivityManager, Intent paramIntent)
  {
    NetworkInfo localNetworkInfo1 = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
    if (localNetworkInfo1 != null) {}
    for (NetworkInfo localNetworkInfo2 = paramConnectivityManager.getNetworkInfo(localNetworkInfo1.getType());; localNetworkInfo2 = null) {
      return localNetworkInfo2;
    }
  }
  
  public static boolean isActiveNetworkMetered(ConnectivityManager paramConnectivityManager)
  {
    return IMPL.isActiveNetworkMetered(paramConnectivityManager);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.net.ConnectivityManagerCompat
 * JD-Core Version:    0.7.0.1
 */