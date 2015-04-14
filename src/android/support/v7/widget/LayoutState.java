package android.support.v7.widget;

import android.view.View;

class LayoutState
{
  static final int INVALID_LAYOUT = -2147483648;
  static final int ITEM_DIRECTION_HEAD = -1;
  static final int ITEM_DIRECTION_TAIL = 1;
  static final int LAYOUT_END = 1;
  static final int LAYOUT_START = -1;
  static final int SCOLLING_OFFSET_NaN = -2147483648;
  static final String TAG = "LayoutState";
  int mAvailable;
  int mCurrentPosition;
  int mExtra = 0;
  int mItemDirection;
  int mLayoutDirection;
  
  boolean hasMore(RecyclerView.State paramState)
  {
    if ((this.mCurrentPosition >= 0) && (this.mCurrentPosition < paramState.getItemCount())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  View next(RecyclerView.Recycler paramRecycler)
  {
    View localView = paramRecycler.getViewForPosition(this.mCurrentPosition);
    this.mCurrentPosition += this.mItemDirection;
    return localView;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.LayoutState
 * JD-Core Version:    0.7.0.1
 */