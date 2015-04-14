import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.AutoCompleteTextView;
import android.widget.Filter;
import com.yik.yak.ui.activity.PeekSearchActivity;

public class Dq
  implements View.OnKeyListener
{
  public Dq(PeekSearchActivity paramPeekSearchActivity) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    int i = 1;
    if ((paramKeyEvent.getAction() == i) && ((paramInt == 66) || (paramInt == 84))) {}
    for (;;)
    {
      try
      {
        PeekSearchActivity.c(this.a).a = true;
        PeekSearchActivity.c(this.a).getFilter().filter(PeekSearchActivity.d(this.a).getText());
        PeekSearchActivity.d(this.a).showDropDown();
        If.a().h(PeekSearchActivity.d(this.a).getText().toString());
        return i;
      }
      catch (Exception localException)
      {
        PeekSearchActivity.c(this.a).a = false;
        continue;
      }
      int j = 0;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Dq
 * JD-Core Version:    0.7.0.1
 */