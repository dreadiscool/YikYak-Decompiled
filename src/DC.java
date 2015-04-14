import android.content.Intent;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.yik.yak.ui.activity.PinCodeDialog;

public class DC
  implements View.OnClickListener
{
  public DC(PinCodeDialog paramPinCodeDialog) {}
  
  public void onClick(View paramView)
  {
    if (PinCodeDialog.b(this.a).length() != 4) {
      Toast.makeText(PinCodeDialog.d(this.a), "Pin Code is too short.", 0).show();
    }
    for (;;)
    {
      return;
      if (PinCodeDialog.e(this.a).equals("new"))
      {
        Intent localIntent1 = new Intent();
        localIntent1.putExtra("pin", PinCodeDialog.b(this.a));
        this.a.setResult(6003, localIntent1);
        PinCodeDialog.c(this.a);
      }
      else if (PinCodeDialog.e(this.a).equals(PinCodeDialog.b(this.a)))
      {
        Intent localIntent2 = new Intent();
        localIntent2.putExtra("pin", PinCodeDialog.b(this.a));
        this.a.setResult(6003, localIntent2);
        PinCodeDialog.c(this.a);
      }
      else
      {
        PinCodeDialog.a(this.a).vibrate(150L);
        Toast.makeText(PinCodeDialog.d(this.a), "Pin Codes do not match.", 0).show();
        PinCodeDialog.a(this.a, "");
        ((TextView)this.a.findViewById(2131558594)).setText("");
        ((TextView)this.a.findViewById(2131558595)).setText("");
        ((TextView)this.a.findViewById(2131558596)).setText("");
        ((TextView)this.a.findViewById(2131558597)).setText("");
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     DC
 * JD-Core Version:    0.7.0.1
 */