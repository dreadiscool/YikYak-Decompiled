import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.oe;

public class iZ
  implements Parcelable.Creator<oe>
{
  public static void a(oe paramoe, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramoe.e, false);
    b.c(paramParcel, 1000, paramoe.d);
    b.c(paramParcel, 2, paramoe.f);
    b.H(paramParcel, i);
  }
  
  public oe a(Parcel paramParcel)
  {
    int i = 0;
    int j = a.G(paramParcel);
    String str = null;
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
        str = a.o(paramParcel, m);
        break;
      case 1000: 
        k = a.g(paramParcel, m);
        break;
      case 2: 
        i = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new oe(k, str, i);
  }
  
  public oe[] a(int paramInt)
  {
    return new oe[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     iZ
 * JD-Core Version:    0.7.0.1
 */