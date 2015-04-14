package com.facebook;

import android.os.Handler;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

class ProgressNoopOutputStream
  extends OutputStream
  implements RequestOutputStream
{
  private int batchMax;
  private final Handler callbackHandler;
  private Request currentRequest;
  private RequestProgress currentRequestProgress;
  private final Map<Request, RequestProgress> progressMap = new HashMap();
  
  ProgressNoopOutputStream(Handler paramHandler)
  {
    this.callbackHandler = paramHandler;
  }
  
  void addProgress(long paramLong)
  {
    if (this.currentRequestProgress == null)
    {
      this.currentRequestProgress = new RequestProgress(this.callbackHandler, this.currentRequest);
      this.progressMap.put(this.currentRequest, this.currentRequestProgress);
    }
    this.currentRequestProgress.addToMax(paramLong);
    this.batchMax = ((int)(paramLong + this.batchMax));
  }
  
  int getMaxProgress()
  {
    return this.batchMax;
  }
  
  Map<Request, RequestProgress> getProgressMap()
  {
    return this.progressMap;
  }
  
  public void setCurrentRequest(Request paramRequest)
  {
    this.currentRequest = paramRequest;
    if (paramRequest != null) {}
    for (RequestProgress localRequestProgress = (RequestProgress)this.progressMap.get(paramRequest);; localRequestProgress = null)
    {
      this.currentRequestProgress = localRequestProgress;
      return;
    }
  }
  
  public void write(int paramInt)
  {
    addProgress(1L);
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    addProgress(paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    addProgress(paramInt2);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.ProgressNoopOutputStream
 * JD-Core Version:    0.7.0.1
 */