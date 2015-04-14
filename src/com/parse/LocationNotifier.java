package com.parse;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import k;
import m;
import y;

class LocationNotifier
{
  private static Location fakeLocation = null;
  public static final String testProviderName = "Test";
  
  static m<ParseGeoPoint> getCurrentLocationAsync(long paramLong, Criteria paramCriteria)
  {
    Parse.checkContext();
    y localy = m.a();
    k localk = new k();
    LocationManager localLocationManager = (LocationManager)Parse.applicationContext.getSystemService("location");
    LocationNotifier.1 local1 = new LocationNotifier.1(localk, localy, localLocationManager);
    localk.a(Parse.getScheduledExecutor().schedule(new LocationNotifier.2(localy, localLocationManager, local1), paramLong, TimeUnit.MILLISECONDS));
    String str = localLocationManager.getBestProvider(paramCriteria, true);
    if (str != null) {
      localLocationManager.requestLocationUpdates(str, 0L, 0.0F, local1);
    }
    if (fakeLocation != null) {
      local1.onLocationChanged(fakeLocation);
    }
    return localy.a();
  }
  
  static void setFakeLocation(Location paramLocation)
  {
    fakeLocation = paramLocation;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.LocationNotifier
 * JD-Core Version:    0.7.0.1
 */