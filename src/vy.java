import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.mixpanel.android.surveys.CardCarouselLayout;

public class vy
  implements Animation.AnimationListener
{
  public vy(CardCarouselLayout paramCardCarouselLayout, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vy
 * JD-Core Version:    0.7.0.1
 */