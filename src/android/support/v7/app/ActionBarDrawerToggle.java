package android.support.v7.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class ActionBarDrawerToggle
  implements DrawerLayout.DrawerListener
{
  private final ActionBarDrawerToggle.Delegate mActivityImpl;
  private final int mCloseDrawerContentDescRes;
  private boolean mDrawerIndicatorEnabled = true;
  private final DrawerLayout mDrawerLayout;
  private boolean mHasCustomUpIndicator;
  private Drawable mHomeAsUpIndicator;
  private final int mOpenDrawerContentDescRes;
  private ActionBarDrawerToggle.DrawerToggle mSlider;
  private View.OnClickListener mToolbarNavigationClickListener;
  
  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, int paramInt1, int paramInt2)
  {
    this(paramActivity, null, paramDrawerLayout, null, paramInt1, paramInt2);
  }
  
  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, Toolbar paramToolbar, int paramInt1, int paramInt2)
  {
    this(paramActivity, paramToolbar, paramDrawerLayout, null, paramInt1, paramInt2);
  }
  
  <T extends Drawable,  extends ActionBarDrawerToggle.DrawerToggle> ActionBarDrawerToggle(Activity paramActivity, Toolbar paramToolbar, DrawerLayout paramDrawerLayout, T paramT, int paramInt1, int paramInt2)
  {
    if (paramToolbar != null)
    {
      this.mActivityImpl = new ActionBarDrawerToggle.ToolbarCompatDelegate(paramToolbar);
      paramToolbar.setNavigationOnClickListener(new ActionBarDrawerToggle.1(this));
      this.mDrawerLayout = paramDrawerLayout;
      this.mOpenDrawerContentDescRes = paramInt1;
      this.mCloseDrawerContentDescRes = paramInt2;
      if (paramT != null) {
        break label198;
      }
    }
    label198:
    for (this.mSlider = new ActionBarDrawerToggle.DrawerArrowDrawableToggle(paramActivity, this.mActivityImpl.getActionBarThemedContext());; this.mSlider = ((ActionBarDrawerToggle.DrawerToggle)paramT))
    {
      this.mHomeAsUpIndicator = getThemeUpIndicator();
      return;
      if ((paramActivity instanceof ActionBarDrawerToggle.DelegateProvider))
      {
        this.mActivityImpl = ((ActionBarDrawerToggle.DelegateProvider)paramActivity).getDrawerToggleDelegate();
        break;
      }
      if ((paramActivity instanceof ActionBarDrawerToggle.TmpDelegateProvider))
      {
        this.mActivityImpl = ((ActionBarDrawerToggle.TmpDelegateProvider)paramActivity).getV7DrawerToggleDelegate();
        break;
      }
      if (Build.VERSION.SDK_INT >= 18)
      {
        this.mActivityImpl = new ActionBarDrawerToggle.JellybeanMr2Delegate(paramActivity, null);
        break;
      }
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.mActivityImpl = new ActionBarDrawerToggle.HoneycombDelegate(paramActivity, null);
        break;
      }
      this.mActivityImpl = new ActionBarDrawerToggle.DummyDelegate(paramActivity);
      break;
    }
  }
  
  private void toggle()
  {
    if (this.mDrawerLayout.isDrawerVisible(8388611)) {
      this.mDrawerLayout.closeDrawer(8388611);
    }
    for (;;)
    {
      return;
      this.mDrawerLayout.openDrawer(8388611);
    }
  }
  
  Drawable getThemeUpIndicator()
  {
    return this.mActivityImpl.getThemeUpIndicator();
  }
  
  public View.OnClickListener getToolbarNavigationClickListener()
  {
    return this.mToolbarNavigationClickListener;
  }
  
  public boolean isDrawerIndicatorEnabled()
  {
    return this.mDrawerIndicatorEnabled;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (!this.mHasCustomUpIndicator) {
      this.mHomeAsUpIndicator = getThemeUpIndicator();
    }
    syncState();
  }
  
  public void onDrawerClosed(View paramView)
  {
    this.mSlider.setPosition(0.0F);
    if (this.mDrawerIndicatorEnabled) {
      setActionBarDescription(this.mOpenDrawerContentDescRes);
    }
  }
  
  public void onDrawerOpened(View paramView)
  {
    this.mSlider.setPosition(1.0F);
    if (this.mDrawerIndicatorEnabled) {
      setActionBarDescription(this.mCloseDrawerContentDescRes);
    }
  }
  
  public void onDrawerSlide(View paramView, float paramFloat)
  {
    this.mSlider.setPosition(Math.min(1.0F, Math.max(0.0F, paramFloat)));
  }
  
  public void onDrawerStateChanged(int paramInt) {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if ((paramMenuItem != null) && (paramMenuItem.getItemId() == 16908332) && (this.mDrawerIndicatorEnabled)) {
      toggle();
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  void setActionBarDescription(int paramInt)
  {
    this.mActivityImpl.setActionBarDescription(paramInt);
  }
  
  void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
  {
    this.mActivityImpl.setActionBarUpIndicator(paramDrawable, paramInt);
  }
  
  public void setDrawerIndicatorEnabled(boolean paramBoolean)
  {
    int i;
    if (paramBoolean != this.mDrawerIndicatorEnabled)
    {
      if (!paramBoolean) {
        break label57;
      }
      Drawable localDrawable = (Drawable)this.mSlider;
      if (!this.mDrawerLayout.isDrawerOpen(8388611)) {
        break label49;
      }
      i = this.mCloseDrawerContentDescRes;
      setActionBarUpIndicator(localDrawable, i);
    }
    for (;;)
    {
      this.mDrawerIndicatorEnabled = paramBoolean;
      return;
      label49:
      i = this.mOpenDrawerContentDescRes;
      break;
      label57:
      setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
    }
  }
  
  public void setHomeAsUpIndicator(int paramInt)
  {
    Drawable localDrawable = null;
    if (paramInt != 0) {
      localDrawable = this.mDrawerLayout.getResources().getDrawable(paramInt);
    }
    setHomeAsUpIndicator(localDrawable);
  }
  
  public void setHomeAsUpIndicator(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      this.mHomeAsUpIndicator = getThemeUpIndicator();
    }
    for (this.mHasCustomUpIndicator = false;; this.mHasCustomUpIndicator = true)
    {
      if (!this.mDrawerIndicatorEnabled) {
        setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
      }
      return;
      this.mHomeAsUpIndicator = paramDrawable;
    }
  }
  
  public void setToolbarNavigationClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mToolbarNavigationClickListener = paramOnClickListener;
  }
  
  public void syncState()
  {
    Drawable localDrawable;
    if (this.mDrawerLayout.isDrawerOpen(8388611))
    {
      this.mSlider.setPosition(1.0F);
      if (this.mDrawerIndicatorEnabled)
      {
        localDrawable = (Drawable)this.mSlider;
        if (!this.mDrawerLayout.isDrawerOpen(8388611)) {
          break label74;
        }
      }
    }
    label74:
    for (int i = this.mCloseDrawerContentDescRes;; i = this.mOpenDrawerContentDescRes)
    {
      setActionBarUpIndicator(localDrawable, i);
      return;
      this.mSlider.setPosition(0.0F);
      break;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarDrawerToggle
 * JD-Core Version:    0.7.0.1
 */