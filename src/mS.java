import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.model.Tile;

public abstract class mS
  extends Binder
  implements mR
{
  public static mR a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
      if ((localIInterface != null) && ((localIInterface instanceof mR))) {
        localObject = (mR)localIInterface;
      } else {
        localObject = new mT(paramIBinder);
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
      paramParcel2.writeString("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
      Tile localTile = a(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      if (localTile != null)
      {
        paramParcel2.writeInt(i);
        localTile.writeToParcel(paramParcel2, i);
      }
      else
      {
        paramParcel2.writeInt(0);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     mS
 * JD-Core Version:    0.7.0.1
 */