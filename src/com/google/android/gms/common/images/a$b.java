package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.internal.jb;
import hV;
import hl;
import hu;
import java.lang.ref.WeakReference;

public final class a$b
  extends a
{
  private WeakReference<ImageView> LS;
  
  public a$b(ImageView paramImageView, int paramInt)
  {
    super(null, paramInt);
    hu.a(paramImageView);
    this.LS = new WeakReference(paramImageView);
  }
  
  public a$b(ImageView paramImageView, Uri paramUri)
  {
    super(paramUri, 0);
    hu.a(paramImageView);
    this.LS = new WeakReference(paramImageView);
  }
  
  private void a(ImageView paramImageView, Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!paramBoolean2) && (!paramBoolean3)) {}
    for (int i = 1; (i != 0) && ((paramImageView instanceof jb)); i = 0)
    {
      int k = ((jb)paramImageView).a();
      if ((this.LL == 0) || (k != this.LL)) {
        break;
      }
      return;
    }
    boolean bool = b(paramBoolean1, paramBoolean2);
    if ((this.LM) && (paramDrawable != null)) {}
    for (Object localObject = paramDrawable.getConstantState().newDrawable();; localObject = paramDrawable)
    {
      if (bool) {
        localObject = a(paramImageView.getDrawable(), (Drawable)localObject);
      }
      paramImageView.setImageDrawable((Drawable)localObject);
      jb localjb;
      Uri localUri;
      if ((paramImageView instanceof jb))
      {
        localjb = (jb)paramImageView;
        if (!paramBoolean3) {
          break label180;
        }
        localUri = this.LJ.uri;
        label136:
        localjb.a(localUri);
        if (i == 0) {
          break label186;
        }
      }
      label180:
      label186:
      for (int j = this.LL;; j = 0)
      {
        localjb.a(j);
        if (!bool) {
          break;
        }
        ((hl)localObject).a(250);
        break;
        localUri = null;
        break label136;
      }
    }
  }
  
  protected void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ImageView localImageView = (ImageView)this.LS.get();
    if (localImageView != null) {
      a(localImageView, paramDrawable, paramBoolean1, paramBoolean2, paramBoolean3);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = false;
    if (!(paramObject instanceof b)) {}
    for (;;)
    {
      return bool1;
      if (this != paramObject) {
        break;
      }
      bool1 = true;
    }
    b localb = (b)paramObject;
    ImageView localImageView1 = (ImageView)this.LS.get();
    ImageView localImageView2 = (ImageView)localb.LS.get();
    if ((localImageView2 != null) && (localImageView1 != null) && (hV.a(localImageView2, localImageView1))) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      bool1 = bool2;
      break;
    }
  }
  
  public int hashCode()
  {
    return 0;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.a.b
 * JD-Core Version:    0.7.0.1
 */