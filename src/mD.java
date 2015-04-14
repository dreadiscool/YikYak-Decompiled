import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.internal.a;

public abstract class mD
  extends Binder
  implements mC
{
  public static mC a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
      if ((localIInterface != null) && ((localIInterface instanceof mC))) {
        localObject = (mC)localIInterface;
      } else {
        localObject = new mE(paramIBinder);
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
      paramParcel2.writeString("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
      a();
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
      String str = b();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
      if (paramParcel1.readInt() != 0) {
        localObject = LatLng.CREATOR.a(paramParcel1);
      }
      a((LatLng)localObject);
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
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
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        a(paramParcel1.readFloat());
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        a(paramParcel1.readFloat(), paramParcel1.readFloat());
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        float f5 = d();
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f5);
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        float f4 = e();
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f4);
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        if (paramParcel1.readInt() != 0) {
          localObject = LatLngBounds.CREATOR.a(paramParcel1);
        }
        a((LatLngBounds)localObject);
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        LatLngBounds localLatLngBounds = f();
        paramParcel2.writeNoException();
        if (localLatLngBounds != null)
        {
          paramParcel2.writeInt(j);
          localLatLngBounds.writeToParcel(paramParcel2, j);
        }
        else
        {
          paramParcel2.writeInt(0);
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
          b(paramParcel1.readFloat());
          paramParcel2.writeNoException();
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
          float f3 = g();
          paramParcel2.writeNoException();
          paramParcel2.writeFloat(f3);
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
          c(paramParcel1.readFloat());
          paramParcel2.writeNoException();
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
          float f2 = h();
          paramParcel2.writeNoException();
          paramParcel2.writeFloat(f2);
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
          if (paramParcel1.readInt() != 0) {}
          int n;
          for (int m = j;; n = 0)
          {
            a(m);
            paramParcel2.writeNoException();
            break;
          }
          paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
          boolean bool2 = i();
          paramParcel2.writeNoException();
          if (bool2) {
            i = j;
          }
          paramParcel2.writeInt(i);
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
          d(paramParcel1.readFloat());
          paramParcel2.writeNoException();
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
          float f1 = j();
          paramParcel2.writeNoException();
          paramParcel2.writeFloat(f1);
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
          boolean bool1 = a(a(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          if (bool1) {
            i = j;
          }
          paramParcel2.writeInt(i);
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
          int k = k();
          paramParcel2.writeNoException();
          paramParcel2.writeInt(k);
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
          a(gV.a(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
          if (paramParcel1.readInt() != 0) {
            localObject = a.CREATOR.a(paramParcel1);
          }
          a((a)localObject);
          paramParcel2.writeNoException();
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     mD
 * JD-Core Version:    0.7.0.1
 */