package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import hV;
import iA;

public class nd
  implements SafeParcelable
{
  public static final iA CREATOR = new iA();
  public final int a;
  public final String b;
  private final int c;
  
  public nd(int paramInt1, int paramInt2, String paramString)
  {
    this.c = paramInt1;
    this.a = paramInt2;
    this.b = paramString;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (!(paramObject instanceof nd)) {}
    for (;;)
    {
      return bool;
      nd localnd = (nd)paramObject;
      if ((localnd.a == this.a) && (hV.a(localnd.b, this.b))) {
        bool = true;
      }
    }
  }
  
  public int hashCode()
  {
    return this.a;
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(this.a);
    arrayOfObject[1] = this.b;
    return String.format("%d:%s", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    iA.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nd
 * JD-Core Version:    0.7.0.1
 */