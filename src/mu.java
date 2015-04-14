import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.internal.c;

public class mu
  implements Parcelable.Creator<c>
{
  public static void a(c paramc, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramc.a());
    b.c(paramParcel, 2, paramc.b());
    b.a(paramParcel, 3, paramc.c(), false);
    b.H(paramParcel, i);
  }
  
  public c a(Parcel paramParcel)
  {
    int i = 0;
    int j = a.G(paramParcel);
    Bundle localBundle = null;
    int k = 0;
    while (paramParcel.dataPosition() < j)
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
        i = a.g(paramParcel, m);
        break;
      case 3: 
        localBundle = a.q(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new c(k, i, localBundle);
  }
  
  public c[] a(int paramInt)
  {
    return new c[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     mu
 * JD-Core Version:    0.7.0.1
 */