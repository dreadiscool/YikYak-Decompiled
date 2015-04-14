package android.support.v7.widget;

import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.view.MenuItem;

class ActionMenuView$MenuBuilderCallback
  implements MenuBuilder.Callback
{
  private ActionMenuView$MenuBuilderCallback(ActionMenuView paramActionMenuView) {}
  
  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    if ((ActionMenuView.access$200(this.this$0) != null) && (ActionMenuView.access$200(this.this$0).onMenuItemClick(paramMenuItem))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void onMenuModeChange(MenuBuilder paramMenuBuilder)
  {
    if (ActionMenuView.access$300(this.this$0) != null) {
      ActionMenuView.access$300(this.this$0).onMenuModeChange(paramMenuBuilder);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuView.MenuBuilderCallback
 * JD-Core Version:    0.7.0.1
 */