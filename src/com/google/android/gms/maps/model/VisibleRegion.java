package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import hV;
import hX;
import kK;
import nk;
import nl;

public final class VisibleRegion
  implements SafeParcelable
{
  public static final nk CREATOR = new nk();
  public final LatLng a;
  public final LatLng b;
  public final LatLng c;
  public final LatLng d;
  public final LatLngBounds e;
  private final int f;
  
  public VisibleRegion(int paramInt, LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3, LatLng paramLatLng4, LatLngBounds paramLatLngBounds)
  {
    this.f = paramInt;
    this.a = paramLatLng1;
    this.b = paramLatLng2;
    this.c = paramLatLng3;
    this.d = paramLatLng4;
    this.e = paramLatLngBounds;
  }
  
  public int a()
  {
    return this.f;
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
      if (!(paramObject instanceof VisibleRegion))
      {
        bool = false;
      }
      else
      {
        VisibleRegion localVisibleRegion = (VisibleRegion)paramObject;
        if ((!this.a.equals(localVisibleRegion.a)) || (!this.b.equals(localVisibleRegion.b)) || (!this.c.equals(localVisibleRegion.c)) || (!this.d.equals(localVisibleRegion.d)) || (!this.e.equals(localVisibleRegion.e))) {
          bool = false;
        }
      }
    }
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = this.a;
    arrayOfObject[1] = this.b;
    arrayOfObject[2] = this.c;
    arrayOfObject[3] = this.d;
    arrayOfObject[4] = this.e;
    return hV.a(arrayOfObject);
  }
  
  public String toString()
  {
    return hV.a(this).a("nearLeft", this.a).a("nearRight", this.b).a("farLeft", this.c).a("farRight", this.d).a("latLngBounds", this.e).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (kK.a()) {
      nl.a(this, paramParcel, paramInt);
    }
    for (;;)
    {
      return;
      nk.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.VisibleRegion
 * JD-Core Version:    0.7.0.1
 */