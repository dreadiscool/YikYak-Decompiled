import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.VisibleRegion;

public class nl
{
  public static void a(VisibleRegion paramVisibleRegion, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramVisibleRegion.a());
    b.a(paramParcel, 2, paramVisibleRegion.a, paramInt, false);
    b.a(paramParcel, 3, paramVisibleRegion.b, paramInt, false);
    b.a(paramParcel, 4, paramVisibleRegion.c, paramInt, false);
    b.a(paramParcel, 5, paramVisibleRegion.d, paramInt, false);
    b.a(paramParcel, 6, paramVisibleRegion.e, paramInt, false);
    b.H(paramParcel, i);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     nl
 * JD-Core Version:    0.7.0.1
 */