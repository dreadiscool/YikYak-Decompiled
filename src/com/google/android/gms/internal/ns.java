package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import hV;
import hX;
import iT;

public final class ns
  implements SafeParcelable
{
  public static final iT CREATOR = new iT();
  private final int a;
  private final int b;
  private final int c;
  private final nu d;
  
  public ns(int paramInt1, int paramInt2, int paramInt3, nu paramnu)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramnu;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public nu d()
  {
    return this.d;
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
      if (!(paramObject instanceof ns))
      {
        bool = false;
      }
      else
      {
        ns localns = (ns)paramObject;
        if ((this.b != localns.b) || (this.c != localns.c) || (!this.d.equals(localns.d))) {
          bool = false;
        }
      }
    }
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(this.b);
    arrayOfObject[1] = Integer.valueOf(this.c);
    return hV.a(arrayOfObject);
  }
  
  public String toString()
  {
    return hV.a(this).a("transitionTypes", Integer.valueOf(this.b)).a("loiteringTimeMillis", Integer.valueOf(this.c)).a("placeFilter", this.d).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    iT.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ns
 * JD-Core Version:    0.7.0.1
 */