import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

final class ea
  implements ServiceConnection
{
  ea(dZ paramdZ) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    eO.c("service connected, binder: " + paramIBinder);
    try
    {
      if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(paramIBinder.getInterfaceDescriptor()))
      {
        eO.c("bound to service");
        dZ.a(this.a, gb.a(paramIBinder));
        dZ.a(this.a);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        dZ.b(this.a).unbindService(this);
        dZ.a(this.a, null);
        dZ.c(this.a).a(2, null);
      }
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    eO.c("service disconnected: " + paramComponentName);
    dZ.a(this.a, null);
    dZ.d(this.a).b();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ea
 * JD-Core Version:    0.7.0.1
 */