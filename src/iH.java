import android.os.IBinder;
import android.os.Parcel;

class iH
  implements iF
{
  private IBinder a;
  
  iH(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public void a(int paramInt, android.app.PendingIntent paramPendingIntent)
  {
    // Byte code:
    //   0: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 24
    //   12: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: iload_1
    //   17: invokevirtual 32	android/os/Parcel:writeInt	(I)V
    //   20: aload_2
    //   21: ifnull +44 -> 65
    //   24: aload_3
    //   25: iconst_1
    //   26: invokevirtual 32	android/os/Parcel:writeInt	(I)V
    //   29: aload_2
    //   30: aload_3
    //   31: iconst_0
    //   32: invokevirtual 38	android/app/PendingIntent:writeToParcel	(Landroid/os/Parcel;I)V
    //   35: aload_0
    //   36: getfield 15	iH:a	Landroid/os/IBinder;
    //   39: iconst_3
    //   40: aload_3
    //   41: aload 4
    //   43: iconst_0
    //   44: invokeinterface 44 5 0
    //   49: pop
    //   50: aload 4
    //   52: invokevirtual 47	android/os/Parcel:readException	()V
    //   55: aload 4
    //   57: invokevirtual 50	android/os/Parcel:recycle	()V
    //   60: aload_3
    //   61: invokevirtual 50	android/os/Parcel:recycle	()V
    //   64: return
    //   65: aload_3
    //   66: iconst_0
    //   67: invokevirtual 32	android/os/Parcel:writeInt	(I)V
    //   70: goto -35 -> 35
    //   73: astore 5
    //   75: aload 4
    //   77: invokevirtual 50	android/os/Parcel:recycle	()V
    //   80: aload_3
    //   81: invokevirtual 50	android/os/Parcel:recycle	()V
    //   84: aload 5
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	iH
    //   0	87	1	paramInt	int
    //   0	87	2	paramPendingIntent	android.app.PendingIntent
    //   3	78	3	localParcel1	Parcel
    //   7	69	4	localParcel2	Parcel
    //   73	12	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	55	73	finally
    //   65	70	73	finally
  }
  
  public void a(int paramInt, String[] paramArrayOfString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
      localParcel1.writeInt(paramInt);
      localParcel1.writeStringArray(paramArrayOfString);
      this.a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public void b(int paramInt, String[] paramArrayOfString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
      localParcel1.writeInt(paramInt);
      localParcel1.writeStringArray(paramArrayOfString);
      this.a.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     iH
 * JD-Core Version:    0.7.0.1
 */