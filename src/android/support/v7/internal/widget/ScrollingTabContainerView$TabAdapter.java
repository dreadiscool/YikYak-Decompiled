package android.support.v7.internal.widget;

import android.support.v7.app.ActionBar.Tab;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

class ScrollingTabContainerView$TabAdapter
  extends BaseAdapter
{
  private ScrollingTabContainerView$TabAdapter(ScrollingTabContainerView paramScrollingTabContainerView) {}
  
  public int getCount()
  {
    return ScrollingTabContainerView.access$200(this.this$0).getChildCount();
  }
  
  public Object getItem(int paramInt)
  {
    return ((ScrollingTabContainerView.TabView)ScrollingTabContainerView.access$200(this.this$0).getChildAt(paramInt)).getTab();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = ScrollingTabContainerView.access$300(this.this$0, (ActionBar.Tab)getItem(paramInt), true);
    }
    for (;;)
    {
      return paramView;
      ((ScrollingTabContainerView.TabView)paramView).bindTab((ActionBar.Tab)getItem(paramInt));
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ScrollingTabContainerView.TabAdapter
 * JD-Core Version:    0.7.0.1
 */