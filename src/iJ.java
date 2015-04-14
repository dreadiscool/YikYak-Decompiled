import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.nl;
import com.google.android.gms.internal.nn;
import com.google.android.gms.internal.nq;
import com.google.android.gms.internal.ns;
import com.google.android.gms.internal.nu;
import com.google.android.gms.internal.nw;
import com.google.android.gms.internal.ny;
import com.google.android.gms.internal.oc;
import com.google.android.gms.internal.oe;
import com.google.android.gms.internal.oh;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.e;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.ArrayList;

public abstract class iJ
  extends Binder
  implements iI
{
  public static iI a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if ((localIInterface != null) && ((localIInterface instanceof iI))) {
        localObject = (iI)localIInterface;
      } else {
        localObject = new iK(paramIBinder);
      }
    }
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool = false;
    int i = 1;
    Object localObject = null;
    switch (paramInt1)
    {
    default: 
      i = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    for (;;)
    {
      return i;
      paramParcel2.writeString("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      ArrayList localArrayList3 = paramParcel1.createTypedArrayList(nn.CREATOR);
      if (paramParcel1.readInt() != 0) {}
      for (PendingIntent localPendingIntent12 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent12 = null)
      {
        a(localArrayList3, localPendingIntent12, iG.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      GeofencingRequest localGeofencingRequest;
      if (paramParcel1.readInt() != 0)
      {
        localGeofencingRequest = (GeofencingRequest)GeofencingRequest.CREATOR.createFromParcel(paramParcel1);
        label442:
        if (paramParcel1.readInt() == 0) {
          break label491;
        }
      }
      label491:
      for (PendingIntent localPendingIntent11 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent11 = null)
      {
        a(localGeofencingRequest, localPendingIntent11, iG.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
        localGeofencingRequest = null;
        break label442;
      }
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0) {}
      for (PendingIntent localPendingIntent10 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent10 = null)
      {
        a(localPendingIntent10, iG.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      a(paramParcel1.createStringArray(), iG.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      a(iG.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      long l = paramParcel1.readLong();
      int m;
      if (paramParcel1.readInt() != 0)
      {
        m = i;
        label637:
        if (paramParcel1.readInt() == 0) {
          break label681;
        }
      }
      label681:
      for (PendingIntent localPendingIntent9 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent9 = null)
      {
        a(l, m, localPendingIntent9);
        paramParcel2.writeNoException();
        break;
        int n = 0;
        break label637;
      }
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0) {}
      for (PendingIntent localPendingIntent8 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent8 = null)
      {
        a(localPendingIntent8);
        paramParcel2.writeNoException();
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      Location localLocation4 = a();
      paramParcel2.writeNoException();
      if (localLocation4 != null)
      {
        paramParcel2.writeInt(i);
        localLocation4.writeToParcel(paramParcel2, i);
      }
      else
      {
        paramParcel2.writeInt(0);
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0) {
          localObject = LocationRequest.CREATOR.a(paramParcel1);
        }
        a((LocationRequest)localObject, jA.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0) {
          localObject = LocationRequest.CREATOR.a(paramParcel1);
        }
        a((LocationRequest)localObject, jA.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        LocationRequest localLocationRequest;
        if (paramParcel1.readInt() != 0)
        {
          localLocationRequest = LocationRequest.CREATOR.a(paramParcel1);
          label889:
          if (paramParcel1.readInt() == 0) {
            break label931;
          }
        }
        label931:
        for (PendingIntent localPendingIntent7 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent7 = null)
        {
          a(localLocationRequest, localPendingIntent7);
          paramParcel2.writeNoException();
          break;
          localLocationRequest = null;
          break label889;
        }
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0) {
          localObject = nl.CREATOR.a(paramParcel1);
        }
        a((nl)localObject, jA.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        nl localnl;
        if (paramParcel1.readInt() != 0)
        {
          localnl = nl.CREATOR.a(paramParcel1);
          label1001:
          if (paramParcel1.readInt() == 0) {
            break label1043;
          }
        }
        label1043:
        for (PendingIntent localPendingIntent6 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent6 = null)
        {
          a(localnl, localPendingIntent6);
          paramParcel2.writeNoException();
          break;
          localnl = null;
          break label1001;
        }
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        a(jA.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0) {}
        for (PendingIntent localPendingIntent5 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent5 = null)
        {
          b(localPendingIntent5);
          paramParcel2.writeNoException();
          break;
        }
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0) {
          bool = i;
        }
        a(bool);
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0) {}
        for (Location localLocation3 = (Location)Location.CREATOR.createFromParcel(paramParcel1);; localLocation3 = null)
        {
          a(localLocation3);
          paramParcel2.writeNoException();
          break;
        }
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        LatLngBounds localLatLngBounds4;
        label1217:
        int k;
        nu localnu4;
        if (paramParcel1.readInt() != 0)
        {
          localLatLngBounds4 = LatLngBounds.CREATOR.a(paramParcel1);
          k = paramParcel1.readInt();
          if (paramParcel1.readInt() == 0) {
            break label1287;
          }
          localnu4 = nu.CREATOR.a(paramParcel1);
          label1239:
          if (paramParcel1.readInt() == 0) {
            break label1293;
          }
        }
        label1287:
        label1293:
        for (oh localoh7 = oh.CREATOR.a(paramParcel1);; localoh7 = null)
        {
          a(localLatLngBounds4, k, localnu4, localoh7, jb.a(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          break;
          localLatLngBounds4 = null;
          break label1217;
          localnu4 = null;
          break label1239;
        }
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        LatLngBounds localLatLngBounds3;
        label1321:
        int j;
        String str4;
        if (paramParcel1.readInt() != 0)
        {
          localLatLngBounds3 = LatLngBounds.CREATOR.a(paramParcel1);
          j = paramParcel1.readInt();
          str4 = paramParcel1.readString();
          if (paramParcel1.readInt() == 0) {
            break label1399;
          }
        }
        label1399:
        for (nu localnu3 = nu.CREATOR.a(paramParcel1);; localnu3 = null)
        {
          if (paramParcel1.readInt() != 0) {
            localObject = oh.CREATOR.a(paramParcel1);
          }
          a(localLatLngBounds3, j, str4, localnu3, (oh)localObject, jb.a(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          break;
          localLatLngBounds3 = null;
          break label1321;
        }
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        String str3 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localObject = oh.CREATOR.a(paramParcel1);
        }
        a(str3, (oh)localObject, jb.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        LatLng localLatLng;
        if (paramParcel1.readInt() != 0)
        {
          localLatLng = LatLng.CREATOR.a(paramParcel1);
          label1477:
          if (paramParcel1.readInt() == 0) {
            break label1539;
          }
        }
        label1539:
        for (nu localnu2 = nu.CREATOR.a(paramParcel1);; localnu2 = null)
        {
          if (paramParcel1.readInt() != 0) {
            localObject = oh.CREATOR.a(paramParcel1);
          }
          a(localLatLng, localnu2, (oh)localObject, jb.a(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          break;
          localLatLng = null;
          break label1477;
        }
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0) {}
        for (nu localnu1 = nu.CREATOR.a(paramParcel1);; localnu1 = null)
        {
          if (paramParcel1.readInt() != 0) {
            localObject = oh.CREATOR.a(paramParcel1);
          }
          a(localnu1, (oh)localObject, jb.a(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          break;
        }
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        String str2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localObject = oh.CREATOR.a(paramParcel1);
        }
        b(str2, (oh)localObject, jb.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        ArrayList localArrayList2 = paramParcel1.createStringArrayList();
        if (paramParcel1.readInt() != 0) {
          localObject = oh.CREATOR.a(paramParcel1);
        }
        a(localArrayList2, (oh)localObject, jb.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        oe localoe;
        label1733:
        LatLngBounds localLatLngBounds2;
        label1749:
        ArrayList localArrayList1;
        if (paramParcel1.readInt() != 0)
        {
          localoe = oe.CREATOR.a(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label1803;
          }
          localLatLngBounds2 = LatLngBounds.CREATOR.a(paramParcel1);
          localArrayList1 = paramParcel1.createStringArrayList();
          if (paramParcel1.readInt() == 0) {
            break label1809;
          }
        }
        label1803:
        label1809:
        for (oh localoh6 = oh.CREATOR.a(paramParcel1);; localoh6 = null)
        {
          a(localoe, localLatLngBounds2, localArrayList1, localoh6, jb.a(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          break;
          localoe = null;
          break label1733;
          localLatLngBounds2 = null;
          break label1749;
        }
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        ny localny;
        label1837:
        oh localoh5;
        if (paramParcel1.readInt() != 0)
        {
          localny = ny.CREATOR.a(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label1897;
          }
          localoh5 = oh.CREATOR.a(paramParcel1);
          label1853:
          if (paramParcel1.readInt() == 0) {
            break label1903;
          }
        }
        label1897:
        label1903:
        for (PendingIntent localPendingIntent4 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent4 = null)
        {
          a(localny, localoh5, localPendingIntent4);
          paramParcel2.writeNoException();
          break;
          localny = null;
          break label1837;
          localoh5 = null;
          break label1853;
        }
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        oh localoh4;
        if (paramParcel1.readInt() != 0)
        {
          localoh4 = oh.CREATOR.a(paramParcel1);
          label1931:
          if (paramParcel1.readInt() == 0) {
            break label1973;
          }
        }
        label1973:
        for (PendingIntent localPendingIntent3 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent3 = null)
        {
          a(localoh4, localPendingIntent3);
          paramParcel2.writeNoException();
          break;
          localoh4 = null;
          break label1931;
        }
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        ns localns;
        label2001:
        oh localoh3;
        if (paramParcel1.readInt() != 0)
        {
          localns = ns.CREATOR.a(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label2061;
          }
          localoh3 = oh.CREATOR.a(paramParcel1);
          label2017:
          if (paramParcel1.readInt() == 0) {
            break label2067;
          }
        }
        label2061:
        label2067:
        for (PendingIntent localPendingIntent2 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent2 = null)
        {
          a(localns, localoh3, localPendingIntent2);
          paramParcel2.writeNoException();
          break;
          localns = null;
          break label2001;
          localoh3 = null;
          break label2017;
        }
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        oh localoh2;
        if (paramParcel1.readInt() != 0)
        {
          localoh2 = oh.CREATOR.a(paramParcel1);
          label2095:
          if (paramParcel1.readInt() == 0) {
            break label2137;
          }
        }
        label2137:
        for (PendingIntent localPendingIntent1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent1 = null)
        {
          b(localoh2, localPendingIntent1);
          paramParcel2.writeNoException();
          break;
          localoh2 = null;
          break label2095;
        }
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        String str1 = paramParcel1.readString();
        LatLngBounds localLatLngBounds1;
        label2171:
        nq localnq;
        if (paramParcel1.readInt() != 0)
        {
          localLatLngBounds1 = LatLngBounds.CREATOR.a(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label2235;
          }
          localnq = nq.CREATOR.a(paramParcel1);
          label2187:
          if (paramParcel1.readInt() == 0) {
            break label2241;
          }
        }
        label2235:
        label2241:
        for (oh localoh1 = oh.CREATOR.a(paramParcel1);; localoh1 = null)
        {
          a(str1, localLatLngBounds1, localnq, localoh1, jb.a(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          break;
          localLatLngBounds1 = null;
          break label2171;
          localnq = null;
          break label2187;
        }
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0) {}
        for (oc localoc = (oc)oc.CREATOR.createFromParcel(paramParcel1);; localoc = null)
        {
          if (paramParcel1.readInt() != 0) {
            localObject = oh.CREATOR.a(paramParcel1);
          }
          a(localoc, (oh)localObject, jb.a(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          break;
        }
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        Location localLocation2 = a(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (localLocation2 != null)
        {
          paramParcel2.writeInt(i);
          localLocation2.writeToParcel(paramParcel2, i);
        }
        else
        {
          paramParcel2.writeInt(0);
          continue;
          paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          if (paramParcel1.readInt() != 0) {}
          for (nw localnw = nw.CREATOR.a(paramParcel1);; localnw = null)
          {
            if (paramParcel1.readInt() != 0) {
              localObject = oh.CREATOR.a(paramParcel1);
            }
            a(localnw, (oh)localObject);
            break;
          }
          paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          if (paramParcel1.readInt() != 0) {}
          for (Location localLocation1 = (Location)Location.CREATOR.createFromParcel(paramParcel1);; localLocation1 = null)
          {
            a(localLocation1, paramParcel1.readInt());
            paramParcel2.writeNoException();
            break;
          }
          paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          e locale = b(paramParcel1.readString());
          paramParcel2.writeNoException();
          if (locale != null)
          {
            paramParcel2.writeInt(i);
            locale.writeToParcel(paramParcel2, i);
          }
          else
          {
            paramParcel2.writeInt(0);
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            IBinder localIBinder2 = b();
            paramParcel2.writeNoException();
            paramParcel2.writeStrongBinder(localIBinder2);
            continue;
            paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            IBinder localIBinder1 = c();
            paramParcel2.writeNoException();
            paramParcel2.writeStrongBinder(localIBinder1);
          }
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     iJ
 * JD-Core Version:    0.7.0.1
 */