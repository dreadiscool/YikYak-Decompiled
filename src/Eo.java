import android.content.Intent;
import com.yik.yak.ui.activity.SplashScreen;

public class Eo
  implements Runnable
{
  public Eo(SplashScreen paramSplashScreen) {}
  
  public void run()
  {
    this.a.startActivityForResult(new Intent("android.settings.WIFI_SETTINGS"), 5001);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Eo
 * JD-Core Version:    0.7.0.1
 */