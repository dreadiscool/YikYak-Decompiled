import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;

public final class jF
{
  private static kd a;
  
  public static jE a(LatLng paramLatLng, float paramFloat)
  {
    try
    {
      jE localjE = new jE(a().a(paramLatLng, paramFloat));
      return localjE;
    }
    catch (RemoteException localRemoteException)
    {
      throw new md(localRemoteException);
    }
  }
  
  private static kd a()
  {
    return (kd)hZ.a(a, "CameraUpdateFactory is not initialized");
  }
  
  public static void a(kd paramkd)
  {
    a = (kd)hZ.a(paramkd);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     jF
 * JD-Core Version:    0.7.0.1
 */