import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ScrollView;
import com.yik.yak.ui.activity.YakarmaActivity;

public class Ev
  implements ViewTreeObserver.OnScrollChangedListener
{
  public Ev(YakarmaActivity paramYakarmaActivity) {}
  
  public void onScrollChanged()
  {
    int i = YakarmaActivity.a(this.a).getScrollY();
    YakarmaActivity.b(this.a).setScrollY(i / 3);
    YakarmaActivity.c(this.a).setScrollY(i / 2);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ev
 * JD-Core Version:    0.7.0.1
 */