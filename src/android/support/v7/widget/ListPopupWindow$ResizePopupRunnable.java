package android.support.v7.widget;

import android.widget.PopupWindow;

class ListPopupWindow$ResizePopupRunnable
  implements Runnable
{
  private ListPopupWindow$ResizePopupRunnable(ListPopupWindow paramListPopupWindow) {}
  
  public void run()
  {
    if ((ListPopupWindow.access$600(this.this$0) != null) && (ListPopupWindow.access$600(this.this$0).getCount() > ListPopupWindow.access$600(this.this$0).getChildCount()) && (ListPopupWindow.access$600(this.this$0).getChildCount() <= this.this$0.mListItemExpandMaximum))
    {
      ListPopupWindow.access$1100(this.this$0).setInputMethodMode(2);
      this.this$0.show();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ListPopupWindow.ResizePopupRunnable
 * JD-Core Version:    0.7.0.1
 */