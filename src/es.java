import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.google.android.gms.common.util.VisibleForTesting;

class es
  extends BroadcastReceiver
{
  @VisibleForTesting
  static final String a = es.class.getName();
  private final eY b;
  
  es(eY parameY)
  {
    this.b = parameY;
  }
  
  public static void b(Context paramContext)
  {
    Intent localIntent = new Intent("com.google.analytics.RADIO_POWERED");
    localIntent.addCategory(paramContext.getPackageName());
    localIntent.putExtra(a, true);
    paramContext.sendBroadcast(localIntent);
  }
  
  public void a(Context paramContext)
  {
    IntentFilter localIntentFilter1 = new IntentFilter();
    localIntentFilter1.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    paramContext.registerReceiver(this, localIntentFilter1);
    IntentFilter localIntentFilter2 = new IntentFilter();
    localIntentFilter2.addAction("com.google.analytics.RADIO_POWERED");
    localIntentFilter2.addCategory(paramContext.getPackageName());
    paramContext.registerReceiver(this, localIntentFilter2);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    boolean bool;
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(str))
    {
      Bundle localBundle = paramIntent.getExtras();
      Boolean localBoolean = Boolean.FALSE;
      if (localBundle != null) {
        localBoolean = Boolean.valueOf(paramIntent.getExtras().getBoolean("noConnectivity"));
      }
      eY localeY = this.b;
      if (!localBoolean.booleanValue())
      {
        bool = true;
        localeY.a(bool);
      }
    }
    for (;;)
    {
      return;
      bool = false;
      break;
      if (("com.google.analytics.RADIO_POWERED".equals(str)) && (!paramIntent.hasExtra(a))) {
        this.b.e();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     es
 * JD-Core Version:    0.7.0.1
 */