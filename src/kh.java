import android.location.Location;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.c;
import com.google.android.gms.maps.model.internal.e;
import com.google.android.gms.maps.model.internal.p;

public abstract class kh
  extends Binder
  implements kg
{
  public static kg a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      if ((localIInterface != null) && ((localIInterface instanceof kg))) {
        localObject = (kg)localIInterface;
      } else {
        localObject = new ki(paramIBinder);
      }
    }
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    int i = 0;
    Object localObject = null;
    int j = 1;
    switch (paramInt1)
    {
    default: 
      j = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 32: 
    case 33: 
    case 35: 
    case 36: 
    case 37: 
    case 38: 
    case 39: 
    case 40: 
    case 41: 
    case 42: 
    case 44: 
    case 45: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
    case 58: 
    case 59: 
    case 60: 
    case 61: 
    case 64: 
    case 65: 
    case 66: 
    case 67: 
    case 68: 
    case 69: 
      for (;;)
      {
        return j;
        paramParcel2.writeString("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        CameraPosition localCameraPosition = a();
        paramParcel2.writeNoException();
        if (localCameraPosition != null)
        {
          paramParcel2.writeInt(j);
          localCameraPosition.writeToParcel(paramParcel2, j);
        }
        else
        {
          paramParcel2.writeInt(0);
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          float f2 = b();
          paramParcel2.writeNoException();
          paramParcel2.writeFloat(f2);
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          float f1 = c();
          paramParcel2.writeNoException();
          paramParcel2.writeFloat(f1);
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          a(gV.a(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          b(gV.a(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          a(gV.a(paramParcel1.readStrongBinder()), kM.a(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          a(gV.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), kM.a(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          d();
          paramParcel2.writeNoException();
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramParcel1.readInt() != 0) {}
          for (PolylineOptions localPolylineOptions = PolylineOptions.CREATOR.a(paramParcel1);; localPolylineOptions = null)
          {
            mq localmq = a(localPolylineOptions);
            paramParcel2.writeNoException();
            if (localmq != null) {
              localObject = localmq.asBinder();
            }
            paramParcel2.writeStrongBinder((IBinder)localObject);
            break;
          }
          paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramParcel1.readInt() != 0) {}
          for (PolygonOptions localPolygonOptions = PolygonOptions.CREATOR.a(paramParcel1);; localPolygonOptions = null)
          {
            mL localmL = a(localPolygonOptions);
            paramParcel2.writeNoException();
            if (localmL != null) {
              localObject = localmL.asBinder();
            }
            paramParcel2.writeStrongBinder((IBinder)localObject);
            break;
          }
          paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramParcel1.readInt() != 0) {}
          for (MarkerOptions localMarkerOptions2 = MarkerOptions.CREATOR.a(paramParcel1);; localMarkerOptions2 = null)
          {
            mI localmI2 = a(localMarkerOptions2);
            paramParcel2.writeNoException();
            if (localmI2 != null) {
              localObject = localmI2.asBinder();
            }
            paramParcel2.writeStrongBinder((IBinder)localObject);
            break;
          }
          paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramParcel1.readInt() != 0) {}
          for (GroundOverlayOptions localGroundOverlayOptions2 = GroundOverlayOptions.CREATOR.a(paramParcel1);; localGroundOverlayOptions2 = null)
          {
            mC localmC2 = a(localGroundOverlayOptions2);
            paramParcel2.writeNoException();
            if (localmC2 != null) {
              localObject = localmC2.asBinder();
            }
            paramParcel2.writeStrongBinder((IBinder)localObject);
            break;
          }
          paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramParcel1.readInt() != 0) {}
          for (TileOverlayOptions localTileOverlayOptions = TileOverlayOptions.CREATOR.a(paramParcel1);; localTileOverlayOptions = null)
          {
            mO localmO = a(localTileOverlayOptions);
            paramParcel2.writeNoException();
            if (localmO != null) {
              localObject = localmO.asBinder();
            }
            paramParcel2.writeStrongBinder((IBinder)localObject);
            break;
          }
          paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          e();
          paramParcel2.writeNoException();
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          int i2 = f();
          paramParcel2.writeNoException();
          paramParcel2.writeInt(i2);
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          a(paramParcel1.readInt());
          paramParcel2.writeNoException();
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          boolean bool6 = g();
          paramParcel2.writeNoException();
          if (bool6) {}
          int i1;
          for (int n = j;; i1 = 0)
          {
            paramParcel2.writeInt(n);
            break;
          }
          paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramParcel1.readInt() != 0) {
            i = j;
          }
          a(i);
          paramParcel2.writeNoException();
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          boolean bool5 = h();
          paramParcel2.writeNoException();
          if (bool5) {
            i = j;
          }
          paramParcel2.writeInt(i);
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramParcel1.readInt() != 0) {}
          int m;
          for (int k = j;; m = 0)
          {
            boolean bool4 = b(k);
            paramParcel2.writeNoException();
            if (bool4) {
              i = j;
            }
            paramParcel2.writeInt(i);
            break;
          }
          paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          boolean bool3 = i();
          paramParcel2.writeNoException();
          if (bool3) {
            i = j;
          }
          paramParcel2.writeInt(i);
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramParcel1.readInt() != 0) {
            i = j;
          }
          c(i);
          paramParcel2.writeNoException();
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          Location localLocation = j();
          paramParcel2.writeNoException();
          if (localLocation != null)
          {
            paramParcel2.writeInt(j);
            localLocation.writeToParcel(paramParcel2, j);
          }
          else
          {
            paramParcel2.writeInt(0);
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            a(kk.a(paramParcel1.readStrongBinder()));
            paramParcel2.writeNoException();
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            kE localkE = k();
            paramParcel2.writeNoException();
            if (localkE != null) {
              localObject = localkE.asBinder();
            }
            paramParcel2.writeStrongBinder((IBinder)localObject);
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            ks localks = l();
            paramParcel2.writeNoException();
            if (localks != null) {
              localObject = localks.asBinder();
            }
            paramParcel2.writeStrongBinder((IBinder)localObject);
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            a(kY.a(paramParcel1.readStrongBinder()));
            paramParcel2.writeNoException();
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            a(lk.a(paramParcel1.readStrongBinder()));
            paramParcel2.writeNoException();
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            a(lq.a(paramParcel1.readStrongBinder()));
            paramParcel2.writeNoException();
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            a(lw.a(paramParcel1.readStrongBinder()));
            paramParcel2.writeNoException();
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            a(lz.a(paramParcel1.readStrongBinder()));
            paramParcel2.writeNoException();
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            a(le.a(paramParcel1.readStrongBinder()));
            paramParcel2.writeNoException();
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            a(kS.a(paramParcel1.readStrongBinder()));
            paramParcel2.writeNoException();
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            if (paramParcel1.readInt() != 0) {}
            for (CircleOptions localCircleOptions = CircleOptions.CREATOR.a(paramParcel1);; localCircleOptions = null)
            {
              mz localmz = a(localCircleOptions);
              paramParcel2.writeNoException();
              if (localmz != null) {
                localObject = localmz.asBinder();
              }
              paramParcel2.writeStrongBinder((IBinder)localObject);
              break;
            }
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            a(lF.a(paramParcel1.readStrongBinder()));
            paramParcel2.writeNoException();
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            a(lC.a(paramParcel1.readStrongBinder()));
            paramParcel2.writeNoException();
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            a(lU.a(paramParcel1.readStrongBinder()), gV.a(paramParcel1.readStrongBinder()));
            paramParcel2.writeNoException();
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            a(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
            paramParcel2.writeNoException();
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            boolean bool2 = m();
            paramParcel2.writeNoException();
            if (bool2) {
              i = j;
            }
            paramParcel2.writeInt(i);
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            if (paramParcel1.readInt() != 0) {
              i = j;
            }
            d(i);
            paramParcel2.writeNoException();
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            a(ln.a(paramParcel1.readStrongBinder()));
            paramParcel2.writeNoException();
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            mF localmF = n();
            paramParcel2.writeNoException();
            if (localmF != null) {
              localObject = localmF.asBinder();
            }
            paramParcel2.writeStrongBinder((IBinder)localObject);
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            a(lb.a(paramParcel1.readStrongBinder()));
            paramParcel2.writeNoException();
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            a(lt.a(paramParcel1.readStrongBinder()));
            paramParcel2.writeNoException();
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            if (paramParcel1.readInt() != 0) {}
            for (Bundle localBundle2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localBundle2 = null)
            {
              a(localBundle2);
              paramParcel2.writeNoException();
              break;
            }
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            o();
            paramParcel2.writeNoException();
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            p();
            paramParcel2.writeNoException();
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            q();
            paramParcel2.writeNoException();
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            r();
            paramParcel2.writeNoException();
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            boolean bool1 = s();
            paramParcel2.writeNoException();
            if (bool1) {
              i = j;
            }
            paramParcel2.writeInt(i);
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            if (paramParcel1.readInt() != 0) {}
            for (Bundle localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localBundle1 = null)
            {
              b(localBundle1);
              paramParcel2.writeNoException();
              if (localBundle1 == null) {
                break label2228;
              }
              paramParcel2.writeInt(j);
              localBundle1.writeToParcel(paramParcel2, j);
              break;
            }
            label2228:
            paramParcel2.writeInt(0);
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            a(paramParcel1.readString());
            paramParcel2.writeNoException();
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            if (paramParcel1.readInt() != 0) {
              localObject = c.CREATOR.a(paramParcel1);
            }
            a((c)localObject);
            paramParcel2.writeNoException();
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            if (paramParcel1.readInt() != 0) {
              localObject = c.CREATOR.a(paramParcel1);
            }
            b((c)localObject);
            paramParcel2.writeNoException();
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            if (paramParcel1.readInt() != 0) {
              localObject = c.CREATOR.a(paramParcel1);
            }
            a((c)localObject, kM.a(paramParcel1.readStrongBinder()));
            paramParcel2.writeNoException();
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            if (paramParcel1.readInt() != 0) {
              localObject = c.CREATOR.a(paramParcel1);
            }
            a((c)localObject, paramParcel1.readInt(), kM.a(paramParcel1.readStrongBinder()));
            paramParcel2.writeNoException();
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            MarkerOptions localMarkerOptions1;
            if (paramParcel1.readInt() != 0)
            {
              localMarkerOptions1 = MarkerOptions.CREATOR.a(paramParcel1);
              label2437:
              if (paramParcel1.readInt() == 0) {
                break label2496;
              }
            }
            label2496:
            for (p localp = p.CREATOR.a(paramParcel1);; localp = null)
            {
              mI localmI1 = a(localMarkerOptions1, localp);
              paramParcel2.writeNoException();
              if (localmI1 != null) {
                localObject = localmI1.asBinder();
              }
              paramParcel2.writeStrongBinder((IBinder)localObject);
              break;
              localMarkerOptions1 = null;
              break label2437;
            }
            paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            a(kV.a(paramParcel1.readStrongBinder()));
            paramParcel2.writeNoException();
          }
        }
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
    GroundOverlayOptions localGroundOverlayOptions1;
    if (paramParcel1.readInt() != 0)
    {
      localGroundOverlayOptions1 = GroundOverlayOptions.CREATOR.a(paramParcel1);
      label2548:
      if (paramParcel1.readInt() == 0) {
        break label2607;
      }
    }
    label2607:
    for (e locale = e.CREATOR.a(paramParcel1);; locale = null)
    {
      mC localmC1 = a(localGroundOverlayOptions1, locale);
      paramParcel2.writeNoException();
      if (localmC1 != null) {
        localObject = localmC1.asBinder();
      }
      paramParcel2.writeStrongBinder((IBinder)localObject);
      break;
      localGroundOverlayOptions1 = null;
      break label2548;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     kh
 * JD-Core Version:    0.7.0.1
 */