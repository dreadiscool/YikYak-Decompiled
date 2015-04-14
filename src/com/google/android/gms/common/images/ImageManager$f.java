package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import hu;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

final class ImageManager$f
  implements Runnable
{
  private boolean LI;
  private final Bitmap mBitmap;
  private final Uri mUri;
  private final CountDownLatch mr;
  
  public ImageManager$f(ImageManager paramImageManager, Uri paramUri, Bitmap paramBitmap, boolean paramBoolean, CountDownLatch paramCountDownLatch)
  {
    this.mUri = paramUri;
    this.mBitmap = paramBitmap;
    this.LI = paramBoolean;
    this.mr = paramCountDownLatch;
  }
  
  private void a(ImageManager.ImageReceiver paramImageReceiver, boolean paramBoolean)
  {
    ArrayList localArrayList = ImageManager.ImageReceiver.a(paramImageReceiver);
    int i = localArrayList.size();
    int j = 0;
    if (j < i)
    {
      a locala = (a)localArrayList.get(j);
      if (paramBoolean) {
        locala.a(ImageManager.b(this.LF), this.mBitmap, false);
      }
      for (;;)
      {
        if (!(locala instanceof a.c)) {
          ImageManager.a(this.LF).remove(locala);
        }
        j++;
        break;
        ImageManager.d(this.LF).put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
        locala.a(ImageManager.b(this.LF), ImageManager.c(this.LF), false);
      }
    }
  }
  
  public void run()
  {
    hu.a("OnBitmapLoadedRunnable must be executed in the main thread");
    boolean bool;
    if (this.mBitmap != null)
    {
      bool = true;
      if (ImageManager.h(this.LF) == null) {
        break label97;
      }
      if (!this.LI) {
        break label67;
      }
      ImageManager.h(this.LF).evictAll();
      System.gc();
      this.LI = false;
      ImageManager.g(this.LF).post(this);
    }
    for (;;)
    {
      return;
      bool = false;
      break;
      label67:
      if (bool) {
        ImageManager.h(this.LF).put(new a.a(this.mUri), this.mBitmap);
      }
      label97:
      ImageManager.ImageReceiver localImageReceiver = (ImageManager.ImageReceiver)ImageManager.e(this.LF).remove(this.mUri);
      if (localImageReceiver != null) {
        a(localImageReceiver, bool);
      }
      this.mr.countDown();
      synchronized (ImageManager.he())
      {
        ImageManager.hf().remove(this.mUri);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageManager.f
 * JD-Core Version:    0.7.0.1
 */