import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.nispok.snackbar.Snackbar;

public class yv
  implements Animation.AnimationListener
{
  public yv(Snackbar paramSnackbar) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (Snackbar.k(this.a) != null) {
      Snackbar.c(this.a, false);
    }
    this.a.post(new yw(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     yv
 * JD-Core Version:    0.7.0.1
 */