package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager
  extends LinearLayoutManager
{
  private static final boolean DEBUG = false;
  public static final int DEFAULT_SPAN_COUNT = -1;
  static final int MAIN_DIR_SPEC = View.MeasureSpec.makeMeasureSpec(0, 0);
  private static final String TAG = "GridLayoutManager";
  final Rect mDecorInsets = new Rect();
  final SparseIntArray mPreLayoutSpanIndexCache = new SparseIntArray();
  final SparseIntArray mPreLayoutSpanSizeCache = new SparseIntArray();
  View[] mSet;
  int mSizePerSpan;
  int mSpanCount = -1;
  GridLayoutManager.SpanSizeLookup mSpanSizeLookup = new GridLayoutManager.DefaultSpanSizeLookup();
  
  public GridLayoutManager(Context paramContext, int paramInt)
  {
    super(paramContext);
    setSpanCount(paramInt);
  }
  
  public GridLayoutManager(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramContext, paramInt2, paramBoolean);
    setSpanCount(paramInt1);
  }
  
  private void assignSpans(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j;
    int i;
    int k;
    int m;
    label36:
    int n;
    int i1;
    label44:
    GridLayoutManager.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      j = 1;
      i = 0;
      if ((this.mOrientation != 1) || (!isLayoutRTL())) {
        break label158;
      }
      k = paramInt2 - 1;
      m = -1;
      n = k;
      i1 = i;
      if (i1 == paramInt1) {
        return;
      }
      View localView = this.mSet[i1];
      localLayoutParams = (GridLayoutManager.LayoutParams)localView.getLayoutParams();
      GridLayoutManager.LayoutParams.access$102(localLayoutParams, getSpanSize(paramRecycler, paramState, getPosition(localView)));
      if ((m != -1) || (GridLayoutManager.LayoutParams.access$100(localLayoutParams) <= 1)) {
        break label167;
      }
      GridLayoutManager.LayoutParams.access$002(localLayoutParams, n - (-1 + GridLayoutManager.LayoutParams.access$100(localLayoutParams)));
    }
    for (;;)
    {
      n += m * GridLayoutManager.LayoutParams.access$100(localLayoutParams);
      i1 += j;
      break label44;
      i = paramInt1 - 1;
      j = -1;
      paramInt1 = -1;
      break;
      label158:
      k = 0;
      m = 1;
      break label36;
      label167:
      GridLayoutManager.LayoutParams.access$002(localLayoutParams, n);
    }
  }
  
  private void cachePreLayoutSpanMapping()
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      GridLayoutManager.LayoutParams localLayoutParams = (GridLayoutManager.LayoutParams)getChildAt(j).getLayoutParams();
      int k = localLayoutParams.getViewPosition();
      this.mPreLayoutSpanSizeCache.put(k, localLayoutParams.getSpanSize());
      this.mPreLayoutSpanIndexCache.put(k, localLayoutParams.getSpanIndex());
    }
  }
  
  private void clearPreLayoutSpanMappingCache()
  {
    this.mPreLayoutSpanSizeCache.clear();
    this.mPreLayoutSpanIndexCache.clear();
  }
  
  private void ensureAnchorIsInFirstSpan(LinearLayoutManager.AnchorInfo paramAnchorInfo)
  {
    for (int i = this.mSpanSizeLookup.getCachedSpanIndex(paramAnchorInfo.mPosition, this.mSpanCount); (i > 0) && (paramAnchorInfo.mPosition > 0); i = this.mSpanSizeLookup.getCachedSpanIndex(paramAnchorInfo.mPosition, this.mSpanCount)) {
      paramAnchorInfo.mPosition = (-1 + paramAnchorInfo.mPosition);
    }
  }
  
  private int getMainDirSpec(int paramInt)
  {
    if (paramInt < 0) {}
    for (int i = MAIN_DIR_SPEC;; i = View.MeasureSpec.makeMeasureSpec(paramInt, 1073741824)) {
      return i;
    }
  }
  
  private int getSpanGroupIndex(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    int j;
    if (!paramState.isPreLayout()) {
      j = this.mSpanSizeLookup.getSpanGroupIndex(paramInt, this.mSpanCount);
    }
    for (;;)
    {
      return j;
      int i = paramRecycler.convertPreLayoutPositionToPostLayout(paramInt);
      if (i == -1)
      {
        new StringBuilder().append("Cannot find span size for pre layout position. ").append(paramInt).toString();
        j = 0;
      }
      else
      {
        j = this.mSpanSizeLookup.getSpanGroupIndex(i, this.mSpanCount);
      }
    }
  }
  
  private int getSpanIndex(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    int i;
    if (!paramState.isPreLayout()) {
      i = this.mSpanSizeLookup.getCachedSpanIndex(paramInt, this.mSpanCount);
    }
    for (;;)
    {
      return i;
      i = this.mPreLayoutSpanIndexCache.get(paramInt, -1);
      if (i == -1)
      {
        int j = paramRecycler.convertPreLayoutPositionToPostLayout(paramInt);
        if (j == -1)
        {
          new StringBuilder().append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:").append(paramInt).toString();
          i = 0;
        }
        else
        {
          i = this.mSpanSizeLookup.getCachedSpanIndex(j, this.mSpanCount);
        }
      }
    }
  }
  
  private int getSpanSize(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    int i;
    if (!paramState.isPreLayout()) {
      i = this.mSpanSizeLookup.getSpanSize(paramInt);
    }
    for (;;)
    {
      return i;
      i = this.mPreLayoutSpanSizeCache.get(paramInt, -1);
      if (i == -1)
      {
        int j = paramRecycler.convertPreLayoutPositionToPostLayout(paramInt);
        if (j == -1)
        {
          new StringBuilder().append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:").append(paramInt).toString();
          i = 1;
        }
        else
        {
          i = this.mSpanSizeLookup.getSpanSize(j);
        }
      }
    }
  }
  
  private void measureChildWithDecorationsAndMargin(View paramView, int paramInt1, int paramInt2)
  {
    calculateItemDecorationsForChild(paramView, this.mDecorInsets);
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    paramView.measure(updateSpecWithExtra(paramInt1, localLayoutParams.leftMargin + this.mDecorInsets.left, localLayoutParams.rightMargin + this.mDecorInsets.right), updateSpecWithExtra(paramInt2, localLayoutParams.topMargin + this.mDecorInsets.top, localLayoutParams.bottomMargin + this.mDecorInsets.bottom));
  }
  
  private void updateMeasurements()
  {
    if (getOrientation() == 1) {}
    for (int i = getWidth() - getPaddingRight() - getPaddingLeft();; i = getHeight() - getPaddingBottom() - getPaddingTop())
    {
      this.mSizePerSpan = (i / this.mSpanCount);
      return;
    }
  }
  
  private int updateSpecWithExtra(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0)) {}
    for (;;)
    {
      return paramInt1;
      int i = View.MeasureSpec.getMode(paramInt1);
      if ((i == -2147483648) || (i == 1073741824)) {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1) - paramInt2 - paramInt3, i);
      }
    }
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof GridLayoutManager.LayoutParams;
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    return new GridLayoutManager.LayoutParams(-2, -2);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new GridLayoutManager.LayoutParams(paramContext, paramAttributeSet);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {}
    for (GridLayoutManager.LayoutParams localLayoutParams = new GridLayoutManager.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);; localLayoutParams = new GridLayoutManager.LayoutParams(paramLayoutParams)) {
      return localLayoutParams;
    }
  }
  
  public int getColumnCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    int i;
    if (this.mOrientation == 1) {
      i = this.mSpanCount;
    }
    for (;;)
    {
      return i;
      if (paramState.getItemCount() < 1) {
        i = 0;
      } else {
        i = getSpanGroupIndex(paramRecycler, paramState, -1 + paramState.getItemCount());
      }
    }
  }
  
  public int getRowCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    int i;
    if (this.mOrientation == 0) {
      i = this.mSpanCount;
    }
    for (;;)
    {
      return i;
      if (paramState.getItemCount() < 1) {
        i = 0;
      } else {
        i = getSpanGroupIndex(paramRecycler, paramState, -1 + paramState.getItemCount());
      }
    }
  }
  
  public int getSpanCount()
  {
    return this.mSpanCount;
  }
  
  public GridLayoutManager.SpanSizeLookup getSpanSizeLookup()
  {
    return this.mSpanSizeLookup;
  }
  
  void layoutChunk(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.LayoutState paramLayoutState, LinearLayoutManager.LayoutChunkResult paramLayoutChunkResult)
  {
    boolean bool;
    int i;
    int j;
    int k;
    if (paramLayoutState.mItemDirection == 1)
    {
      bool = true;
      i = 0;
      j = 0;
      k = this.mSpanCount;
      if (!bool) {
        k = getSpanIndex(paramRecycler, paramState, paramLayoutState.mCurrentPosition) + getSpanSize(paramRecycler, paramState, paramLayoutState.mCurrentPosition);
      }
    }
    for (;;)
    {
      int i22;
      if ((i < this.mSpanCount) && (paramLayoutState.hasMore(paramState)) && (k > 0))
      {
        int i21 = paramLayoutState.mCurrentPosition;
        i22 = getSpanSize(paramRecycler, paramState, i21);
        if (i22 > this.mSpanCount)
        {
          throw new IllegalArgumentException("Item at position " + i21 + " requires " + i22 + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
          bool = false;
          break;
        }
        k -= i22;
        if (k >= 0) {
          break label187;
        }
      }
      label187:
      View localView4;
      do
      {
        if (i != 0) {
          break;
        }
        paramLayoutChunkResult.mFinished = true;
        return;
        localView4 = paramLayoutState.next(paramRecycler);
      } while (localView4 == null);
      j += i22;
      this.mSet[i] = localView4;
      i++;
    }
    assignSpans(paramRecycler, paramState, i, j, bool);
    int m = 0;
    int n = 0;
    label239:
    View localView3;
    label273:
    int i19;
    GridLayoutManager.LayoutParams localLayoutParams2;
    label332:
    int i20;
    if (m < i)
    {
      localView3 = this.mSet[m];
      if (paramLayoutState.mScrapList == null) {
        if (bool)
        {
          addView(localView3);
          i19 = View.MeasureSpec.makeMeasureSpec(getSpanSize(paramRecycler, paramState, getPosition(localView3)) * this.mSizePerSpan, 1073741824);
          localLayoutParams2 = (GridLayoutManager.LayoutParams)localView3.getLayoutParams();
          if (this.mOrientation != 1) {
            break label394;
          }
          measureChildWithDecorationsAndMargin(localView3, i19, getMainDirSpec(localLayoutParams2.height));
          i20 = this.mOrientationHelper.getDecoratedMeasurement(localView3);
          if (i20 <= n) {
            break label874;
          }
        }
      }
    }
    for (;;)
    {
      m++;
      n = i20;
      break label239;
      addView(localView3, 0);
      break label273;
      if (bool)
      {
        addDisappearingView(localView3);
        break label273;
      }
      addDisappearingView(localView3, 0);
      break label273;
      label394:
      measureChildWithDecorationsAndMargin(localView3, getMainDirSpec(localLayoutParams2.width), i19);
      break label332;
      int i1 = getMainDirSpec(n);
      int i2 = 0;
      if (i2 < i)
      {
        View localView2 = this.mSet[i2];
        int i18;
        if (this.mOrientationHelper.getDecoratedMeasurement(localView2) != n)
        {
          i18 = View.MeasureSpec.makeMeasureSpec(getSpanSize(paramRecycler, paramState, getPosition(localView2)) * this.mSizePerSpan, 1073741824);
          if (this.mOrientation != 1) {
            break label503;
          }
          measureChildWithDecorationsAndMargin(localView2, i18, i1);
        }
        for (;;)
        {
          i2++;
          break;
          label503:
          measureChildWithDecorationsAndMargin(localView2, i1, i18);
        }
      }
      paramLayoutChunkResult.mConsumed = n;
      int i3 = 0;
      int i6;
      int i5;
      int i4;
      int i7;
      int i8;
      int i9;
      int i10;
      int i11;
      label581:
      View localView1;
      GridLayoutManager.LayoutParams localLayoutParams1;
      int i14;
      int i12;
      if (this.mOrientation == 1) {
        if (paramLayoutState.mLayoutDirection == -1)
        {
          i3 = paramLayoutState.mOffset;
          i6 = i3 - n;
          i5 = 0;
          i4 = 0;
          i7 = 0;
          i8 = i4;
          i9 = i5;
          i10 = i6;
          i11 = i3;
          if (i7 >= i) {
            break label863;
          }
          localView1 = this.mSet[i7];
          localLayoutParams1 = (GridLayoutManager.LayoutParams)localView1.getLayoutParams();
          if (this.mOrientation != 1) {
            break label821;
          }
          i14 = getPaddingLeft() + this.mSizePerSpan * GridLayoutManager.LayoutParams.access$000(localLayoutParams1);
          i12 = i14 + this.mOrientationHelper.getDecoratedMeasurementInOther(localView1);
        }
      }
      for (int i13 = i14;; i13 = i8)
      {
        layoutDecorated(localView1, i13 + localLayoutParams1.leftMargin, i10 + localLayoutParams1.topMargin, i12 - localLayoutParams1.rightMargin, i11 - localLayoutParams1.bottomMargin);
        if ((localLayoutParams1.isItemRemoved()) || (localLayoutParams1.isItemChanged())) {
          paramLayoutChunkResult.mIgnoreConsumed = true;
        }
        paramLayoutChunkResult.mFocusable |= localView1.isFocusable();
        i7++;
        i9 = i12;
        i8 = i13;
        break label581;
        int i17 = paramLayoutState.mOffset;
        i3 = i17 + n;
        i6 = i17;
        i5 = 0;
        i4 = 0;
        break;
        if (paramLayoutState.mLayoutDirection == -1)
        {
          int i15 = paramLayoutState.mOffset;
          int i16 = i15 - n;
          i5 = i15;
          i4 = i16;
          i6 = 0;
          break;
        }
        i4 = paramLayoutState.mOffset;
        i5 = n + i4;
        i6 = 0;
        break;
        label821:
        i10 = getPaddingTop() + this.mSizePerSpan * GridLayoutManager.LayoutParams.access$000(localLayoutParams1);
        i11 = i10 + this.mOrientationHelper.getDecoratedMeasurementInOther(localView1);
        i12 = i9;
      }
      label863:
      Arrays.fill(this.mSet, null);
      break;
      label874:
      i20 = n;
    }
  }
  
  void onAnchorReady(RecyclerView.State paramState, LinearLayoutManager.AnchorInfo paramAnchorInfo)
  {
    super.onAnchorReady(paramState, paramAnchorInfo);
    updateMeasurements();
    if ((paramState.getItemCount() > 0) && (!paramState.isPreLayout())) {
      ensureAnchorIsInFirstSpan(paramAnchorInfo);
    }
    if ((this.mSet == null) || (this.mSet.length != this.mSpanCount)) {
      this.mSet = new View[this.mSpanCount];
    }
  }
  
  public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (!(localLayoutParams instanceof GridLayoutManager.LayoutParams))
    {
      super.onInitializeAccessibilityNodeInfoForItem(paramView, paramAccessibilityNodeInfoCompat);
      return;
    }
    GridLayoutManager.LayoutParams localLayoutParams1 = (GridLayoutManager.LayoutParams)localLayoutParams;
    int i = getSpanGroupIndex(paramRecycler, paramState, localLayoutParams1.getViewPosition());
    if (this.mOrientation == 0)
    {
      int m = localLayoutParams1.getSpanIndex();
      int n = localLayoutParams1.getSpanSize();
      if ((this.mSpanCount > 1) && (localLayoutParams1.getSpanSize() == this.mSpanCount)) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(m, n, i, 1, bool2, false));
        break;
      }
    }
    int j = localLayoutParams1.getSpanIndex();
    int k = localLayoutParams1.getSpanSize();
    if ((this.mSpanCount > 1) && (localLayoutParams1.getSpanSize() == this.mSpanCount)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i, 1, j, k, bool1, false));
      break;
    }
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (paramState.isPreLayout()) {
      cachePreLayoutSpanMapping();
    }
    super.onLayoutChildren(paramRecycler, paramState);
    clearPreLayoutSpanMappingCache();
  }
  
  public void setSpanCount(int paramInt)
  {
    if (paramInt == this.mSpanCount) {}
    for (;;)
    {
      return;
      if (paramInt < 1) {
        throw new IllegalArgumentException("Span count should be at least 1. Provided " + paramInt);
      }
      this.mSpanCount = paramInt;
      this.mSpanSizeLookup.invalidateSpanIndexCache();
    }
  }
  
  public void setSpanSizeLookup(GridLayoutManager.SpanSizeLookup paramSpanSizeLookup)
  {
    this.mSpanSizeLookup = paramSpanSizeLookup;
  }
  
  public void setStackFromEnd(boolean paramBoolean)
  {
    if (paramBoolean) {
      throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }
    super.setStackFromEnd(false);
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    if (this.mPendingSavedState == null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.GridLayoutManager
 * JD-Core Version:    0.7.0.1
 */