package android.support.v7.view;

import android.view.Menu;
import android.view.MenuItem;

public abstract interface ActionMode$Callback
{
  public abstract boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem);
  
  public abstract boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu);
  
  public abstract void onDestroyActionMode(ActionMode paramActionMode);
  
  public abstract boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.view.ActionMode.Callback
 * JD-Core Version:    0.7.0.1
 */