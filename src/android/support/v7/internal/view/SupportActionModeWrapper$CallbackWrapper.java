package android.support.v7.internal.view;

import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.util.SimpleArrayMap;
import android.support.v7.internal.view.menu.MenuWrapperFactory;
import android.view.Menu;
import android.view.MenuItem;

public class SupportActionModeWrapper$CallbackWrapper
  implements android.support.v7.view.ActionMode.Callback
{
  final SimpleArrayMap<android.support.v7.view.ActionMode, SupportActionModeWrapper> mActionModes;
  final Context mContext;
  final SimpleArrayMap<Menu, Menu> mMenus;
  final android.view.ActionMode.Callback mWrappedCallback;
  
  public SupportActionModeWrapper$CallbackWrapper(Context paramContext, android.view.ActionMode.Callback paramCallback)
  {
    this.mContext = paramContext;
    this.mWrappedCallback = paramCallback;
    this.mActionModes = new SimpleArrayMap();
    this.mMenus = new SimpleArrayMap();
  }
  
  private android.view.ActionMode getActionModeWrapper(android.support.v7.view.ActionMode paramActionMode)
  {
    SupportActionModeWrapper localSupportActionModeWrapper = (SupportActionModeWrapper)this.mActionModes.get(paramActionMode);
    if (localSupportActionModeWrapper != null) {}
    for (;;)
    {
      return localSupportActionModeWrapper;
      localSupportActionModeWrapper = new SupportActionModeWrapper(this.mContext, paramActionMode);
      this.mActionModes.put(paramActionMode, localSupportActionModeWrapper);
    }
  }
  
  private Menu getMenuWrapper(Menu paramMenu)
  {
    Menu localMenu = (Menu)this.mMenus.get(paramMenu);
    if (localMenu == null)
    {
      localMenu = MenuWrapperFactory.wrapSupportMenu(this.mContext, (SupportMenu)paramMenu);
      this.mMenus.put(paramMenu, localMenu);
    }
    return localMenu;
  }
  
  public boolean onActionItemClicked(android.support.v7.view.ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return this.mWrappedCallback.onActionItemClicked(getActionModeWrapper(paramActionMode), MenuWrapperFactory.wrapSupportMenuItem(this.mContext, (SupportMenuItem)paramMenuItem));
  }
  
  public boolean onCreateActionMode(android.support.v7.view.ActionMode paramActionMode, Menu paramMenu)
  {
    return this.mWrappedCallback.onCreateActionMode(getActionModeWrapper(paramActionMode), getMenuWrapper(paramMenu));
  }
  
  public void onDestroyActionMode(android.support.v7.view.ActionMode paramActionMode)
  {
    this.mWrappedCallback.onDestroyActionMode(getActionModeWrapper(paramActionMode));
  }
  
  public boolean onPrepareActionMode(android.support.v7.view.ActionMode paramActionMode, Menu paramMenu)
  {
    return this.mWrappedCallback.onPrepareActionMode(getActionModeWrapper(paramActionMode), getMenuWrapper(paramMenu));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.SupportActionModeWrapper.CallbackWrapper
 * JD-Core Version:    0.7.0.1
 */