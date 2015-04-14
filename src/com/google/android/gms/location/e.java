package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import hV;
import jD;

public class e
  implements SafeParcelable
{
  public static final jD CREATOR = new jD();
  public int a;
  public int b;
  public long c;
  private final int d;
  
  public e(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.d = paramInt1;
    this.a = paramInt2;
    this.b = paramInt3;
    this.c = paramLong;
  }
  
  private String a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    case 1: 
    default: 
      str = "STATUS_UNKNOWN";
    }
    for (;;)
    {
      return str;
      str = "STATUS_SUCCESSFUL";
      continue;
      str = "STATUS_TIMED_OUT_ON_SCAN";
      continue;
      str = "STATUS_NO_INFO_IN_DATABASE";
      continue;
      str = "STATUS_INVALID_SCAN";
      continue;
      str = "STATUS_UNABLE_TO_QUERY_DATABASE";
      continue;
      str = "STATUS_SCANS_DISABLED_IN_SETTINGS";
      continue;
      str = "STATUS_LOCATION_DISABLED_IN_SETTINGS";
      continue;
      str = "STATUS_IN_PROGRESS";
    }
  }
  
  public int a()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (!(paramObject instanceof e)) {}
    for (;;)
    {
      return bool;
      e locale = (e)paramObject;
      if ((this.a == locale.a) && (this.b == locale.b) && (this.c == locale.c)) {
        bool = true;
      }
    }
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.a);
    arrayOfObject[1] = Integer.valueOf(this.b);
    arrayOfObject[2] = Long.valueOf(this.c);
    return hV.a(arrayOfObject);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LocationStatus[cell status: ").append(a(this.a));
    localStringBuilder.append(", wifi status: ").append(a(this.b));
    localStringBuilder.append(", elapsed realtime ns: ").append(this.c);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    jD.a(this, paramParcel, paramInt);
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     com.google.android.gms.location.e

 * JD-Core Version:    0.7.0.1

 */