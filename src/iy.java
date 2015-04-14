import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public class iy
  extends hy<iI>
{
  protected final iR<iI> d = new iz(this);
  private final String e;
  
  public iy(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
    this.e = paramString;
  }
  
  protected String a()
  {
    return "com.google.android.location.internal.GoogleLocationManagerService.START";
  }
  
  protected void a(hP paramhP, hB paramhB)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("client_name", this.e);
    paramhP.e(paramhB, 6587000, d().getPackageName(), localBundle);
  }
  
  protected String b()
  {
    return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
  }
  
  protected iI c(IBinder paramIBinder)
  {
    return iJ.a(paramIBinder);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     iy
 * JD-Core Version:    0.7.0.1
 */