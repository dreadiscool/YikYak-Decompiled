import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

class gq
  extends BroadcastReceiver
{
  static final String a = gq.class.getName();
  private final fG b;
  
  gq(fG paramfG)
  {
    this.b = paramfG;
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
    boolean bool1 = false;
    String str = paramIntent.getAction();
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(str))
    {
      boolean bool2 = paramIntent.getBooleanExtra("noConnectivity", false);
      fG localfG = this.b;
      if (!bool2) {
        bool1 = true;
      }
      localfG.a(bool1);
    }
    for (;;)
    {
      return;
      if (("com.google.analytics.RADIO_POWERED".equals(str)) && (!paramIntent.hasExtra(a))) {
        this.b.b();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     gq
 * JD-Core Version:    0.7.0.1
 */