import android.os.Handler;

class He
  implements Runnable
{
  He(Hd paramHd) {}
  
  public void run()
  {
    if (this.a.isRunning())
    {
      this.a.invalidateSelf();
      Hd.a(this.a).postDelayed(this, 20L);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     He
 * JD-Core Version:    0.7.0.1
 */