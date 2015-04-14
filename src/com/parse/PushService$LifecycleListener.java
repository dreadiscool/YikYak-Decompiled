package com.parse;

import android.app.Service;

abstract interface PushService$LifecycleListener
{
  public abstract void onServiceCreated(Service paramService);
  
  public abstract void onServiceDestroyed(Service paramService);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushService.LifecycleListener
 * JD-Core Version:    0.7.0.1
 */