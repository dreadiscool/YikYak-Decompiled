package com.facebook;

import android.os.Handler;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class ProgressOutputStream
  extends FilterOutputStream
  implements RequestOutputStream
{
  private long batchProgress;
  private RequestProgress currentRequestProgress;
  private long lastReportedProgress;
  private long maxProgress;
  private final Map<Request, RequestProgress> progressMap;
  private final RequestBatch requests;
  private final long threshold;
  
  ProgressOutputStream(OutputStream paramOutputStream, RequestBatch paramRequestBatch, Map<Request, RequestProgress> paramMap, long paramLong)
  {
    super(paramOutputStream);
    this.requests = paramRequestBatch;
    this.progressMap = paramMap;
    this.maxProgress = paramLong;
    this.threshold = Settings.getOnProgressThreshold();
  }
  
  private void addProgress(long paramLong)
  {
    if (this.currentRequestProgress != null) {
      this.currentRequestProgress.addProgress(paramLong);
    }
    this.batchProgress = (paramLong + this.batchProgress);
    if ((this.batchProgress >= this.lastReportedProgress + this.threshold) || (this.batchProgress >= this.maxProgress)) {
      reportBatchProgress();
    }
  }
  
  private void reportBatchProgress()
  {
    if (this.batchProgress > this.lastReportedProgress)
    {
      Iterator localIterator = this.requests.getCallbacks().iterator();
      while (localIterator.hasNext())
      {
        RequestBatch.Callback localCallback = (RequestBatch.Callback)localIterator.next();
        if ((localCallback instanceof RequestBatch.OnProgressCallback))
        {
          Handler localHandler = this.requests.getCallbackHandler();
          RequestBatch.OnProgressCallback localOnProgressCallback = (RequestBatch.OnProgressCallback)localCallback;
          if (localHandler == null) {
            localOnProgressCallback.onBatchProgress(this.requests, this.batchProgress, this.maxProgress);
          } else {
            localHandler.post(new ProgressOutputStream.1(this, localOnProgressCallback));
          }
        }
      }
      this.lastReportedProgress = this.batchProgress;
    }
  }
  
  public void close()
  {
    super.close();
    Iterator localIterator = this.progressMap.values().iterator();
    while (localIterator.hasNext()) {
      ((RequestProgress)localIterator.next()).reportProgress();
    }
    reportBatchProgress();
  }
  
  long getBatchProgress()
  {
    return this.batchProgress;
  }
  
  long getMaxProgress()
  {
    return this.maxProgress;
  }
  
  public void setCurrentRequest(Request paramRequest)
  {
    if (paramRequest != null) {}
    for (RequestProgress localRequestProgress = (RequestProgress)this.progressMap.get(paramRequest);; localRequestProgress = null)
    {
      this.currentRequestProgress = localRequestProgress;
      return;
    }
  }
  
  public void write(int paramInt)
  {
    this.out.write(paramInt);
    addProgress(1L);
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    this.out.write(paramArrayOfByte);
    addProgress(paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    addProgress(paramInt2);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.ProgressOutputStream
 * JD-Core Version:    0.7.0.1
 */