import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;

class JG
  extends JO<Params, Result>
{
  JG(JE paramJE)
  {
    super(null);
  }
  
  public Result call()
  {
    JE.a(this.a).set(true);
    Process.setThreadPriority(10);
    return JE.a(this.a, this.a.a(this.b));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     JG
 * JD-Core Version:    0.7.0.1
 */