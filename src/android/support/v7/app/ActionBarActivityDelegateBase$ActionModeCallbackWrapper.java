package android.support.v7.app;

import android.support.v4.view.ViewCompat;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.PopupWindow;

class ActionBarActivityDelegateBase$ActionModeCallbackWrapper
  implements ActionMode.Callback
{
  private ActionMode.Callback mWrapped;
  
  public ActionBarActivityDelegateBase$ActionModeCallbackWrapper(ActionBarActivityDelegateBase paramActionBarActivityDelegateBase, ActionMode.Callback paramCallback)
  {
    this.mWrapped = paramCallback;
  }
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return this.mWrapped.onActionItemClicked(paramActionMode, paramMenuItem);
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return this.mWrapped.onCreateActionMode(paramActionMode, paramMenu);
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode)
  {
    this.mWrapped.onDestroyActionMode(paramActionMode);
    if (this.this$0.mActionModePopup != null)
    {
      this.this$0.mActivity.getWindow().getDecorView().removeCallbacks(this.this$0.mShowActionModePopup);
      this.this$0.mActionModePopup.dismiss();
    }
    for (;;)
    {
      if (this.this$0.mActionModeView != null) {
        this.this$0.mActionModeView.removeAllViews();
      }
      if (this.this$0.mActivity != null) {}
      try
      {
        this.this$0.mActivity.onSupportActionModeFinished(this.this$0.mActionMode);
        label101:
        this.this$0.mActionMode = null;
        return;
        if (this.this$0.mActionModeView == null) {
          continue;
        }
        this.this$0.mActionModeView.setVisibility(8);
        if (this.this$0.mActionModeView.getParent() == null) {
          continue;
        }
        ViewCompat.requestApplyInsets((View)this.this$0.mActionModeView.getParent());
      }
      catch (AbstractMethodError localAbstractMethodError)
      {
        break label101;
      }
    }
  }
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return this.mWrapped.onPrepareActionMode(paramActionMode, paramMenu);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegateBase.ActionModeCallbackWrapper
 * JD-Core Version:    0.7.0.1
 */