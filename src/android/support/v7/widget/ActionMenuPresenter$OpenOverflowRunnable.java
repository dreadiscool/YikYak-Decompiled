package android.support.v7.widget;

import android.support.v7.internal.view.menu.MenuBuilder;
import android.view.View;

class ActionMenuPresenter$OpenOverflowRunnable
  implements Runnable
{
  private ActionMenuPresenter.OverflowPopup mPopup;
  
  public ActionMenuPresenter$OpenOverflowRunnable(ActionMenuPresenter paramActionMenuPresenter, ActionMenuPresenter.OverflowPopup paramOverflowPopup)
  {
    this.mPopup = paramOverflowPopup;
  }
  
  public void run()
  {
    ActionMenuPresenter.access$800(this.this$0).changeMenuMode();
    View localView = (View)ActionMenuPresenter.access$900(this.this$0);
    if ((localView != null) && (localView.getWindowToken() != null) && (this.mPopup.tryShow())) {
      ActionMenuPresenter.access$202(this.this$0, this.mPopup);
    }
    ActionMenuPresenter.access$302(this.this$0, null);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter.OpenOverflowRunnable
 * JD-Core Version:    0.7.0.1
 */