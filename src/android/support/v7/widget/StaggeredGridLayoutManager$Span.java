package android.support.v7.widget;

import android.view.View;
import java.util.ArrayList;

class StaggeredGridLayoutManager$Span
{
  static final int INVALID_LINE = -2147483648;
  int mCachedEnd = -2147483648;
  int mCachedStart = -2147483648;
  int mDeletedSize = 0;
  final int mIndex;
  private ArrayList<View> mViews = new ArrayList();
  
  private StaggeredGridLayoutManager$Span(StaggeredGridLayoutManager paramStaggeredGridLayoutManager, int paramInt)
  {
    this.mIndex = paramInt;
  }
  
  void appendToSpan(View paramView)
  {
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams(paramView);
    localLayoutParams.mSpan = this;
    this.mViews.add(paramView);
    this.mCachedEnd = -2147483648;
    if (this.mViews.size() == 1) {
      this.mCachedStart = -2147483648;
    }
    if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
      this.mDeletedSize += this.this$0.mPrimaryOrientation.getDecoratedMeasurement(paramView);
    }
  }
  
  void cacheReferenceLineAndClear(boolean paramBoolean, int paramInt)
  {
    int i;
    if (paramBoolean)
    {
      i = getEndLine(-2147483648);
      clear();
      if (i != -2147483648) {
        break label32;
      }
    }
    for (;;)
    {
      return;
      i = getStartLine(-2147483648);
      break;
      label32:
      if (((!paramBoolean) || (i >= this.this$0.mPrimaryOrientation.getEndAfterPadding())) && ((paramBoolean) || (i <= this.this$0.mPrimaryOrientation.getStartAfterPadding())))
      {
        if (paramInt != -2147483648) {
          i += paramInt;
        }
        this.mCachedEnd = i;
        this.mCachedStart = i;
      }
    }
  }
  
  void calculateCachedEnd()
  {
    View localView = (View)this.mViews.get(-1 + this.mViews.size());
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams(localView);
    this.mCachedEnd = this.this$0.mPrimaryOrientation.getDecoratedEnd(localView);
    if (localLayoutParams.mFullSpan)
    {
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = this.this$0.mLazySpanLookup.getFullSpanItem(localLayoutParams.getViewPosition());
      if ((localFullSpanItem != null) && (localFullSpanItem.mGapDir == 1)) {
        this.mCachedEnd += localFullSpanItem.getGapForSpan(this.mIndex);
      }
    }
  }
  
  void calculateCachedStart()
  {
    View localView = (View)this.mViews.get(0);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams(localView);
    this.mCachedStart = this.this$0.mPrimaryOrientation.getDecoratedStart(localView);
    if (localLayoutParams.mFullSpan)
    {
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = this.this$0.mLazySpanLookup.getFullSpanItem(localLayoutParams.getViewPosition());
      if ((localFullSpanItem != null) && (localFullSpanItem.mGapDir == -1)) {
        this.mCachedStart -= localFullSpanItem.getGapForSpan(this.mIndex);
      }
    }
  }
  
  void clear()
  {
    this.mViews.clear();
    invalidateCache();
    this.mDeletedSize = 0;
  }
  
  public int findFirstCompletelyVisibleItemPosition()
  {
    if (StaggeredGridLayoutManager.access$600(this.this$0)) {}
    for (int i = findOneVisibleChild(-1 + this.mViews.size(), -1, true);; i = findOneVisibleChild(0, this.mViews.size(), true)) {
      return i;
    }
  }
  
  public int findFirstVisibleItemPosition()
  {
    if (StaggeredGridLayoutManager.access$600(this.this$0)) {}
    for (int i = findOneVisibleChild(-1 + this.mViews.size(), -1, false);; i = findOneVisibleChild(0, this.mViews.size(), false)) {
      return i;
    }
  }
  
  public int findLastCompletelyVisibleItemPosition()
  {
    if (StaggeredGridLayoutManager.access$600(this.this$0)) {}
    for (int i = findOneVisibleChild(0, this.mViews.size(), true);; i = findOneVisibleChild(-1 + this.mViews.size(), -1, true)) {
      return i;
    }
  }
  
  public int findLastVisibleItemPosition()
  {
    if (StaggeredGridLayoutManager.access$600(this.this$0)) {}
    for (int i = findOneVisibleChild(0, this.mViews.size(), false);; i = findOneVisibleChild(-1 + this.mViews.size(), -1, false)) {
      return i;
    }
  }
  
  int findOneVisibleChild(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = -1;
    int j = this.this$0.mPrimaryOrientation.getStartAfterPadding();
    int k = this.this$0.mPrimaryOrientation.getEndAfterPadding();
    int m;
    if (paramInt2 > paramInt1) {
      m = 1;
    }
    for (;;)
    {
      View localView;
      if (paramInt1 != paramInt2)
      {
        localView = (View)this.mViews.get(paramInt1);
        int n = this.this$0.mPrimaryOrientation.getDecoratedStart(localView);
        int i1 = this.this$0.mPrimaryOrientation.getDecoratedEnd(localView);
        if ((n >= k) || (i1 <= j)) {
          break label149;
        }
        if (!paramBoolean) {
          break label135;
        }
        if ((n < j) || (i1 > k)) {
          break label149;
        }
      }
      label135:
      for (i = this.this$0.getPosition(localView);; i = this.this$0.getPosition(localView))
      {
        return i;
        m = i;
        break;
      }
      label149:
      paramInt1 += m;
    }
  }
  
  public int getDeletedSize()
  {
    return this.mDeletedSize;
  }
  
  int getEndLine()
  {
    if (this.mCachedEnd != -2147483648) {}
    for (int i = this.mCachedEnd;; i = this.mCachedEnd)
    {
      return i;
      calculateCachedEnd();
    }
  }
  
  int getEndLine(int paramInt)
  {
    if (this.mCachedEnd != -2147483648) {
      paramInt = this.mCachedEnd;
    }
    for (;;)
    {
      return paramInt;
      if (this.mViews.size() != 0)
      {
        calculateCachedEnd();
        paramInt = this.mCachedEnd;
      }
    }
  }
  
  StaggeredGridLayoutManager.LayoutParams getLayoutParams(View paramView)
  {
    return (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
  }
  
  int getNormalizedOffset(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mViews.size() == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      return paramInt1;
      if (paramInt1 < 0)
      {
        int j = getEndLine() - paramInt3;
        if (j <= 0) {
          paramInt1 = 0;
        } else if (-paramInt1 > j) {
          paramInt1 = -j;
        }
      }
      else
      {
        int i = paramInt2 - getStartLine();
        if (i <= 0) {
          paramInt1 = 0;
        } else if (i < paramInt1) {
          paramInt1 = i;
        }
      }
    }
  }
  
  int getStartLine()
  {
    if (this.mCachedStart != -2147483648) {}
    for (int i = this.mCachedStart;; i = this.mCachedStart)
    {
      return i;
      calculateCachedStart();
    }
  }
  
  int getStartLine(int paramInt)
  {
    if (this.mCachedStart != -2147483648) {
      paramInt = this.mCachedStart;
    }
    for (;;)
    {
      return paramInt;
      if (this.mViews.size() != 0)
      {
        calculateCachedStart();
        paramInt = this.mCachedStart;
      }
    }
  }
  
  void invalidateCache()
  {
    this.mCachedStart = -2147483648;
    this.mCachedEnd = -2147483648;
  }
  
  boolean isEmpty(int paramInt1, int paramInt2)
  {
    int i = this.mViews.size();
    int j = 0;
    if (j < i)
    {
      View localView = (View)this.mViews.get(j);
      if ((this.this$0.mPrimaryOrientation.getDecoratedStart(localView) >= paramInt2) || (this.this$0.mPrimaryOrientation.getDecoratedEnd(localView) <= paramInt1)) {}
    }
    for (boolean bool = false;; bool = true)
    {
      return bool;
      j++;
      break;
    }
  }
  
  void onOffset(int paramInt)
  {
    if (this.mCachedStart != -2147483648) {
      this.mCachedStart = (paramInt + this.mCachedStart);
    }
    if (this.mCachedEnd != -2147483648) {
      this.mCachedEnd = (paramInt + this.mCachedEnd);
    }
  }
  
  void popEnd()
  {
    int i = this.mViews.size();
    View localView = (View)this.mViews.remove(i - 1);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams(localView);
    localLayoutParams.mSpan = null;
    if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
      this.mDeletedSize -= this.this$0.mPrimaryOrientation.getDecoratedMeasurement(localView);
    }
    if (i == 1) {
      this.mCachedStart = -2147483648;
    }
    this.mCachedEnd = -2147483648;
  }
  
  void popStart()
  {
    View localView = (View)this.mViews.remove(0);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams(localView);
    localLayoutParams.mSpan = null;
    if (this.mViews.size() == 0) {
      this.mCachedEnd = -2147483648;
    }
    if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
      this.mDeletedSize -= this.this$0.mPrimaryOrientation.getDecoratedMeasurement(localView);
    }
    this.mCachedStart = -2147483648;
  }
  
  void prependToSpan(View paramView)
  {
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams(paramView);
    localLayoutParams.mSpan = this;
    this.mViews.add(0, paramView);
    this.mCachedStart = -2147483648;
    if (this.mViews.size() == 1) {
      this.mCachedEnd = -2147483648;
    }
    if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
      this.mDeletedSize += this.this$0.mPrimaryOrientation.getDecoratedMeasurement(paramView);
    }
  }
  
  void setLine(int paramInt)
  {
    this.mCachedStart = paramInt;
    this.mCachedEnd = paramInt;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.Span
 * JD-Core Version:    0.7.0.1
 */