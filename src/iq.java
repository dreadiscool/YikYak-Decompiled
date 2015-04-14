import android.os.IBinder;
import android.os.Parcel;

class iq
  implements io
{
  private IBinder a;
  
  iq(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public void a(il paramil)
  {
    IBinder localIBinder = null;
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonService");
      if (paramil != null) {
        localIBinder = paramil.asBinder();
      }
      localParcel.writeStrongBinder(localIBinder);
      this.a.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     iq
 * JD-Core Version:    0.7.0.1
 */