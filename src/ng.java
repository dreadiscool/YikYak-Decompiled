import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.Tile;

public class ng
  implements Parcelable.Creator<Tile>
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
  
  public Tile a(Parcel paramParcel)
  {
    int i = 0;
    int j = a.G(paramParcel);
    byte[] arrayOfByte = null;
    int k = 0;
    int m = 0;
    while (paramParcel.dataPosition() < j)
    {
      int n = a.F(paramParcel);
      switch (a.aH(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        m = a.g(paramParcel, n);
        break;
      case 2: 
        k = a.g(paramParcel, n);
        break;
      case 3: 
        i = a.g(paramParcel, n);
        break;
      case 4: 
        arrayOfByte = a.r(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new Tile(m, k, i, arrayOfByte);
  }
  
  public Tile[] a(int paramInt)
  {
    return new Tile[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ng
 * JD-Core Version:    0.7.0.1
 */