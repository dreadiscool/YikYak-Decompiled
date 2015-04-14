import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.yik.yak.ui.activity.PinCodeDialog;

public class DA
  implements View.OnClickListener
{
  public DA(PinCodeDialog paramPinCodeDialog) {}
  
  public void onClick(View paramView)
  {
    String str1 = ((Button)paramView).getText().toString();
    PinCodeDialog.a(this.a).vibrate(75L);
    if (str1.equals("R"))
    {
      PinCodeDialog.a(this.a, "");
      ((TextView)this.a.findViewById(2131558594)).setText("");
      ((TextView)this.a.findViewById(2131558595)).setText("");
      ((TextView)this.a.findViewById(2131558596)).setText("");
      ((TextView)this.a.findViewById(2131558597)).setText("");
      return;
    }
    if (((str1.equals("C")) || (PinCodeDialog.b(this.a).length() != 4)) && ((!str1.equals("C")) || (PinCodeDialog.b(this.a).length() != 0)))
    {
      if (!str1.equals("C")) {
        break label364;
      }
      PinCodeDialog.a(this.a, PinCodeDialog.b(this.a).substring(0, -1 + PinCodeDialog.b(this.a).length()));
    }
    for (;;)
    {
      try
      {
        TextView localTextView1 = (TextView)this.a.findViewById(2131558594);
        if (PinCodeDialog.b(this.a).length() < 1) {
          break label376;
        }
        str2 = "*";
        localTextView1.setText(str2);
        TextView localTextView2 = (TextView)this.a.findViewById(2131558595);
        if (PinCodeDialog.b(this.a).length() < 2) {
          break label390;
        }
        str3 = "*";
        localTextView2.setText(str3);
        TextView localTextView3 = (TextView)this.a.findViewById(2131558596);
        if (PinCodeDialog.b(this.a).length() < 3) {
          break label397;
        }
        str4 = "*";
        localTextView3.setText(str4);
        TextView localTextView4 = (TextView)this.a.findViewById(2131558597);
        if (PinCodeDialog.b(this.a).length() != 4) {
          break label383;
        }
        str5 = "*";
        localTextView4.setText(str5);
      }
      catch (Exception localException) {}
      break;
      break;
      label364:
      PinCodeDialog.a(this.a, str1);
      continue;
      label376:
      String str2 = "";
      continue;
      label383:
      String str5 = "";
      continue;
      label390:
      String str3 = "";
      continue;
      label397:
      String str4 = "";
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     DA
 * JD-Core Version:    0.7.0.1
 */