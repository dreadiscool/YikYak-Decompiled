import com.mixpanel.android.mpmetrics.MixpanelAPI;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class uW
  implements Runnable, uZ
{
  private final Set<Object> b = new HashSet();
  private final Executor c = Executors.newSingleThreadExecutor();
  
  private uW(MixpanelAPI paramMixpanelAPI) {}
  
  public void a()
  {
    this.c.execute(this);
  }
  
  public void run()
  {
    try
    {
      Iterator localIterator = this.b.iterator();
      if (localIterator.hasNext()) {
        localIterator.next();
      }
      return;
    }
    finally {}
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     uW
 * JD-Core Version:    0.7.0.1
 */