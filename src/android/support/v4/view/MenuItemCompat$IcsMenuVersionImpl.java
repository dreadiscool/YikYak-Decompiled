package android.support.v4.view;

import android.view.MenuItem;

class MenuItemCompat$IcsMenuVersionImpl
  extends MenuItemCompat.HoneycombMenuVersionImpl
{
  public boolean collapseActionView(MenuItem paramMenuItem)
  {
    return MenuItemCompatIcs.collapseActionView(paramMenuItem);
  }
  
  public boolean expandActionView(MenuItem paramMenuItem)
  {
    return MenuItemCompatIcs.expandActionView(paramMenuItem);
  }
  
  public boolean isActionViewExpanded(MenuItem paramMenuItem)
  {
    return MenuItemCompatIcs.isActionViewExpanded(paramMenuItem);
  }
  
  public MenuItem setOnActionExpandListener(MenuItem paramMenuItem, MenuItemCompat.OnActionExpandListener paramOnActionExpandListener)
  {
    if (paramOnActionExpandListener == null) {}
    for (MenuItem localMenuItem = MenuItemCompatIcs.setOnActionExpandListener(paramMenuItem, null);; localMenuItem = MenuItemCompatIcs.setOnActionExpandListener(paramMenuItem, new MenuItemCompat.IcsMenuVersionImpl.1(this, paramOnActionExpandListener))) {
      return localMenuItem;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.MenuItemCompat.IcsMenuVersionImpl
 * JD-Core Version:    0.7.0.1
 */