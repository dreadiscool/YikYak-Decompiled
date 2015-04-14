import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class lz
  extends Binder
  implements ly
{
  public static ly a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
      if ((localIInterface != null) && ((localIInterface instanceof ly))) {
        localObject = (ly)localIInterface;
      } else {
        localObject = new lA(paramIBinder);
      }
    }
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool = true;
    switch (paramInt1)
    {
    default: 
      bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    for (;;)
    {
      return bool;
      paramParcel2.writeString("com.google.android.gms.maps.internal.IOnMarkerDragListener");
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
      a(mJ.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
      b(mJ.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
      c(mJ.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     lz
 * JD-Core Version:    0.7.0.1
 */