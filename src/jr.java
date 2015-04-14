import android.os.IBinder;
import android.os.Parcel;

class jr
  implements jp
{
  private IBinder a;
  
  jr(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public String a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
      this.a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public String a(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
      localParcel1.writeString(paramString);
      this.a.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    int i = 0;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
      localParcel1.writeString(paramString);
      if (paramBoolean) {
        i = 1;
      }
      localParcel1.writeInt(i);
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
  
  /* Error */
  public boolean a(boolean paramBoolean)
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
    //   18: ifeq +55 -> 73
    //   21: iload_2
    //   22: istore 6
    //   24: aload_3
    //   25: iload 6
    //   27: invokevirtual 52	android/os/Parcel:writeInt	(I)V
    //   30: aload_0
    //   31: getfield 15	jr:a	Landroid/os/IBinder;
    //   34: iconst_2
    //   35: aload_3
    //   36: aload 4
    //   38: iconst_0
    //   39: invokeinterface 34 5 0
    //   44: pop
    //   45: aload 4
    //   47: invokevirtual 37	android/os/Parcel:readException	()V
    //   50: aload 4
    //   52: invokevirtual 57	android/os/Parcel:readInt	()I
    //   55: istore 8
    //   57: iload 8
    //   59: ifeq +20 -> 79
    //   62: aload 4
    //   64: invokevirtual 43	android/os/Parcel:recycle	()V
    //   67: aload_3
    //   68: invokevirtual 43	android/os/Parcel:recycle	()V
    //   71: iload_2
    //   72: ireturn
    //   73: iconst_0
    //   74: istore 6
    //   76: goto -52 -> 24
    //   79: iconst_0
    //   80: istore_2
    //   81: goto -19 -> 62
    //   84: astore 5
    //   86: aload 4
    //   88: invokevirtual 43	android/os/Parcel:recycle	()V
    //   91: aload_3
    //   92: invokevirtual 43	android/os/Parcel:recycle	()V
    //   95: aload 5
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	jr
    //   0	98	1	paramBoolean	boolean
    //   1	80	2	i	int
    //   5	87	3	localParcel1	Parcel
    //   9	78	4	localParcel2	Parcel
    //   84	12	5	localObject	Object
    //   22	4	6	j	int
    //   74	1	6	k	int
    //   55	3	8	m	int
    // Exception table:
    //   from	to	target	type
    //   11	57	84	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     jr
 * JD-Core Version:    0.7.0.1
 */