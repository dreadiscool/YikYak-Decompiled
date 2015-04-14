package com.squareup.picasso;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;

class Stats
{
  private static final int BITMAP_DECODE_FINISHED = 2;
  private static final int BITMAP_TRANSFORMED_FINISHED = 3;
  private static final int CACHE_HIT = 0;
  private static final int CACHE_MISS = 1;
  private static final int DOWNLOAD_FINISHED = 4;
  private static final String STATS_THREAD_NAME = "Picasso-Stats";
  long averageDownloadSize;
  long averageOriginalBitmapSize;
  long averageTransformedBitmapSize;
  final Cache cache;
  long cacheHits;
  long cacheMisses;
  int downloadCount;
  final Handler handler;
  int originalBitmapCount;
  final HandlerThread statsThread;
  long totalDownloadSize;
  long totalOriginalBitmapSize;
  long totalTransformedBitmapSize;
  int transformedBitmapCount;
  
  Stats(Cache paramCache)
  {
    this.cache = paramCache;
    this.statsThread = new HandlerThread("Picasso-Stats", 10);
    this.statsThread.start();
    this.handler = new Stats.StatsHandler(this.statsThread.getLooper(), this);
  }
  
  private static long getAverage(int paramInt, long paramLong)
  {
    return paramLong / paramInt;
  }
  
  private void processBitmap(Bitmap paramBitmap, int paramInt)
  {
    int i = Utils.getBitmapBytes(paramBitmap);
    this.handler.sendMessage(this.handler.obtainMessage(paramInt, i, 0));
  }
  
  StatsSnapshot createSnapshot()
  {
    return new StatsSnapshot(this.cache.maxSize(), this.cache.size(), this.cacheHits, this.cacheMisses, this.totalDownloadSize, this.totalOriginalBitmapSize, this.totalTransformedBitmapSize, this.averageDownloadSize, this.averageOriginalBitmapSize, this.averageTransformedBitmapSize, this.downloadCount, this.originalBitmapCount, this.transformedBitmapCount, System.currentTimeMillis());
  }
  
  void dispatchBitmapDecoded(Bitmap paramBitmap)
  {
    processBitmap(paramBitmap, 2);
  }
  
  void dispatchBitmapTransformed(Bitmap paramBitmap)
  {
    processBitmap(paramBitmap, 3);
  }
  
  void dispatchCacheHit()
  {
    this.handler.sendEmptyMessage(0);
  }
  
  void dispatchCacheMiss()
  {
    this.handler.sendEmptyMessage(1);
  }
  
  void dispatchDownloadFinished(long paramLong)
  {
    this.handler.sendMessage(this.handler.obtainMessage(4, Long.valueOf(paramLong)));
  }
  
  void performBitmapDecoded(long paramLong)
  {
    this.originalBitmapCount = (1 + this.originalBitmapCount);
    this.totalOriginalBitmapSize = (paramLong + this.totalOriginalBitmapSize);
    this.averageOriginalBitmapSize = getAverage(this.originalBitmapCount, this.totalOriginalBitmapSize);
  }
  
  void performBitmapTransformed(long paramLong)
  {
    this.transformedBitmapCount = (1 + this.transformedBitmapCount);
    this.totalTransformedBitmapSize = (paramLong + this.totalTransformedBitmapSize);
    this.averageTransformedBitmapSize = getAverage(this.originalBitmapCount, this.totalTransformedBitmapSize);
  }
  
  void performCacheHit()
  {
    this.cacheHits = (1L + this.cacheHits);
  }
  
  void performCacheMiss()
  {
    this.cacheMisses = (1L + this.cacheMisses);
  }
  
  void performDownloadFinished(Long paramLong)
  {
    this.downloadCount = (1 + this.downloadCount);
    this.totalDownloadSize += paramLong.longValue();
    this.averageDownloadSize = getAverage(this.downloadCount, this.totalDownloadSize);
  }
  
  void shutdown()
  {
    this.statsThread.quit();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Stats
 * JD-Core Version:    0.7.0.1
 */