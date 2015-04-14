import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.TileOverlayOptions;

public class nj
{
  public static void a(TileOverlayOptions paramTileOverlayOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramTileOverlayOptions.a());
    b.a(paramParcel, 2, paramTileOverlayOptions.b(), false);
    b.a(paramParcel, 3, paramTileOverlayOptions.d());
    b.a(paramParcel, 4, paramTileOverlayOptions.c());
    b.H(paramParcel, i);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     nj
 * JD-Core Version:    0.7.0.1
 */