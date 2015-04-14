import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.yik.yak.ui.pullrefresh.PullRefreshLayout;

public class GY
  implements Animation.AnimationListener
{
  public GY(PullRefreshLayout paramPullRefreshLayout) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    PullRefreshLayout.a(this.a).stop();
    PullRefreshLayout.b(this.a).setVisibility(8);
    PullRefreshLayout.a(this.a, PullRefreshLayout.c(this.a).getTop());
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     GY
 * JD-Core Version:    0.7.0.1
 */