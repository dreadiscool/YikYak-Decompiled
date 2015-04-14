package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import hV;
import hX;
import iU;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class nu
  implements SafeParcelable
{
  public static final iU CREATOR = new iU();
  public final int a;
  public final List<oa> b;
  public final List<oe> c;
  public final List<String> d;
  private final String e;
  private final boolean f;
  private final Set<oa> g;
  private final Set<oe> h;
  private final Set<String> i;
  
  public nu(int paramInt, List<oa> paramList, String paramString, boolean paramBoolean, List<oe> paramList1, List<String> paramList2)
  {
    this.a = paramInt;
    List localList1;
    List localList2;
    if (paramList == null)
    {
      localList1 = Collections.emptyList();
      this.b = localList1;
      if (paramString == null) {
        paramString = "";
      }
      this.e = paramString;
      this.f = paramBoolean;
      if (paramList1 != null) {
        break label117;
      }
      localList2 = Collections.emptyList();
      label52:
      this.c = localList2;
      if (paramList2 != null) {
        break label127;
      }
    }
    label117:
    label127:
    for (List localList3 = Collections.emptyList();; localList3 = Collections.unmodifiableList(paramList2))
    {
      this.d = localList3;
      this.g = a(this.b);
      this.h = a(this.c);
      this.i = a(this.d);
      return;
      localList1 = Collections.unmodifiableList(paramList);
      break;
      localList2 = Collections.unmodifiableList(paramList1);
      break label52;
    }
  }
  
  private static <E> Set<E> a(List<E> paramList)
  {
    if (paramList.isEmpty()) {}
    for (Set localSet = Collections.emptySet();; localSet = Collections.unmodifiableSet(new HashSet(paramList))) {
      return localSet;
    }
  }
  
  @Deprecated
  public String a()
  {
    return this.e;
  }
  
  public boolean b()
  {
    return this.f;
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
      if (!(paramObject instanceof nu))
      {
        bool = false;
      }
      else
      {
        nu localnu = (nu)paramObject;
        if ((!this.g.equals(localnu.g)) || (this.f != localnu.f) || (!this.h.equals(localnu.h)) || (!this.i.equals(localnu.i))) {
          bool = false;
        }
      }
    }
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = this.g;
    arrayOfObject[1] = Boolean.valueOf(this.f);
    arrayOfObject[2] = this.h;
    arrayOfObject[3] = this.i;
    return hV.a(arrayOfObject);
  }
  
  public String toString()
  {
    return hV.a(this).a("types", this.g).a("placeIds", this.i).a("requireOpenNow", Boolean.valueOf(this.f)).a("requestedUserDataTypes", this.h).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    iU.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nu
 * JD-Core Version:    0.7.0.1
 */