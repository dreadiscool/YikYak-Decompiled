import android.location.Location;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;

public abstract interface js
{
  public abstract Location a(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<Status> a(GoogleApiClient paramGoogleApiClient, LocationRequest paramLocationRequest, ju paramju);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     js
 * JD-Core Version:    0.7.0.1
 */