package android.support.v4.view;

import android.view.View;

class ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$MyVpaListener
  implements ViewPropertyAnimatorListener
{
  ViewPropertyAnimatorCompat mVpa;
  
  ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$MyVpaListener(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    this.mVpa = paramViewPropertyAnimatorCompat;
  }
  
  public void onAnimationCancel(View paramView)
  {
    Object localObject = paramView.getTag(2113929216);
    if ((localObject instanceof ViewPropertyAnimatorListener)) {}
    for (ViewPropertyAnimatorListener localViewPropertyAnimatorListener = (ViewPropertyAnimatorListener)localObject;; localViewPropertyAnimatorListener = null)
    {
      if (localViewPropertyAnimatorListener != null) {
        localViewPropertyAnimatorListener.onAnimationCancel(paramView);
      }
      return;
    }
  }
  
  public void onAnimationEnd(View paramView)
  {
    if (ViewPropertyAnimatorCompat.access$400(this.mVpa) >= 0)
    {
      ViewCompat.setLayerType(paramView, ViewPropertyAnimatorCompat.access$400(this.mVpa), null);
      ViewPropertyAnimatorCompat.access$402(this.mVpa, -1);
    }
    if (ViewPropertyAnimatorCompat.access$000(this.mVpa) != null) {
      ViewPropertyAnimatorCompat.access$000(this.mVpa).run();
    }
    Object localObject = paramView.getTag(2113929216);
    if ((localObject instanceof ViewPropertyAnimatorListener)) {}
    for (ViewPropertyAnimatorListener localViewPropertyAnimatorListener = (ViewPropertyAnimatorListener)localObject;; localViewPropertyAnimatorListener = null)
    {
      if (localViewPropertyAnimatorListener != null) {
        localViewPropertyAnimatorListener.onAnimationEnd(paramView);
      }
      return;
    }
  }
  
  public void onAnimationStart(View paramView)
  {
    if (ViewPropertyAnimatorCompat.access$400(this.mVpa) >= 0) {
      ViewCompat.setLayerType(paramView, 2, null);
    }
    if (ViewPropertyAnimatorCompat.access$100(this.mVpa) != null) {
      ViewPropertyAnimatorCompat.access$100(this.mVpa).run();
    }
    Object localObject = paramView.getTag(2113929216);
    if ((localObject instanceof ViewPropertyAnimatorListener)) {}
    for (ViewPropertyAnimatorListener localViewPropertyAnimatorListener = (ViewPropertyAnimatorListener)localObject;; localViewPropertyAnimatorListener = null)
    {
      if (localViewPropertyAnimatorListener != null) {
        localViewPropertyAnimatorListener.onAnimationStart(paramView);
      }
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl.MyVpaListener
 * JD-Core Version:    0.7.0.1
 */