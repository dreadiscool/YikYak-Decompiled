import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class kC
  extends Binder
  implements kB
{
  public static kB a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
      if ((localIInterface != null) && ((localIInterface instanceof kB))) {
        localObject = (kB)localIInterface;
      } else {
        localObject = new kD(paramIBinder);
      }
    }
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject = null;
    boolean bool;
    switch (paramInt1)
    {
    default: 
      bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    for (;;)
    {
      return bool;
      paramParcel2.writeString("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
      kv localkv = a();
      paramParcel2.writeNoException();
      if (localkv != null) {
        localObject = localkv.asBinder();
      }
      paramParcel2.writeStrongBinder((IBinder)localObject);
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      a((Bundle)localObject);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
      b();
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
      c();
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
      d();
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
      e();
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      b((Bundle)localObject);
      paramParcel2.writeNoException();
      if (localObject != null)
      {
        paramParcel2.writeInt(1);
        ((Bundle)localObject).writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        bool = true;
        break;
        paramParcel2.writeInt(0);
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
      gU localgU = f();
      paramParcel2.writeNoException();
      if (localgU != null) {
        localObject = localgU.asBinder();
      }
      paramParcel2.writeStrongBinder((IBinder)localObject);
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
      a(lR.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      bool = true;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     kC
 * JD-Core Version:    0.7.0.1
 */