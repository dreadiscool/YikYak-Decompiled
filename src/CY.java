import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.yik.yak.ui.activity.YikYakDialog;
import java.util.List;

public class CY
{
  private static CY a;
  
  public static CY a()
  {
    if (a == null) {
      a = new CY();
    }
    return a;
  }
  
  private boolean a(int paramInt)
  {
    if (BV.f() >= paramInt) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void b(Activity paramActivity)
  {
    ApplicationConfig.c(true);
    Intent localIntent = new Intent(paramActivity, YikYakDialog.class);
    localIntent.putExtra("title", paramActivity.getString(2131230965));
    localIntent.putExtra("message", paramActivity.getString(2131230964));
    localIntent.putExtra("okText", "OKAY");
    paramActivity.startActivityForResult(localIntent, 10);
  }
  
  private boolean b()
  {
    return ApplicationConfig.g();
  }
  
  public void a(Activity paramActivity)
  {
    if ((!b()) && (a(CR.a("yakarma", "rate_prompt", 1000))))
    {
      If.a().e(BV.e());
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + paramActivity.getPackageName()));
      if (paramActivity.getPackageManager().queryIntentActivities(localIntent, 0).size() > 0) {
        b(paramActivity);
      }
    }
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     CY

 * JD-Core Version:    0.7.0.1

 */