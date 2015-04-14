import android.os.Handler.Callback;
import android.os.Message;
import com.yik.yak.ui.activity.SplashScreen;

public class Ej
  implements Handler.Callback
{
  public Ej(SplashScreen paramSplashScreen) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.arg1 == 1) || (paramMessage.arg1 == 0)) {
      SplashScreen.a(this.a);
    }
    for (;;)
    {
      return true;
      SplashScreen.b(this.a);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ej
 * JD-Core Version:    0.7.0.1
 */