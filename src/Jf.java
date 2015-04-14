import android.os.Process;

public abstract class Jf
  implements Runnable
{
  protected abstract void a();
  
  public final void run()
  {
    Process.setThreadPriority(10);
    a();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Jf
 * JD-Core Version:    0.7.0.1
 */