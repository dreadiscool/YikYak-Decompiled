import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class aU
  implements Application.ActivityLifecycleCallbacks
{
  aU(aT paramaT) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    this.a.a(paramActivity);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    this.a.b(paramActivity);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    this.a.c(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    this.a.d(paramActivity);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    this.a.e(paramActivity);
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    this.a.f(paramActivity);
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    this.a.g(paramActivity);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     aU
 * JD-Core Version:    0.7.0.1
 */