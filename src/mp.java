import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.LatLng;

public class mp
  implements Parcelable.Creator<LatLng>
{
  public static void a(LatLng paramLatLng, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramLatLng.a());
    b.a(paramParcel, 2, paramLatLng.a);
    b.a(paramParcel, 3, paramLatLng.b);
    b.H(paramParcel, i);
  }
  
  public LatLng a(Parcel paramParcel)
  {
    double d1 = 0.0D;
    int i = a.G(paramParcel);
    int j = 0;
    double d2 = d1;
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
        d2 = a.m(paramParcel, k);
        break;
      case 3: 
        d1 = a.m(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new LatLng(j, d2, d1);
  }
  
  public LatLng[] a(int paramInt)
  {
    return new LatLng[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     mp
 * JD-Core Version:    0.7.0.1
 */