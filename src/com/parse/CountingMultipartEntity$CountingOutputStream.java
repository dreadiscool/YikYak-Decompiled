package com.parse;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import m;

public class CountingMultipartEntity$CountingOutputStream
  extends FilterOutputStream
{
  private boolean hasReportedDone = false;
  private final ProgressCallback progressCallback;
  private long totalSize;
  private long uploadedSize;
  
  public CountingMultipartEntity$CountingOutputStream(OutputStream paramOutputStream, ProgressCallback paramProgressCallback, long paramLong)
  {
    super(paramOutputStream);
    this.progressCallback = paramProgressCallback;
    this.totalSize = paramLong;
    this.uploadedSize = 0L;
  }
  
  private void notifyCallback()
  {
    if (this.hasReportedDone) {}
    for (;;)
    {
      return;
      int i = Math.round(100.0F * ((float)this.uploadedSize / (float)this.totalSize));
      Parse.callbackOnMainThreadAsync(m.a(Integer.valueOf(i)), this.progressCallback);
      if (i == 100) {
        this.hasReportedDone = true;
      }
    }
  }
  
  public void write(int paramInt)
  {
    this.out.write(paramInt);
    this.uploadedSize = (1L + this.uploadedSize);
    notifyCallback();
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    this.uploadedSize += paramInt2;
    notifyCallback();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.CountingMultipartEntity.CountingOutputStream
 * JD-Core Version:    0.7.0.1
 */