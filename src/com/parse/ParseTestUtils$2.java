package com.parse;

import java.util.concurrent.Semaphore;

final class ParseTestUtils$2
  implements Runnable
{
  ParseTestUtils$2(boolean paramBoolean, Semaphore paramSemaphore) {}
  
  public void run()
  {
    ParseTestUtils.setStrictModeEnabledForThisThread(this.val$enabled);
    this.val$done.release();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseTestUtils.2
 * JD-Core Version:    0.7.0.1
 */