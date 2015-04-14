import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class HB
  implements ValueAnimator.AnimatorUpdateListener
{
  HB(HA paramHA) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    HA.a(this.a, i);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     HB
 * JD-Core Version:    0.7.0.1
 */