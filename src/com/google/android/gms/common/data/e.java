package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class e<T extends SafeParcelable>
  extends DataBuffer<T>
{
  private static final String[] Lb;
  private final Parcelable.Creator<T> Lc;
  
  static
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "data";
    Lb = arrayOfString;
  }
  
  public e(DataHolder paramDataHolder, Parcelable.Creator<T> paramCreator)
  {
    super(paramDataHolder);
    this.Lc = paramCreator;
  }
  
  public T at(int paramInt)
  {
    byte[] arrayOfByte = this.JG.f("data", paramInt, this.JG.au(paramInt));
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(arrayOfByte, 0, arrayOfByte.length);
    localParcel.setDataPosition(0);
    SafeParcelable localSafeParcelable = (SafeParcelable)this.Lc.createFromParcel(localParcel);
    localParcel.recycle();
    return localSafeParcelable;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.e
 * JD-Core Version:    0.7.0.1
 */