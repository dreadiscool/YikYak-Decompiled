package android.support.v7.internal.widget;

import android.view.View;

class ScrollingTabContainerView$1
  implements Runnable
{
  ScrollingTabContainerView$1(ScrollingTabContainerView paramScrollingTabContainerView, View paramView) {}
  
  public void run()
  {
    int i = this.val$tabView.getLeft() - (this.this$0.getWidth() - this.val$tabView.getWidth()) / 2;
    this.this$0.smoothScrollTo(i, 0);
    this.this$0.mTabSelector = null;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ScrollingTabContainerView.1
 * JD-Core Version:    0.7.0.1
 */