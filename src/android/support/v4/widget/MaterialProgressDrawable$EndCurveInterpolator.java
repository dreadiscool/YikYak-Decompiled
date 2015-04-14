package android.support.v4.widget;

import android.view.animation.AccelerateDecelerateInterpolator;

class MaterialProgressDrawable$EndCurveInterpolator
  extends AccelerateDecelerateInterpolator
{
  public float getInterpolation(float paramFloat)
  {
    return super.getInterpolation(Math.max(0.0F, 2.0F * (paramFloat - 0.5F)));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.MaterialProgressDrawable.EndCurveInterpolator
 * JD-Core Version:    0.7.0.1
 */