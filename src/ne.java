import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaLink;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

public class ne
  implements Parcelable.Creator<StreetViewPanoramaLocation>
{
  public static void a(StreetViewPanoramaLocation paramStreetViewPanoramaLocation, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramStreetViewPanoramaLocation.a());
    b.a(paramParcel, 2, paramStreetViewPanoramaLocation.a, paramInt, false);
    b.a(paramParcel, 3, paramStreetViewPanoramaLocation.b, paramInt, false);
    b.a(paramParcel, 4, paramStreetViewPanoramaLocation.c, false);
    b.H(paramParcel, i);
  }
  
  public StreetViewPanoramaLocation a(Parcel paramParcel)
  {
    Object localObject1 = null;
    int i = a.G(paramParcel);
    int j = 0;
    Object localObject2 = null;
    Object localObject3 = null;
    if (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      Object localObject4;
      Object localObject5;
      Object localObject6;
      int m;
      switch (a.aH(k))
      {
      default: 
        a.b(paramParcel, k);
        localObject4 = localObject1;
        localObject5 = localObject2;
        localObject6 = localObject3;
        m = j;
      }
      for (;;)
      {
        j = m;
        localObject3 = localObject6;
        localObject2 = localObject5;
        localObject1 = localObject4;
        break;
        int n = a.g(paramParcel, k);
        Object localObject9 = localObject1;
        localObject5 = localObject2;
        localObject6 = localObject3;
        m = n;
        localObject4 = localObject9;
        continue;
        StreetViewPanoramaLink[] arrayOfStreetViewPanoramaLink = (StreetViewPanoramaLink[])a.b(paramParcel, k, StreetViewPanoramaLink.CREATOR);
        m = j;
        Object localObject8 = localObject2;
        localObject6 = arrayOfStreetViewPanoramaLink;
        localObject4 = localObject1;
        localObject5 = localObject8;
        continue;
        LatLng localLatLng = (LatLng)a.a(paramParcel, k, LatLng.CREATOR);
        localObject6 = localObject3;
        m = j;
        Object localObject7 = localObject1;
        localObject5 = localLatLng;
        localObject4 = localObject7;
        continue;
        localObject4 = a.o(paramParcel, k);
        localObject5 = localObject2;
        localObject6 = localObject3;
        m = j;
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new StreetViewPanoramaLocation(j, localObject3, localObject2, localObject1);
  }
  
  public StreetViewPanoramaLocation[] a(int paramInt)
  {
    return new StreetViewPanoramaLocation[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ne
 * JD-Core Version:    0.7.0.1
 */