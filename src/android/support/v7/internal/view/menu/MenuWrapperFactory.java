package android.support.v7.internal.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public final class MenuWrapperFactory
{
  public static Menu wrapSupportMenu(Context paramContext, SupportMenu paramSupportMenu)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return new MenuWrapperICS(paramContext, paramSupportMenu);
    }
    throw new UnsupportedOperationException();
  }
  
  public static MenuItem wrapSupportMenuItem(Context paramContext, SupportMenuItem paramSupportMenuItem)
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (Object localObject = new MenuItemWrapperJB(paramContext, paramSupportMenuItem);; localObject = new MenuItemWrapperICS(paramContext, paramSupportMenuItem))
    {
      return localObject;
      if (Build.VERSION.SDK_INT < 14) {
        break;
      }
    }
    throw new UnsupportedOperationException();
  }
  
  public static SubMenu wrapSupportSubMenu(Context paramContext, SupportSubMenu paramSupportSubMenu)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return new SubMenuWrapperICS(paramContext, paramSupportSubMenu);
    }
    throw new UnsupportedOperationException();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuWrapperFactory
 * JD-Core Version:    0.7.0.1
 */