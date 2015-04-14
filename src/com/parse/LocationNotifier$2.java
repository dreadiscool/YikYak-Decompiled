package com.parse;

import android.location.LocationListener;
import android.location.LocationManager;
import y;

final class LocationNotifier$2
  implements Runnable
{
  LocationNotifier$2(y paramy, LocationManager paramLocationManager, LocationListener paramLocationListener) {}
  
  public void run()
  {
    this.val$tcs.a(new ParseException(124, "location fetch timed out"));
    this.val$manager.removeUpdates(this.val$listener);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.LocationNotifier.2
 * JD-Core Version:    0.7.0.1
 */