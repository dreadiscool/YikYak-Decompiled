package com.parse;

import android.os.Looper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class Synchronizer
{
  boolean done = false;
  CountDownLatch latch = new CountDownLatch(1);
  
  void assertFinishes()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      throw new RuntimeException("assertFinishes() should *not* be called from the UI thread");
    }
    try
    {
      Thread.sleep(500L);
      this.done = this.latch.await(10L, TimeUnit.SECONDS);
      if (!this.done) {
        throw new RuntimeException("finish() was never called");
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new RuntimeException(localInterruptedException.getMessage());
    }
  }
  
  void finish()
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      throw new RuntimeException("finish() should be called from the UI thread");
    }
    if (this.done) {
      throw new RuntimeException("finish() was called too much");
    }
    this.latch.countDown();
  }
  
  void start(int paramInt)
  {
    this.latch = new CountDownLatch(paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.Synchronizer
 * JD-Core Version:    0.7.0.1
 */