import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.internal.a;

public abstract class mJ
  extends Binder
  implements mI
{
  public static mI a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      if ((localIInterface != null) && ((localIInterface instanceof mI))) {
        localObject = (mI)localIInterface;
      } else {
        localObject = new mK(paramIBinder);
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
    }
    for (;;)
    {
      return j;
      paramParcel2.writeString("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      a();
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      String str3 = b();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str3);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      if (paramParcel1.readInt() != 0) {
        localObject = LatLng.CREATOR.a(paramParcel1);
      }
      a((LatLng)localObject);
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      LatLng localLatLng = c();
      paramParcel2.writeNoException();
      if (localLatLng != null)
      {
        paramParcel2.writeInt(j);
        localLatLng.writeToParcel(paramParcel2, j);
      }
      else
      {
        paramParcel2.writeInt(0);
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        a(paramParcel1.readString());
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        String str2 = d();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str2);
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        b(paramParcel1.readString());
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        String str1 = e();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str1);
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        if (paramParcel1.readInt() != 0) {}
        int n;
        for (int m = j;; n = 0)
        {
          a(m);
          paramParcel2.writeNoException();
          break;
        }
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        boolean bool5 = f();
        paramParcel2.writeNoException();
        if (bool5) {
          i = j;
        }
        paramParcel2.writeInt(i);
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        g();
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        h();
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        boolean bool4 = i();
        paramParcel2.writeNoException();
        if (bool4) {
          i = j;
        }
        paramParcel2.writeInt(i);
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        if (paramParcel1.readInt() != 0) {
          i = j;
        }
        b(i);
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        boolean bool3 = j();
        paramParcel2.writeNoException();
        if (bool3) {
          i = j;
        }
        paramParcel2.writeInt(i);
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        boolean bool2 = a(a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        if (bool2) {
          i = j;
        }
        paramParcel2.writeInt(i);
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        int k = k();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(k);
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        a(gV.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        a(paramParcel1.readFloat(), paramParcel1.readFloat());
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        if (paramParcel1.readInt() != 0) {
          i = j;
        }
        c(i);
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        boolean bool1 = l();
        paramParcel2.writeNoException();
        if (bool1) {
          i = j;
        }
        paramParcel2.writeInt(i);
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        a(paramParcel1.readFloat());
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        float f2 = m();
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f2);
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        b(paramParcel1.readFloat(), paramParcel1.readFloat());
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        b(paramParcel1.readFloat());
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        float f1 = n();
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f1);
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        if (paramParcel1.readInt() != 0) {
          localObject = a.CREATOR.a(paramParcel1);
        }
        a((a)localObject);
        paramParcel2.writeNoException();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     mJ
 * JD-Core Version:    0.7.0.1
 */