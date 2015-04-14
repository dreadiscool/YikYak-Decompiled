package com.facebook;

class ProgressOutputStream$1
  implements Runnable
{
  ProgressOutputStream$1(ProgressOutputStream paramProgressOutputStream, RequestBatch.OnProgressCallback paramOnProgressCallback) {}
  
  public void run()
  {
    this.val$progressCallback.onBatchProgress(ProgressOutputStream.access$000(this.this$0), ProgressOutputStream.access$100(this.this$0), ProgressOutputStream.access$200(this.this$0));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.ProgressOutputStream.1
 * JD-Core Version:    0.7.0.1
 */