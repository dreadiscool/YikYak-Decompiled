import android.os.Message;

class wz
  implements Runnable
{
  private volatile boolean b = true;
  
  public wz(ww paramww) {}
  
  public void a()
  {
    this.b = false;
    ww.a(this.a).post(this);
  }
  
  public void b()
  {
    this.b = true;
    ww.a(this.a).removeCallbacks(this);
  }
  
  public void run()
  {
    if (!this.b)
    {
      Message localMessage = ww.a(this.a).obtainMessage(1);
      ww.a(this.a).sendMessage(localMessage);
    }
    ww.a(this.a).postDelayed(this, 30000L);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wz
 * JD-Core Version:    0.7.0.1
 */