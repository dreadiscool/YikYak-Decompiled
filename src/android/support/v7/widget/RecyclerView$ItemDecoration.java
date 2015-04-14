package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

public abstract class RecyclerView$ItemDecoration
{
  @Deprecated
  public void getItemOffsets(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
  {
    paramRect.set(0, 0, 0, 0);
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    getItemOffsets(paramRect, ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewPosition(), paramRecyclerView);
  }
  
  @Deprecated
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView) {}
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    onDraw(paramCanvas, paramRecyclerView);
  }
  
  @Deprecated
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView) {}
  
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    onDrawOver(paramCanvas, paramRecyclerView);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.ItemDecoration
 * JD-Core Version:    0.7.0.1
 */