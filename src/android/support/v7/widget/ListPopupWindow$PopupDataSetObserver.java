package android.support.v7.widget;

import android.database.DataSetObserver;

class ListPopupWindow$PopupDataSetObserver
  extends DataSetObserver
{
  private ListPopupWindow$PopupDataSetObserver(ListPopupWindow paramListPopupWindow) {}
  
  public void onChanged()
  {
    if (this.this$0.isShowing()) {
      this.this$0.show();
    }
  }
  
  public void onInvalidated()
  {
    this.this$0.dismiss();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ListPopupWindow.PopupDataSetObserver
 * JD-Core Version:    0.7.0.1
 */