package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import hV;
import hX;
import ne;

public class StreetViewPanoramaLocation
  implements SafeParcelable
{
  public static final ne CREATOR = new ne();
  public final StreetViewPanoramaLink[] a;
  public final LatLng b;
  public final String c;
  private final int d;
  
  public StreetViewPanoramaLocation(int paramInt, StreetViewPanoramaLink[] paramArrayOfStreetViewPanoramaLink, LatLng paramLatLng, String paramString)
  {
    this.d = paramInt;
    this.a = paramArrayOfStreetViewPanoramaLink;
    this.b = paramLatLng;
    this.c = paramString;
  }
  
  public int a()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {}
    for (;;)
    {
      return bool;
      if (!(paramObject instanceof StreetViewPanoramaLocation))
      {
        bool = false;
      }
      else
      {
        StreetViewPanoramaLocation localStreetViewPanoramaLocation = (StreetViewPanoramaLocation)paramObject;
        if ((!this.c.equals(localStreetViewPanoramaLocation.c)) || (!this.b.equals(localStreetViewPanoramaLocation.b))) {
          bool = false;
        }
      }
    }
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.b;
    arrayOfObject[1] = this.c;
    return hV.a(arrayOfObject);
  }
  
  public String toString()
  {
    return hV.a(this).a("panoId", this.c).a("position", this.b.toString()).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ne.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.StreetViewPanoramaLocation
 * JD-Core Version:    0.7.0.1
 */