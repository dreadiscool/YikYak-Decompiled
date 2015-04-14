package com.facebook.internal;

import android.content.Context;

class ImageDownloader$DownloadImageWorkItem
  implements Runnable
{
  private Context context;
  private ImageDownloader.RequestKey key;
  
  ImageDownloader$DownloadImageWorkItem(Context paramContext, ImageDownloader.RequestKey paramRequestKey)
  {
    this.context = paramContext;
    this.key = paramRequestKey;
  }
  
  public void run()
  {
    ImageDownloader.access$200(this.key, this.context);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.ImageDownloader.DownloadImageWorkItem
 * JD-Core Version:    0.7.0.1
 */