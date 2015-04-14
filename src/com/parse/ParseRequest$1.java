package com.parse;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class ParseRequest$1
  implements ThreadFactory
{
  private final AtomicInteger mCount = new AtomicInteger(1);
  
  public Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "ParseRequest.NETWORK_EXECUTOR-thread-" + this.mCount.getAndIncrement());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseRequest.1
 * JD-Core Version:    0.7.0.1
 */