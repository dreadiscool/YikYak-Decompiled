import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.internal.y;
import com.google.android.gms.maps.model.LatLng;

class ku
  implements ks
{
  private IBinder a;
  
  ku(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public LatLng a(y paramy)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
        if (paramy != null)
        {
          localParcel1.writeInt(1);
          paramy.writeToParcel(localParcel1, 0);
          this.a.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            LatLng localLatLng2 = LatLng.CREATOR.a(localParcel2);
            localLatLng1 = localLatLng2;
            return localLatLng1;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        LatLng localLatLng1 = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  /* Error */
  public LatLng a(gU paramgU)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore_3
    //   6: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore 4
    //   11: aload_3
    //   12: ldc 24
    //   14: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_1
    //   18: ifnull +69 -> 87
    //   21: aload_1
    //   22: invokeinterface 72 1 0
    //   27: astore 6
    //   29: aload_3
    //   30: aload 6
    //   32: invokevirtual 75	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   35: aload_0
    //   36: getfield 15	ku:a	Landroid/os/IBinder;
    //   39: iconst_1
    //   40: aload_3
    //   41: aload 4
    //   43: iconst_0
    //   44: invokeinterface 44 5 0
    //   49: pop
    //   50: aload 4
    //   52: invokevirtual 47	android/os/Parcel:readException	()V
    //   55: aload 4
    //   57: invokevirtual 51	android/os/Parcel:readInt	()I
    //   60: ifeq +16 -> 76
    //   63: getstatic 57	com/google/android/gms/maps/model/LatLng:CREATOR	Lmp;
    //   66: aload 4
    //   68: invokevirtual 62	mp:a	(Landroid/os/Parcel;)Lcom/google/android/gms/maps/model/LatLng;
    //   71: astore 8
    //   73: aload 8
    //   75: astore_2
    //   76: aload 4
    //   78: invokevirtual 65	android/os/Parcel:recycle	()V
    //   81: aload_3
    //   82: invokevirtual 65	android/os/Parcel:recycle	()V
    //   85: aload_2
    //   86: areturn
    //   87: aconst_null
    //   88: astore 6
    //   90: goto -61 -> 29
    //   93: astore 5
    //   95: aload 4
    //   97: invokevirtual 65	android/os/Parcel:recycle	()V
    //   100: aload_3
    //   101: invokevirtual 65	android/os/Parcel:recycle	()V
    //   104: aload 5
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	ku
    //   0	107	1	paramgU	gU
    //   1	85	2	localObject1	Object
    //   5	96	3	localParcel1	Parcel
    //   9	87	4	localParcel2	Parcel
    //   93	12	5	localObject2	Object
    //   27	62	6	localIBinder	IBinder
    //   71	3	8	localLatLng	LatLng
    // Exception table:
    //   from	to	target	type
    //   11	73	93	finally
  }
  
  /* Error */
  public com.google.android.gms.maps.model.VisibleRegion a()
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
    //   15: getfield 15	ku:a	Landroid/os/IBinder;
    //   18: iconst_3
    //   19: aload_1
    //   20: aload_2
    //   21: iconst_0
    //   22: invokeinterface 44 5 0
    //   27: pop
    //   28: aload_2
    //   29: invokevirtual 47	android/os/Parcel:readException	()V
    //   32: aload_2
    //   33: invokevirtual 51	android/os/Parcel:readInt	()I
    //   36: ifeq +27 -> 63
    //   39: getstatic 81	com/google/android/gms/maps/model/VisibleRegion:CREATOR	Lnk;
    //   42: aload_2
    //   43: invokevirtual 86	nk:a	(Landroid/os/Parcel;)Lcom/google/android/gms/maps/model/VisibleRegion;
    //   46: astore 6
    //   48: aload 6
    //   50: astore 5
    //   52: aload_2
    //   53: invokevirtual 65	android/os/Parcel:recycle	()V
    //   56: aload_1
    //   57: invokevirtual 65	android/os/Parcel:recycle	()V
    //   60: aload 5
    //   62: areturn
    //   63: aconst_null
    //   64: astore 5
    //   66: goto -14 -> 52
    //   69: astore_3
    //   70: aload_2
    //   71: invokevirtual 65	android/os/Parcel:recycle	()V
    //   74: aload_1
    //   75: invokevirtual 65	android/os/Parcel:recycle	()V
    //   78: aload_3
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	ku
    //   3	72	1	localParcel1	Parcel
    //   7	64	2	localParcel2	Parcel
    //   69	10	3	localObject	Object
    //   50	15	5	localVisibleRegion1	com.google.android.gms.maps.model.VisibleRegion
    //   46	3	6	localVisibleRegion2	com.google.android.gms.maps.model.VisibleRegion
    // Exception table:
    //   from	to	target	type
    //   8	48	69	finally
  }
  
  /* Error */
  public gU a(LatLng paramLatLng)
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
    //   15: ifnull +52 -> 67
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 32	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 88	com/google/android/gms/maps/model/LatLng:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	ku:a	Landroid/os/IBinder;
    //   33: iconst_2
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: invokeinterface 44 5 0
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 47	android/os/Parcel:readException	()V
    //   47: aload_3
    //   48: invokevirtual 91	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   51: invokestatic 96	gV:a	(Landroid/os/IBinder;)LgU;
    //   54: astore 6
    //   56: aload_3
    //   57: invokevirtual 65	android/os/Parcel:recycle	()V
    //   60: aload_2
    //   61: invokevirtual 65	android/os/Parcel:recycle	()V
    //   64: aload 6
    //   66: areturn
    //   67: aload_2
    //   68: iconst_0
    //   69: invokevirtual 32	android/os/Parcel:writeInt	(I)V
    //   72: goto -43 -> 29
    //   75: astore 4
    //   77: aload_3
    //   78: invokevirtual 65	android/os/Parcel:recycle	()V
    //   81: aload_2
    //   82: invokevirtual 65	android/os/Parcel:recycle	()V
    //   85: aload 4
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	ku
    //   0	88	1	paramLatLng	LatLng
    //   3	79	2	localParcel1	Parcel
    //   7	71	3	localParcel2	Parcel
    //   75	11	4	localObject	Object
    //   54	11	6	localgU	gU
    // Exception table:
    //   from	to	target	type
    //   8	56	75	finally
    //   67	72	75	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public y b(LatLng paramLatLng)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
        if (paramLatLng != null)
        {
          localParcel1.writeInt(1);
          paramLatLng.writeToParcel(localParcel1, 0);
          this.a.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            y localy2 = y.CREATOR.a(localParcel2);
            localy1 = localy2;
            return localy1;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        y localy1 = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ku
 * JD-Core Version:    0.7.0.1
 */