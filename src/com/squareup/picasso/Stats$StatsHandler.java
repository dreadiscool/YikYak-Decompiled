package com.squareup.picasso;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class Stats$StatsHandler
  extends Handler
{
  private final Stats stats;
  
  public Stats$StatsHandler(Looper paramLooper, Stats paramStats)
  {
    super(paramLooper);
    this.stats = paramStats;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      Picasso.HANDLER.post(new Stats.StatsHandler.1(this, paramMessage));
    }
    for (;;)
    {
      return;
      this.stats.performCacheHit();
      continue;
      this.stats.performCacheMiss();
      continue;
      this.stats.performBitmapDecoded(paramMessage.arg1);
      continue;
      this.stats.performBitmapTransformed(paramMessage.arg1);
      continue;
      this.stats.performDownloadFinished((Long)paramMessage.obj);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Stats.StatsHandler
 * JD-Core Version:    0.7.0.1
 */