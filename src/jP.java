import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;

public final class jP
{
  public static int a(Context paramContext)
  {
    hZ.a(paramContext);
    try
    {
      kO localkO = lX.a(paramContext);
      a(localkO);
      i = 0;
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      for (;;)
      {
        int i = localGooglePlayServicesNotAvailableException.errorCode;
      }
    }
    return i;
  }
  
  public static void a(kO paramkO)
  {
    try
    {
      jF.a(paramkO.a());
      ma.a(paramkO.b());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new md(localRemoteException);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     jP
 * JD-Core Version:    0.7.0.1
 */