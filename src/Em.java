import android.os.Handler.Callback;
import android.os.Message;
import com.yik.yak.ui.activity.SplashScreen;

public class Em
  implements Handler.Callback
{
  public Em(SplashScreen paramSplashScreen) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      SplashScreen.c(this.a);
    }
    for (;;)
    {
      return false;
      if (paramMessage.arg1 == -1) {
        SplashScreen.d(this.a);
      } else {
        SplashScreen.c(this.a);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Em
 * JD-Core Version:    0.7.0.1
 */