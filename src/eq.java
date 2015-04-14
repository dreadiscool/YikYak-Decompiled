import android.content.Context;
import com.google.analytics.tracking.android.Tracker;
import java.util.ArrayList;

public class eq
  implements Thread.UncaughtExceptionHandler
{
  private final Thread.UncaughtExceptionHandler a;
  private final Tracker b;
  private final eY c;
  private ep d;
  
  public eq(Tracker paramTracker, eY parameY, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, Context paramContext)
  {
    if (paramTracker == null) {
      throw new NullPointerException("tracker cannot be null");
    }
    if (parameY == null) {
      throw new NullPointerException("serviceManager cannot be null");
    }
    this.a = paramUncaughtExceptionHandler;
    this.b = paramTracker;
    this.c = parameY;
    this.d = new fb(paramContext, new ArrayList());
    StringBuilder localStringBuilder = new StringBuilder().append("ExceptionReporter created, original handler is ");
    if (paramUncaughtExceptionHandler == null) {}
    for (String str = "null";; str = paramUncaughtExceptionHandler.getClass().getName())
    {
      eO.c(str);
      return;
    }
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    String str1 = "UncaughtException";
    if (this.d != null) {
      if (paramThread == null) {
        break label104;
      }
    }
    label104:
    for (String str2 = paramThread.getName();; str2 = null)
    {
      str1 = this.d.a(str2, paramThrowable);
      eO.c("Tracking Exception: " + str1);
      this.b.send(eR.a(str1, Boolean.valueOf(true)).a());
      this.c.c();
      if (this.a != null)
      {
        eO.c("Passing exception to original handler.");
        this.a.uncaughtException(paramThread, paramThrowable);
      }
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     eq
 * JD-Core Version:    0.7.0.1
 */