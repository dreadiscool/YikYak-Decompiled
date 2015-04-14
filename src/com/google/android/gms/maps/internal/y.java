package com.google.android.gms.maps.internal;

import android.graphics.Point;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import lY;

public class y
  implements SafeParcelable
{
  public static final lY CREATOR = new lY();
  private final int a;
  private final Point b;
  
  public y(int paramInt, Point paramPoint)
  {
    this.a = paramInt;
    this.b = paramPoint;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public Point b()
  {
    return this.b;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (this == paramObject) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if (!(paramObject instanceof y))
      {
        bool = false;
      }
      else
      {
        y localy = (y)paramObject;
        bool = this.b.equals(localy.b);
      }
    }
  }
  
  public int hashCode()
  {
    return this.b.hashCode();
  }
  
  public String toString()
  {
    return this.b.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    lY.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.y
 * JD-Core Version:    0.7.0.1
 */