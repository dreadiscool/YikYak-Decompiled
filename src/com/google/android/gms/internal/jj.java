package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import hx;

public class jj
  implements SafeParcelable
{
  public static final Parcelable.Creator<jj> CREATOR = new hx();
  public final int a;
  public final int b;
  public int c;
  public String d;
  public IBinder e;
  public Scope[] f;
  public Bundle g;
  
  public jj(int paramInt1, int paramInt2, int paramInt3, String paramString, IBinder paramIBinder, Scope[] paramArrayOfScope, Bundle paramBundle)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramString;
    this.e = paramIBinder;
    this.f = paramArrayOfScope;
    this.g = paramBundle;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    hx.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jj
 * JD-Core Version:    0.7.0.1
 */