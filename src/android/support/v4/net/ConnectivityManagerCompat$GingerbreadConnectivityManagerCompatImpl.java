package android.support.v4.net;

import android.net.ConnectivityManager;

class ConnectivityManagerCompat$GingerbreadConnectivityManagerCompatImpl
  implements ConnectivityManagerCompat.ConnectivityManagerCompatImpl
{
  public boolean isActiveNetworkMetered(ConnectivityManager paramConnectivityManager)
  {
    return ConnectivityManagerCompatGingerbread.isActiveNetworkMetered(paramConnectivityManager);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.net.ConnectivityManagerCompat.GingerbreadConnectivityManagerCompatImpl
 * JD-Core Version:    0.7.0.1
 */