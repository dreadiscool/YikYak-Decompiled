package android.support.v4.view;

import android.view.View;
import android.view.ViewPropertyAnimator;

class ViewPropertyAnimatorCompatKK
{
  public static void setUpdateListener(View paramView, ViewPropertyAnimatorUpdateListener paramViewPropertyAnimatorUpdateListener)
  {
    paramView.animate().setUpdateListener(new ViewPropertyAnimatorCompatKK.1(paramViewPropertyAnimatorUpdateListener, paramView));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewPropertyAnimatorCompatKK
 * JD-Core Version:    0.7.0.1
 */