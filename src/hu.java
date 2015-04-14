import android.os.Looper;

public final class hu
{
  public static void a(Object paramObject)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("null reference");
    }
  }
  
  public static void a(String paramString)
  {
    if (Looper.getMainLooper().getThread() != Thread.currentThread())
    {
      new StringBuilder().append("checkMainThread: current thread ").append(Thread.currentThread()).append(" IS NOT the main thread ").append(Looper.getMainLooper().getThread()).append("!").toString();
      throw new IllegalStateException(paramString);
    }
  }
  
  public static void b(String paramString)
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      new StringBuilder().append("checkNotMainThread: current thread ").append(Thread.currentThread()).append(" IS the main thread ").append(Looper.getMainLooper().getThread()).append("!").toString();
      throw new IllegalStateException(paramString);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     hu
 * JD-Core Version:    0.7.0.1
 */