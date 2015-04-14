package com.squareup.picasso;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

final class RequestCreator$1
  implements Runnable
{
  RequestCreator$1(AtomicInteger paramAtomicInteger, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    this.val$id.set(RequestCreator.access$000());
    this.val$latch.countDown();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.RequestCreator.1
 * JD-Core Version:    0.7.0.1
 */