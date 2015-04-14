package android.support.v7.widget;

import android.view.animation.Interpolator;

final class RecyclerView$3
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    float f = paramFloat - 1.0F;
    return 1.0F + f * (f * (f * (f * f)));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.3
 * JD-Core Version:    0.7.0.1
 */