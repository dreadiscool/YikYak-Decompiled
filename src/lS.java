import android.os.IBinder;

class lS
  implements lQ
{
  private IBinder a;
  
  lS(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public void a(kv paramkv)
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
    //   15: ifnull +44 -> 59
    //   18: aload_1
    //   19: invokeinterface 34 1 0
    //   24: astore 5
    //   26: aload_2
    //   27: aload 5
    //   29: invokevirtual 37	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   32: aload_0
    //   33: getfield 15	lS:a	Landroid/os/IBinder;
    //   36: iconst_1
    //   37: aload_2
    //   38: aload_3
    //   39: iconst_0
    //   40: invokeinterface 43 5 0
    //   45: pop
    //   46: aload_3
    //   47: invokevirtual 46	android/os/Parcel:readException	()V
    //   50: aload_3
    //   51: invokevirtual 49	android/os/Parcel:recycle	()V
    //   54: aload_2
    //   55: invokevirtual 49	android/os/Parcel:recycle	()V
    //   58: return
    //   59: aconst_null
    //   60: astore 5
    //   62: goto -36 -> 26
    //   65: astore 4
    //   67: aload_3
    //   68: invokevirtual 49	android/os/Parcel:recycle	()V
    //   71: aload_2
    //   72: invokevirtual 49	android/os/Parcel:recycle	()V
    //   75: aload 4
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	lS
    //   0	78	1	paramkv	kv
    //   3	69	2	localParcel1	android.os.Parcel
    //   7	61	3	localParcel2	android.os.Parcel
    //   65	11	4	localObject	Object
    //   24	37	5	localIBinder	IBinder
    // Exception table:
    //   from	to	target	type
    //   8	50	65	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     lS
 * JD-Core Version:    0.7.0.1
 */