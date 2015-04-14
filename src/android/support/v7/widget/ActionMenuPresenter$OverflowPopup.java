package android.support.v7.widget;

import android.content.Context;
import android.support.v7.appcompat.R.attr;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuPopupHelper;
import android.view.View;

class ActionMenuPresenter$OverflowPopup
  extends MenuPopupHelper
{
  public ActionMenuPresenter$OverflowPopup(ActionMenuPresenter paramActionMenuPresenter, Context paramContext, MenuBuilder paramMenuBuilder, View paramView, boolean paramBoolean)
  {
    super(paramContext, paramMenuBuilder, paramView, paramBoolean, R.attr.actionOverflowMenuStyle);
    setGravity(8388613);
    setCallback(paramActionMenuPresenter.mPopupPresenterCallback);
  }
  
  public void onDismiss()
  {
    super.onDismiss();
    ActionMenuPresenter.access$400(this.this$0).close();
    ActionMenuPresenter.access$202(this.this$0, null);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter.OverflowPopup
 * JD-Core Version:    0.7.0.1
 */