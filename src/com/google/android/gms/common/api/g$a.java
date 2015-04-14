package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.Loader;
import com.google.android.gms.common.ConnectionResult;

class g$a
  extends Loader<ConnectionResult>
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  public final GoogleApiClient KH;
  private boolean KI;
  private ConnectionResult KJ;
  
  public g$a(Context paramContext, GoogleApiClient paramGoogleApiClient)
  {
    super(paramContext);
    this.KH = paramGoogleApiClient;
  }
  
  private void a(ConnectionResult paramConnectionResult)
  {
    this.KJ = paramConnectionResult;
    if ((isStarted()) && (!isAbandoned())) {
      deliverResult(paramConnectionResult);
    }
  }
  
  public void gS()
  {
    if (this.KI)
    {
      this.KI = false;
      if ((isStarted()) && (!isAbandoned())) {
        this.KH.connect();
      }
    }
  }
  
  public void onConnected(Bundle paramBundle)
  {
    this.KI = false;
    a(ConnectionResult.Iu);
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    this.KI = true;
    a(paramConnectionResult);
  }
  
  public void onConnectionSuspended(int paramInt) {}
  
  protected void onReset()
  {
    this.KJ = null;
    this.KI = false;
    this.KH.unregisterConnectionCallbacks(this);
    this.KH.unregisterConnectionFailedListener(this);
    this.KH.disconnect();
  }
  
  protected void onStartLoading()
  {
    super.onStartLoading();
    this.KH.registerConnectionCallbacks(this);
    this.KH.registerConnectionFailedListener(this);
    if (this.KJ != null) {
      deliverResult(this.KJ);
    }
    if ((!this.KH.isConnected()) && (!this.KH.isConnecting()) && (!this.KI)) {
      this.KH.connect();
    }
  }
  
  protected void onStopLoading()
  {
    this.KH.disconnect();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.g.a
 * JD-Core Version:    0.7.0.1
 */