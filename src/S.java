import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

class S
{
  private final ExecutorService a;
  
  public S(ExecutorService paramExecutorService)
  {
    this.a = paramExecutorService;
  }
  
  <T> T a(Callable<T> paramCallable)
  {
    Object localObject1 = null;
    try
    {
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        localObject1 = this.a.submit(paramCallable).get(4L, TimeUnit.SECONDS);
      }
      else
      {
        Object localObject2 = this.a.submit(paramCallable).get();
        localObject1 = localObject2;
      }
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      IC.g();
    }
    catch (Exception localException)
    {
      IC.g();
    }
    return localObject1;
  }
  
  Future<?> a(Runnable paramRunnable)
  {
    try
    {
      Future localFuture2 = this.a.submit(new T(this, paramRunnable));
      localFuture1 = localFuture2;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      for (;;)
      {
        IC.g();
        Future localFuture1 = null;
      }
    }
    return localFuture1;
  }
  
  <T> Future<T> b(Callable<T> paramCallable)
  {
    try
    {
      Future localFuture2 = this.a.submit(new U(this, paramCallable));
      localFuture1 = localFuture2;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      for (;;)
      {
        IC.g();
        Future localFuture1 = null;
      }
    }
    return localFuture1;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     S
 * JD-Core Version:    0.7.0.1
 */