package android.support.v7.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle.DelegateProvider;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.app.TaskStackBuilder.SupportParentable;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class ActionBarActivity
  extends FragmentActivity
  implements ActionBarDrawerToggle.DelegateProvider, TaskStackBuilder.SupportParentable, ActionBar.Callback, ActionBarDrawerToggle.TmpDelegateProvider
{
  private ActionBarActivityDelegate mDelegate;
  
  private ActionBarActivityDelegate getDelegate()
  {
    if (this.mDelegate == null) {
      this.mDelegate = ActionBarActivityDelegate.createDelegate(this);
    }
    return this.mDelegate;
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    getDelegate().addContentView(paramView, paramLayoutParams);
  }
  
  public final android.support.v4.app.ActionBarDrawerToggle.Delegate getDrawerToggleDelegate()
  {
    return getDelegate().getDrawerToggleDelegate();
  }
  
  public MenuInflater getMenuInflater()
  {
    return getDelegate().getMenuInflater();
  }
  
  public ActionBar getSupportActionBar()
  {
    return getDelegate().getSupportActionBar();
  }
  
  public Intent getSupportParentActivityIntent()
  {
    return NavUtils.getParentActivityIntent(this);
  }
  
  public ActionBarDrawerToggle.Delegate getV7DrawerToggleDelegate()
  {
    return getDelegate().getV7DrawerToggleDelegate();
  }
  
  public void invalidateOptionsMenu()
  {
    getDelegate().supportInvalidateOptionsMenu();
  }
  
  public void onBackPressed()
  {
    if (!getDelegate().onBackPressed()) {
      super.onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    getDelegate().onConfigurationChanged(paramConfiguration);
  }
  
  public final void onContentChanged()
  {
    getDelegate().onContentChanged();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getDelegate().onCreate(paramBundle);
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    return getDelegate().onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public View onCreatePanelView(int paramInt)
  {
    if (paramInt == 0) {}
    for (View localView = getDelegate().onCreatePanelView(paramInt);; localView = super.onCreatePanelView(paramInt)) {
      return localView;
    }
  }
  
  public void onCreateSupportNavigateUpTaskStack(TaskStackBuilder paramTaskStackBuilder)
  {
    paramTaskStackBuilder.addParentStack(this);
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView = super.onCreateView(paramString, paramContext, paramAttributeSet);
    if (localView != null) {}
    for (;;)
    {
      return localView;
      localView = getDelegate().createView(paramString, paramContext, paramAttributeSet);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    getDelegate().destroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (super.onKeyDown(paramInt, paramKeyEvent)) {}
    for (boolean bool = true;; bool = getDelegate().onKeyDown(paramInt, paramKeyEvent)) {
      return bool;
    }
  }
  
  public boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    return getDelegate().onKeyShortcut(paramInt, paramKeyEvent);
  }
  
  public final boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    boolean bool;
    if (super.onMenuItemSelected(paramInt, paramMenuItem)) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      ActionBar localActionBar = getSupportActionBar();
      if ((paramMenuItem.getItemId() == 16908332) && (localActionBar != null) && ((0x4 & localActionBar.getDisplayOptions()) != 0)) {
        bool = onSupportNavigateUp();
      } else {
        bool = false;
      }
    }
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return getDelegate().onMenuOpened(paramInt, paramMenu);
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    getDelegate().onPanelClosed(paramInt, paramMenu);
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    getDelegate().onPostResume();
  }
  
  protected boolean onPrepareOptionsPanel(View paramView, Menu paramMenu)
  {
    return getDelegate().onPrepareOptionsPanel(paramView, paramMenu);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    return getDelegate().onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  public void onPrepareSupportNavigateUpTaskStack(TaskStackBuilder paramTaskStackBuilder) {}
  
  protected void onStop()
  {
    super.onStop();
    getDelegate().onStop();
  }
  
  public void onSupportActionModeFinished(ActionMode paramActionMode) {}
  
  public void onSupportActionModeStarted(ActionMode paramActionMode) {}
  
  public void onSupportContentChanged() {}
  
  public boolean onSupportNavigateUp()
  {
    Intent localIntent = getSupportParentActivityIntent();
    if (localIntent != null) {
      if (supportShouldUpRecreateTask(localIntent))
      {
        TaskStackBuilder localTaskStackBuilder = TaskStackBuilder.create(this);
        onCreateSupportNavigateUpTaskStack(localTaskStackBuilder);
        onPrepareSupportNavigateUpTaskStack(localTaskStackBuilder);
        localTaskStackBuilder.startActivities();
      }
    }
    for (;;)
    {
      try
      {
        ActivityCompat.finishAffinity(this);
        bool = true;
        return bool;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        finish();
        continue;
      }
      supportNavigateUpTo(localIntent);
      continue;
      boolean bool = false;
    }
  }
  
  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    super.onTitleChanged(paramCharSequence, paramInt);
    getDelegate().onTitleChanged(paramCharSequence);
  }
  
  public void setContentView(int paramInt)
  {
    getDelegate().setContentView(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    getDelegate().setContentView(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    getDelegate().setContentView(paramView, paramLayoutParams);
  }
  
  public void setSupportActionBar(Toolbar paramToolbar)
  {
    getDelegate().setSupportActionBar(paramToolbar);
  }
  
  public void setSupportProgress(int paramInt)
  {
    getDelegate().setSupportProgress(paramInt);
  }
  
  public void setSupportProgressBarIndeterminate(boolean paramBoolean)
  {
    getDelegate().setSupportProgressBarIndeterminate(paramBoolean);
  }
  
  public void setSupportProgressBarIndeterminateVisibility(boolean paramBoolean)
  {
    getDelegate().setSupportProgressBarIndeterminateVisibility(paramBoolean);
  }
  
  public void setSupportProgressBarVisibility(boolean paramBoolean)
  {
    getDelegate().setSupportProgressBarVisibility(paramBoolean);
  }
  
  public ActionMode startSupportActionMode(ActionMode.Callback paramCallback)
  {
    return getDelegate().startSupportActionMode(paramCallback);
  }
  
  void superAddContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addContentView(paramView, paramLayoutParams);
  }
  
  boolean superOnCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  boolean superOnMenuOpened(int paramInt, Menu paramMenu)
  {
    return super.onMenuOpened(paramInt, paramMenu);
  }
  
  void superOnPanelClosed(int paramInt, Menu paramMenu)
  {
    super.onPanelClosed(paramInt, paramMenu);
  }
  
  boolean superOnPrepareOptionsPanel(View paramView, Menu paramMenu)
  {
    return super.onPrepareOptionsPanel(paramView, paramMenu);
  }
  
  boolean superOnPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    return super.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  void superSetContentView(int paramInt)
  {
    super.setContentView(paramInt);
  }
  
  void superSetContentView(View paramView)
  {
    super.setContentView(paramView);
  }
  
  void superSetContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setContentView(paramView, paramLayoutParams);
  }
  
  public void supportInvalidateOptionsMenu()
  {
    getDelegate().supportInvalidateOptionsMenu();
  }
  
  public void supportNavigateUpTo(Intent paramIntent)
  {
    NavUtils.navigateUpTo(this, paramIntent);
  }
  
  public boolean supportRequestWindowFeature(int paramInt)
  {
    return getDelegate().supportRequestWindowFeature(paramInt);
  }
  
  public boolean supportShouldUpRecreateTask(Intent paramIntent)
  {
    return NavUtils.shouldUpRecreateTask(this, paramIntent);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivity
 * JD-Core Version:    0.7.0.1
 */