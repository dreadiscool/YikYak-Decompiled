import android.os.Message;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.yik.yak.ui.activity.MainActivity;

public class Do
  extends BY<MainActivity>
{
  public Do(MainActivity paramMainActivity)
  {
    super(paramMainActivity);
  }
  
  public boolean a(MainActivity paramMainActivity, Message paramMessage)
  {
    if (paramMessage.arg1 <= 0) {
      MainActivity.b(paramMainActivity).setVisibility(8);
    }
    for (;;)
    {
      MainActivity.c(paramMainActivity).setText(String.valueOf(paramMessage.arg1));
      return true;
      MainActivity.b(paramMainActivity).setVisibility(0);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Do
 * JD-Core Version:    0.7.0.1
 */