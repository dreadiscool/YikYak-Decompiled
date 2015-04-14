import android.os.IBinder;

class kW
  implements kU
{
  private IBinder a;
  
  kW(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public android.graphics.Bitmap a(mI parammI, int paramInt1, int paramInt2)
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
    //   21: ifnull +87 -> 108
    //   24: aload_1
    //   25: invokeinterface 34 1 0
    //   30: astore 8
    //   32: aload 5
    //   34: aload 8
    //   36: invokevirtual 37	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   39: aload 5
    //   41: iload_2
    //   42: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   45: aload 5
    //   47: iload_3
    //   48: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   51: aload_0
    //   52: getfield 15	kW:a	Landroid/os/IBinder;
    //   55: iconst_1
    //   56: aload 5
    //   58: aload 6
    //   60: iconst_0
    //   61: invokeinterface 47 5 0
    //   66: pop
    //   67: aload 6
    //   69: invokevirtual 50	android/os/Parcel:readException	()V
    //   72: aload 6
    //   74: invokevirtual 54	android/os/Parcel:readInt	()I
    //   77: ifeq +18 -> 95
    //   80: getstatic 60	android/graphics/Bitmap:CREATOR	Landroid/os/Parcelable$Creator;
    //   83: aload 6
    //   85: invokeinterface 66 2 0
    //   90: checkcast 56	android/graphics/Bitmap
    //   93: astore 4
    //   95: aload 6
    //   97: invokevirtual 69	android/os/Parcel:recycle	()V
    //   100: aload 5
    //   102: invokevirtual 69	android/os/Parcel:recycle	()V
    //   105: aload 4
    //   107: areturn
    //   108: aconst_null
    //   109: astore 8
    //   111: goto -79 -> 32
    //   114: astore 7
    //   116: aload 6
    //   118: invokevirtual 69	android/os/Parcel:recycle	()V
    //   121: aload 5
    //   123: invokevirtual 69	android/os/Parcel:recycle	()V
    //   126: aload 7
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	kW
    //   0	129	1	parammI	mI
    //   0	129	2	paramInt1	int
    //   0	129	3	paramInt2	int
    //   1	105	4	localBitmap	android.graphics.Bitmap
    //   6	116	5	localParcel1	android.os.Parcel
    //   11	106	6	localParcel2	android.os.Parcel
    //   114	13	7	localObject	Object
    //   30	80	8	localIBinder	IBinder
    // Exception table:
    //   from	to	target	type
    //   13	95	114	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     kW
 * JD-Core Version:    0.7.0.1
 */