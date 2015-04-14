import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.yik.yak.ui.pullrefresh.PullRefreshLayout;

public class GX
  extends Animation
{
  public GX(PullRefreshLayout paramPullRefreshLayout) {}
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    PullRefreshLayout.a(this.a, paramFloat);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     GX
 * JD-Core Version:    0.7.0.1
 */