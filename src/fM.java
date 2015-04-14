import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

final class fM
  implements ServiceConnection
{
  fM(fL paramfL) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    fA.c("service connected, binder: " + paramIBinder);
    for (;;)
    {
      try
      {
        if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(paramIBinder.getInterfaceDescriptor()))
        {
          fA.c("bound to service");
          fL.a(this.a, hi.a(paramIBinder));
          fL.a(this.a);
          return;
        }
      }
      catch (RemoteException localRemoteException) {}
      try
      {
        fL.b(this.a).unbindService(this);
        label73:
        fL.a(this.a, null);
        fL.c(this.a).a(2, null);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        break label73;
      }
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    fA.c("service disconnected: " + paramComponentName);
    fL.a(this.a, null);
    fL.d(this.a).e();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     fM
 * JD-Core Version:    0.7.0.1
 */