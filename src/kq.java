import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class kq
  extends Binder
  implements kp
{
  public static kp a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
      if ((localIInterface != null) && ((localIInterface instanceof kp))) {
        localObject = (kp)localIInterface;
      } else {
        localObject = new kr(paramIBinder);
      }
    }
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject = null;
    boolean bool;
    switch (paramInt1)
    {
    default: 
      bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    for (;;)
    {
      return bool;
      paramParcel2.writeString("com.google.android.gms.maps.internal.IMapViewDelegate");
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
      kg localkg = a();
      paramParcel2.writeNoException();
      if (localkg != null) {
        localObject = localkg.asBinder();
      }
      paramParcel2.writeStrongBinder((IBinder)localObject);
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      a((Bundle)localObject);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
      b();
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
      c();
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
      d();
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
      e();
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      b((Bundle)localObject);
      paramParcel2.writeNoException();
      if (localObject != null)
      {
        paramParcel2.writeInt(1);
        ((Bundle)localObject).writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        bool = true;
        break;
        paramParcel2.writeInt(0);
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
      gU localgU = f();
      paramParcel2.writeNoException();
      if (localgU != null) {
        localObject = localgU.asBinder();
      }
      paramParcel2.writeStrongBinder((IBinder)localObject);
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
      a(lt.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      bool = true;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     kq
 * JD-Core Version:    0.7.0.1
 */