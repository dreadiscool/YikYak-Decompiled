package com.amplitude.api;

import android.os.Handler;
import android.os.HandlerThread;

public class WorkerThread
  extends HandlerThread
{
  private Handler handler;
  
  public WorkerThread(String paramString)
  {
    super(paramString);
  }
  
  private void waitForInitialization()
  {
    try
    {
      if (this.handler == null) {
        this.handler = new Handler(getLooper());
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  Handler getHandler()
  {
    return this.handler;
  }
  
  void post(Runnable paramRunnable)
  {
    waitForInitialization();
    this.handler.post(paramRunnable);
  }
  
  void postDelayed(Runnable paramRunnable, long paramLong)
  {
    waitForInitialization();
    this.handler.postDelayed(paramRunnable, paramLong);
  }
  
  void removeCallbacks(Runnable paramRunnable)
  {
    waitForInitialization();
    this.handler.removeCallbacks(paramRunnable);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.amplitude.api.WorkerThread
 * JD-Core Version:    0.7.0.1
 */