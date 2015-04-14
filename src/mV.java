import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.LatLng;

public class mV
{
  public static void a(LatLng paramLatLng, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramLatLng.a());
    b.a(paramParcel, 2, paramLatLng.a);
    b.a(paramParcel, 3, paramLatLng.b);
    b.H(paramParcel, i);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     mV
 * JD-Core Version:    0.7.0.1
 */