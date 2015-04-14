package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import kJ;
import kc;

public final class StreetViewPanoramaOptions
  implements SafeParcelable
{
  public static final kc CREATOR = new kc();
  private final int a;
  private StreetViewPanoramaCamera b;
  private String c;
  private LatLng d;
  private Integer e;
  private Boolean f = Boolean.valueOf(true);
  private Boolean g = Boolean.valueOf(true);
  private Boolean h = Boolean.valueOf(true);
  private Boolean i = Boolean.valueOf(true);
  private Boolean j;
  
  public StreetViewPanoramaOptions()
  {
    this.a = 1;
  }
  
  public StreetViewPanoramaOptions(int paramInt, StreetViewPanoramaCamera paramStreetViewPanoramaCamera, String paramString, LatLng paramLatLng, Integer paramInteger, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5)
  {
    this.a = paramInt;
    this.b = paramStreetViewPanoramaCamera;
    this.d = paramLatLng;
    this.e = paramInteger;
    this.c = paramString;
    this.f = kJ.a(paramByte1);
    this.g = kJ.a(paramByte2);
    this.h = kJ.a(paramByte3);
    this.i = kJ.a(paramByte4);
    this.j = kJ.a(paramByte5);
  }
  
  public int a()
  {
    return this.a;
  }
  
  public byte b()
  {
    return kJ.a(this.f);
  }
  
  public byte c()
  {
    return kJ.a(this.g);
  }
  
  public byte d()
  {
    return kJ.a(this.h);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public byte e()
  {
    return kJ.a(this.i);
  }
  
  public byte f()
  {
    return kJ.a(this.j);
  }
  
  public StreetViewPanoramaCamera g()
  {
    return this.b;
  }
  
  public LatLng h()
  {
    return this.d;
  }
  
  public Integer i()
  {
    return this.e;
  }
  
  public String j()
  {
    return this.c;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    kc.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.StreetViewPanoramaOptions
 * JD-Core Version:    0.7.0.1
 */