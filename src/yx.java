import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.nispok.snackbar.Snackbar;

public class yx
  implements Animation.AnimationListener
{
  public yx(Snackbar paramSnackbar) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.post(new yy(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     yx
 * JD-Core Version:    0.7.0.1
 */