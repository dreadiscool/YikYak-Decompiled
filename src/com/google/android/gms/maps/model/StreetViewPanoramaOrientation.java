package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import hV;
import hX;
import hZ;
import nf;

public class StreetViewPanoramaOrientation
  implements SafeParcelable
{
  public static final nf CREATOR = new nf();
  public final float a;
  public final float b;
  private final int c;
  
  public StreetViewPanoramaOrientation(float paramFloat1, float paramFloat2)
  {
    this(1, paramFloat1, paramFloat2);
  }
  
  public StreetViewPanoramaOrientation(int paramInt, float paramFloat1, float paramFloat2)
  {
    if ((-90.0F <= paramFloat1) && (paramFloat1 <= 90.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      hZ.b(bool, "Tilt needs to be between -90 and 90 inclusive");
      this.c = paramInt;
      this.a = (0.0F + paramFloat1);
      if (paramFloat2 <= 0.0D) {
        paramFloat2 = 360.0F + paramFloat2 % 360.0F;
      }
      this.b = (paramFloat2 % 360.0F);
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
      if (!(paramObject instanceof StreetViewPanoramaOrientation))
      {
        bool = false;
      }
      else
      {
        StreetViewPanoramaOrientation localStreetViewPanoramaOrientation = (StreetViewPanoramaOrientation)paramObject;
        if ((Float.floatToIntBits(this.a) != Float.floatToIntBits(localStreetViewPanoramaOrientation.a)) || (Float.floatToIntBits(this.b) != Float.floatToIntBits(localStreetViewPanoramaOrientation.b))) {
          bool = false;
        }
      }
    }
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Float.valueOf(this.a);
    arrayOfObject[1] = Float.valueOf(this.b);
    return hV.a(arrayOfObject);
  }
  
  public String toString()
  {
    return hV.a(this).a("tilt", Float.valueOf(this.a)).a("bearing", Float.valueOf(this.b)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    nf.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.StreetViewPanoramaOrientation
 * JD-Core Version:    0.7.0.1
 */