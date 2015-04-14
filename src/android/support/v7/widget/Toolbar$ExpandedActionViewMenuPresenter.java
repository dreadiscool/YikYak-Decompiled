package android.support.v7.widget;

import android.content.Context;
import android.os.Parcelable;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.support.v7.view.CollapsibleActionView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

class Toolbar$ExpandedActionViewMenuPresenter
  implements MenuPresenter
{
  MenuItemImpl mCurrentExpandedItem;
  MenuBuilder mMenu;
  
  private Toolbar$ExpandedActionViewMenuPresenter(Toolbar paramToolbar) {}
  
  public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    if ((this.this$0.mExpandedActionView instanceof CollapsibleActionView)) {
      ((CollapsibleActionView)this.this$0.mExpandedActionView).onActionViewCollapsed();
    }
    this.this$0.removeView(this.this$0.mExpandedActionView);
    this.this$0.removeView(Toolbar.access$300(this.this$0));
    this.this$0.mExpandedActionView = null;
    Toolbar.access$500(this.this$0, false);
    this.mCurrentExpandedItem = null;
    this.this$0.requestLayout();
    paramMenuItemImpl.setActionViewExpanded(false);
    return true;
  }
  
  public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    Toolbar.access$200(this.this$0);
    if (Toolbar.access$300(this.this$0).getParent() != this.this$0) {
      this.this$0.addView(Toolbar.access$300(this.this$0));
    }
    this.this$0.mExpandedActionView = paramMenuItemImpl.getActionView();
    this.mCurrentExpandedItem = paramMenuItemImpl;
    if (this.this$0.mExpandedActionView.getParent() != this.this$0)
    {
      Toolbar.LayoutParams localLayoutParams = this.this$0.generateDefaultLayoutParams();
      localLayoutParams.gravity = (0x800003 | 0x70 & Toolbar.access$400(this.this$0));
      localLayoutParams.mViewType = 2;
      this.this$0.mExpandedActionView.setLayoutParams(localLayoutParams);
      this.this$0.addView(this.this$0.mExpandedActionView);
    }
    Toolbar.access$500(this.this$0, true);
    this.this$0.requestLayout();
    paramMenuItemImpl.setActionViewExpanded(true);
    if ((this.this$0.mExpandedActionView instanceof CollapsibleActionView)) {
      ((CollapsibleActionView)this.this$0.mExpandedActionView).onActionViewExpanded();
    }
    return true;
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public int getId()
  {
    return 0;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    if ((this.mMenu != null) && (this.mCurrentExpandedItem != null)) {
      this.mMenu.collapseItemActionView(this.mCurrentExpandedItem);
    }
    this.mMenu = paramMenuBuilder;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {}
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    return false;
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback) {}
  
  public void updateMenuView(boolean paramBoolean)
  {
    int i = 0;
    int j;
    if (this.mCurrentExpandedItem != null) {
      if (this.mMenu != null) {
        j = this.mMenu.size();
      }
    }
    for (int k = 0;; k++) {
      if (k < j)
      {
        if (this.mMenu.getItem(k) == this.mCurrentExpandedItem) {
          i = 1;
        }
      }
      else
      {
        if (i == 0) {
          collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
        }
        return;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.Toolbar.ExpandedActionViewMenuPresenter
 * JD-Core Version:    0.7.0.1
 */