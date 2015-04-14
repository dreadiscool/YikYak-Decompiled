import android.content.Context;
import android.text.TextUtils;
import com.google.analytics.tracking.android.Tracker;
import java.util.Map;

public class en
  extends Tracker
{
  private static en a;
  private static String b;
  private final eL c;
  private boolean d;
  private boolean e;
  private int f;
  private long g;
  private Context h;
  private final Map<String, String> i;
  private eS j;
  private eY k;
  private ej l;
  private boolean m;
  private boolean n;
  
  private en(Context paramContext)
  {
    this(paramContext, new eT(paramContext), eL.a(paramContext), et.a(), null);
  }
  
  private en(Context paramContext, eS parameS, eL parameL, eY parameY, fc paramfc) {}
  
  private eQ a(String paramString)
  {
    try
    {
      eQ localeQ2 = eQ.a(paramString.toUpperCase());
      localeQ1 = localeQ2;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        eQ localeQ1 = null;
      }
    }
    return localeQ1;
  }
  
  public static en a(Context paramContext)
  {
    if (a == null) {
      a = new en(paramContext);
    }
    return a;
  }
  
  private void a()
  {
    eO.c("Starting EasyTracker.");
    String str1 = this.j.a("ga_trackingId");
    if (TextUtils.isEmpty(str1)) {
      str1 = this.j.a("ga_api_key");
    }
    set("&tid", str1);
    eO.c("[EasyTracker] trackingId loaded: " + str1);
    String str2 = this.j.a("ga_appName");
    if (!TextUtils.isEmpty(str2))
    {
      eO.c("[EasyTracker] app name loaded: " + str2);
      set("&an", str2);
    }
    String str3 = this.j.a("ga_appVersion");
    if (str3 != null)
    {
      eO.c("[EasyTracker] app version loaded: " + str3);
      set("&av", str3);
    }
    String str4 = this.j.a("ga_logLevel");
    if (str4 != null)
    {
      eQ localeQ = a(str4);
      if (localeQ != null)
      {
        eO.c("[EasyTracker] log level loaded: " + localeQ);
        this.c.d().a(localeQ);
      }
    }
    Double localDouble = this.j.b("ga_sampleFrequency");
    if (localDouble == null) {
      localDouble = new Double(this.j.a("ga_sampleRate", 100));
    }
    if (localDouble.doubleValue() != 100.0D) {
      set("&sf", Double.toString(localDouble.doubleValue()));
    }
    eO.c("[EasyTracker] sample rate loaded: " + localDouble);
    int i1 = this.j.a("ga_dispatchPeriod", 1800);
    eO.c("[EasyTracker] dispatch period loaded: " + i1);
    this.k.a(i1);
    this.g = (1000 * this.j.a("ga_sessionTimeout", 30));
    eO.c("[EasyTracker] session timeout loaded: " + this.g);
    if ((this.j.c("ga_autoActivityTracking")) || (this.j.c("ga_auto_activity_tracking"))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.e = bool1;
      eO.c("[EasyTracker] auto activity tracking loaded: " + this.e);
      boolean bool2 = this.j.c("ga_anonymizeIp");
      if (bool2)
      {
        set("&aip", "1");
        eO.c("[EasyTracker] anonymize ip loaded: " + bool2);
      }
      this.d = this.j.c("ga_reportUncaughtExceptions");
      if (this.d)
      {
        Thread.setDefaultUncaughtExceptionHandler(new eq(this, this.k, Thread.getDefaultUncaughtExceptionHandler(), this.h));
        eO.c("[EasyTracker] report uncaught exceptions loaded: " + this.d);
      }
      boolean bool3 = this.j.c("ga_dryRun");
      this.c.a(bool3);
      return;
    }
  }
  
  private void a(Context paramContext, eS parameS, eY parameY)
  {
    if (paramContext == null) {
      eO.a("Context cannot be null");
    }
    this.h = paramContext.getApplicationContext();
    this.k = parameY;
    this.j = parameS;
    a();
  }
  
  public void send(Map<String, String> paramMap)
  {
    if (this.n)
    {
      paramMap.put("&sc", "start");
      this.n = false;
    }
    super.send(paramMap);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     en
 * JD-Core Version:    0.7.0.1
 */