package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

class ListPopupWindow$3
  implements AdapterView.OnItemSelectedListener
{
  ListPopupWindow$3(ListPopupWindow paramListPopupWindow) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt != -1)
    {
      ListPopupWindow.DropDownListView localDropDownListView = ListPopupWindow.access$600(this.this$0);
      if (localDropDownListView != null) {
        ListPopupWindow.DropDownListView.access$502(localDropDownListView, false);
      }
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ListPopupWindow.3
 * JD-Core Version:    0.7.0.1
 */