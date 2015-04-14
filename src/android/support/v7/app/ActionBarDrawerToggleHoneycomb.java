package android.support.v7.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.ImageView;
import java.lang.reflect.Method;

class ActionBarDrawerToggleHoneycomb
{
  private static final String TAG = "ActionBarDrawerToggleHoneycomb";
  private static final int[] THEME_ATTRS;
  
  static
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 16843531;
    THEME_ATTRS = arrayOfInt;
  }
  
  public static Drawable getThemeUpIndicator(Activity paramActivity)
  {
    TypedArray localTypedArray = paramActivity.obtainStyledAttributes(THEME_ATTRS);
    Drawable localDrawable = localTypedArray.getDrawable(0);
    localTypedArray.recycle();
    return localDrawable;
  }
  
  public static ActionBarDrawerToggleHoneycomb.SetIndicatorInfo setActionBarDescription(ActionBarDrawerToggleHoneycomb.SetIndicatorInfo paramSetIndicatorInfo, Activity paramActivity, int paramInt)
  {
    if (paramSetIndicatorInfo == null) {
      paramSetIndicatorInfo = new ActionBarDrawerToggleHoneycomb.SetIndicatorInfo(paramActivity);
    }
    if (paramSetIndicatorInfo.setHomeAsUpIndicator != null) {}
    try
    {
      ActionBar localActionBar = paramActivity.getActionBar();
      Method localMethod = paramSetIndicatorInfo.setHomeActionContentDescription;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      localMethod.invoke(localActionBar, arrayOfObject);
      if (Build.VERSION.SDK_INT <= 19) {
        localActionBar.setSubtitle(localActionBar.getSubtitle());
      }
      label74:
      return paramSetIndicatorInfo;
    }
    catch (Exception localException)
    {
      break label74;
    }
  }
  
  public static ActionBarDrawerToggleHoneycomb.SetIndicatorInfo setActionBarUpIndicator(ActionBarDrawerToggleHoneycomb.SetIndicatorInfo paramSetIndicatorInfo, Activity paramActivity, Drawable paramDrawable, int paramInt)
  {
    ActionBarDrawerToggleHoneycomb.SetIndicatorInfo localSetIndicatorInfo = new ActionBarDrawerToggleHoneycomb.SetIndicatorInfo(paramActivity);
    if (localSetIndicatorInfo.setHomeAsUpIndicator != null) {}
    try
    {
      ActionBar localActionBar = paramActivity.getActionBar();
      Method localMethod1 = localSetIndicatorInfo.setHomeAsUpIndicator;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = paramDrawable;
      localMethod1.invoke(localActionBar, arrayOfObject1);
      Method localMethod2 = localSetIndicatorInfo.setHomeActionContentDescription;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(paramInt);
      localMethod2.invoke(localActionBar, arrayOfObject2);
      for (;;)
      {
        label83:
        return localSetIndicatorInfo;
        if (localSetIndicatorInfo.upIndicatorView != null) {
          localSetIndicatorInfo.upIndicatorView.setImageDrawable(paramDrawable);
        }
      }
    }
    catch (Exception localException)
    {
      break label83;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarDrawerToggleHoneycomb
 * JD-Core Version:    0.7.0.1
 */