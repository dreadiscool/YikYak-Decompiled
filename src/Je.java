import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;

public class Je
{
  protected String a()
  {
    return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
  }
  
  public String a(Context paramContext)
  {
    String str = b(paramContext);
    if (TextUtils.isEmpty(str)) {
      str = c(paramContext);
    }
    if (TextUtils.isEmpty(str)) {
      d(paramContext);
    }
    return str;
  }
  
  protected String b(Context paramContext)
  {
    Object localObject = null;
    try
    {
      String str1 = paramContext.getPackageName();
      Bundle localBundle = paramContext.getPackageManager().getApplicationInfo(str1, 128).metaData;
      if (localBundle != null)
      {
        localObject = localBundle.getString("io.fabric.ApiKey");
        if (localObject == null)
        {
          IC.g();
          String str2 = localBundle.getString("com.crashlytics.ApiKey");
          localObject = str2;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        IC.g();
        new StringBuilder().append("Caught non-fatal exception while retrieving apiKey: ").append(localException).toString();
      }
    }
    return localObject;
  }
  
  protected String c(Context paramContext)
  {
    String str = null;
    int i = Jg.a(paramContext, "io.fabric.ApiKey", "string");
    if (i == 0)
    {
      IC.g();
      i = Jg.a(paramContext, "com.crashlytics.ApiKey", "string");
    }
    if (i != 0) {
      str = paramContext.getResources().getString(i);
    }
    return str;
  }
  
  protected void d(Context paramContext)
  {
    if ((IC.h()) || (Jg.i(paramContext))) {
      throw new IllegalArgumentException(a());
    }
    IC.g();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Je
 * JD-Core Version:    0.7.0.1
 */