import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

public abstract class kz
  extends Binder
  implements ky
{
  public static ky a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
      if ((localIInterface != null) && ((localIInterface instanceof ky))) {
        localObject = (ky)localIInterface;
      } else {
        localObject = new kA(paramIBinder);
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
      paramParcel2.writeString("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
      kv localkv = a();
      paramParcel2.writeNoException();
      if (localkv != null) {}
      for (IBinder localIBinder2 = localkv.asBinder();; localIBinder2 = null)
      {
        paramParcel2.writeStrongBinder(localIBinder2);
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
      gU localgU4 = gV.a(paramParcel1.readStrongBinder());
      StreetViewPanoramaOptions localStreetViewPanoramaOptions;
      if (paramParcel1.readInt() != 0)
      {
        localStreetViewPanoramaOptions = StreetViewPanoramaOptions.CREATOR.a(paramParcel1);
        label219:
        if (paramParcel1.readInt() == 0) {
          break label263;
        }
      }
      label263:
      for (Bundle localBundle4 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localBundle4 = null)
      {
        a(localgU4, localStreetViewPanoramaOptions, localBundle4);
        paramParcel2.writeNoException();
        break;
        localStreetViewPanoramaOptions = null;
        break label219;
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
      if (paramParcel1.readInt() != 0) {}
      for (Bundle localBundle3 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localBundle3 = null)
      {
        a(localBundle3);
        paramParcel2.writeNoException();
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
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
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
      b();
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
      c();
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
      d();
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
      e();
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
      f();
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
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
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
      boolean bool = g();
      paramParcel2.writeNoException();
      if (bool) {}
      int k;
      for (int j = i;; k = 0)
      {
        paramParcel2.writeInt(j);
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
      a(lR.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     kz
 * JD-Core Version:    0.7.0.1
 */