package com.google.android.gms.common.api;

import android.os.Looper;
import java.util.List;

public final class Batch
  extends BaseImplementation.AbstractPendingResult<BatchResult>
{
  private boolean JA;
  private boolean JB;
  private final PendingResult<?>[] JC;
  private int Jz;
  private final Object mH = new Object();
  
  private Batch(List<PendingResult<?>> paramList, Looper paramLooper)
  {
    super(new BaseImplementation.CallbackHandler(paramLooper));
    this.Jz = paramList.size();
    this.JC = new PendingResult[this.Jz];
    for (int i = 0; i < paramList.size(); i++)
    {
      PendingResult localPendingResult = (PendingResult)paramList.get(i);
      this.JC[i] = localPendingResult;
      localPendingResult.a(new Batch.1(this));
    }
  }
  
  public void cancel()
  {
    super.cancel();
    PendingResult[] arrayOfPendingResult = this.JC;
    int i = arrayOfPendingResult.length;
    for (int j = 0; j < i; j++) {
      arrayOfPendingResult[j].cancel();
    }
  }
  
  public BatchResult createFailedResult(Status paramStatus)
  {
    return new BatchResult(paramStatus, this.JC);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.Batch
 * JD-Core Version:    0.7.0.1
 */