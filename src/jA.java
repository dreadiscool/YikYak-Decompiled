import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class jA
  extends Binder
  implements jz
{
  public jA()
  {
    attachInterface(this, "com.google.android.gms.location.ILocationListener");
  }
  
  public static jz a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
      if ((localIInterface != null) && ((localIInterface instanceof jz))) {
        localObject = (jz)localIInterface;
      } else {
        localObject = new jB(paramIBinder);
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
        paramParcel2.writeString("com.google.android.gms.location.ILocationListener");
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.location.ILocationListener");
    if (paramParcel1.readInt() != 0) {}
    for (Location localLocation = (Location)Location.CREATOR.createFromParcel(paramParcel1);; localLocation = null)
    {
      a(localLocation);
      bool = true;
      break;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     jA
 * JD-Core Version:    0.7.0.1
 */