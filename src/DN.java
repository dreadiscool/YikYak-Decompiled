import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.yik.yak.ui.activity.SendAYak;

public class DN
  implements View.OnClickListener
{
  public DN(SendAYak paramSendAYak) {}
  
  public void onClick(View paramView)
  {
    if (SendAYak.n(this.a))
    {
      SendAYak.l(this.a).setImageResource(2130837565);
      SendAYak.a(this.a, SendAYak.m(this.a), false);
      SendAYak.c(this.a, false);
    }
    for (;;)
    {
      return;
      SendAYak.l(this.a).setImageResource(2130837564);
      SendAYak.a(this.a, SendAYak.m(this.a), true);
      if (SendAYak.m(this.a).getText().toString().equals("")) {
        SendAYak.m(this.a).requestFocus();
      }
      SendAYak.c(this.a, true);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     DN
 * JD-Core Version:    0.7.0.1
 */