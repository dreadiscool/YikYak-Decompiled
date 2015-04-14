import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
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
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

class iK
  implements iI
{
  private IBinder a;
  
  iK(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public android.location.Location a()
  {
    // Byte code:
    //   0: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_1
    //   4: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_2
    //   8: aload_1
    //   9: ldc 24
    //   11: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 15	iK:a	Landroid/os/IBinder;
    //   18: bipush 7
    //   20: aload_1
    //   21: aload_2
    //   22: iconst_0
    //   23: invokeinterface 34 5 0
    //   28: pop
    //   29: aload_2
    //   30: invokevirtual 37	android/os/Parcel:readException	()V
    //   33: aload_2
    //   34: invokevirtual 41	android/os/Parcel:readInt	()I
    //   37: ifeq +28 -> 65
    //   40: getstatic 47	android/location/Location:CREATOR	Landroid/os/Parcelable$Creator;
    //   43: aload_2
    //   44: invokeinterface 53 2 0
    //   49: checkcast 43	android/location/Location
    //   52: astore 5
    //   54: aload_2
    //   55: invokevirtual 56	android/os/Parcel:recycle	()V
    //   58: aload_1
    //   59: invokevirtual 56	android/os/Parcel:recycle	()V
    //   62: aload 5
    //   64: areturn
    //   65: aconst_null
    //   66: astore 5
    //   68: goto -14 -> 54
    //   71: astore_3
    //   72: aload_2
    //   73: invokevirtual 56	android/os/Parcel:recycle	()V
    //   76: aload_1
    //   77: invokevirtual 56	android/os/Parcel:recycle	()V
    //   80: aload_3
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	iK
    //   3	74	1	localParcel1	Parcel
    //   7	66	2	localParcel2	Parcel
    //   71	10	3	localObject	Object
    //   52	15	5	localLocation	android.location.Location
    // Exception table:
    //   from	to	target	type
    //   8	54	71	finally
  }
  
  /* Error */
  public android.location.Location a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 24
    //   11: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_2
    //   15: aload_1
    //   16: invokevirtual 60	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   19: aload_0
    //   20: getfield 15	iK:a	Landroid/os/IBinder;
    //   23: bipush 21
    //   25: aload_2
    //   26: aload_3
    //   27: iconst_0
    //   28: invokeinterface 34 5 0
    //   33: pop
    //   34: aload_3
    //   35: invokevirtual 37	android/os/Parcel:readException	()V
    //   38: aload_3
    //   39: invokevirtual 41	android/os/Parcel:readInt	()I
    //   42: ifeq +28 -> 70
    //   45: getstatic 47	android/location/Location:CREATOR	Landroid/os/Parcelable$Creator;
    //   48: aload_3
    //   49: invokeinterface 53 2 0
    //   54: checkcast 43	android/location/Location
    //   57: astore 6
    //   59: aload_3
    //   60: invokevirtual 56	android/os/Parcel:recycle	()V
    //   63: aload_2
    //   64: invokevirtual 56	android/os/Parcel:recycle	()V
    //   67: aload 6
    //   69: areturn
    //   70: aconst_null
    //   71: astore 6
    //   73: goto -14 -> 59
    //   76: astore 4
    //   78: aload_3
    //   79: invokevirtual 56	android/os/Parcel:recycle	()V
    //   82: aload_2
    //   83: invokevirtual 56	android/os/Parcel:recycle	()V
    //   86: aload 4
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	iK
    //   0	89	1	paramString	String
    //   3	80	2	localParcel1	Parcel
    //   7	72	3	localParcel2	Parcel
    //   76	11	4	localObject	Object
    //   57	15	6	localLocation	android.location.Location
    // Exception table:
    //   from	to	target	type
    //   8	59	76	finally
  }
  
  /* Error */
  public void a(long paramLong, boolean paramBoolean, PendingIntent paramPendingIntent)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 6
    //   8: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 7
    //   13: aload 6
    //   15: ldc 24
    //   17: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload 6
    //   22: lload_1
    //   23: invokevirtual 65	android/os/Parcel:writeLong	(J)V
    //   26: iload_3
    //   27: ifeq +61 -> 88
    //   30: aload 6
    //   32: iload 5
    //   34: invokevirtual 69	android/os/Parcel:writeInt	(I)V
    //   37: aload 4
    //   39: ifnull +55 -> 94
    //   42: aload 6
    //   44: iconst_1
    //   45: invokevirtual 69	android/os/Parcel:writeInt	(I)V
    //   48: aload 4
    //   50: aload 6
    //   52: iconst_0
    //   53: invokevirtual 75	android/app/PendingIntent:writeToParcel	(Landroid/os/Parcel;I)V
    //   56: aload_0
    //   57: getfield 15	iK:a	Landroid/os/IBinder;
    //   60: iconst_5
    //   61: aload 6
    //   63: aload 7
    //   65: iconst_0
    //   66: invokeinterface 34 5 0
    //   71: pop
    //   72: aload 7
    //   74: invokevirtual 37	android/os/Parcel:readException	()V
    //   77: aload 7
    //   79: invokevirtual 56	android/os/Parcel:recycle	()V
    //   82: aload 6
    //   84: invokevirtual 56	android/os/Parcel:recycle	()V
    //   87: return
    //   88: iconst_0
    //   89: istore 5
    //   91: goto -61 -> 30
    //   94: aload 6
    //   96: iconst_0
    //   97: invokevirtual 69	android/os/Parcel:writeInt	(I)V
    //   100: goto -44 -> 56
    //   103: astore 8
    //   105: aload 7
    //   107: invokevirtual 56	android/os/Parcel:recycle	()V
    //   110: aload 6
    //   112: invokevirtual 56	android/os/Parcel:recycle	()V
    //   115: aload 8
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	iK
    //   0	118	1	paramLong	long
    //   0	118	3	paramBoolean	boolean
    //   0	118	4	paramPendingIntent	PendingIntent
    //   1	89	5	i	int
    //   6	105	6	localParcel1	Parcel
    //   11	95	7	localParcel2	Parcel
    //   103	13	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	77	103	finally
    //   94	100	103	finally
  }
  
  /* Error */
  public void a(PendingIntent paramPendingIntent)
  {
    // Byte code:
    //   0: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 24
    //   11: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +42 -> 57
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 69	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 75	android/app/PendingIntent:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	iK:a	Landroid/os/IBinder;
    //   33: bipush 6
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 34 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 37	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 56	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 56	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aload_2
    //   58: iconst_0
    //   59: invokevirtual 69	android/os/Parcel:writeInt	(I)V
    //   62: goto -33 -> 29
    //   65: astore 4
    //   67: aload_3
    //   68: invokevirtual 56	android/os/Parcel:recycle	()V
    //   71: aload_2
    //   72: invokevirtual 56	android/os/Parcel:recycle	()V
    //   75: aload 4
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	iK
    //   0	78	1	paramPendingIntent	PendingIntent
    //   3	69	2	localParcel1	Parcel
    //   7	61	3	localParcel2	Parcel
    //   65	11	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	48	65	finally
    //   57	62	65	finally
  }
  
  public void a(PendingIntent paramPendingIntent, iF paramiF, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramPendingIntent != null)
        {
          localParcel1.writeInt(1);
          paramPendingIntent.writeToParcel(localParcel1, 0);
          if (paramiF != null)
          {
            localIBinder = paramiF.asBinder();
            localParcel1.writeStrongBinder(localIBinder);
            localParcel1.writeString(paramString);
            this.a.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        IBinder localIBinder = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  /* Error */
  public void a(android.location.Location paramLocation)
  {
    // Byte code:
    //   0: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 24
    //   11: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +42 -> 57
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 69	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 88	android/location/Location:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	iK:a	Landroid/os/IBinder;
    //   33: bipush 13
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 34 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 37	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 56	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 56	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aload_2
    //   58: iconst_0
    //   59: invokevirtual 69	android/os/Parcel:writeInt	(I)V
    //   62: goto -33 -> 29
    //   65: astore 4
    //   67: aload_3
    //   68: invokevirtual 56	android/os/Parcel:recycle	()V
    //   71: aload_2
    //   72: invokevirtual 56	android/os/Parcel:recycle	()V
    //   75: aload 4
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	iK
    //   0	78	1	paramLocation	android.location.Location
    //   3	69	2	localParcel1	Parcel
    //   7	61	3	localParcel2	Parcel
    //   65	11	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	48	65	finally
    //   57	62	65	finally
  }
  
  /* Error */
  public void a(android.location.Location paramLocation, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 24
    //   12: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +50 -> 66
    //   19: aload_3
    //   20: iconst_1
    //   21: invokevirtual 69	android/os/Parcel:writeInt	(I)V
    //   24: aload_1
    //   25: aload_3
    //   26: iconst_0
    //   27: invokevirtual 88	android/location/Location:writeToParcel	(Landroid/os/Parcel;I)V
    //   30: aload_3
    //   31: iload_2
    //   32: invokevirtual 69	android/os/Parcel:writeInt	(I)V
    //   35: aload_0
    //   36: getfield 15	iK:a	Landroid/os/IBinder;
    //   39: bipush 26
    //   41: aload_3
    //   42: aload 4
    //   44: iconst_0
    //   45: invokeinterface 34 5 0
    //   50: pop
    //   51: aload 4
    //   53: invokevirtual 37	android/os/Parcel:readException	()V
    //   56: aload 4
    //   58: invokevirtual 56	android/os/Parcel:recycle	()V
    //   61: aload_3
    //   62: invokevirtual 56	android/os/Parcel:recycle	()V
    //   65: return
    //   66: aload_3
    //   67: iconst_0
    //   68: invokevirtual 69	android/os/Parcel:writeInt	(I)V
    //   71: goto -41 -> 30
    //   74: astore 5
    //   76: aload 4
    //   78: invokevirtual 56	android/os/Parcel:recycle	()V
    //   81: aload_3
    //   82: invokevirtual 56	android/os/Parcel:recycle	()V
    //   85: aload 5
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	iK
    //   0	88	1	paramLocation	android.location.Location
    //   0	88	2	paramInt	int
    //   3	79	3	localParcel1	Parcel
    //   7	70	4	localParcel2	Parcel
    //   74	12	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	56	74	finally
    //   66	71	74	finally
  }
  
  public void a(nl paramnl, PendingIntent paramPendingIntent)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramnl != null)
        {
          localParcel1.writeInt(1);
          paramnl.writeToParcel(localParcel1, 0);
          if (paramPendingIntent != null)
          {
            localParcel1.writeInt(1);
            paramPendingIntent.writeToParcel(localParcel1, 0);
            this.a.transact(53, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void a(nl paramnl, jz paramjz)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramnl != null)
        {
          localParcel1.writeInt(1);
          paramnl.writeToParcel(localParcel1, 0);
          if (paramjz != null)
          {
            localIBinder = paramjz.asBinder();
            localParcel1.writeStrongBinder(localIBinder);
            this.a.transact(52, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        IBinder localIBinder = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void a(ns paramns, oh paramoh, PendingIntent paramPendingIntent)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramns != null)
        {
          localParcel1.writeInt(1);
          paramns.writeToParcel(localParcel1, 0);
          if (paramoh != null)
          {
            localParcel1.writeInt(1);
            paramoh.writeToParcel(localParcel1, 0);
            if (paramPendingIntent == null) {
              break label134;
            }
            localParcel1.writeInt(1);
            paramPendingIntent.writeToParcel(localParcel1, 0);
            this.a.transact(48, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      continue;
      label134:
      localParcel1.writeInt(0);
    }
  }
  
  public void a(nu paramnu, oh paramoh, ja paramja)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramnu != null)
        {
          localParcel1.writeInt(1);
          paramnu.writeToParcel(localParcel1, 0);
          if (paramoh != null)
          {
            localParcel1.writeInt(1);
            paramoh.writeToParcel(localParcel1, 0);
            if (paramja == null) {
              break label136;
            }
            localIBinder = paramja.asBinder();
            localParcel1.writeStrongBinder(localIBinder);
            this.a.transact(17, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      continue;
      label136:
      IBinder localIBinder = null;
    }
  }
  
  public void a(nw paramnw, oh paramoh)
  {
    Parcel localParcel = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramnw != null)
        {
          localParcel.writeInt(1);
          paramnw.writeToParcel(localParcel, 0);
          if (paramoh != null)
          {
            localParcel.writeInt(1);
            paramoh.writeToParcel(localParcel, 0);
            this.a.transact(25, localParcel, null, 1);
          }
        }
        else
        {
          localParcel.writeInt(0);
          continue;
        }
        localParcel.writeInt(0);
      }
      finally
      {
        localParcel.recycle();
      }
    }
  }
  
  public void a(ny paramny, oh paramoh, PendingIntent paramPendingIntent)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramny != null)
        {
          localParcel1.writeInt(1);
          paramny.writeToParcel(localParcel1, 0);
          if (paramoh != null)
          {
            localParcel1.writeInt(1);
            paramoh.writeToParcel(localParcel1, 0);
            if (paramPendingIntent == null) {
              break label134;
            }
            localParcel1.writeInt(1);
            paramPendingIntent.writeToParcel(localParcel1, 0);
            this.a.transact(18, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      continue;
      label134:
      localParcel1.writeInt(0);
    }
  }
  
  public void a(oc paramoc, oh paramoh, ja paramja)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramoc != null)
        {
          localParcel1.writeInt(1);
          paramoc.writeToParcel(localParcel1, 0);
          if (paramoh != null)
          {
            localParcel1.writeInt(1);
            paramoh.writeToParcel(localParcel1, 0);
            if (paramja == null) {
              break label136;
            }
            localIBinder = paramja.asBinder();
            localParcel1.writeStrongBinder(localIBinder);
            this.a.transact(46, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      continue;
      label136:
      IBinder localIBinder = null;
    }
  }
  
  public void a(oe paramoe, LatLngBounds paramLatLngBounds, List<String> paramList, oh paramoh, ja paramja)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramoe != null)
        {
          localParcel1.writeInt(1);
          paramoe.writeToParcel(localParcel1, 0);
          if (paramLatLngBounds != null)
          {
            localParcel1.writeInt(1);
            paramLatLngBounds.writeToParcel(localParcel1, 0);
            localParcel1.writeStringList(paramList);
            if (paramoh == null) {
              break label163;
            }
            localParcel1.writeInt(1);
            paramoh.writeToParcel(localParcel1, 0);
            if (paramja == null) {
              break label172;
            }
            localIBinder = paramja.asBinder();
            localParcel1.writeStrongBinder(localIBinder);
            this.a.transact(50, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      continue;
      label163:
      localParcel1.writeInt(0);
      continue;
      label172:
      IBinder localIBinder = null;
    }
  }
  
  public void a(oh paramoh, PendingIntent paramPendingIntent)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramoh != null)
        {
          localParcel1.writeInt(1);
          paramoh.writeToParcel(localParcel1, 0);
          if (paramPendingIntent != null)
          {
            localParcel1.writeInt(1);
            paramPendingIntent.writeToParcel(localParcel1, 0);
            this.a.transact(19, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void a(GeofencingRequest paramGeofencingRequest, PendingIntent paramPendingIntent, iF paramiF)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramGeofencingRequest != null)
        {
          localParcel1.writeInt(1);
          paramGeofencingRequest.writeToParcel(localParcel1, 0);
          if (paramPendingIntent != null)
          {
            localParcel1.writeInt(1);
            paramPendingIntent.writeToParcel(localParcel1, 0);
            if (paramiF == null) {
              break label136;
            }
            localIBinder = paramiF.asBinder();
            localParcel1.writeStrongBinder(localIBinder);
            this.a.transact(57, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      continue;
      label136:
      IBinder localIBinder = null;
    }
  }
  
  public void a(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramLocationRequest != null)
        {
          localParcel1.writeInt(1);
          paramLocationRequest.writeToParcel(localParcel1, 0);
          if (paramPendingIntent != null)
          {
            localParcel1.writeInt(1);
            paramPendingIntent.writeToParcel(localParcel1, 0);
            this.a.transact(9, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void a(LocationRequest paramLocationRequest, jz paramjz)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramLocationRequest != null)
        {
          localParcel1.writeInt(1);
          paramLocationRequest.writeToParcel(localParcel1, 0);
          if (paramjz != null)
          {
            localIBinder = paramjz.asBinder();
            localParcel1.writeStrongBinder(localIBinder);
            this.a.transact(8, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        IBinder localIBinder = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void a(LocationRequest paramLocationRequest, jz paramjz, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramLocationRequest != null)
        {
          localParcel1.writeInt(1);
          paramLocationRequest.writeToParcel(localParcel1, 0);
          if (paramjz != null)
          {
            localIBinder = paramjz.asBinder();
            localParcel1.writeStrongBinder(localIBinder);
            localParcel1.writeString(paramString);
            this.a.transact(20, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        IBinder localIBinder = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void a(LatLng paramLatLng, nu paramnu, oh paramoh, ja paramja)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramLatLng != null)
        {
          localParcel1.writeInt(1);
          paramLatLng.writeToParcel(localParcel1, 0);
          if (paramnu != null)
          {
            localParcel1.writeInt(1);
            paramnu.writeToParcel(localParcel1, 0);
            if (paramoh == null) {
              break label155;
            }
            localParcel1.writeInt(1);
            paramoh.writeToParcel(localParcel1, 0);
            if (paramja == null) {
              break label164;
            }
            localIBinder = paramja.asBinder();
            localParcel1.writeStrongBinder(localIBinder);
            this.a.transact(16, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      continue;
      label155:
      localParcel1.writeInt(0);
      continue;
      label164:
      IBinder localIBinder = null;
    }
  }
  
  public void a(LatLngBounds paramLatLngBounds, int paramInt, nu paramnu, oh paramoh, ja paramja)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramLatLngBounds != null)
        {
          localParcel1.writeInt(1);
          paramLatLngBounds.writeToParcel(localParcel1, 0);
          localParcel1.writeInt(paramInt);
          if (paramnu != null)
          {
            localParcel1.writeInt(1);
            paramnu.writeToParcel(localParcel1, 0);
            if (paramoh == null) {
              break label163;
            }
            localParcel1.writeInt(1);
            paramoh.writeToParcel(localParcel1, 0);
            if (paramja == null) {
              break label172;
            }
            localIBinder = paramja.asBinder();
            localParcel1.writeStrongBinder(localIBinder);
            this.a.transact(14, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      continue;
      label163:
      localParcel1.writeInt(0);
      continue;
      label172:
      IBinder localIBinder = null;
    }
  }
  
  public void a(LatLngBounds paramLatLngBounds, int paramInt, String paramString, nu paramnu, oh paramoh, ja paramja)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramLatLngBounds != null)
        {
          localParcel1.writeInt(1);
          paramLatLngBounds.writeToParcel(localParcel1, 0);
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString);
          if (paramnu != null)
          {
            localParcel1.writeInt(1);
            paramnu.writeToParcel(localParcel1, 0);
            if (paramoh == null) {
              break label171;
            }
            localParcel1.writeInt(1);
            paramoh.writeToParcel(localParcel1, 0);
            if (paramja == null) {
              break label180;
            }
            localIBinder = paramja.asBinder();
            localParcel1.writeStrongBinder(localIBinder);
            this.a.transact(47, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      continue;
      label171:
      localParcel1.writeInt(0);
      continue;
      label180:
      IBinder localIBinder = null;
    }
  }
  
  /* Error */
  public void a(iF paramiF, String paramString)
  {
    // Byte code:
    //   0: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 24
    //   12: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +52 -> 68
    //   19: aload_1
    //   20: invokeinterface 83 1 0
    //   25: astore 6
    //   27: aload_3
    //   28: aload 6
    //   30: invokevirtual 86	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   33: aload_3
    //   34: aload_2
    //   35: invokevirtual 60	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   38: aload_0
    //   39: getfield 15	iK:a	Landroid/os/IBinder;
    //   42: iconst_4
    //   43: aload_3
    //   44: aload 4
    //   46: iconst_0
    //   47: invokeinterface 34 5 0
    //   52: pop
    //   53: aload 4
    //   55: invokevirtual 37	android/os/Parcel:readException	()V
    //   58: aload 4
    //   60: invokevirtual 56	android/os/Parcel:recycle	()V
    //   63: aload_3
    //   64: invokevirtual 56	android/os/Parcel:recycle	()V
    //   67: return
    //   68: aconst_null
    //   69: astore 6
    //   71: goto -44 -> 27
    //   74: astore 5
    //   76: aload 4
    //   78: invokevirtual 56	android/os/Parcel:recycle	()V
    //   81: aload_3
    //   82: invokevirtual 56	android/os/Parcel:recycle	()V
    //   85: aload 5
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	iK
    //   0	88	1	paramiF	iF
    //   0	88	2	paramString	String
    //   3	79	3	localParcel1	Parcel
    //   7	70	4	localParcel2	Parcel
    //   74	12	5	localObject	Object
    //   25	45	6	localIBinder	IBinder
    // Exception table:
    //   from	to	target	type
    //   9	58	74	finally
  }
  
  public void a(String paramString, oh paramoh, ja paramja)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localParcel1.writeString(paramString);
        if (paramoh != null)
        {
          localParcel1.writeInt(1);
          paramoh.writeToParcel(localParcel1, 0);
          if (paramja != null)
          {
            localIBinder = paramja.asBinder();
            localParcel1.writeStrongBinder(localIBinder);
            this.a.transact(15, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        IBinder localIBinder = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void a(String paramString, LatLngBounds paramLatLngBounds, nq paramnq, oh paramoh, ja paramja)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localParcel1.writeString(paramString);
        if (paramLatLngBounds != null)
        {
          localParcel1.writeInt(1);
          paramLatLngBounds.writeToParcel(localParcel1, 0);
          if (paramnq != null)
          {
            localParcel1.writeInt(1);
            paramnq.writeToParcel(localParcel1, 0);
            if (paramoh == null) {
              break label163;
            }
            localParcel1.writeInt(1);
            paramoh.writeToParcel(localParcel1, 0);
            if (paramja == null) {
              break label172;
            }
            localIBinder = paramja.asBinder();
            localParcel1.writeStrongBinder(localIBinder);
            this.a.transact(55, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      continue;
      label163:
      localParcel1.writeInt(0);
      continue;
      label172:
      IBinder localIBinder = null;
    }
  }
  
  public void a(List<nn> paramList, PendingIntent paramPendingIntent, iF paramiF, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localParcel1.writeTypedList(paramList);
        if (paramPendingIntent != null)
        {
          localParcel1.writeInt(1);
          paramPendingIntent.writeToParcel(localParcel1, 0);
          if (paramiF != null)
          {
            localIBinder = paramiF.asBinder();
            localParcel1.writeStrongBinder(localIBinder);
            localParcel1.writeString(paramString);
            this.a.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        IBinder localIBinder = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void a(List<String> paramList, oh paramoh, ja paramja)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localParcel1.writeStringList(paramList);
        if (paramoh != null)
        {
          localParcel1.writeInt(1);
          paramoh.writeToParcel(localParcel1, 0);
          if (paramja != null)
          {
            localIBinder = paramja.asBinder();
            localParcel1.writeStrongBinder(localIBinder);
            this.a.transact(58, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        IBinder localIBinder = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  /* Error */
  public void a(jz paramjz)
  {
    // Byte code:
    //   0: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 24
    //   11: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +45 -> 60
    //   18: aload_1
    //   19: invokeinterface 97 1 0
    //   24: astore 5
    //   26: aload_2
    //   27: aload 5
    //   29: invokevirtual 86	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   32: aload_0
    //   33: getfield 15	iK:a	Landroid/os/IBinder;
    //   36: bipush 10
    //   38: aload_2
    //   39: aload_3
    //   40: iconst_0
    //   41: invokeinterface 34 5 0
    //   46: pop
    //   47: aload_3
    //   48: invokevirtual 37	android/os/Parcel:readException	()V
    //   51: aload_3
    //   52: invokevirtual 56	android/os/Parcel:recycle	()V
    //   55: aload_2
    //   56: invokevirtual 56	android/os/Parcel:recycle	()V
    //   59: return
    //   60: aconst_null
    //   61: astore 5
    //   63: goto -37 -> 26
    //   66: astore 4
    //   68: aload_3
    //   69: invokevirtual 56	android/os/Parcel:recycle	()V
    //   72: aload_2
    //   73: invokevirtual 56	android/os/Parcel:recycle	()V
    //   76: aload 4
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	iK
    //   0	79	1	paramjz	jz
    //   3	70	2	localParcel1	Parcel
    //   7	62	3	localParcel2	Parcel
    //   66	11	4	localObject	Object
    //   24	38	5	localIBinder	IBinder
    // Exception table:
    //   from	to	target	type
    //   8	51	66	finally
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 0;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramBoolean) {
        i = 1;
      }
      localParcel1.writeInt(i);
      this.a.transact(12, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public void a(String[] paramArrayOfString, iF paramiF, String paramString)
  {
    // Byte code:
    //   0: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 4
    //   5: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 5
    //   10: aload 4
    //   12: ldc 24
    //   14: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload 4
    //   19: aload_1
    //   20: invokevirtual 169	android/os/Parcel:writeStringArray	([Ljava/lang/String;)V
    //   23: aload_2
    //   24: ifnull +56 -> 80
    //   27: aload_2
    //   28: invokeinterface 83 1 0
    //   33: astore 7
    //   35: aload 4
    //   37: aload 7
    //   39: invokevirtual 86	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   42: aload 4
    //   44: aload_3
    //   45: invokevirtual 60	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   48: aload_0
    //   49: getfield 15	iK:a	Landroid/os/IBinder;
    //   52: iconst_3
    //   53: aload 4
    //   55: aload 5
    //   57: iconst_0
    //   58: invokeinterface 34 5 0
    //   63: pop
    //   64: aload 5
    //   66: invokevirtual 37	android/os/Parcel:readException	()V
    //   69: aload 5
    //   71: invokevirtual 56	android/os/Parcel:recycle	()V
    //   74: aload 4
    //   76: invokevirtual 56	android/os/Parcel:recycle	()V
    //   79: return
    //   80: aconst_null
    //   81: astore 7
    //   83: goto -48 -> 35
    //   86: astore 6
    //   88: aload 5
    //   90: invokevirtual 56	android/os/Parcel:recycle	()V
    //   93: aload 4
    //   95: invokevirtual 56	android/os/Parcel:recycle	()V
    //   98: aload 6
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	iK
    //   0	101	1	paramArrayOfString	String[]
    //   0	101	2	paramiF	iF
    //   0	101	3	paramString	String
    //   3	91	4	localParcel1	Parcel
    //   8	81	5	localParcel2	Parcel
    //   86	13	6	localObject	Object
    //   33	49	7	localIBinder	IBinder
    // Exception table:
    //   from	to	target	type
    //   10	69	86	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public IBinder b()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      this.a.transact(51, localParcel1, localParcel2, 0);
      localParcel2.readException();
      IBinder localIBinder = localParcel2.readStrongBinder();
      return localIBinder;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public com.google.android.gms.location.e b(String paramString)
  {
    // Byte code:
    //   0: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 24
    //   11: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_2
    //   15: aload_1
    //   16: invokevirtual 60	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   19: aload_0
    //   20: getfield 15	iK:a	Landroid/os/IBinder;
    //   23: bipush 34
    //   25: aload_2
    //   26: aload_3
    //   27: iconst_0
    //   28: invokeinterface 34 5 0
    //   33: pop
    //   34: aload_3
    //   35: invokevirtual 37	android/os/Parcel:readException	()V
    //   38: aload_3
    //   39: invokevirtual 41	android/os/Parcel:readInt	()I
    //   42: ifeq +27 -> 69
    //   45: getstatic 179	com/google/android/gms/location/e:CREATOR	LjD;
    //   48: aload_3
    //   49: invokevirtual 184	jD:a	(Landroid/os/Parcel;)Lcom/google/android/gms/location/e;
    //   52: astore 7
    //   54: aload 7
    //   56: astore 6
    //   58: aload_3
    //   59: invokevirtual 56	android/os/Parcel:recycle	()V
    //   62: aload_2
    //   63: invokevirtual 56	android/os/Parcel:recycle	()V
    //   66: aload 6
    //   68: areturn
    //   69: aconst_null
    //   70: astore 6
    //   72: goto -14 -> 58
    //   75: astore 4
    //   77: aload_3
    //   78: invokevirtual 56	android/os/Parcel:recycle	()V
    //   81: aload_2
    //   82: invokevirtual 56	android/os/Parcel:recycle	()V
    //   85: aload 4
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	iK
    //   0	88	1	paramString	String
    //   3	79	2	localParcel1	Parcel
    //   7	71	3	localParcel2	Parcel
    //   75	11	4	localObject	Object
    //   56	15	6	locale1	com.google.android.gms.location.e
    //   52	3	7	locale2	com.google.android.gms.location.e
    // Exception table:
    //   from	to	target	type
    //   8	54	75	finally
  }
  
  /* Error */
  public void b(PendingIntent paramPendingIntent)
  {
    // Byte code:
    //   0: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 24
    //   11: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +42 -> 57
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 69	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 75	android/app/PendingIntent:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	iK:a	Landroid/os/IBinder;
    //   33: bipush 11
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 34 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 37	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 56	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 56	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aload_2
    //   58: iconst_0
    //   59: invokevirtual 69	android/os/Parcel:writeInt	(I)V
    //   62: goto -33 -> 29
    //   65: astore 4
    //   67: aload_3
    //   68: invokevirtual 56	android/os/Parcel:recycle	()V
    //   71: aload_2
    //   72: invokevirtual 56	android/os/Parcel:recycle	()V
    //   75: aload 4
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	iK
    //   0	78	1	paramPendingIntent	PendingIntent
    //   3	69	2	localParcel1	Parcel
    //   7	61	3	localParcel2	Parcel
    //   65	11	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	48	65	finally
    //   57	62	65	finally
  }
  
  public void b(oh paramoh, PendingIntent paramPendingIntent)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramoh != null)
        {
          localParcel1.writeInt(1);
          paramoh.writeToParcel(localParcel1, 0);
          if (paramPendingIntent != null)
          {
            localParcel1.writeInt(1);
            paramPendingIntent.writeToParcel(localParcel1, 0);
            this.a.transact(49, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void b(String paramString, oh paramoh, ja paramja)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localParcel1.writeString(paramString);
        if (paramoh != null)
        {
          localParcel1.writeInt(1);
          paramoh.writeToParcel(localParcel1, 0);
          if (paramja != null)
          {
            localIBinder = paramja.asBinder();
            localParcel1.writeStrongBinder(localIBinder);
            this.a.transact(42, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        IBinder localIBinder = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public IBinder c()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      this.a.transact(54, localParcel1, localParcel2, 0);
      localParcel2.readException();
      IBinder localIBinder = localParcel2.readStrongBinder();
      return localIBinder;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     iK
 * JD-Core Version:    0.7.0.1
 */