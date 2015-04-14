package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import mt;

public final class a
  implements SafeParcelable
{
  public static final mt CREATOR = new mt();
  private final int a;
  private byte b;
  private Bundle c;
  private Bitmap d;
  
  public a(int paramInt, byte paramByte, Bundle paramBundle, Bitmap paramBitmap)
  {
    this.a = paramInt;
    this.b = paramByte;
    this.c = paramBundle;
    this.d = paramBitmap;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public byte b()
  {
    return this.b;
  }
  
  public Bundle c()
  {
    return this.c;
  }
  
  public Bitmap d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    mt.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.internal.a
 * JD-Core Version:    0.7.0.1
 */