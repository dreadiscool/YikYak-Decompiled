import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

class gy
  extends TimerTask
{
  private gy(gu paramgu) {}
  
  public void run()
  {
    if ((gu.b(this.a) == gx.b) && (gu.e(this.a).isEmpty()) && (gu.f(this.a) + gu.g(this.a) < gu.h(this.a).b()))
    {
      fA.c("Disconnecting due to inactivity");
      gu.i(this.a);
    }
    for (;;)
    {
      return;
      gu.j(this.a).schedule(new gy(this.a), gu.g(this.a));
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     gy
 * JD-Core Version:    0.7.0.1
 */