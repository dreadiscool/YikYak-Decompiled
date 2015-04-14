package android.support.v7.app;

import android.support.v7.internal.app.WindowCallback;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;

final class ActionBarActivityDelegateBase$ActionMenuPresenterCallback
  implements MenuPresenter.Callback
{
  private ActionBarActivityDelegateBase$ActionMenuPresenterCallback(ActionBarActivityDelegateBase paramActionBarActivityDelegateBase) {}
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    ActionBarActivityDelegateBase.access$900(this.this$0, paramMenuBuilder);
  }
  
  public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
  {
    WindowCallback localWindowCallback = this.this$0.getWindowCallback();
    if (localWindowCallback != null) {
      localWindowCallback.onMenuOpened(8, paramMenuBuilder);
    }
    return true;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegateBase.ActionMenuPresenterCallback
 * JD-Core Version:    0.7.0.1
 */