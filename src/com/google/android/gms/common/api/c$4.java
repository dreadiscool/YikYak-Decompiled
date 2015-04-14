package com.google.android.gms.common.api;

import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

class c$4
  implements GoogleApiClient.OnConnectionFailedListener
{
  c$4(c paramc, Api.b paramb) {}
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    c.a(this.Kn).lock();
    try
    {
      if ((c.k(this.Kn) == null) || (this.Ko.getPriority() < c.l(this.Kn)))
      {
        c.a(this.Kn, paramConnectionResult);
        c.b(this.Kn, this.Ko.getPriority());
      }
      c.d(this.Kn);
      return;
    }
    finally
    {
      c.a(this.Kn).unlock();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.c.4
 * JD-Core Version:    0.7.0.1
 */