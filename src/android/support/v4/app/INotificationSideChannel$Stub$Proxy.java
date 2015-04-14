package android.support.v4.app;

import android.os.IBinder;
import android.os.Parcel;

class INotificationSideChannel$Stub$Proxy
  implements INotificationSideChannel
{
  private IBinder mRemote;
  
  INotificationSideChannel$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public void cancel(String paramString1, int paramInt, String paramString2)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
      localParcel.writeString(paramString1);
      localParcel.writeInt(paramInt);
      localParcel.writeString(paramString2);
      this.mRemote.transact(2, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void cancelAll(String paramString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
      localParcel.writeString(paramString);
      this.mRemote.transact(3, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public String getInterfaceDescriptor()
  {
    return "android.support.v4.app.INotificationSideChannel";
  }
  
  /* Error */
  public void notify(String paramString1, int paramInt, String paramString2, android.app.Notification paramNotification)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 5
    //   5: aload 5
    //   7: ldc 27
    //   9: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   12: aload 5
    //   14: aload_1
    //   15: invokevirtual 34	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   18: aload 5
    //   20: iload_2
    //   21: invokevirtual 38	android/os/Parcel:writeInt	(I)V
    //   24: aload 5
    //   26: aload_3
    //   27: invokevirtual 34	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   30: aload 4
    //   32: ifnull +38 -> 70
    //   35: aload 5
    //   37: iconst_1
    //   38: invokevirtual 38	android/os/Parcel:writeInt	(I)V
    //   41: aload 4
    //   43: aload 5
    //   45: iconst_0
    //   46: invokevirtual 58	android/app/Notification:writeToParcel	(Landroid/os/Parcel;I)V
    //   49: aload_0
    //   50: getfield 15	android/support/v4/app/INotificationSideChannel$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   53: iconst_1
    //   54: aload 5
    //   56: aconst_null
    //   57: iconst_1
    //   58: invokeinterface 44 5 0
    //   63: pop
    //   64: aload 5
    //   66: invokevirtual 47	android/os/Parcel:recycle	()V
    //   69: return
    //   70: aload 5
    //   72: iconst_0
    //   73: invokevirtual 38	android/os/Parcel:writeInt	(I)V
    //   76: goto -27 -> 49
    //   79: astore 6
    //   81: aload 5
    //   83: invokevirtual 47	android/os/Parcel:recycle	()V
    //   86: aload 6
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	Proxy
    //   0	89	1	paramString1	String
    //   0	89	2	paramInt	int
    //   0	89	3	paramString2	String
    //   0	89	4	paramNotification	android.app.Notification
    //   3	79	5	localParcel	Parcel
    //   79	8	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	64	79	finally
    //   70	76	79	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.INotificationSideChannel.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */