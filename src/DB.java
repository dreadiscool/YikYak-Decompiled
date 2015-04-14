import android.view.View;
import android.view.View.OnClickListener;
import com.yik.yak.ui.activity.PinCodeDialog;

public class DB
  implements View.OnClickListener
{
  public DB(PinCodeDialog paramPinCodeDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.setResult(6004);
    PinCodeDialog.c(this.a);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     DB
 * JD-Core Version:    0.7.0.1
 */