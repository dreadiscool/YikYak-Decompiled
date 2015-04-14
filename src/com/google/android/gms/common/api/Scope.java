package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import hZ;

public final class Scope
  implements SafeParcelable
{
  public static final Parcelable.Creator<Scope> CREATOR = new e();
  final int CK;
  private final String Kv;
  
  Scope(int paramInt, String paramString)
  {
    hZ.a(paramString, "scopeUri must not be null or empty");
    this.CK = paramInt;
    this.Kv = paramString;
  }
  
  public Scope(String paramString)
  {
    this(1, paramString);
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
      if (!(paramObject instanceof Scope)) {
        bool = false;
      } else {
        bool = this.Kv.equals(((Scope)paramObject).Kv);
      }
    }
  }
  
  public String gO()
  {
    return this.Kv;
  }
  
  public int hashCode()
  {
    return this.Kv.hashCode();
  }
  
  public String toString()
  {
    return this.Kv;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    e.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.Scope
 * JD-Core Version:    0.7.0.1
 */