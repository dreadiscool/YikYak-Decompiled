package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;

class StaggeredGridLayoutManager$2
  extends LinearSmoothScroller
{
  StaggeredGridLayoutManager$2(StaggeredGridLayoutManager paramStaggeredGridLayoutManager, Context paramContext)
  {
    super(paramContext);
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    int i = StaggeredGridLayoutManager.access$400(this.this$0, paramInt);
    PointF localPointF;
    if (i == 0) {
      localPointF = null;
    }
    for (;;)
    {
      return localPointF;
      if (StaggeredGridLayoutManager.access$500(this.this$0) == 0) {
        localPointF = new PointF(i, 0.0F);
      } else {
        localPointF = new PointF(0.0F, i);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.2
 * JD-Core Version:    0.7.0.1
 */