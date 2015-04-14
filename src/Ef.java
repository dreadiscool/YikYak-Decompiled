import android.view.inputmethod.InputMethodManager;
import com.yik.yak.ui.activity.SendAYak;
import com.yik.yak.ui.view.LinkDetectingEditText;

public class Ef
  implements Runnable
{
  public Ef(SendAYak paramSendAYak) {}
  
  public void run()
  {
    SendAYak.i(this.a).requestFocus();
    ((InputMethodManager)this.a.getSystemService("input_method")).showSoftInput(SendAYak.i(this.a), 1);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ef
 * JD-Core Version:    0.7.0.1
 */