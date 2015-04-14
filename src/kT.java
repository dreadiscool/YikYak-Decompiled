import android.os.IBinder;

class kT
  implements kR
{
  private IBinder a;
  
  kT(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public gU a(mI parammI)
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
    //   15: ifnull +55 -> 70
    //   18: aload_1
    //   19: invokeinterface 34 1 0
    //   24: astore 5
    //   26: aload_2
    //   27: aload 5
    //   29: invokevirtual 37	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   32: aload_0
    //   33: getfield 15	kT:a	Landroid/os/IBinder;
    //   36: iconst_1
    //   37: aload_2
    //   38: aload_3
    //   39: iconst_0
    //   40: invokeinterface 43 5 0
    //   45: pop
    //   46: aload_3
    //   47: invokevirtual 46	android/os/Parcel:readException	()V
    //   50: aload_3
    //   51: invokevirtual 49	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   54: invokestatic 54	gV:a	(Landroid/os/IBinder;)LgU;
    //   57: astore 7
    //   59: aload_3
    //   60: invokevirtual 57	android/os/Parcel:recycle	()V
    //   63: aload_2
    //   64: invokevirtual 57	android/os/Parcel:recycle	()V
    //   67: aload 7
    //   69: areturn
    //   70: aconst_null
    //   71: astore 5
    //   73: goto -47 -> 26
    //   76: astore 4
    //   78: aload_3
    //   79: invokevirtual 57	android/os/Parcel:recycle	()V
    //   82: aload_2
    //   83: invokevirtual 57	android/os/Parcel:recycle	()V
    //   86: aload 4
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	kT
    //   0	89	1	parammI	mI
    //   3	80	2	localParcel1	android.os.Parcel
    //   7	72	3	localParcel2	android.os.Parcel
    //   76	11	4	localObject	Object
    //   24	48	5	localIBinder	IBinder
    //   57	11	7	localgU	gU
    // Exception table:
    //   from	to	target	type
    //   8	59	76	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  /* Error */
  public gU b(mI parammI)
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
    //   15: ifnull +55 -> 70
    //   18: aload_1
    //   19: invokeinterface 34 1 0
    //   24: astore 5
    //   26: aload_2
    //   27: aload 5
    //   29: invokevirtual 37	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   32: aload_0
    //   33: getfield 15	kT:a	Landroid/os/IBinder;
    //   36: iconst_2
    //   37: aload_2
    //   38: aload_3
    //   39: iconst_0
    //   40: invokeinterface 43 5 0
    //   45: pop
    //   46: aload_3
    //   47: invokevirtual 46	android/os/Parcel:readException	()V
    //   50: aload_3
    //   51: invokevirtual 49	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   54: invokestatic 54	gV:a	(Landroid/os/IBinder;)LgU;
    //   57: astore 7
    //   59: aload_3
    //   60: invokevirtual 57	android/os/Parcel:recycle	()V
    //   63: aload_2
    //   64: invokevirtual 57	android/os/Parcel:recycle	()V
    //   67: aload 7
    //   69: areturn
    //   70: aconst_null
    //   71: astore 5
    //   73: goto -47 -> 26
    //   76: astore 4
    //   78: aload_3
    //   79: invokevirtual 57	android/os/Parcel:recycle	()V
    //   82: aload_2
    //   83: invokevirtual 57	android/os/Parcel:recycle	()V
    //   86: aload 4
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	kT
    //   0	89	1	parammI	mI
    //   3	80	2	localParcel1	android.os.Parcel
    //   7	72	3	localParcel2	android.os.Parcel
    //   76	11	4	localObject	Object
    //   24	48	5	localIBinder	IBinder
    //   57	11	7	localgU	gU
    // Exception table:
    //   from	to	target	type
    //   8	59	76	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     kT
 * JD-Core Version:    0.7.0.1
 */