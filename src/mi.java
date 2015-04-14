import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.CameraPosition;

public class mi
{
  public static void a(CameraPosition paramCameraPosition, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramCameraPosition.a());
    b.a(paramParcel, 2, paramCameraPosition.a, paramInt, false);
    b.a(paramParcel, 3, paramCameraPosition.b);
    b.a(paramParcel, 4, paramCameraPosition.c);
    b.a(paramParcel, 5, paramCameraPosition.d);
    b.H(paramParcel, i);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     mi
 * JD-Core Version:    0.7.0.1
 */