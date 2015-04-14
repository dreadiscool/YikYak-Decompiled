package android.support.v4.app;

import android.app.Activity;
import android.app.SharedElementCallback;

class ActivityCompat21
{
  private static SharedElementCallback createCallback(ActivityCompat21.SharedElementCallback21 paramSharedElementCallback21)
  {
    ActivityCompat21.SharedElementCallbackImpl localSharedElementCallbackImpl = null;
    if (paramSharedElementCallback21 != null) {
      localSharedElementCallbackImpl = new ActivityCompat21.SharedElementCallbackImpl(paramSharedElementCallback21);
    }
    return localSharedElementCallbackImpl;
  }
  
  public static void finishAfterTransition(Activity paramActivity)
  {
    paramActivity.finishAfterTransition();
  }
  
  public static void postponeEnterTransition(Activity paramActivity)
  {
    paramActivity.postponeEnterTransition();
  }
  
  public static void setEnterSharedElementCallback(Activity paramActivity, ActivityCompat21.SharedElementCallback21 paramSharedElementCallback21)
  {
    paramActivity.setEnterSharedElementCallback(createCallback(paramSharedElementCallback21));
  }
  
  public static void setExitSharedElementCallback(Activity paramActivity, ActivityCompat21.SharedElementCallback21 paramSharedElementCallback21)
  {
    paramActivity.setExitSharedElementCallback(createCallback(paramSharedElementCallback21));
  }
  
  public static void startPostponedEnterTransition(Activity paramActivity)
  {
    paramActivity.startPostponedEnterTransition();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.ActivityCompat21
 * JD-Core Version:    0.7.0.1
 */