import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.StreetViewPanoramaLink;

public class nd
  implements Parcelable.Creator<StreetViewPanoramaLink>
{
  public static void a(StreetViewPanoramaLink paramStreetViewPanoramaLink, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramStreetViewPanoramaLink.a());
    b.a(paramParcel, 2, paramStreetViewPanoramaLink.a, false);
    b.a(paramParcel, 3, paramStreetViewPanoramaLink.b);
    b.H(paramParcel, i);
  }
  
  public StreetViewPanoramaLink a(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    String str = null;
    float f = 0.0F;
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
        str = a.o(paramParcel, k);
        break;
      case 3: 
        f = a.l(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new StreetViewPanoramaLink(j, str, f);
  }
  
  public StreetViewPanoramaLink[] a(int paramInt)
  {
    return new StreetViewPanoramaLink[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     nd
 * JD-Core Version:    0.7.0.1
 */