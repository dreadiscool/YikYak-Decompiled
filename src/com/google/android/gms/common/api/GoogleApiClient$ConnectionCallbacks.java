package com.google.android.gms.common.api;

import android.os.Bundle;

public abstract interface GoogleApiClient$ConnectionCallbacks
{
  public static final int CAUSE_NETWORK_LOST = 2;
  public static final int CAUSE_SERVICE_DISCONNECTED = 1;
  
  public abstract void onConnected(Bundle paramBundle);
  
  public abstract void onConnectionSuspended(int paramInt);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
 * JD-Core Version:    0.7.0.1
 */