package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import hV;
import hX;
import java.util.Locale;
import jd;

public class oh
  implements SafeParcelable
{
  public static final jd CREATOR = new jd();
  public static final oh a = new oh("com.google.android.gms", Locale.ENGLISH, null);
  public final int b;
  public final String c;
  public final String d;
  public final String e;
  public final String f;
  
  public oh(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.b = paramInt;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramString4;
  }
  
  public oh(String paramString1, Locale paramLocale, String paramString2)
  {
    this(1, paramString1, paramLocale.toString(), paramString2, null);
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
      if ((paramObject == null) || (!(paramObject instanceof oh)))
      {
        bool = false;
      }
      else
      {
        oh localoh = (oh)paramObject;
        if ((!this.d.equals(localoh.d)) || (!this.c.equals(localoh.c)) || (!hV.a(this.e, localoh.e)) || (!hV.a(this.f, localoh.f))) {
          bool = false;
        }
      }
    }
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.c;
    arrayOfObject[1] = this.d;
    arrayOfObject[2] = this.e;
    return hV.a(arrayOfObject);
  }
  
  public String toString()
  {
    return hV.a(this).a("clientPackageName", this.c).a("locale", this.d).a("accountName", this.e).a("gCoreClientName", this.f).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    jd.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.oh
 * JD-Core Version:    0.7.0.1
 */