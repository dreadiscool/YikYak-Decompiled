import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public class ik
  extends hy<io>
{
  public ik(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String... paramVarArgs)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramVarArgs);
  }
  
  public String a()
  {
    return "com.google.android.gms.common.service.START";
  }
  
  protected void a(hP paramhP, hB paramhB)
  {
    paramhP.j(paramhB, 6587000, d().getPackageName());
  }
  
  protected String b()
  {
    return "com.google.android.gms.common.internal.service.ICommonService";
  }
  
  protected io c(IBinder paramIBinder)
  {
    return ip.a(paramIBinder);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ik
 * JD-Core Version:    0.7.0.1
 */