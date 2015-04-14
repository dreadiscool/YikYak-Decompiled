import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

final class Jr
  extends Jf
{
  Jr(String paramString, ExecutorService paramExecutorService, long paramLong, TimeUnit paramTimeUnit) {}
  
  public void a()
  {
    try
    {
      IC.g();
      new StringBuilder().append("Executing shutdown hook for ").append(this.a).toString();
      this.b.shutdown();
      if (!this.b.awaitTermination(this.c, this.d))
      {
        IC.g();
        new StringBuilder().append(this.a).append(" did not shut down in the").append(" allocated time. Requesting immediate shutdown.").toString();
        this.b.shutdownNow();
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        IC.g();
        Locale localLocale = Locale.US;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = this.a;
        String.format(localLocale, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", arrayOfObject);
        this.b.shutdownNow();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Jr
 * JD-Core Version:    0.7.0.1
 */