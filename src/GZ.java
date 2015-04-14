import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.yik.yak.ui.pullrefresh.PullRefreshLayout;

public class GZ
  extends Animation
{
  public GZ(PullRefreshLayout paramPullRefreshLayout) {}
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    int i = PullRefreshLayout.d(this.a);
    int j = PullRefreshLayout.e(this.a) + (int)(paramFloat * (i - PullRefreshLayout.e(this.a))) - PullRefreshLayout.c(this.a).getTop();
    PullRefreshLayout.a(this.a, j, false);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     GZ
 * JD-Core Version:    0.7.0.1
 */