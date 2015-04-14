package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import hV;
import iS;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class nq
  implements SafeParcelable
{
  public static final iS CREATOR = new iS();
  public final int a;
  final boolean b;
  public final List<oa> c;
  private final Set<oa> d;
  
  public nq(int paramInt, boolean paramBoolean, List<oa> paramList)
  {
    this.a = paramInt;
    this.b = paramBoolean;
    List localList;
    if (paramList == null)
    {
      localList = Collections.emptyList();
      this.c = localList;
      if (!this.c.isEmpty()) {
        break label58;
      }
    }
    label58:
    for (this.d = Collections.emptySet();; this.d = Collections.unmodifiableSet(new HashSet(this.c)))
    {
      return;
      localList = Collections.unmodifiableList(paramList);
      break;
    }
  }
  
  public boolean a()
  {
    return this.b;
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
      if (!(paramObject instanceof nq))
      {
        bool = false;
      }
      else
      {
        nq localnq = (nq)paramObject;
        if ((!this.d.equals(localnq.d)) || (this.b != localnq.b)) {
          bool = false;
        }
      }
    }
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.d;
    arrayOfObject[1] = Boolean.valueOf(this.b);
    return hV.a(arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    iS.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nq
 * JD-Core Version:    0.7.0.1
 */