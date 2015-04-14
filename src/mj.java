import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

public class mj
  implements Parcelable.Creator<CircleOptions>
{
  public static void a(CircleOptions paramCircleOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramCircleOptions.a());
    b.a(paramParcel, 2, paramCircleOptions.b(), paramInt, false);
    b.a(paramParcel, 3, paramCircleOptions.c());
    b.a(paramParcel, 4, paramCircleOptions.d());
    b.c(paramParcel, 5, paramCircleOptions.e());
    b.c(paramParcel, 6, paramCircleOptions.f());
    b.a(paramParcel, 7, paramCircleOptions.g());
    b.a(paramParcel, 8, paramCircleOptions.h());
    b.H(paramParcel, i);
  }
  
  public CircleOptions a(Parcel paramParcel)
  {
    float f1 = 0.0F;
    boolean bool = false;
    int i = a.G(paramParcel);
    LatLng localLatLng = null;
    double d = 0.0D;
    int j = 0;
    int k = 0;
    float f2 = 0.0F;
    int m = 0;
    while (paramParcel.dataPosition() < i)
    {
      int n = a.F(paramParcel);
      switch (a.aH(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        m = a.g(paramParcel, n);
        break;
      case 2: 
        localLatLng = (LatLng)a.a(paramParcel, n, LatLng.CREATOR);
        break;
      case 3: 
        d = a.m(paramParcel, n);
        break;
      case 4: 
        f2 = a.l(paramParcel, n);
        break;
      case 5: 
        k = a.g(paramParcel, n);
        break;
      case 6: 
        j = a.g(paramParcel, n);
        break;
      case 7: 
        f1 = a.l(paramParcel, n);
        break;
      case 8: 
        bool = a.c(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new CircleOptions(m, localLatLng, d, f2, k, j, f1, bool);
  }
  
  public CircleOptions[] a(int paramInt)
  {
    return new CircleOptions[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     mj
 * JD-Core Version:    0.7.0.1
 */