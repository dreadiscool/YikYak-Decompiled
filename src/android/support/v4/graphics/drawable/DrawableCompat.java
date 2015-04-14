package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public class DrawableCompat
{
  static final DrawableCompat.DrawableImpl IMPL;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21) {
      IMPL = new DrawableCompat.LDrawableImpl();
    }
    for (;;)
    {
      return;
      if (i >= 19) {
        IMPL = new DrawableCompat.KitKatDrawableImpl();
      } else if (i >= 11) {
        IMPL = new DrawableCompat.HoneycombDrawableImpl();
      } else {
        IMPL = new DrawableCompat.BaseDrawableImpl();
      }
    }
  }
  
  public static boolean isAutoMirrored(Drawable paramDrawable)
  {
    return IMPL.isAutoMirrored(paramDrawable);
  }
  
  public static void jumpToCurrentState(Drawable paramDrawable)
  {
    IMPL.jumpToCurrentState(paramDrawable);
  }
  
  public static void setAutoMirrored(Drawable paramDrawable, boolean paramBoolean)
  {
    IMPL.setAutoMirrored(paramDrawable, paramBoolean);
  }
  
  public static void setHotspot(Drawable paramDrawable, float paramFloat1, float paramFloat2)
  {
    IMPL.setHotspot(paramDrawable, paramFloat1, paramFloat2);
  }
  
  public static void setHotspotBounds(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    IMPL.setHotspotBounds(paramDrawable, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void setTint(Drawable paramDrawable, int paramInt)
  {
    IMPL.setTint(paramDrawable, paramInt);
  }
  
  public static void setTintList(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    IMPL.setTintList(paramDrawable, paramColorStateList);
  }
  
  public static void setTintMode(Drawable paramDrawable, PorterDuff.Mode paramMode)
  {
    IMPL.setTintMode(paramDrawable, paramMode);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.graphics.drawable.DrawableCompat
 * JD-Core Version:    0.7.0.1
 */