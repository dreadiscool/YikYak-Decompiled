import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.internal.y;

public class lY
  implements Parcelable.Creator<y>
{
  public static void a(y paramy, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramy.a());
    b.a(paramParcel, 2, paramy.b(), paramInt, false);
    b.H(paramParcel, i);
  }
  
  public y a(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    Point localPoint = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      switch (a.aH(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        localPoint = (Point)a.a(paramParcel, k, Point.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new y(j, localPoint);
  }
  
  public y[] a(int paramInt)
  {
    return new y[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     lY
 * JD-Core Version:    0.7.0.1
 */