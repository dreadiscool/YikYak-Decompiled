import com.yik.yak.ui.activity.SplashScreen;

public class Ep
  implements Runnable
{
  public Ep(SplashScreen paramSplashScreen) {}
  
  public void run()
  {
    if (BV.getYakkerID().isEmpty()) {
      this.a.finish();
    }
    for (;;)
    {
      return;
      SplashScreen.f(this.a);
      SplashScreen.e(this.a);
    }
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     Ep

 * JD-Core Version:    0.7.0.1

 */