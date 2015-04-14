package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import mv;

public final class e
  implements SafeParcelable
{
  public static final mv CREATOR = new mv();
  private final int a;
  private a b;
  
  public e()
  {
    this.a = 1;
  }
  
  public e(int paramInt, a parama)
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
    mv.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.internal.e
 * JD-Core Version:    0.7.0.1
 */