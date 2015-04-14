package com.google.android.gms.common.api;

import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

public final class Batch$Builder
{
  private List<PendingResult<?>> JE = new ArrayList();
  private Looper JF;
  
  public Batch$Builder(GoogleApiClient paramGoogleApiClient)
  {
    this.JF = paramGoogleApiClient.getLooper();
  }
  
  public <R extends Result> BatchResultToken<R> add(PendingResult<R> paramPendingResult)
  {
    BatchResultToken localBatchResultToken = new BatchResultToken(this.JE.size());
    this.JE.add(paramPendingResult);
    return localBatchResultToken;
  }
  
  public Batch build()
  {
    return new Batch(this.JE, this.JF, null);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.Batch.Builder
 * JD-Core Version:    0.7.0.1
 */