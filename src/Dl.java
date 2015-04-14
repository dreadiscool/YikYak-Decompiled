import android.os.Handler.Callback;
import android.os.Message;
import com.yik.yak.ui.activity.MainActivity;

public class Dl
  implements Handler.Callback
{
  public Dl(MainActivity paramMainActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    this.a.a();
    return true;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Dl
 * JD-Core Version:    0.7.0.1
 */