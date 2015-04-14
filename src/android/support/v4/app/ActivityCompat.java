package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

public class ActivityCompat
  extends ContextCompat
{
  private static ActivityCompat21.SharedElementCallback21 createCallback(SharedElementCallback paramSharedElementCallback)
  {
    ActivityCompat.SharedElementCallback21Impl localSharedElementCallback21Impl = null;
    if (paramSharedElementCallback != null) {
      localSharedElementCallback21Impl = new ActivityCompat.SharedElementCallback21Impl(paramSharedElementCallback);
    }
    return localSharedElementCallback21Impl;
  }
  
  public static void finishAffinity(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      ActivityCompatJB.finishAffinity(paramActivity);
    }
    for (;;)
    {
      return;
      paramActivity.finish();
    }
  }
  
  public static void finishAfterTransition(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      ActivityCompat21.finishAfterTransition(paramActivity);
    }
    for (;;)
    {
      return;
      paramActivity.finish();
    }
  }
  
  public static boolean invalidateOptionsMenu(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      ActivityCompatHoneycomb.invalidateOptionsMenu(paramActivity);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static void postponeEnterTransition(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      ActivityCompat21.postponeEnterTransition(paramActivity);
    }
  }
  
  public static void setEnterSharedElementCallback(Activity paramActivity, SharedElementCallback paramSharedElementCallback)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      ActivityCompat21.setEnterSharedElementCallback(paramActivity, createCallback(paramSharedElementCallback));
    }
  }
  
  public static void setExitSharedElementCallback(Activity paramActivity, SharedElementCallback paramSharedElementCallback)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      ActivityCompat21.setExitSharedElementCallback(paramActivity, createCallback(paramSharedElementCallback));
    }
  }
  
  public static void startActivity(Activity paramActivity, Intent paramIntent, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      ActivityCompatJB.startActivity(paramActivity, paramIntent, paramBundle);
    }
    for (;;)
    {
      return;
      paramActivity.startActivity(paramIntent);
    }
  }
  
  public static void startActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      ActivityCompatJB.startActivityForResult(paramActivity, paramIntent, paramInt, paramBundle);
    }
    for (;;)
    {
      return;
      paramActivity.startActivityForResult(paramIntent, paramInt);
    }
  }
  
  public static void startPostponedEnterTransition(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      ActivityCompat21.startPostponedEnterTransition(paramActivity);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.ActivityCompat
 * JD-Core Version:    0.7.0.1
 */