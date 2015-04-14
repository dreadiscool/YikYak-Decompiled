import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AutoCompleteTextView;
import com.yik.yak.ui.activity.PeekSearchActivity;

public class Ds
  implements View.OnTouchListener
{
  public Ds(PeekSearchActivity paramPeekSearchActivity, Drawable paramDrawable) {}
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    try
    {
      if ((paramMotionEvent.getAction() == 1) && (paramMotionEvent.getX() > PeekSearchActivity.d(this.b).getWidth() - PeekSearchActivity.d(this.b).getPaddingRight() - this.a.getIntrinsicWidth())) {
        PeekSearchActivity.d(this.b).setText("");
      }
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ds
 * JD-Core Version:    0.7.0.1
 */