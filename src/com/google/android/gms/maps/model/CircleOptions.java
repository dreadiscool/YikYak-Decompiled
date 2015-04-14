package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import kK;
import mj;
import mk;

public final class CircleOptions
  implements SafeParcelable
{
  public static final mj CREATOR = new mj();
  private final int a;
  private LatLng b = null;
  private double c = 0.0D;
  private float d = 10.0F;
  private int e = -16777216;
  private int f = 0;
  private float g = 0.0F;
  private boolean h = true;
  
  public CircleOptions()
  {
    this.a = 1;
  }
  
  public CircleOptions(int paramInt1, LatLng paramLatLng, double paramDouble, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean)
  {
    this.a = paramInt1;
    this.b = paramLatLng;
    this.c = paramDouble;
    this.d = paramFloat1;
    this.e = paramInt2;
    this.f = paramInt3;
    this.g = paramFloat2;
    this.h = paramBoolean;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public LatLng b()
  {
    return this.b;
  }
  
  public double c()
  {
    return this.c;
  }
  
  public float d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public int f()
  {
    return this.f;
  }
  
  public float g()
  {
    return this.g;
  }
  
  public boolean h()
  {
    return this.h;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (kK.a()) {
      mk.a(this, paramParcel, paramInt);
    }
    for (;;)
    {
      return;
      mj.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.CircleOptions
 * JD-Core Version:    0.7.0.1
 */