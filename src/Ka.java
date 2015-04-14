import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Ka
  extends ThreadPoolExecutor
{
  private static final int a = Runtime.getRuntime().availableProcessors();
  private static final int b = 1 + a;
  private static final int c = 1 + 2 * a;
  
  <T extends Runnable,  extends JP,  extends Kc,  extends JY> Ka(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, JQ<T> paramJQ, ThreadFactory paramThreadFactory)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramJQ, paramThreadFactory);
    prestartAllCoreThreads();
  }
  
  public static Ka a()
  {
    return a(b, c);
  }
  
  public static <T extends Runnable,  extends JP,  extends Kc,  extends JY> Ka a(int paramInt1, int paramInt2)
  {
    return new Ka(paramInt1, paramInt2, 1L, TimeUnit.SECONDS, new JQ(), new Kb(10));
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    Kc localKc = (Kc)paramRunnable;
    localKc.b(true);
    localKc.a(paramThrowable);
    b().d();
    super.afterExecute(paramRunnable, paramThrowable);
  }
  
  public JQ b()
  {
    return (JQ)super.getQueue();
  }
  
  public void execute(Runnable paramRunnable)
  {
    if (JZ.a(paramRunnable)) {
      super.execute(paramRunnable);
    }
    for (;;)
    {
      return;
      super.execute(newTaskFor(paramRunnable, null));
    }
  }
  
  protected <T> RunnableFuture<T> newTaskFor(Runnable paramRunnable, T paramT)
  {
    return new JX(paramRunnable, paramT);
  }
  
  protected <T> RunnableFuture<T> newTaskFor(Callable<T> paramCallable)
  {
    return new JX(paramCallable);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ka
 * JD-Core Version:    0.7.0.1
 */