package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.LocationRequest;
import hV;
import iP;
import java.util.Collections;
import java.util.List;

public class nl
  implements SafeParcelable
{
  public static final iP CREATOR = new iP();
  public static final List<nd> a = ;
  public LocationRequest b;
  public boolean c;
  public boolean d;
  public boolean e;
  public List<nd> f;
  public final String g;
  private final int h;
  
  public nl(int paramInt, LocationRequest paramLocationRequest, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, List<nd> paramList, String paramString)
  {
    this.h = paramInt;
    this.b = paramLocationRequest;
    this.c = paramBoolean1;
    this.d = paramBoolean2;
    this.e = paramBoolean3;
    this.f = paramList;
    this.g = paramString;
  }
  
  public int a()
  {
    return this.h;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (!(paramObject instanceof nl)) {}
    for (;;)
    {
      return bool;
      nl localnl = (nl)paramObject;
      if ((hV.a(this.b, localnl.b)) && (this.c == localnl.c) && (this.d == localnl.d) && (this.e == localnl.e) && (hV.a(this.f, localnl.f))) {
        bool = true;
      }
    }
  }
  
  public int hashCode()
  {
    return this.b.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.toString());
    localStringBuilder.append(" requestNlpDebugInfo=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" restorePendingIntentListeners=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" triggerUpdate=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" clients=");
    localStringBuilder.append(this.f);
    if (this.g != null)
    {
      localStringBuilder.append(" tag=");
      localStringBuilder.append(this.g);
    }
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    iP.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nl
 * JD-Core Version:    0.7.0.1
 */