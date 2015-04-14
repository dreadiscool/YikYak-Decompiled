import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;

class FI
  implements Animation.AnimationListener
{
  FI(FH paramFH) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.c.setVisibility(8);
    FH.a(this.a).findViewById(2131558656).setVisibility(8);
    FH.a(this.a).findViewById(2131558658).setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     FI
 * JD-Core Version:    0.7.0.1
 */