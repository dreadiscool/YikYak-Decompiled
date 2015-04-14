import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import com.yik.yak.ui.activity.YakarmaActivity;

public class Ey
  implements Runnable
{
  public Ey(YakarmaActivity paramYakarmaActivity) {}
  
  public void run()
  {
    YakarmaActivity.a(this.a).getViewTreeObserver().addOnScrollChangedListener(this.a.b);
    ScrollView localScrollView = YakarmaActivity.a(this.a);
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = YakarmaActivity.a(this.a).getChildAt(0).getHeight();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(localScrollView, "scrollY", arrayOfInt);
    localObjectAnimator.setStartDelay(1000L);
    localObjectAnimator.setDuration(4000L);
    localObjectAnimator.start();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ey
 * JD-Core Version:    0.7.0.1
 */