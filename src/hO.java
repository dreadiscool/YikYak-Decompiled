import android.os.IBinder;

class hO
  implements hM
{
  private IBinder a;
  
  hO(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public void a(int paramInt, IBinder paramIBinder, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 4
    //   5: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 5
    //   10: aload 4
    //   12: ldc 24
    //   14: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload 4
    //   19: iload_1
    //   20: invokevirtual 32	android/os/Parcel:writeInt	(I)V
    //   23: aload 4
    //   25: aload_2
    //   26: invokevirtual 35	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   29: aload_3
    //   30: ifnull +48 -> 78
    //   33: aload 4
    //   35: iconst_1
    //   36: invokevirtual 32	android/os/Parcel:writeInt	(I)V
    //   39: aload_3
    //   40: aload 4
    //   42: iconst_0
    //   43: invokevirtual 41	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   46: aload_0
    //   47: getfield 15	hO:a	Landroid/os/IBinder;
    //   50: iconst_1
    //   51: aload 4
    //   53: aload 5
    //   55: iconst_0
    //   56: invokeinterface 47 5 0
    //   61: pop
    //   62: aload 5
    //   64: invokevirtual 50	android/os/Parcel:readException	()V
    //   67: aload 5
    //   69: invokevirtual 53	android/os/Parcel:recycle	()V
    //   72: aload 4
    //   74: invokevirtual 53	android/os/Parcel:recycle	()V
    //   77: return
    //   78: aload 4
    //   80: iconst_0
    //   81: invokevirtual 32	android/os/Parcel:writeInt	(I)V
    //   84: goto -38 -> 46
    //   87: astore 6
    //   89: aload 5
    //   91: invokevirtual 53	android/os/Parcel:recycle	()V
    //   94: aload 4
    //   96: invokevirtual 53	android/os/Parcel:recycle	()V
    //   99: aload 6
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	hO
    //   0	102	1	paramInt	int
    //   0	102	2	paramIBinder	IBinder
    //   0	102	3	paramBundle	android.os.Bundle
    //   3	92	4	localParcel1	android.os.Parcel
    //   8	82	5	localParcel2	android.os.Parcel
    //   87	13	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	67	87	finally
    //   78	84	87	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     hO
 * JD-Core Version:    0.7.0.1
 */