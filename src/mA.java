import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;

public abstract class mA
  extends Binder
  implements mz
{
  public static mz a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
      if ((localIInterface != null) && ((localIInterface instanceof mz))) {
        localObject = (mz)localIInterface;
      } else {
        localObject = new mB(paramIBinder);
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
      paramParcel2.writeString("com.google.android.gms.maps.model.internal.ICircleDelegate");
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
      a();
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
      String str = b();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
      if (paramParcel1.readInt() != 0) {}
      for (LatLng localLatLng2 = LatLng.CREATOR.a(paramParcel1);; localLatLng2 = null)
      {
        a(localLatLng2);
        paramParcel2.writeNoException();
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
      LatLng localLatLng1 = c();
      paramParcel2.writeNoException();
      if (localLatLng1 != null)
      {
        paramParcel2.writeInt(j);
        localLatLng1.writeToParcel(paramParcel2, j);
      }
      else
      {
        paramParcel2.writeInt(0);
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
        a(paramParcel1.readDouble());
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
        double d = d();
        paramParcel2.writeNoException();
        paramParcel2.writeDouble(d);
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
        a(paramParcel1.readFloat());
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
        float f2 = e();
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f2);
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
        a(paramParcel1.readInt());
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
        int n = f();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(n);
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
        b(paramParcel1.readInt());
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
        int m = g();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(m);
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
        b(paramParcel1.readFloat());
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
        float f1 = h();
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f1);
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
        if (paramParcel1.readInt() != 0) {
          i = j;
        }
        a(i);
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
        boolean bool2 = i();
        paramParcel2.writeNoException();
        if (bool2) {
          i = j;
        }
        paramParcel2.writeInt(i);
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
        boolean bool1 = a(a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        if (bool1) {
          i = j;
        }
        paramParcel2.writeInt(i);
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
        int k = j();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(k);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     mA
 * JD-Core Version:    0.7.0.1
 */