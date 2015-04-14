import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

public abstract class mG
  extends Binder
  implements mF
{
  public static mF a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
      if ((localIInterface != null) && ((localIInterface instanceof mF))) {
        localObject = (mF)localIInterface;
      } else {
        localObject = new mH(paramIBinder);
      }
    }
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    int i = 0;
    int j = 1;
    switch (paramInt1)
    {
    default: 
      j = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    for (;;)
    {
      return j;
      paramParcel2.writeString("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
      int n = a();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(n);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
      int m = b();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(m);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
      List localList = c();
      paramParcel2.writeNoException();
      paramParcel2.writeBinderList(localList);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
      boolean bool2 = d();
      paramParcel2.writeNoException();
      if (bool2) {
        i = j;
      }
      paramParcel2.writeInt(i);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
      boolean bool1 = a(a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      if (bool1) {
        i = j;
      }
      paramParcel2.writeInt(i);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
      int k = e();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(k);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     mG
 * JD-Core Version:    0.7.0.1
 */