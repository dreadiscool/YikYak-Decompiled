package android.support.v7.internal.app;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.support.v7.internal.view.menu.MenuPopupHelper;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarOverlayLayout;
import android.support.v7.internal.widget.DecorToolbar;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

public class WindowDecorActionBar$ActionModeImpl
  extends ActionMode
  implements MenuBuilder.Callback
{
  private ActionMode.Callback mCallback;
  private WeakReference<View> mCustomView;
  private MenuBuilder mMenu;
  
  public WindowDecorActionBar$ActionModeImpl(WindowDecorActionBar paramWindowDecorActionBar, ActionMode.Callback paramCallback)
  {
    this.mCallback = paramCallback;
    this.mMenu = new MenuBuilder(paramWindowDecorActionBar.getThemedContext()).setDefaultShowAsAction(1);
    this.mMenu.setCallback(this);
  }
  
  public boolean dispatchOnCreate()
  {
    this.mMenu.stopDispatchingItemsChanged();
    try
    {
      boolean bool = this.mCallback.onCreateActionMode(this, this.mMenu);
      return bool;
    }
    finally
    {
      this.mMenu.startDispatchingItemsChanged();
    }
  }
  
  public void finish()
  {
    if (this.this$0.mActionMode != this) {
      return;
    }
    if (!WindowDecorActionBar.access$900(WindowDecorActionBar.access$700(this.this$0), WindowDecorActionBar.access$800(this.this$0), false))
    {
      this.this$0.mDeferredDestroyActionMode = this;
      this.this$0.mDeferredModeDestroyCallback = this.mCallback;
    }
    for (;;)
    {
      this.mCallback = null;
      this.this$0.animateToMode(false);
      WindowDecorActionBar.access$1000(this.this$0).closeMode();
      WindowDecorActionBar.access$1100(this.this$0).getViewGroup().sendAccessibilityEvent(32);
      WindowDecorActionBar.access$600(this.this$0).setHideOnContentScrollEnabled(this.this$0.mHideOnContentScroll);
      this.this$0.mActionMode = null;
      break;
      this.mCallback.onDestroyActionMode(this);
    }
  }
  
  public View getCustomView()
  {
    if (this.mCustomView != null) {}
    for (View localView = (View)this.mCustomView.get();; localView = null) {
      return localView;
    }
  }
  
  public Menu getMenu()
  {
    return this.mMenu;
  }
  
  public MenuInflater getMenuInflater()
  {
    return new SupportMenuInflater(this.this$0.getThemedContext());
  }
  
  public CharSequence getSubtitle()
  {
    return WindowDecorActionBar.access$1000(this.this$0).getSubtitle();
  }
  
  public CharSequence getTitle()
  {
    return WindowDecorActionBar.access$1000(this.this$0).getTitle();
  }
  
  public void invalidate()
  {
    this.mMenu.stopDispatchingItemsChanged();
    try
    {
      this.mCallback.onPrepareActionMode(this, this.mMenu);
      return;
    }
    finally
    {
      this.mMenu.startDispatchingItemsChanged();
    }
  }
  
  public boolean isTitleOptional()
  {
    return WindowDecorActionBar.access$1000(this.this$0).isTitleOptional();
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {}
  
  public void onCloseSubMenu(SubMenuBuilder paramSubMenuBuilder) {}
  
  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    if (this.mCallback != null) {}
    for (boolean bool = this.mCallback.onActionItemClicked(this, paramMenuItem);; bool = false) {
      return bool;
    }
  }
  
  public void onMenuModeChange(MenuBuilder paramMenuBuilder)
  {
    if (this.mCallback == null) {}
    for (;;)
    {
      return;
      invalidate();
      WindowDecorActionBar.access$1000(this.this$0).showOverflowMenu();
    }
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    boolean bool = true;
    if (this.mCallback == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (paramSubMenuBuilder.hasVisibleItems()) {
        new MenuPopupHelper(this.this$0.getThemedContext(), paramSubMenuBuilder).show();
      }
    }
  }
  
  public void setCustomView(View paramView)
  {
    WindowDecorActionBar.access$1000(this.this$0).setCustomView(paramView);
    this.mCustomView = new WeakReference(paramView);
  }
  
  public void setSubtitle(int paramInt)
  {
    setSubtitle(WindowDecorActionBar.access$1200(this.this$0).getResources().getString(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    WindowDecorActionBar.access$1000(this.this$0).setSubtitle(paramCharSequence);
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(WindowDecorActionBar.access$1200(this.this$0).getResources().getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    WindowDecorActionBar.access$1000(this.this$0).setTitle(paramCharSequence);
  }
  
  public void setTitleOptionalHint(boolean paramBoolean)
  {
    super.setTitleOptionalHint(paramBoolean);
    WindowDecorActionBar.access$1000(this.this$0).setTitleOptional(paramBoolean);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.app.WindowDecorActionBar.ActionModeImpl
 * JD-Core Version:    0.7.0.1
 */