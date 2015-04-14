import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

class eB
  extends TimerTask
{
  private eB(ew paramew) {}
  
  public void run()
  {
    if ((ew.b(this.a) == eA.b) && (ew.e(this.a).isEmpty()) && (ew.f(this.a) + ew.g(this.a) < ew.h(this.a).a()))
    {
      eO.c("Disconnecting due to inactivity");
      ew.i(this.a);
    }
    for (;;)
    {
      return;
      ew.j(this.a).schedule(new eB(this.a), ew.g(this.a));
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     eB
 * JD-Core Version:    0.7.0.1
 */