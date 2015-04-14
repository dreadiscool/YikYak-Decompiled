package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import hV;
import jC;

public final class LocationRequest
  implements SafeParcelable
{
  public static final jC CREATOR = new jC();
  public int a;
  public long b;
  public long c;
  public boolean d;
  public long e;
  public int f;
  public float g;
  public long h;
  private final int i;
  
  public LocationRequest()
  {
    this.i = 1;
    this.a = 102;
    this.b = 3600000L;
    this.c = 600000L;
    this.d = false;
    this.e = 9223372036854775807L;
    this.f = 2147483647;
    this.g = 0.0F;
    this.h = 0L;
  }
  
  public LocationRequest(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, int paramInt3, float paramFloat, long paramLong4)
  {
    this.i = paramInt1;
    this.a = paramInt2;
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramBoolean;
    this.e = paramLong3;
    this.f = paramInt3;
    this.g = paramFloat;
    this.h = paramLong4;
  }
  
  public static String a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    case 101: 
    case 103: 
    default: 
      str = "???";
    }
    for (;;)
    {
      return str;
      str = "PRIORITY_HIGH_ACCURACY";
      continue;
      str = "PRIORITY_BALANCED_POWER_ACCURACY";
      continue;
      str = "PRIORITY_LOW_POWER";
      continue;
      str = "PRIORITY_NO_POWER";
    }
  }
  
  private static void b(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("invalid interval: " + paramLong);
    }
  }
  
  public int a()
  {
    return this.i;
  }
  
  public LocationRequest a(long paramLong)
  {
    b(paramLong);
    this.b = paramLong;
    if (!this.d) {
      this.c = ((this.b / 6.0D));
    }
    return this;
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
      if (!(paramObject instanceof LocationRequest))
      {
        bool = false;
      }
      else
      {
        LocationRequest localLocationRequest = (LocationRequest)paramObject;
        if ((this.a != localLocationRequest.a) || (this.b != localLocationRequest.b) || (this.c != localLocationRequest.c) || (this.d != localLocationRequest.d) || (this.e != localLocationRequest.e) || (this.f != localLocationRequest.f) || (this.g != localLocationRequest.g)) {
          bool = false;
        }
      }
    }
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = Integer.valueOf(this.a);
    arrayOfObject[1] = Long.valueOf(this.b);
    arrayOfObject[2] = Long.valueOf(this.c);
    arrayOfObject[3] = Boolean.valueOf(this.d);
    arrayOfObject[4] = Long.valueOf(this.e);
    arrayOfObject[5] = Integer.valueOf(this.f);
    arrayOfObject[6] = Float.valueOf(this.g);
    return hV.a(arrayOfObject);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Request[").append(a(this.a));
    if (this.a != 105)
    {
      localStringBuilder.append(" requested=");
      localStringBuilder.append(this.b + "ms");
    }
    localStringBuilder.append(" fastest=");
    localStringBuilder.append(this.c + "ms");
    if (this.e != 9223372036854775807L)
    {
      long l = this.e - SystemClock.elapsedRealtime();
      localStringBuilder.append(" expireIn=");
      localStringBuilder.append(l + "ms");
    }
    if (this.f != 2147483647) {
      localStringBuilder.append(" num=").append(this.f);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    jC.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.LocationRequest
 * JD-Core Version:    0.7.0.1
 */