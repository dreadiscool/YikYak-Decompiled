import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.nu;
import com.google.android.gms.internal.ny;

public class iW
  implements Parcelable.Creator<ny>
{
  public static void a(ny paramny, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1000, paramny.b);
    b.a(paramParcel, 2, paramny.a(), paramInt, false);
    b.a(paramParcel, 3, paramny.b());
    b.c(paramParcel, 4, paramny.c());
    b.H(paramParcel, i);
  }
  
  public ny a(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    nu localnu = null;
    long l = ny.a;
    int k = 102;
    while (paramParcel.dataPosition() < i)
    {
      int m = a.F(paramParcel);
      switch (a.aH(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1000: 
        j = a.g(paramParcel, m);
        break;
      case 2: 
        localnu = (nu)a.a(paramParcel, m, nu.CREATOR);
        break;
      case 3: 
        l = a.i(paramParcel, m);
        break;
      case 4: 
        k = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new ny(j, localnu, l, k);
  }
  
  public ny[] a(int paramInt)
  {
    return new ny[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     iW
 * JD-Core Version:    0.7.0.1
 */