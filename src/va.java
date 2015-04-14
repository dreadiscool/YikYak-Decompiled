import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.mixpanel.android.mpmetrics.MixpanelAPI;

@TargetApi(16)
public class va
  implements Application.ActivityLifecycleCallbacks
{
  private final MixpanelAPI a;
  
  public va(MixpanelAPI paramMixpanelAPI)
  {
    this.a = paramMixpanelAPI;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    if (!paramActivity.isTaskRoot()) {}
    for (;;)
    {
      return;
      this.a.getPeople().b(paramActivity);
      this.a.getPeople().a(paramActivity);
    }
  }
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     va
 * JD-Core Version:    0.7.0.1
 */