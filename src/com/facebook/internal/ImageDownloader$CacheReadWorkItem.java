package com.facebook.internal;

import android.content.Context;

class ImageDownloader$CacheReadWorkItem
  implements Runnable
{
  private boolean allowCachedRedirects;
  private Context context;
  private ImageDownloader.RequestKey key;
  
  ImageDownloader$CacheReadWorkItem(Context paramContext, ImageDownloader.RequestKey paramRequestKey, boolean paramBoolean)
  {
    this.context = paramContext;
    this.key = paramRequestKey;
    this.allowCachedRedirects = paramBoolean;
  }
  
  public void run()
  {
    ImageDownloader.access$100(this.key, this.context, this.allowCachedRedirects);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.ImageDownloader.CacheReadWorkItem
 * JD-Core Version:    0.7.0.1
 */