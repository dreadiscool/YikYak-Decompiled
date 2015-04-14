import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.LatLngBounds;

public class mo
{
  public static void a(LatLngBounds paramLatLngBounds, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramLatLngBounds.a());
    b.a(paramParcel, 2, paramLatLngBounds.a, paramInt, false);
    b.a(paramParcel, 3, paramLatLngBounds.b, paramInt, false);
    b.H(paramParcel, i);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     mo
 * JD-Core Version:    0.7.0.1
 */