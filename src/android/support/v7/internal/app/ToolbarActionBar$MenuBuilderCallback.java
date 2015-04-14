package android.support.v7.internal.app;

import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

final class ToolbarActionBar$MenuBuilderCallback
  implements MenuBuilder.Callback
{
  private ToolbarActionBar$MenuBuilderCallback(ToolbarActionBar paramToolbarActionBar) {}
  
  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    return false;
  }
  
  public void onMenuModeChange(MenuBuilder paramMenuBuilder)
  {
    if (ToolbarActionBar.access$000(this.this$0) != null)
    {
      if (!ToolbarActionBar.access$400(this.this$0).isOverflowMenuShowing()) {
        break label39;
      }
      ToolbarActionBar.access$000(this.this$0).onPanelClosed(8, paramMenuBuilder);
    }
    for (;;)
    {
      return;
      label39:
      if (ToolbarActionBar.access$000(this.this$0).onPreparePanel(0, null, paramMenuBuilder)) {
        ToolbarActionBar.access$000(this.this$0).onMenuOpened(8, paramMenuBuilder);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.app.ToolbarActionBar.MenuBuilderCallback
 * JD-Core Version:    0.7.0.1
 */