import android.os.IBinder;

class jc
  implements ja
{
  private IBinder a;
  
  jc(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public void a(com.google.android.gms.common.data.DataHolder paramDataHolder)
  {
    // Byte code:
    //   0: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: aload_2
    //   5: ldc 24
    //   7: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_1
    //   11: ifnull +33 -> 44
    //   14: aload_2
    //   15: iconst_1
    //   16: invokevirtual 32	android/os/Parcel:writeInt	(I)V
    //   19: aload_1
    //   20: aload_2
    //   21: iconst_0
    //   22: invokevirtual 38	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
    //   25: aload_0
    //   26: getfield 15	jc:a	Landroid/os/IBinder;
    //   29: iconst_1
    //   30: aload_2
    //   31: aconst_null
    //   32: iconst_1
    //   33: invokeinterface 44 5 0
    //   38: pop
    //   39: aload_2
    //   40: invokevirtual 47	android/os/Parcel:recycle	()V
    //   43: return
    //   44: aload_2
    //   45: iconst_0
    //   46: invokevirtual 32	android/os/Parcel:writeInt	(I)V
    //   49: goto -24 -> 25
    //   52: astore_3
    //   53: aload_2
    //   54: invokevirtual 47	android/os/Parcel:recycle	()V
    //   57: aload_3
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	jc
    //   0	59	1	paramDataHolder	com.google.android.gms.common.data.DataHolder
    //   3	51	2	localParcel	android.os.Parcel
    //   52	6	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	39	52	finally
    //   44	49	52	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  /* Error */
  public void b(com.google.android.gms.common.data.DataHolder paramDataHolder)
  {
    // Byte code:
    //   0: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: aload_2
    //   5: ldc 24
    //   7: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_1
    //   11: ifnull +33 -> 44
    //   14: aload_2
    //   15: iconst_1
    //   16: invokevirtual 32	android/os/Parcel:writeInt	(I)V
    //   19: aload_1
    //   20: aload_2
    //   21: iconst_0
    //   22: invokevirtual 38	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
    //   25: aload_0
    //   26: getfield 15	jc:a	Landroid/os/IBinder;
    //   29: iconst_2
    //   30: aload_2
    //   31: aconst_null
    //   32: iconst_1
    //   33: invokeinterface 44 5 0
    //   38: pop
    //   39: aload_2
    //   40: invokevirtual 47	android/os/Parcel:recycle	()V
    //   43: return
    //   44: aload_2
    //   45: iconst_0
    //   46: invokevirtual 32	android/os/Parcel:writeInt	(I)V
    //   49: goto -24 -> 25
    //   52: astore_3
    //   53: aload_2
    //   54: invokevirtual 47	android/os/Parcel:recycle	()V
    //   57: aload_3
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	jc
    //   0	59	1	paramDataHolder	com.google.android.gms.common.data.DataHolder
    //   3	51	2	localParcel	android.os.Parcel
    //   52	6	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	39	52	finally
    //   44	49	52	finally
  }
  
  /* Error */
  public void c(com.google.android.gms.common.data.DataHolder paramDataHolder)
  {
    // Byte code:
    //   0: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: aload_2
    //   5: ldc 24
    //   7: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_1
    //   11: ifnull +33 -> 44
    //   14: aload_2
    //   15: iconst_1
    //   16: invokevirtual 32	android/os/Parcel:writeInt	(I)V
    //   19: aload_1
    //   20: aload_2
    //   21: iconst_0
    //   22: invokevirtual 38	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
    //   25: aload_0
    //   26: getfield 15	jc:a	Landroid/os/IBinder;
    //   29: iconst_3
    //   30: aload_2
    //   31: aconst_null
    //   32: iconst_1
    //   33: invokeinterface 44 5 0
    //   38: pop
    //   39: aload_2
    //   40: invokevirtual 47	android/os/Parcel:recycle	()V
    //   43: return
    //   44: aload_2
    //   45: iconst_0
    //   46: invokevirtual 32	android/os/Parcel:writeInt	(I)V
    //   49: goto -24 -> 25
    //   52: astore_3
    //   53: aload_2
    //   54: invokevirtual 47	android/os/Parcel:recycle	()V
    //   57: aload_3
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	jc
    //   0	59	1	paramDataHolder	com.google.android.gms.common.data.DataHolder
    //   3	51	2	localParcel	android.os.Parcel
    //   52	6	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	39	52	finally
    //   44	49	52	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     jc
 * JD-Core Version:    0.7.0.1
 */