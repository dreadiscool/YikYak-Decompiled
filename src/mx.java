import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class mx
  extends Binder
  implements mw
{
  public static mw a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
      if ((localIInterface != null) && ((localIInterface instanceof mw))) {
        localObject = (mw)localIInterface;
      } else {
        localObject = new my(paramIBinder);
      }
    }
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    IBinder localIBinder1 = null;
    boolean bool;
    switch (paramInt1)
    {
    default: 
      bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    for (;;)
    {
      return bool;
      paramParcel2.writeString("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
      gU localgU7 = a(paramParcel1.readInt());
      paramParcel2.writeNoException();
      if (localgU7 != null) {}
      for (IBinder localIBinder2 = localgU7.asBinder();; localIBinder2 = null)
      {
        paramParcel2.writeStrongBinder(localIBinder2);
        bool = true;
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
      gU localgU6 = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (localgU6 != null) {
        localIBinder1 = localgU6.asBinder();
      }
      paramParcel2.writeStrongBinder(localIBinder1);
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
      gU localgU5 = b(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (localgU5 != null) {
        localIBinder1 = localgU5.asBinder();
      }
      paramParcel2.writeStrongBinder(localIBinder1);
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
      gU localgU4 = a();
      paramParcel2.writeNoException();
      if (localgU4 != null) {
        localIBinder1 = localgU4.asBinder();
      }
      paramParcel2.writeStrongBinder(localIBinder1);
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
      gU localgU3 = a(paramParcel1.readFloat());
      paramParcel2.writeNoException();
      if (localgU3 != null) {
        localIBinder1 = localgU3.asBinder();
      }
      paramParcel2.writeStrongBinder(localIBinder1);
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
      if (paramParcel1.readInt() != 0) {}
      for (Bitmap localBitmap = (Bitmap)Bitmap.CREATOR.createFromParcel(paramParcel1);; localBitmap = null)
      {
        gU localgU2 = a(localBitmap);
        paramParcel2.writeNoException();
        if (localgU2 != null) {
          localIBinder1 = localgU2.asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder1);
        bool = true;
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
      gU localgU1 = c(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (localgU1 != null) {
        localIBinder1 = localgU1.asBinder();
      }
      paramParcel2.writeStrongBinder(localIBinder1);
      bool = true;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     mx
 * JD-Core Version:    0.7.0.1
 */