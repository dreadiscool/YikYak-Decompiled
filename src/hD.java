import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;

public final class hD
  extends hy<T>.hA<Boolean>
{
  public final int b;
  public final Bundle c;
  public final IBinder d;
  
  public hD(hy paramhy, int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    super(paramhy, Boolean.valueOf(true));
    this.b = paramInt;
    this.d = paramIBinder;
    this.c = paramBundle;
  }
  
  protected void a(Boolean paramBoolean)
  {
    if (paramBoolean == null)
    {
      hy.a(this.e, 1, null);
      return;
    }
    switch (this.b)
    {
    default: 
      if (this.c == null) {
        break;
      }
    }
    for (PendingIntent localPendingIntent = (PendingIntent)this.c.getParcelable("pendingIntent");; localPendingIntent = null)
    {
      for (;;)
      {
        if (hy.c(this.e) != null)
        {
          hH.a(hy.d(this.e)).b(this.e.a(), hy.c(this.e));
          hy.a(this.e, null);
        }
        hy.a(this.e, 1, null);
        hy.a(this.e).a(new ConnectionResult(this.b, localPendingIntent));
        break;
        try
        {
          String str = this.d.getInterfaceDescriptor();
          if (this.e.b().equals(str))
          {
            IInterface localIInterface = this.e.a(this.d);
            if (localIInterface != null)
            {
              hy.a(this.e, 3, localIInterface);
              hy.a(this.e).a();
            }
          }
        }
        catch (RemoteException localRemoteException)
        {
          hH.a(hy.d(this.e)).b(this.e.a(), hy.c(this.e));
          hy.a(this.e, null);
          hy.a(this.e, 1, null);
          hy.a(this.e).a(new ConnectionResult(8, null));
        }
      }
      break;
      hy.a(this.e, 1, null);
      throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     hD
 * JD-Core Version:    0.7.0.1
 */