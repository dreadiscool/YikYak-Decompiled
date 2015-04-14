import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class lt
  extends Binder
  implements ls
{
  public lt()
  {
    attachInterface(this, "com.google.android.gms.maps.internal.IOnMapReadyCallback");
  }
  
  public static ls a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMapReadyCallback");
      if ((localIInterface != null) && ((localIInterface instanceof ls))) {
        localObject = (ls)localIInterface;
      } else {
        localObject = new lu(paramIBinder);
      }
    }
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool = true;
    switch (paramInt1)
    {
    default: 
      bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    for (;;)
    {
      return bool;
      paramParcel2.writeString("com.google.android.gms.maps.internal.IOnMapReadyCallback");
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IOnMapReadyCallback");
      a(kh.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     lt
 * JD-Core Version:    0.7.0.1
 */