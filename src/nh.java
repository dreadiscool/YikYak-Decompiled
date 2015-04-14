import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.Tile;

public class nh
{
  public static void a(Tile paramTile, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramTile.a());
    b.c(paramParcel, 2, paramTile.a);
    b.c(paramParcel, 3, paramTile.b);
    b.a(paramParcel, 4, paramTile.c, false);
    b.H(paramParcel, i);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     nh
 * JD-Core Version:    0.7.0.1
 */