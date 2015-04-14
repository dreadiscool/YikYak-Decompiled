import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

final class Jb
  implements ServiceConnection
{
  private boolean a = false;
  private final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue(1);
  
  public IBinder a()
  {
    if (this.a) {
      IC.g();
    }
    this.a = true;
    try
    {
      localIBinder = (IBinder)this.b.poll(200L, TimeUnit.MILLISECONDS);
      return localIBinder;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        IBinder localIBinder = null;
      }
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      this.b.put(paramIBinder);
      label8:
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label8;
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.b.clear();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Jb
 * JD-Core Version:    0.7.0.1
 */