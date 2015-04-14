import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class mW
  implements Parcelable.Creator<MarkerOptions>
{
  public static void a(MarkerOptions paramMarkerOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramMarkerOptions.a());
    b.a(paramParcel, 2, paramMarkerOptions.c(), paramInt, false);
    b.a(paramParcel, 3, paramMarkerOptions.d(), false);
    b.a(paramParcel, 4, paramMarkerOptions.e(), false);
    b.a(paramParcel, 5, paramMarkerOptions.b(), false);
    b.a(paramParcel, 6, paramMarkerOptions.f());
    b.a(paramParcel, 7, paramMarkerOptions.g());
    b.a(paramParcel, 8, paramMarkerOptions.h());
    b.a(paramParcel, 9, paramMarkerOptions.i());
    b.a(paramParcel, 10, paramMarkerOptions.j());
    b.a(paramParcel, 11, paramMarkerOptions.k());
    b.a(paramParcel, 12, paramMarkerOptions.l());
    b.a(paramParcel, 13, paramMarkerOptions.m());
    b.a(paramParcel, 14, paramMarkerOptions.n());
    b.H(paramParcel, i);
  }
  
  public MarkerOptions a(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    LatLng localLatLng = null;
    String str1 = null;
    String str2 = null;
    IBinder localIBinder = null;
    float f1 = 0.0F;
    float f2 = 0.0F;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    float f3 = 0.0F;
    float f4 = 0.5F;
    float f5 = 0.0F;
    float f6 = 1.0F;
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
        str1 = a.o(paramParcel, k);
        break;
      case 4: 
        str2 = a.o(paramParcel, k);
        break;
      case 5: 
        localIBinder = a.p(paramParcel, k);
        break;
      case 6: 
        f1 = a.l(paramParcel, k);
        break;
      case 7: 
        f2 = a.l(paramParcel, k);
        break;
      case 8: 
        bool1 = a.c(paramParcel, k);
        break;
      case 9: 
        bool2 = a.c(paramParcel, k);
        break;
      case 10: 
        bool3 = a.c(paramParcel, k);
        break;
      case 11: 
        f3 = a.l(paramParcel, k);
        break;
      case 12: 
        f4 = a.l(paramParcel, k);
        break;
      case 13: 
        f5 = a.l(paramParcel, k);
        break;
      case 14: 
        f6 = a.l(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new MarkerOptions(j, localLatLng, str1, str2, localIBinder, f1, f2, bool1, bool2, bool3, f3, f4, f5, f6);
  }
  
  public MarkerOptions[] a(int paramInt)
  {
    return new MarkerOptions[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     mW
 * JD-Core Version:    0.7.0.1
 */