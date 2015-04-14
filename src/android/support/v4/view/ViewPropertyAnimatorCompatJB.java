package android.support.v4.view;

import android.view.View;
import android.view.ViewPropertyAnimator;

class ViewPropertyAnimatorCompatJB
{
  public static void setListener(View paramView, ViewPropertyAnimatorListener paramViewPropertyAnimatorListener)
  {
    if (paramViewPropertyAnimatorListener != null) {
      paramView.animate().setListener(new ViewPropertyAnimatorCompatJB.1(paramViewPropertyAnimatorListener, paramView));
    }
    for (;;)
    {
      return;
      paramView.animate().setListener(null);
    }
  }
  
  public static void withEndAction(View paramView, Runnable paramRunnable)
  {
    paramView.animate().withEndAction(paramRunnable);
  }
  
  public static void withLayer(View paramView)
  {
    paramView.animate().withLayer();
  }
  
  public static void withStartAction(View paramView, Runnable paramRunnable)
  {
    paramView.animate().withStartAction(paramRunnable);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewPropertyAnimatorCompatJB
 * JD-Core Version:    0.7.0.1
 */