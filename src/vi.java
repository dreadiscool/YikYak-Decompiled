import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class vi
{
  private final Executor a = Executors.newSingleThreadExecutor();
  
  public Future<SharedPreferences> a(Context paramContext, String paramString, vk paramvk)
  {
    FutureTask localFutureTask = new FutureTask(new vj(paramContext, paramString, paramvk));
    this.a.execute(localFutureTask);
    return localFutureTask;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vi
 * JD-Core Version:    0.7.0.1
 */