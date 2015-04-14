import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.VisibleRegion;

public class nk
  implements Parcelable.Creator<VisibleRegion>
{
  public static void a(VisibleRegion paramVisibleRegion, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramVisibleRegion.a());
    b.a(paramParcel, 2, paramVisibleRegion.a, paramInt, false);
    b.a(paramParcel, 3, paramVisibleRegion.b, paramInt, false);
    b.a(paramParcel, 4, paramVisibleRegion.c, paramInt, false);
    b.a(paramParcel, 5, paramVisibleRegion.d, paramInt, false);
    b.a(paramParcel, 6, paramVisibleRegion.e, paramInt, false);
    b.H(paramParcel, i);
  }
  
  public VisibleRegion a(Parcel paramParcel)
  {
    LatLngBounds localLatLngBounds = null;
    int i = a.G(paramParcel);
    int j = 0;
    LatLng localLatLng1 = null;
    LatLng localLatLng2 = null;
    LatLng localLatLng3 = null;
    LatLng localLatLng4 = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      switch (a.aH(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        localLatLng4 = (LatLng)a.a(paramParcel, k, LatLng.CREATOR);
        break;
      case 3: 
        localLatLng3 = (LatLng)a.a(paramParcel, k, LatLng.CREATOR);
        break;
      case 4: 
        localLatLng2 = (LatLng)a.a(paramParcel, k, LatLng.CREATOR);
        break;
      case 5: 
        localLatLng1 = (LatLng)a.a(paramParcel, k, LatLng.CREATOR);
        break;
      case 6: 
        localLatLngBounds = (LatLngBounds)a.a(paramParcel, k, LatLngBounds.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new VisibleRegion(j, localLatLng4, localLatLng3, localLatLng2, localLatLng1, localLatLngBounds);
  }
  
  public VisibleRegion[] a(int paramInt)
  {
    return new VisibleRegion[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     nk
 * JD-Core Version:    0.7.0.1
 */