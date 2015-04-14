import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.nw;

public class iV
  implements Parcelable.Creator<nw>
{
  public static void a(nw paramnw, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramnw.a);
    b.a(paramParcel, 2, paramnw.a(), false);
    b.a(paramParcel, 3, paramnw.b(), false);
    b.a(paramParcel, 4, paramnw.c(), false);
    b.H(paramParcel, i);
  }
  
  public nw a(Parcel paramParcel)
  {
    String str1 = null;
    int i = a.G(paramParcel);
    int j = 0;
    String str2 = null;
    String str3 = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      switch (a.aH(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        str3 = a.o(paramParcel, k);
        break;
      case 3: 
        str2 = a.o(paramParcel, k);
        break;
      case 4: 
        str1 = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new nw(j, str3, str2, str1);
  }
  
  public nw[] a(int paramInt)
  {
    return new nw[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     iV
 * JD-Core Version:    0.7.0.1
 */