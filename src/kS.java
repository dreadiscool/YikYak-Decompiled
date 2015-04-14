import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class kS
  extends Binder
  implements kR
{
  public static kR a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
      if ((localIInterface != null) && ((localIInterface instanceof kR))) {
        localObject = (kR)localIInterface;
      } else {
        localObject = new kT(paramIBinder);
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
      paramParcel2.writeString("com.google.android.gms.maps.internal.IInfoWindowAdapter");
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
      gU localgU2 = a(mJ.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      if (localgU2 != null) {
        localIBinder = localgU2.asBinder();
      }
      paramParcel2.writeStrongBinder(localIBinder);
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
      gU localgU1 = b(mJ.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      if (localgU1 != null) {
        localIBinder = localgU1.asBinder();
      }
      paramParcel2.writeStrongBinder(localIBinder);
      bool = true;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     kS
 * JD-Core Version:    0.7.0.1
 */