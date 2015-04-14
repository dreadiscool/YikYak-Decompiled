import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import com.yik.yak.ui.activity.YakarmaActivity;

public class Ew
  implements View.OnTouchListener
{
  public Ew(YakarmaActivity paramYakarmaActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    YakarmaActivity.a(this.a).getViewTreeObserver().addOnScrollChangedListener(this.a.b);
    return false;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ew
 * JD-Core Version:    0.7.0.1
 */