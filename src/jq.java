import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class jq
  extends Binder
  implements jp
{
  public static jp a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
      if ((localIInterface != null) && ((localIInterface instanceof jp))) {
        localObject = (jp)localIInterface;
      } else {
        localObject = new jr(paramIBinder);
      }
    }
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    int i = 0;
    int j = 1;
    switch (paramInt1)
    {
    default: 
      j = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    for (;;)
    {
      return j;
      paramParcel2.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
      String str3 = a();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str3);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
      if (paramParcel1.readInt() != 0) {}
      for (boolean bool1 = j;; bool1 = false)
      {
        boolean bool2 = a(bool1);
        paramParcel2.writeNoException();
        if (bool2) {
          i = j;
        }
        paramParcel2.writeInt(i);
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
      String str2 = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(str2);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
      String str1 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        i = j;
      }
      a(str1, i);
      paramParcel2.writeNoException();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     jq
 * JD-Core Version:    0.7.0.1
 */