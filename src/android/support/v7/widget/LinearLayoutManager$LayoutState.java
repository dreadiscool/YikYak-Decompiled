package android.support.v7.widget;

import android.view.View;
import java.util.List;

class LinearLayoutManager$LayoutState
{
  static final int INVALID_LAYOUT = -2147483648;
  static final int ITEM_DIRECTION_HEAD = -1;
  static final int ITEM_DIRECTION_TAIL = 1;
  static final int LAYOUT_END = 1;
  static final int LAYOUT_START = -1;
  static final int SCOLLING_OFFSET_NaN = -2147483648;
  static final String TAG = "LinearLayoutManager#LayoutState";
  int mAvailable;
  int mCurrentPosition;
  int mExtra = 0;
  boolean mIsPreLayout = false;
  int mItemDirection;
  int mLayoutDirection;
  int mOffset;
  boolean mRecycle = true;
  List<RecyclerView.ViewHolder> mScrapList = null;
  int mScrollingOffset;
  
  private View nextFromLimitedList()
  {
    int i = this.mScrapList.size();
    int j = 2147483647;
    int k = 0;
    Object localObject1 = null;
    Object localObject2;
    int n;
    Object localObject3;
    int m;
    if (k < i)
    {
      localObject2 = (RecyclerView.ViewHolder)this.mScrapList.get(k);
      if ((!this.mIsPreLayout) && (((RecyclerView.ViewHolder)localObject2).isRemoved())) {
        n = j;
      }
      for (localObject3 = localObject1;; localObject3 = localObject1)
      {
        k++;
        localObject1 = localObject3;
        j = n;
        break;
        m = (((RecyclerView.ViewHolder)localObject2).getPosition() - this.mCurrentPosition) * this.mItemDirection;
        if (m >= 0) {
          break label105;
        }
        n = j;
      }
      label105:
      if (m < j) {
        if (m != 0) {}
      }
    }
    for (;;)
    {
      if (localObject2 != null) {
        this.mCurrentPosition = (((RecyclerView.ViewHolder)localObject2).getPosition() + this.mItemDirection);
      }
      for (View localView = ((RecyclerView.ViewHolder)localObject2).itemView;; localView = null) {
        return localView;
      }
      localObject3 = localObject2;
      n = m;
      break;
      n = j;
      localObject3 = localObject1;
      break;
      localObject2 = localObject1;
    }
  }
  
  boolean hasMore(RecyclerView.State paramState)
  {
    if ((this.mCurrentPosition >= 0) && (this.mCurrentPosition < paramState.getItemCount())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  void log()
  {
    new StringBuilder().append("avail:").append(this.mAvailable).append(", ind:").append(this.mCurrentPosition).append(", dir:").append(this.mItemDirection).append(", offset:").append(this.mOffset).append(", layoutDir:").append(this.mLayoutDirection).toString();
  }
  
  View next(RecyclerView.Recycler paramRecycler)
  {
    View localView;
    if (this.mScrapList != null) {
      localView = nextFromLimitedList();
    }
    for (;;)
    {
      return localView;
      localView = paramRecycler.getViewForPosition(this.mCurrentPosition);
      this.mCurrentPosition += this.mItemDirection;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager.LayoutState
 * JD-Core Version:    0.7.0.1
 */