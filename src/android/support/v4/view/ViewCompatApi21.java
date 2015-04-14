package android.support.v4.view;

import android.view.View;

class ViewCompatApi21
{
  public static float getElevation(View paramView)
  {
    return paramView.getElevation();
  }
  
  public static String getTransitionName(View paramView)
  {
    return paramView.getTransitionName();
  }
  
  public static float getTranslationZ(View paramView)
  {
    return paramView.getTranslationZ();
  }
  
  public static void requestApplyInsets(View paramView)
  {
    paramView.requestApplyInsets();
  }
  
  public static void setElevation(View paramView, float paramFloat)
  {
    paramView.setElevation(paramFloat);
  }
  
  public static void setOnApplyWindowInsetsListener(View paramView, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    paramView.setOnApplyWindowInsetsListener(new ViewCompatApi21.1(paramOnApplyWindowInsetsListener));
  }
  
  public static void setTransitionName(View paramView, String paramString)
  {
    paramView.setTransitionName(paramString);
  }
  
  public static void setTranslationZ(View paramView, float paramFloat)
  {
    paramView.setTranslationZ(paramFloat);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewCompatApi21
 * JD-Core Version:    0.7.0.1
 */