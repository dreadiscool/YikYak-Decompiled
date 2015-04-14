import android.content.Intent;
import com.yik.yak.ui.activity.SplashScreen;

public class Eq
  implements Runnable
{
  public Eq(SplashScreen paramSplashScreen) {}
  
  public void run()
  {
    this.a.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 5000);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Eq
 * JD-Core Version:    0.7.0.1
 */