package com.google.android.gms.common.api;

class c$7
  implements ResultCallback<Status>
{
  c$7(c paramc, f paramf, boolean paramBoolean, GoogleApiClient paramGoogleApiClient) {}
  
  public void j(Status paramStatus)
  {
    if ((paramStatus.isSuccess()) && (this.Kn.isConnected())) {
      this.Kn.reconnect();
    }
    this.Kq.b(paramStatus);
    if (this.Kr) {
      this.GB.disconnect();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.c.7
 * JD-Core Version:    0.7.0.1
 */