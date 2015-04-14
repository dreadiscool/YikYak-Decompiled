import android.os.Handler;

class GW
  implements Runnable
{
  GW(GV paramGV) {}
  
  public void run()
  {
    if ((this.a.isRunning()) && (GV.a(this.a) < GV.b(this.a)))
    {
      this.a.invalidateSelf();
      GV.c(this.a).postDelayed(this, 30L);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     GW
 * JD-Core Version:    0.7.0.1
 */