package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.internal.view.SupportMenuItem;
import android.view.MenuItem;
import android.view.View;

public class MenuItemCompat
{
  static final MenuItemCompat.MenuVersionImpl IMPL;
  public static final int SHOW_AS_ACTION_ALWAYS = 2;
  public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
  public static final int SHOW_AS_ACTION_IF_ROOM = 1;
  public static final int SHOW_AS_ACTION_NEVER = 0;
  public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
  private static final String TAG = "MenuItemCompat";
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 14) {
      IMPL = new MenuItemCompat.IcsMenuVersionImpl();
    }
    for (;;)
    {
      return;
      if (i >= 11) {
        IMPL = new MenuItemCompat.HoneycombMenuVersionImpl();
      } else {
        IMPL = new MenuItemCompat.BaseMenuVersionImpl();
      }
    }
  }
  
  public static boolean collapseActionView(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {}
    for (boolean bool = ((SupportMenuItem)paramMenuItem).collapseActionView();; bool = IMPL.collapseActionView(paramMenuItem)) {
      return bool;
    }
  }
  
  public static boolean expandActionView(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {}
    for (boolean bool = ((SupportMenuItem)paramMenuItem).expandActionView();; bool = IMPL.expandActionView(paramMenuItem)) {
      return bool;
    }
  }
  
  public static ActionProvider getActionProvider(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {}
    for (ActionProvider localActionProvider = ((SupportMenuItem)paramMenuItem).getSupportActionProvider();; localActionProvider = null) {
      return localActionProvider;
    }
  }
  
  public static View getActionView(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {}
    for (View localView = ((SupportMenuItem)paramMenuItem).getActionView();; localView = IMPL.getActionView(paramMenuItem)) {
      return localView;
    }
  }
  
  public static boolean isActionViewExpanded(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {}
    for (boolean bool = ((SupportMenuItem)paramMenuItem).isActionViewExpanded();; bool = IMPL.isActionViewExpanded(paramMenuItem)) {
      return bool;
    }
  }
  
  public static MenuItem setActionProvider(MenuItem paramMenuItem, ActionProvider paramActionProvider)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      paramMenuItem = ((SupportMenuItem)paramMenuItem).setSupportActionProvider(paramActionProvider);
    }
    return paramMenuItem;
  }
  
  public static MenuItem setActionView(MenuItem paramMenuItem, int paramInt)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {}
    for (MenuItem localMenuItem = ((SupportMenuItem)paramMenuItem).setActionView(paramInt);; localMenuItem = IMPL.setActionView(paramMenuItem, paramInt)) {
      return localMenuItem;
    }
  }
  
  public static MenuItem setActionView(MenuItem paramMenuItem, View paramView)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {}
    for (MenuItem localMenuItem = ((SupportMenuItem)paramMenuItem).setActionView(paramView);; localMenuItem = IMPL.setActionView(paramMenuItem, paramView)) {
      return localMenuItem;
    }
  }
  
  public static MenuItem setOnActionExpandListener(MenuItem paramMenuItem, MenuItemCompat.OnActionExpandListener paramOnActionExpandListener)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {}
    for (Object localObject = ((SupportMenuItem)paramMenuItem).setSupportOnActionExpandListener(paramOnActionExpandListener);; localObject = IMPL.setOnActionExpandListener(paramMenuItem, paramOnActionExpandListener)) {
      return localObject;
    }
  }
  
  public static void setShowAsAction(MenuItem paramMenuItem, int paramInt)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      ((SupportMenuItem)paramMenuItem).setShowAsAction(paramInt);
    }
    for (;;)
    {
      return;
      IMPL.setShowAsAction(paramMenuItem, paramInt);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.MenuItemCompat
 * JD-Core Version:    0.7.0.1
 */