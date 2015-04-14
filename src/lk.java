import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;

public abstract class lk
  extends Binder
  implements lj
{
  public lk()
  {
    attachInterface(this, "com.google.android.gms.maps.internal.IOnMapClickListener");
  }
  
  public static lj a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMapClickListener");
      if ((localIInterface != null) && ((localIInterface instanceof lj))) {
        localObject = (lj)localIInterface;
      } else {
        localObject = new ll(paramIBinder);
      }
    }
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool;
    switch (paramInt1)
    {
    default: 
    case 1598968902: 
      for (bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);; bool = true)
      {
        return bool;
        paramParcel2.writeString("com.google.android.gms.maps.internal.IOnMapClickListener");
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IOnMapClickListener");
    if (paramParcel1.readInt() != 0) {}
    for (LatLng localLatLng = LatLng.CREATOR.a(paramParcel1);; localLatLng = null)
    {
      a(localLatLng);
      paramParcel2.writeNoException();
      bool = true;
      break;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     lk
 * JD-Core Version:    0.7.0.1
 */