import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.nq;
import com.google.android.gms.internal.oa;
import java.util.ArrayList;

public class iS
  implements Parcelable.Creator<nq>
{
  public static void a(nq paramnq, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramnq.a());
    b.c(paramParcel, 1000, paramnq.a);
    b.c(paramParcel, 2, paramnq.c, false);
    b.H(paramParcel, i);
  }
  
  public nq a(Parcel paramParcel)
  {
    boolean bool = false;
    int i = a.G(paramParcel);
    ArrayList localArrayList = null;
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
        bool = a.c(paramParcel, k);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        localArrayList = a.c(paramParcel, k, oa.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new nq(j, bool, localArrayList);
  }
  
  public nq[] a(int paramInt)
  {
    return new nq[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     iS
 * JD-Core Version:    0.7.0.1
 */