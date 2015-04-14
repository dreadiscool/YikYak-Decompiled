package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.support.v4.util.ArrayMap;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class BaseMenuWrapper<T>
  extends BaseWrapper<T>
{
  final Context mContext;
  private Map<SupportMenuItem, MenuItem> mMenuItems;
  private Map<SupportSubMenu, SubMenu> mSubMenus;
  
  BaseMenuWrapper(Context paramContext, T paramT)
  {
    super(paramT);
    this.mContext = paramContext;
  }
  
  final MenuItem getMenuItemWrapper(MenuItem paramMenuItem)
  {
    MenuItem localMenuItem;
    if ((paramMenuItem instanceof SupportMenuItem))
    {
      SupportMenuItem localSupportMenuItem = (SupportMenuItem)paramMenuItem;
      if (this.mMenuItems == null) {
        this.mMenuItems = new ArrayMap();
      }
      localMenuItem = (MenuItem)this.mMenuItems.get(paramMenuItem);
      if (localMenuItem == null)
      {
        localMenuItem = MenuWrapperFactory.wrapSupportMenuItem(this.mContext, localSupportMenuItem);
        this.mMenuItems.put(localSupportMenuItem, localMenuItem);
      }
    }
    for (;;)
    {
      return localMenuItem;
      localMenuItem = paramMenuItem;
    }
  }
  
  final SubMenu getSubMenuWrapper(SubMenu paramSubMenu)
  {
    SubMenu localSubMenu;
    if ((paramSubMenu instanceof SupportSubMenu))
    {
      SupportSubMenu localSupportSubMenu = (SupportSubMenu)paramSubMenu;
      if (this.mSubMenus == null) {
        this.mSubMenus = new ArrayMap();
      }
      localSubMenu = (SubMenu)this.mSubMenus.get(localSupportSubMenu);
      if (localSubMenu == null)
      {
        localSubMenu = MenuWrapperFactory.wrapSupportSubMenu(this.mContext, localSupportSubMenu);
        this.mSubMenus.put(localSupportSubMenu, localSubMenu);
      }
    }
    for (;;)
    {
      return localSubMenu;
      localSubMenu = paramSubMenu;
    }
  }
  
  final void internalClear()
  {
    if (this.mMenuItems != null) {
      this.mMenuItems.clear();
    }
    if (this.mSubMenus != null) {
      this.mSubMenus.clear();
    }
  }
  
  final void internalRemoveGroup(int paramInt)
  {
    if (this.mMenuItems == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.mMenuItems.keySet().iterator();
      while (localIterator.hasNext()) {
        if (paramInt == ((MenuItem)localIterator.next()).getGroupId()) {
          localIterator.remove();
        }
      }
    }
  }
  
  final void internalRemoveItem(int paramInt)
  {
    if (this.mMenuItems == null) {
      return;
    }
    for (;;)
    {
      Iterator localIterator = this.mMenuItems.keySet().iterator();
      if (localIterator.hasNext())
      {
        if (paramInt != ((MenuItem)localIterator.next()).getItemId()) {
          break;
        }
        localIterator.remove();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.BaseMenuWrapper
 * JD-Core Version:    0.7.0.1
 */