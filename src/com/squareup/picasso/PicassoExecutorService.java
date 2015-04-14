package com.squareup.picasso;

import android.net.NetworkInfo;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class PicassoExecutorService
  extends ThreadPoolExecutor
{
  private static final int DEFAULT_THREAD_COUNT = 3;
  
  PicassoExecutorService()
  {
    super(3, 3, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new Utils.PicassoThreadFactory());
  }
  
  private void setThreadCount(int paramInt)
  {
    setCorePoolSize(paramInt);
    setMaximumPoolSize(paramInt);
  }
  
  void adjustThreadCount(NetworkInfo paramNetworkInfo)
  {
    if ((paramNetworkInfo == null) || (!paramNetworkInfo.isConnectedOrConnecting())) {
      setThreadCount(3);
    }
    for (;;)
    {
      return;
      switch (paramNetworkInfo.getType())
      {
      default: 
        setThreadCount(3);
        break;
      case 1: 
      case 6: 
      case 9: 
        setThreadCount(4);
        break;
      case 0: 
        switch (paramNetworkInfo.getSubtype())
        {
        case 7: 
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        default: 
          setThreadCount(3);
          break;
        case 13: 
        case 14: 
        case 15: 
          setThreadCount(3);
          break;
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 12: 
          setThreadCount(2);
          break;
        case 1: 
        case 2: 
          setThreadCount(1);
        }
        break;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.PicassoExecutorService
 * JD-Core Version:    0.7.0.1
 */