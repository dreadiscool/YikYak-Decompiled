import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ha;

public abstract class hi
  extends Binder
  implements hh
{
  public static hh a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
      if ((localIInterface != null) && ((localIInterface instanceof hh))) {
        localObject = (hh)localIInterface;
      } else {
        localObject = new hj(paramIBinder);
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
      paramParcel2.writeString("com.google.android.gms.analytics.internal.IAnalyticsService");
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
      a(paramParcel1.readHashMap(getClass().getClassLoader()), paramParcel1.readLong(), paramParcel1.readString(), paramParcel1.createTypedArrayList(ha.CREATOR));
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
      a();
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
      String str = b();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str);
      bool = true;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     hi
 * JD-Core Version:    0.7.0.1
 */