package com.google.android.gms.common.api;

import hZ;
import java.util.concurrent.TimeUnit;

public final class BatchResult
  implements Result
{
  private final Status Eb;
  private final PendingResult<?>[] JC;
  
  BatchResult(Status paramStatus, PendingResult<?>[] paramArrayOfPendingResult)
  {
    this.Eb = paramStatus;
    this.JC = paramArrayOfPendingResult;
  }
  
  public Status getStatus()
  {
    return this.Eb;
  }
  
  public <R extends Result> R take(BatchResultToken<R> paramBatchResultToken)
  {
    if (paramBatchResultToken.mId < this.JC.length) {}
    for (boolean bool = true;; bool = false)
    {
      hZ.b(bool, "The result token does not belong to this batch");
      return this.JC[paramBatchResultToken.mId].await(0L, TimeUnit.MILLISECONDS);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.BatchResult
 * JD-Core Version:    0.7.0.1
 */