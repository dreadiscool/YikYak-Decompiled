import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

public abstract class lL
  extends Binder
  implements lK
{
  public static lK a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaChangeListener");
      if ((localIInterface != null) && ((localIInterface instanceof lK))) {
        localObject = (lK)localIInterface;
      } else {
        localObject = new lM(paramIBinder);
      }
    }
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool;
    switch (paramInt1)
    {
    default: 
    case 1598968902: 
      for (bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);; bool = true)
      {
        return bool;
        paramParcel2.writeString("com.google.android.gms.maps.internal.IOnStreetViewPanoramaChangeListener");
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaChangeListener");
    if (paramParcel1.readInt() != 0) {}
    for (StreetViewPanoramaLocation localStreetViewPanoramaLocation = StreetViewPanoramaLocation.CREATOR.a(paramParcel1);; localStreetViewPanoramaLocation = null)
    {
      a(localStreetViewPanoramaLocation);
      paramParcel2.writeNoException();
      bool = true;
      break;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     lL
 * JD-Core Version:    0.7.0.1
 */