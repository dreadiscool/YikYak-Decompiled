import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class ip
  extends Binder
  implements io
{
  public static io a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
      if ((localIInterface != null) && ((localIInterface instanceof io))) {
        localObject = (io)localIInterface;
      } else {
        localObject = new iq(paramIBinder);
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
      paramParcel2.writeString("com.google.android.gms.common.internal.service.ICommonService");
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.service.ICommonService");
      a(im.a(paramParcel1.readStrongBinder()));
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ip
 * JD-Core Version:    0.7.0.1
 */