import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.jj;

public abstract class hQ
  extends Binder
  implements hP
{
  public static hP a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      if ((localIInterface != null) && ((localIInterface instanceof hP))) {
        localObject = (hP)localIInterface;
      } else {
        localObject = new hR(paramIBinder);
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
      paramParcel2.writeString("com.google.android.gms.common.internal.IGmsServiceBroker");
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      hM localhM26 = hN.a(paramParcel1.readStrongBinder());
      int i20 = paramParcel1.readInt();
      String str30 = paramParcel1.readString();
      String str31 = paramParcel1.readString();
      String[] arrayOfString4 = paramParcel1.createStringArray();
      String str32 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (Bundle localBundle5 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localBundle5 = null)
      {
        a(localhM26, i20, str30, str31, arrayOfString4, str32, localBundle5);
        paramParcel2.writeNoException();
        bool = true;
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      hM localhM25 = hN.a(paramParcel1.readStrongBinder());
      int i19 = paramParcel1.readInt();
      String str29 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      a(localhM25, i19, str29, (Bundle)localObject);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      a(hN.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      a(hN.a(paramParcel1.readStrongBinder()), paramParcel1.readInt());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      hM localhM24 = hN.a(paramParcel1.readStrongBinder());
      int i18 = paramParcel1.readInt();
      String str28 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      b(localhM24, i18, str28, (Bundle)localObject);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      hM localhM23 = hN.a(paramParcel1.readStrongBinder());
      int i17 = paramParcel1.readInt();
      String str27 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      c(localhM23, i17, str27, (Bundle)localObject);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      hM localhM22 = hN.a(paramParcel1.readStrongBinder());
      int i16 = paramParcel1.readInt();
      String str26 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      d(localhM22, i16, str26, (Bundle)localObject);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      hM localhM21 = hN.a(paramParcel1.readStrongBinder());
      int i15 = paramParcel1.readInt();
      String str25 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      e(localhM21, i15, str25, (Bundle)localObject);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      hM localhM20 = hN.a(paramParcel1.readStrongBinder());
      int i14 = paramParcel1.readInt();
      String str21 = paramParcel1.readString();
      String str22 = paramParcel1.readString();
      String[] arrayOfString3 = paramParcel1.createStringArray();
      String str23 = paramParcel1.readString();
      IBinder localIBinder2 = paramParcel1.readStrongBinder();
      String str24 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (Bundle localBundle4 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localBundle4 = null)
      {
        a(localhM20, i14, str21, str22, arrayOfString3, str23, localIBinder2, str24, localBundle4);
        paramParcel2.writeNoException();
        bool = true;
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      a(hN.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createStringArray());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      hM localhM19 = hN.a(paramParcel1.readStrongBinder());
      int i13 = paramParcel1.readInt();
      String str20 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      f(localhM19, i13, str20, (Bundle)localObject);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      hM localhM18 = hN.a(paramParcel1.readStrongBinder());
      int i12 = paramParcel1.readInt();
      String str19 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      g(localhM18, i12, str19, (Bundle)localObject);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      hM localhM17 = hN.a(paramParcel1.readStrongBinder());
      int i11 = paramParcel1.readInt();
      String str18 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      h(localhM17, i11, str18, (Bundle)localObject);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      hM localhM16 = hN.a(paramParcel1.readStrongBinder());
      int i10 = paramParcel1.readInt();
      String str17 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      i(localhM16, i10, str17, (Bundle)localObject);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      hM localhM15 = hN.a(paramParcel1.readStrongBinder());
      int i9 = paramParcel1.readInt();
      String str16 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      j(localhM15, i9, str16, (Bundle)localObject);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      hM localhM14 = hN.a(paramParcel1.readStrongBinder());
      int i8 = paramParcel1.readInt();
      String str15 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      k(localhM14, i8, str15, (Bundle)localObject);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      hM localhM13 = hN.a(paramParcel1.readStrongBinder());
      int i7 = paramParcel1.readInt();
      String str14 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      l(localhM13, i7, str14, (Bundle)localObject);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      hM localhM12 = hN.a(paramParcel1.readStrongBinder());
      int i6 = paramParcel1.readInt();
      String str13 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      m(localhM12, i6, str13, (Bundle)localObject);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      hM localhM11 = hN.a(paramParcel1.readStrongBinder());
      int i5 = paramParcel1.readInt();
      String str12 = paramParcel1.readString();
      IBinder localIBinder1 = paramParcel1.readStrongBinder();
      if (paramParcel1.readInt() != 0) {}
      for (Bundle localBundle3 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localBundle3 = null)
      {
        a(localhM11, i5, str12, localIBinder1, localBundle3);
        paramParcel2.writeNoException();
        bool = true;
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      hM localhM10 = hN.a(paramParcel1.readStrongBinder());
      int i4 = paramParcel1.readInt();
      String str10 = paramParcel1.readString();
      String[] arrayOfString2 = paramParcel1.createStringArray();
      String str11 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (Bundle localBundle2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localBundle2 = null)
      {
        a(localhM10, i4, str10, arrayOfString2, str11, localBundle2);
        paramParcel2.writeNoException();
        bool = true;
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      b(hN.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      c(hN.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      hM localhM9 = hN.a(paramParcel1.readStrongBinder());
      int i3 = paramParcel1.readInt();
      String str9 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      n(localhM9, i3, str9, (Bundle)localObject);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      d(hN.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      hM localhM8 = hN.a(paramParcel1.readStrongBinder());
      int i2 = paramParcel1.readInt();
      String str8 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      o(localhM8, i2, str8, (Bundle)localObject);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      e(hN.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      hM localhM7 = hN.a(paramParcel1.readStrongBinder());
      int i1 = paramParcel1.readInt();
      String str7 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      p(localhM7, i1, str7, (Bundle)localObject);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      b(hN.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createStringArray());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      hM localhM6 = hN.a(paramParcel1.readStrongBinder());
      int n = paramParcel1.readInt();
      String str5 = paramParcel1.readString();
      String str6 = paramParcel1.readString();
      String[] arrayOfString1 = paramParcel1.createStringArray();
      if (paramParcel1.readInt() != 0) {}
      for (Bundle localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localBundle1 = null)
      {
        a(localhM6, n, str5, str6, arrayOfString1, localBundle1);
        paramParcel2.writeNoException();
        bool = true;
        break;
      }
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      f(hN.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      g(hN.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      a(hN.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createStringArray());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      a(hN.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      h(hN.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      i(hN.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      hM localhM5 = hN.a(paramParcel1.readStrongBinder());
      int m = paramParcel1.readInt();
      String str4 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      q(localhM5, m, str4, (Bundle)localObject);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      hM localhM4 = hN.a(paramParcel1.readStrongBinder());
      int k = paramParcel1.readInt();
      String str3 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      r(localhM4, k, str3, (Bundle)localObject);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      j(hN.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      hM localhM3 = hN.a(paramParcel1.readStrongBinder());
      int j = paramParcel1.readInt();
      String str2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      s(localhM3, j, str2, (Bundle)localObject);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      k(hN.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      hM localhM2 = hN.a(paramParcel1.readStrongBinder());
      int i = paramParcel1.readInt();
      String str1 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      t(localhM2, i, str1, (Bundle)localObject);
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      l(hN.a(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      hM localhM1 = hN.a(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0) {
        localObject = (jj)jj.CREATOR.createFromParcel(paramParcel1);
      }
      a(localhM1, (jj)localObject);
      paramParcel2.writeNoException();
      bool = true;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     hQ
 * JD-Core Version:    0.7.0.1
 */