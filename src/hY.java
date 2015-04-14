import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.jg.a;
import java.util.ArrayList;

public class hY
  implements Parcelable.Creator<jg.a>
{
  public static void a(jg.a parama, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, parama.a(), false);
    b.c(paramParcel, 1000, parama.e());
    b.b(paramParcel, 2, parama.d(), false);
    b.c(paramParcel, 3, parama.b());
    b.a(paramParcel, 4, parama.c(), false);
    b.H(paramParcel, i);
  }
  
  public jg.a a(Parcel paramParcel)
  {
    int i = 0;
    String str1 = null;
    int j = a.G(paramParcel);
    ArrayList localArrayList = null;
    String str2 = null;
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
        str2 = a.o(paramParcel, m);
        break;
      case 1000: 
        k = a.g(paramParcel, m);
        break;
      case 2: 
        localArrayList = a.C(paramParcel, m);
        break;
      case 3: 
        i = a.g(paramParcel, m);
        break;
      case 4: 
        str1 = a.o(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new jg.a(k, str2, localArrayList, i, str1);
  }
  
  public jg.a[] a(int paramInt)
  {
    return new jg.a[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     hY
 * JD-Core Version:    0.7.0.1
 */