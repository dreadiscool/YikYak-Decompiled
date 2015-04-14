import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.google.android.gms.analytics.internal.Command;
import java.util.List;
import java.util.Map;

class dZ
  implements dY
{
  private ServiceConnection a;
  private eb b;
  private ec c;
  private Context d;
  private ga e;
  
  public dZ(Context paramContext, eb parameb, ec paramec)
  {
    this.d = paramContext;
    if (parameb == null) {
      throw new IllegalArgumentException("onConnectedListener cannot be null");
    }
    this.b = parameb;
    if (paramec == null) {
      throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
    }
    this.c = paramec;
  }
  
  private ga f()
  {
    d();
    return this.e;
  }
  
  private void g()
  {
    h();
  }
  
  private void h()
  {
    this.b.a();
  }
  
  public void a()
  {
    try
    {
      f().a();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        eO.a("clear hits failed: " + localRemoteException);
      }
    }
  }
  
  public void a(Map<String, String> paramMap, long paramLong, String paramString, List<Command> paramList)
  {
    try
    {
      f().a(paramMap, paramLong, paramString, paramList);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        eO.a("sendHit failed: " + localRemoteException);
      }
    }
  }
  
  public void b()
  {
    Intent localIntent = new Intent("com.google.android.gms.analytics.service.START");
    localIntent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
    localIntent.putExtra("app_package_name", this.d.getPackageName());
    if (this.a != null) {
      eO.a("Calling connect() while still connected, missing disconnect().");
    }
    for (;;)
    {
      return;
      this.a = new ea(this);
      boolean bool = this.d.bindService(localIntent, this.a, 129);
      eO.c("connect: bindService returned " + bool + " for " + localIntent);
      if (!bool)
      {
        this.a = null;
        this.c.a(1, null);
      }
    }
  }
  
  public void c()
  {
    this.e = null;
    if (this.a != null) {}
    try
    {
      this.d.unbindService(this.a);
      label23:
      this.a = null;
      this.b.b();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label23;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label23;
    }
  }
  
  protected void d()
  {
    if (!e()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
  }
  
  public boolean e()
  {
    if (this.e != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     dZ
 * JD-Core Version:    0.7.0.1
 */