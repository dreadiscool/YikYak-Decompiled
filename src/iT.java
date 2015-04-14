import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.ns;
import com.google.android.gms.internal.nu;

public class iT
  implements Parcelable.Creator<ns>
{
  public static void a(ns paramns, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramns.b());
    b.c(paramParcel, 1000, paramns.a());
    b.c(paramParcel, 2, paramns.c());
    b.a(paramParcel, 3, paramns.d(), paramInt, false);
    b.H(paramParcel, i);
  }
  
  public ns a(Parcel paramParcel)
  {
    int i = 0;
    int j = a.G(paramParcel);
    int k = -1;
    nu localnu = null;
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
        i = a.g(paramParcel, n);
        break;
      case 1000: 
        m = a.g(paramParcel, n);
        break;
      case 2: 
        k = a.g(paramParcel, n);
        break;
      case 3: 
        localnu = (nu)a.a(paramParcel, n, nu.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ns(m, i, k, localnu);
  }
  
  public ns[] a(int paramInt)
  {
    return new ns[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     iT
 * JD-Core Version:    0.7.0.1
 */