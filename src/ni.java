import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.TileOverlayOptions;

public class ni
  implements Parcelable.Creator<TileOverlayOptions>
{
  public static void a(TileOverlayOptions paramTileOverlayOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramTileOverlayOptions.a());
    b.a(paramParcel, 2, paramTileOverlayOptions.b(), false);
    b.a(paramParcel, 3, paramTileOverlayOptions.d());
    b.a(paramParcel, 4, paramTileOverlayOptions.c());
    b.a(paramParcel, 5, paramTileOverlayOptions.e());
    b.H(paramParcel, i);
  }
  
  public TileOverlayOptions a(Parcel paramParcel)
  {
    boolean bool1 = false;
    int i = a.G(paramParcel);
    IBinder localIBinder = null;
    float f = 0.0F;
    boolean bool2 = true;
    int j = 0;
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
        localIBinder = a.p(paramParcel, k);
        break;
      case 3: 
        bool1 = a.c(paramParcel, k);
        break;
      case 4: 
        f = a.l(paramParcel, k);
        break;
      case 5: 
        bool2 = a.c(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new TileOverlayOptions(j, localIBinder, bool1, f, bool2);
  }
  
  public TileOverlayOptions[] a(int paramInt)
  {
    return new TileOverlayOptions[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ni
 * JD-Core Version:    0.7.0.1
 */