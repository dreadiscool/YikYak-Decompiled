import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

public abstract class kP
  extends Binder
  implements kO
{
  public static kO a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
      if ((localIInterface != null) && ((localIInterface instanceof kO))) {
        localObject = (kO)localIInterface;
      } else {
        localObject = new kQ(paramIBinder);
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
    }
    for (;;)
    {
      return bool;
      paramParcel2.writeString("com.google.android.gms.maps.internal.ICreator");
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICreator");
      a(gV.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICreator");
      km localkm = b(gV.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      if (localkm != null) {
        localIBinder = localkm.asBinder();
      }
      paramParcel2.writeStrongBinder(localIBinder);
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICreator");
      gU localgU2 = gV.a(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0) {}
      for (GoogleMapOptions localGoogleMapOptions = GoogleMapOptions.CREATOR.a(paramParcel1);; localGoogleMapOptions = null)
      {
        kp localkp = a(localgU2, localGoogleMapOptions);
        paramParcel2.writeNoException();
        if (localkp != null) {
          localIBinder = localkp.asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder);
        bool = true;
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICreator");
      kd localkd = a();
      paramParcel2.writeNoException();
      if (localkd != null) {
        localIBinder = localkd.asBinder();
      }
      paramParcel2.writeStrongBinder(localIBinder);
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICreator");
      mw localmw = b();
      paramParcel2.writeNoException();
      if (localmw != null) {
        localIBinder = localmw.asBinder();
      }
      paramParcel2.writeStrongBinder(localIBinder);
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICreator");
      a(gV.a(paramParcel1.readStrongBinder()), paramParcel1.readInt());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICreator");
      gU localgU1 = gV.a(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0) {}
      for (StreetViewPanoramaOptions localStreetViewPanoramaOptions = StreetViewPanoramaOptions.CREATOR.a(paramParcel1);; localStreetViewPanoramaOptions = null)
      {
        kB localkB = a(localgU1, localStreetViewPanoramaOptions);
        paramParcel2.writeNoException();
        if (localkB != null) {
          localIBinder = localkB.asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder);
        bool = true;
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICreator");
      ky localky = c(gV.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      if (localky != null) {
        localIBinder = localky.asBinder();
      }
      paramParcel2.writeStrongBinder(localIBinder);
      bool = true;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     kP
 * JD-Core Version:    0.7.0.1
 */