import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.nd;
import com.google.android.gms.internal.nl;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public class iP
  implements Parcelable.Creator<nl>
{
  public static void a(nl paramnl, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramnl.b, paramInt, false);
    b.c(paramParcel, 1000, paramnl.a());
    b.a(paramParcel, 2, paramnl.c);
    b.a(paramParcel, 3, paramnl.d);
    b.a(paramParcel, 4, paramnl.e);
    b.c(paramParcel, 5, paramnl.f, false);
    b.a(paramParcel, 6, paramnl.g, false);
    b.H(paramParcel, i);
  }
  
  public nl a(Parcel paramParcel)
  {
    String str = null;
    boolean bool1 = true;
    boolean bool2 = false;
    int i = a.G(paramParcel);
    Object localObject = nl.a;
    boolean bool3 = bool1;
    LocationRequest localLocationRequest = null;
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
        localLocationRequest = (LocationRequest)a.a(paramParcel, k, LocationRequest.CREATOR);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        bool2 = a.c(paramParcel, k);
        break;
      case 3: 
        bool3 = a.c(paramParcel, k);
        break;
      case 4: 
        bool1 = a.c(paramParcel, k);
        break;
      case 5: 
        localObject = a.c(paramParcel, k, nd.CREATOR);
        break;
      case 6: 
        str = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new nl(j, localLocationRequest, bool2, bool3, bool1, (List)localObject, str);
  }
  
  public nl[] a(int paramInt)
  {
    return new nl[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     iP
 * JD-Core Version:    0.7.0.1
 */