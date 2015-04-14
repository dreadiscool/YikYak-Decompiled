package android.support.v7.widget;

import android.support.v4.view.KeyEventCompat;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class SearchView$8
  implements View.OnKeyListener
{
  SearchView$8(SearchView paramSearchView) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (SearchView.access$1500(this.this$0) == null) {}
    for (;;)
    {
      return bool;
      if ((SearchView.access$1300(this.this$0).isPopupShowing()) && (SearchView.access$1300(this.this$0).getListSelection() != -1))
      {
        bool = SearchView.access$1600(this.this$0, paramView, paramInt, paramKeyEvent);
      }
      else if ((!SearchView.SearchAutoComplete.access$1700(SearchView.access$1300(this.this$0))) && (KeyEventCompat.hasNoModifiers(paramKeyEvent)) && (paramKeyEvent.getAction() == 1) && (paramInt == 66))
      {
        paramView.cancelLongPress();
        SearchView.access$1800(this.this$0, 0, null, SearchView.access$1300(this.this$0).getText().toString());
        bool = true;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.SearchView.8
 * JD-Core Version:    0.7.0.1
 */