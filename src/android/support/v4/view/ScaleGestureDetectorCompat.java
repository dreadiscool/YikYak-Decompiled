package android.support.v4.view;

import android.os.Build.VERSION;

public class ScaleGestureDetectorCompat
{
  static final ScaleGestureDetectorCompat.ScaleGestureDetectorImpl IMPL;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    for (IMPL = new ScaleGestureDetectorCompat.ScaleGestureDetectorCompatKitKatImpl(null);; IMPL = new ScaleGestureDetectorCompat.BaseScaleGestureDetectorImpl(null)) {
      return;
    }
  }
  
  public static boolean isQuickScaleEnabled(Object paramObject)
  {
    return IMPL.isQuickScaleEnabled(paramObject);
  }
  
  public static void setQuickScaleEnabled(Object paramObject, boolean paramBoolean)
  {
    IMPL.setQuickScaleEnabled(paramObject, paramBoolean);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ScaleGestureDetectorCompat
 * JD-Core Version:    0.7.0.1
 */