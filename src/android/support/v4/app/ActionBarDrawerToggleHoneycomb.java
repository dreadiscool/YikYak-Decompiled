package android.support.v4.app;

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
  
  public static Object setActionBarDescription(Object paramObject, Activity paramActivity, int paramInt)
  {
    if (paramObject == null) {}
    for (Object localObject = new ActionBarDrawerToggleHoneycomb.SetIndicatorInfo(paramActivity);; localObject = paramObject)
    {
      ActionBarDrawerToggleHoneycomb.SetIndicatorInfo localSetIndicatorInfo = (ActionBarDrawerToggleHoneycomb.SetIndicatorInfo)localObject;
      if (localSetIndicatorInfo.setHomeAsUpIndicator != null) {}
      try
      {
        ActionBar localActionBar = paramActivity.getActionBar();
        Method localMethod = localSetIndicatorInfo.setHomeActionContentDescription;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(paramInt);
        localMethod.invoke(localActionBar, arrayOfObject);
        if (Build.VERSION.SDK_INT <= 19) {
          localActionBar.setSubtitle(localActionBar.getSubtitle());
        }
        label82:
        return localObject;
      }
      catch (Exception localException)
      {
        break label82;
      }
    }
  }
  
  public static Object setActionBarUpIndicator(Object paramObject, Activity paramActivity, Drawable paramDrawable, int paramInt)
  {
    if (paramObject == null) {}
    for (Object localObject = new ActionBarDrawerToggleHoneycomb.SetIndicatorInfo(paramActivity);; localObject = paramObject)
    {
      ActionBarDrawerToggleHoneycomb.SetIndicatorInfo localSetIndicatorInfo = (ActionBarDrawerToggleHoneycomb.SetIndicatorInfo)localObject;
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
          label94:
          return localObject;
          if (localSetIndicatorInfo.upIndicatorView != null) {
            localSetIndicatorInfo.upIndicatorView.setImageDrawable(paramDrawable);
          }
        }
      }
      catch (Exception localException)
      {
        break label94;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.ActionBarDrawerToggleHoneycomb
 * JD-Core Version:    0.7.0.1
 */