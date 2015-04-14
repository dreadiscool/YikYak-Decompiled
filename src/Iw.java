import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.provider.Telephony.Sms;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iw
{
  private static Intent a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.putExtra("sms_body", paramString);
    localIntent.putExtra("android.intent.extra.TEXT", paramString);
    localIntent.setType("text/plain");
    String str = null;
    if (Build.VERSION.SDK_INT >= 19) {
      str = Telephony.Sms.getDefaultSmsPackage(paramContext);
    }
    if (str != null) {
      localIntent.setPackage(str);
    }
    return localIntent;
  }
  
  private static Intent a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", "", null));
    localIntent.putExtra("android.intent.extra.SUBJECT", paramString1);
    localIntent.putExtra("android.intent.extra.TEXT", paramString2);
    return localIntent;
  }
  
  private static List<ResolveInfo> a(Context paramContext)
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("text/plain");
    return a(paramContext, localIntent);
  }
  
  private static List<ResolveInfo> a(Context paramContext, Intent paramIntent)
  {
    return paramContext.getPackageManager().queryIntentActivities(paramIntent, 0);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    String str1 = paramContext.getString(paramInt1);
    String str2 = paramContext.getString(paramInt2);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a(str1, str2));
    localArrayList.add(a(paramContext, str2));
    Iterator localIterator = a(paramContext).iterator();
    while (localIterator.hasNext())
    {
      ActivityInfo localActivityInfo = ((ResolveInfo)localIterator.next()).activityInfo;
      String str3 = localActivityInfo.name;
      ComponentName localComponentName = new ComponentName(localActivityInfo.applicationInfo.packageName, str3);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = str3;
      Iq.a(Iw.class, arrayOfObject);
      if ((str3.contains("facebook")) || (str3.contains("twitter")) || (str3.contains("Slack")))
      {
        Intent localIntent2 = new Intent("android.intent.action.SEND");
        localIntent2.setType("text/plain");
        localIntent2.addCategory("android.intent.category.LAUNCHER");
        localIntent2.putExtra("android.intent.extra.TEXT", str2);
        localIntent2.setComponent(localComponentName);
        localArrayList.add(localIntent2);
      }
    }
    If.a().d("");
    Intent localIntent1 = Intent.createChooser((Intent)localArrayList.remove(0), "Share Yik Yak");
    localIntent1.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])localArrayList.toArray(new Parcelable[localArrayList.size()]));
    paramContext.startActivity(localIntent1);
  }
  
  public static void a(Context paramContext, Uri paramUri)
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("image/png");
    localIntent.putExtra("android.intent.extra.STREAM", paramUri);
    paramContext.startActivity(Intent.createChooser(localIntent, paramContext.getString(2131231012)));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Iw
 * JD-Core Version:    0.7.0.1
 */