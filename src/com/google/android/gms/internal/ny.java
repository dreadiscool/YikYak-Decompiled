package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import hV;
import hX;
import iW;
import java.util.concurrent.TimeUnit;

public final class ny
  implements SafeParcelable
{
  public static final iW CREATOR = new iW();
  public static final long a = TimeUnit.HOURS.toMillis(1L);
  public final int b;
  private final nu c;
  private final long d;
  private final int e;
  
  public ny(int paramInt1, nu paramnu, long paramLong, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramnu;
    this.d = paramLong;
    this.e = paramInt2;
  }
  
  public nu a()
  {
    return this.c;
  }
  
  public long b()
  {
    return this.d;
  }
  
  public int c()
  {
    return this.e;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {}
    for (;;)
    {
      return bool;
      if (!(paramObject instanceof ny))
      {
        bool = false;
      }
      else
      {
        ny localny = (ny)paramObject;
        if ((!hV.a(this.c, localny.c)) || (this.d != localny.d) || (this.e != localny.e)) {
          bool = false;
        }
      }
    }
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.c;
    arrayOfObject[1] = Long.valueOf(this.d);
    arrayOfObject[2] = Integer.valueOf(this.e);
    return hV.a(arrayOfObject);
  }
  
  public String toString()
  {
    return hV.a(this).a("filter", this.c).a("interval", Long.valueOf(this.d)).a("priority", Integer.valueOf(this.e)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    iW.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ny
 * JD-Core Version:    0.7.0.1
 */