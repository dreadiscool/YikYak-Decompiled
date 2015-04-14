package android.support.v7.internal.app;

import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.view.Window;

final class ToolbarActionBar$PanelMenuPresenterCallback
  implements MenuPresenter.Callback
{
  private ToolbarActionBar$PanelMenuPresenterCallback(ToolbarActionBar paramToolbarActionBar) {}
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (ToolbarActionBar.access$000(this.this$0) != null) {
      ToolbarActionBar.access$000(this.this$0).onPanelClosed(0, paramMenuBuilder);
    }
    ToolbarActionBar.access$1000(this.this$0).closePanel(0);
  }
  
  public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
  {
    if ((paramMenuBuilder == null) && (ToolbarActionBar.access$000(this.this$0) != null)) {
      ToolbarActionBar.access$000(this.this$0).onMenuOpened(0, paramMenuBuilder);
    }
    return true;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.app.ToolbarActionBar.PanelMenuPresenterCallback
 * JD-Core Version:    0.7.0.1
 */