package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

public class MarginLayoutParamsCompat
{
  static final MarginLayoutParamsCompat.MarginLayoutParamsCompatImpl IMPL;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 17) {}
    for (IMPL = new MarginLayoutParamsCompat.MarginLayoutParamsCompatImplJbMr1();; IMPL = new MarginLayoutParamsCompat.MarginLayoutParamsCompatImplBase()) {
      return;
    }
  }
  
  public static int getLayoutDirection(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    return IMPL.getLayoutDirection(paramMarginLayoutParams);
  }
  
  public static int getMarginEnd(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    return IMPL.getMarginEnd(paramMarginLayoutParams);
  }
  
  public static int getMarginStart(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    return IMPL.getMarginStart(paramMarginLayoutParams);
  }
  
  public static boolean isMarginRelative(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    return IMPL.isMarginRelative(paramMarginLayoutParams);
  }
  
  public static void resolveLayoutDirection(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt)
  {
    IMPL.resolveLayoutDirection(paramMarginLayoutParams, paramInt);
  }
  
  public static void setLayoutDirection(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt)
  {
    IMPL.setLayoutDirection(paramMarginLayoutParams, paramInt);
  }
  
  public static void setMarginEnd(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt)
  {
    IMPL.setMarginEnd(paramMarginLayoutParams, paramInt);
  }
  
  public static void setMarginStart(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt)
  {
    IMPL.setMarginStart(paramMarginLayoutParams, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.MarginLayoutParamsCompat
 * JD-Core Version:    0.7.0.1
 */