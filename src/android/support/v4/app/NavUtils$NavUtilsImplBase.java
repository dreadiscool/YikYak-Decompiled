package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.v4.content.IntentCompat;

class NavUtils$NavUtilsImplBase
  implements NavUtils.NavUtilsImpl
{
  public Intent getParentActivityIntent(Activity paramActivity)
  {
    Object localObject = null;
    String str = NavUtils.getParentActivityName(paramActivity);
    if (str == null) {}
    for (;;)
    {
      return localObject;
      ComponentName localComponentName = new ComponentName(paramActivity, str);
      try
      {
        if (NavUtils.getParentActivityName(paramActivity, localComponentName) == null)
        {
          localObject = IntentCompat.makeMainActivity(localComponentName);
        }
        else
        {
          Intent localIntent = new Intent().setComponent(localComponentName);
          localObject = localIntent;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        new StringBuilder().append("getParentActivityIntent: bad parentActivityName '").append(str).append("' in manifest").toString();
      }
    }
  }
  
  public String getParentActivityName(Context paramContext, ActivityInfo paramActivityInfo)
  {
    String str;
    if (paramActivityInfo.metaData == null) {
      str = null;
    }
    for (;;)
    {
      return str;
      str = paramActivityInfo.metaData.getString("android.support.PARENT_ACTIVITY");
      if (str == null) {
        str = null;
      } else if (str.charAt(0) == '.') {
        str = paramContext.getPackageName() + str;
      }
    }
  }
  
  public void navigateUpTo(Activity paramActivity, Intent paramIntent)
  {
    paramIntent.addFlags(67108864);
    paramActivity.startActivity(paramIntent);
    paramActivity.finish();
  }
  
  public boolean shouldUpRecreateTask(Activity paramActivity, Intent paramIntent)
  {
    String str = paramActivity.getIntent().getAction();
    if ((str != null) && (!str.equals("android.intent.action.MAIN"))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NavUtils.NavUtilsImplBase
 * JD-Core Version:    0.7.0.1
 */