package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import hV;
import hX;
import iV;

public class nw
  implements SafeParcelable
{
  public static final iV CREATOR = new iV();
  public final int a;
  private final String b;
  private final String c;
  private final String d;
  
  public nw(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
  }
  
  public String a()
  {
    return this.b;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public String c()
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
    if (!(paramObject instanceof nw)) {}
    for (;;)
    {
      return bool;
      nw localnw = (nw)paramObject;
      if ((hV.a(this.b, localnw.b)) && (hV.a(this.c, localnw.c)) && (hV.a(this.d, localnw.d))) {
        bool = true;
      }
    }
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.b;
    arrayOfObject[1] = this.c;
    arrayOfObject[2] = this.d;
    return hV.a(arrayOfObject);
  }
  
  public String toString()
  {
    return hV.a(this).a("mPlaceId", this.b).a("mTag", this.c).a("mSource", this.d).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    iV.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nw
 * JD-Core Version:    0.7.0.1
 */