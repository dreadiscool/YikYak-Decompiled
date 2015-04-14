package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;
import kK;
import mY;
import mZ;

public final class PolygonOptions
  implements SafeParcelable
{
  public static final mY CREATOR = new mY();
  private final int a;
  private final List<LatLng> b;
  private final List<List<LatLng>> c;
  private float d = 10.0F;
  private int e = -16777216;
  private int f = 0;
  private float g = 0.0F;
  private boolean h = true;
  private boolean i = false;
  
  public PolygonOptions()
  {
    this.a = 1;
    this.b = new ArrayList();
    this.c = new ArrayList();
  }
  
  public PolygonOptions(int paramInt1, List<LatLng> paramList, List paramList1, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramInt1;
    this.b = paramList;
    this.c = paramList1;
    this.d = paramFloat1;
    this.e = paramInt2;
    this.f = paramInt3;
    this.g = paramFloat2;
    this.h = paramBoolean1;
    this.i = paramBoolean2;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public List b()
  {
    return this.c;
  }
  
  public List<LatLng> c()
  {
    return this.b;
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
  
  public boolean i()
  {
    return this.i;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (kK.a()) {
      mZ.a(this, paramParcel, paramInt);
    }
    for (;;)
    {
      return;
      mY.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.PolygonOptions
 * JD-Core Version:    0.7.0.1
 */