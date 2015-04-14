import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.PolygonOptions;

public class mZ
{
  public static void a(PolygonOptions paramPolygonOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramPolygonOptions.a());
    b.c(paramParcel, 2, paramPolygonOptions.c(), false);
    b.d(paramParcel, 3, paramPolygonOptions.b(), false);
    b.a(paramParcel, 4, paramPolygonOptions.d());
    b.c(paramParcel, 5, paramPolygonOptions.e());
    b.c(paramParcel, 6, paramPolygonOptions.f());
    b.a(paramParcel, 7, paramPolygonOptions.g());
    b.a(paramParcel, 8, paramPolygonOptions.h());
    b.a(paramParcel, 9, paramPolygonOptions.i());
    b.H(paramParcel, i);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     mZ
 * JD-Core Version:    0.7.0.1
 */