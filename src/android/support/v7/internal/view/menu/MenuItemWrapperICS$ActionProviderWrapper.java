package android.support.v7.internal.view.menu;

import android.content.Context;
import android.view.SubMenu;
import android.view.View;

class MenuItemWrapperICS$ActionProviderWrapper
  extends android.support.v4.view.ActionProvider
{
  final android.view.ActionProvider mInner;
  
  public MenuItemWrapperICS$ActionProviderWrapper(MenuItemWrapperICS paramMenuItemWrapperICS, Context paramContext, android.view.ActionProvider paramActionProvider)
  {
    super(paramContext);
    this.mInner = paramActionProvider;
  }
  
  public boolean hasSubMenu()
  {
    return this.mInner.hasSubMenu();
  }
  
  public View onCreateActionView()
  {
    return this.mInner.onCreateActionView();
  }
  
  public boolean onPerformDefaultAction()
  {
    return this.mInner.onPerformDefaultAction();
  }
  
  public void onPrepareSubMenu(SubMenu paramSubMenu)
  {
    this.mInner.onPrepareSubMenu(this.this$0.getSubMenuWrapper(paramSubMenu));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuItemWrapperICS.ActionProviderWrapper
 * JD-Core Version:    0.7.0.1
 */