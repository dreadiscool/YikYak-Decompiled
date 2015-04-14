import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.internal.c;
import com.google.android.gms.maps.model.internal.e;
import com.google.android.gms.maps.model.internal.p;

class ki
  implements kg
{
  private IBinder a;
  
  ki(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public com.google.android.gms.maps.model.CameraPosition a()
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
    //   15: getfield 15	ki:a	Landroid/os/IBinder;
    //   18: iconst_1
    //   19: aload_1
    //   20: aload_2
    //   21: iconst_0
    //   22: invokeinterface 34 5 0
    //   27: pop
    //   28: aload_2
    //   29: invokevirtual 37	android/os/Parcel:readException	()V
    //   32: aload_2
    //   33: invokevirtual 41	android/os/Parcel:readInt	()I
    //   36: ifeq +27 -> 63
    //   39: getstatic 47	com/google/android/gms/maps/model/CameraPosition:CREATOR	Lmh;
    //   42: aload_2
    //   43: invokevirtual 52	mh:a	(Landroid/os/Parcel;)Lcom/google/android/gms/maps/model/CameraPosition;
    //   46: astore 6
    //   48: aload 6
    //   50: astore 5
    //   52: aload_2
    //   53: invokevirtual 55	android/os/Parcel:recycle	()V
    //   56: aload_1
    //   57: invokevirtual 55	android/os/Parcel:recycle	()V
    //   60: aload 5
    //   62: areturn
    //   63: aconst_null
    //   64: astore 5
    //   66: goto -14 -> 52
    //   69: astore_3
    //   70: aload_2
    //   71: invokevirtual 55	android/os/Parcel:recycle	()V
    //   74: aload_1
    //   75: invokevirtual 55	android/os/Parcel:recycle	()V
    //   78: aload_3
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	ki
    //   3	72	1	localParcel1	Parcel
    //   7	64	2	localParcel2	Parcel
    //   69	10	3	localObject	Object
    //   50	15	5	localCameraPosition1	com.google.android.gms.maps.model.CameraPosition
    //   46	3	6	localCameraPosition2	com.google.android.gms.maps.model.CameraPosition
    // Exception table:
    //   from	to	target	type
    //   8	48	69	finally
  }
  
  /* Error */
  public mC a(GroundOverlayOptions paramGroundOverlayOptions)
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
    //   15: ifnull +53 -> 68
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 66	com/google/android/gms/maps/model/GroundOverlayOptions:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	ki:a	Landroid/os/IBinder;
    //   33: bipush 12
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 34 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 37	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 70	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   52: invokestatic 75	mD:a	(Landroid/os/IBinder;)LmC;
    //   55: astore 6
    //   57: aload_3
    //   58: invokevirtual 55	android/os/Parcel:recycle	()V
    //   61: aload_2
    //   62: invokevirtual 55	android/os/Parcel:recycle	()V
    //   65: aload 6
    //   67: areturn
    //   68: aload_2
    //   69: iconst_0
    //   70: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   73: goto -44 -> 29
    //   76: astore 4
    //   78: aload_3
    //   79: invokevirtual 55	android/os/Parcel:recycle	()V
    //   82: aload_2
    //   83: invokevirtual 55	android/os/Parcel:recycle	()V
    //   86: aload 4
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	ki
    //   0	89	1	paramGroundOverlayOptions	GroundOverlayOptions
    //   3	80	2	localParcel1	Parcel
    //   7	72	3	localParcel2	Parcel
    //   76	11	4	localObject	Object
    //   55	11	6	localmC	mC
    // Exception table:
    //   from	to	target	type
    //   8	57	76	finally
    //   68	73	76	finally
  }
  
  public mC a(GroundOverlayOptions paramGroundOverlayOptions, e parame)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramGroundOverlayOptions != null)
        {
          localParcel1.writeInt(1);
          paramGroundOverlayOptions.writeToParcel(localParcel1, 0);
          if (parame != null)
          {
            localParcel1.writeInt(1);
            parame.writeToParcel(localParcel1, 0);
            this.a.transact(70, localParcel1, localParcel2, 0);
            localParcel2.readException();
            mC localmC = mD.a(localParcel2.readStrongBinder());
            return localmC;
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
  
  /* Error */
  public mI a(MarkerOptions paramMarkerOptions)
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
    //   15: ifnull +53 -> 68
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 83	com/google/android/gms/maps/model/MarkerOptions:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	ki:a	Landroid/os/IBinder;
    //   33: bipush 11
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 34 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 37	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 70	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   52: invokestatic 88	mJ:a	(Landroid/os/IBinder;)LmI;
    //   55: astore 6
    //   57: aload_3
    //   58: invokevirtual 55	android/os/Parcel:recycle	()V
    //   61: aload_2
    //   62: invokevirtual 55	android/os/Parcel:recycle	()V
    //   65: aload 6
    //   67: areturn
    //   68: aload_2
    //   69: iconst_0
    //   70: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   73: goto -44 -> 29
    //   76: astore 4
    //   78: aload_3
    //   79: invokevirtual 55	android/os/Parcel:recycle	()V
    //   82: aload_2
    //   83: invokevirtual 55	android/os/Parcel:recycle	()V
    //   86: aload 4
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	ki
    //   0	89	1	paramMarkerOptions	MarkerOptions
    //   3	80	2	localParcel1	Parcel
    //   7	72	3	localParcel2	Parcel
    //   76	11	4	localObject	Object
    //   55	11	6	localmI	mI
    // Exception table:
    //   from	to	target	type
    //   8	57	76	finally
    //   68	73	76	finally
  }
  
  public mI a(MarkerOptions paramMarkerOptions, p paramp)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramMarkerOptions != null)
        {
          localParcel1.writeInt(1);
          paramMarkerOptions.writeToParcel(localParcel1, 0);
          if (paramp != null)
          {
            localParcel1.writeInt(1);
            paramp.writeToParcel(localParcel1, 0);
            this.a.transact(68, localParcel1, localParcel2, 0);
            localParcel2.readException();
            mI localmI = mJ.a(localParcel2.readStrongBinder());
            return localmI;
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
  
  /* Error */
  public mL a(com.google.android.gms.maps.model.PolygonOptions paramPolygonOptions)
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
    //   15: ifnull +53 -> 68
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 96	com/google/android/gms/maps/model/PolygonOptions:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	ki:a	Landroid/os/IBinder;
    //   33: bipush 10
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 34 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 37	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 70	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   52: invokestatic 101	mM:a	(Landroid/os/IBinder;)LmL;
    //   55: astore 6
    //   57: aload_3
    //   58: invokevirtual 55	android/os/Parcel:recycle	()V
    //   61: aload_2
    //   62: invokevirtual 55	android/os/Parcel:recycle	()V
    //   65: aload 6
    //   67: areturn
    //   68: aload_2
    //   69: iconst_0
    //   70: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   73: goto -44 -> 29
    //   76: astore 4
    //   78: aload_3
    //   79: invokevirtual 55	android/os/Parcel:recycle	()V
    //   82: aload_2
    //   83: invokevirtual 55	android/os/Parcel:recycle	()V
    //   86: aload 4
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	ki
    //   0	89	1	paramPolygonOptions	com.google.android.gms.maps.model.PolygonOptions
    //   3	80	2	localParcel1	Parcel
    //   7	72	3	localParcel2	Parcel
    //   76	11	4	localObject	Object
    //   55	11	6	localmL	mL
    // Exception table:
    //   from	to	target	type
    //   8	57	76	finally
    //   68	73	76	finally
  }
  
  /* Error */
  public mO a(com.google.android.gms.maps.model.TileOverlayOptions paramTileOverlayOptions)
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
    //   15: ifnull +53 -> 68
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 105	com/google/android/gms/maps/model/TileOverlayOptions:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	ki:a	Landroid/os/IBinder;
    //   33: bipush 13
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 34 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 37	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 70	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   52: invokestatic 110	mP:a	(Landroid/os/IBinder;)LmO;
    //   55: astore 6
    //   57: aload_3
    //   58: invokevirtual 55	android/os/Parcel:recycle	()V
    //   61: aload_2
    //   62: invokevirtual 55	android/os/Parcel:recycle	()V
    //   65: aload 6
    //   67: areturn
    //   68: aload_2
    //   69: iconst_0
    //   70: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   73: goto -44 -> 29
    //   76: astore 4
    //   78: aload_3
    //   79: invokevirtual 55	android/os/Parcel:recycle	()V
    //   82: aload_2
    //   83: invokevirtual 55	android/os/Parcel:recycle	()V
    //   86: aload 4
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	ki
    //   0	89	1	paramTileOverlayOptions	com.google.android.gms.maps.model.TileOverlayOptions
    //   3	80	2	localParcel1	Parcel
    //   7	72	3	localParcel2	Parcel
    //   76	11	4	localObject	Object
    //   55	11	6	localmO	mO
    // Exception table:
    //   from	to	target	type
    //   8	57	76	finally
    //   68	73	76	finally
  }
  
  /* Error */
  public mq a(com.google.android.gms.maps.model.PolylineOptions paramPolylineOptions)
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
    //   15: ifnull +53 -> 68
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 114	com/google/android/gms/maps/model/PolylineOptions:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	ki:a	Landroid/os/IBinder;
    //   33: bipush 9
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 34 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 37	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 70	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   52: invokestatic 119	mr:a	(Landroid/os/IBinder;)Lmq;
    //   55: astore 6
    //   57: aload_3
    //   58: invokevirtual 55	android/os/Parcel:recycle	()V
    //   61: aload_2
    //   62: invokevirtual 55	android/os/Parcel:recycle	()V
    //   65: aload 6
    //   67: areturn
    //   68: aload_2
    //   69: iconst_0
    //   70: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   73: goto -44 -> 29
    //   76: astore 4
    //   78: aload_3
    //   79: invokevirtual 55	android/os/Parcel:recycle	()V
    //   82: aload_2
    //   83: invokevirtual 55	android/os/Parcel:recycle	()V
    //   86: aload 4
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	ki
    //   0	89	1	paramPolylineOptions	com.google.android.gms.maps.model.PolylineOptions
    //   3	80	2	localParcel1	Parcel
    //   7	72	3	localParcel2	Parcel
    //   76	11	4	localObject	Object
    //   55	11	6	localmq	mq
    // Exception table:
    //   from	to	target	type
    //   8	57	76	finally
    //   68	73	76	finally
  }
  
  /* Error */
  public mz a(com.google.android.gms.maps.model.CircleOptions paramCircleOptions)
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
    //   15: ifnull +53 -> 68
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 123	com/google/android/gms/maps/model/CircleOptions:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	ki:a	Landroid/os/IBinder;
    //   33: bipush 35
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 34 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 37	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 70	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   52: invokestatic 128	mA:a	(Landroid/os/IBinder;)Lmz;
    //   55: astore 6
    //   57: aload_3
    //   58: invokevirtual 55	android/os/Parcel:recycle	()V
    //   61: aload_2
    //   62: invokevirtual 55	android/os/Parcel:recycle	()V
    //   65: aload 6
    //   67: areturn
    //   68: aload_2
    //   69: iconst_0
    //   70: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   73: goto -44 -> 29
    //   76: astore 4
    //   78: aload_3
    //   79: invokevirtual 55	android/os/Parcel:recycle	()V
    //   82: aload_2
    //   83: invokevirtual 55	android/os/Parcel:recycle	()V
    //   86: aload 4
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	ki
    //   0	89	1	paramCircleOptions	com.google.android.gms.maps.model.CircleOptions
    //   3	80	2	localParcel1	Parcel
    //   7	72	3	localParcel2	Parcel
    //   76	11	4	localObject	Object
    //   55	11	6	localmz	mz
    // Exception table:
    //   from	to	target	type
    //   8	57	76	finally
    //   68	73	76	finally
  }
  
  public void a(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      localParcel1.writeInt(paramInt);
      this.a.transact(16, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      localParcel1.writeInt(paramInt3);
      localParcel1.writeInt(paramInt4);
      this.a.transact(39, localParcel1, localParcel2, 0);
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
  public void a(android.os.Bundle paramBundle)
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
    //   20: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 133	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	ki:a	Landroid/os/IBinder;
    //   33: bipush 54
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 34 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 37	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 55	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 55	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aload_2
    //   58: iconst_0
    //   59: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   62: goto -33 -> 29
    //   65: astore 4
    //   67: aload_3
    //   68: invokevirtual 55	android/os/Parcel:recycle	()V
    //   71: aload_2
    //   72: invokevirtual 55	android/os/Parcel:recycle	()V
    //   75: aload 4
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	ki
    //   0	78	1	paramBundle	android.os.Bundle
    //   3	69	2	localParcel1	Parcel
    //   7	61	3	localParcel2	Parcel
    //   65	11	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	48	65	finally
    //   57	62	65	finally
  }
  
  /* Error */
  public void a(c paramc)
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
    //   20: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 137	com/google/android/gms/maps/model/internal/c:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	ki:a	Landroid/os/IBinder;
    //   33: bipush 64
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 34 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 37	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 55	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 55	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aload_2
    //   58: iconst_0
    //   59: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   62: goto -33 -> 29
    //   65: astore 4
    //   67: aload_3
    //   68: invokevirtual 55	android/os/Parcel:recycle	()V
    //   71: aload_2
    //   72: invokevirtual 55	android/os/Parcel:recycle	()V
    //   75: aload 4
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	ki
    //   0	78	1	paramc	c
    //   3	69	2	localParcel1	Parcel
    //   7	61	3	localParcel2	Parcel
    //   65	11	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	48	65	finally
    //   57	62	65	finally
  }
  
  public void a(c paramc, int paramInt, kL paramkL)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramc != null)
        {
          localParcel1.writeInt(1);
          paramc.writeToParcel(localParcel1, 0);
          localParcel1.writeInt(paramInt);
          if (paramkL != null)
          {
            localIBinder = paramkL.asBinder();
            localParcel1.writeStrongBinder(localIBinder);
            this.a.transact(67, localParcel1, localParcel2, 0);
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
  
  public void a(c paramc, kL paramkL)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramc != null)
        {
          localParcel1.writeInt(1);
          paramc.writeToParcel(localParcel1, 0);
          if (paramkL != null)
          {
            localIBinder = paramkL.asBinder();
            localParcel1.writeStrongBinder(localIBinder);
            this.a.transact(66, localParcel1, localParcel2, 0);
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
  public void a(gU paramgU)
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
    //   15: ifnull +44 -> 59
    //   18: aload_1
    //   19: invokeinterface 151 1 0
    //   24: astore 5
    //   26: aload_2
    //   27: aload 5
    //   29: invokevirtual 146	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   32: aload_0
    //   33: getfield 15	ki:a	Landroid/os/IBinder;
    //   36: iconst_4
    //   37: aload_2
    //   38: aload_3
    //   39: iconst_0
    //   40: invokeinterface 34 5 0
    //   45: pop
    //   46: aload_3
    //   47: invokevirtual 37	android/os/Parcel:readException	()V
    //   50: aload_3
    //   51: invokevirtual 55	android/os/Parcel:recycle	()V
    //   54: aload_2
    //   55: invokevirtual 55	android/os/Parcel:recycle	()V
    //   58: return
    //   59: aconst_null
    //   60: astore 5
    //   62: goto -36 -> 26
    //   65: astore 4
    //   67: aload_3
    //   68: invokevirtual 55	android/os/Parcel:recycle	()V
    //   71: aload_2
    //   72: invokevirtual 55	android/os/Parcel:recycle	()V
    //   75: aload 4
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	ki
    //   0	78	1	paramgU	gU
    //   3	69	2	localParcel1	Parcel
    //   7	61	3	localParcel2	Parcel
    //   65	11	4	localObject	Object
    //   24	37	5	localIBinder	IBinder
    // Exception table:
    //   from	to	target	type
    //   8	50	65	finally
  }
  
  /* Error */
  public void a(gU paramgU, int paramInt, kL paramkL)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 5
    //   8: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 6
    //   13: aload 5
    //   15: ldc 24
    //   17: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload_1
    //   21: ifnull +76 -> 97
    //   24: aload_1
    //   25: invokeinterface 151 1 0
    //   30: astore 8
    //   32: aload 5
    //   34: aload 8
    //   36: invokevirtual 146	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   39: aload 5
    //   41: iload_2
    //   42: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   45: aload_3
    //   46: ifnull +11 -> 57
    //   49: aload_3
    //   50: invokeinterface 143 1 0
    //   55: astore 4
    //   57: aload 5
    //   59: aload 4
    //   61: invokevirtual 146	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   64: aload_0
    //   65: getfield 15	ki:a	Landroid/os/IBinder;
    //   68: bipush 7
    //   70: aload 5
    //   72: aload 6
    //   74: iconst_0
    //   75: invokeinterface 34 5 0
    //   80: pop
    //   81: aload 6
    //   83: invokevirtual 37	android/os/Parcel:readException	()V
    //   86: aload 6
    //   88: invokevirtual 55	android/os/Parcel:recycle	()V
    //   91: aload 5
    //   93: invokevirtual 55	android/os/Parcel:recycle	()V
    //   96: return
    //   97: aconst_null
    //   98: astore 8
    //   100: goto -68 -> 32
    //   103: astore 7
    //   105: aload 6
    //   107: invokevirtual 55	android/os/Parcel:recycle	()V
    //   110: aload 5
    //   112: invokevirtual 55	android/os/Parcel:recycle	()V
    //   115: aload 7
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	ki
    //   0	118	1	paramgU	gU
    //   0	118	2	paramInt	int
    //   0	118	3	paramkL	kL
    //   1	59	4	localIBinder1	IBinder
    //   6	105	5	localParcel1	Parcel
    //   11	95	6	localParcel2	Parcel
    //   103	13	7	localObject	Object
    //   30	69	8	localIBinder2	IBinder
    // Exception table:
    //   from	to	target	type
    //   13	86	103	finally
  }
  
  /* Error */
  public void a(gU paramgU, kL paramkL)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore 4
    //   7: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   10: astore 5
    //   12: aload 4
    //   14: ldc 24
    //   16: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   19: aload_1
    //   20: ifnull +68 -> 88
    //   23: aload_1
    //   24: invokeinterface 151 1 0
    //   29: astore 7
    //   31: aload 4
    //   33: aload 7
    //   35: invokevirtual 146	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   38: aload_2
    //   39: ifnull +10 -> 49
    //   42: aload_2
    //   43: invokeinterface 143 1 0
    //   48: astore_3
    //   49: aload 4
    //   51: aload_3
    //   52: invokevirtual 146	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   55: aload_0
    //   56: getfield 15	ki:a	Landroid/os/IBinder;
    //   59: bipush 6
    //   61: aload 4
    //   63: aload 5
    //   65: iconst_0
    //   66: invokeinterface 34 5 0
    //   71: pop
    //   72: aload 5
    //   74: invokevirtual 37	android/os/Parcel:readException	()V
    //   77: aload 5
    //   79: invokevirtual 55	android/os/Parcel:recycle	()V
    //   82: aload 4
    //   84: invokevirtual 55	android/os/Parcel:recycle	()V
    //   87: return
    //   88: aconst_null
    //   89: astore 7
    //   91: goto -60 -> 31
    //   94: astore 6
    //   96: aload 5
    //   98: invokevirtual 55	android/os/Parcel:recycle	()V
    //   101: aload 4
    //   103: invokevirtual 55	android/os/Parcel:recycle	()V
    //   106: aload 6
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	ki
    //   0	109	1	paramgU	gU
    //   0	109	2	paramkL	kL
    //   1	51	3	localIBinder1	IBinder
    //   5	97	4	localParcel1	Parcel
    //   10	87	5	localParcel2	Parcel
    //   94	13	6	localObject	Object
    //   29	61	7	localIBinder2	IBinder
    // Exception table:
    //   from	to	target	type
    //   12	77	94	finally
  }
  
  public void a(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      localParcel1.writeString(paramString);
      this.a.transact(61, localParcel1, localParcel2, 0);
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
  public void a(kR paramkR)
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
    //   19: invokeinterface 160 1 0
    //   24: astore 5
    //   26: aload_2
    //   27: aload 5
    //   29: invokevirtual 146	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   32: aload_0
    //   33: getfield 15	ki:a	Landroid/os/IBinder;
    //   36: bipush 33
    //   38: aload_2
    //   39: aload_3
    //   40: iconst_0
    //   41: invokeinterface 34 5 0
    //   46: pop
    //   47: aload_3
    //   48: invokevirtual 37	android/os/Parcel:readException	()V
    //   51: aload_3
    //   52: invokevirtual 55	android/os/Parcel:recycle	()V
    //   55: aload_2
    //   56: invokevirtual 55	android/os/Parcel:recycle	()V
    //   59: return
    //   60: aconst_null
    //   61: astore 5
    //   63: goto -37 -> 26
    //   66: astore 4
    //   68: aload_3
    //   69: invokevirtual 55	android/os/Parcel:recycle	()V
    //   72: aload_2
    //   73: invokevirtual 55	android/os/Parcel:recycle	()V
    //   76: aload 4
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	ki
    //   0	79	1	paramkR	kR
    //   3	70	2	localParcel1	Parcel
    //   7	62	3	localParcel2	Parcel
    //   66	11	4	localObject	Object
    //   24	38	5	localIBinder	IBinder
    // Exception table:
    //   from	to	target	type
    //   8	51	66	finally
  }
  
  /* Error */
  public void a(kU paramkU)
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
    //   19: invokeinterface 164 1 0
    //   24: astore 5
    //   26: aload_2
    //   27: aload 5
    //   29: invokevirtual 146	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   32: aload_0
    //   33: getfield 15	ki:a	Landroid/os/IBinder;
    //   36: bipush 69
    //   38: aload_2
    //   39: aload_3
    //   40: iconst_0
    //   41: invokeinterface 34 5 0
    //   46: pop
    //   47: aload_3
    //   48: invokevirtual 37	android/os/Parcel:readException	()V
    //   51: aload_3
    //   52: invokevirtual 55	android/os/Parcel:recycle	()V
    //   55: aload_2
    //   56: invokevirtual 55	android/os/Parcel:recycle	()V
    //   59: return
    //   60: aconst_null
    //   61: astore 5
    //   63: goto -37 -> 26
    //   66: astore 4
    //   68: aload_3
    //   69: invokevirtual 55	android/os/Parcel:recycle	()V
    //   72: aload_2
    //   73: invokevirtual 55	android/os/Parcel:recycle	()V
    //   76: aload 4
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	ki
    //   0	79	1	paramkU	kU
    //   3	70	2	localParcel1	Parcel
    //   7	62	3	localParcel2	Parcel
    //   66	11	4	localObject	Object
    //   24	38	5	localIBinder	IBinder
    // Exception table:
    //   from	to	target	type
    //   8	51	66	finally
  }
  
  /* Error */
  public void a(kX paramkX)
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
    //   19: invokeinterface 168 1 0
    //   24: astore 5
    //   26: aload_2
    //   27: aload 5
    //   29: invokevirtual 146	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   32: aload_0
    //   33: getfield 15	ki:a	Landroid/os/IBinder;
    //   36: bipush 27
    //   38: aload_2
    //   39: aload_3
    //   40: iconst_0
    //   41: invokeinterface 34 5 0
    //   46: pop
    //   47: aload_3
    //   48: invokevirtual 37	android/os/Parcel:readException	()V
    //   51: aload_3
    //   52: invokevirtual 55	android/os/Parcel:recycle	()V
    //   55: aload_2
    //   56: invokevirtual 55	android/os/Parcel:recycle	()V
    //   59: return
    //   60: aconst_null
    //   61: astore 5
    //   63: goto -37 -> 26
    //   66: astore 4
    //   68: aload_3
    //   69: invokevirtual 55	android/os/Parcel:recycle	()V
    //   72: aload_2
    //   73: invokevirtual 55	android/os/Parcel:recycle	()V
    //   76: aload 4
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	ki
    //   0	79	1	paramkX	kX
    //   3	70	2	localParcel1	Parcel
    //   7	62	3	localParcel2	Parcel
    //   66	11	4	localObject	Object
    //   24	38	5	localIBinder	IBinder
    // Exception table:
    //   from	to	target	type
    //   8	51	66	finally
  }
  
  /* Error */
  public void a(kj paramkj)
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
    //   19: invokeinterface 172 1 0
    //   24: astore 5
    //   26: aload_2
    //   27: aload 5
    //   29: invokevirtual 146	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   32: aload_0
    //   33: getfield 15	ki:a	Landroid/os/IBinder;
    //   36: bipush 24
    //   38: aload_2
    //   39: aload_3
    //   40: iconst_0
    //   41: invokeinterface 34 5 0
    //   46: pop
    //   47: aload_3
    //   48: invokevirtual 37	android/os/Parcel:readException	()V
    //   51: aload_3
    //   52: invokevirtual 55	android/os/Parcel:recycle	()V
    //   55: aload_2
    //   56: invokevirtual 55	android/os/Parcel:recycle	()V
    //   59: return
    //   60: aconst_null
    //   61: astore 5
    //   63: goto -37 -> 26
    //   66: astore 4
    //   68: aload_3
    //   69: invokevirtual 55	android/os/Parcel:recycle	()V
    //   72: aload_2
    //   73: invokevirtual 55	android/os/Parcel:recycle	()V
    //   76: aload 4
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	ki
    //   0	79	1	paramkj	kj
    //   3	70	2	localParcel1	Parcel
    //   7	62	3	localParcel2	Parcel
    //   66	11	4	localObject	Object
    //   24	38	5	localIBinder	IBinder
    // Exception table:
    //   from	to	target	type
    //   8	51	66	finally
  }
  
  /* Error */
  public void a(lB paramlB)
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
    //   19: invokeinterface 176 1 0
    //   24: astore 5
    //   26: aload_2
    //   27: aload 5
    //   29: invokevirtual 146	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   32: aload_0
    //   33: getfield 15	ki:a	Landroid/os/IBinder;
    //   36: bipush 37
    //   38: aload_2
    //   39: aload_3
    //   40: iconst_0
    //   41: invokeinterface 34 5 0
    //   46: pop
    //   47: aload_3
    //   48: invokevirtual 37	android/os/Parcel:readException	()V
    //   51: aload_3
    //   52: invokevirtual 55	android/os/Parcel:recycle	()V
    //   55: aload_2
    //   56: invokevirtual 55	android/os/Parcel:recycle	()V
    //   59: return
    //   60: aconst_null
    //   61: astore 5
    //   63: goto -37 -> 26
    //   66: astore 4
    //   68: aload_3
    //   69: invokevirtual 55	android/os/Parcel:recycle	()V
    //   72: aload_2
    //   73: invokevirtual 55	android/os/Parcel:recycle	()V
    //   76: aload 4
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	ki
    //   0	79	1	paramlB	lB
    //   3	70	2	localParcel1	Parcel
    //   7	62	3	localParcel2	Parcel
    //   66	11	4	localObject	Object
    //   24	38	5	localIBinder	IBinder
    // Exception table:
    //   from	to	target	type
    //   8	51	66	finally
  }
  
  /* Error */
  public void a(lE paramlE)
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
    //   19: invokeinterface 180 1 0
    //   24: astore 5
    //   26: aload_2
    //   27: aload 5
    //   29: invokevirtual 146	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   32: aload_0
    //   33: getfield 15	ki:a	Landroid/os/IBinder;
    //   36: bipush 36
    //   38: aload_2
    //   39: aload_3
    //   40: iconst_0
    //   41: invokeinterface 34 5 0
    //   46: pop
    //   47: aload_3
    //   48: invokevirtual 37	android/os/Parcel:readException	()V
    //   51: aload_3
    //   52: invokevirtual 55	android/os/Parcel:recycle	()V
    //   55: aload_2
    //   56: invokevirtual 55	android/os/Parcel:recycle	()V
    //   59: return
    //   60: aconst_null
    //   61: astore 5
    //   63: goto -37 -> 26
    //   66: astore 4
    //   68: aload_3
    //   69: invokevirtual 55	android/os/Parcel:recycle	()V
    //   72: aload_2
    //   73: invokevirtual 55	android/os/Parcel:recycle	()V
    //   76: aload 4
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	ki
    //   0	79	1	paramlE	lE
    //   3	70	2	localParcel1	Parcel
    //   7	62	3	localParcel2	Parcel
    //   66	11	4	localObject	Object
    //   24	38	5	localIBinder	IBinder
    // Exception table:
    //   from	to	target	type
    //   8	51	66	finally
  }
  
  /* Error */
  public void a(lT paramlT, gU paramgU)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore 4
    //   7: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   10: astore 5
    //   12: aload 4
    //   14: ldc 24
    //   16: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   19: aload_1
    //   20: ifnull +68 -> 88
    //   23: aload_1
    //   24: invokeinterface 184 1 0
    //   29: astore 7
    //   31: aload 4
    //   33: aload 7
    //   35: invokevirtual 146	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   38: aload_2
    //   39: ifnull +10 -> 49
    //   42: aload_2
    //   43: invokeinterface 151 1 0
    //   48: astore_3
    //   49: aload 4
    //   51: aload_3
    //   52: invokevirtual 146	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   55: aload_0
    //   56: getfield 15	ki:a	Landroid/os/IBinder;
    //   59: bipush 38
    //   61: aload 4
    //   63: aload 5
    //   65: iconst_0
    //   66: invokeinterface 34 5 0
    //   71: pop
    //   72: aload 5
    //   74: invokevirtual 37	android/os/Parcel:readException	()V
    //   77: aload 5
    //   79: invokevirtual 55	android/os/Parcel:recycle	()V
    //   82: aload 4
    //   84: invokevirtual 55	android/os/Parcel:recycle	()V
    //   87: return
    //   88: aconst_null
    //   89: astore 7
    //   91: goto -60 -> 31
    //   94: astore 6
    //   96: aload 5
    //   98: invokevirtual 55	android/os/Parcel:recycle	()V
    //   101: aload 4
    //   103: invokevirtual 55	android/os/Parcel:recycle	()V
    //   106: aload 6
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	ki
    //   0	109	1	paramlT	lT
    //   0	109	2	paramgU	gU
    //   1	51	3	localIBinder1	IBinder
    //   5	97	4	localParcel1	Parcel
    //   10	87	5	localParcel2	Parcel
    //   94	13	6	localObject	Object
    //   29	61	7	localIBinder2	IBinder
    // Exception table:
    //   from	to	target	type
    //   12	77	94	finally
  }
  
  /* Error */
  public void a(la paramla)
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
    //   19: invokeinterface 188 1 0
    //   24: astore 5
    //   26: aload_2
    //   27: aload 5
    //   29: invokevirtual 146	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   32: aload_0
    //   33: getfield 15	ki:a	Landroid/os/IBinder;
    //   36: bipush 45
    //   38: aload_2
    //   39: aload_3
    //   40: iconst_0
    //   41: invokeinterface 34 5 0
    //   46: pop
    //   47: aload_3
    //   48: invokevirtual 37	android/os/Parcel:readException	()V
    //   51: aload_3
    //   52: invokevirtual 55	android/os/Parcel:recycle	()V
    //   55: aload_2
    //   56: invokevirtual 55	android/os/Parcel:recycle	()V
    //   59: return
    //   60: aconst_null
    //   61: astore 5
    //   63: goto -37 -> 26
    //   66: astore 4
    //   68: aload_3
    //   69: invokevirtual 55	android/os/Parcel:recycle	()V
    //   72: aload_2
    //   73: invokevirtual 55	android/os/Parcel:recycle	()V
    //   76: aload 4
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	ki
    //   0	79	1	paramla	la
    //   3	70	2	localParcel1	Parcel
    //   7	62	3	localParcel2	Parcel
    //   66	11	4	localObject	Object
    //   24	38	5	localIBinder	IBinder
    // Exception table:
    //   from	to	target	type
    //   8	51	66	finally
  }
  
  /* Error */
  public void a(ld paramld)
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
    //   19: invokeinterface 192 1 0
    //   24: astore 5
    //   26: aload_2
    //   27: aload 5
    //   29: invokevirtual 146	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   32: aload_0
    //   33: getfield 15	ki:a	Landroid/os/IBinder;
    //   36: bipush 32
    //   38: aload_2
    //   39: aload_3
    //   40: iconst_0
    //   41: invokeinterface 34 5 0
    //   46: pop
    //   47: aload_3
    //   48: invokevirtual 37	android/os/Parcel:readException	()V
    //   51: aload_3
    //   52: invokevirtual 55	android/os/Parcel:recycle	()V
    //   55: aload_2
    //   56: invokevirtual 55	android/os/Parcel:recycle	()V
    //   59: return
    //   60: aconst_null
    //   61: astore 5
    //   63: goto -37 -> 26
    //   66: astore 4
    //   68: aload_3
    //   69: invokevirtual 55	android/os/Parcel:recycle	()V
    //   72: aload_2
    //   73: invokevirtual 55	android/os/Parcel:recycle	()V
    //   76: aload 4
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	ki
    //   0	79	1	paramld	ld
    //   3	70	2	localParcel1	Parcel
    //   7	62	3	localParcel2	Parcel
    //   66	11	4	localObject	Object
    //   24	38	5	localIBinder	IBinder
    // Exception table:
    //   from	to	target	type
    //   8	51	66	finally
  }
  
  /* Error */
  public void a(lj paramlj)
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
    //   19: invokeinterface 196 1 0
    //   24: astore 5
    //   26: aload_2
    //   27: aload 5
    //   29: invokevirtual 146	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   32: aload_0
    //   33: getfield 15	ki:a	Landroid/os/IBinder;
    //   36: bipush 28
    //   38: aload_2
    //   39: aload_3
    //   40: iconst_0
    //   41: invokeinterface 34 5 0
    //   46: pop
    //   47: aload_3
    //   48: invokevirtual 37	android/os/Parcel:readException	()V
    //   51: aload_3
    //   52: invokevirtual 55	android/os/Parcel:recycle	()V
    //   55: aload_2
    //   56: invokevirtual 55	android/os/Parcel:recycle	()V
    //   59: return
    //   60: aconst_null
    //   61: astore 5
    //   63: goto -37 -> 26
    //   66: astore 4
    //   68: aload_3
    //   69: invokevirtual 55	android/os/Parcel:recycle	()V
    //   72: aload_2
    //   73: invokevirtual 55	android/os/Parcel:recycle	()V
    //   76: aload 4
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	ki
    //   0	79	1	paramlj	lj
    //   3	70	2	localParcel1	Parcel
    //   7	62	3	localParcel2	Parcel
    //   66	11	4	localObject	Object
    //   24	38	5	localIBinder	IBinder
    // Exception table:
    //   from	to	target	type
    //   8	51	66	finally
  }
  
  /* Error */
  public void a(lm paramlm)
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
    //   19: invokeinterface 200 1 0
    //   24: astore 5
    //   26: aload_2
    //   27: aload 5
    //   29: invokevirtual 146	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   32: aload_0
    //   33: getfield 15	ki:a	Landroid/os/IBinder;
    //   36: bipush 42
    //   38: aload_2
    //   39: aload_3
    //   40: iconst_0
    //   41: invokeinterface 34 5 0
    //   46: pop
    //   47: aload_3
    //   48: invokevirtual 37	android/os/Parcel:readException	()V
    //   51: aload_3
    //   52: invokevirtual 55	android/os/Parcel:recycle	()V
    //   55: aload_2
    //   56: invokevirtual 55	android/os/Parcel:recycle	()V
    //   59: return
    //   60: aconst_null
    //   61: astore 5
    //   63: goto -37 -> 26
    //   66: astore 4
    //   68: aload_3
    //   69: invokevirtual 55	android/os/Parcel:recycle	()V
    //   72: aload_2
    //   73: invokevirtual 55	android/os/Parcel:recycle	()V
    //   76: aload 4
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	ki
    //   0	79	1	paramlm	lm
    //   3	70	2	localParcel1	Parcel
    //   7	62	3	localParcel2	Parcel
    //   66	11	4	localObject	Object
    //   24	38	5	localIBinder	IBinder
    // Exception table:
    //   from	to	target	type
    //   8	51	66	finally
  }
  
  /* Error */
  public void a(lp paramlp)
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
    //   19: invokeinterface 204 1 0
    //   24: astore 5
    //   26: aload_2
    //   27: aload 5
    //   29: invokevirtual 146	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   32: aload_0
    //   33: getfield 15	ki:a	Landroid/os/IBinder;
    //   36: bipush 29
    //   38: aload_2
    //   39: aload_3
    //   40: iconst_0
    //   41: invokeinterface 34 5 0
    //   46: pop
    //   47: aload_3
    //   48: invokevirtual 37	android/os/Parcel:readException	()V
    //   51: aload_3
    //   52: invokevirtual 55	android/os/Parcel:recycle	()V
    //   55: aload_2
    //   56: invokevirtual 55	android/os/Parcel:recycle	()V
    //   59: return
    //   60: aconst_null
    //   61: astore 5
    //   63: goto -37 -> 26
    //   66: astore 4
    //   68: aload_3
    //   69: invokevirtual 55	android/os/Parcel:recycle	()V
    //   72: aload_2
    //   73: invokevirtual 55	android/os/Parcel:recycle	()V
    //   76: aload 4
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	ki
    //   0	79	1	paramlp	lp
    //   3	70	2	localParcel1	Parcel
    //   7	62	3	localParcel2	Parcel
    //   66	11	4	localObject	Object
    //   24	38	5	localIBinder	IBinder
    // Exception table:
    //   from	to	target	type
    //   8	51	66	finally
  }
  
  /* Error */
  public void a(ls paramls)
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
    //   19: invokeinterface 208 1 0
    //   24: astore 5
    //   26: aload_2
    //   27: aload 5
    //   29: invokevirtual 146	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   32: aload_0
    //   33: getfield 15	ki:a	Landroid/os/IBinder;
    //   36: bipush 53
    //   38: aload_2
    //   39: aload_3
    //   40: iconst_0
    //   41: invokeinterface 34 5 0
    //   46: pop
    //   47: aload_3
    //   48: invokevirtual 37	android/os/Parcel:readException	()V
    //   51: aload_3
    //   52: invokevirtual 55	android/os/Parcel:recycle	()V
    //   55: aload_2
    //   56: invokevirtual 55	android/os/Parcel:recycle	()V
    //   59: return
    //   60: aconst_null
    //   61: astore 5
    //   63: goto -37 -> 26
    //   66: astore 4
    //   68: aload_3
    //   69: invokevirtual 55	android/os/Parcel:recycle	()V
    //   72: aload_2
    //   73: invokevirtual 55	android/os/Parcel:recycle	()V
    //   76: aload 4
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	ki
    //   0	79	1	paramls	ls
    //   3	70	2	localParcel1	Parcel
    //   7	62	3	localParcel2	Parcel
    //   66	11	4	localObject	Object
    //   24	38	5	localIBinder	IBinder
    // Exception table:
    //   from	to	target	type
    //   8	51	66	finally
  }
  
  /* Error */
  public void a(lv paramlv)
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
    //   19: invokeinterface 212 1 0
    //   24: astore 5
    //   26: aload_2
    //   27: aload 5
    //   29: invokevirtual 146	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   32: aload_0
    //   33: getfield 15	ki:a	Landroid/os/IBinder;
    //   36: bipush 30
    //   38: aload_2
    //   39: aload_3
    //   40: iconst_0
    //   41: invokeinterface 34 5 0
    //   46: pop
    //   47: aload_3
    //   48: invokevirtual 37	android/os/Parcel:readException	()V
    //   51: aload_3
    //   52: invokevirtual 55	android/os/Parcel:recycle	()V
    //   55: aload_2
    //   56: invokevirtual 55	android/os/Parcel:recycle	()V
    //   59: return
    //   60: aconst_null
    //   61: astore 5
    //   63: goto -37 -> 26
    //   66: astore 4
    //   68: aload_3
    //   69: invokevirtual 55	android/os/Parcel:recycle	()V
    //   72: aload_2
    //   73: invokevirtual 55	android/os/Parcel:recycle	()V
    //   76: aload 4
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	ki
    //   0	79	1	paramlv	lv
    //   3	70	2	localParcel1	Parcel
    //   7	62	3	localParcel2	Parcel
    //   66	11	4	localObject	Object
    //   24	38	5	localIBinder	IBinder
    // Exception table:
    //   from	to	target	type
    //   8	51	66	finally
  }
  
  /* Error */
  public void a(ly paramly)
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
    //   19: invokeinterface 216 1 0
    //   24: astore 5
    //   26: aload_2
    //   27: aload 5
    //   29: invokevirtual 146	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   32: aload_0
    //   33: getfield 15	ki:a	Landroid/os/IBinder;
    //   36: bipush 31
    //   38: aload_2
    //   39: aload_3
    //   40: iconst_0
    //   41: invokeinterface 34 5 0
    //   46: pop
    //   47: aload_3
    //   48: invokevirtual 37	android/os/Parcel:readException	()V
    //   51: aload_3
    //   52: invokevirtual 55	android/os/Parcel:recycle	()V
    //   55: aload_2
    //   56: invokevirtual 55	android/os/Parcel:recycle	()V
    //   59: return
    //   60: aconst_null
    //   61: astore 5
    //   63: goto -37 -> 26
    //   66: astore 4
    //   68: aload_3
    //   69: invokevirtual 55	android/os/Parcel:recycle	()V
    //   72: aload_2
    //   73: invokevirtual 55	android/os/Parcel:recycle	()V
    //   76: aload 4
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	ki
    //   0	79	1	paramly	ly
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
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      if (paramBoolean) {
        i = 1;
      }
      localParcel1.writeInt(i);
      this.a.transact(18, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public float b()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      this.a.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      float f = localParcel2.readFloat();
      return f;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public void b(android.os.Bundle paramBundle)
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
    //   15: ifnull +54 -> 69
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 133	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	ki:a	Landroid/os/IBinder;
    //   33: bipush 60
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 34 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 37	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 41	android/os/Parcel:readInt	()I
    //   52: ifeq +8 -> 60
    //   55: aload_1
    //   56: aload_3
    //   57: invokevirtual 226	android/os/Bundle:readFromParcel	(Landroid/os/Parcel;)V
    //   60: aload_3
    //   61: invokevirtual 55	android/os/Parcel:recycle	()V
    //   64: aload_2
    //   65: invokevirtual 55	android/os/Parcel:recycle	()V
    //   68: return
    //   69: aload_2
    //   70: iconst_0
    //   71: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   74: goto -45 -> 29
    //   77: astore 4
    //   79: aload_3
    //   80: invokevirtual 55	android/os/Parcel:recycle	()V
    //   83: aload_2
    //   84: invokevirtual 55	android/os/Parcel:recycle	()V
    //   87: aload 4
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	ki
    //   0	90	1	paramBundle	android.os.Bundle
    //   3	81	2	localParcel1	Parcel
    //   7	73	3	localParcel2	Parcel
    //   77	11	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	60	77	finally
    //   69	74	77	finally
  }
  
  /* Error */
  public void b(c paramc)
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
    //   20: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 137	com/google/android/gms/maps/model/internal/c:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	ki:a	Landroid/os/IBinder;
    //   33: bipush 65
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 34 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 37	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 55	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 55	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aload_2
    //   58: iconst_0
    //   59: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   62: goto -33 -> 29
    //   65: astore 4
    //   67: aload_3
    //   68: invokevirtual 55	android/os/Parcel:recycle	()V
    //   71: aload_2
    //   72: invokevirtual 55	android/os/Parcel:recycle	()V
    //   75: aload 4
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	ki
    //   0	78	1	paramc	c
    //   3	69	2	localParcel1	Parcel
    //   7	61	3	localParcel2	Parcel
    //   65	11	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	48	65	finally
    //   57	62	65	finally
  }
  
  /* Error */
  public void b(gU paramgU)
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
    //   15: ifnull +44 -> 59
    //   18: aload_1
    //   19: invokeinterface 151 1 0
    //   24: astore 5
    //   26: aload_2
    //   27: aload 5
    //   29: invokevirtual 146	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   32: aload_0
    //   33: getfield 15	ki:a	Landroid/os/IBinder;
    //   36: iconst_5
    //   37: aload_2
    //   38: aload_3
    //   39: iconst_0
    //   40: invokeinterface 34 5 0
    //   45: pop
    //   46: aload_3
    //   47: invokevirtual 37	android/os/Parcel:readException	()V
    //   50: aload_3
    //   51: invokevirtual 55	android/os/Parcel:recycle	()V
    //   54: aload_2
    //   55: invokevirtual 55	android/os/Parcel:recycle	()V
    //   58: return
    //   59: aconst_null
    //   60: astore 5
    //   62: goto -36 -> 26
    //   65: astore 4
    //   67: aload_3
    //   68: invokevirtual 55	android/os/Parcel:recycle	()V
    //   71: aload_2
    //   72: invokevirtual 55	android/os/Parcel:recycle	()V
    //   75: aload 4
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	ki
    //   0	78	1	paramgU	gU
    //   3	69	2	localParcel1	Parcel
    //   7	61	3	localParcel2	Parcel
    //   65	11	4	localObject	Object
    //   24	37	5	localIBinder	IBinder
    // Exception table:
    //   from	to	target	type
    //   8	50	65	finally
  }
  
  /* Error */
  public boolean b(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore_3
    //   6: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore 4
    //   11: aload_3
    //   12: ldc 24
    //   14: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: iload_1
    //   18: ifeq +56 -> 74
    //   21: iload_2
    //   22: istore 6
    //   24: aload_3
    //   25: iload 6
    //   27: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   30: aload_0
    //   31: getfield 15	ki:a	Landroid/os/IBinder;
    //   34: bipush 20
    //   36: aload_3
    //   37: aload 4
    //   39: iconst_0
    //   40: invokeinterface 34 5 0
    //   45: pop
    //   46: aload 4
    //   48: invokevirtual 37	android/os/Parcel:readException	()V
    //   51: aload 4
    //   53: invokevirtual 41	android/os/Parcel:readInt	()I
    //   56: istore 8
    //   58: iload 8
    //   60: ifeq +20 -> 80
    //   63: aload 4
    //   65: invokevirtual 55	android/os/Parcel:recycle	()V
    //   68: aload_3
    //   69: invokevirtual 55	android/os/Parcel:recycle	()V
    //   72: iload_2
    //   73: ireturn
    //   74: iconst_0
    //   75: istore 6
    //   77: goto -53 -> 24
    //   80: iconst_0
    //   81: istore_2
    //   82: goto -19 -> 63
    //   85: astore 5
    //   87: aload 4
    //   89: invokevirtual 55	android/os/Parcel:recycle	()V
    //   92: aload_3
    //   93: invokevirtual 55	android/os/Parcel:recycle	()V
    //   96: aload 5
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	ki
    //   0	99	1	paramBoolean	boolean
    //   1	81	2	i	int
    //   5	88	3	localParcel1	Parcel
    //   9	79	4	localParcel2	Parcel
    //   85	12	5	localObject	Object
    //   22	4	6	j	int
    //   75	1	6	k	int
    //   56	3	8	m	int
    // Exception table:
    //   from	to	target	type
    //   11	58	85	finally
  }
  
  public float c()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      this.a.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      float f = localParcel2.readFloat();
      return f;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    int i = 0;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      if (paramBoolean) {
        i = 1;
      }
      localParcel1.writeInt(i);
      this.a.transact(22, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void d()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      this.a.transact(8, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    int i = 0;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      if (paramBoolean) {
        i = 1;
      }
      localParcel1.writeInt(i);
      this.a.transact(41, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void e()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      this.a.transact(14, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public int f()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      this.a.transact(15, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean g()
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      this.a.transact(17, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean h()
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      this.a.transact(19, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean i()
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      this.a.transact(21, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public android.location.Location j()
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
    //   15: getfield 15	ki:a	Landroid/os/IBinder;
    //   18: bipush 23
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
    //   40: getstatic 242	android/location/Location:CREATOR	Landroid/os/Parcelable$Creator;
    //   43: aload_2
    //   44: invokeinterface 248 2 0
    //   49: checkcast 239	android/location/Location
    //   52: astore 5
    //   54: aload_2
    //   55: invokevirtual 55	android/os/Parcel:recycle	()V
    //   58: aload_1
    //   59: invokevirtual 55	android/os/Parcel:recycle	()V
    //   62: aload 5
    //   64: areturn
    //   65: aconst_null
    //   66: astore 5
    //   68: goto -14 -> 54
    //   71: astore_3
    //   72: aload_2
    //   73: invokevirtual 55	android/os/Parcel:recycle	()V
    //   76: aload_1
    //   77: invokevirtual 55	android/os/Parcel:recycle	()V
    //   80: aload_3
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	ki
    //   3	74	1	localParcel1	Parcel
    //   7	66	2	localParcel2	Parcel
    //   71	10	3	localObject	Object
    //   52	15	5	localLocation	android.location.Location
    // Exception table:
    //   from	to	target	type
    //   8	54	71	finally
  }
  
  public kE k()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      this.a.transact(25, localParcel1, localParcel2, 0);
      localParcel2.readException();
      kE localkE = kF.a(localParcel2.readStrongBinder());
      return localkE;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public ks l()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      this.a.transact(26, localParcel1, localParcel2, 0);
      localParcel2.readException();
      ks localks = kt.a(localParcel2.readStrongBinder());
      return localks;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean m()
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      this.a.transact(40, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public mF n()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      this.a.transact(44, localParcel1, localParcel2, 0);
      localParcel2.readException();
      mF localmF = mG.a(localParcel2.readStrongBinder());
      return localmF;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void o()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      this.a.transact(55, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void p()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      this.a.transact(56, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void q()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      this.a.transact(57, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void r()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      this.a.transact(58, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean s()
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      this.a.transact(59, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ki
 * JD-Core Version:    0.7.0.1
 */