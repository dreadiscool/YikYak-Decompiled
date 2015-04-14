import android.content.Context;
import com.google.android.gms.analytics.Tracker;
import java.util.ArrayList;

public class fk
  implements Thread.UncaughtExceptionHandler
{
  private final Thread.UncaughtExceptionHandler a;
  private final Tracker b;
  private final Context c;
  private fj d;
  private fl e;
  
  public fk(Tracker paramTracker, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, Context paramContext)
  {
    if (paramTracker == null) {
      throw new NullPointerException("tracker cannot be null");
    }
    if (paramContext == null) {
      throw new NullPointerException("context cannot be null");
    }
    this.a = paramUncaughtExceptionHandler;
    this.b = paramTracker;
    this.d = new fs(paramContext, new ArrayList());
    this.c = paramContext.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder().append("ExceptionReporter created, original handler is ");
    if (paramUncaughtExceptionHandler == null) {}
    for (String str = "null";; str = paramUncaughtExceptionHandler.getClass().getName())
    {
      fA.c(str);
      return;
    }
  }
  
  fl a()
  {
    if (this.e == null) {
      this.e = fl.a(this.c);
    }
    return this.e;
  }
  
  public Thread.UncaughtExceptionHandler b()
  {
    return this.a;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    String str1 = "UncaughtException";
    if (this.d != null) {
      if (paramThread == null) {
        break label120;
      }
    }
    label120:
    for (String str2 = paramThread.getName();; str2 = null)
    {
      str1 = this.d.a(str2, paramThrowable);
      fA.c("Tracking Exception: " + str1);
      this.b.send(new fp().a(str1).a(true).a());
      fl localfl = a();
      localfl.e();
      localfl.f();
      if (this.a != null)
      {
        fA.c("Passing exception to original handler.");
        this.a.uncaughtException(paramThread, paramThrowable);
      }
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     fk
 * JD-Core Version:    0.7.0.1
 */