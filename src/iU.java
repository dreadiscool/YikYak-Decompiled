import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.nu;
import com.google.android.gms.internal.oa;
import com.google.android.gms.internal.oe;
import java.util.ArrayList;

public class iU
  implements Parcelable.Creator<nu>
{
  public static void a(nu paramnu, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramnu.b, false);
    b.c(paramParcel, 1000, paramnu.a);
    b.a(paramParcel, 2, paramnu.a(), false);
    b.a(paramParcel, 3, paramnu.b());
    b.c(paramParcel, 4, paramnu.c, false);
    b.b(paramParcel, 6, paramnu.d, false);
    b.H(paramParcel, i);
  }
  
  public nu a(Parcel paramParcel)
  {
    boolean bool = false;
    ArrayList localArrayList1 = null;
    int i = a.G(paramParcel);
    ArrayList localArrayList2 = null;
    String str = null;
    ArrayList localArrayList3 = null;
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
        localArrayList3 = a.c(paramParcel, k, oa.CREATOR);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        str = a.o(paramParcel, k);
        break;
      case 3: 
        bool = a.c(paramParcel, k);
        break;
      case 4: 
        localArrayList2 = a.c(paramParcel, k, oe.CREATOR);
        break;
      case 6: 
        localArrayList1 = a.C(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new nu(j, localArrayList3, str, bool, localArrayList2, localArrayList1);
  }
  
  public nu[] a(int paramInt)
  {
    return new nu[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     iU
 * JD-Core Version:    0.7.0.1
 */