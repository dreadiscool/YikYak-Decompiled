import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public abstract class kw
  extends Binder
  implements kv
{
  public static kv a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
      if ((localIInterface != null) && ((localIInterface instanceof kv))) {
        localObject = (kv)localIInterface;
      } else {
        localObject = new kx(paramIBinder);
      }
    }
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject = null;
    int i = 0;
    int j = 1;
    switch (paramInt1)
    {
    default: 
      j = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
      for (;;)
      {
        return j;
        paramParcel2.writeString("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        if (paramParcel1.readInt() != 0) {
          i = j;
        }
        a(i);
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        if (paramParcel1.readInt() != 0) {
          i = j;
        }
        b(i);
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        if (paramParcel1.readInt() != 0) {
          i = j;
        }
        c(i);
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        if (paramParcel1.readInt() != 0) {
          i = j;
        }
        d(i);
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        boolean bool4 = a();
        paramParcel2.writeNoException();
        if (bool4) {
          i = j;
        }
        paramParcel2.writeInt(i);
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        boolean bool3 = b();
        paramParcel2.writeNoException();
        if (bool3) {
          i = j;
        }
        paramParcel2.writeInt(i);
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        boolean bool2 = c();
        paramParcel2.writeNoException();
        if (bool2) {
          i = j;
        }
        paramParcel2.writeInt(i);
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        boolean bool1 = d();
        paramParcel2.writeNoException();
        if (bool1) {
          i = j;
        }
        paramParcel2.writeInt(i);
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        if (paramParcel1.readInt() != 0) {}
        for (StreetViewPanoramaCamera localStreetViewPanoramaCamera2 = StreetViewPanoramaCamera.CREATOR.a(paramParcel1);; localStreetViewPanoramaCamera2 = null)
        {
          a(localStreetViewPanoramaCamera2, paramParcel1.readLong());
          paramParcel2.writeNoException();
          break;
        }
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        StreetViewPanoramaCamera localStreetViewPanoramaCamera1 = e();
        paramParcel2.writeNoException();
        if (localStreetViewPanoramaCamera1 != null)
        {
          paramParcel2.writeInt(j);
          localStreetViewPanoramaCamera1.writeToParcel(paramParcel2, j);
        }
        else
        {
          paramParcel2.writeInt(0);
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
          a(paramParcel1.readString());
          paramParcel2.writeNoException();
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
          if (paramParcel1.readInt() != 0) {
            localObject = LatLng.CREATOR.a(paramParcel1);
          }
          a((LatLng)localObject);
          paramParcel2.writeNoException();
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
          if (paramParcel1.readInt() != 0) {
            localObject = LatLng.CREATOR.a(paramParcel1);
          }
          a((LatLng)localObject, paramParcel1.readInt());
          paramParcel2.writeNoException();
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
          StreetViewPanoramaLocation localStreetViewPanoramaLocation = f();
          paramParcel2.writeNoException();
          if (localStreetViewPanoramaLocation != null)
          {
            paramParcel2.writeInt(j);
            localStreetViewPanoramaLocation.writeToParcel(paramParcel2, j);
          }
          else
          {
            paramParcel2.writeInt(0);
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            a(lL.a(paramParcel1.readStrongBinder()));
            paramParcel2.writeNoException();
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            a(lI.a(paramParcel1.readStrongBinder()));
            paramParcel2.writeNoException();
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            a(lO.a(paramParcel1.readStrongBinder()));
            paramParcel2.writeNoException();
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            StreetViewPanoramaOrientation localStreetViewPanoramaOrientation2 = a(gV.a(paramParcel1.readStrongBinder()));
            paramParcel2.writeNoException();
            if (localStreetViewPanoramaOrientation2 != null)
            {
              paramParcel2.writeInt(j);
              localStreetViewPanoramaOrientation2.writeToParcel(paramParcel2, j);
            }
            else
            {
              paramParcel2.writeInt(0);
            }
          }
        }
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
    if (paramParcel1.readInt() != 0) {}
    for (StreetViewPanoramaOrientation localStreetViewPanoramaOrientation1 = StreetViewPanoramaOrientation.CREATOR.a(paramParcel1);; localStreetViewPanoramaOrientation1 = null)
    {
      gU localgU = a(localStreetViewPanoramaOrientation1);
      paramParcel2.writeNoException();
      if (localgU != null) {
        localObject = localgU.asBinder();
      }
      paramParcel2.writeStrongBinder((IBinder)localObject);
      break;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     kw
 * JD-Core Version:    0.7.0.1
 */