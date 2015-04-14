package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;

class DrawableCompat$LDrawableImpl
  extends DrawableCompat.KitKatDrawableImpl
{
  public void setHotspot(Drawable paramDrawable, float paramFloat1, float paramFloat2)
  {
    DrawableCompatL.setHotspot(paramDrawable, paramFloat1, paramFloat2);
  }
  
  public void setHotspotBounds(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    DrawableCompatL.setHotspotBounds(paramDrawable, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setTint(Drawable paramDrawable, int paramInt)
  {
    DrawableCompatL.setTint(paramDrawable, paramInt);
  }
  
  public void setTintList(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    DrawableCompatL.setTintList(paramDrawable, paramColorStateList);
  }
  
  public void setTintMode(Drawable paramDrawable, PorterDuff.Mode paramMode)
  {
    DrawableCompatL.setTintMode(paramDrawable, paramMode);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.graphics.drawable.DrawableCompat.LDrawableImpl
 * JD-Core Version:    0.7.0.1
 */