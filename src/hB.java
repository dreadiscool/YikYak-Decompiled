import android.os.Bundle;
import android.os.IBinder;

public final class hB
  extends hN
{
  private hy a;
  
  public hB(hy paramhy)
  {
    this.a = paramhy;
  }
  
  public void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    hZ.a("onPostInitComplete can be called only once per call to getServiceFromBroker", this.a);
    this.a.a(paramInt, paramIBinder, paramBundle);
    this.a = null;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     hB
 * JD-Core Version:    0.7.0.1
 */