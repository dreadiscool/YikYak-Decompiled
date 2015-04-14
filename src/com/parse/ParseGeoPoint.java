package com.parse;

import android.location.Criteria;
import m;

public class ParseGeoPoint
{
  static double EARTH_MEAN_RADIUS_KM = 6371.0D;
  static double EARTH_MEAN_RADIUS_MILE = 3958.8000000000002D;
  private double latitude = 0.0D;
  private double longitude = 0.0D;
  
  public ParseGeoPoint() {}
  
  public ParseGeoPoint(double paramDouble1, double paramDouble2)
  {
    setLatitude(paramDouble1);
    setLongitude(paramDouble2);
  }
  
  public static m<ParseGeoPoint> getCurrentLocationInBackground(long paramLong)
  {
    Criteria localCriteria = new Criteria();
    localCriteria.setAccuracy(0);
    localCriteria.setPowerRequirement(0);
    return LocationNotifier.getCurrentLocationAsync(paramLong, localCriteria);
  }
  
  public static m<ParseGeoPoint> getCurrentLocationInBackground(long paramLong, Criteria paramCriteria)
  {
    return LocationNotifier.getCurrentLocationAsync(paramLong, paramCriteria);
  }
  
  public static void getCurrentLocationInBackground(long paramLong, Criteria paramCriteria, LocationCallback paramLocationCallback)
  {
    Parse.callbackOnMainThreadAsync(getCurrentLocationInBackground(paramLong, paramCriteria), paramLocationCallback);
  }
  
  public static void getCurrentLocationInBackground(long paramLong, LocationCallback paramLocationCallback)
  {
    Parse.callbackOnMainThreadAsync(getCurrentLocationInBackground(paramLong), paramLocationCallback);
  }
  
  public double distanceInKilometersTo(ParseGeoPoint paramParseGeoPoint)
  {
    return distanceInRadiansTo(paramParseGeoPoint) * EARTH_MEAN_RADIUS_KM;
  }
  
  public double distanceInMilesTo(ParseGeoPoint paramParseGeoPoint)
  {
    return distanceInRadiansTo(paramParseGeoPoint) * EARTH_MEAN_RADIUS_MILE;
  }
  
  public double distanceInRadiansTo(ParseGeoPoint paramParseGeoPoint)
  {
    double d1 = 0.0174532925199433D * this.latitude;
    double d2 = 0.0174532925199433D * this.longitude;
    double d3 = 0.0174532925199433D * paramParseGeoPoint.getLatitude();
    double d4 = 0.0174532925199433D * paramParseGeoPoint.getLongitude();
    double d5 = d1 - d3;
    double d6 = d2 - d4;
    double d7 = Math.sin(d5 / 2.0D);
    double d8 = Math.sin(d6 / 2.0D);
    return 2.0D * Math.asin(Math.sqrt(Math.min(1.0D, d7 * d7 + d8 * (d8 * (Math.cos(d1) * Math.cos(d3))))));
  }
  
  public double getLatitude()
  {
    return this.latitude;
  }
  
  public double getLongitude()
  {
    return this.longitude;
  }
  
  public void setLatitude(double paramDouble)
  {
    if ((paramDouble > 90.0D) || (paramDouble < -90.0D)) {
      throw new IllegalArgumentException("Latitude must be within the range (-90.0, 90.0).");
    }
    this.latitude = paramDouble;
  }
  
  public void setLongitude(double paramDouble)
  {
    if ((paramDouble > 180.0D) || (paramDouble < -180.0D)) {
      throw new IllegalArgumentException("Longitude must be within the range (-180.0, 180.0).");
    }
    this.longitude = paramDouble;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseGeoPoint
 * JD-Core Version:    0.7.0.1
 */