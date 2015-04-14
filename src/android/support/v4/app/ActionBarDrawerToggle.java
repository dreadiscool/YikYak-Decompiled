package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.MenuItem;
import android.view.View;

@Deprecated
public class ActionBarDrawerToggle
  implements DrawerLayout.DrawerListener
{
  private static final int ID_HOME = 16908332;
  private static final ActionBarDrawerToggle.ActionBarDrawerToggleImpl IMPL;
  private static final float TOGGLE_DRAWABLE_OFFSET = 0.3333333F;
  private final Activity mActivity;
  private final ActionBarDrawerToggle.Delegate mActivityImpl;
  private final int mCloseDrawerContentDescRes;
  private Drawable mDrawerImage;
  private final int mDrawerImageResource;
  private boolean mDrawerIndicatorEnabled = true;
  private final DrawerLayout mDrawerLayout;
  private boolean mHasCustomUpIndicator;
  private Drawable mHomeAsUpIndicator;
  private final int mOpenDrawerContentDescRes;
  private Object mSetIndicatorInfo;
  private ActionBarDrawerToggle.SlideDrawable mSlider;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 18) {
      IMPL = new ActionBarDrawerToggle.ActionBarDrawerToggleImplJellybeanMR2(null);
    }
    for (;;)
    {
      return;
      if (i >= 11) {
        IMPL = new ActionBarDrawerToggle.ActionBarDrawerToggleImplHC(null);
      } else {
        IMPL = new ActionBarDrawerToggle.ActionBarDrawerToggleImplBase(null);
      }
    }
  }
  
  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, int paramInt1, int paramInt2, int paramInt3) {}
  
  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mActivity = paramActivity;
    ActionBarDrawerToggle.SlideDrawable localSlideDrawable;
    if ((paramActivity instanceof ActionBarDrawerToggle.DelegateProvider))
    {
      this.mActivityImpl = ((ActionBarDrawerToggle.DelegateProvider)paramActivity).getDrawerToggleDelegate();
      this.mDrawerLayout = paramDrawerLayout;
      this.mDrawerImageResource = paramInt1;
      this.mOpenDrawerContentDescRes = paramInt2;
      this.mCloseDrawerContentDescRes = paramInt3;
      this.mHomeAsUpIndicator = getThemeUpIndicator();
      this.mDrawerImage = ContextCompat.getDrawable(paramActivity, paramInt1);
      this.mSlider = new ActionBarDrawerToggle.SlideDrawable(this, this.mDrawerImage, null);
      localSlideDrawable = this.mSlider;
      if (!paramBoolean) {
        break label122;
      }
    }
    label122:
    for (float f = 0.3333333F;; f = 0.0F)
    {
      localSlideDrawable.setOffset(f);
      return;
      this.mActivityImpl = null;
      break;
    }
  }
  
  private static boolean assumeMaterial(Context paramContext)
  {
    if ((paramContext.getApplicationInfo().targetSdkVersion >= 21) && (Build.VERSION.SDK_INT >= 21)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  Drawable getThemeUpIndicator()
  {
    if (this.mActivityImpl != null) {}
    for (Drawable localDrawable = this.mActivityImpl.getThemeUpIndicator();; localDrawable = IMPL.getThemeUpIndicator(this.mActivity)) {
      return localDrawable;
    }
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
    this.mDrawerImage = ContextCompat.getDrawable(this.mActivity, this.mDrawerImageResource);
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
    float f1 = this.mSlider.getPosition();
    if (paramFloat > 0.5F) {}
    for (float f2 = Math.max(f1, 2.0F * Math.max(0.0F, paramFloat - 0.5F));; f2 = Math.min(f1, paramFloat * 2.0F))
    {
      this.mSlider.setPosition(f2);
      return;
    }
  }
  
  public void onDrawerStateChanged(int paramInt) {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if ((paramMenuItem != null) && (paramMenuItem.getItemId() == 16908332) && (this.mDrawerIndicatorEnabled)) {
      if (this.mDrawerLayout.isDrawerVisible(8388611)) {
        this.mDrawerLayout.closeDrawer(8388611);
      }
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      this.mDrawerLayout.openDrawer(8388611);
      break;
    }
  }
  
  void setActionBarDescription(int paramInt)
  {
    if (this.mActivityImpl != null) {
      this.mActivityImpl.setActionBarDescription(paramInt);
    }
    for (;;)
    {
      return;
      this.mSetIndicatorInfo = IMPL.setActionBarDescription(this.mSetIndicatorInfo, this.mActivity, paramInt);
    }
  }
  
  void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
  {
    if (this.mActivityImpl != null) {
      this.mActivityImpl.setActionBarUpIndicator(paramDrawable, paramInt);
    }
    for (;;)
    {
      return;
      this.mSetIndicatorInfo = IMPL.setActionBarUpIndicator(this.mSetIndicatorInfo, this.mActivity, paramDrawable, paramInt);
    }
  }
  
  public void setDrawerIndicatorEnabled(boolean paramBoolean)
  {
    int i;
    if (paramBoolean != this.mDrawerIndicatorEnabled)
    {
      if (!paramBoolean) {
        break label54;
      }
      ActionBarDrawerToggle.SlideDrawable localSlideDrawable = this.mSlider;
      if (!this.mDrawerLayout.isDrawerOpen(8388611)) {
        break label46;
      }
      i = this.mCloseDrawerContentDescRes;
      setActionBarUpIndicator(localSlideDrawable, i);
    }
    for (;;)
    {
      this.mDrawerIndicatorEnabled = paramBoolean;
      return;
      label46:
      i = this.mOpenDrawerContentDescRes;
      break;
      label54:
      setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
    }
  }
  
  public void setHomeAsUpIndicator(int paramInt)
  {
    Drawable localDrawable = null;
    if (paramInt != 0) {
      localDrawable = ContextCompat.getDrawable(this.mActivity, paramInt);
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
  
  public void syncState()
  {
    ActionBarDrawerToggle.SlideDrawable localSlideDrawable;
    if (this.mDrawerLayout.isDrawerOpen(8388611))
    {
      this.mSlider.setPosition(1.0F);
      if (this.mDrawerIndicatorEnabled)
      {
        localSlideDrawable = this.mSlider;
        if (!this.mDrawerLayout.isDrawerOpen(8388611)) {
          break label67;
        }
      }
    }
    label67:
    for (int i = this.mCloseDrawerContentDescRes;; i = this.mOpenDrawerContentDescRes)
    {
      setActionBarUpIndicator(localSlideDrawable, i);
      return;
      this.mSlider.setPosition(0.0F);
      break;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.ActionBarDrawerToggle
 * JD-Core Version:    0.7.0.1
 */