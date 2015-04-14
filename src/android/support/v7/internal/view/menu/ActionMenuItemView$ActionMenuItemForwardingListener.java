package android.support.v7.internal.view.menu;

import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ListPopupWindow.ForwardingListener;

class ActionMenuItemView$ActionMenuItemForwardingListener
  extends ListPopupWindow.ForwardingListener
{
  public ActionMenuItemView$ActionMenuItemForwardingListener(ActionMenuItemView paramActionMenuItemView)
  {
    super(paramActionMenuItemView);
  }
  
  public ListPopupWindow getPopup()
  {
    if (ActionMenuItemView.access$000(this.this$0) != null) {}
    for (ListPopupWindow localListPopupWindow = ActionMenuItemView.access$000(this.this$0).getPopup();; localListPopupWindow = null) {
      return localListPopupWindow;
    }
  }
  
  protected boolean onForwardingStarted()
  {
    boolean bool = false;
    if ((ActionMenuItemView.access$100(this.this$0) != null) && (ActionMenuItemView.access$100(this.this$0).invokeItem(ActionMenuItemView.access$200(this.this$0))))
    {
      ListPopupWindow localListPopupWindow = getPopup();
      if ((localListPopupWindow != null) && (localListPopupWindow.isShowing())) {
        bool = true;
      }
    }
    return bool;
  }
  
  protected boolean onForwardingStopped()
  {
    ListPopupWindow localListPopupWindow = getPopup();
    if (localListPopupWindow != null) {
      localListPopupWindow.dismiss();
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.ActionMenuItemView.ActionMenuItemForwardingListener
 * JD-Core Version:    0.7.0.1
 */