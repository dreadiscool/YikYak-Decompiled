import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

class d
  implements Executor
{
  public void execute(Runnable paramRunnable)
  {
    new Handler(Looper.getMainLooper()).post(paramRunnable);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     d
 * JD-Core Version:    0.7.0.1
 */