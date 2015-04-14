import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

final class h
{
  private static final h a = new h();
  private final ExecutorService b;
  private final Executor c;
  
  private h()
  {
    if (!c()) {}
    for (ExecutorService localExecutorService = Executors.newCachedThreadPool();; localExecutorService = b.a())
    {
      this.b = localExecutorService;
      this.c = new j(null);
      return;
    }
  }
  
  public static ExecutorService a()
  {
    return a.b;
  }
  
  static Executor b()
  {
    return a.c;
  }
  
  private static boolean c()
  {
    String str = System.getProperty("java.runtime.name");
    if (str == null) {}
    for (boolean bool = false;; bool = str.toLowerCase(Locale.US).contains("android")) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     h
 * JD-Core Version:    0.7.0.1
 */