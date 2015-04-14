package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import hV;
import hX;
import hZ;
import kK;
import mn;
import mo;

public final class LatLngBounds
  implements SafeParcelable
{
  public static final mn CREATOR = new mn();
  public final LatLng a;
  public final LatLng b;
  private final int c;
  
  public LatLngBounds(int paramInt, LatLng paramLatLng1, LatLng paramLatLng2)
  {
    hZ.a(paramLatLng1, "null southwest");
    hZ.a(paramLatLng2, "null northeast");
    if (paramLatLng2.a >= paramLatLng1.a) {}
    for (boolean bool = true;; bool = false)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Double.valueOf(paramLatLng1.a);
      arrayOfObject[1] = Double.valueOf(paramLatLng2.a);
      hZ.b(bool, "southern latitude exceeds northern latitude (%s > %s)", arrayOfObject);
      this.c = paramInt;
      this.a = paramLatLng1;
      this.b = paramLatLng2;
      return;
    }
  }
  
  public int a()
  {
    return this.c;
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
      if (!(paramObject instanceof LatLngBounds))
      {
        bool = false;
      }
      else
      {
        LatLngBounds localLatLngBounds = (LatLngBounds)paramObject;
        if ((!this.a.equals(localLatLngBounds.a)) || (!this.b.equals(localLatLngBounds.b))) {
          bool = false;
        }
      }
    }
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.a;
    arrayOfObject[1] = this.b;
    return hV.a(arrayOfObject);
  }
  
  public String toString()
  {
    return hV.a(this).a("southwest", this.a).a("northeast", this.b).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (kK.a()) {
      mo.a(this, paramParcel, paramInt);
    }
    for (;;)
    {
      return;
      mn.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.LatLngBounds
 * JD-Core Version:    0.7.0.1
 */