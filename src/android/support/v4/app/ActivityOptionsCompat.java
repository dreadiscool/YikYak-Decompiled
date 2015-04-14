package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.view.View;

public class ActivityOptionsCompat
{
  public static ActivityOptionsCompat makeCustomAnimation(Context paramContext, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (Object localObject = new ActivityOptionsCompat.ActivityOptionsImplJB(ActivityOptionsCompatJB.makeCustomAnimation(paramContext, paramInt1, paramInt2));; localObject = new ActivityOptionsCompat()) {
      return localObject;
    }
  }
  
  public static ActivityOptionsCompat makeScaleUpAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (Object localObject = new ActivityOptionsCompat.ActivityOptionsImplJB(ActivityOptionsCompatJB.makeScaleUpAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4));; localObject = new ActivityOptionsCompat()) {
      return localObject;
    }
  }
  
  public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity paramActivity, View paramView, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (Object localObject = new ActivityOptionsCompat.ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(paramActivity, paramView, paramString));; localObject = new ActivityOptionsCompat()) {
      return localObject;
    }
  }
  
  public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity paramActivity, Pair<View, String>... paramVarArgs)
  {
    Object localObject1 = null;
    View[] arrayOfView2;
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramVarArgs == null) {
        break label109;
      }
      arrayOfView2 = new View[paramVarArgs.length];
      String[] arrayOfString = new String[paramVarArgs.length];
      for (int i = 0; i < paramVarArgs.length; i++)
      {
        arrayOfView2[i] = ((View)paramVarArgs[i].first);
        arrayOfString[i] = ((String)paramVarArgs[i].second);
      }
      localObject1 = arrayOfString;
    }
    label109:
    for (View[] arrayOfView1 = arrayOfView2;; arrayOfView1 = null) {
      for (Object localObject2 = new ActivityOptionsCompat.ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(paramActivity, arrayOfView1, localObject1));; localObject2 = new ActivityOptionsCompat()) {
        return localObject2;
      }
    }
  }
  
  public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View paramView, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (Object localObject = new ActivityOptionsCompat.ActivityOptionsImplJB(ActivityOptionsCompatJB.makeThumbnailScaleUpAnimation(paramView, paramBitmap, paramInt1, paramInt2));; localObject = new ActivityOptionsCompat()) {
      return localObject;
    }
  }
  
  public Bundle toBundle()
  {
    return null;
  }
  
  public void update(ActivityOptionsCompat paramActivityOptionsCompat) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.ActivityOptionsCompat
 * JD-Core Version:    0.7.0.1
 */