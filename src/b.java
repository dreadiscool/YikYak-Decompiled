import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class b
{
  static final int a = 1 + e;
  static final int b = 1 + 2 * e;
  private static final b c = new b();
  private static final int e = Runtime.getRuntime().availableProcessors();
  private final Executor d = new d(null);
  
  public static ExecutorService a()
  {
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(a, b, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    a(localThreadPoolExecutor, true);
    return localThreadPoolExecutor;
  }
  
  @SuppressLint({"NewApi"})
  public static void a(ThreadPoolExecutor paramThreadPoolExecutor, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      paramThreadPoolExecutor.allowCoreThreadTimeOut(paramBoolean);
    }
  }
  
  public static Executor b()
  {
    return c.d;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     b
 * JD-Core Version:    0.7.0.1
 */