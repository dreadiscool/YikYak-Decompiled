import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import com.mixpanel.android.surveys.SurveyActivity;
import java.util.List;

public class up
{
  public static String a = "MixpanelAPI.ConfigurationChecker";
  
  public static boolean a(Context paramContext)
  {
    if (paramContext.getPackageManager().checkPermission("android.permission.INTERNET", paramContext.getPackageName()) != 0) {}
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool = false;
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      return bool;
      Intent localIntent = new Intent(paramContext, SurveyActivity.class);
      localIntent.addFlags(268435456);
      localIntent.addFlags(131072);
      if (paramContext.getPackageManager().queryIntentActivities(localIntent, 0).size() == 0) {
        new StringBuilder().append(SurveyActivity.class.getName()).append(" is not registered as an activity in your application, so surveys can't be shown.").toString();
      } else {
        bool = true;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     up
 * JD-Core Version:    0.7.0.1
 */