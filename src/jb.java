import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;

public abstract class jb
  extends Binder
  implements ja
{
  public static ja a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof ja))) {
        localObject = (ja)localIInterface;
      } else {
        localObject = new jc(paramIBinder);
      }
    }
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    DataHolder localDataHolder = null;
    boolean bool;
    switch (paramInt1)
    {
    default: 
      bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    for (;;)
    {
      return bool;
      paramParcel2.writeString("com.google.android.gms.location.places.internal.IPlacesCallbacks");
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
      if (paramParcel1.readInt() != 0) {
        localDataHolder = DataHolder.CREATOR.B(paramParcel1);
      }
      a(localDataHolder);
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
      if (paramParcel1.readInt() != 0) {
        localDataHolder = DataHolder.CREATOR.B(paramParcel1);
      }
      b(localDataHolder);
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
      if (paramParcel1.readInt() != 0) {
        localDataHolder = DataHolder.CREATOR.B(paramParcel1);
      }
      c(localDataHolder);
      bool = true;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     jb
 * JD-Core Version:    0.7.0.1
 */