package com.google.android.gms.maps.model.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import mu;

public final class c
  implements SafeParcelable
{
  public static final mu CREATOR = new mu();
  private final int a;
  private int b;
  private Bundle c;
  
  public c(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramBundle;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public Bundle c()
  {
    return this.c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    mu.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.internal.c
 * JD-Core Version:    0.7.0.1
 */