package android.support.v7.internal.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;

class TintDrawableWrapper
  extends DrawableWrapper
{
  private int mCurrentColor;
  private final PorterDuff.Mode mTintMode;
  private final ColorStateList mTintStateList;
  
  public TintDrawableWrapper(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    this(paramDrawable, paramColorStateList, TintManager.DEFAULT_MODE);
  }
  
  public TintDrawableWrapper(Drawable paramDrawable, ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    super(paramDrawable);
    this.mTintStateList = paramColorStateList;
    this.mTintMode = paramMode;
  }
  
  private boolean updateTint(int[] paramArrayOfInt)
  {
    if (this.mTintStateList != null)
    {
      int i = this.mTintStateList.getColorForState(paramArrayOfInt, this.mCurrentColor);
      if (i != this.mCurrentColor) {
        if (i != 0)
        {
          setColorFilter(i, this.mTintMode);
          this.mCurrentColor = i;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      clearColorFilter();
      break;
    }
  }
  
  public boolean isStateful()
  {
    if (((this.mTintStateList != null) && (this.mTintStateList.isStateful())) || (super.isStateful())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    boolean bool1 = super.setState(paramArrayOfInt);
    if ((updateTint(paramArrayOfInt)) || (bool1)) {}
    for (boolean bool2 = true;; bool2 = false) {
      return bool2;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.TintDrawableWrapper
 * JD-Core Version:    0.7.0.1
 */