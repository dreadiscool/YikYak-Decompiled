import android.os.IBinder;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

class mH
  implements mF
{
  private IBinder a;
  
  mH(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public int a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
      this.a.transact(1, localParcel1, localParcel2, 0);
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
  
  /* Error */
  public boolean a(mF parammF)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore_3
    //   6: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore 4
    //   11: aload_3
    //   12: ldc 24
    //   14: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_1
    //   18: ifnull +62 -> 80
    //   21: aload_1
    //   22: invokeinterface 48 1 0
    //   27: astore 6
    //   29: aload_3
    //   30: aload 6
    //   32: invokevirtual 51	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   35: aload_0
    //   36: getfield 15	mH:a	Landroid/os/IBinder;
    //   39: iconst_5
    //   40: aload_3
    //   41: aload 4
    //   43: iconst_0
    //   44: invokeinterface 34 5 0
    //   49: pop
    //   50: aload 4
    //   52: invokevirtual 37	android/os/Parcel:readException	()V
    //   55: aload 4
    //   57: invokevirtual 40	android/os/Parcel:readInt	()I
    //   60: istore 8
    //   62: iload 8
    //   64: ifeq +5 -> 69
    //   67: iconst_1
    //   68: istore_2
    //   69: aload 4
    //   71: invokevirtual 43	android/os/Parcel:recycle	()V
    //   74: aload_3
    //   75: invokevirtual 43	android/os/Parcel:recycle	()V
    //   78: iload_2
    //   79: ireturn
    //   80: aconst_null
    //   81: astore 6
    //   83: goto -54 -> 29
    //   86: astore 5
    //   88: aload 4
    //   90: invokevirtual 43	android/os/Parcel:recycle	()V
    //   93: aload_3
    //   94: invokevirtual 43	android/os/Parcel:recycle	()V
    //   97: aload 5
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	mH
    //   0	100	1	parammF	mF
    //   1	78	2	bool	boolean
    //   5	89	3	localParcel1	Parcel
    //   9	80	4	localParcel2	Parcel
    //   86	12	5	localObject	Object
    //   27	55	6	localIBinder	IBinder
    //   60	3	8	i	int
    // Exception table:
    //   from	to	target	type
    //   11	62	86	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public int b()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
      this.a.transact(2, localParcel1, localParcel2, 0);
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
  
  public List<IBinder> c()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
      this.a.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      ArrayList localArrayList = localParcel2.createBinderArrayList();
      return localArrayList;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean d()
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
      this.a.transact(4, localParcel1, localParcel2, 0);
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
  
  public int e()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
      this.a.transact(6, localParcel1, localParcel2, 0);
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
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     mH
 * JD-Core Version:    0.7.0.1
 */