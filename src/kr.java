import android.os.IBinder;
import android.os.Parcel;

class kr
  implements kp
{
  private IBinder a;
  
  kr(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public kg a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
      this.a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      kg localkg = kh.a(localParcel2.readStrongBinder());
      return localkg;
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
    //   15: ifnull +41 -> 56
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 54	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 60	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	kr:a	Landroid/os/IBinder;
    //   33: iconst_2
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: invokeinterface 34 5 0
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 37	android/os/Parcel:readException	()V
    //   47: aload_3
    //   48: invokevirtual 49	android/os/Parcel:recycle	()V
    //   51: aload_2
    //   52: invokevirtual 49	android/os/Parcel:recycle	()V
    //   55: return
    //   56: aload_2
    //   57: iconst_0
    //   58: invokevirtual 54	android/os/Parcel:writeInt	(I)V
    //   61: goto -32 -> 29
    //   64: astore 4
    //   66: aload_3
    //   67: invokevirtual 49	android/os/Parcel:recycle	()V
    //   70: aload_2
    //   71: invokevirtual 49	android/os/Parcel:recycle	()V
    //   74: aload 4
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	kr
    //   0	77	1	paramBundle	android.os.Bundle
    //   3	68	2	localParcel1	Parcel
    //   7	60	3	localParcel2	Parcel
    //   64	11	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	47	64	finally
    //   56	61	64	finally
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
    //   19: invokeinterface 66 1 0
    //   24: astore 5
    //   26: aload_2
    //   27: aload 5
    //   29: invokevirtual 69	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   32: aload_0
    //   33: getfield 15	kr:a	Landroid/os/IBinder;
    //   36: bipush 9
    //   38: aload_2
    //   39: aload_3
    //   40: iconst_0
    //   41: invokeinterface 34 5 0
    //   46: pop
    //   47: aload_3
    //   48: invokevirtual 37	android/os/Parcel:readException	()V
    //   51: aload_3
    //   52: invokevirtual 49	android/os/Parcel:recycle	()V
    //   55: aload_2
    //   56: invokevirtual 49	android/os/Parcel:recycle	()V
    //   59: return
    //   60: aconst_null
    //   61: astore 5
    //   63: goto -37 -> 26
    //   66: astore 4
    //   68: aload_3
    //   69: invokevirtual 49	android/os/Parcel:recycle	()V
    //   72: aload_2
    //   73: invokevirtual 49	android/os/Parcel:recycle	()V
    //   76: aload 4
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	kr
    //   0	79	1	paramls	ls
    //   3	70	2	localParcel1	Parcel
    //   7	62	3	localParcel2	Parcel
    //   66	11	4	localObject	Object
    //   24	38	5	localIBinder	IBinder
    // Exception table:
    //   from	to	target	type
    //   8	51	66	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public void b()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
      this.a.transact(3, localParcel1, localParcel2, 0);
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
    //   20: invokevirtual 54	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 60	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	kr:a	Landroid/os/IBinder;
    //   33: bipush 7
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 34 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 37	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 74	android/os/Parcel:readInt	()I
    //   52: ifeq +8 -> 60
    //   55: aload_1
    //   56: aload_3
    //   57: invokevirtual 78	android/os/Bundle:readFromParcel	(Landroid/os/Parcel;)V
    //   60: aload_3
    //   61: invokevirtual 49	android/os/Parcel:recycle	()V
    //   64: aload_2
    //   65: invokevirtual 49	android/os/Parcel:recycle	()V
    //   68: return
    //   69: aload_2
    //   70: iconst_0
    //   71: invokevirtual 54	android/os/Parcel:writeInt	(I)V
    //   74: goto -45 -> 29
    //   77: astore 4
    //   79: aload_3
    //   80: invokevirtual 49	android/os/Parcel:recycle	()V
    //   83: aload_2
    //   84: invokevirtual 49	android/os/Parcel:recycle	()V
    //   87: aload 4
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	kr
    //   0	90	1	paramBundle	android.os.Bundle
    //   3	81	2	localParcel1	Parcel
    //   7	73	3	localParcel2	Parcel
    //   77	11	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	60	77	finally
    //   69	74	77	finally
  }
  
  public void c()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
      this.a.transact(4, localParcel1, localParcel2, 0);
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
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
      this.a.transact(5, localParcel1, localParcel2, 0);
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
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
      this.a.transact(6, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public gU f()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
      this.a.transact(8, localParcel1, localParcel2, 0);
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
 * Qualified Name:     kr
 * JD-Core Version:    0.7.0.1
 */