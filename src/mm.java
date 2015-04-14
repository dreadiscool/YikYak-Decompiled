import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.GroundOverlayOptions;

public class mm
{
  public static void a(GroundOverlayOptions paramGroundOverlayOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramGroundOverlayOptions.b());
    b.a(paramParcel, 2, paramGroundOverlayOptions.a(), false);
    b.a(paramParcel, 3, paramGroundOverlayOptions.c(), paramInt, false);
    b.a(paramParcel, 4, paramGroundOverlayOptions.d());
    b.a(paramParcel, 5, paramGroundOverlayOptions.e());
    b.a(paramParcel, 6, paramGroundOverlayOptions.f(), paramInt, false);
    b.a(paramParcel, 7, paramGroundOverlayOptions.g());
    b.a(paramParcel, 8, paramGroundOverlayOptions.h());
    b.a(paramParcel, 9, paramGroundOverlayOptions.l());
    b.a(paramParcel, 10, paramGroundOverlayOptions.i());
    b.a(paramParcel, 11, paramGroundOverlayOptions.j());
    b.a(paramParcel, 12, paramGroundOverlayOptions.k());
    b.H(paramParcel, i);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     mm
 * JD-Core Version:    0.7.0.1
 */