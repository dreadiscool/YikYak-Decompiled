import android.os.IBinder;

class lx
  implements lv
{
  private IBinder a;
  
  lx(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public boolean a(mI parammI)
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
    //   17: aload_1
    //   18: ifnull +60 -> 78
    //   21: aload_1
    //   22: invokeinterface 34 1 0
    //   27: astore 6
    //   29: aload_3
    //   30: aload 6
    //   32: invokevirtual 37	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   35: aload_0
    //   36: getfield 15	lx:a	Landroid/os/IBinder;
    //   39: iconst_1
    //   40: aload_3
    //   41: aload 4
    //   43: iconst_0
    //   44: invokeinterface 43 5 0
    //   49: pop
    //   50: aload 4
    //   52: invokevirtual 46	android/os/Parcel:readException	()V
    //   55: aload 4
    //   57: invokevirtual 50	android/os/Parcel:readInt	()I
    //   60: istore 8
    //   62: iload 8
    //   64: ifeq +20 -> 84
    //   67: aload 4
    //   69: invokevirtual 53	android/os/Parcel:recycle	()V
    //   72: aload_3
    //   73: invokevirtual 53	android/os/Parcel:recycle	()V
    //   76: iload_2
    //   77: ireturn
    //   78: aconst_null
    //   79: astore 6
    //   81: goto -52 -> 29
    //   84: iconst_0
    //   85: istore_2
    //   86: goto -19 -> 67
    //   89: astore 5
    //   91: aload 4
    //   93: invokevirtual 53	android/os/Parcel:recycle	()V
    //   96: aload_3
    //   97: invokevirtual 53	android/os/Parcel:recycle	()V
    //   100: aload 5
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	lx
    //   0	103	1	parammI	mI
    //   1	85	2	bool	boolean
    //   5	92	3	localParcel1	android.os.Parcel
    //   9	83	4	localParcel2	android.os.Parcel
    //   89	12	5	localObject	Object
    //   27	53	6	localIBinder	IBinder
    //   60	3	8	i	int
    // Exception table:
    //   from	to	target	type
    //   11	62	89	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     lx
 * JD-Core Version:    0.7.0.1
 */