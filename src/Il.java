import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Il
{
  public static boolean a(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected())) {}
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Il
 * JD-Core Version:    0.7.0.1
 */