import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

class j
  implements Executor
{
  private ThreadLocal<Integer> a = new ThreadLocal();
  
  private int a()
  {
    Integer localInteger = (Integer)this.a.get();
    if (localInteger == null) {
      localInteger = Integer.valueOf(0);
    }
    int i = 1 + localInteger.intValue();
    this.a.set(Integer.valueOf(i));
    return i;
  }
  
  private int b()
  {
    Integer localInteger = (Integer)this.a.get();
    if (localInteger == null) {
      localInteger = Integer.valueOf(0);
    }
    int i = -1 + localInteger.intValue();
    if (i == 0) {
      this.a.remove();
    }
    for (;;)
    {
      return i;
      this.a.set(Integer.valueOf(i));
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    if (a() <= 15) {}
    for (;;)
    {
      try
      {
        paramRunnable.run();
        return;
      }
      finally
      {
        b();
      }
      h.a().execute(paramRunnable);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     j
 * JD-Core Version:    0.7.0.1
 */