import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.util.VisibleForTesting;

public class eg
  implements el
{
  private static eg e;
  private static Object f = new Object();
  protected String a;
  protected String b;
  protected String c;
  protected String d;
  
  @VisibleForTesting
  protected eg() {}
  
  private eg(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    this.c = paramContext.getPackageName();
    this.d = localPackageManager.getInstallerPackageName(this.c);
    String str1 = this.c;
    String str2 = null;
    try
    {
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0);
      if (localPackageInfo != null)
      {
        str1 = localPackageManager.getApplicationLabel(localPackageInfo.applicationInfo).toString();
        str2 = localPackageInfo.versionName;
      }
      this.a = str1;
      this.b = str2;
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        eO.a("Error retrieving package info: appName set to " + str1);
      }
    }
  }
  
  public static eg a()
  {
    return e;
  }
  
  public static void a(Context paramContext)
  {
    synchronized (f)
    {
      if (e == null) {
        e = new eg(paramContext);
      }
      return;
    }
  }
  
  public boolean a(String paramString)
  {
    if (("&an".equals(paramString)) || ("&av".equals(paramString)) || ("&aid".equals(paramString)) || ("&aiid".equals(paramString))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public String b(String paramString)
  {
    String str = null;
    if (paramString == null) {}
    for (;;)
    {
      return str;
      if (paramString.equals("&an")) {
        str = this.a;
      } else if (paramString.equals("&av")) {
        str = this.b;
      } else if (paramString.equals("&aid")) {
        str = this.c;
      } else if (paramString.equals("&aiid")) {
        str = this.d;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     eg
 * JD-Core Version:    0.7.0.1
 */