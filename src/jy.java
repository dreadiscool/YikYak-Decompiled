import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.nn;
import com.google.android.gms.location.GeofencingRequest;
import java.util.ArrayList;

public class jy
  implements Parcelable.Creator<GeofencingRequest>
{
  public static void a(GeofencingRequest paramGeofencingRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramGeofencingRequest.b(), false);
    b.c(paramParcel, 1000, paramGeofencingRequest.a());
    b.c(paramParcel, 2, paramGeofencingRequest.c());
    b.H(paramParcel, i);
  }
  
  public GeofencingRequest a(Parcel paramParcel)
  {
    int i = 0;
    int j = a.G(paramParcel);
    ArrayList localArrayList = null;
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
        localArrayList = a.c(paramParcel, m, nn.CREATOR);
        break;
      case 1000: 
        k = a.g(paramParcel, m);
        break;
      case 2: 
        i = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new GeofencingRequest(k, localArrayList, i);
  }
  
  public GeofencingRequest[] a(int paramInt)
  {
    return new GeofencingRequest[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     jy
 * JD-Core Version:    0.7.0.1
 */