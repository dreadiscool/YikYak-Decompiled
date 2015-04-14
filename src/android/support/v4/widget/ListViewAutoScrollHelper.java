package android.support.v4.widget;

import android.view.View;
import android.widget.ListView;

public class ListViewAutoScrollHelper
  extends AutoScrollHelper
{
  private final ListView mTarget;
  
  public ListViewAutoScrollHelper(ListView paramListView)
  {
    super(paramListView);
    this.mTarget = paramListView;
  }
  
  public boolean canTargetScrollHorizontally(int paramInt)
  {
    return false;
  }
  
  public boolean canTargetScrollVertically(int paramInt)
  {
    boolean bool = false;
    ListView localListView = this.mTarget;
    int i = localListView.getCount();
    if (i == 0) {}
    for (;;)
    {
      return bool;
      int j = localListView.getChildCount();
      int k = localListView.getFirstVisiblePosition();
      int m = k + j;
      if (paramInt > 0)
      {
        if ((m >= i) && (localListView.getChildAt(j - 1).getBottom() <= localListView.getHeight())) {}
      }
      else {
        do
        {
          bool = true;
          break;
          if (paramInt >= 0) {
            break;
          }
        } while ((k > 0) || (localListView.getChildAt(0).getTop() < 0));
      }
    }
  }
  
  public void scrollTargetBy(int paramInt1, int paramInt2)
  {
    ListView localListView = this.mTarget;
    int i = localListView.getFirstVisiblePosition();
    if (i == -1) {}
    for (;;)
    {
      return;
      View localView = localListView.getChildAt(0);
      if (localView != null) {
        localListView.setSelectionFromTop(i, localView.getTop() - paramInt2);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.ListViewAutoScrollHelper
 * JD-Core Version:    0.7.0.1
 */