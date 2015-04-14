import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class mP
  extends Binder
  implements mO
{
  public static mO a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
      if ((localIInterface != null) && ((localIInterface instanceof mO))) {
        localObject = (mO)localIInterface;
      } else {
        localObject = new mQ(paramIBinder);
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
      paramParcel2.writeString("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
      a();
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
      b();
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
      String str = c();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
      a(paramParcel1.readFloat());
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
      float f = d();
      paramParcel2.writeNoException();
      paramParcel2.writeFloat(f);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
      if (paramParcel1.readInt() != 0) {
        i = j;
      }
      a(i);
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
      boolean bool3 = e();
      paramParcel2.writeNoException();
      if (bool3) {
        i = j;
      }
      paramParcel2.writeInt(i);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
      boolean bool2 = a(a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      if (bool2) {
        i = j;
      }
      paramParcel2.writeInt(i);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
      int k = f();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(k);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
      if (paramParcel1.readInt() != 0) {
        i = j;
      }
      b(i);
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
      boolean bool1 = g();
      paramParcel2.writeNoException();
      if (bool1) {
        i = j;
      }
      paramParcel2.writeInt(i);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     mP
 * JD-Core Version:    0.7.0.1
 */