package android.support.v7.widget;

import android.view.View;

class LinearLayoutManager$AnchorInfo
{
  int mCoordinate;
  boolean mLayoutFromEnd;
  int mPosition;
  
  LinearLayoutManager$AnchorInfo(LinearLayoutManager paramLinearLayoutManager) {}
  
  void assignCoordinateFromPadding()
  {
    if (this.mLayoutFromEnd) {}
    for (int i = this.this$0.mOrientationHelper.getEndAfterPadding();; i = this.this$0.mOrientationHelper.getStartAfterPadding())
    {
      this.mCoordinate = i;
      return;
    }
  }
  
  public void assignFromView(View paramView)
  {
    if (this.mLayoutFromEnd) {}
    for (this.mCoordinate = (this.this$0.mOrientationHelper.getDecoratedEnd(paramView) + this.this$0.mOrientationHelper.getTotalSpaceChange());; this.mCoordinate = this.this$0.mOrientationHelper.getDecoratedStart(paramView))
    {
      this.mPosition = this.this$0.getPosition(paramView);
      return;
    }
  }
  
  public boolean assignFromViewIfValid(View paramView, RecyclerView.State paramState)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    if ((!localLayoutParams.isItemRemoved()) && (localLayoutParams.getViewPosition() >= 0) && (localLayoutParams.getViewPosition() < paramState.getItemCount())) {
      assignFromView(paramView);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  void reset()
  {
    this.mPosition = -1;
    this.mCoordinate = -2147483648;
    this.mLayoutFromEnd = false;
  }
  
  public String toString()
  {
    return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.mCoordinate + ", mLayoutFromEnd=" + this.mLayoutFromEnd + '}';
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager.AnchorInfo
 * JD-Core Version:    0.7.0.1
 */