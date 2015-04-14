package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import kK;
import mR;
import mS;
import mf;
import mg;
import ni;
import nj;

public final class TileOverlayOptions
  implements SafeParcelable
{
  public static final ni CREATOR = new ni();
  private final int a;
  private mR b;
  private mg c;
  private boolean d = true;
  private float e;
  private boolean f = true;
  
  public TileOverlayOptions()
  {
    this.a = 1;
  }
  
  public TileOverlayOptions(int paramInt, IBinder paramIBinder, boolean paramBoolean1, float paramFloat, boolean paramBoolean2)
  {
    this.a = paramInt;
    this.b = mS.a(paramIBinder);
    if (this.b == null) {}
    for (mf localmf = null;; localmf = new mf(this))
    {
      this.c = localmf;
      this.d = paramBoolean1;
      this.e = paramFloat;
      this.f = paramBoolean2;
      return;
    }
  }
  
  public int a()
  {
    return this.a;
  }
  
  public IBinder b()
  {
    return this.b.asBinder();
  }
  
  public float c()
  {
    return this.e;
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean e()
  {
    return this.f;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (kK.a()) {
      nj.a(this, paramParcel, paramInt);
    }
    for (;;)
    {
      return;
      ni.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.TileOverlayOptions
 * JD-Core Version:    0.7.0.1
 */