import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.internal.e;

public class mv
  implements Parcelable.Creator<e>
{
  public static void a(e parame, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, parame.a());
    b.a(paramParcel, 2, parame.b(), paramInt, false);
    b.H(paramParcel, i);
  }
  
  public e a(Parcel paramParcel)
  {
    int i = com.google.android.gms.common.internal.safeparcel.a.G(paramParcel);
    int j = 0;
    com.google.android.gms.maps.model.internal.a locala = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = com.google.android.gms.common.internal.safeparcel.a.F(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.aH(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        break;
      case 1: 
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        break;
      case 2: 
        locala = (com.google.android.gms.maps.model.internal.a)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, com.google.android.gms.maps.model.internal.a.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new e(j, locala);
  }
  
  public e[] a(int paramInt)
  {
    return new e[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     mv
 * JD-Core Version:    0.7.0.1
 */