package android.support.v7.widget;

import android.support.v7.internal.view.menu.MenuPopupHelper;
import android.view.View;

class PopupMenu$1
  extends ListPopupWindow.ForwardingListener
{
  PopupMenu$1(PopupMenu paramPopupMenu, View paramView)
  {
    super(paramView);
  }
  
  public ListPopupWindow getPopup()
  {
    return PopupMenu.access$000(this.this$0).getPopup();
  }
  
  protected boolean onForwardingStarted()
  {
    this.this$0.show();
    return true;
  }
  
  protected boolean onForwardingStopped()
  {
    this.this$0.dismiss();
    return true;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.PopupMenu.1
 * JD-Core Version:    0.7.0.1
 */