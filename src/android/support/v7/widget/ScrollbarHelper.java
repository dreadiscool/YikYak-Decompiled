package android.support.v7.widget;

import android.view.View;

class ScrollbarHelper
{
  static int computeScrollExtent(RecyclerView.State paramState, OrientationHelper paramOrientationHelper, View paramView1, View paramView2, RecyclerView.LayoutManager paramLayoutManager, boolean paramBoolean)
  {
    int i;
    if ((paramLayoutManager.getChildCount() == 0) || (paramState.getItemCount() == 0) || (paramView1 == null) || (paramView2 == null)) {
      i = 0;
    }
    for (;;)
    {
      return i;
      if (!paramBoolean)
      {
        i = 1 + Math.abs(paramLayoutManager.getPosition(paramView1) - paramLayoutManager.getPosition(paramView2));
      }
      else
      {
        int j = paramOrientationHelper.getDecoratedEnd(paramView2) - paramOrientationHelper.getDecoratedStart(paramView1);
        i = Math.min(paramOrientationHelper.getTotalSpace(), j);
      }
    }
  }
  
  static int computeScrollOffset(RecyclerView.State paramState, OrientationHelper paramOrientationHelper, View paramView1, View paramView2, RecyclerView.LayoutManager paramLayoutManager, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    if ((paramLayoutManager.getChildCount() == 0) || (paramState.getItemCount() == 0) || (paramView1 == null) || (paramView2 == null)) {}
    label165:
    for (;;)
    {
      return i;
      int j = Math.min(paramLayoutManager.getPosition(paramView1), paramLayoutManager.getPosition(paramView2));
      int k = Math.max(paramLayoutManager.getPosition(paramView1), paramLayoutManager.getPosition(paramView2));
      if (paramBoolean2) {}
      for (i = Math.max(0, -1 + (paramState.getItemCount() - k));; i = Math.max(0, j))
      {
        if (!paramBoolean1) {
          break label165;
        }
        int m = Math.abs(paramOrientationHelper.getDecoratedEnd(paramView2) - paramOrientationHelper.getDecoratedStart(paramView1));
        int n = 1 + Math.abs(paramLayoutManager.getPosition(paramView1) - paramLayoutManager.getPosition(paramView2));
        i = Math.round(m / n * i + (paramOrientationHelper.getStartAfterPadding() - paramOrientationHelper.getDecoratedStart(paramView1)));
        break;
      }
    }
  }
  
  static int computeScrollRange(RecyclerView.State paramState, OrientationHelper paramOrientationHelper, View paramView1, View paramView2, RecyclerView.LayoutManager paramLayoutManager, boolean paramBoolean)
  {
    int i;
    if ((paramLayoutManager.getChildCount() == 0) || (paramState.getItemCount() == 0) || (paramView1 == null) || (paramView2 == null)) {
      i = 0;
    }
    for (;;)
    {
      return i;
      if (!paramBoolean)
      {
        i = paramState.getItemCount();
      }
      else
      {
        int j = paramOrientationHelper.getDecoratedEnd(paramView2) - paramOrientationHelper.getDecoratedStart(paramView1);
        int k = 1 + Math.abs(paramLayoutManager.getPosition(paramView1) - paramLayoutManager.getPosition(paramView2));
        i = (int)(j / k * paramState.getItemCount());
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ScrollbarHelper
 * JD-Core Version:    0.7.0.1
 */