package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class ViewPropertyAnimatorCompatJB$1
  extends AnimatorListenerAdapter
{
  ViewPropertyAnimatorCompatJB$1(ViewPropertyAnimatorListener paramViewPropertyAnimatorListener, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.val$listener.onAnimationCancel(this.val$view);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.val$listener.onAnimationEnd(this.val$view);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.val$listener.onAnimationStart(this.val$view);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewPropertyAnimatorCompatJB.1
 * JD-Core Version:    0.7.0.1
 */