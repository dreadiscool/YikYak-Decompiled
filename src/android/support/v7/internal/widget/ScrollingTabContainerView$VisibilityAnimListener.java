package android.support.v7.internal.widget;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;

public class ScrollingTabContainerView$VisibilityAnimListener
  implements ViewPropertyAnimatorListener
{
  private boolean mCanceled = false;
  private int mFinalVisibility;
  
  protected ScrollingTabContainerView$VisibilityAnimListener(ScrollingTabContainerView paramScrollingTabContainerView) {}
  
  public void onAnimationCancel(View paramView)
  {
    this.mCanceled = true;
  }
  
  public void onAnimationEnd(View paramView)
  {
    if (this.mCanceled) {}
    for (;;)
    {
      return;
      this.this$0.mVisibilityAnim = null;
      this.this$0.setVisibility(this.mFinalVisibility);
    }
  }
  
  public void onAnimationStart(View paramView)
  {
    this.this$0.setVisibility(0);
    this.mCanceled = false;
  }
  
  public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, int paramInt)
  {
    this.mFinalVisibility = paramInt;
    this.this$0.mVisibilityAnim = paramViewPropertyAnimatorCompat;
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ScrollingTabContainerView.VisibilityAnimListener
 * JD-Core Version:    0.7.0.1
 */