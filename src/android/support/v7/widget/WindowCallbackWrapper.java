package android.support.v7.widget;

import android.support.v7.internal.app.WindowCallback;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class WindowCallbackWrapper
  implements WindowCallback
{
  private WindowCallback mWrapped;
  
  public WindowCallbackWrapper(WindowCallback paramWindowCallback)
  {
    if (paramWindowCallback == null) {
      throw new IllegalArgumentException("Window callback may not be null");
    }
    this.mWrapped = paramWindowCallback;
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    return this.mWrapped.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public View onCreatePanelView(int paramInt)
  {
    return this.mWrapped.onCreatePanelView(paramInt);
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    return this.mWrapped.onMenuItemSelected(paramInt, paramMenuItem);
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return this.mWrapped.onMenuOpened(paramInt, paramMenu);
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    this.mWrapped.onPanelClosed(paramInt, paramMenu);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    return this.mWrapped.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  public ActionMode startActionMode(ActionMode.Callback paramCallback)
  {
    return this.mWrapped.startActionMode(paramCallback);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.WindowCallbackWrapper
 * JD-Core Version:    0.7.0.1
 */