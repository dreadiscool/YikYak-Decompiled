import android.content.Context;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public abstract class Kk<T>
  implements Kr
{
  protected final Context a;
  protected final ScheduledExecutorService b;
  protected Ks<T> c;
  
  public Kk(Context paramContext, Ks<T> paramKs, Kh paramKh, ScheduledExecutorService paramScheduledExecutorService)
  {
    this.a = paramContext.getApplicationContext();
    this.b = paramScheduledExecutorService;
    this.c = paramKs;
    paramKh.a(this);
  }
  
  protected abstract Ks<T> a();
  
  public void a(T paramT)
  {
    a(new Km(this, paramT));
  }
  
  public void a(T paramT, boolean paramBoolean)
  {
    b(new Kl(this, paramT, paramBoolean));
  }
  
  protected void a(Runnable paramRunnable)
  {
    try
    {
      this.b.submit(paramRunnable).get();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Jg.a(this.a, "Failed to run events task", localException);
      }
    }
  }
  
  public void a(String paramString)
  {
    b(new Kn(this));
  }
  
  public void b()
  {
    b(new Ko(this));
  }
  
  protected void b(Runnable paramRunnable)
  {
    try
    {
      this.b.submit(paramRunnable);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Jg.a(this.a, "Failed to submit events task", localException);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Kk
 * JD-Core Version:    0.7.0.1
 */