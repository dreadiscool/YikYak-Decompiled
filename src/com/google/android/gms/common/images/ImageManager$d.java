package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.os.SystemClock;
import hu;
import java.util.HashSet;
import java.util.Map;

final class ImageManager$d
  implements Runnable
{
  private final a LH;
  
  public ImageManager$d(ImageManager paramImageManager, a parama)
  {
    this.LH = parama;
  }
  
  public void run()
  {
    hu.a("LoadImageRunnable must be executed on the main thread");
    ImageManager.ImageReceiver localImageReceiver1 = (ImageManager.ImageReceiver)ImageManager.a(this.LF).get(this.LH);
    if (localImageReceiver1 != null)
    {
      ImageManager.a(this.LF).remove(this.LH);
      localImageReceiver1.c(this.LH);
    }
    a.a locala = this.LH.LJ;
    if (locala.uri == null) {
      this.LH.a(ImageManager.b(this.LF), ImageManager.c(this.LF), true);
    }
    for (;;)
    {
      return;
      Bitmap localBitmap = ImageManager.a(this.LF, locala);
      if (localBitmap != null)
      {
        this.LH.a(ImageManager.b(this.LF), localBitmap, true);
        continue;
      }
      Long localLong = (Long)ImageManager.d(this.LF).get(locala.uri);
      if (localLong != null)
      {
        if (SystemClock.elapsedRealtime() - localLong.longValue() < 3600000L)
        {
          this.LH.a(ImageManager.b(this.LF), ImageManager.c(this.LF), true);
          continue;
        }
        ImageManager.d(this.LF).remove(locala.uri);
      }
      this.LH.a(ImageManager.b(this.LF), ImageManager.c(this.LF));
      ImageManager.ImageReceiver localImageReceiver2 = (ImageManager.ImageReceiver)ImageManager.e(this.LF).get(locala.uri);
      if (localImageReceiver2 == null)
      {
        localImageReceiver2 = new ImageManager.ImageReceiver(this.LF, locala.uri);
        ImageManager.e(this.LF).put(locala.uri, localImageReceiver2);
      }
      localImageReceiver2.b(this.LH);
      if (!(this.LH instanceof a.c)) {
        ImageManager.a(this.LF).put(this.LH, localImageReceiver2);
      }
      synchronized (ImageManager.he())
      {
        if (!ImageManager.hf().contains(locala.uri))
        {
          ImageManager.hf().add(locala.uri);
          localImageReceiver2.hg();
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageManager.d
 * JD-Core Version:    0.7.0.1
 */