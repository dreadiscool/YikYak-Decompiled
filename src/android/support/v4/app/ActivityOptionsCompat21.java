package android.support.v4.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

class ActivityOptionsCompat21
{
  private final ActivityOptions mActivityOptions;
  
  private ActivityOptionsCompat21(ActivityOptions paramActivityOptions)
  {
    this.mActivityOptions = paramActivityOptions;
  }
  
  public static ActivityOptionsCompat21 makeSceneTransitionAnimation(Activity paramActivity, View paramView, String paramString)
  {
    return new ActivityOptionsCompat21(ActivityOptions.makeSceneTransitionAnimation(paramActivity, paramView, paramString));
  }
  
  public static ActivityOptionsCompat21 makeSceneTransitionAnimation(Activity paramActivity, View[] paramArrayOfView, String[] paramArrayOfString)
  {
    Object localObject = null;
    if (paramArrayOfView != null)
    {
      Pair[] arrayOfPair = new Pair[paramArrayOfView.length];
      for (int i = 0; i < arrayOfPair.length; i++) {
        arrayOfPair[i] = Pair.create(paramArrayOfView[i], paramArrayOfString[i]);
      }
      localObject = arrayOfPair;
    }
    return new ActivityOptionsCompat21(ActivityOptions.makeSceneTransitionAnimation(paramActivity, localObject));
  }
  
  public Bundle toBundle()
  {
    return this.mActivityOptions.toBundle();
  }
  
  public void update(ActivityOptionsCompat21 paramActivityOptionsCompat21)
  {
    this.mActivityOptions.update(paramActivityOptionsCompat21.mActivityOptions);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.ActivityOptionsCompat21
 * JD-Core Version:    0.7.0.1
 */