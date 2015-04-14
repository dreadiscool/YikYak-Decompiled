package android.support.v7.internal.view.menu;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.style;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ListAdapter;

public class MenuDialogHelper
  implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, MenuPresenter.Callback
{
  private AlertDialog mDialog;
  private MenuBuilder mMenu;
  ListMenuPresenter mPresenter;
  private MenuPresenter.Callback mPresenterCallback;
  
  public MenuDialogHelper(MenuBuilder paramMenuBuilder)
  {
    this.mMenu = paramMenuBuilder;
  }
  
  public void dismiss()
  {
    if (this.mDialog != null) {
      this.mDialog.dismiss();
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.mMenu.performItemAction((MenuItemImpl)this.mPresenter.getAdapter().getItem(paramInt), 0);
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if ((paramBoolean) || (paramMenuBuilder == this.mMenu)) {
      dismiss();
    }
    if (this.mPresenterCallback != null) {
      this.mPresenterCallback.onCloseMenu(paramMenuBuilder, paramBoolean);
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.mPresenter.onCloseMenu(this.mMenu, true);
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    int i = 1;
    if ((paramInt == 82) || (paramInt == 4)) {
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        Window localWindow2 = this.mDialog.getWindow();
        if (localWindow2 == null) {
          break label157;
        }
        View localView2 = localWindow2.getDecorView();
        if (localView2 == null) {
          break label157;
        }
        KeyEvent.DispatcherState localDispatcherState2 = localView2.getKeyDispatcherState();
        if (localDispatcherState2 == null) {
          break label157;
        }
        localDispatcherState2.startTracking(paramKeyEvent, this);
      }
    }
    for (;;)
    {
      return i;
      if ((paramKeyEvent.getAction() == i) && (!paramKeyEvent.isCanceled()))
      {
        Window localWindow1 = this.mDialog.getWindow();
        if (localWindow1 != null)
        {
          View localView1 = localWindow1.getDecorView();
          if (localView1 != null)
          {
            KeyEvent.DispatcherState localDispatcherState1 = localView1.getKeyDispatcherState();
            if ((localDispatcherState1 != null) && (localDispatcherState1.isTracking(paramKeyEvent)))
            {
              this.mMenu.close(i);
              paramDialogInterface.dismiss();
              continue;
            }
          }
        }
      }
      label157:
      boolean bool = this.mMenu.performShortcut(paramInt, paramKeyEvent, 0);
    }
  }
  
  public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
  {
    if (this.mPresenterCallback != null) {}
    for (boolean bool = this.mPresenterCallback.onOpenSubMenu(paramMenuBuilder);; bool = false) {
      return bool;
    }
  }
  
  public void setPresenterCallback(MenuPresenter.Callback paramCallback)
  {
    this.mPresenterCallback = paramCallback;
  }
  
  public void show(IBinder paramIBinder)
  {
    MenuBuilder localMenuBuilder = this.mMenu;
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(localMenuBuilder.getContext());
    this.mPresenter = new ListMenuPresenter(R.layout.abc_list_menu_item_layout, R.style.Theme_AppCompat_CompactMenu);
    this.mPresenter.setCallback(this);
    this.mMenu.addMenuPresenter(this.mPresenter);
    localBuilder.setAdapter(this.mPresenter.getAdapter(), this);
    View localView = localMenuBuilder.getHeaderView();
    if (localView != null) {
      localBuilder.setCustomTitle(localView);
    }
    for (;;)
    {
      localBuilder.setOnKeyListener(this);
      this.mDialog = localBuilder.create();
      this.mDialog.setOnDismissListener(this);
      WindowManager.LayoutParams localLayoutParams = this.mDialog.getWindow().getAttributes();
      localLayoutParams.type = 1003;
      if (paramIBinder != null) {
        localLayoutParams.token = paramIBinder;
      }
      localLayoutParams.flags = (0x20000 | localLayoutParams.flags);
      this.mDialog.show();
      return;
      localBuilder.setIcon(localMenuBuilder.getHeaderIcon()).setTitle(localMenuBuilder.getHeaderTitle());
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuDialogHelper
 * JD-Core Version:    0.7.0.1
 */