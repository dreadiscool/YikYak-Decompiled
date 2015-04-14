package android.support.v7.internal.app;

import android.support.v7.internal.widget.DecorToolbar;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.WindowCallbackWrapper;
import android.view.Menu;
import android.view.View;

class ToolbarActionBar$ToolbarCallbackWrapper
  extends WindowCallbackWrapper
{
  public ToolbarActionBar$ToolbarCallbackWrapper(ToolbarActionBar paramToolbarActionBar, WindowCallback paramWindowCallback)
  {
    super(paramWindowCallback);
  }
  
  public View onCreatePanelView(int paramInt)
  {
    switch (paramInt)
    {
    }
    Menu localMenu;
    for (View localView = super.onCreatePanelView(paramInt);; localView = ToolbarActionBar.access$600(this.this$0, localMenu))
    {
      return localView;
      if (!ToolbarActionBar.access$100(this.this$0))
      {
        this.this$0.populateOptionsMenu();
        ToolbarActionBar.access$400(this.this$0).removeCallbacks(ToolbarActionBar.access$300(this.this$0));
      }
      if ((!ToolbarActionBar.access$100(this.this$0)) || (ToolbarActionBar.access$000(this.this$0) == null)) {
        break;
      }
      localMenu = ToolbarActionBar.access$500(this.this$0);
      if ((!ToolbarActionBar.access$000(this.this$0).onPreparePanel(paramInt, null, localMenu)) || (!ToolbarActionBar.access$000(this.this$0).onMenuOpened(paramInt, localMenu))) {
        break;
      }
    }
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    boolean bool = super.onPreparePanel(paramInt, paramView, paramMenu);
    if ((bool) && (!ToolbarActionBar.access$100(this.this$0)))
    {
      ToolbarActionBar.access$200(this.this$0).setMenuPrepared();
      ToolbarActionBar.access$102(this.this$0, true);
    }
    return bool;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.app.ToolbarActionBar.ToolbarCallbackWrapper
 * JD-Core Version:    0.7.0.1
 */