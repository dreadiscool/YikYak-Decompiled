import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.ArrayList;

public class na
  implements Parcelable.Creator<PolylineOptions>
{
  public static void a(PolylineOptions paramPolylineOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramPolylineOptions.a());
    b.c(paramParcel, 2, paramPolylineOptions.b(), false);
    b.a(paramParcel, 3, paramPolylineOptions.c());
    b.c(paramParcel, 4, paramPolylineOptions.d());
    b.a(paramParcel, 5, paramPolylineOptions.e());
    b.a(paramParcel, 6, paramPolylineOptions.f());
    b.a(paramParcel, 7, paramPolylineOptions.g());
    b.H(paramParcel, i);
  }
  
  public PolylineOptions a(Parcel paramParcel)
  {
    float f1 = 0.0F;
    boolean bool1 = false;
    int i = a.G(paramParcel);
    ArrayList localArrayList = null;
    boolean bool2 = false;
    int j = 0;
    float f2 = 0.0F;
    int k = 0;
    while (paramParcel.dataPosition() < i)
    {
      int m = a.F(paramParcel);
      switch (a.aH(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        k = a.g(paramParcel, m);
        break;
      case 2: 
        localArrayList = a.c(paramParcel, m, LatLng.CREATOR);
        break;
      case 3: 
        f2 = a.l(paramParcel, m);
        break;
      case 4: 
        j = a.g(paramParcel, m);
        break;
      case 5: 
        f1 = a.l(paramParcel, m);
        break;
      case 6: 
        bool2 = a.c(paramParcel, m);
        break;
      case 7: 
        bool1 = a.c(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new PolylineOptions(k, localArrayList, f2, j, f1, bool2, bool1);
  }
  
  public PolylineOptions[] a(int paramInt)
  {
    return new PolylineOptions[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     na
 * JD-Core Version:    0.7.0.1
 */