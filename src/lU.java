import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class lU
  extends Binder
  implements lT
{
  public static lT a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
      if ((localIInterface != null) && ((localIInterface instanceof lT))) {
        localObject = (lT)localIInterface;
      } else {
        localObject = new lV(paramIBinder);
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
    }
    for (;;)
    {
      return bool;
      paramParcel2.writeString("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
      if (paramParcel1.readInt() != 0) {}
      for (Bitmap localBitmap = (Bitmap)Bitmap.CREATOR.createFromParcel(paramParcel1);; localBitmap = null)
      {
        a(localBitmap);
        paramParcel2.writeNoException();
        bool = true;
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
      a(gV.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      bool = true;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     lU
 * JD-Core Version:    0.7.0.1
 */