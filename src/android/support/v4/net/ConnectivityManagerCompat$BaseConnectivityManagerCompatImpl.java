package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

class ConnectivityManagerCompat$BaseConnectivityManagerCompatImpl
  implements ConnectivityManagerCompat.ConnectivityManagerCompatImpl
{
  public boolean isActiveNetworkMetered(ConnectivityManager paramConnectivityManager)
  {
    boolean bool = true;
    NetworkInfo localNetworkInfo = paramConnectivityManager.getActiveNetworkInfo();
    if (localNetworkInfo == null) {}
    for (;;)
    {
      return bool;
      switch (localNetworkInfo.getType())
      {
      case 0: 
      default: 
        break;
      case 1: 
        bool = false;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.net.ConnectivityManagerCompat.BaseConnectivityManagerCompatImpl
 * JD-Core Version:    0.7.0.1
 */