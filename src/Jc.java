import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

final class Jc
  implements IInterface
{
  private final IBinder a;
  
  public Jc(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public String a()
  {
    localParcel1 = Parcel.obtain();
    localParcel2 = Parcel.obtain();
    Object localObject1 = null;
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
      this.a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      localObject1 = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        IC.g();
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    return localObject1;
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public boolean b()
  {
    bool = true;
    localParcel1 = Parcel.obtain();
    localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        localParcel1.writeInt(1);
        this.a.transact(2, localParcel1, localParcel2, 0);
        localParcel2.readException();
        int i = localParcel2.readInt();
        if (i == 0) {
          continue;
        }
      }
      catch (Exception localException)
      {
        IC.g();
        localParcel2.recycle();
        localParcel1.recycle();
        bool = false;
        continue;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      return bool;
      bool = false;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Jc
 * JD-Core Version:    0.7.0.1
 */