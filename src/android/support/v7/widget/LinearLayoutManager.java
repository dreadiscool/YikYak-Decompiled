package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcelable;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager
  extends RecyclerView.LayoutManager
{
  private static final boolean DEBUG = false;
  public static final int HORIZONTAL = 0;
  public static final int INVALID_OFFSET = -2147483648;
  private static final float MAX_SCROLL_FACTOR = 0.33F;
  private static final String TAG = "LinearLayoutManager";
  public static final int VERTICAL = 1;
  final LinearLayoutManager.AnchorInfo mAnchorInfo = new LinearLayoutManager.AnchorInfo(this);
  private boolean mLastStackFromEnd;
  private LinearLayoutManager.LayoutState mLayoutState;
  int mOrientation;
  OrientationHelper mOrientationHelper;
  LinearLayoutManager.SavedState mPendingSavedState = null;
  int mPendingScrollPosition = -1;
  int mPendingScrollPositionOffset = -2147483648;
  private boolean mRecycleChildrenOnDetach;
  private boolean mReverseLayout = false;
  boolean mShouldReverseLayout = false;
  private boolean mSmoothScrollbarEnabled = true;
  private boolean mStackFromEnd = false;
  
  public LinearLayoutManager(Context paramContext)
  {
    this(paramContext, 1, false);
  }
  
  public LinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean)
  {
    setOrientation(paramInt);
    setReverseLayout(paramBoolean);
  }
  
  private int computeScrollExtent(RecyclerView.State paramState)
  {
    if (getChildCount() == 0) {}
    for (int i = 0;; i = ScrollbarHelper.computeScrollExtent(paramState, this.mOrientationHelper, getChildClosestToStart(), getChildClosestToEnd(), this, this.mSmoothScrollbarEnabled))
    {
      return i;
      ensureLayoutState();
    }
  }
  
  private int computeScrollOffset(RecyclerView.State paramState)
  {
    if (getChildCount() == 0) {}
    for (int i = 0;; i = ScrollbarHelper.computeScrollOffset(paramState, this.mOrientationHelper, getChildClosestToStart(), getChildClosestToEnd(), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout))
    {
      return i;
      ensureLayoutState();
    }
  }
  
  private int computeScrollRange(RecyclerView.State paramState)
  {
    if (getChildCount() == 0) {}
    for (int i = 0;; i = ScrollbarHelper.computeScrollRange(paramState, this.mOrientationHelper, getChildClosestToStart(), getChildClosestToEnd(), this, this.mSmoothScrollbarEnabled))
    {
      return i;
      ensureLayoutState();
    }
  }
  
  private int convertFocusDirectionToLayoutDirection(int paramInt)
  {
    int i = -1;
    int j = 1;
    int k = -2147483648;
    switch (paramInt)
    {
    default: 
      i = k;
    case 1: 
    case 2: 
    case 33: 
    case 130: 
    case 17: 
      for (;;)
      {
        return i;
        i = j;
        continue;
        if (this.mOrientation != j)
        {
          i = k;
          continue;
          if (this.mOrientation == j) {
            k = j;
          }
          i = k;
          continue;
          if (this.mOrientation != 0) {
            i = k;
          }
        }
      }
    }
    if (this.mOrientation == 0) {}
    for (;;)
    {
      i = j;
      break;
      j = k;
    }
  }
  
  private View findFirstReferenceChild(int paramInt)
  {
    return findReferenceChild(0, getChildCount(), paramInt);
  }
  
  private View findLastReferenceChild(int paramInt)
  {
    return findReferenceChild(-1 + getChildCount(), -1, paramInt);
  }
  
  private View findReferenceChild(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = null;
    ensureLayoutState();
    int i = this.mOrientationHelper.getStartAfterPadding();
    int j = this.mOrientationHelper.getEndAfterPadding();
    int k;
    Object localObject2;
    label36:
    Object localObject3;
    Object localObject4;
    if (paramInt2 > paramInt1)
    {
      k = 1;
      localObject2 = null;
      if (paramInt1 == paramInt2) {
        break label157;
      }
      localObject3 = getChildAt(paramInt1);
      int m = getPosition((View)localObject3);
      if ((m < 0) || (m >= paramInt3)) {
        break label176;
      }
      if (!((RecyclerView.LayoutParams)((View)localObject3).getLayoutParams()).isItemRemoved()) {
        break label113;
      }
      if (localObject2 != null) {
        break label176;
      }
      localObject4 = localObject1;
    }
    for (;;)
    {
      paramInt1 += k;
      localObject1 = localObject4;
      localObject2 = localObject3;
      break label36;
      k = -1;
      break;
      label113:
      if ((this.mOrientationHelper.getDecoratedStart((View)localObject3) >= j) || (this.mOrientationHelper.getDecoratedEnd((View)localObject3) < i))
      {
        if (localObject1 != null) {
          break label176;
        }
        localObject4 = localObject3;
        localObject3 = localObject2;
        continue;
        if (localObject1 == null) {
          break label169;
        }
      }
      for (;;)
      {
        label157:
        localObject3 = localObject1;
        return localObject3;
        label169:
        localObject1 = localObject2;
      }
      label176:
      localObject4 = localObject1;
      localObject3 = localObject2;
    }
  }
  
  private View findReferenceChildClosestToEnd(RecyclerView.State paramState)
  {
    if (this.mShouldReverseLayout) {}
    for (View localView = findFirstReferenceChild(paramState.getItemCount());; localView = findLastReferenceChild(paramState.getItemCount())) {
      return localView;
    }
  }
  
  private View findReferenceChildClosestToStart(RecyclerView.State paramState)
  {
    if (this.mShouldReverseLayout) {}
    for (View localView = findLastReferenceChild(paramState.getItemCount());; localView = findFirstReferenceChild(paramState.getItemCount())) {
      return localView;
    }
  }
  
  private int fixLayoutEndGap(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i = this.mOrientationHelper.getEndAfterPadding() - paramInt;
    int j;
    if (i > 0)
    {
      j = -scrollBy(-i, paramRecycler, paramState);
      int k = paramInt + j;
      if (paramBoolean)
      {
        int m = this.mOrientationHelper.getEndAfterPadding() - k;
        if (m > 0)
        {
          this.mOrientationHelper.offsetChildren(m);
          j += m;
        }
      }
    }
    for (;;)
    {
      return j;
      j = 0;
    }
  }
  
  private int fixLayoutStartGap(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i = paramInt - this.mOrientationHelper.getStartAfterPadding();
    int j;
    if (i > 0)
    {
      j = -scrollBy(i, paramRecycler, paramState);
      int k = paramInt + j;
      if (paramBoolean)
      {
        int m = k - this.mOrientationHelper.getStartAfterPadding();
        if (m > 0)
        {
          this.mOrientationHelper.offsetChildren(-m);
          j -= m;
        }
      }
    }
    for (;;)
    {
      return j;
      j = 0;
    }
  }
  
  private View getChildClosestToEnd()
  {
    if (this.mShouldReverseLayout) {}
    for (int i = 0;; i = -1 + getChildCount()) {
      return getChildAt(i);
    }
  }
  
  private View getChildClosestToStart()
  {
    if (this.mShouldReverseLayout) {}
    for (int i = -1 + getChildCount();; i = 0) {
      return getChildAt(i);
    }
  }
  
  private void layoutForPredictiveAnimations(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2)
  {
    if ((!paramState.willRunPredictiveAnimations()) || (getChildCount() == 0) || (paramState.isPreLayout()) || (!supportsPredictiveItemAnimations())) {
      return;
    }
    int i = 0;
    int j = 0;
    List localList = paramRecycler.getScrapList();
    int k = localList.size();
    int m = getPosition(getChildAt(0));
    int n = 0;
    if (n < k)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)localList.get(n);
      int i5;
      label98:
      int i6;
      label111:
      int i8;
      int i7;
      if (localViewHolder.getPosition() < m)
      {
        i5 = 1;
        if (i5 == this.mShouldReverseLayout) {
          break label159;
        }
        i6 = -1;
        if (i6 != -1) {
          break label165;
        }
        i8 = i + this.mOrientationHelper.getDecoratedMeasurement(localViewHolder.itemView);
        i7 = j;
      }
      for (;;)
      {
        n++;
        i = i8;
        j = i7;
        break;
        i5 = 0;
        break label98;
        label159:
        i6 = 1;
        break label111;
        label165:
        i7 = j + this.mOrientationHelper.getDecoratedMeasurement(localViewHolder.itemView);
        i8 = i;
      }
    }
    this.mLayoutState.mScrapList = localList;
    int i4;
    label256:
    LinearLayoutManager.LayoutState localLayoutState1;
    int i1;
    if (i > 0)
    {
      updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), paramInt1);
      this.mLayoutState.mExtra = i;
      this.mLayoutState.mAvailable = 0;
      LinearLayoutManager.LayoutState localLayoutState2 = this.mLayoutState;
      int i3 = localLayoutState2.mCurrentPosition;
      if (this.mShouldReverseLayout)
      {
        i4 = 1;
        localLayoutState2.mCurrentPosition = (i4 + i3);
        fill(paramRecycler, this.mLayoutState, paramState, false);
      }
    }
    else if (j > 0)
    {
      updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), paramInt2);
      this.mLayoutState.mExtra = j;
      this.mLayoutState.mAvailable = 0;
      localLayoutState1 = this.mLayoutState;
      i1 = localLayoutState1.mCurrentPosition;
      if (!this.mShouldReverseLayout) {
        break label378;
      }
    }
    label378:
    for (int i2 = -1;; i2 = 1)
    {
      localLayoutState1.mCurrentPosition = (i2 + i1);
      fill(paramRecycler, this.mLayoutState, paramState, false);
      this.mLayoutState.mScrapList = null;
      break;
      i4 = -1;
      break label256;
    }
  }
  
  private void logChildren()
  {
    for (int i = 0; i < getChildCount(); i++)
    {
      View localView = getChildAt(i);
      new StringBuilder().append("item ").append(getPosition(localView)).append(", coord:").append(this.mOrientationHelper.getDecoratedStart(localView)).toString();
    }
  }
  
  private void recycleByLayoutState(RecyclerView.Recycler paramRecycler, LinearLayoutManager.LayoutState paramLayoutState)
  {
    if (!paramLayoutState.mRecycle) {}
    for (;;)
    {
      return;
      if (paramLayoutState.mLayoutDirection == -1) {
        recycleViewsFromEnd(paramRecycler, paramLayoutState.mScrollingOffset);
      } else {
        recycleViewsFromStart(paramRecycler, paramLayoutState.mScrollingOffset);
      }
    }
  }
  
  private void recycleChildren(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {}
    for (;;)
    {
      return;
      if (paramInt2 > paramInt1) {
        for (int i = paramInt2 - 1; i >= paramInt1; i--) {
          removeAndRecycleViewAt(i, paramRecycler);
        }
      } else {
        while (paramInt1 > paramInt2)
        {
          removeAndRecycleViewAt(paramInt1, paramRecycler);
          paramInt1--;
        }
      }
    }
  }
  
  private void recycleViewsFromEnd(RecyclerView.Recycler paramRecycler, int paramInt)
  {
    int i = getChildCount();
    if (paramInt < 0) {}
    label74:
    label125:
    for (;;)
    {
      return;
      int j = this.mOrientationHelper.getEnd() - paramInt;
      if (this.mShouldReverseLayout) {
        for (int m = 0;; m++)
        {
          if (m >= i) {
            break label74;
          }
          View localView2 = getChildAt(m);
          if (this.mOrientationHelper.getDecoratedStart(localView2) < j)
          {
            recycleChildren(paramRecycler, 0, m);
            break;
          }
        }
      } else {
        for (int k = i - 1;; k--)
        {
          if (k < 0) {
            break label125;
          }
          View localView1 = getChildAt(k);
          if (this.mOrientationHelper.getDecoratedStart(localView1) < j)
          {
            recycleChildren(paramRecycler, i - 1, k);
            break;
          }
        }
      }
    }
  }
  
  private void recycleViewsFromStart(RecyclerView.Recycler paramRecycler, int paramInt)
  {
    if (paramInt < 0) {}
    label65:
    label112:
    for (;;)
    {
      return;
      int i = getChildCount();
      if (this.mShouldReverseLayout) {
        for (int k = i - 1;; k--)
        {
          if (k < 0) {
            break label65;
          }
          View localView2 = getChildAt(k);
          if (this.mOrientationHelper.getDecoratedEnd(localView2) > paramInt)
          {
            recycleChildren(paramRecycler, i - 1, k);
            break;
          }
        }
      } else {
        for (int j = 0;; j++)
        {
          if (j >= i) {
            break label112;
          }
          View localView1 = getChildAt(j);
          if (this.mOrientationHelper.getDecoratedEnd(localView1) > paramInt)
          {
            recycleChildren(paramRecycler, 0, j);
            break;
          }
        }
      }
    }
  }
  
  private void resolveShouldLayoutReverse()
  {
    int i = 1;
    if ((this.mOrientation == i) || (!isLayoutRTL()))
    {
      this.mShouldReverseLayout = this.mReverseLayout;
      return;
    }
    if (!this.mReverseLayout) {}
    for (;;)
    {
      this.mShouldReverseLayout = i;
      break;
      i = 0;
    }
  }
  
  private boolean updateAnchorFromChildren(RecyclerView.State paramState, LinearLayoutManager.AnchorInfo paramAnchorInfo)
  {
    boolean bool = false;
    if (getChildCount() == 0) {}
    do
    {
      for (;;)
      {
        return bool;
        View localView1 = getFocusedChild();
        if ((localView1 == null) || (!paramAnchorInfo.assignFromViewIfValid(localView1, paramState))) {
          break;
        }
        bool = true;
      }
    } while (this.mLastStackFromEnd != this.mStackFromEnd);
    View localView2;
    if (paramAnchorInfo.mLayoutFromEnd)
    {
      localView2 = findReferenceChildClosestToEnd(paramState);
      label62:
      if (localView2 == null) {
        break label166;
      }
      paramAnchorInfo.assignFromView(localView2);
      if ((!paramState.isPreLayout()) && (supportsPredictiveItemAnimations()))
      {
        if ((this.mOrientationHelper.getDecoratedStart(localView2) >= this.mOrientationHelper.getEndAfterPadding()) || (this.mOrientationHelper.getDecoratedEnd(localView2) < this.mOrientationHelper.getStartAfterPadding())) {
          bool = true;
        }
        if (bool) {
          if (!paramAnchorInfo.mLayoutFromEnd) {
            break label168;
          }
        }
      }
    }
    label166:
    label168:
    for (int i = this.mOrientationHelper.getEndAfterPadding();; i = this.mOrientationHelper.getStartAfterPadding())
    {
      paramAnchorInfo.mCoordinate = i;
      bool = true;
      break;
      localView2 = findReferenceChildClosestToStart(paramState);
      break label62;
      break;
    }
  }
  
  private boolean updateAnchorFromPendingData(RecyclerView.State paramState, LinearLayoutManager.AnchorInfo paramAnchorInfo)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    if ((paramState.isPreLayout()) || (this.mPendingScrollPosition == -1)) {
      bool2 = false;
    }
    for (;;)
    {
      return bool2;
      if ((this.mPendingScrollPosition < 0) || (this.mPendingScrollPosition >= paramState.getItemCount()))
      {
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = -2147483648;
        bool2 = false;
      }
      else
      {
        paramAnchorInfo.mPosition = this.mPendingScrollPosition;
        if ((this.mPendingSavedState != null) && (this.mPendingSavedState.hasValidAnchor()))
        {
          paramAnchorInfo.mLayoutFromEnd = this.mPendingSavedState.mAnchorLayoutFromEnd;
          if (paramAnchorInfo.mLayoutFromEnd) {
            paramAnchorInfo.mCoordinate = (this.mOrientationHelper.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset);
          } else {
            paramAnchorInfo.mCoordinate = (this.mOrientationHelper.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset);
          }
        }
        else if (this.mPendingScrollPositionOffset == -2147483648)
        {
          View localView = findViewByPosition(this.mPendingScrollPosition);
          if (localView != null)
          {
            if (this.mOrientationHelper.getDecoratedMeasurement(localView) > this.mOrientationHelper.getTotalSpace())
            {
              paramAnchorInfo.assignCoordinateFromPadding();
            }
            else if (this.mOrientationHelper.getDecoratedStart(localView) - this.mOrientationHelper.getStartAfterPadding() < 0)
            {
              paramAnchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding();
              paramAnchorInfo.mLayoutFromEnd = false;
            }
            else if (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(localView) < 0)
            {
              paramAnchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
              paramAnchorInfo.mLayoutFromEnd = bool2;
            }
            else
            {
              if (paramAnchorInfo.mLayoutFromEnd) {}
              for (int j = this.mOrientationHelper.getDecoratedEnd(localView) + this.mOrientationHelper.getTotalSpaceChange();; j = this.mOrientationHelper.getDecoratedStart(localView))
              {
                paramAnchorInfo.mCoordinate = j;
                break;
              }
            }
          }
          else
          {
            if (getChildCount() > 0)
            {
              int i = getPosition(getChildAt(0));
              if (this.mPendingScrollPosition >= i) {
                break label383;
              }
            }
            label383:
            for (boolean bool3 = bool2;; bool3 = false)
            {
              if (bool3 == this.mShouldReverseLayout) {
                bool1 = bool2;
              }
              paramAnchorInfo.mLayoutFromEnd = bool1;
              paramAnchorInfo.assignCoordinateFromPadding();
              break;
            }
          }
        }
        else
        {
          paramAnchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
          if (this.mShouldReverseLayout) {
            paramAnchorInfo.mCoordinate = (this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset);
          } else {
            paramAnchorInfo.mCoordinate = (this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset);
          }
        }
      }
    }
  }
  
  private void updateAnchorInfoForLayout(RecyclerView.State paramState, LinearLayoutManager.AnchorInfo paramAnchorInfo)
  {
    if (updateAnchorFromPendingData(paramState, paramAnchorInfo)) {
      return;
    }
    if (!updateAnchorFromChildren(paramState, paramAnchorInfo))
    {
      paramAnchorInfo.assignCoordinateFromPadding();
      if (!this.mStackFromEnd) {
        break label46;
      }
    }
    label46:
    for (int i = -1 + paramState.getItemCount();; i = 0)
    {
      paramAnchorInfo.mPosition = i;
      break;
      break;
    }
  }
  
  private void updateLayoutState(int paramInt1, int paramInt2, boolean paramBoolean, RecyclerView.State paramState)
  {
    int i = -1;
    int j = 1;
    this.mLayoutState.mExtra = getExtraLayoutSpace(paramState);
    this.mLayoutState.mLayoutDirection = paramInt1;
    int k;
    if (paramInt1 == j)
    {
      LinearLayoutManager.LayoutState localLayoutState4 = this.mLayoutState;
      localLayoutState4.mExtra += this.mOrientationHelper.getEndPadding();
      View localView2 = getChildClosestToEnd();
      LinearLayoutManager.LayoutState localLayoutState5 = this.mLayoutState;
      if (this.mShouldReverseLayout) {}
      for (;;)
      {
        localLayoutState5.mItemDirection = i;
        this.mLayoutState.mCurrentPosition = (getPosition(localView2) + this.mLayoutState.mItemDirection);
        this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedEnd(localView2);
        k = this.mOrientationHelper.getDecoratedEnd(localView2) - this.mOrientationHelper.getEndAfterPadding();
        this.mLayoutState.mAvailable = paramInt2;
        if (paramBoolean)
        {
          LinearLayoutManager.LayoutState localLayoutState3 = this.mLayoutState;
          localLayoutState3.mAvailable -= k;
        }
        this.mLayoutState.mScrollingOffset = k;
        return;
        i = j;
      }
    }
    View localView1 = getChildClosestToStart();
    LinearLayoutManager.LayoutState localLayoutState1 = this.mLayoutState;
    localLayoutState1.mExtra += this.mOrientationHelper.getStartAfterPadding();
    LinearLayoutManager.LayoutState localLayoutState2 = this.mLayoutState;
    if (this.mShouldReverseLayout) {}
    for (;;)
    {
      localLayoutState2.mItemDirection = j;
      this.mLayoutState.mCurrentPosition = (getPosition(localView1) + this.mLayoutState.mItemDirection);
      this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedStart(localView1);
      k = -this.mOrientationHelper.getDecoratedStart(localView1) + this.mOrientationHelper.getStartAfterPadding();
      break;
      j = i;
    }
  }
  
  private void updateLayoutStateToFillEnd(int paramInt1, int paramInt2)
  {
    this.mLayoutState.mAvailable = (this.mOrientationHelper.getEndAfterPadding() - paramInt2);
    LinearLayoutManager.LayoutState localLayoutState = this.mLayoutState;
    if (this.mShouldReverseLayout) {}
    for (int i = -1;; i = 1)
    {
      localLayoutState.mItemDirection = i;
      this.mLayoutState.mCurrentPosition = paramInt1;
      this.mLayoutState.mLayoutDirection = 1;
      this.mLayoutState.mOffset = paramInt2;
      this.mLayoutState.mScrollingOffset = -2147483648;
      return;
    }
  }
  
  private void updateLayoutStateToFillEnd(LinearLayoutManager.AnchorInfo paramAnchorInfo)
  {
    updateLayoutStateToFillEnd(paramAnchorInfo.mPosition, paramAnchorInfo.mCoordinate);
  }
  
  private void updateLayoutStateToFillStart(int paramInt1, int paramInt2)
  {
    this.mLayoutState.mAvailable = (paramInt2 - this.mOrientationHelper.getStartAfterPadding());
    this.mLayoutState.mCurrentPosition = paramInt1;
    LinearLayoutManager.LayoutState localLayoutState = this.mLayoutState;
    if (this.mShouldReverseLayout) {}
    for (int i = 1;; i = -1)
    {
      localLayoutState.mItemDirection = i;
      this.mLayoutState.mLayoutDirection = -1;
      this.mLayoutState.mOffset = paramInt2;
      this.mLayoutState.mScrollingOffset = -2147483648;
      return;
    }
  }
  
  private void updateLayoutStateToFillStart(LinearLayoutManager.AnchorInfo paramAnchorInfo)
  {
    updateLayoutStateToFillStart(paramAnchorInfo.mPosition, paramAnchorInfo.mCoordinate);
  }
  
  public void assertNotInLayoutOrScroll(String paramString)
  {
    if (this.mPendingSavedState == null) {
      super.assertNotInLayoutOrScroll(paramString);
    }
  }
  
  public boolean canScrollHorizontally()
  {
    if (this.mOrientation == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean canScrollVertically()
  {
    int i = 1;
    if (this.mOrientation == i) {}
    for (;;)
    {
      return i;
      int j = 0;
    }
  }
  
  public int computeHorizontalScrollExtent(RecyclerView.State paramState)
  {
    return computeScrollExtent(paramState);
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.State paramState)
  {
    return computeScrollOffset(paramState);
  }
  
  public int computeHorizontalScrollRange(RecyclerView.State paramState)
  {
    return computeScrollRange(paramState);
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    int i = 1;
    int j = 0;
    PointF localPointF;
    if (getChildCount() == 0) {
      localPointF = null;
    }
    for (;;)
    {
      return localPointF;
      if (paramInt < getPosition(getChildAt(0))) {
        j = i;
      }
      if (j != this.mShouldReverseLayout) {
        i = -1;
      }
      if (this.mOrientation == 0) {
        localPointF = new PointF(i, 0.0F);
      } else {
        localPointF = new PointF(0.0F, i);
      }
    }
  }
  
  public int computeVerticalScrollExtent(RecyclerView.State paramState)
  {
    return computeScrollExtent(paramState);
  }
  
  public int computeVerticalScrollOffset(RecyclerView.State paramState)
  {
    return computeScrollOffset(paramState);
  }
  
  public int computeVerticalScrollRange(RecyclerView.State paramState)
  {
    return computeScrollRange(paramState);
  }
  
  void ensureLayoutState()
  {
    if (this.mLayoutState == null) {
      this.mLayoutState = new LinearLayoutManager.LayoutState();
    }
    if (this.mOrientationHelper == null) {
      this.mOrientationHelper = OrientationHelper.createOrientationHelper(this, this.mOrientation);
    }
  }
  
  int fill(RecyclerView.Recycler paramRecycler, LinearLayoutManager.LayoutState paramLayoutState, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i = paramLayoutState.mAvailable;
    if (paramLayoutState.mScrollingOffset != -2147483648)
    {
      if (paramLayoutState.mAvailable < 0) {
        paramLayoutState.mScrollingOffset += paramLayoutState.mAvailable;
      }
      recycleByLayoutState(paramRecycler, paramLayoutState);
    }
    int j = paramLayoutState.mAvailable + paramLayoutState.mExtra;
    LinearLayoutManager.LayoutChunkResult localLayoutChunkResult = new LinearLayoutManager.LayoutChunkResult();
    if ((j > 0) && (paramLayoutState.hasMore(paramState)))
    {
      localLayoutChunkResult.resetInternal();
      layoutChunk(paramRecycler, paramState, paramLayoutState, localLayoutChunkResult);
      if (!localLayoutChunkResult.mFinished) {
        break label104;
      }
    }
    for (;;)
    {
      return i - paramLayoutState.mAvailable;
      label104:
      paramLayoutState.mOffset += localLayoutChunkResult.mConsumed * paramLayoutState.mLayoutDirection;
      if ((!localLayoutChunkResult.mIgnoreConsumed) || (this.mLayoutState.mScrapList != null) || (!paramState.isPreLayout()))
      {
        paramLayoutState.mAvailable -= localLayoutChunkResult.mConsumed;
        j -= localLayoutChunkResult.mConsumed;
      }
      if (paramLayoutState.mScrollingOffset != -2147483648)
      {
        paramLayoutState.mScrollingOffset += localLayoutChunkResult.mConsumed;
        if (paramLayoutState.mAvailable < 0) {
          paramLayoutState.mScrollingOffset += paramLayoutState.mAvailable;
        }
        recycleByLayoutState(paramRecycler, paramLayoutState);
      }
      if ((!paramBoolean) || (!localLayoutChunkResult.mFocusable)) {
        break;
      }
    }
  }
  
  public int findFirstCompletelyVisibleItemPosition()
  {
    View localView = findOneVisibleChild(0, getChildCount(), true);
    if (localView == null) {}
    for (int i = -1;; i = getPosition(localView)) {
      return i;
    }
  }
  
  public int findFirstVisibleItemPosition()
  {
    View localView = findOneVisibleChild(0, getChildCount(), false);
    if (localView == null) {}
    for (int i = -1;; i = getPosition(localView)) {
      return i;
    }
  }
  
  public int findLastCompletelyVisibleItemPosition()
  {
    int i = -1;
    View localView = findOneVisibleChild(-1 + getChildCount(), i, true);
    if (localView == null) {}
    for (;;)
    {
      return i;
      i = getPosition(localView);
    }
  }
  
  public int findLastVisibleItemPosition()
  {
    int i = -1;
    View localView = findOneVisibleChild(-1 + getChildCount(), i, false);
    if (localView == null) {}
    for (;;)
    {
      return i;
      i = getPosition(localView);
    }
  }
  
  View findOneVisibleChild(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ensureLayoutState();
    int i = this.mOrientationHelper.getStartAfterPadding();
    int j = this.mOrientationHelper.getEndAfterPadding();
    int k;
    View localView2;
    View localView1;
    if (paramInt2 > paramInt1)
    {
      k = 1;
      if (paramInt1 == paramInt2) {
        break label125;
      }
      localView2 = getChildAt(paramInt1);
      int m = this.mOrientationHelper.getDecoratedStart(localView2);
      int n = this.mOrientationHelper.getDecoratedEnd(localView2);
      if ((m >= j) || (n <= i)) {
        break label117;
      }
      if (!paramBoolean) {
        break label110;
      }
      if ((m < i) || (n > j)) {
        break label117;
      }
      localView1 = localView2;
    }
    for (;;)
    {
      return localView1;
      k = -1;
      break;
      label110:
      localView1 = localView2;
      continue;
      label117:
      paramInt1 += k;
      break;
      label125:
      localView1 = null;
    }
  }
  
  public View findViewByPosition(int paramInt)
  {
    View localView = null;
    int i = getChildCount();
    if (i == 0) {}
    for (;;)
    {
      return localView;
      int j = paramInt - getPosition(getChildAt(0));
      if ((j >= 0) && (j < i)) {
        localView = getChildAt(j);
      }
    }
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  protected int getExtraLayoutSpace(RecyclerView.State paramState)
  {
    if (paramState.hasTargetScrollPosition()) {}
    for (int i = this.mOrientationHelper.getTotalSpace();; i = 0) {
      return i;
    }
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public boolean getRecycleChildrenOnDetach()
  {
    return this.mRecycleChildrenOnDetach;
  }
  
  public boolean getReverseLayout()
  {
    return this.mReverseLayout;
  }
  
  public boolean getStackFromEnd()
  {
    return this.mStackFromEnd;
  }
  
  protected boolean isLayoutRTL()
  {
    int i = 1;
    if (getLayoutDirection() == i) {}
    for (;;)
    {
      return i;
      int j = 0;
    }
  }
  
  public boolean isSmoothScrollbarEnabled()
  {
    return this.mSmoothScrollbarEnabled;
  }
  
  void layoutChunk(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.LayoutState paramLayoutState, LinearLayoutManager.LayoutChunkResult paramLayoutChunkResult)
  {
    View localView = paramLayoutState.next(paramRecycler);
    if (localView == null)
    {
      paramLayoutChunkResult.mFinished = true;
      return;
    }
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
    boolean bool4;
    label54:
    label67:
    int i3;
    int n;
    label129:
    int i;
    int i1;
    int j;
    if (paramLayoutState.mScrapList == null)
    {
      boolean bool3 = this.mShouldReverseLayout;
      if (paramLayoutState.mLayoutDirection == -1)
      {
        bool4 = true;
        if (bool3 != bool4) {
          break label243;
        }
        addView(localView);
        measureChildWithMargins(localView, 0, 0);
        paramLayoutChunkResult.mConsumed = this.mOrientationHelper.getDecoratedMeasurement(localView);
        if (this.mOrientation != 1) {
          break label359;
        }
        if (!isLayoutRTL()) {
          break label303;
        }
        i3 = getWidth() - getPaddingRight();
        n = i3 - this.mOrientationHelper.getDecoratedMeasurementInOther(localView);
        if (paramLayoutState.mLayoutDirection != -1) {
          break label326;
        }
        int i6 = paramLayoutState.mOffset;
        i = paramLayoutState.mOffset - paramLayoutChunkResult.mConsumed;
        i1 = i3;
        j = i6;
      }
    }
    for (;;)
    {
      layoutDecorated(localView, n + localLayoutParams.leftMargin, i + localLayoutParams.topMargin, i1 - localLayoutParams.rightMargin, j - localLayoutParams.bottomMargin);
      if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
        paramLayoutChunkResult.mIgnoreConsumed = true;
      }
      paramLayoutChunkResult.mFocusable = localView.isFocusable();
      break;
      bool4 = false;
      break label54;
      label243:
      addView(localView, 0);
      break label67;
      boolean bool1 = this.mShouldReverseLayout;
      if (paramLayoutState.mLayoutDirection == -1) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        if (bool1 != bool2) {
          break label293;
        }
        addDisappearingView(localView);
        break;
      }
      label293:
      addDisappearingView(localView, 0);
      break label67;
      label303:
      n = getPaddingLeft();
      i3 = n + this.mOrientationHelper.getDecoratedMeasurementInOther(localView);
      break label129;
      label326:
      int i4 = paramLayoutState.mOffset;
      int i5 = paramLayoutState.mOffset + paramLayoutChunkResult.mConsumed;
      i = i4;
      i1 = i3;
      j = i5;
      continue;
      label359:
      i = getPaddingTop();
      j = i + this.mOrientationHelper.getDecoratedMeasurementInOther(localView);
      if (paramLayoutState.mLayoutDirection == -1)
      {
        int i2 = paramLayoutState.mOffset;
        n = paramLayoutState.mOffset - paramLayoutChunkResult.mConsumed;
        i1 = i2;
      }
      else
      {
        int k = paramLayoutState.mOffset;
        int m = paramLayoutState.mOffset + paramLayoutChunkResult.mConsumed;
        n = k;
        i1 = m;
      }
    }
  }
  
  void onAnchorReady(RecyclerView.State paramState, LinearLayoutManager.AnchorInfo paramAnchorInfo) {}
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler)
  {
    super.onDetachedFromWindow(paramRecyclerView, paramRecycler);
    if (this.mRecycleChildrenOnDetach)
    {
      removeAndRecycleAllViews(paramRecycler);
      paramRecycler.clear();
    }
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    Object localObject = null;
    resolveShouldLayoutReverse();
    if (getChildCount() == 0) {}
    label154:
    label156:
    label163:
    for (;;)
    {
      return localObject;
      int i = convertFocusDirectionToLayoutDirection(paramInt);
      if (i != -2147483648)
      {
        ensureLayoutState();
        View localView1;
        if (i == -1)
        {
          localView1 = findReferenceChildClosestToStart(paramState);
          label50:
          if (localView1 == null) {
            break label154;
          }
          ensureLayoutState();
          updateLayoutState(i, (int)(0.33F * this.mOrientationHelper.getTotalSpace()), false, paramState);
          this.mLayoutState.mScrollingOffset = -2147483648;
          this.mLayoutState.mRecycle = false;
          fill(paramRecycler, this.mLayoutState, paramState, true);
          if (i != -1) {
            break label156;
          }
        }
        for (View localView2 = getChildClosestToStart();; localView2 = getChildClosestToEnd())
        {
          if ((localView2 == localView1) || (!localView2.isFocusable())) {
            break label163;
          }
          localObject = localView2;
          break;
          localView1 = findReferenceChildClosestToEnd(paramState);
          break label50;
          break;
        }
      }
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (getChildCount() > 0)
    {
      AccessibilityRecordCompat localAccessibilityRecordCompat = AccessibilityEventCompat.asRecord(paramAccessibilityEvent);
      localAccessibilityRecordCompat.setFromIndex(findFirstVisibleItemPosition());
      localAccessibilityRecordCompat.setToIndex(findLastVisibleItemPosition());
    }
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if ((this.mPendingSavedState != null) && (this.mPendingSavedState.hasValidAnchor())) {
      this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
    }
    ensureLayoutState();
    this.mLayoutState.mRecycle = false;
    resolveShouldLayoutReverse();
    this.mAnchorInfo.reset();
    this.mAnchorInfo.mLayoutFromEnd = (this.mShouldReverseLayout ^ this.mStackFromEnd);
    updateAnchorInfoForLayout(paramState, this.mAnchorInfo);
    int i = getExtraLayoutSpace(paramState);
    int j;
    int k;
    label113:
    int m;
    int n;
    View localView;
    int i12;
    label207:
    label219:
    int i2;
    label376:
    int i9;
    int i10;
    if (paramState.getTargetScrollPosition() < this.mAnchorInfo.mPosition)
    {
      j = 1;
      if (j != this.mShouldReverseLayout) {
        break label501;
      }
      k = i;
      i = 0;
      m = i + this.mOrientationHelper.getStartAfterPadding();
      n = k + this.mOrientationHelper.getEndPadding();
      if ((paramState.isPreLayout()) && (this.mPendingScrollPosition != -1) && (this.mPendingScrollPositionOffset != -2147483648))
      {
        localView = findViewByPosition(this.mPendingScrollPosition);
        if (localView != null)
        {
          if (!this.mShouldReverseLayout) {
            break label507;
          }
          i12 = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(localView) - this.mPendingScrollPositionOffset;
          if (i12 <= 0) {
            break label538;
          }
          m += i12;
        }
      }
      onAnchorReady(paramState, this.mAnchorInfo);
      detachAndScrapAttachedViews(paramRecycler);
      this.mLayoutState.mIsPreLayout = paramState.isPreLayout();
      if (!this.mAnchorInfo.mLayoutFromEnd) {
        break label548;
      }
      updateLayoutStateToFillStart(this.mAnchorInfo);
      this.mLayoutState.mExtra = m;
      fill(paramRecycler, this.mLayoutState, paramState, false);
      i2 = this.mLayoutState.mOffset;
      if (this.mLayoutState.mAvailable > 0) {
        n += this.mLayoutState.mAvailable;
      }
      updateLayoutStateToFillEnd(this.mAnchorInfo);
      this.mLayoutState.mExtra = n;
      LinearLayoutManager.LayoutState localLayoutState2 = this.mLayoutState;
      localLayoutState2.mCurrentPosition += this.mLayoutState.mItemDirection;
      fill(paramRecycler, this.mLayoutState, paramState, false);
      i1 = this.mLayoutState.mOffset;
      if (getChildCount() > 0)
      {
        if (!(this.mShouldReverseLayout ^ this.mStackFromEnd)) {
          break label673;
        }
        int i7 = fixLayoutEndGap(i1, paramRecycler, paramState, true);
        int i8 = i2 + i7;
        i9 = i1 + i7;
        i10 = fixLayoutStartGap(i8, paramRecycler, paramState, false);
        i2 = i8 + i10;
      }
    }
    label501:
    label507:
    int i5;
    label538:
    label548:
    int i6;
    for (int i1 = i9 + i10;; i1 = i5 + i6)
    {
      layoutForPredictiveAnimations(paramRecycler, paramState, i2, i1);
      if (!paramState.isPreLayout())
      {
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = -2147483648;
        this.mOrientationHelper.onLayoutComplete();
      }
      this.mLastStackFromEnd = this.mStackFromEnd;
      this.mPendingSavedState = null;
      return;
      j = 0;
      break;
      k = 0;
      break label113;
      int i11 = this.mOrientationHelper.getDecoratedStart(localView) - this.mOrientationHelper.getStartAfterPadding();
      i12 = this.mPendingScrollPositionOffset - i11;
      break label207;
      n -= i12;
      break label219;
      updateLayoutStateToFillEnd(this.mAnchorInfo);
      this.mLayoutState.mExtra = n;
      fill(paramRecycler, this.mLayoutState, paramState, false);
      i1 = this.mLayoutState.mOffset;
      if (this.mLayoutState.mAvailable > 0) {
        m += this.mLayoutState.mAvailable;
      }
      updateLayoutStateToFillStart(this.mAnchorInfo);
      this.mLayoutState.mExtra = m;
      LinearLayoutManager.LayoutState localLayoutState1 = this.mLayoutState;
      localLayoutState1.mCurrentPosition += this.mLayoutState.mItemDirection;
      fill(paramRecycler, this.mLayoutState, paramState, false);
      i2 = this.mLayoutState.mOffset;
      break label376;
      label673:
      int i3 = fixLayoutStartGap(i2, paramRecycler, paramState, true);
      int i4 = i2 + i3;
      i5 = i1 + i3;
      i6 = fixLayoutEndGap(i5, paramRecycler, paramState, false);
      i2 = i4 + i6;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof LinearLayoutManager.SavedState))
    {
      this.mPendingSavedState = ((LinearLayoutManager.SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    LinearLayoutManager.SavedState localSavedState;
    if (this.mPendingSavedState != null) {
      localSavedState = new LinearLayoutManager.SavedState(this.mPendingSavedState);
    }
    for (;;)
    {
      return localSavedState;
      localSavedState = new LinearLayoutManager.SavedState();
      if (getChildCount() > 0)
      {
        ensureLayoutState();
        boolean bool = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
        localSavedState.mAnchorLayoutFromEnd = bool;
        if (bool)
        {
          View localView2 = getChildClosestToEnd();
          localSavedState.mAnchorOffset = (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(localView2));
          localSavedState.mAnchorPosition = getPosition(localView2);
        }
        else
        {
          View localView1 = getChildClosestToStart();
          localSavedState.mAnchorPosition = getPosition(localView1);
          localSavedState.mAnchorOffset = (this.mOrientationHelper.getDecoratedStart(localView1) - this.mOrientationHelper.getStartAfterPadding());
        }
      }
      else
      {
        localSavedState.invalidateAnchor();
      }
    }
  }
  
  int scrollBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if ((getChildCount() == 0) || (paramInt == 0)) {
      paramInt = 0;
    }
    for (;;)
    {
      return paramInt;
      this.mLayoutState.mRecycle = true;
      ensureLayoutState();
      if (paramInt > 0) {}
      int j;
      int k;
      for (int i = 1;; i = -1)
      {
        j = Math.abs(paramInt);
        updateLayoutState(i, j, true, paramState);
        k = this.mLayoutState.mScrollingOffset + fill(paramRecycler, this.mLayoutState, paramState, false);
        if (k >= 0) {
          break label88;
        }
        paramInt = 0;
        break;
      }
      label88:
      if (j > k) {
        paramInt = i * k;
      }
      this.mOrientationHelper.offsetChildren(-paramInt);
    }
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mOrientation == 1) {}
    for (int i = 0;; i = scrollBy(paramInt, paramRecycler, paramState)) {
      return i;
    }
  }
  
  public void scrollToPosition(int paramInt)
  {
    this.mPendingScrollPosition = paramInt;
    this.mPendingScrollPositionOffset = -2147483648;
    if (this.mPendingSavedState != null) {
      this.mPendingSavedState.invalidateAnchor();
    }
    requestLayout();
  }
  
  public void scrollToPositionWithOffset(int paramInt1, int paramInt2)
  {
    this.mPendingScrollPosition = paramInt1;
    this.mPendingScrollPositionOffset = paramInt2;
    if (this.mPendingSavedState != null) {
      this.mPendingSavedState.invalidateAnchor();
    }
    requestLayout();
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mOrientation == 0) {}
    for (int i = 0;; i = scrollBy(paramInt, paramRecycler, paramState)) {
      return i;
    }
  }
  
  public void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation:" + paramInt);
    }
    assertNotInLayoutOrScroll(null);
    if (paramInt == this.mOrientation) {}
    for (;;)
    {
      return;
      this.mOrientation = paramInt;
      this.mOrientationHelper = null;
      requestLayout();
    }
  }
  
  public void setRecycleChildrenOnDetach(boolean paramBoolean)
  {
    this.mRecycleChildrenOnDetach = paramBoolean;
  }
  
  public void setReverseLayout(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    if (paramBoolean == this.mReverseLayout) {}
    for (;;)
    {
      return;
      this.mReverseLayout = paramBoolean;
      requestLayout();
    }
  }
  
  public void setSmoothScrollbarEnabled(boolean paramBoolean)
  {
    this.mSmoothScrollbarEnabled = paramBoolean;
  }
  
  public void setStackFromEnd(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    if (this.mStackFromEnd == paramBoolean) {}
    for (;;)
    {
      return;
      this.mStackFromEnd = paramBoolean;
      requestLayout();
    }
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt)
  {
    LinearLayoutManager.1 local1 = new LinearLayoutManager.1(this, paramRecyclerView.getContext());
    local1.setTargetPosition(paramInt);
    startSmoothScroll(local1);
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    if ((this.mPendingSavedState == null) && (this.mLastStackFromEnd == this.mStackFromEnd)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  void validateChildOrder()
  {
    int i = 1;
    new StringBuilder().append("validating child count ").append(getChildCount()).toString();
    if (getChildCount() < i) {}
    for (;;)
    {
      return;
      int k = getPosition(getChildAt(0));
      int m = this.mOrientationHelper.getDecoratedStart(getChildAt(0));
      int j;
      if (this.mShouldReverseLayout) {
        for (int i3 = i; i3 < getChildCount(); i3++)
        {
          View localView2 = getChildAt(i3);
          int i4 = getPosition(localView2);
          int i5 = this.mOrientationHelper.getDecoratedStart(localView2);
          if (i4 < k)
          {
            logChildren();
            StringBuilder localStringBuilder2 = new StringBuilder().append("detected invalid position. loc invalid? ");
            if (i5 < m) {}
            for (;;)
            {
              throw new RuntimeException(i);
              j = 0;
            }
          }
          if (i5 > m)
          {
            logChildren();
            throw new RuntimeException("detected invalid location");
          }
        }
      } else {
        for (int n = j; n < getChildCount(); n++)
        {
          View localView1 = getChildAt(n);
          int i1 = getPosition(localView1);
          int i2 = this.mOrientationHelper.getDecoratedStart(localView1);
          if (i1 < k)
          {
            logChildren();
            StringBuilder localStringBuilder1 = new StringBuilder().append("detected invalid position. loc invalid? ");
            if (i2 < m) {}
            for (;;)
            {
              throw new RuntimeException(j);
              j = 0;
            }
          }
          if (i2 < m)
          {
            logChildren();
            throw new RuntimeException("detected invalid location");
          }
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */