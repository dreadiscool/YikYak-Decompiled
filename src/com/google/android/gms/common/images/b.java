package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;

public class b
  implements Parcelable.Creator<WebImage>
{
  static void a(WebImage paramWebImage, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.H(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, paramWebImage.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 2, paramWebImage.getUrl(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 3, paramWebImage.getWidth());
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 4, paramWebImage.getHeight());
    com.google.android.gms.common.internal.safeparcel.b.H(paramParcel, i);
  }
  
  public WebImage C(Parcel paramParcel)
  {
    int i = 0;
    int j = a.G(paramParcel);
    Object localObject1 = null;
    int k = 0;
    int m = 0;
    if (paramParcel.dataPosition() < j)
    {
      int n = a.F(paramParcel);
      int i1;
      int i2;
      Object localObject2;
      int i3;
      switch (a.aH(n))
      {
      default: 
        a.b(paramParcel, n);
        i1 = i;
        i2 = k;
        localObject2 = localObject1;
        i3 = m;
      }
      for (;;)
      {
        m = i3;
        localObject1 = localObject2;
        k = i2;
        i = i1;
        break;
        int i7 = a.g(paramParcel, n);
        int i8 = i;
        i2 = k;
        localObject2 = localObject1;
        i3 = i7;
        i1 = i8;
        continue;
        Uri localUri = (Uri)a.a(paramParcel, n, Uri.CREATOR);
        i3 = m;
        int i6 = k;
        localObject2 = localUri;
        i1 = i;
        i2 = i6;
        continue;
        int i4 = a.g(paramParcel, n);
        localObject2 = localObject1;
        i3 = m;
        int i5 = i;
        i2 = i4;
        i1 = i5;
        continue;
        i1 = a.g(paramParcel, n);
        i2 = k;
        localObject2 = localObject1;
        i3 = m;
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new WebImage(m, localObject1, k, i);
  }
  
  public WebImage[] aA(int paramInt)
  {
    return new WebImage[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.b
 * JD-Core Version:    0.7.0.1
 */