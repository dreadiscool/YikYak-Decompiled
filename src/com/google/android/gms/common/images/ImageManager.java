package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import hs;
import hu;
import iv;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager
{
  private static final Object Lu = new Object();
  private static HashSet<Uri> Lv = new HashSet();
  private static ImageManager Lw;
  private static ImageManager Lx;
  private final hs LA;
  private final Map<a, ImageManager.ImageReceiver> LB;
  private final Map<Uri, ImageManager.ImageReceiver> LC;
  private final Map<Uri, Long> LD;
  private final ExecutorService Ly;
  private final ImageManager.b Lz;
  private final Context mContext;
  private final Handler mHandler;
  
  private ImageManager(Context paramContext, boolean paramBoolean)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mHandler = new Handler(Looper.getMainLooper());
    this.Ly = Executors.newFixedThreadPool(4);
    if (paramBoolean)
    {
      this.Lz = new ImageManager.b(this.mContext);
      if (iv.c()) {
        hd();
      }
    }
    for (;;)
    {
      this.LA = new hs();
      this.LB = new HashMap();
      this.LC = new HashMap();
      this.LD = new HashMap();
      return;
      this.Lz = null;
    }
  }
  
  private Bitmap a(a.a parama)
  {
    if (this.Lz == null) {}
    for (Bitmap localBitmap = null;; localBitmap = (Bitmap)this.Lz.get(parama)) {
      return localBitmap;
    }
  }
  
  public static ImageManager c(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (Lx == null) {
        Lx = new ImageManager(paramContext, true);
      }
    }
    for (ImageManager localImageManager = Lx;; localImageManager = Lw)
    {
      return localImageManager;
      if (Lw == null) {
        Lw = new ImageManager(paramContext, false);
      }
    }
  }
  
  public static ImageManager create(Context paramContext)
  {
    return c(paramContext, false);
  }
  
  private void hd()
  {
    this.mContext.registerComponentCallbacks(new ImageManager.e(this.Lz));
  }
  
  public void a(a parama)
  {
    hu.a("ImageManager.loadImage() must be called in the main thread");
    new ImageManager.d(this, parama).run();
  }
  
  public void loadImage(ImageView paramImageView, int paramInt)
  {
    a(new a.b(paramImageView, paramInt));
  }
  
  public void loadImage(ImageView paramImageView, Uri paramUri)
  {
    a(new a.b(paramImageView, paramUri));
  }
  
  public void loadImage(ImageView paramImageView, Uri paramUri, int paramInt)
  {
    a.b localb = new a.b(paramImageView, paramUri);
    localb.az(paramInt);
    a(localb);
  }
  
  public void loadImage(ImageManager.OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
  {
    a(new a.c(paramOnImageLoadedListener, paramUri));
  }
  
  public void loadImage(ImageManager.OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri, int paramInt)
  {
    a.c localc = new a.c(paramOnImageLoadedListener, paramUri);
    localc.az(paramInt);
    a(localc);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageManager
 * JD-Core Version:    0.7.0.1
 */