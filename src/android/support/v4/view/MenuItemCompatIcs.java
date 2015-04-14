package android.support.v4.view;

import android.view.MenuItem;

class MenuItemCompatIcs
{
  public static boolean collapseActionView(MenuItem paramMenuItem)
  {
    return paramMenuItem.collapseActionView();
  }
  
  public static boolean expandActionView(MenuItem paramMenuItem)
  {
    return paramMenuItem.expandActionView();
  }
  
  public static boolean isActionViewExpanded(MenuItem paramMenuItem)
  {
    return paramMenuItem.isActionViewExpanded();
  }
  
  public static MenuItem setOnActionExpandListener(MenuItem paramMenuItem, MenuItemCompatIcs.SupportActionExpandProxy paramSupportActionExpandProxy)
  {
    return paramMenuItem.setOnActionExpandListener(new MenuItemCompatIcs.OnActionExpandListenerWrapper(paramSupportActionExpandProxy));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.MenuItemCompatIcs
 * JD-Core Version:    0.7.0.1
 */