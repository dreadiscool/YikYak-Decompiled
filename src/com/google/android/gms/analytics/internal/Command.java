package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import fZ;

public class Command
  implements Parcelable
{
  public static final Parcelable.Creator<Command> CREATOR = new fZ();
  private String a;
  private String b;
  private String c;
  
  public Command() {}
  
  public Command(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public Command(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
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
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.internal.Command
 * JD-Core Version:    0.7.0.1
 */