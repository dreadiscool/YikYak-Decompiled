import android.os.IBinder;

class lG
  implements lE
{
  private IBinder a;
  
  lG(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public void a(android.location.Location paramLocation)
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
    //   20: invokevirtual 32	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 38	android/location/Location:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	lG:a	Landroid/os/IBinder;
    //   33: iconst_2
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: invokeinterface 44 5 0
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 47	android/os/Parcel:readException	()V
    //   47: aload_3
    //   48: invokevirtual 50	android/os/Parcel:recycle	()V
    //   51: aload_2
    //   52: invokevirtual 50	android/os/Parcel:recycle	()V
    //   55: return
    //   56: aload_2
    //   57: iconst_0
    //   58: invokevirtual 32	android/os/Parcel:writeInt	(I)V
    //   61: goto -32 -> 29
    //   64: astore 4
    //   66: aload_3
    //   67: invokevirtual 50	android/os/Parcel:recycle	()V
    //   70: aload_2
    //   71: invokevirtual 50	android/os/Parcel:recycle	()V
    //   74: aload 4
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	lG
    //   0	77	1	paramLocation	android.location.Location
    //   3	68	2	localParcel1	android.os.Parcel
    //   7	60	3	localParcel2	android.os.Parcel
    //   64	11	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	47	64	finally
    //   56	61	64	finally
  }
  
  /* Error */
  public void a(gU paramgU)
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
    //   19: invokeinterface 57 1 0
    //   24: astore 5
    //   26: aload_2
    //   27: aload 5
    //   29: invokevirtual 60	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   32: aload_0
    //   33: getfield 15	lG:a	Landroid/os/IBinder;
    //   36: iconst_1
    //   37: aload_2
    //   38: aload_3
    //   39: iconst_0
    //   40: invokeinterface 44 5 0
    //   45: pop
    //   46: aload_3
    //   47: invokevirtual 47	android/os/Parcel:readException	()V
    //   50: aload_3
    //   51: invokevirtual 50	android/os/Parcel:recycle	()V
    //   54: aload_2
    //   55: invokevirtual 50	android/os/Parcel:recycle	()V
    //   58: return
    //   59: aconst_null
    //   60: astore 5
    //   62: goto -36 -> 26
    //   65: astore 4
    //   67: aload_3
    //   68: invokevirtual 50	android/os/Parcel:recycle	()V
    //   71: aload_2
    //   72: invokevirtual 50	android/os/Parcel:recycle	()V
    //   75: aload 4
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	lG
    //   0	78	1	paramgU	gU
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
 * Qualified Name:     lG
 * JD-Core Version:    0.7.0.1
 */