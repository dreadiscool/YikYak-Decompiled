import android.location.Location;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;

public class iB
  implements js
{
  public Location a(GoogleApiClient paramGoogleApiClient)
  {
    iO localiO = jv.a(paramGoogleApiClient);
    try
    {
      Location localLocation2 = localiO.g();
      localLocation1 = localLocation2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Location localLocation1 = null;
      }
    }
    return localLocation1;
  }
  
  public PendingResult<Status> a(GoogleApiClient paramGoogleApiClient, LocationRequest paramLocationRequest, ju paramju)
  {
    return paramGoogleApiClient.b(new iC(this, paramGoogleApiClient, paramLocationRequest, paramju));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     iB
 * JD-Core Version:    0.7.0.1
 */