import android.os.IBinder;

class lD
  implements lB
{
  private IBinder a;
  
  lD(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore_2
    //   6: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore_3
    //   10: aload_2
    //   11: ldc 24
    //   13: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: getfield 15	lD:a	Landroid/os/IBinder;
    //   20: iconst_1
    //   21: aload_2
    //   22: aload_3
    //   23: iconst_0
    //   24: invokeinterface 34 5 0
    //   29: pop
    //   30: aload_3
    //   31: invokevirtual 37	android/os/Parcel:readException	()V
    //   34: aload_3
    //   35: invokevirtual 41	android/os/Parcel:readInt	()I
    //   38: istore 6
    //   40: iload 6
    //   42: ifeq +13 -> 55
    //   45: aload_3
    //   46: invokevirtual 44	android/os/Parcel:recycle	()V
    //   49: aload_2
    //   50: invokevirtual 44	android/os/Parcel:recycle	()V
    //   53: iload_1
    //   54: ireturn
    //   55: iconst_0
    //   56: istore_1
    //   57: goto -12 -> 45
    //   60: astore 4
    //   62: aload_3
    //   63: invokevirtual 44	android/os/Parcel:recycle	()V
    //   66: aload_2
    //   67: invokevirtual 44	android/os/Parcel:recycle	()V
    //   70: aload 4
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	lD
    //   1	56	1	bool	boolean
    //   5	62	2	localParcel1	android.os.Parcel
    //   9	54	3	localParcel2	android.os.Parcel
    //   60	11	4	localObject	Object
    //   38	3	6	i	int
    // Exception table:
    //   from	to	target	type
    //   10	40	60	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     lD
 * JD-Core Version:    0.7.0.1
 */