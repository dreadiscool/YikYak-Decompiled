import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class mn
  implements Parcelable.Creator<LatLngBounds>
{
  public static void a(LatLngBounds paramLatLngBounds, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramLatLngBounds.a());
    b.a(paramParcel, 2, paramLatLngBounds.a, paramInt, false);
    b.a(paramParcel, 3, paramLatLngBounds.b, paramInt, false);
    b.H(paramParcel, i);
  }
  
  public LatLngBounds a(Parcel paramParcel)
  {
    Object localObject1 = null;
    int i = a.G(paramParcel);
    int j = 0;
    Object localObject2 = null;
    if (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      Object localObject3;
      Object localObject4;
      int m;
      switch (a.aH(k))
      {
      default: 
        a.b(paramParcel, k);
        localObject3 = localObject1;
        localObject4 = localObject2;
        m = j;
      }
      for (;;)
      {
        j = m;
        localObject2 = localObject4;
        localObject1 = localObject3;
        break;
        int n = a.g(paramParcel, k);
        Object localObject5 = localObject1;
        localObject4 = localObject2;
        m = n;
        localObject3 = localObject5;
        continue;
        LatLng localLatLng = (LatLng)a.a(paramParcel, k, LatLng.CREATOR);
        m = j;
        localObject3 = localObject1;
        localObject4 = localLatLng;
        continue;
        localObject3 = (LatLng)a.a(paramParcel, k, LatLng.CREATOR);
        localObject4 = localObject2;
        m = j;
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new LatLngBounds(j, localObject2, localObject1);
  }
  
  public LatLngBounds[] a(int paramInt)
  {
    return new LatLngBounds[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     mn
 * JD-Core Version:    0.7.0.1
 */