package com.parse;

public abstract class LocationCallback
  extends ParseCallback<ParseGeoPoint>
{
  public abstract void done(ParseGeoPoint paramParseGeoPoint, ParseException paramParseException);
  
  final void internalDone(ParseGeoPoint paramParseGeoPoint, ParseException paramParseException)
  {
    done(paramParseGeoPoint, paramParseException);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.LocationCallback
 * JD-Core Version:    0.7.0.1
 */