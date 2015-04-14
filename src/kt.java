import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.internal.y;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

public abstract class kt
  extends Binder
  implements ks
{
  public static ks a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
      if ((localIInterface != null) && ((localIInterface instanceof ks))) {
        localObject = (ks)localIInterface;
      } else {
        localObject = new ku(paramIBinder);
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
    case 1598968902: 
      for (bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);; bool = true)
      {
        return bool;
        paramParcel2.writeString("com.google.android.gms.maps.internal.IProjectionDelegate");
      }
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
      LatLng localLatLng3 = a(gV.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      if (localLatLng3 != null)
      {
        paramParcel2.writeInt(1);
        localLatLng3.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        bool = true;
        break;
        paramParcel2.writeInt(0);
      }
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
      if (paramParcel1.readInt() != 0) {}
      for (LatLng localLatLng2 = LatLng.CREATOR.a(paramParcel1);; localLatLng2 = null)
      {
        gU localgU = a(localLatLng2);
        paramParcel2.writeNoException();
        if (localgU != null) {
          localObject = localgU.asBinder();
        }
        paramParcel2.writeStrongBinder((IBinder)localObject);
        bool = true;
        break;
      }
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
      VisibleRegion localVisibleRegion = a();
      paramParcel2.writeNoException();
      if (localVisibleRegion != null)
      {
        paramParcel2.writeInt(1);
        localVisibleRegion.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        bool = true;
        break;
        paramParcel2.writeInt(0);
      }
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
      if (paramParcel1.readInt() != 0) {
        localObject = y.CREATOR.a(paramParcel1);
      }
      LatLng localLatLng1 = a((y)localObject);
      paramParcel2.writeNoException();
      if (localLatLng1 != null)
      {
        paramParcel2.writeInt(1);
        localLatLng1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        bool = true;
        break;
        paramParcel2.writeInt(0);
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
    if (paramParcel1.readInt() != 0) {
      localObject = LatLng.CREATOR.a(paramParcel1);
    }
    y localy = b((LatLng)localObject);
    paramParcel2.writeNoException();
    if (localy != null)
    {
      paramParcel2.writeInt(1);
      localy.writeToParcel(paramParcel2, 1);
    }
    for (;;)
    {
      bool = true;
      break;
      paramParcel2.writeInt(0);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     kt
 * JD-Core Version:    0.7.0.1
 */