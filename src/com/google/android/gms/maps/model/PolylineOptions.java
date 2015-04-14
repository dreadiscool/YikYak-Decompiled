package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;
import kK;
import na;
import nb;

public final class PolylineOptions
  implements SafeParcelable
{
  public static final na CREATOR = new na();
  private final int a;
  private final List<LatLng> b;
  private float c = 10.0F;
  private int d = -16777216;
  private float e = 0.0F;
  private boolean f = true;
  private boolean g = false;
  
  public PolylineOptions()
  {
    this.a = 1;
    this.b = new ArrayList();
  }
  
  public PolylineOptions(int paramInt1, List paramList, float paramFloat1, int paramInt2, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramInt1;
    this.b = paramList;
    this.c = paramFloat1;
    this.d = paramInt2;
    this.e = paramFloat2;
    this.f = paramBoolean1;
    this.g = paramBoolean2;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public List<LatLng> b()
  {
    return this.b;
  }
  
  public float c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public float e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return this.f;
  }
  
  public boolean g()
  {
    return this.g;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (kK.a()) {
      nb.a(this, paramParcel, paramInt);
    }
    for (;;)
    {
      return;
      na.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.PolylineOptions
 * JD-Core Version:    0.7.0.1
 */