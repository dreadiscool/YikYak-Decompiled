import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.MarkerOptions;

public class mX
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
    b.H(paramParcel, i);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     mX
 * JD-Core Version:    0.7.0.1
 */