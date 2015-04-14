import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.location.e;

public class jD
  implements Parcelable.Creator<e>
{
  public static void a(e parame, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, parame.a);
    b.c(paramParcel, 1000, parame.a());
    b.c(paramParcel, 2, parame.b);
    b.a(paramParcel, 3, parame.c);
    b.H(paramParcel, i);
  }
  
  public e a(Parcel paramParcel)
  {
    int i = 1;
    int j = a.G(paramParcel);
    int k = 0;
    long l = 0L;
    int m = i;
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
      case 1000: 
        k = a.g(paramParcel, n);
        break;
      case 2: 
        i = a.g(paramParcel, n);
        break;
      case 3: 
        l = a.i(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new e(k, m, i, l);
  }
  
  public e[] a(int paramInt)
  {
    return new e[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     jD
 * JD-Core Version:    0.7.0.1
 */