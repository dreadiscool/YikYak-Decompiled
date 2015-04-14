import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;

public final class hC
  implements ServiceConnection
{
  public hC(hy paramhy) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.b(paramIBinder);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.a.sendMessage(this.a.a.obtainMessage(4, Integer.valueOf(1)));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     hC
 * JD-Core Version:    0.7.0.1
 */