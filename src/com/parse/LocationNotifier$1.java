package com.parse;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import java.util.concurrent.ScheduledFuture;
import k;
import y;

final class LocationNotifier$1
  implements LocationListener
{
  LocationNotifier$1(k paramk, y paramy, LocationManager paramLocationManager) {}
  
  public void onLocationChanged(Location paramLocation)
  {
    ((ScheduledFuture)this.val$timeoutFuture.a()).cancel(true);
    ParseGeoPoint localParseGeoPoint = null;
    if (paramLocation != null) {
      localParseGeoPoint = new ParseGeoPoint(paramLocation.getLatitude(), paramLocation.getLongitude());
    }
    this.val$tcs.a(localParseGeoPoint);
    this.val$manager.removeUpdates(this);
  }
  
  public void onProviderDisabled(String paramString) {}
  
  public void onProviderEnabled(String paramString) {}
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.LocationNotifier.1
 * JD-Core Version:    0.7.0.1
 */