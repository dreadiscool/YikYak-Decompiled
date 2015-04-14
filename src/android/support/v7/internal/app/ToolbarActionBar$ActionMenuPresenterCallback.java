package android.support.v7.internal.app;

import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.widget.Toolbar;

final class ToolbarActionBar$ActionMenuPresenterCallback
  implements MenuPresenter.Callback
{
  private boolean mClosingActionMenu;
  
  private ToolbarActionBar$ActionMenuPresenterCallback(ToolbarActionBar paramToolbarActionBar) {}
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (this.mClosingActionMenu) {}
    for (;;)
    {
      return;
      this.mClosingActionMenu = true;
      ToolbarActionBar.access$400(this.this$0).dismissPopupMenus();
      if (ToolbarActionBar.access$000(this.this$0) != null) {
        ToolbarActionBar.access$000(this.this$0).onPanelClosed(8, paramMenuBuilder);
      }
      this.mClosingActionMenu = false;
    }
  }
  
  public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
  {
    if (ToolbarActionBar.access$000(this.this$0) != null) {
      ToolbarActionBar.access$000(this.this$0).onMenuOpened(8, paramMenuBuilder);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.app.ToolbarActionBar.ActionMenuPresenterCallback
 * JD-Core Version:    0.7.0.1
 */