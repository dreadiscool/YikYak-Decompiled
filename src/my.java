import android.os.IBinder;
import android.os.Parcel;

class my
  implements mw
{
  private IBinder a;
  
  my(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public gU a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
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
  
  public gU a(float paramFloat)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
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
  
  public gU a(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
      localParcel1.writeInt(paramInt);
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
  
  /* Error */
  public gU a(android.graphics.Bitmap paramBitmap)
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
    //   20: invokevirtual 59	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 66	android/graphics/Bitmap:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	my:a	Landroid/os/IBinder;
    //   33: bipush 6
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
    //   70: invokevirtual 59	android/os/Parcel:writeInt	(I)V
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
    //   0	89	0	this	my
    //   0	89	1	paramBitmap	android.graphics.Bitmap
    //   3	80	2	localParcel1	Parcel
    //   7	72	3	localParcel2	Parcel
    //   76	11	4	localObject	Object
    //   55	11	6	localgU	gU
    // Exception table:
    //   from	to	target	type
    //   8	57	76	finally
    //   68	73	76	finally
  }
  
  public gU a(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
      localParcel1.writeString(paramString);
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
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public gU b(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
      localParcel1.writeString(paramString);
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
  
  public gU c(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
      localParcel1.writeString(paramString);
      this.a.transact(7, localParcel1, localParcel2, 0);
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
 * Qualified Name:     my
 * JD-Core Version:    0.7.0.1
 */