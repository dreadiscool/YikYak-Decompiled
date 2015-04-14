package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import mU;

public final class p
  implements SafeParcelable
{
  public static final mU CREATOR = new mU();
  private final int a;
  private a b;
  
  public p()
  {
    this.a = 1;
  }
  
  public p(int paramInt, a parama)
  {
    this.a = paramInt;
    this.b = parama;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public a b()
  {
    return this.b;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    mU.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.internal.p
 * JD-Core Version:    0.7.0.1
 */