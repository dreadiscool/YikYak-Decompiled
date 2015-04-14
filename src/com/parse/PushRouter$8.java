package com.parse;

import android.content.Intent;
import java.util.concurrent.Semaphore;

final class PushRouter$8
  implements Runnable
{
  PushRouter$8(Intent paramIntent, Semaphore paramSemaphore) {}
  
  public void run()
  {
    PushRouter.access$000().handleGcmPush(this.val$intent);
    this.val$done.release();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushRouter.8
 * JD-Core Version:    0.7.0.1
 */