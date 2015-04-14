package android.support.v7.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

class ActionBarDrawerToggle$JellybeanMr2Delegate
  implements ActionBarDrawerToggle.Delegate
{
  final Activity mActivity;
  
  private ActionBarDrawerToggle$JellybeanMr2Delegate(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  public Context getActionBarThemedContext()
  {
    ActionBar localActionBar = this.mActivity.getActionBar();
    if (localActionBar != null) {}
    for (Object localObject = localActionBar.getThemedContext();; localObject = this.mActivity) {
      return localObject;
    }
  }
  
  public Drawable getThemeUpIndicator()
  {
    Context localContext = getActionBarThemedContext();
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 16843531;
    TypedArray localTypedArray = localContext.obtainStyledAttributes(null, arrayOfInt, 16843470, 0);
    Drawable localDrawable = localTypedArray.getDrawable(0);
    localTypedArray.recycle();
    return localDrawable;
  }
  
  public void setActionBarDescription(int paramInt)
  {
    ActionBar localActionBar = this.mActivity.getActionBar();
    if (localActionBar != null) {
      localActionBar.setHomeActionContentDescription(paramInt);
    }
  }
  
  public void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
  {
    ActionBar localActionBar = this.mActivity.getActionBar();
    if (localActionBar != null)
    {
      localActionBar.setHomeAsUpIndicator(paramDrawable);
      localActionBar.setHomeActionContentDescription(paramInt);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarDrawerToggle.JellybeanMr2Delegate
 * JD-Core Version:    0.7.0.1
 */