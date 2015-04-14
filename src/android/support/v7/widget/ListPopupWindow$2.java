package android.support.v7.widget;

import android.view.View;

class ListPopupWindow$2
  implements Runnable
{
  ListPopupWindow$2(ListPopupWindow paramListPopupWindow) {}
  
  public void run()
  {
    View localView = this.this$0.getAnchorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      this.this$0.show();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ListPopupWindow.2
 * JD-Core Version:    0.7.0.1
 */