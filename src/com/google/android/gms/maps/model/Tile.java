package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import kK;
import ng;
import nh;

public final class Tile
  implements SafeParcelable
{
  public static final ng CREATOR = new ng();
  public final int a;
  public final int b;
  public final byte[] c;
  private final int d;
  
  public Tile(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this.d = paramInt1;
    this.a = paramInt2;
    this.b = paramInt3;
    this.c = paramArrayOfByte;
  }
  
  public Tile(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this(1, paramInt1, paramInt2, paramArrayOfByte);
  }
  
  public int a()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (kK.a()) {
      nh.a(this, paramParcel, paramInt);
    }
    for (;;)
    {
      return;
      ng.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.Tile
 * JD-Core Version:    0.7.0.1
 */