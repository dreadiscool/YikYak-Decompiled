import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.PolylineOptions;

public class nb
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
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     nb
 * JD-Core Version:    0.7.0.1
 */