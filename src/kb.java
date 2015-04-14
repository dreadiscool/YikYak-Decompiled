import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.GoogleMapOptions;

public class kb
{
  public static void a(GoogleMapOptions paramGoogleMapOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramGoogleMapOptions.a());
    b.a(paramParcel, 2, paramGoogleMapOptions.b());
    b.a(paramParcel, 3, paramGoogleMapOptions.c());
    b.c(paramParcel, 4, paramGoogleMapOptions.l());
    b.a(paramParcel, 5, paramGoogleMapOptions.m(), paramInt, false);
    b.a(paramParcel, 6, paramGoogleMapOptions.d());
    b.a(paramParcel, 7, paramGoogleMapOptions.e());
    b.a(paramParcel, 8, paramGoogleMapOptions.f());
    b.a(paramParcel, 9, paramGoogleMapOptions.g());
    b.a(paramParcel, 10, paramGoogleMapOptions.h());
    b.a(paramParcel, 11, paramGoogleMapOptions.i());
    b.H(paramParcel, i);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     kb
 * JD-Core Version:    0.7.0.1
 */