package android.support.v7.internal.widget;

import android.support.v7.app.ActionBar.Tab;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.View.OnClickListener;

class ScrollingTabContainerView$TabClickListener
  implements View.OnClickListener
{
  private ScrollingTabContainerView$TabClickListener(ScrollingTabContainerView paramScrollingTabContainerView) {}
  
  public void onClick(View paramView)
  {
    ((ScrollingTabContainerView.TabView)paramView).getTab().select();
    int i = ScrollingTabContainerView.access$200(this.this$0).getChildCount();
    int j = 0;
    if (j < i)
    {
      View localView = ScrollingTabContainerView.access$200(this.this$0).getChildAt(j);
      if (localView == paramView) {}
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        j++;
        break;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ScrollingTabContainerView.TabClickListener
 * JD-Core Version:    0.7.0.1
 */