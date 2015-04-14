package android.support.v7.app;

import android.support.v7.internal.app.WindowCallback;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;

final class ActionBarActivityDelegateBase$PanelMenuPresenterCallback
  implements MenuPresenter.Callback
{
  private ActionBarActivityDelegateBase$PanelMenuPresenterCallback(ActionBarActivityDelegateBase paramActionBarActivityDelegateBase) {}
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    MenuBuilder localMenuBuilder = paramMenuBuilder.getRootMenu();
    int i;
    ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState;
    if (localMenuBuilder != paramMenuBuilder)
    {
      i = 1;
      ActionBarActivityDelegateBase localActionBarActivityDelegateBase = this.this$0;
      if (i != 0) {
        paramMenuBuilder = localMenuBuilder;
      }
      localPanelFeatureState = ActionBarActivityDelegateBase.access$600(localActionBarActivityDelegateBase, paramMenuBuilder);
      if (localPanelFeatureState != null)
      {
        if (i == 0) {
          break label76;
        }
        ActionBarActivityDelegateBase.access$700(this.this$0, localPanelFeatureState.featureId, localPanelFeatureState, localMenuBuilder);
        ActionBarActivityDelegateBase.access$800(this.this$0, localPanelFeatureState, true);
      }
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label76:
      this.this$0.mActivity.closeOptionsMenu();
      ActionBarActivityDelegateBase.access$800(this.this$0, localPanelFeatureState, paramBoolean);
    }
  }
  
  public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
  {
    if ((paramMenuBuilder == null) && (this.this$0.mHasActionBar))
    {
      WindowCallback localWindowCallback = this.this$0.getWindowCallback();
      if ((localWindowCallback != null) && (!this.this$0.isDestroyed())) {
        localWindowCallback.onMenuOpened(8, paramMenuBuilder);
      }
    }
    return true;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegateBase.PanelMenuPresenterCallback
 * JD-Core Version:    0.7.0.1
 */