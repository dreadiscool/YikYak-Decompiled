package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import hg;

public class ha
  implements Parcelable
{
  @Deprecated
  public static final Parcelable.Creator<ha> CREATOR = new hg();
  private String a;
  private String b;
  private String c;
  
  @Deprecated
  public ha() {}
  
  @Deprecated
  public ha(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public ha(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  @Deprecated
  private void a(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.c;
  }
  
  @Deprecated
  public int describeContents()
  {
    return 0;
  }
  
  @Deprecated
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ha
 * JD-Core Version:    0.7.0.1
 */