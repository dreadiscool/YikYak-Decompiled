import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.google.android.gms.internal.ha;
import java.util.List;
import java.util.Map;

class fL
  implements fK
{
  private ServiceConnection a;
  private fN b;
  private fO c;
  private Context d;
  private hh e;
  
  public fL(Context paramContext, fN paramfN, fO paramfO)
  {
    this.d = paramContext;
    if (paramfN == null) {
      throw new IllegalArgumentException("onConnectedListener cannot be null");
    }
    this.b = paramfN;
    if (paramfO == null) {
      throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
    }
    this.c = paramfO;
  }
  
  private hh f()
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
    this.b.d();
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
        fA.a("clear hits failed: " + localRemoteException);
      }
    }
  }
  
  public void a(Map<String, String> paramMap, long paramLong, String paramString, List<ha> paramList)
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
        fA.a("sendHit failed: " + localRemoteException);
      }
    }
  }
  
  public void b()
  {
    Intent localIntent = new Intent("com.google.android.gms.analytics.service.START");
    localIntent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
    localIntent.putExtra("app_package_name", this.d.getPackageName());
    if (this.a != null) {
      fA.a("Calling connect() while still connected, missing disconnect().");
    }
    for (;;)
    {
      return;
      this.a = new fM(this);
      boolean bool = this.d.bindService(localIntent, this.a, 129);
      fA.c("connect: bindService returned " + bool + " for " + localIntent);
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
      this.b.e();
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
 * Qualified Name:     fL
 * JD-Core Version:    0.7.0.1
 */