package android.support.v4.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;

class SlidingPaneLayout$SlidingPanelLayoutImplJBMR1
  extends SlidingPaneLayout.SlidingPanelLayoutImplBase
{
  public void invalidateChildRegion(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
  {
    ViewCompat.setLayerPaint(paramView, ((SlidingPaneLayout.LayoutParams)paramView.getLayoutParams()).dimPaint);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImplJBMR1
 * JD-Core Version:    0.7.0.1
 */