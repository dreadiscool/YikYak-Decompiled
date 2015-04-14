import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class hT
  extends Binder
  implements hS
{
  public static hS a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
      if ((localIInterface != null) && ((localIInterface instanceof hS))) {
        localObject = (hS)localIInterface;
      } else {
        localObject = new hU(paramIBinder);
      }
    }
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
        paramParcel2.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
    gU localgU = a(gV.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt());
    paramParcel2.writeNoException();
    if (localgU != null) {}
    for (IBinder localIBinder = localgU.asBinder();; localIBinder = null)
    {
      paramParcel2.writeStrongBinder(localIBinder);
      bool = true;
      break;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     hT
 * JD-Core Version:    0.7.0.1
 */