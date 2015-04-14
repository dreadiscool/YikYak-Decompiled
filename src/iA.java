import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.nd;

public class iA
  implements Parcelable.Creator<nd>
{
  public static void a(nd paramnd, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramnd.a);
    b.c(paramParcel, 1000, paramnd.a());
    b.a(paramParcel, 2, paramnd.b, false);
    b.H(paramParcel, i);
  }
  
  public nd a(Parcel paramParcel)
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
        i = a.g(paramParcel, m);
        break;
      case 1000: 
        k = a.g(paramParcel, m);
        break;
      case 2: 
        str = a.o(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new nd(k, i, str);
  }
  
  public nd[] a(int paramInt)
  {
    return new nd[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     iA
 * JD-Core Version:    0.7.0.1
 */