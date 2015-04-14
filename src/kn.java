import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.GoogleMapOptions;

public abstract class kn
  extends Binder
  implements km
{
  public static km a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
      if ((localIInterface != null) && ((localIInterface instanceof km))) {
        localObject = (km)localIInterface;
      } else {
        localObject = new ko(paramIBinder);
      }
    }
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    IBinder localIBinder1 = null;
    int i = 1;
    switch (paramInt1)
    {
    default: 
      i = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    for (;;)
    {
      return i;
      paramParcel2.writeString("com.google.android.gms.maps.internal.IMapFragmentDelegate");
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
      kg localkg = a();
      paramParcel2.writeNoException();
      if (localkg != null) {}
      for (IBinder localIBinder2 = localkg.asBinder();; localIBinder2 = null)
      {
        paramParcel2.writeStrongBinder(localIBinder2);
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
      gU localgU4 = gV.a(paramParcel1.readStrongBinder());
      GoogleMapOptions localGoogleMapOptions;
      if (paramParcel1.readInt() != 0)
      {
        localGoogleMapOptions = GoogleMapOptions.CREATOR.a(paramParcel1);
        label219:
        if (paramParcel1.readInt() == 0) {
          break label263;
        }
      }
      label263:
      for (Bundle localBundle4 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localBundle4 = null)
      {
        a(localgU4, localGoogleMapOptions, localBundle4);
        paramParcel2.writeNoException();
        break;
        localGoogleMapOptions = null;
        break label219;
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
      if (paramParcel1.readInt() != 0) {}
      for (Bundle localBundle3 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localBundle3 = null)
      {
        a(localBundle3);
        paramParcel2.writeNoException();
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
      gU localgU1 = gV.a(paramParcel1.readStrongBinder());
      gU localgU2 = gV.a(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0) {}
      for (Bundle localBundle2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localBundle2 = null)
      {
        gU localgU3 = a(localgU1, localgU2, localBundle2);
        paramParcel2.writeNoException();
        if (localgU3 != null) {
          localIBinder1 = localgU3.asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder1);
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
      b();
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
      c();
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
      d();
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
      e();
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
      f();
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
      if (paramParcel1.readInt() != 0) {}
      for (Bundle localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localBundle1 = null)
      {
        b(localBundle1);
        paramParcel2.writeNoException();
        if (localBundle1 == null) {
          break label555;
        }
        paramParcel2.writeInt(i);
        localBundle1.writeToParcel(paramParcel2, i);
        break;
      }
      label555:
      paramParcel2.writeInt(0);
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
      boolean bool = g();
      paramParcel2.writeNoException();
      if (bool) {}
      int k;
      for (int j = i;; k = 0)
      {
        paramParcel2.writeInt(j);
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
      a(lt.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     kn
 * JD-Core Version:    0.7.0.1
 */