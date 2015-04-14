import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public abstract class lI
  extends Binder
  implements lH
{
  public static lH a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
      if ((localIInterface != null) && ((localIInterface instanceof lH))) {
        localObject = (lH)localIInterface;
      } else {
        localObject = new lJ(paramIBinder);
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
        paramParcel2.writeString("com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
    if (paramParcel1.readInt() != 0) {}
    for (StreetViewPanoramaCamera localStreetViewPanoramaCamera = StreetViewPanoramaCamera.CREATOR.a(paramParcel1);; localStreetViewPanoramaCamera = null)
    {
      a(localStreetViewPanoramaCamera);
      paramParcel2.writeNoException();
      bool = true;
      break;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     lI
 * JD-Core Version:    0.7.0.1
 */