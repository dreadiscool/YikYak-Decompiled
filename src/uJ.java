import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public class uJ
{
  public static boolean a = false;
  private static uJ s;
  private static final Object t = new Object();
  private final int b;
  private final int c;
  private final int d;
  private final boolean e;
  private final boolean f;
  private final boolean g;
  private final boolean h;
  private final boolean i;
  private final String j;
  private final String k;
  private final String l;
  private final String m;
  private final String n;
  private final String o;
  private final boolean p;
  private final String q;
  private final String r;
  
  uJ(Bundle paramBundle)
  {
    a = paramBundle.getBoolean("com.mixpanel.android.MPConfig.EnableDebugLogging", false);
    paramBundle.containsKey("com.mixpanel.android.MPConfig.AutoCheckForSurveys");
    this.b = paramBundle.getInt("com.mixpanel.android.MPConfig.BulkUploadLimit", 40);
    this.c = paramBundle.getInt("com.mixpanel.android.MPConfig.FlushInterval", 60000);
    this.d = paramBundle.getInt("com.mixpanel.android.MPConfig.DataExpiration", 432000000);
    this.e = paramBundle.getBoolean("com.mixpanel.android.MPConfig.DisableFallback", bool1);
    this.r = paramBundle.getString("com.mixpanel.android.MPConfig.ResourcePackageName");
    this.g = paramBundle.getBoolean("com.mixpanel.android.MPConfig.DisableGestureBindingUI", false);
    this.h = paramBundle.getBoolean("com.mixpanel.android.MPConfig.DisableEmulatorBindingUI", false);
    this.i = paramBundle.getBoolean("com.mixpanel.android.MPConfig.DisableAppOpenEvent", bool1);
    boolean bool2 = paramBundle.getBoolean("com.mixpanel.android.MPConfig.AutoCheckForSurveys", bool1);
    boolean bool3 = paramBundle.getBoolean("com.mixpanel.android.MPConfig.AutoShowMixpanelUpdates", bool1);
    if ((bool2) && (bool3)) {}
    for (;;)
    {
      this.p = bool1;
      this.f = paramBundle.getBoolean("com.mixpanel.android.MPConfig.TestMode", false);
      String str1 = paramBundle.getString("com.mixpanel.android.MPConfig.EventsEndpoint");
      if (str1 == null) {
        str1 = "https://api.mixpanel.com/track?ip=1";
      }
      this.j = str1;
      String str2 = paramBundle.getString("com.mixpanel.android.MPConfig.EventsFallbackEndpoint");
      if (str2 == null) {
        str2 = "http://api.mixpanel.com/track?ip=1";
      }
      this.k = str2;
      String str3 = paramBundle.getString("com.mixpanel.android.MPConfig.PeopleEndpoint");
      if (str3 == null) {
        str3 = "https://api.mixpanel.com/engage";
      }
      this.l = str3;
      String str4 = paramBundle.getString("com.mixpanel.android.MPConfig.PeopleFallbackEndpoint");
      if (str4 == null) {
        str4 = "http://api.mixpanel.com/engage";
      }
      this.m = str4;
      String str5 = paramBundle.getString("com.mixpanel.android.MPConfig.DecideEndpoint");
      if (str5 == null) {
        str5 = "https://decide.mixpanel.com/decide";
      }
      this.n = str5;
      String str6 = paramBundle.getString("com.mixpanel.android.MPConfig.DecideFallbackEndpoint");
      if (str6 == null) {
        str6 = "http://decide.mixpanel.com/decide";
      }
      this.o = str6;
      String str7 = paramBundle.getString("com.mixpanel.android.MPConfig.EditorUrl");
      if (str7 == null) {
        str7 = "wss://switchboard.mixpanel.com/connect/";
      }
      this.q = str7;
      if (a) {
        new StringBuilder().append("Mixpanel configured with:\n    AutoShowMixpanelUpdates ").append(o()).append("\n").append("    BulkUploadLimit ").append(a()).append("\n").append("    FlushInterval ").append(b()).append("\n").append("    DataExpiration ").append(c()).append("\n").append("    DisableFallback ").append(d()).append("\n").append("    DisableAppOpenEvent ").append(g()).append("\n").append("    DisableDeviceUIBinding ").append(e()).append("\n").append("    DisableEmulatorUIBinding ").append(f()).append("\n").append("    EnableDebugLogging ").append(a).append("\n").append("    TestMode ").append(h()).append("\n").append("    EventsEndpoint ").append(i()).append("\n").append("    PeopleEndpoint ").append(j()).append("\n").append("    DecideEndpoint ").append(k()).append("\n").append("    EventsFallbackEndpoint ").append(l()).append("\n").append("    PeopleFallbackEndpoint ").append(m()).append("\n").append("    DecideFallbackEndpoint ").append(n()).append("\n").append("    EditorUrl ").append(p()).append("\n").toString();
      }
      return;
      bool1 = false;
    }
  }
  
  public static uJ a(Context paramContext)
  {
    synchronized (t)
    {
      if (s == null) {
        s = b(paramContext.getApplicationContext());
      }
      return s;
    }
  }
  
  static uJ b(Context paramContext)
  {
    String str = paramContext.getPackageName();
    try
    {
      Bundle localBundle = paramContext.getPackageManager().getApplicationInfo(str, 128).metaData;
      if (localBundle == null) {
        localBundle = new Bundle();
      }
      uJ localuJ = new uJ(localBundle);
      return localuJ;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      throw new RuntimeException("Can't configure Mixpanel with package name " + str, localNameNotFoundException);
    }
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public boolean d()
  {
    return this.e;
  }
  
  public boolean e()
  {
    return this.g;
  }
  
  public boolean f()
  {
    return this.h;
  }
  
  public boolean g()
  {
    return this.i;
  }
  
  public boolean h()
  {
    return this.f;
  }
  
  public String i()
  {
    return this.j;
  }
  
  public String j()
  {
    return this.l;
  }
  
  public String k()
  {
    return this.n;
  }
  
  public String l()
  {
    return this.k;
  }
  
  public String m()
  {
    return this.m;
  }
  
  public String n()
  {
    return this.o;
  }
  
  public boolean o()
  {
    return this.p;
  }
  
  public String p()
  {
    return this.q;
  }
  
  public String q()
  {
    return this.r;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     uJ
 * JD-Core Version:    0.7.0.1
 */