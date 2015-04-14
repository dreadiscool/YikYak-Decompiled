import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class iG
  extends Binder
  implements iF
{
  public static iF a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof iF))) {
        localObject = (iF)localIInterface;
      } else {
        localObject = new iH(paramIBinder);
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
    case 1598968902: 
    case 1: 
    case 2: 
      for (;;)
      {
        return bool;
        paramParcel2.writeString("com.google.android.gms.location.internal.IGeofencerCallbacks");
        bool = true;
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
        a(paramParcel1.readInt(), paramParcel1.createStringArray());
        paramParcel2.writeNoException();
        bool = true;
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
        b(paramParcel1.readInt(), paramParcel1.createStringArray());
        paramParcel2.writeNoException();
        bool = true;
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
    int i = paramParcel1.readInt();
    if (paramParcel1.readInt() != 0) {}
    for (PendingIntent localPendingIntent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent = null)
    {
      a(i, localPendingIntent);
      paramParcel2.writeNoException();
      bool = true;
      break;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     iG
 * JD-Core Version:    0.7.0.1
 */