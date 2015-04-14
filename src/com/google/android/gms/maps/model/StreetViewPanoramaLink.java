package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import hV;
import hX;
import nd;

public class StreetViewPanoramaLink
  implements SafeParcelable
{
  public static final nd CREATOR = new nd();
  public final String a;
  public final float b;
  private final int c;
  
  public StreetViewPanoramaLink(int paramInt, String paramString, float paramFloat)
  {
    this.c = paramInt;
    this.a = paramString;
    if (paramFloat <= 0.0D) {
      paramFloat = 360.0F + paramFloat % 360.0F;
    }
    this.b = (paramFloat % 360.0F);
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
      if (!(paramObject instanceof StreetViewPanoramaLink))
      {
        bool = false;
      }
      else
      {
        StreetViewPanoramaLink localStreetViewPanoramaLink = (StreetViewPanoramaLink)paramObject;
        if ((!this.a.equals(localStreetViewPanoramaLink.a)) || (Float.floatToIntBits(this.b) != Float.floatToIntBits(localStreetViewPanoramaLink.b))) {
          bool = false;
        }
      }
    }
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.a;
    arrayOfObject[1] = Float.valueOf(this.b);
    return hV.a(arrayOfObject);
  }
  
  public String toString()
  {
    return hV.a(this).a("panoId", this.a).a("bearing", Float.valueOf(this.b)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    nd.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.StreetViewPanoramaLink
 * JD-Core Version:    0.7.0.1
 */