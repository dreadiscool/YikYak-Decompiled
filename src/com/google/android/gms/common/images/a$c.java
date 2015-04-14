package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import hV;
import hu;
import java.lang.ref.WeakReference;

public final class a$c
  extends a
{
  private WeakReference<ImageManager.OnImageLoadedListener> LT;
  
  public a$c(ImageManager.OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
  {
    super(paramUri, 0);
    hu.a(paramOnImageLoadedListener);
    this.LT = new WeakReference(paramOnImageLoadedListener);
  }
  
  protected void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!paramBoolean2)
    {
      ImageManager.OnImageLoadedListener localOnImageLoadedListener = (ImageManager.OnImageLoadedListener)this.LT.get();
      if (localOnImageLoadedListener != null) {
        localOnImageLoadedListener.onImageLoaded(this.LJ.uri, paramDrawable, paramBoolean3);
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = false;
    if (!(paramObject instanceof c)) {}
    for (;;)
    {
      return bool1;
      if (this != paramObject) {
        break;
      }
      bool1 = true;
    }
    c localc = (c)paramObject;
    ImageManager.OnImageLoadedListener localOnImageLoadedListener1 = (ImageManager.OnImageLoadedListener)this.LT.get();
    ImageManager.OnImageLoadedListener localOnImageLoadedListener2 = (ImageManager.OnImageLoadedListener)localc.LT.get();
    if ((localOnImageLoadedListener2 != null) && (localOnImageLoadedListener1 != null) && (hV.a(localOnImageLoadedListener2, localOnImageLoadedListener1)) && (hV.a(localc.LJ, this.LJ))) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      bool1 = bool2;
      break;
    }
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.LJ;
    return hV.a(arrayOfObject);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.a.c
 * JD-Core Version:    0.7.0.1
 */