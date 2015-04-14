package com.yik.yak.data.models;

import Ik;
import android.location.Location;

public class YakkerLocation
    extends Location
{
    public YakkerLocation(Location paramLocation)
    {
        super(paramLocation);
    }
    
    public YakkerLocation(String paramString)
    {
        super(paramString);
    }
    
    // public String a()
    public String getLatitudeString()
    {
        return Ik.locationDoubleToString(getLatitude());
    }
    
    // public String b()
    public String getLongitudeString()
    {
        return Ik.locationDoubleToString(getLongitude());
    }
    
    // public String c()
    public String getLatitudeRoundedString()
    {
        return String.valueOf(Math.round(100.0D * getLatitude()) / 100.0D);
    }
    
    // public String d()
    public String getLongitudeRoundedString()
    {
        return String.valueOf(Math.round(100.0D * getLongitude()) / 100.0D);
    }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     com.yik.yak.data.models.YakkerLocation

 * JD-Core Version:    0.7.0.1

 */