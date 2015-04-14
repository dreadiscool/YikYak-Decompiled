package android.support.v7.widget;

import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.view.MenuItem;

class ActionMenuPresenter$PopupPresenterCallback
  implements MenuPresenter.Callback
{
  private ActionMenuPresenter$PopupPresenterCallback(ActionMenuPresenter paramActionMenuPresenter) {}
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if ((paramMenuBuilder instanceof SubMenuBuilder)) {
      ((SubMenuBuilder)paramMenuBuilder).getRootMenu().close(false);
    }
    MenuPresenter.Callback localCallback = this.this$0.getCallback();
    if (localCallback != null) {
      localCallback.onCloseMenu(paramMenuBuilder, paramBoolean);
    }
  }
  
  public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
  {
    boolean bool1 = false;
    if (paramMenuBuilder == null) {
      return bool1;
    }
    this.this$0.mOpenSubMenuId = ((SubMenuBuilder)paramMenuBuilder).getItem().getItemId();
    MenuPresenter.Callback localCallback = this.this$0.getCallback();
    if (localCallback != null) {}
    for (boolean bool2 = localCallback.onOpenSubMenu(paramMenuBuilder);; bool2 = false)
    {
      bool1 = bool2;
      break;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter.PopupPresenterCallback
 * JD-Core Version:    0.7.0.1
 */