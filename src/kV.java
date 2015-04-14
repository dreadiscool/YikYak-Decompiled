import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class kV
  extends Binder
  implements kU
{
  public static kU a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IInfoWindowRenderer");
      if ((localIInterface != null) && ((localIInterface instanceof kU))) {
        localObject = (kU)localIInterface;
      } else {
        localObject = new kW(paramIBinder);
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
    }
    for (;;)
    {
      return i;
      paramParcel2.writeString("com.google.android.gms.maps.internal.IInfoWindowRenderer");
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowRenderer");
      Bitmap localBitmap = a(mJ.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      if (localBitmap != null)
      {
        paramParcel2.writeInt(i);
        localBitmap.writeToParcel(paramParcel2, i);
      }
      else
      {
        paramParcel2.writeInt(0);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     kV
 * JD-Core Version:    0.7.0.1
 */