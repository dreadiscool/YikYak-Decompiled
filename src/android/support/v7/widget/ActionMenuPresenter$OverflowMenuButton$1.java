package android.support.v7.widget;

import android.view.View;

class ActionMenuPresenter$OverflowMenuButton$1
  extends ListPopupWindow.ForwardingListener
{
  ActionMenuPresenter$OverflowMenuButton$1(ActionMenuPresenter.OverflowMenuButton paramOverflowMenuButton, View paramView, ActionMenuPresenter paramActionMenuPresenter)
  {
    super(paramView);
  }
  
  public ListPopupWindow getPopup()
  {
    if (ActionMenuPresenter.access$200(this.this$1.this$0) == null) {}
    for (ListPopupWindow localListPopupWindow = null;; localListPopupWindow = ActionMenuPresenter.access$200(this.this$1.this$0).getPopup()) {
      return localListPopupWindow;
    }
  }
  
  public boolean onForwardingStarted()
  {
    this.this$1.this$0.showOverflowMenu();
    return true;
  }
  
  public boolean onForwardingStopped()
  {
    if (ActionMenuPresenter.access$300(this.this$1.this$0) != null) {}
    for (boolean bool = false;; bool = true)
    {
      return bool;
      this.this$1.this$0.hideOverflowMenu();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter.OverflowMenuButton.1
 * JD-Core Version:    0.7.0.1
 */