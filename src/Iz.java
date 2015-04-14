import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class Iz
  implements Application.ActivityLifecycleCallbacks
{
  Iz(Iy paramIy, IA paramIA) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    this.a.a(paramActivity, paramBundle);
  }
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity)
  {
    this.a.b(paramActivity);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    this.a.a(paramActivity);
  }
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Iz
 * JD-Core Version:    0.7.0.1
 */