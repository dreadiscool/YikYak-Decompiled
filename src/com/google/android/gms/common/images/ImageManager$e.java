package com.google.android.gms.common.images;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

final class ImageManager$e
  implements ComponentCallbacks2
{
  private final ImageManager.b Lz;
  
  public ImageManager$e(ImageManager.b paramb)
  {
    this.Lz = paramb;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory()
  {
    this.Lz.evictAll();
  }
  
  public void onTrimMemory(int paramInt)
  {
    if (paramInt >= 60) {
      this.Lz.evictAll();
    }
    for (;;)
    {
      return;
      if (paramInt >= 20) {
        this.Lz.trimToSize(this.Lz.size() / 2);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageManager.e
 * JD-Core Version:    0.7.0.1
 */