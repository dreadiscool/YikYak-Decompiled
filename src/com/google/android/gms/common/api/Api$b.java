package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.internal.jg;

public abstract interface Api$b<T extends Api.a, O>
{
  public abstract T a(Context paramContext, Looper paramLooper, jg paramjg, O paramO, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public abstract int getPriority();
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.Api.b
 * JD-Core Version:    0.7.0.1
 */