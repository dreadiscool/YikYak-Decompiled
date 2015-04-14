import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class kF
  extends Binder
  implements kE
{
  public static kE a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
      if ((localIInterface != null) && ((localIInterface instanceof kE))) {
        localObject = (kE)localIInterface;
      } else {
        localObject = new kG(paramIBinder);
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
      paramParcel2.writeString("com.google.android.gms.maps.internal.IUiSettingsDelegate");
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
      if (paramParcel1.readInt() != 0) {
        i = j;
      }
      a(i);
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
      if (paramParcel1.readInt() != 0) {
        i = j;
      }
      b(i);
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
      if (paramParcel1.readInt() != 0) {
        i = j;
      }
      c(i);
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
      if (paramParcel1.readInt() != 0) {
        i = j;
      }
      d(i);
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
      if (paramParcel1.readInt() != 0) {
        i = j;
      }
      e(i);
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
      if (paramParcel1.readInt() != 0) {
        i = j;
      }
      f(i);
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
      if (paramParcel1.readInt() != 0) {
        i = j;
      }
      g(i);
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
      if (paramParcel1.readInt() != 0) {
        i = j;
      }
      h(i);
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
      boolean bool9 = a();
      paramParcel2.writeNoException();
      if (bool9) {
        i = j;
      }
      paramParcel2.writeInt(i);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
      boolean bool8 = b();
      paramParcel2.writeNoException();
      if (bool8) {
        i = j;
      }
      paramParcel2.writeInt(i);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
      boolean bool7 = c();
      paramParcel2.writeNoException();
      if (bool7) {
        i = j;
      }
      paramParcel2.writeInt(i);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
      boolean bool6 = d();
      paramParcel2.writeNoException();
      if (bool6) {
        i = j;
      }
      paramParcel2.writeInt(i);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
      boolean bool5 = e();
      paramParcel2.writeNoException();
      if (bool5) {
        i = j;
      }
      paramParcel2.writeInt(i);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
      boolean bool4 = f();
      paramParcel2.writeNoException();
      if (bool4) {
        i = j;
      }
      paramParcel2.writeInt(i);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
      boolean bool3 = g();
      paramParcel2.writeNoException();
      if (bool3) {
        i = j;
      }
      paramParcel2.writeInt(i);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
      if (paramParcel1.readInt() != 0) {
        i = j;
      }
      i(i);
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
      boolean bool2 = h();
      paramParcel2.writeNoException();
      if (bool2) {
        i = j;
      }
      paramParcel2.writeInt(i);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
      if (paramParcel1.readInt() != 0) {
        i = j;
      }
      j(i);
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
      boolean bool1 = i();
      paramParcel2.writeNoException();
      if (bool1) {
        i = j;
      }
      paramParcel2.writeInt(i);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     kF
 * JD-Core Version:    0.7.0.1
 */