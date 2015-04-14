package android.support.v7.widget;

import android.content.Context;
import android.support.v7.appcompat.R.attr;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.support.v7.internal.view.menu.MenuPopupHelper;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnTouchListener;

public class PopupMenu
  implements MenuBuilder.Callback, MenuPresenter.Callback
{
  private View mAnchor;
  private Context mContext;
  private PopupMenu.OnDismissListener mDismissListener;
  private View.OnTouchListener mDragListener;
  private MenuBuilder mMenu;
  private PopupMenu.OnMenuItemClickListener mMenuItemClickListener;
  private MenuPopupHelper mPopup;
  
  public PopupMenu(Context paramContext, View paramView)
  {
    this(paramContext, paramView, 0);
  }
  
  public PopupMenu(Context paramContext, View paramView, int paramInt)
  {
    this(paramContext, paramView, paramInt, R.attr.popupMenuStyle, 0);
  }
  
  public PopupMenu(Context paramContext, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mContext = paramContext;
    this.mMenu = new MenuBuilder(paramContext);
    this.mMenu.setCallback(this);
    this.mAnchor = paramView;
    this.mPopup = new MenuPopupHelper(paramContext, this.mMenu, paramView, false, paramInt2, paramInt3);
    this.mPopup.setGravity(paramInt1);
    this.mPopup.setCallback(this);
  }
  
  public void dismiss()
  {
    this.mPopup.dismiss();
  }
  
  public View.OnTouchListener getDragToOpenListener()
  {
    if (this.mDragListener == null) {
      this.mDragListener = new PopupMenu.1(this, this.mAnchor);
    }
    return this.mDragListener;
  }
  
  public Menu getMenu()
  {
    return this.mMenu;
  }
  
  public MenuInflater getMenuInflater()
  {
    return new SupportMenuInflater(this.mContext);
  }
  
  public void inflate(int paramInt)
  {
    getMenuInflater().inflate(paramInt, this.mMenu);
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (this.mDismissListener != null) {
      this.mDismissListener.onDismiss(this);
    }
  }
  
  public void onCloseSubMenu(SubMenuBuilder paramSubMenuBuilder) {}
  
  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    if (this.mMenuItemClickListener != null) {}
    for (boolean bool = this.mMenuItemClickListener.onMenuItemClick(paramMenuItem);; bool = false) {
      return bool;
    }
  }
  
  public void onMenuModeChange(MenuBuilder paramMenuBuilder) {}
  
  public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
  {
    boolean bool = true;
    if (paramMenuBuilder == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (paramMenuBuilder.hasVisibleItems()) {
        new MenuPopupHelper(this.mContext, paramMenuBuilder, this.mAnchor).show();
      }
    }
  }
  
  public void setOnDismissListener(PopupMenu.OnDismissListener paramOnDismissListener)
  {
    this.mDismissListener = paramOnDismissListener;
  }
  
  public void setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mMenuItemClickListener = paramOnMenuItemClickListener;
  }
  
  public void show()
  {
    this.mPopup.show();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.PopupMenu
 * JD-Core Version:    0.7.0.1
 */