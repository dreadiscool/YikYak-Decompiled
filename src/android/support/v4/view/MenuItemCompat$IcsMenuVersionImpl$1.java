package android.support.v4.view;

import android.view.MenuItem;

class MenuItemCompat$IcsMenuVersionImpl$1
  implements MenuItemCompatIcs.SupportActionExpandProxy
{
  MenuItemCompat$IcsMenuVersionImpl$1(MenuItemCompat.IcsMenuVersionImpl paramIcsMenuVersionImpl, MenuItemCompat.OnActionExpandListener paramOnActionExpandListener) {}
  
  public boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
  {
    return this.val$listener.onMenuItemActionCollapse(paramMenuItem);
  }
  
  public boolean onMenuItemActionExpand(MenuItem paramMenuItem)
  {
    return this.val$listener.onMenuItemActionExpand(paramMenuItem);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.MenuItemCompat.IcsMenuVersionImpl.1
 * JD-Core Version:    0.7.0.1
 */