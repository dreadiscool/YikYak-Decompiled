package com.google.android.gms.common.api;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import java.util.concurrent.locks.Lock;

class c$2
  implements GoogleApiClient.ConnectionCallbacks
{
  c$2(c paramc) {}
  
  public void onConnected(Bundle paramBundle)
  {
    c.a(this.Kn).lock();
    try
    {
      if (c.b(this.Kn) == 1)
      {
        if (paramBundle != null) {
          c.c(this.Kn).putAll(paramBundle);
        }
        c.d(this.Kn);
      }
      return;
    }
    finally
    {
      c.a(this.Kn).unlock();
    }
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    c.a(this.Kn).lock();
    switch (paramInt)
    {
    }
    for (;;)
    {
      c.a(this.Kn).unlock();
      for (;;)
      {
        for (;;)
        {
          return;
          try
          {
            c.a(this.Kn, paramInt);
            this.Kn.connect();
            break;
          }
          finally
          {
            c.a(this.Kn).unlock();
          }
        }
        boolean bool = this.Kn.gL();
        if (!bool) {
          break label111;
        }
        c.a(this.Kn).unlock();
      }
      label111:
      c.a(this.Kn, true);
      this.Kn.Ke = new c.a(this.Kn);
      IntentFilter localIntentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
      localIntentFilter.addDataScheme("package");
      c.e(this.Kn).registerReceiver(this.Kn.Ke, localIntentFilter);
      this.Kn.Kd.sendMessageDelayed(this.Kn.Kd.obtainMessage(1), c.f(this.Kn));
      this.Kn.Kd.sendMessageDelayed(this.Kn.Kd.obtainMessage(2), c.g(this.Kn));
      c.a(this.Kn, paramInt);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.c.2
 * JD-Core Version:    0.7.0.1
 */