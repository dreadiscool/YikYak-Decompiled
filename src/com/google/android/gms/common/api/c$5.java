package com.google.android.gms.common.api;

import android.os.Bundle;
import java.util.concurrent.atomic.AtomicReference;

class c$5
  implements GoogleApiClient.ConnectionCallbacks
{
  c$5(c paramc, AtomicReference paramAtomicReference, f paramf) {}
  
  public void onConnected(Bundle paramBundle)
  {
    c.a(this.Kn, (GoogleApiClient)this.Kp.get(), this.Kq, true);
  }
  
  public void onConnectionSuspended(int paramInt) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.c.5
 * JD-Core Version:    0.7.0.1
 */