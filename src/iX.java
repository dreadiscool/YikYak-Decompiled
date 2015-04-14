import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.oa;

public class iX
  implements Parcelable.Creator<oa>
{
  public static void a(oa paramoa, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramoa.bx, false);
    b.c(paramParcel, 1000, paramoa.bw);
    b.H(paramParcel, i);
  }
  
  public oa a(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    String str = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      switch (a.aH(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        str = a.o(paramParcel, k);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new oa(j, str);
  }
  
  public oa[] a(int paramInt)
  {
    return new oa[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     iX
 * JD-Core Version:    0.7.0.1
 */