import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;

public class jv
{
  public static final Api<Api.ApiOptions.NoOptions> a = new Api(e, d, new Scope[0]);
  public static js b = new iB();
  public static jt c = new iE();
  private static final Api.c<iO> d = new Api.c();
  private static final Api.b<iO, Api.ApiOptions.NoOptions> e = new jw();
  
  public static iO a(GoogleApiClient paramGoogleApiClient)
  {
    boolean bool1 = true;
    boolean bool2;
    iO localiO;
    if (paramGoogleApiClient != null)
    {
      bool2 = bool1;
      hZ.b(bool2, "GoogleApiClient parameter is required.");
      localiO = (iO)paramGoogleApiClient.a(d);
      if (localiO == null) {
        break label44;
      }
    }
    for (;;)
    {
      hZ.a(bool1, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
      return localiO;
      bool2 = false;
      break;
      label44:
      bool1 = false;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     jv
 * JD-Core Version:    0.7.0.1
 */