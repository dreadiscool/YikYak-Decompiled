import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class le
  extends Binder
  implements ld
{
  public static ld a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
      if ((localIInterface != null) && ((localIInterface instanceof ld))) {
        localObject = (ld)localIInterface;
      } else {
        localObject = new lf(paramIBinder);
      }
    }
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
      paramParcel2.writeString("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
      a(mJ.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     le
 * JD-Core Version:    0.7.0.1
 */