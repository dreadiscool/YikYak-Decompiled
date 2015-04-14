package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import hY;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class jg$a
  implements SafeParcelable
{
  public static final hY CREATOR = new hY();
  private final int a;
  private final String b;
  private final List<String> c = new ArrayList();
  private final int d;
  private final String e;
  
  public jg$a(int paramInt1, String paramString1, List<String> paramList, int paramInt2, String paramString2)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c.addAll(paramList);
    this.d = paramInt2;
    this.e = paramString2;
  }
  
  public jg$a(String paramString1, Collection<String> paramCollection, int paramInt, String paramString2)
  {
    this(3, paramString1, new ArrayList(paramCollection), paramInt, paramString2);
  }
  
  public String a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public String c()
  {
    return this.e;
  }
  
  public List<String> d()
  {
    return new ArrayList(this.c);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int e()
  {
    return this.a;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    hY.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jg.a
 * JD-Core Version:    0.7.0.1
 */