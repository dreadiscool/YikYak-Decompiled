package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import hl;
import hq;
import hs;
import ht;
import hu;

public abstract class a
{
  final a.a LJ;
  protected int LK = 0;
  protected int LL = 0;
  protected boolean LM = false;
  protected ImageManager.OnImageLoadedListener LN;
  private boolean LO = true;
  private boolean LP = false;
  private boolean LQ = true;
  protected int LR;
  
  public a(Uri paramUri, int paramInt)
  {
    this.LJ = new a.a(paramUri);
    this.LL = paramInt;
  }
  
  private Drawable a(Context paramContext, hs paramhs, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    Drawable localDrawable;
    if (this.LR > 0)
    {
      ht localht = new ht(paramInt, this.LR);
      localDrawable = (Drawable)paramhs.get(localht);
      if (localDrawable == null)
      {
        localDrawable = localResources.getDrawable(paramInt);
        if ((0x1 & this.LR) != 0) {
          localDrawable = a(localResources, localDrawable);
        }
        paramhs.put(localht, localDrawable);
      }
    }
    for (;;)
    {
      return localDrawable;
      localDrawable = localResources.getDrawable(paramInt);
    }
  }
  
  protected Drawable a(Resources paramResources, Drawable paramDrawable)
  {
    return hq.a(paramResources, paramDrawable);
  }
  
  protected hl a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (paramDrawable1 != null) {
      if (!(paramDrawable1 instanceof hl)) {}
    }
    for (paramDrawable1 = ((hl)paramDrawable1).b();; paramDrawable1 = null) {
      return new hl(paramDrawable1, paramDrawable2);
    }
  }
  
  void a(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    hu.a(paramBitmap);
    if ((0x1 & this.LR) != 0) {
      paramBitmap = hq.a(paramBitmap);
    }
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(paramContext.getResources(), paramBitmap);
    if (this.LN != null) {
      this.LN.onImageLoaded(this.LJ.uri, localBitmapDrawable, true);
    }
    a(localBitmapDrawable, paramBoolean, false, true);
  }
  
  void a(Context paramContext, hs paramhs)
  {
    if (this.LQ)
    {
      Drawable localDrawable = null;
      if (this.LK != 0) {
        localDrawable = a(paramContext, paramhs, this.LK);
      }
      a(localDrawable, false, true, false);
    }
  }
  
  void a(Context paramContext, hs paramhs, boolean paramBoolean)
  {
    Drawable localDrawable = null;
    if (this.LL != 0) {
      localDrawable = a(paramContext, paramhs, this.LL);
    }
    if (this.LN != null) {
      this.LN.onImageLoaded(this.LJ.uri, localDrawable, false);
    }
    a(localDrawable, paramBoolean, false, false);
  }
  
  protected abstract void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public void az(int paramInt)
  {
    this.LL = paramInt;
  }
  
  protected boolean b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.LO) && (!paramBoolean2) && ((!paramBoolean1) || (this.LP))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.a
 * JD-Core Version:    0.7.0.1
 */