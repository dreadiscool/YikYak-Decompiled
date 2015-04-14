import android.provider.Settings.Secure;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.yik.yak.ui.activity.MainActivity;
import java.io.IOException;

public class Dk
  implements Runnable
{
  public Dk(MainActivity paramMainActivity) {}
  
  public void run()
  {
    try
    {
      AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.a.getApplicationContext());
      this.a.c.a(localInfo.getId(), localInfo.isLimitAdTrackingEnabled());
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        this.a.c.a(Settings.Secure.getString(this.a.getContentResolver(), "android_id"));
      }
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      for (;;)
      {
        this.a.c.a(Settings.Secure.getString(this.a.getContentResolver(), "android_id"));
      }
    }
    catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
    {
      for (;;)
      {
        this.a.c.a(Settings.Secure.getString(this.a.getContentResolver(), "android_id"));
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        this.a.c.a(Settings.Secure.getString(this.a.getContentResolver(), "android_id"));
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Dk
 * JD-Core Version:    0.7.0.1
 */