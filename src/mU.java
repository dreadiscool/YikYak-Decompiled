import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.internal.p;

public class mU
  implements Parcelable.Creator<p>
{
  public static void a(p paramp, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramp.a());
    b.a(paramParcel, 2, paramp.b(), paramInt, false);
    b.H(paramParcel, i);
  }
  
  public p a(Parcel paramParcel)
  {
    int i = com.google.android.gms.common.internal.safeparcel.a.G(paramParcel);
    int j = 0;
    com.google.android.gms.maps.model.internal.a locala = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = com.google.android.gms.common.internal.safeparcel.a.F(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.aH(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        break;
      case 1: 
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        break;
      case 2: 
        locala = (com.google.android.gms.maps.model.internal.a)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, com.google.android.gms.maps.model.internal.a.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new p(j, locala);
  }
  
  public p[] a(int paramInt)
  {
    return new p[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     mU
 * JD-Core Version:    0.7.0.1
 */