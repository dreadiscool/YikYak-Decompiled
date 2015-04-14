package android.support.v7.internal.view.menu;

import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

class MenuItemWrapperICS$OnActionExpandListenerWrapper
  extends BaseWrapper<MenuItem.OnActionExpandListener>
  implements MenuItemCompat.OnActionExpandListener
{
  MenuItemWrapperICS$OnActionExpandListenerWrapper(MenuItemWrapperICS paramMenuItemWrapperICS, MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    super(paramOnActionExpandListener);
  }
  
  public boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
  {
    return ((MenuItem.OnActionExpandListener)this.mWrappedObject).onMenuItemActionCollapse(this.this$0.getMenuItemWrapper(paramMenuItem));
  }
  
  public boolean onMenuItemActionExpand(MenuItem paramMenuItem)
  {
    return ((MenuItem.OnActionExpandListener)this.mWrappedObject).onMenuItemActionExpand(this.this$0.getMenuItemWrapper(paramMenuItem));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuItemWrapperICS.OnActionExpandListenerWrapper
 * JD-Core Version:    0.7.0.1
 */