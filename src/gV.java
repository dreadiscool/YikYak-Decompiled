import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class gV
  extends Binder
  implements gU
{
  public gV()
  {
    attachInterface(this, "com.google.android.gms.dynamic.IObjectWrapper");
  }
  
  public static gU a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
      if ((localIInterface != null) && ((localIInterface instanceof gU))) {
        localObject = (gU)localIInterface;
      } else {
        localObject = new gW(paramIBinder);
      }
    }
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (boolean bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);; bool = true)
    {
      return bool;
      paramParcel2.writeString("com.google.android.gms.dynamic.IObjectWrapper");
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     gV
 * JD-Core Version:    0.7.0.1
 */