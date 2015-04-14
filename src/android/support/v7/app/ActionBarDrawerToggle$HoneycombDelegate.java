package android.support.v7.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;

class ActionBarDrawerToggle$HoneycombDelegate
  implements ActionBarDrawerToggle.Delegate
{
  final Activity mActivity;
  ActionBarDrawerToggleHoneycomb.SetIndicatorInfo mSetIndicatorInfo;
  
  private ActionBarDrawerToggle$HoneycombDelegate(Activity paramActivity)
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
    return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(this.mActivity);
  }
  
  public void setActionBarDescription(int paramInt)
  {
    this.mSetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarDescription(this.mSetIndicatorInfo, this.mActivity, paramInt);
  }
  
  public void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
  {
    this.mActivity.getActionBar().setDisplayShowHomeEnabled(true);
    this.mSetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(this.mSetIndicatorInfo, this.mActivity, paramDrawable, paramInt);
    this.mActivity.getActionBar().setDisplayShowHomeEnabled(false);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarDrawerToggle.HoneycombDelegate
 * JD-Core Version:    0.7.0.1
 */