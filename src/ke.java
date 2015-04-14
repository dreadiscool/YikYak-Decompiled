import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public abstract class ke
  extends Binder
  implements kd
{
  public static kd a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
      if ((localIInterface != null) && ((localIInterface instanceof kd))) {
        localObject = (kd)localIInterface;
      } else {
        localObject = new kf(paramIBinder);
      }
    }
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    IBinder localIBinder = null;
    boolean bool;
    switch (paramInt1)
    {
    default: 
      bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      for (;;)
      {
        return bool;
        paramParcel2.writeString("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        bool = true;
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        gU localgU11 = a();
        paramParcel2.writeNoException();
        if (localgU11 != null) {
          localIBinder = localgU11.asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder);
        bool = true;
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        gU localgU10 = b();
        paramParcel2.writeNoException();
        if (localgU10 != null) {
          localIBinder = localgU10.asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder);
        bool = true;
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        gU localgU9 = a(paramParcel1.readFloat(), paramParcel1.readFloat());
        paramParcel2.writeNoException();
        if (localgU9 != null) {
          localIBinder = localgU9.asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder);
        bool = true;
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        gU localgU8 = a(paramParcel1.readFloat());
        paramParcel2.writeNoException();
        if (localgU8 != null) {
          localIBinder = localgU8.asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder);
        bool = true;
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        gU localgU7 = b(paramParcel1.readFloat());
        paramParcel2.writeNoException();
        if (localgU7 != null) {
          localIBinder = localgU7.asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder);
        bool = true;
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        gU localgU6 = a(paramParcel1.readFloat(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (localgU6 != null) {
          localIBinder = localgU6.asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder);
        bool = true;
      }
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
      if (paramParcel1.readInt() != 0) {}
      for (CameraPosition localCameraPosition = CameraPosition.CREATOR.a(paramParcel1);; localCameraPosition = null)
      {
        gU localgU5 = a(localCameraPosition);
        paramParcel2.writeNoException();
        if (localgU5 != null) {
          localIBinder = localgU5.asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder);
        bool = true;
        break;
      }
    case 8: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
      if (paramParcel1.readInt() != 0) {}
      for (LatLng localLatLng2 = LatLng.CREATOR.a(paramParcel1);; localLatLng2 = null)
      {
        gU localgU4 = a(localLatLng2);
        paramParcel2.writeNoException();
        if (localgU4 != null) {
          localIBinder = localgU4.asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder);
        bool = true;
        break;
      }
    case 9: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
      if (paramParcel1.readInt() != 0) {}
      for (LatLng localLatLng1 = LatLng.CREATOR.a(paramParcel1);; localLatLng1 = null)
      {
        gU localgU3 = a(localLatLng1, paramParcel1.readFloat());
        paramParcel2.writeNoException();
        if (localgU3 != null) {
          localIBinder = localgU3.asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder);
        bool = true;
        break;
      }
    case 10: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
      if (paramParcel1.readInt() != 0) {}
      for (LatLngBounds localLatLngBounds2 = LatLngBounds.CREATOR.a(paramParcel1);; localLatLngBounds2 = null)
      {
        gU localgU2 = a(localLatLngBounds2, paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (localgU2 != null) {
          localIBinder = localgU2.asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder);
        bool = true;
        break;
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
    if (paramParcel1.readInt() != 0) {}
    for (LatLngBounds localLatLngBounds1 = LatLngBounds.CREATOR.a(paramParcel1);; localLatLngBounds1 = null)
    {
      gU localgU1 = a(localLatLngBounds1, paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      if (localgU1 != null) {
        localIBinder = localgU1.asBinder();
      }
      paramParcel2.writeStrongBinder(localIBinder);
      bool = true;
      break;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ke
 * JD-Core Version:    0.7.0.1
 */