import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class mh
  implements Parcelable.Creator<CameraPosition>
{
  public static void a(CameraPosition paramCameraPosition, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramCameraPosition.a());
    b.a(paramParcel, 2, paramCameraPosition.a, paramInt, false);
    b.a(paramParcel, 3, paramCameraPosition.b);
    b.a(paramParcel, 4, paramCameraPosition.c);
    b.a(paramParcel, 5, paramCameraPosition.d);
    b.H(paramParcel, i);
  }
  
  public CameraPosition a(Parcel paramParcel)
  {
    float f1 = 0.0F;
    int i = a.G(paramParcel);
    int j = 0;
    LatLng localLatLng = null;
    float f2 = 0.0F;
    float f3 = 0.0F;
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
        localLatLng = (LatLng)a.a(paramParcel, k, LatLng.CREATOR);
        break;
      case 3: 
        f3 = a.l(paramParcel, k);
        break;
      case 4: 
        f2 = a.l(paramParcel, k);
        break;
      case 5: 
        f1 = a.l(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new CameraPosition(j, localLatLng, f3, f2, f1);
  }
  
  public CameraPosition[] a(int paramInt)
  {
    return new CameraPosition[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     mh
 * JD-Core Version:    0.7.0.1
 */