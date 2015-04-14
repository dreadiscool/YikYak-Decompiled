package android.support.v7.internal.view.menu;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MenuItemWrapperICS$OnMenuItemClickListenerWrapper
  extends BaseWrapper<MenuItem.OnMenuItemClickListener>
  implements MenuItem.OnMenuItemClickListener
{
  MenuItemWrapperICS$OnMenuItemClickListenerWrapper(MenuItemWrapperICS paramMenuItemWrapperICS, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    super(paramOnMenuItemClickListener);
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    return ((MenuItem.OnMenuItemClickListener)this.mWrappedObject).onMenuItemClick(this.this$0.getMenuItemWrapper(paramMenuItem));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuItemWrapperICS.OnMenuItemClickListenerWrapper
 * JD-Core Version:    0.7.0.1
 */