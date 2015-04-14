package android.support.v7.app;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.app.WindowCallback;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

abstract class ActionBarActivityDelegate
{
  static final String METADATA_UI_OPTIONS = "android.support.UI_OPTIONS";
  private static final String TAG = "ActionBarActivityDelegate";
  private ActionBar mActionBar;
  final ActionBarActivity mActivity;
  final WindowCallback mDefaultWindowCallback = new ActionBarActivityDelegate.1(this);
  boolean mHasActionBar;
  private boolean mIsDestroyed;
  boolean mIsFloating;
  private MenuInflater mMenuInflater;
  boolean mOverlayActionBar;
  boolean mOverlayActionMode;
  private WindowCallback mWindowCallback;
  
  ActionBarActivityDelegate(ActionBarActivity paramActionBarActivity)
  {
    this.mActivity = paramActionBarActivity;
    this.mWindowCallback = this.mDefaultWindowCallback;
  }
  
  static ActionBarActivityDelegate createDelegate(ActionBarActivity paramActionBarActivity)
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (Object localObject = new ActionBarActivityDelegateHC(paramActionBarActivity);; localObject = new ActionBarActivityDelegateBase(paramActionBarActivity)) {
      return localObject;
    }
  }
  
  abstract void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  abstract ActionBar createSupportActionBar();
  
  abstract View createView(String paramString, Context paramContext, AttributeSet paramAttributeSet);
  
  final void destroy()
  {
    this.mIsDestroyed = true;
  }
  
  protected final Context getActionBarThemedContext()
  {
    Object localObject = null;
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localObject = localActionBar.getThemedContext();
    }
    if (localObject == null) {
      localObject = this.mActivity;
    }
    return localObject;
  }
  
  final android.support.v4.app.ActionBarDrawerToggle.Delegate getDrawerToggleDelegate()
  {
    return new ActionBarActivityDelegate.ActionBarDrawableToggleImpl(this, null);
  }
  
  abstract int getHomeAsUpIndicatorAttrId();
  
  MenuInflater getMenuInflater()
  {
    if (this.mMenuInflater == null) {
      this.mMenuInflater = new SupportMenuInflater(getActionBarThemedContext());
    }
    return this.mMenuInflater;
  }
  
  final ActionBar getSupportActionBar()
  {
    if ((this.mHasActionBar) && (this.mActionBar == null)) {
      this.mActionBar = createSupportActionBar();
    }
    return this.mActionBar;
  }
  
  final String getUiOptionsFromMetadata()
  {
    Object localObject = null;
    try
    {
      ActivityInfo localActivityInfo = this.mActivity.getPackageManager().getActivityInfo(this.mActivity.getComponentName(), 128);
      if (localActivityInfo.metaData != null)
      {
        String str = localActivityInfo.metaData.getString("android.support.UI_OPTIONS");
        localObject = str;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        new StringBuilder().append("getUiOptionsFromMetadata: Activity '").append(this.mActivity.getClass().getSimpleName()).append("' not in manifest").toString();
      }
    }
    return localObject;
  }
  
  final ActionBarDrawerToggle.Delegate getV7DrawerToggleDelegate()
  {
    return new ActionBarActivityDelegate.ActionBarDrawableToggleImpl(this, null);
  }
  
  final WindowCallback getWindowCallback()
  {
    return this.mWindowCallback;
  }
  
  final boolean isDestroyed()
  {
    return this.mIsDestroyed;
  }
  
  abstract boolean onBackPressed();
  
  abstract void onConfigurationChanged(Configuration paramConfiguration);
  
  abstract void onContentChanged();
  
  void onCreate(Bundle paramBundle)
  {
    TypedArray localTypedArray = this.mActivity.obtainStyledAttributes(R.styleable.Theme);
    if (!localTypedArray.hasValue(R.styleable.Theme_windowActionBar))
    {
      localTypedArray.recycle();
      throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }
    if (localTypedArray.getBoolean(R.styleable.Theme_windowActionBar, false)) {
      this.mHasActionBar = true;
    }
    if (localTypedArray.getBoolean(R.styleable.Theme_windowActionBarOverlay, false)) {
      this.mOverlayActionBar = true;
    }
    if (localTypedArray.getBoolean(R.styleable.Theme_windowActionModeOverlay, false)) {
      this.mOverlayActionMode = true;
    }
    this.mIsFloating = localTypedArray.getBoolean(R.styleable.Theme_android_windowIsFloating, false);
    localTypedArray.recycle();
  }
  
  abstract boolean onCreatePanelMenu(int paramInt, Menu paramMenu);
  
  abstract View onCreatePanelView(int paramInt);
  
  boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  abstract boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent);
  
  abstract boolean onMenuOpened(int paramInt, Menu paramMenu);
  
  abstract void onPanelClosed(int paramInt, Menu paramMenu);
  
  abstract void onPostResume();
  
  boolean onPrepareOptionsPanel(View paramView, Menu paramMenu)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    for (boolean bool = this.mActivity.onPrepareOptionsMenu(paramMenu);; bool = this.mActivity.superOnPrepareOptionsPanel(paramView, paramMenu)) {
      return bool;
    }
  }
  
  abstract boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu);
  
  abstract void onStop();
  
  abstract void onTitleChanged(CharSequence paramCharSequence);
  
  final ActionBar peekSupportActionBar()
  {
    return this.mActionBar;
  }
  
  abstract void setContentView(int paramInt);
  
  abstract void setContentView(View paramView);
  
  abstract void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  protected final void setSupportActionBar(ActionBar paramActionBar)
  {
    this.mActionBar = paramActionBar;
  }
  
  abstract void setSupportActionBar(Toolbar paramToolbar);
  
  abstract void setSupportProgress(int paramInt);
  
  abstract void setSupportProgressBarIndeterminate(boolean paramBoolean);
  
  abstract void setSupportProgressBarIndeterminateVisibility(boolean paramBoolean);
  
  abstract void setSupportProgressBarVisibility(boolean paramBoolean);
  
  final void setWindowCallback(WindowCallback paramWindowCallback)
  {
    if (paramWindowCallback == null) {
      throw new IllegalArgumentException("callback can not be null");
    }
    this.mWindowCallback = paramWindowCallback;
  }
  
  abstract ActionMode startSupportActionMode(ActionMode.Callback paramCallback);
  
  abstract ActionMode startSupportActionModeFromWindow(ActionMode.Callback paramCallback);
  
  abstract void supportInvalidateOptionsMenu();
  
  abstract boolean supportRequestWindowFeature(int paramInt);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegate
 * JD-Core Version:    0.7.0.1
 */