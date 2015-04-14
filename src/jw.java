import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.jg;

final class jw
  implements Api.b<iO, Api.ApiOptions.NoOptions>
{
  public iO a(Context paramContext, Looper paramLooper, jg paramjg, Api.ApiOptions.NoOptions paramNoOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return new iO(paramContext, paramLooper, paramContext.getPackageName(), paramConnectionCallbacks, paramOnConnectionFailedListener, "locationServices", paramjg.a());
  }
  
  public int getPriority()
  {
    return 2147483647;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     jw
 * JD-Core Version:    0.7.0.1
 */