import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class HC
  implements Animator.AnimatorListener
{
  HC(HA paramHA) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    HA.a(this.a);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    HA.a(this.a);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     HC
 * JD-Core Version:    0.7.0.1
 */