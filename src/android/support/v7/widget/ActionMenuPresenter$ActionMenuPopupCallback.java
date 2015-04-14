package android.support.v7.widget;

import android.support.v7.internal.view.menu.ActionMenuItemView.PopupCallback;

class ActionMenuPresenter$ActionMenuPopupCallback
  extends ActionMenuItemView.PopupCallback
{
  private ActionMenuPresenter$ActionMenuPopupCallback(ActionMenuPresenter paramActionMenuPresenter) {}
  
  public ListPopupWindow getPopup()
  {
    if (ActionMenuPresenter.access$700(this.this$0) != null) {}
    for (ListPopupWindow localListPopupWindow = ActionMenuPresenter.access$700(this.this$0).getPopup();; localListPopupWindow = null) {
      return localListPopupWindow;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter.ActionMenuPopupCallback
 * JD-Core Version:    0.7.0.1
 */