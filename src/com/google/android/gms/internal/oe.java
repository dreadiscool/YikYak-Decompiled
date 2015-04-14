package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import hZ;
import iZ;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class oe
  implements SafeParcelable
{
  public static final iZ CREATOR = new iZ();
  public static final oe a = a("test_type", 1);
  public static final oe b = a("labeled_place", 6);
  public static final Set<oe> c;
  public final int d;
  public final String e;
  public final int f;
  
  static
  {
    oe[] arrayOfoe = new oe[2];
    arrayOfoe[0] = a;
    arrayOfoe[1] = b;
    c = Collections.unmodifiableSet(new HashSet(Arrays.asList(arrayOfoe)));
  }
  
  public oe(int paramInt1, String paramString, int paramInt2)
  {
    hZ.a(paramString);
    this.d = paramInt1;
    this.e = paramString;
    this.f = paramInt2;
  }
  
  private static oe a(String paramString, int paramInt)
  {
    return new oe(0, paramString, paramInt);
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
      if (!(paramObject instanceof oe))
      {
        bool = false;
      }
      else
      {
        oe localoe = (oe)paramObject;
        if ((!this.e.equals(localoe.e)) || (this.f != localoe.f)) {
          bool = false;
        }
      }
    }
  }
  
  public int hashCode()
  {
    return this.e.hashCode();
  }
  
  public String toString()
  {
    return this.e;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    iZ.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.oe
 * JD-Core Version:    0.7.0.1
 */