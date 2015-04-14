import android.os.IBinder;
import android.os.Parcel;

class kf
  implements kd
{
  private IBinder a;
  
  kf(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public gU a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
      this.a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      gU localgU = gV.a(localParcel2.readStrongBinder());
      return localgU;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public gU a(float paramFloat)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
      localParcel1.writeFloat(paramFloat);
      this.a.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      gU localgU = gV.a(localParcel2.readStrongBinder());
      return localgU;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public gU a(float paramFloat1, float paramFloat2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
      localParcel1.writeFloat(paramFloat1);
      localParcel1.writeFloat(paramFloat2);
      this.a.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      gU localgU = gV.a(localParcel2.readStrongBinder());
      return localgU;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public gU a(float paramFloat, int paramInt1, int paramInt2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
      localParcel1.writeFloat(paramFloat);
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      this.a.transact(6, localParcel1, localParcel2, 0);
      localParcel2.readException();
      gU localgU = gV.a(localParcel2.readStrongBinder());
      return localgU;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public gU a(com.google.android.gms.maps.model.CameraPosition paramCameraPosition)
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
    //   26: invokevirtual 67	com/google/android/gms/maps/model/CameraPosition:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	kf:a	Landroid/os/IBinder;
    //   33: bipush 7
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 34 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 37	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 41	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   52: invokestatic 46	gV:a	(Landroid/os/IBinder;)LgU;
    //   55: astore 6
    //   57: aload_3
    //   58: invokevirtual 49	android/os/Parcel:recycle	()V
    //   61: aload_2
    //   62: invokevirtual 49	android/os/Parcel:recycle	()V
    //   65: aload 6
    //   67: areturn
    //   68: aload_2
    //   69: iconst_0
    //   70: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   73: goto -44 -> 29
    //   76: astore 4
    //   78: aload_3
    //   79: invokevirtual 49	android/os/Parcel:recycle	()V
    //   82: aload_2
    //   83: invokevirtual 49	android/os/Parcel:recycle	()V
    //   86: aload 4
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	kf
    //   0	89	1	paramCameraPosition	com.google.android.gms.maps.model.CameraPosition
    //   3	80	2	localParcel1	Parcel
    //   7	72	3	localParcel2	Parcel
    //   76	11	4	localObject	Object
    //   55	11	6	localgU	gU
    // Exception table:
    //   from	to	target	type
    //   8	57	76	finally
    //   68	73	76	finally
  }
  
  /* Error */
  public gU a(com.google.android.gms.maps.model.LatLng paramLatLng)
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
    //   26: invokevirtual 71	com/google/android/gms/maps/model/LatLng:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	kf:a	Landroid/os/IBinder;
    //   33: bipush 8
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 34 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 37	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 41	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   52: invokestatic 46	gV:a	(Landroid/os/IBinder;)LgU;
    //   55: astore 6
    //   57: aload_3
    //   58: invokevirtual 49	android/os/Parcel:recycle	()V
    //   61: aload_2
    //   62: invokevirtual 49	android/os/Parcel:recycle	()V
    //   65: aload 6
    //   67: areturn
    //   68: aload_2
    //   69: iconst_0
    //   70: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   73: goto -44 -> 29
    //   76: astore 4
    //   78: aload_3
    //   79: invokevirtual 49	android/os/Parcel:recycle	()V
    //   82: aload_2
    //   83: invokevirtual 49	android/os/Parcel:recycle	()V
    //   86: aload 4
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	kf
    //   0	89	1	paramLatLng	com.google.android.gms.maps.model.LatLng
    //   3	80	2	localParcel1	Parcel
    //   7	72	3	localParcel2	Parcel
    //   76	11	4	localObject	Object
    //   55	11	6	localgU	gU
    // Exception table:
    //   from	to	target	type
    //   8	57	76	finally
    //   68	73	76	finally
  }
  
  /* Error */
  public gU a(com.google.android.gms.maps.model.LatLng paramLatLng, float paramFloat)
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
    //   16: ifnull +62 -> 78
    //   19: aload_3
    //   20: iconst_1
    //   21: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   24: aload_1
    //   25: aload_3
    //   26: iconst_0
    //   27: invokevirtual 71	com/google/android/gms/maps/model/LatLng:writeToParcel	(Landroid/os/Parcel;I)V
    //   30: aload_3
    //   31: fload_2
    //   32: invokevirtual 54	android/os/Parcel:writeFloat	(F)V
    //   35: aload_0
    //   36: getfield 15	kf:a	Landroid/os/IBinder;
    //   39: bipush 9
    //   41: aload_3
    //   42: aload 4
    //   44: iconst_0
    //   45: invokeinterface 34 5 0
    //   50: pop
    //   51: aload 4
    //   53: invokevirtual 37	android/os/Parcel:readException	()V
    //   56: aload 4
    //   58: invokevirtual 41	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   61: invokestatic 46	gV:a	(Landroid/os/IBinder;)LgU;
    //   64: astore 7
    //   66: aload 4
    //   68: invokevirtual 49	android/os/Parcel:recycle	()V
    //   71: aload_3
    //   72: invokevirtual 49	android/os/Parcel:recycle	()V
    //   75: aload 7
    //   77: areturn
    //   78: aload_3
    //   79: iconst_0
    //   80: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   83: goto -53 -> 30
    //   86: astore 5
    //   88: aload 4
    //   90: invokevirtual 49	android/os/Parcel:recycle	()V
    //   93: aload_3
    //   94: invokevirtual 49	android/os/Parcel:recycle	()V
    //   97: aload 5
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	kf
    //   0	100	1	paramLatLng	com.google.android.gms.maps.model.LatLng
    //   0	100	2	paramFloat	float
    //   3	91	3	localParcel1	Parcel
    //   7	82	4	localParcel2	Parcel
    //   86	12	5	localObject	Object
    //   64	12	7	localgU	gU
    // Exception table:
    //   from	to	target	type
    //   9	66	86	finally
    //   78	83	86	finally
  }
  
  /* Error */
  public gU a(com.google.android.gms.maps.model.LatLngBounds paramLatLngBounds, int paramInt)
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
    //   16: ifnull +62 -> 78
    //   19: aload_3
    //   20: iconst_1
    //   21: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   24: aload_1
    //   25: aload_3
    //   26: iconst_0
    //   27: invokevirtual 76	com/google/android/gms/maps/model/LatLngBounds:writeToParcel	(Landroid/os/Parcel;I)V
    //   30: aload_3
    //   31: iload_2
    //   32: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   35: aload_0
    //   36: getfield 15	kf:a	Landroid/os/IBinder;
    //   39: bipush 10
    //   41: aload_3
    //   42: aload 4
    //   44: iconst_0
    //   45: invokeinterface 34 5 0
    //   50: pop
    //   51: aload 4
    //   53: invokevirtual 37	android/os/Parcel:readException	()V
    //   56: aload 4
    //   58: invokevirtual 41	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   61: invokestatic 46	gV:a	(Landroid/os/IBinder;)LgU;
    //   64: astore 7
    //   66: aload 4
    //   68: invokevirtual 49	android/os/Parcel:recycle	()V
    //   71: aload_3
    //   72: invokevirtual 49	android/os/Parcel:recycle	()V
    //   75: aload 7
    //   77: areturn
    //   78: aload_3
    //   79: iconst_0
    //   80: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   83: goto -53 -> 30
    //   86: astore 5
    //   88: aload 4
    //   90: invokevirtual 49	android/os/Parcel:recycle	()V
    //   93: aload_3
    //   94: invokevirtual 49	android/os/Parcel:recycle	()V
    //   97: aload 5
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	kf
    //   0	100	1	paramLatLngBounds	com.google.android.gms.maps.model.LatLngBounds
    //   0	100	2	paramInt	int
    //   3	91	3	localParcel1	Parcel
    //   7	82	4	localParcel2	Parcel
    //   86	12	5	localObject	Object
    //   64	12	7	localgU	gU
    // Exception table:
    //   from	to	target	type
    //   9	66	86	finally
    //   78	83	86	finally
  }
  
  /* Error */
  public gU a(com.google.android.gms.maps.model.LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 5
    //   5: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 6
    //   10: aload 5
    //   12: ldc 24
    //   14: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_1
    //   18: ifnull +80 -> 98
    //   21: aload 5
    //   23: iconst_1
    //   24: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   27: aload_1
    //   28: aload 5
    //   30: iconst_0
    //   31: invokevirtual 76	com/google/android/gms/maps/model/LatLngBounds:writeToParcel	(Landroid/os/Parcel;I)V
    //   34: aload 5
    //   36: iload_2
    //   37: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   40: aload 5
    //   42: iload_3
    //   43: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   46: aload 5
    //   48: iload 4
    //   50: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   53: aload_0
    //   54: getfield 15	kf:a	Landroid/os/IBinder;
    //   57: bipush 11
    //   59: aload 5
    //   61: aload 6
    //   63: iconst_0
    //   64: invokeinterface 34 5 0
    //   69: pop
    //   70: aload 6
    //   72: invokevirtual 37	android/os/Parcel:readException	()V
    //   75: aload 6
    //   77: invokevirtual 41	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   80: invokestatic 46	gV:a	(Landroid/os/IBinder;)LgU;
    //   83: astore 9
    //   85: aload 6
    //   87: invokevirtual 49	android/os/Parcel:recycle	()V
    //   90: aload 5
    //   92: invokevirtual 49	android/os/Parcel:recycle	()V
    //   95: aload 9
    //   97: areturn
    //   98: aload 5
    //   100: iconst_0
    //   101: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   104: goto -70 -> 34
    //   107: astore 7
    //   109: aload 6
    //   111: invokevirtual 49	android/os/Parcel:recycle	()V
    //   114: aload 5
    //   116: invokevirtual 49	android/os/Parcel:recycle	()V
    //   119: aload 7
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	kf
    //   0	122	1	paramLatLngBounds	com.google.android.gms.maps.model.LatLngBounds
    //   0	122	2	paramInt1	int
    //   0	122	3	paramInt2	int
    //   0	122	4	paramInt3	int
    //   3	112	5	localParcel1	Parcel
    //   8	102	6	localParcel2	Parcel
    //   107	13	7	localObject	Object
    //   83	13	9	localgU	gU
    // Exception table:
    //   from	to	target	type
    //   10	85	107	finally
    //   98	104	107	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public gU b()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
      this.a.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      gU localgU = gV.a(localParcel2.readStrongBinder());
      return localgU;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public gU b(float paramFloat)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
      localParcel1.writeFloat(paramFloat);
      this.a.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      gU localgU = gV.a(localParcel2.readStrongBinder());
      return localgU;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     kf
 * JD-Core Version:    0.7.0.1
 */