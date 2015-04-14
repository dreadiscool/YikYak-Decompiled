import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.ImageView;
import com.yik.yak.ui.activity.SendAYak;

public class DM
  implements View.OnFocusChangeListener
{
  public DM(SendAYak paramSendAYak) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      SendAYak.l(this.a).setImageResource(2130837564);
      SendAYak.a(this.a, SendAYak.m(this.a), true);
      SendAYak.c(this.a, true);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     DM
 * JD-Core Version:    0.7.0.1
 */