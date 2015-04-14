import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class lF
  extends Binder
  implements lE
{
  public static lE a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
      if ((localIInterface != null) && ((localIInterface instanceof lE))) {
        localObject = (lE)localIInterface;
      } else {
        localObject = new lG(paramIBinder);
      }
    }
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool;
    switch (paramInt1)
    {
    default: 
      bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
    case 1: 
      for (;;)
      {
        return bool;
        paramParcel2.writeString("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
        bool = true;
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
        a(gV.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        bool = true;
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
    if (paramParcel1.readInt() != 0) {}
    for (Location localLocation = (Location)Location.CREATOR.createFromParcel(paramParcel1);; localLocation = null)
    {
      a(localLocation);
      paramParcel2.writeNoException();
      bool = true;
      break;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     lF
 * JD-Core Version:    0.7.0.1
 */