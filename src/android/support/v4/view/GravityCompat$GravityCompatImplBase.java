package android.support.v4.view;

import android.graphics.Rect;
import android.view.Gravity;

class GravityCompat$GravityCompatImplBase
  implements GravityCompat.GravityCompatImpl
{
  public void apply(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, int paramInt4, int paramInt5, Rect paramRect2, int paramInt6)
  {
    Gravity.apply(paramInt1, paramInt2, paramInt3, paramRect1, paramInt4, paramInt5, paramRect2);
  }
  
  public void apply(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, Rect paramRect2, int paramInt4)
  {
    Gravity.apply(paramInt1, paramInt2, paramInt3, paramRect1, paramRect2);
  }
  
  public void applyDisplay(int paramInt1, Rect paramRect1, Rect paramRect2, int paramInt2)
  {
    Gravity.applyDisplay(paramInt1, paramRect1, paramRect2);
  }
  
  public int getAbsoluteGravity(int paramInt1, int paramInt2)
  {
    return 0xFF7FFFFF & paramInt1;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.GravityCompat.GravityCompatImplBase
 * JD-Core Version:    0.7.0.1
 */