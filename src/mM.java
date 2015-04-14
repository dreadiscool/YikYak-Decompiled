import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

public abstract class mM
  extends Binder
  implements mL
{
  public static mL a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
      if ((localIInterface != null) && ((localIInterface instanceof mL))) {
        localObject = (mL)localIInterface;
      } else {
        localObject = new mN(paramIBinder);
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
      paramParcel2.writeString("com.google.android.gms.maps.model.internal.IPolygonDelegate");
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
      a();
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
      String str = b();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
      a(paramParcel1.createTypedArrayList(LatLng.CREATOR));
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
      List localList2 = c();
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(localList2);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
      b(paramParcel1.readArrayList(getClass().getClassLoader()));
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
      List localList1 = d();
      paramParcel2.writeNoException();
      paramParcel2.writeList(localList1);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
      a(paramParcel1.readFloat());
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
      float f2 = e();
      paramParcel2.writeNoException();
      paramParcel2.writeFloat(f2);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
      a(paramParcel1.readInt());
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
      int n = f();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(n);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
      b(paramParcel1.readInt());
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
      int m = g();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(m);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
      b(paramParcel1.readFloat());
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
      float f1 = h();
      paramParcel2.writeNoException();
      paramParcel2.writeFloat(f1);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
      if (paramParcel1.readInt() != 0) {
        i = j;
      }
      a(i);
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
      boolean bool3 = i();
      paramParcel2.writeNoException();
      if (bool3) {
        i = j;
      }
      paramParcel2.writeInt(i);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
      if (paramParcel1.readInt() != 0) {
        i = j;
      }
      b(i);
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
      boolean bool2 = j();
      paramParcel2.writeNoException();
      if (bool2) {
        i = j;
      }
      paramParcel2.writeInt(i);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
      boolean bool1 = a(a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      if (bool1) {
        i = j;
      }
      paramParcel2.writeInt(i);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
      int k = k();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(k);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     mM
 * JD-Core Version:    0.7.0.1
 */