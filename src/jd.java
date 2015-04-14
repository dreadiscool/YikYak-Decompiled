import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.oh;

public class jd
  implements Parcelable.Creator<oh>
{
  public static void a(oh paramoh, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramoh.c, false);
    b.c(paramParcel, 1000, paramoh.b);
    b.a(paramParcel, 2, paramoh.d, false);
    b.a(paramParcel, 3, paramoh.e, false);
    b.a(paramParcel, 4, paramoh.f, false);
    b.H(paramParcel, i);
  }
  
  public oh a(Parcel paramParcel)
  {
    String str1 = null;
    int i = a.G(paramParcel);
    int j = 0;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      switch (a.aH(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        str4 = a.o(paramParcel, k);
        break;
      case 1000: 
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
    return new oh(j, str4, str3, str2, str1);
  }
  
  public oh[] a(int paramInt)
  {
    return new oh[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     jd
 * JD-Core Version:    0.7.0.1
 */