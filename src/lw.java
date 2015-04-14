import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class lw
  extends Binder
  implements lv
{
  public static lv a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
      if ((localIInterface != null) && ((localIInterface instanceof lv))) {
        localObject = (lv)localIInterface;
      } else {
        localObject = new lx(paramIBinder);
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
        paramParcel2.writeString("com.google.android.gms.maps.internal.IOnMarkerClickListener");
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
    boolean bool = a(mJ.a(paramParcel1.readStrongBinder()));
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
 * Qualified Name:     lw
 * JD-Core Version:    0.7.0.1
 */