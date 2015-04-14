import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.jj;

public class hx
  implements Parcelable.Creator<jj>
{
  public static void a(jj paramjj, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramjj.a);
    b.c(paramParcel, 2, paramjj.b);
    b.c(paramParcel, 3, paramjj.c);
    b.a(paramParcel, 4, paramjj.d, false);
    b.a(paramParcel, 5, paramjj.e, false);
    b.a(paramParcel, 6, paramjj.f, paramInt, false);
    b.a(paramParcel, 7, paramjj.g, false);
    b.H(paramParcel, i);
  }
  
  public jj a(Parcel paramParcel)
  {
    int i = 0;
    Bundle localBundle = null;
    int j = a.G(paramParcel);
    Scope[] arrayOfScope = null;
    IBinder localIBinder = null;
    String str = null;
    int k = 0;
    int m = 0;
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
      case 2: 
        k = a.g(paramParcel, n);
        break;
      case 3: 
        i = a.g(paramParcel, n);
        break;
      case 4: 
        str = a.o(paramParcel, n);
        break;
      case 5: 
        localIBinder = a.p(paramParcel, n);
        break;
      case 6: 
        arrayOfScope = (Scope[])a.b(paramParcel, n, Scope.CREATOR);
        break;
      case 7: 
        localBundle = a.q(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new jj(m, k, i, str, localIBinder, arrayOfScope, localBundle);
  }
  
  public jj[] a(int paramInt)
  {
    return new jj[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     hx
 * JD-Core Version:    0.7.0.1
 */