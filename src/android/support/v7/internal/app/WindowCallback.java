package android.support.v7.internal.app;

import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public abstract interface WindowCallback
{
  public abstract boolean onCreatePanelMenu(int paramInt, Menu paramMenu);
  
  public abstract View onCreatePanelView(int paramInt);
  
  public abstract boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem);
  
  public abstract boolean onMenuOpened(int paramInt, Menu paramMenu);
  
  public abstract void onPanelClosed(int paramInt, Menu paramMenu);
  
  public abstract boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu);
  
  public abstract ActionMode startActionMode(ActionMode.Callback paramCallback);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.app.WindowCallback
 * JD-Core Version:    0.7.0.1
 */