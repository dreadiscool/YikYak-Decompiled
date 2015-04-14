import java.util.LinkedList;
import java.util.concurrent.Executor;

class JL
  implements Executor
{
  final LinkedList<Runnable> a = new LinkedList();
  Runnable b;
  
  protected void a()
  {
    try
    {
      Runnable localRunnable = (Runnable)this.a.poll();
      this.b = localRunnable;
      if (localRunnable != null) {
        JE.b.execute(this.b);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    try
    {
      this.a.offer(new JM(this, paramRunnable));
      if (this.b == null) {
        a();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     JL
 * JD-Core Version:    0.7.0.1
 */