import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.CircleOptions;

public class mk
{
  public static void a(CircleOptions paramCircleOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramCircleOptions.a());
    b.a(paramParcel, 2, paramCircleOptions.b(), paramInt, false);
    b.a(paramParcel, 3, paramCircleOptions.c());
    b.a(paramParcel, 4, paramCircleOptions.d());
    b.c(paramParcel, 5, paramCircleOptions.e());
    b.c(paramParcel, 6, paramCircleOptions.f());
    b.a(paramParcel, 7, paramCircleOptions.g());
    b.a(paramParcel, 8, paramCircleOptions.h());
    b.H(paramParcel, i);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     mk
 * JD-Core Version:    0.7.0.1
 */