import android.content.Context;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationRequest;

public class iO
  extends iy
{
  private final iL e = new iL(paramContext, this.d);
  private final iw f = iw.a(paramContext, paramString3, paramString4, this.d);
  private final hk g = hk.a(paramContext, this.d);
  
  public iO(Context paramContext, Looper paramLooper, String paramString1, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString2, String paramString3)
  {
    this(paramContext, paramLooper, paramString1, paramConnectionCallbacks, paramOnConnectionFailedListener, paramString2, paramString3, null);
  }
  
  public iO(Context paramContext, Looper paramLooper, String paramString1, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString2, String paramString3, String paramString4)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramString2);
  }
  
  public void a(LocationRequest paramLocationRequest, ju paramju, Looper paramLooper)
  {
    synchronized (this.e)
    {
      this.e.a(paramLocationRequest, paramju, paramLooper);
      return;
    }
  }
  
  public void disconnect()
  {
    synchronized (this.e)
    {
      boolean bool = isConnected();
      if (!bool) {}
    }
    try
    {
      this.e.b();
      this.e.c();
      label30:
      super.disconnect();
      return;
      localObject = finally;
      throw localObject;
    }
    catch (Exception localException)
    {
      break label30;
    }
  }
  
  public Location g()
  {
    return this.e.a();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     iO
 * JD-Core Version:    0.7.0.1
 */