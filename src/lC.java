import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class lC
  extends Binder
  implements lB
{
  public static lB a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
      if ((localIInterface != null) && ((localIInterface instanceof lB))) {
        localObject = (lB)localIInterface;
      } else {
        localObject = new lD(paramIBinder);
      }
    }
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    int i = 1;
    switch (paramInt1)
    {
    default: 
      i = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      for (;;)
      {
        return i;
        paramParcel2.writeString("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
    boolean bool = a();
    paramParcel2.writeNoException();
    if (bool) {}
    int k;
    for (int j = i;; k = 0)
    {
      paramParcel2.writeInt(j);
      break;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     lC
 * JD-Core Version:    0.7.0.1
 */