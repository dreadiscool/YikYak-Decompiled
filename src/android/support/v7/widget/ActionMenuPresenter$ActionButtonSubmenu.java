package android.support.v7.widget;

import android.content.Context;
import android.support.v7.appcompat.R.attr;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuPopupHelper;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.view.MenuItem;
import android.view.View;

class ActionMenuPresenter$ActionButtonSubmenu
  extends MenuPopupHelper
{
  private SubMenuBuilder mSubMenu;
  
  public ActionMenuPresenter$ActionButtonSubmenu(ActionMenuPresenter paramActionMenuPresenter, Context paramContext, SubMenuBuilder paramSubMenuBuilder)
  {
    super(paramContext, paramSubMenuBuilder, null, false, R.attr.actionOverflowMenuStyle);
    this.mSubMenu = paramSubMenuBuilder;
    View localView;
    int i;
    if (!((MenuItemImpl)paramSubMenuBuilder.getItem()).isActionButton())
    {
      if (ActionMenuPresenter.access$500(paramActionMenuPresenter) == null)
      {
        localView = (View)ActionMenuPresenter.access$600(paramActionMenuPresenter);
        setAnchorView(localView);
      }
    }
    else
    {
      setCallback(paramActionMenuPresenter.mPopupPresenterCallback);
      i = paramSubMenuBuilder.size();
    }
    for (int j = 0;; j++) {
      if (j < i)
      {
        MenuItem localMenuItem = paramSubMenuBuilder.getItem(j);
        if ((localMenuItem.isVisible()) && (localMenuItem.getIcon() != null)) {
          bool = true;
        }
      }
      else
      {
        setForceShowIcon(bool);
        return;
        localView = ActionMenuPresenter.access$500(paramActionMenuPresenter);
        break;
      }
    }
  }
  
  public void onDismiss()
  {
    super.onDismiss();
    ActionMenuPresenter.access$702(this.this$0, null);
    this.this$0.mOpenSubMenuId = 0;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter.ActionButtonSubmenu
 * JD-Core Version:    0.7.0.1
 */