import android.os.IBinder;
import android.os.Parcel;

class lo
  implements lm
{
  private IBinder a;
  
  lo(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public void a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
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
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     lo
 * JD-Core Version:    0.7.0.1
 */