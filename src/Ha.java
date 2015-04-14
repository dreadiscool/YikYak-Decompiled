import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.yik.yak.ui.pullrefresh.PullRefreshLayout;

public class Ha
  implements Animation.AnimationListener
{
  public Ha(PullRefreshLayout paramPullRefreshLayout) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (PullRefreshLayout.f(this.a))
    {
      PullRefreshLayout.a(this.a).start();
      if ((PullRefreshLayout.g(this.a)) && (PullRefreshLayout.h(this.a) != null)) {
        PullRefreshLayout.h(this.a).a();
      }
    }
    for (;;)
    {
      PullRefreshLayout.a(this.a, PullRefreshLayout.c(this.a).getTop());
      return;
      PullRefreshLayout.a(this.a).stop();
      PullRefreshLayout.b(this.a).setVisibility(8);
      PullRefreshLayout.i(this.a);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    PullRefreshLayout.b(this.a).setVisibility(0);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ha
 * JD-Core Version:    0.7.0.1
 */