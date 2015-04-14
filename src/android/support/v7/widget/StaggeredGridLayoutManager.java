package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.BitSet;

public class StaggeredGridLayoutManager
  extends RecyclerView.LayoutManager
{
  private static final boolean DEBUG = false;
  @Deprecated
  public static final int GAP_HANDLING_LAZY = 1;
  public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
  public static final int GAP_HANDLING_NONE = 0;
  public static final int HORIZONTAL = 0;
  private static final int INVALID_OFFSET = -2147483648;
  public static final String TAG = "StaggeredGridLayoutManager";
  public static final int VERTICAL = 1;
  private final Runnable checkForGapsRunnable = new StaggeredGridLayoutManager.1(this);
  private final StaggeredGridLayoutManager.AnchorInfo mAnchorInfo = new StaggeredGridLayoutManager.AnchorInfo(this, null);
  private int mFullSizeSpec;
  private int mGapStrategy = 2;
  private int mHeightSpec;
  private boolean mLaidOutInvalidFullSpan = false;
  private boolean mLastLayoutFromEnd;
  private boolean mLastLayoutRTL;
  private LayoutState mLayoutState;
  StaggeredGridLayoutManager.LazySpanLookup mLazySpanLookup = new StaggeredGridLayoutManager.LazySpanLookup();
  private int mOrientation;
  private StaggeredGridLayoutManager.SavedState mPendingSavedState;
  int mPendingScrollPosition = -1;
  int mPendingScrollPositionOffset = -2147483648;
  OrientationHelper mPrimaryOrientation;
  private BitSet mRemainingSpans;
  private boolean mReverseLayout = false;
  OrientationHelper mSecondaryOrientation;
  boolean mShouldReverseLayout = false;
  private int mSizePerSpan;
  private boolean mSmoothScrollbarEnabled = true;
  private int mSpanCount = -1;
  private StaggeredGridLayoutManager.Span[] mSpans;
  private int mWidthSpec;
  
  public StaggeredGridLayoutManager(int paramInt1, int paramInt2)
  {
    this.mOrientation = paramInt2;
    setSpanCount(paramInt1);
  }
  
  private void appendViewToAllSpans(View paramView)
  {
    for (int i = -1 + this.mSpanCount; i >= 0; i--) {
      this.mSpans[i].appendToSpan(paramView);
    }
  }
  
  private void applyPendingSavedState(StaggeredGridLayoutManager.AnchorInfo paramAnchorInfo)
  {
    if (this.mPendingSavedState.mSpanOffsetsSize > 0) {
      if (this.mPendingSavedState.mSpanOffsetsSize == this.mSpanCount)
      {
        int i = 0;
        if (i < this.mSpanCount)
        {
          this.mSpans[i].clear();
          int j = this.mPendingSavedState.mSpanOffsets[i];
          if (j != -2147483648)
          {
            if (!this.mPendingSavedState.mAnchorLayoutFromEnd) {
              break label95;
            }
            j += this.mPrimaryOrientation.getEndAfterPadding();
          }
          for (;;)
          {
            this.mSpans[i].setLine(j);
            i++;
            break;
            label95:
            j += this.mPrimaryOrientation.getStartAfterPadding();
          }
        }
      }
      else
      {
        this.mPendingSavedState.invalidateSpanInfo();
        this.mPendingSavedState.mAnchorPosition = this.mPendingSavedState.mVisibleAnchorPosition;
      }
    }
    this.mLastLayoutRTL = this.mPendingSavedState.mLastLayoutRTL;
    setReverseLayout(this.mPendingSavedState.mReverseLayout);
    resolveShouldLayoutReverse();
    if (this.mPendingSavedState.mAnchorPosition != -1) {
      this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
    }
    for (paramAnchorInfo.mLayoutFromEnd = this.mPendingSavedState.mAnchorLayoutFromEnd;; paramAnchorInfo.mLayoutFromEnd = this.mShouldReverseLayout)
    {
      if (this.mPendingSavedState.mSpanLookupSize > 1)
      {
        this.mLazySpanLookup.mData = this.mPendingSavedState.mSpanLookup;
        this.mLazySpanLookup.mFullSpanItems = this.mPendingSavedState.mFullSpanItems;
      }
      return;
    }
  }
  
  private void attachViewToSpans(View paramView, StaggeredGridLayoutManager.LayoutParams paramLayoutParams, LayoutState paramLayoutState)
  {
    if (paramLayoutState.mLayoutDirection == 1) {
      if (paramLayoutParams.mFullSpan) {
        appendViewToAllSpans(paramView);
      }
    }
    for (;;)
    {
      return;
      paramLayoutParams.mSpan.appendToSpan(paramView);
      continue;
      if (paramLayoutParams.mFullSpan) {
        prependViewToAllSpans(paramView);
      } else {
        paramLayoutParams.mSpan.prependToSpan(paramView);
      }
    }
  }
  
  private int calculateScrollDirectionForPosition(int paramInt)
  {
    int i = -1;
    int j = 1;
    if (getChildCount() == 0)
    {
      if (this.mShouldReverseLayout) {}
      for (;;)
      {
        return j;
        j = i;
      }
    }
    int k;
    if (paramInt < getFirstChildPosition())
    {
      k = j;
      label37:
      if (k == this.mShouldReverseLayout) {
        break label57;
      }
    }
    for (;;)
    {
      j = i;
      break;
      k = 0;
      break label37;
      label57:
      i = j;
    }
  }
  
  private void checkForGaps()
  {
    if ((getChildCount() == 0) || (this.mGapStrategy == 0)) {}
    int k;
    int m;
    label88:
    do
    {
      return;
      int i2;
      if (this.mShouldReverseLayout)
      {
        int i1 = getLastChildPosition();
        i2 = getFirstChildPosition();
        k = i1;
      }
      int j;
      for (m = i2;; m = j)
      {
        if ((k != 0) || (hasGapsToFix() == null)) {
          break label88;
        }
        this.mLazySpanLookup.clear();
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        break;
        int i = getFirstChildPosition();
        j = getLastChildPosition();
        k = i;
      }
    } while (!this.mLaidOutInvalidFullSpan);
    if (this.mShouldReverseLayout) {}
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem1;
    for (int n = -1;; n = 1)
    {
      localFullSpanItem1 = this.mLazySpanLookup.getFirstFullSpanItemInRange(k, m + 1, n);
      if (localFullSpanItem1 != null) {
        break label153;
      }
      this.mLaidOutInvalidFullSpan = false;
      this.mLazySpanLookup.forceInvalidateAfter(m + 1);
      break;
    }
    label153:
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem2 = this.mLazySpanLookup.getFirstFullSpanItemInRange(k, localFullSpanItem1.mPosition, n * -1);
    if (localFullSpanItem2 == null) {
      this.mLazySpanLookup.forceInvalidateAfter(localFullSpanItem1.mPosition);
    }
    for (;;)
    {
      requestSimpleAnimationsInNextLayout();
      requestLayout();
      break;
      this.mLazySpanLookup.forceInvalidateAfter(1 + localFullSpanItem2.mPosition);
    }
  }
  
  private boolean checkSpanForGap(StaggeredGridLayoutManager.Span paramSpan)
  {
    boolean bool = true;
    if (this.mShouldReverseLayout) {
      if (paramSpan.getEndLine() >= this.mPrimaryOrientation.getEndAfterPadding()) {
        break label39;
      }
    }
    for (;;)
    {
      return bool;
      if (paramSpan.getStartLine() <= this.mPrimaryOrientation.getStartAfterPadding()) {
        label39:
        bool = false;
      }
    }
  }
  
  private int computeScrollExtent(RecyclerView.State paramState)
  {
    boolean bool1 = true;
    int i = 0;
    if (getChildCount() == 0) {
      return i;
    }
    ensureOrientationHelper();
    OrientationHelper localOrientationHelper = this.mPrimaryOrientation;
    boolean bool2;
    label33:
    View localView;
    if (!this.mSmoothScrollbarEnabled)
    {
      bool2 = bool1;
      localView = findFirstVisibleItemClosestToStart(bool2);
      if (this.mSmoothScrollbarEnabled) {
        break label76;
      }
    }
    for (;;)
    {
      i = ScrollbarHelper.computeScrollExtent(paramState, localOrientationHelper, localView, findFirstVisibleItemClosestToEnd(bool1), this, this.mSmoothScrollbarEnabled);
      break;
      bool2 = false;
      break label33;
      label76:
      bool1 = false;
    }
  }
  
  private int computeScrollOffset(RecyclerView.State paramState)
  {
    boolean bool1 = true;
    int i = 0;
    if (getChildCount() == 0) {
      return i;
    }
    ensureOrientationHelper();
    OrientationHelper localOrientationHelper = this.mPrimaryOrientation;
    boolean bool2;
    label33:
    View localView;
    if (!this.mSmoothScrollbarEnabled)
    {
      bool2 = bool1;
      localView = findFirstVisibleItemClosestToStart(bool2);
      if (this.mSmoothScrollbarEnabled) {
        break label80;
      }
    }
    for (;;)
    {
      i = ScrollbarHelper.computeScrollOffset(paramState, localOrientationHelper, localView, findFirstVisibleItemClosestToEnd(bool1), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
      break;
      bool2 = false;
      break label33;
      label80:
      bool1 = false;
    }
  }
  
  private int computeScrollRange(RecyclerView.State paramState)
  {
    boolean bool1 = true;
    int i = 0;
    if (getChildCount() == 0) {
      return i;
    }
    ensureOrientationHelper();
    OrientationHelper localOrientationHelper = this.mPrimaryOrientation;
    boolean bool2;
    label33:
    View localView;
    if (!this.mSmoothScrollbarEnabled)
    {
      bool2 = bool1;
      localView = findFirstVisibleItemClosestToStart(bool2);
      if (this.mSmoothScrollbarEnabled) {
        break label76;
      }
    }
    for (;;)
    {
      i = ScrollbarHelper.computeScrollRange(paramState, localOrientationHelper, localView, findFirstVisibleItemClosestToEnd(bool1), this, this.mSmoothScrollbarEnabled);
      break;
      bool2 = false;
      break label33;
      label76:
      bool1 = false;
    }
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem createFullSpanItemFromEnd(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    localFullSpanItem.mGapPerSpan = new int[this.mSpanCount];
    for (int i = 0; i < this.mSpanCount; i++) {
      localFullSpanItem.mGapPerSpan[i] = (paramInt - this.mSpans[i].getEndLine(paramInt));
    }
    return localFullSpanItem;
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem createFullSpanItemFromStart(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    localFullSpanItem.mGapPerSpan = new int[this.mSpanCount];
    for (int i = 0; i < this.mSpanCount; i++) {
      localFullSpanItem.mGapPerSpan[i] = (this.mSpans[i].getStartLine(paramInt) - paramInt);
    }
    return localFullSpanItem;
  }
  
  private void ensureOrientationHelper()
  {
    if (this.mPrimaryOrientation == null)
    {
      this.mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, this.mOrientation);
      this.mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - this.mOrientation);
      this.mLayoutState = new LayoutState();
    }
  }
  
  private int fill(RecyclerView.Recycler paramRecycler, LayoutState paramLayoutState, RecyclerView.State paramState)
  {
    this.mRemainingSpans.set(0, this.mSpanCount, true);
    int k;
    int m;
    int n;
    label92:
    View localView;
    StaggeredGridLayoutManager.LayoutParams localLayoutParams;
    label141:
    int i4;
    int i5;
    int i6;
    label177:
    StaggeredGridLayoutManager.Span localSpan2;
    label198:
    StaggeredGridLayoutManager.Span localSpan1;
    label213:
    int i13;
    label237:
    int i9;
    int i8;
    if (paramLayoutState.mLayoutDirection == 1)
    {
      int i14 = this.mPrimaryOrientation.getEndAfterPadding() + this.mLayoutState.mAvailable;
      int i15 = i14 + this.mLayoutState.mExtra + this.mPrimaryOrientation.getEndPadding();
      k = i14;
      m = i15;
      updateAllRemainingSpans(paramLayoutState.mLayoutDirection, m);
      if (!this.mShouldReverseLayout) {
        break label480;
      }
      n = this.mPrimaryOrientation.getEndAfterPadding();
      if ((!paramLayoutState.hasMore(paramState)) || (this.mRemainingSpans.isEmpty())) {
        break label696;
      }
      localView = paramLayoutState.next(paramRecycler);
      localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      if (paramLayoutState.mLayoutDirection != 1) {
        break label492;
      }
      addView(localView);
      measureChildWithDecorationsAndMargin(localView, localLayoutParams);
      i4 = localLayoutParams.getViewPosition();
      i5 = this.mLazySpanLookup.getSpan(i4);
      if (i5 != -1) {
        break label502;
      }
      i6 = 1;
      if (i6 == 0) {
        break label518;
      }
      if (!localLayoutParams.mFullSpan) {
        break label508;
      }
      localSpan2 = this.mSpans[0];
      this.mLazySpanLookup.setSpan(i4, localSpan2);
      localSpan1 = localSpan2;
      if (paramLayoutState.mLayoutDirection != 1) {
        break label542;
      }
      if (!localLayoutParams.mFullSpan) {
        break label530;
      }
      i13 = getMaxEnd(n);
      i9 = i13 + this.mPrimaryOrientation.getDecoratedMeasurement(localView);
      if ((i6 == 0) || (!localLayoutParams.mFullSpan)) {
        break label778;
      }
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem2 = createFullSpanItemFromEnd(i13);
      localFullSpanItem2.mGapDir = -1;
      localFullSpanItem2.mPosition = i4;
      this.mLazySpanLookup.addFullSpanItem(localFullSpanItem2);
      i8 = i13;
    }
    for (;;)
    {
      if ((localLayoutParams.mFullSpan) && (paramLayoutState.mItemDirection == -1) && (i6 != 0)) {
        this.mLaidOutInvalidFullSpan = true;
      }
      localLayoutParams.mSpan = localSpan1;
      attachViewToSpans(localView, localLayoutParams, paramLayoutState);
      int i10;
      label359:
      int i11;
      if (localLayoutParams.mFullSpan)
      {
        i10 = this.mSecondaryOrientation.getStartAfterPadding();
        i11 = i10 + this.mSecondaryOrientation.getDecoratedMeasurement(localView);
        if (this.mOrientation != 1) {
          break label657;
        }
        layoutDecoratedWithMargins(localView, i10, i8, i11, i9);
        label395:
        if (!localLayoutParams.mFullSpan) {
          break label674;
        }
        updateAllRemainingSpans(this.mLayoutState.mLayoutDirection, m);
      }
      for (;;)
      {
        recycle(paramRecycler, this.mLayoutState, localSpan1, k);
        break label92;
        int i = this.mPrimaryOrientation.getStartAfterPadding() - this.mLayoutState.mAvailable;
        int j = i - this.mLayoutState.mExtra - this.mPrimaryOrientation.getStartAfterPadding();
        k = i;
        m = j;
        break;
        label480:
        n = this.mPrimaryOrientation.getStartAfterPadding();
        break label92;
        label492:
        addView(localView, 0);
        break label141;
        label502:
        i6 = 0;
        break label177;
        label508:
        localSpan2 = getNextSpan(paramLayoutState);
        break label198;
        label518:
        localSpan1 = this.mSpans[i5];
        break label213;
        label530:
        i13 = localSpan1.getEndLine(n);
        break label237;
        label542:
        if (localLayoutParams.mFullSpan) {}
        for (int i7 = getMinStart(n);; i7 = localSpan1.getStartLine(n))
        {
          i8 = i7 - this.mPrimaryOrientation.getDecoratedMeasurement(localView);
          if ((i6 != 0) && (localLayoutParams.mFullSpan))
          {
            StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem1 = createFullSpanItemFromStart(i7);
            localFullSpanItem1.mGapDir = 1;
            localFullSpanItem1.mPosition = i4;
            this.mLazySpanLookup.addFullSpanItem(localFullSpanItem1);
          }
          i9 = i7;
          break;
        }
        i10 = localSpan1.mIndex * this.mSizePerSpan + this.mSecondaryOrientation.getStartAfterPadding();
        break label359;
        label657:
        layoutDecoratedWithMargins(localView, i8, i10, i9, i11);
        break label395;
        label674:
        int i12 = this.mLayoutState.mLayoutDirection;
        updateRemainingSpans(localSpan1, i12, m);
      }
      label696:
      int i3;
      if (this.mLayoutState.mLayoutDirection == -1) {
        i3 = getMinStart(this.mPrimaryOrientation.getStartAfterPadding());
      }
      int i1;
      for (int i2 = Math.max(0, this.mLayoutState.mAvailable + (k - i3));; i2 = Math.max(0, this.mLayoutState.mAvailable + (i1 - k)))
      {
        return i2;
        i1 = getMaxEnd(this.mPrimaryOrientation.getEndAfterPadding());
      }
      label778:
      i8 = i13;
    }
  }
  
  private int findFirstReferenceChildPosition(int paramInt)
  {
    int i = getChildCount();
    int j = 0;
    int k;
    if (j < i)
    {
      k = getPosition(getChildAt(j));
      if ((k < 0) || (k >= paramInt)) {}
    }
    for (;;)
    {
      return k;
      j++;
      break;
      k = 0;
    }
  }
  
  private int findLastReferenceChildPosition(int paramInt)
  {
    int i = -1 + getChildCount();
    int j;
    if (i >= 0)
    {
      j = getPosition(getChildAt(i));
      if ((j < 0) || (j >= paramInt)) {}
    }
    for (;;)
    {
      return j;
      i--;
      break;
      j = 0;
    }
  }
  
  private void fixEndGap(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i = getMaxEnd(this.mPrimaryOrientation.getEndAfterPadding());
    int j = this.mPrimaryOrientation.getEndAfterPadding() - i;
    if (j > 0)
    {
      int k = j - -scrollBy(-j, paramRecycler, paramState);
      if ((paramBoolean) && (k > 0)) {
        this.mPrimaryOrientation.offsetChildren(k);
      }
    }
  }
  
  private void fixStartGap(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i = getMinStart(this.mPrimaryOrientation.getStartAfterPadding()) - this.mPrimaryOrientation.getStartAfterPadding();
    if (i > 0)
    {
      int j = i - scrollBy(i, paramRecycler, paramState);
      if ((paramBoolean) && (j > 0)) {
        this.mPrimaryOrientation.offsetChildren(-j);
      }
    }
  }
  
  private int getFirstChildPosition()
  {
    int i = 0;
    if (getChildCount() == 0) {}
    for (;;)
    {
      return i;
      i = getPosition(getChildAt(0));
    }
  }
  
  private int getLastChildPosition()
  {
    int i = getChildCount();
    if (i == 0) {}
    for (int j = 0;; j = getPosition(getChildAt(i - 1))) {
      return j;
    }
  }
  
  private int getMaxEnd(int paramInt)
  {
    int i = this.mSpans[0].getEndLine(paramInt);
    for (int j = 1; j < this.mSpanCount; j++)
    {
      int k = this.mSpans[j].getEndLine(paramInt);
      if (k > i) {
        i = k;
      }
    }
    return i;
  }
  
  private int getMaxStart(int paramInt)
  {
    int i = this.mSpans[0].getStartLine(paramInt);
    for (int j = 1; j < this.mSpanCount; j++)
    {
      int k = this.mSpans[j].getStartLine(paramInt);
      if (k > i) {
        i = k;
      }
    }
    return i;
  }
  
  private int getMinEnd(int paramInt)
  {
    int i = this.mSpans[0].getEndLine(paramInt);
    for (int j = 1; j < this.mSpanCount; j++)
    {
      int k = this.mSpans[j].getEndLine(paramInt);
      if (k < i) {
        i = k;
      }
    }
    return i;
  }
  
  private int getMinStart(int paramInt)
  {
    int i = this.mSpans[0].getStartLine(paramInt);
    for (int j = 1; j < this.mSpanCount; j++)
    {
      int k = this.mSpans[j].getStartLine(paramInt);
      if (k < i) {
        i = k;
      }
    }
    return i;
  }
  
  private StaggeredGridLayoutManager.Span getNextSpan(LayoutState paramLayoutState)
  {
    Object localObject1 = null;
    int i = -1;
    int k;
    int m;
    int i5;
    int i6;
    label54:
    StaggeredGridLayoutManager.Span localSpan2;
    int i7;
    if (preferLastSpan(paramLayoutState.mLayoutDirection))
    {
      k = -1 + this.mSpanCount;
      m = i;
      if (paramLayoutState.mLayoutDirection != 1) {
        break label124;
      }
      int i4 = this.mPrimaryOrientation.getStartAfterPadding();
      i5 = k;
      i6 = 2147483647;
      if (i5 == m) {
        break label193;
      }
      localSpan2 = this.mSpans[i5];
      i7 = localSpan2.getEndLine(i4);
      if (i7 >= i6) {
        break label205;
      }
    }
    for (Object localObject3 = localSpan2;; localObject3 = localObject1)
    {
      i5 += i;
      localObject1 = localObject3;
      i6 = i7;
      break label54;
      int j = this.mSpanCount;
      k = 0;
      m = j;
      i = 1;
      break;
      label124:
      int n = this.mPrimaryOrientation.getEndAfterPadding();
      int i1 = k;
      int i2 = -2147483648;
      StaggeredGridLayoutManager.Span localSpan1;
      int i3;
      if (i1 != m)
      {
        localSpan1 = this.mSpans[i1];
        i3 = localSpan1.getStartLine(n);
        if (i3 <= i2) {
          break label195;
        }
      }
      for (Object localObject2 = localSpan1;; localObject2 = localObject1)
      {
        i1 += i;
        localObject1 = localObject2;
        i2 = i3;
        break;
        label193:
        return localObject1;
        label195:
        i3 = i2;
      }
      label205:
      i7 = i6;
    }
  }
  
  private void handleUpdate(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if (this.mShouldReverseLayout)
    {
      i = getLastChildPosition();
      this.mLazySpanLookup.invalidateAfter(paramInt1);
      switch (paramInt3)
      {
      case 2: 
      default: 
        label52:
        if (paramInt1 + paramInt2 > i) {
          break;
        }
      }
    }
    label148:
    for (;;)
    {
      return;
      i = getFirstChildPosition();
      break;
      this.mLazySpanLookup.offsetForAddition(paramInt1, paramInt2);
      break label52;
      this.mLazySpanLookup.offsetForRemoval(paramInt1, paramInt2);
      break label52;
      this.mLazySpanLookup.offsetForRemoval(paramInt1, 1);
      this.mLazySpanLookup.offsetForAddition(paramInt2, 1);
      break label52;
      if (this.mShouldReverseLayout) {}
      for (int j = getFirstChildPosition();; j = getLastChildPosition())
      {
        if (paramInt1 > j) {
          break label148;
        }
        requestLayout();
        break;
      }
    }
  }
  
  private void layoutDecoratedWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    layoutDecorated(paramView, paramInt1 + localLayoutParams.leftMargin, paramInt2 + localLayoutParams.topMargin, paramInt3 - localLayoutParams.rightMargin, paramInt4 - localLayoutParams.bottomMargin);
  }
  
  private void measureChildWithDecorationsAndMargin(View paramView, int paramInt1, int paramInt2)
  {
    Rect localRect = this.mRecyclerView.getItemDecorInsetsForChild(paramView);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    paramView.measure(updateSpecWithExtra(paramInt1, localLayoutParams.leftMargin + localRect.left, localLayoutParams.rightMargin + localRect.right), updateSpecWithExtra(paramInt2, localLayoutParams.topMargin + localRect.top, localLayoutParams.bottomMargin + localRect.bottom));
  }
  
  private void measureChildWithDecorationsAndMargin(View paramView, StaggeredGridLayoutManager.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams.mFullSpan) {
      if (this.mOrientation == 1) {
        measureChildWithDecorationsAndMargin(paramView, this.mFullSizeSpec, this.mHeightSpec);
      }
    }
    for (;;)
    {
      return;
      measureChildWithDecorationsAndMargin(paramView, this.mWidthSpec, this.mFullSizeSpec);
      continue;
      measureChildWithDecorationsAndMargin(paramView, this.mWidthSpec, this.mHeightSpec);
    }
  }
  
  private boolean preferLastSpan(int paramInt)
  {
    boolean bool1 = true;
    boolean bool4;
    if (this.mOrientation == 0) {
      if (paramInt == -1)
      {
        bool4 = bool1;
        if (bool4 == this.mShouldReverseLayout) {
          break label35;
        }
      }
    }
    label35:
    label48:
    label78:
    label82:
    for (;;)
    {
      return bool1;
      bool4 = false;
      break;
      bool1 = false;
      continue;
      boolean bool2;
      if (paramInt == -1)
      {
        bool2 = bool1;
        if (bool2 != this.mShouldReverseLayout) {
          break label78;
        }
      }
      for (boolean bool3 = bool1;; bool3 = false)
      {
        if (bool3 == isLayoutRTL()) {
          break label82;
        }
        bool1 = false;
        break;
        bool2 = false;
        break label48;
      }
    }
  }
  
  private void prependViewToAllSpans(View paramView)
  {
    for (int i = -1 + this.mSpanCount; i >= 0; i--) {
      this.mSpans[i].prependToSpan(paramView);
    }
  }
  
  private void recycle(RecyclerView.Recycler paramRecycler, LayoutState paramLayoutState, StaggeredGridLayoutManager.Span paramSpan, int paramInt)
  {
    if (paramLayoutState.mLayoutDirection == -1) {
      recycleFromEnd(paramRecycler, Math.max(paramInt, getMaxStart(paramSpan.getStartLine())) + (this.mPrimaryOrientation.getEnd() - this.mPrimaryOrientation.getStartAfterPadding()));
    }
    for (;;)
    {
      return;
      recycleFromStart(paramRecycler, Math.min(paramInt, getMinEnd(paramSpan.getEndLine())) - (this.mPrimaryOrientation.getEnd() - this.mPrimaryOrientation.getStartAfterPadding()));
    }
  }
  
  private void recycleFromEnd(RecyclerView.Recycler paramRecycler, int paramInt)
  {
    for (int i = -1 + getChildCount(); i >= 0; i--)
    {
      View localView = getChildAt(i);
      if (this.mPrimaryOrientation.getDecoratedStart(localView) <= paramInt) {
        break;
      }
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      if (localLayoutParams.mFullSpan) {
        for (int j = 0; j < this.mSpanCount; j++) {
          this.mSpans[j].popEnd();
        }
      }
      localLayoutParams.mSpan.popEnd();
      removeAndRecycleView(localView, paramRecycler);
    }
  }
  
  private void recycleFromStart(RecyclerView.Recycler paramRecycler, int paramInt)
  {
    while (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      if (this.mPrimaryOrientation.getDecoratedEnd(localView) >= paramInt) {
        break;
      }
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      if (localLayoutParams.mFullSpan) {
        for (int i = 0; i < this.mSpanCount; i++) {
          this.mSpans[i].popStart();
        }
      }
      localLayoutParams.mSpan.popStart();
      removeAndRecycleView(localView, paramRecycler);
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
  
  private void updateAllRemainingSpans(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (i < this.mSpanCount)
    {
      if (StaggeredGridLayoutManager.Span.access$300(this.mSpans[i]).isEmpty()) {}
      for (;;)
      {
        i++;
        break;
        updateRemainingSpans(this.mSpans[i], paramInt1, paramInt2);
      }
    }
  }
  
  private boolean updateAnchorFromChildren(RecyclerView.State paramState, StaggeredGridLayoutManager.AnchorInfo paramAnchorInfo)
  {
    if (this.mLastLayoutFromEnd) {}
    for (int i = findLastReferenceChildPosition(paramState.getItemCount());; i = findFirstReferenceChildPosition(paramState.getItemCount()))
    {
      paramAnchorInfo.mPosition = i;
      paramAnchorInfo.mOffset = -2147483648;
      return true;
    }
  }
  
  private void updateLayoutStateToFillEnd(int paramInt, RecyclerView.State paramState)
  {
    int i = 1;
    this.mLayoutState.mAvailable = 0;
    this.mLayoutState.mCurrentPosition = paramInt;
    if (isSmoothScrolling())
    {
      int j = paramState.getTargetScrollPosition();
      int k = this.mShouldReverseLayout;
      if (j > paramInt)
      {
        int m = i;
        if (k != m) {
          break label98;
        }
        this.mLayoutState.mExtra = 0;
      }
    }
    for (;;)
    {
      this.mLayoutState.mLayoutDirection = i;
      LayoutState localLayoutState = this.mLayoutState;
      if (this.mShouldReverseLayout) {
        i = -1;
      }
      localLayoutState.mItemDirection = i;
      return;
      int n = 0;
      break;
      label98:
      this.mLayoutState.mExtra = this.mPrimaryOrientation.getTotalSpace();
      continue;
      this.mLayoutState.mExtra = 0;
    }
  }
  
  private void updateLayoutStateToFillStart(int paramInt, RecyclerView.State paramState)
  {
    int i = 1;
    this.mLayoutState.mAvailable = 0;
    this.mLayoutState.mCurrentPosition = paramInt;
    label61:
    LayoutState localLayoutState;
    if (isSmoothScrolling())
    {
      int j = paramState.getTargetScrollPosition();
      int k = this.mShouldReverseLayout;
      if (j < paramInt)
      {
        int m = i;
        if (k != m) {
          break label96;
        }
        this.mLayoutState.mExtra = 0;
        this.mLayoutState.mLayoutDirection = -1;
        localLayoutState = this.mLayoutState;
        if (!this.mShouldReverseLayout) {
          break label124;
        }
      }
    }
    for (;;)
    {
      localLayoutState.mItemDirection = i;
      return;
      int n = 0;
      break;
      label96:
      this.mLayoutState.mExtra = this.mPrimaryOrientation.getTotalSpace();
      break label61;
      this.mLayoutState.mExtra = 0;
      break label61;
      label124:
      i = -1;
    }
  }
  
  private void updateRemainingSpans(StaggeredGridLayoutManager.Span paramSpan, int paramInt1, int paramInt2)
  {
    int i = paramSpan.getDeletedSize();
    if (paramInt1 == -1) {
      if (i + paramSpan.getStartLine() < paramInt2) {
        this.mRemainingSpans.set(paramSpan.mIndex, false);
      }
    }
    for (;;)
    {
      return;
      if (paramSpan.getEndLine() - i > paramInt2) {
        this.mRemainingSpans.set(paramSpan.mIndex, false);
      }
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
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof StaggeredGridLayoutManager.LayoutParams;
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
  
  public int[] findFirstCompletelyVisibleItemPositions(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      paramArrayOfInt = new int[this.mSpanCount];
    }
    while (paramArrayOfInt.length >= this.mSpanCount) {
      for (int i = 0; i < this.mSpanCount; i++) {
        paramArrayOfInt[i] = this.mSpans[i].findFirstCompletelyVisibleItemPosition();
      }
    }
    throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + paramArrayOfInt.length);
    return paramArrayOfInt;
  }
  
  View findFirstVisibleItemClosestToEnd(boolean paramBoolean)
  {
    ensureOrientationHelper();
    int i = this.mPrimaryOrientation.getStartAfterPadding();
    int j = this.mPrimaryOrientation.getEndAfterPadding();
    int k = -1 + getChildCount();
    View localView;
    if (k >= 0)
    {
      localView = getChildAt(k);
      if ((this.mPrimaryOrientation.getDecoratedStart(localView) < i) || ((paramBoolean) && (this.mPrimaryOrientation.getDecoratedEnd(localView) > j))) {}
    }
    for (;;)
    {
      return localView;
      k--;
      break;
      localView = null;
    }
  }
  
  View findFirstVisibleItemClosestToStart(boolean paramBoolean)
  {
    ensureOrientationHelper();
    int i = this.mPrimaryOrientation.getStartAfterPadding();
    int j = this.mPrimaryOrientation.getEndAfterPadding();
    int k = getChildCount();
    int m = 0;
    View localView;
    if (m < k)
    {
      localView = getChildAt(m);
      if (((paramBoolean) && (this.mPrimaryOrientation.getDecoratedStart(localView) < i)) || (this.mPrimaryOrientation.getDecoratedEnd(localView) > j)) {}
    }
    for (;;)
    {
      return localView;
      m++;
      break;
      localView = null;
    }
  }
  
  int findFirstVisibleItemPositionInt()
  {
    View localView;
    if (this.mShouldReverseLayout)
    {
      localView = findFirstVisibleItemClosestToEnd(true);
      if (localView != null) {
        break label31;
      }
    }
    label31:
    for (int i = -1;; i = getPosition(localView))
    {
      return i;
      localView = findFirstVisibleItemClosestToStart(true);
      break;
    }
  }
  
  public int[] findFirstVisibleItemPositions(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      paramArrayOfInt = new int[this.mSpanCount];
    }
    while (paramArrayOfInt.length >= this.mSpanCount) {
      for (int i = 0; i < this.mSpanCount; i++) {
        paramArrayOfInt[i] = this.mSpans[i].findFirstVisibleItemPosition();
      }
    }
    throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + paramArrayOfInt.length);
    return paramArrayOfInt;
  }
  
  public int[] findLastCompletelyVisibleItemPositions(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      paramArrayOfInt = new int[this.mSpanCount];
    }
    while (paramArrayOfInt.length >= this.mSpanCount) {
      for (int i = 0; i < this.mSpanCount; i++) {
        paramArrayOfInt[i] = this.mSpans[i].findLastCompletelyVisibleItemPosition();
      }
    }
    throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + paramArrayOfInt.length);
    return paramArrayOfInt;
  }
  
  public int[] findLastVisibleItemPositions(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      paramArrayOfInt = new int[this.mSpanCount];
    }
    while (paramArrayOfInt.length >= this.mSpanCount) {
      for (int i = 0; i < this.mSpanCount; i++) {
        paramArrayOfInt[i] = this.mSpans[i].findLastVisibleItemPosition();
      }
    }
    throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + paramArrayOfInt.length);
    return paramArrayOfInt;
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    return new StaggeredGridLayoutManager.LayoutParams(-2, -2);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new StaggeredGridLayoutManager.LayoutParams(paramContext, paramAttributeSet);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {}
    for (StaggeredGridLayoutManager.LayoutParams localLayoutParams = new StaggeredGridLayoutManager.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);; localLayoutParams = new StaggeredGridLayoutManager.LayoutParams(paramLayoutParams)) {
      return localLayoutParams;
    }
  }
  
  public int getColumnCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mOrientation == 1) {}
    for (int i = this.mSpanCount;; i = super.getColumnCountForAccessibility(paramRecycler, paramState)) {
      return i;
    }
  }
  
  public int getGapStrategy()
  {
    return this.mGapStrategy;
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public boolean getReverseLayout()
  {
    return this.mReverseLayout;
  }
  
  public int getRowCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mOrientation == 0) {}
    for (int i = this.mSpanCount;; i = super.getRowCountForAccessibility(paramRecycler, paramState)) {
      return i;
    }
  }
  
  public int getSpanCount()
  {
    return this.mSpanCount;
  }
  
  View hasGapsToFix()
  {
    int i = -1 + getChildCount();
    BitSet localBitSet = new BitSet(this.mSpanCount);
    localBitSet.set(0, this.mSpanCount, true);
    int j;
    int m;
    int k;
    if ((this.mOrientation == 1) && (isLayoutRTL()))
    {
      j = 1;
      if (!this.mShouldReverseLayout) {
        break label142;
      }
      m = i - 1;
      k = -1;
      label63:
      if (m >= k) {
        break label151;
      }
    }
    int i1;
    View localView2;
    StaggeredGridLayoutManager.LayoutParams localLayoutParams1;
    View localView1;
    label133:
    label142:
    label151:
    for (int n = 1;; n = -1)
    {
      i1 = m;
      if (i1 == k) {
        break label382;
      }
      localView2 = getChildAt(i1);
      localLayoutParams1 = (StaggeredGridLayoutManager.LayoutParams)localView2.getLayoutParams();
      if (!localBitSet.get(localLayoutParams1.mSpan.mIndex)) {
        break label170;
      }
      if (!checkSpanForGap(localLayoutParams1.mSpan)) {
        break label158;
      }
      localView1 = localView2;
      return localView1;
      j = -1;
      break;
      k = i;
      m = 0;
      break label63;
    }
    label158:
    localBitSet.clear(localLayoutParams1.mSpan.mIndex);
    label170:
    if (localLayoutParams1.mFullSpan) {}
    label262:
    label392:
    for (;;)
    {
      label178:
      i1 += n;
      break;
      if (i1 + n != k)
      {
        View localView3 = getChildAt(i1 + n);
        int i4;
        if (this.mShouldReverseLayout)
        {
          int i7 = this.mPrimaryOrientation.getDecoratedEnd(localView2);
          int i8 = this.mPrimaryOrientation.getDecoratedEnd(localView3);
          if (i7 < i8)
          {
            localView1 = localView2;
            break label133;
          }
          if (i7 != i8) {
            break label388;
          }
          i4 = 1;
        }
        for (;;)
        {
          if (i4 == 0) {
            break label392;
          }
          StaggeredGridLayoutManager.LayoutParams localLayoutParams2 = (StaggeredGridLayoutManager.LayoutParams)localView3.getLayoutParams();
          int i5;
          if (localLayoutParams1.mSpan.mIndex - localLayoutParams2.mSpan.mIndex < 0)
          {
            i5 = 1;
            label300:
            if (j >= 0) {
              break label376;
            }
          }
          label376:
          for (int i6 = 1;; i6 = 0)
          {
            if (i5 == i6) {
              break label380;
            }
            localView1 = localView2;
            break;
            int i2 = this.mPrimaryOrientation.getDecoratedStart(localView2);
            int i3 = this.mPrimaryOrientation.getDecoratedStart(localView3);
            if (i2 > i3)
            {
              localView1 = localView2;
              break;
            }
            if (i2 != i3) {
              break label388;
            }
            i4 = 1;
            break label262;
            i5 = 0;
            break label300;
          }
          label380:
          break label178;
          label382:
          localView1 = null;
          break;
          i4 = 0;
        }
      }
    }
  }
  
  public void invalidateSpanAssignments()
  {
    this.mLazySpanLookup.clear();
    requestLayout();
  }
  
  boolean isLayoutRTL()
  {
    int i = 1;
    if (getLayoutDirection() == i) {}
    for (;;)
    {
      return i;
      int j = 0;
    }
  }
  
  public void offsetChildrenHorizontal(int paramInt)
  {
    super.offsetChildrenHorizontal(paramInt);
    for (int i = 0; i < this.mSpanCount; i++) {
      this.mSpans[i].onOffset(paramInt);
    }
  }
  
  public void offsetChildrenVertical(int paramInt)
  {
    super.offsetChildrenVertical(paramInt);
    for (int i = 0; i < this.mSpanCount; i++) {
      this.mSpans[i].onOffset(paramInt);
    }
  }
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler)
  {
    for (int i = 0; i < this.mSpanCount; i++) {
      this.mSpans[i].clear();
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    AccessibilityRecordCompat localAccessibilityRecordCompat;
    View localView1;
    View localView2;
    if (getChildCount() > 0)
    {
      localAccessibilityRecordCompat = AccessibilityEventCompat.asRecord(paramAccessibilityEvent);
      localView1 = findFirstVisibleItemClosestToStart(false);
      localView2 = findFirstVisibleItemClosestToEnd(false);
      if ((localView1 != null) && (localView2 != null)) {
        break label40;
      }
    }
    for (;;)
    {
      return;
      label40:
      int i = getPosition(localView1);
      int j = getPosition(localView2);
      if (i < j)
      {
        localAccessibilityRecordCompat.setFromIndex(i);
        localAccessibilityRecordCompat.setToIndex(j);
      }
      else
      {
        localAccessibilityRecordCompat.setFromIndex(j);
        localAccessibilityRecordCompat.setToIndex(i);
      }
    }
  }
  
  public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (!(localLayoutParams instanceof StaggeredGridLayoutManager.LayoutParams))
    {
      super.onInitializeAccessibilityNodeInfoForItem(paramView, paramAccessibilityNodeInfoCompat);
      return;
    }
    StaggeredGridLayoutManager.LayoutParams localLayoutParams1 = (StaggeredGridLayoutManager.LayoutParams)localLayoutParams;
    if (this.mOrientation == 0)
    {
      int k = localLayoutParams1.getSpanIndex();
      if (localLayoutParams1.mFullSpan) {}
      for (int m = this.mSpanCount;; m = 1)
      {
        paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(k, m, -1, -1, localLayoutParams1.mFullSpan, false));
        break;
      }
    }
    int i = localLayoutParams1.getSpanIndex();
    if (localLayoutParams1.mFullSpan) {}
    for (int j = this.mSpanCount;; j = 1)
    {
      paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(-1, -1, i, j, localLayoutParams1.mFullSpan, false));
      break;
    }
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    handleUpdate(paramInt1, paramInt2, 0);
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView)
  {
    this.mLazySpanLookup.clear();
    requestLayout();
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    handleUpdate(paramInt1, paramInt2, 3);
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    handleUpdate(paramInt1, paramInt2, 1);
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    handleUpdate(paramInt1, paramInt2, 2);
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    ensureOrientationHelper();
    StaggeredGridLayoutManager.AnchorInfo localAnchorInfo = this.mAnchorInfo;
    localAnchorInfo.reset();
    if (this.mPendingSavedState != null) {
      applyPendingSavedState(localAnchorInfo);
    }
    for (;;)
    {
      updateAnchorInfoForLayout(paramState, localAnchorInfo);
      if ((this.mPendingSavedState == null) && ((localAnchorInfo.mLayoutFromEnd != this.mLastLayoutFromEnd) || (isLayoutRTL() != this.mLastLayoutRTL)))
      {
        this.mLazySpanLookup.clear();
        localAnchorInfo.mInvalidateOffsets = true;
      }
      if ((getChildCount() <= 0) || ((this.mPendingSavedState != null) && (this.mPendingSavedState.mSpanOffsetsSize >= 1))) {
        break label206;
      }
      if (!localAnchorInfo.mInvalidateOffsets) {
        break;
      }
      for (int j = 0; j < this.mSpanCount; j++)
      {
        this.mSpans[j].clear();
        if (localAnchorInfo.mOffset != -2147483648) {
          this.mSpans[j].setLine(localAnchorInfo.mOffset);
        }
      }
      resolveShouldLayoutReverse();
      localAnchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
    }
    for (int i = 0; i < this.mSpanCount; i++) {
      this.mSpans[i].cacheReferenceLineAndClear(this.mShouldReverseLayout, localAnchorInfo.mOffset);
    }
    label206:
    detachAndScrapAttachedViews(paramRecycler);
    this.mLaidOutInvalidFullSpan = false;
    updateMeasureSpecs();
    if (localAnchorInfo.mLayoutFromEnd)
    {
      updateLayoutStateToFillStart(localAnchorInfo.mPosition, paramState);
      fill(paramRecycler, this.mLayoutState, paramState);
      updateLayoutStateToFillEnd(localAnchorInfo.mPosition, paramState);
      LayoutState localLayoutState2 = this.mLayoutState;
      localLayoutState2.mCurrentPosition += this.mLayoutState.mItemDirection;
      fill(paramRecycler, this.mLayoutState, paramState);
      if (getChildCount() > 0)
      {
        if (!this.mShouldReverseLayout) {
          break label462;
        }
        fixEndGap(paramRecycler, paramState, true);
        fixStartGap(paramRecycler, paramState, false);
      }
    }
    for (;;)
    {
      if (!paramState.isPreLayout())
      {
        if ((getChildCount() > 0) && (this.mPendingScrollPosition != -1) && (this.mLaidOutInvalidFullSpan)) {
          ViewCompat.postOnAnimation(getChildAt(0), this.checkForGapsRunnable);
        }
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = -2147483648;
      }
      this.mLastLayoutFromEnd = localAnchorInfo.mLayoutFromEnd;
      this.mLastLayoutRTL = isLayoutRTL();
      this.mPendingSavedState = null;
      return;
      updateLayoutStateToFillEnd(localAnchorInfo.mPosition, paramState);
      fill(paramRecycler, this.mLayoutState, paramState);
      updateLayoutStateToFillStart(localAnchorInfo.mPosition, paramState);
      LayoutState localLayoutState1 = this.mLayoutState;
      localLayoutState1.mCurrentPosition += this.mLayoutState.mItemDirection;
      fill(paramRecycler, this.mLayoutState, paramState);
      break;
      label462:
      fixStartGap(paramRecycler, paramState, true);
      fixEndGap(paramRecycler, paramState, false);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof StaggeredGridLayoutManager.SavedState))
    {
      this.mPendingSavedState = ((StaggeredGridLayoutManager.SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    if (this.mPendingSavedState != null) {}
    StaggeredGridLayoutManager.SavedState localSavedState;
    for (Object localObject = new StaggeredGridLayoutManager.SavedState(this.mPendingSavedState);; localObject = localSavedState)
    {
      return localObject;
      localSavedState = new StaggeredGridLayoutManager.SavedState();
      localSavedState.mReverseLayout = this.mReverseLayout;
      localSavedState.mAnchorLayoutFromEnd = this.mLastLayoutFromEnd;
      localSavedState.mLastLayoutRTL = this.mLastLayoutRTL;
      int i;
      label124:
      int j;
      label158:
      int k;
      if ((this.mLazySpanLookup != null) && (this.mLazySpanLookup.mData != null))
      {
        localSavedState.mSpanLookup = this.mLazySpanLookup.mData;
        localSavedState.mSpanLookupSize = localSavedState.mSpanLookup.length;
        localSavedState.mFullSpanItems = this.mLazySpanLookup.mFullSpanItems;
        if (getChildCount() <= 0) {
          break label274;
        }
        ensureOrientationHelper();
        if (!this.mLastLayoutFromEnd) {
          break label230;
        }
        i = getLastChildPosition();
        localSavedState.mAnchorPosition = i;
        localSavedState.mVisibleAnchorPosition = findFirstVisibleItemPositionInt();
        localSavedState.mSpanOffsetsSize = this.mSpanCount;
        localSavedState.mSpanOffsets = new int[this.mSpanCount];
        j = 0;
        if (j >= this.mSpanCount) {
          continue;
        }
        if (!this.mLastLayoutFromEnd) {
          break label238;
        }
        k = this.mSpans[j].getEndLine(-2147483648);
        if (k != -2147483648) {
          k -= this.mPrimaryOrientation.getEndAfterPadding();
        }
      }
      for (;;)
      {
        localSavedState.mSpanOffsets[j] = k;
        j++;
        break label158;
        localSavedState.mSpanLookupSize = 0;
        break;
        label230:
        i = getFirstChildPosition();
        break label124;
        label238:
        k = this.mSpans[j].getStartLine(-2147483648);
        if (k != -2147483648) {
          k -= this.mPrimaryOrientation.getStartAfterPadding();
        }
      }
      label274:
      localSavedState.mAnchorPosition = -1;
      localSavedState.mVisibleAnchorPosition = -1;
      localSavedState.mSpanOffsetsSize = 0;
    }
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 0) {
      checkForGaps();
    }
  }
  
  int scrollBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    int i = 1;
    int j = -1;
    ensureOrientationHelper();
    int k;
    int n;
    label104:
    int i1;
    if (paramInt > 0)
    {
      this.mLayoutState.mLayoutDirection = i;
      LayoutState localLayoutState3 = this.mLayoutState;
      if (this.mShouldReverseLayout)
      {
        localLayoutState3.mItemDirection = j;
        k = getLastChildPosition();
        this.mLayoutState.mCurrentPosition = (k + this.mLayoutState.mItemDirection);
        int m = Math.abs(paramInt);
        this.mLayoutState.mAvailable = m;
        LayoutState localLayoutState2 = this.mLayoutState;
        if (!isSmoothScrolling()) {
          break label201;
        }
        n = this.mPrimaryOrientation.getTotalSpace();
        localLayoutState2.mExtra = n;
        i1 = fill(paramRecycler, this.mLayoutState, paramState);
        if (m >= i1) {
          break label207;
        }
      }
    }
    for (;;)
    {
      this.mPrimaryOrientation.offsetChildren(-paramInt);
      this.mLastLayoutFromEnd = this.mShouldReverseLayout;
      return paramInt;
      j = i;
      break;
      this.mLayoutState.mLayoutDirection = j;
      LayoutState localLayoutState1 = this.mLayoutState;
      if (this.mShouldReverseLayout) {}
      for (;;)
      {
        localLayoutState1.mItemDirection = i;
        k = getFirstChildPosition();
        break;
        i = j;
      }
      label201:
      n = 0;
      break label104;
      label207:
      if (paramInt < 0) {
        paramInt = -i1;
      } else {
        paramInt = i1;
      }
    }
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return scrollBy(paramInt, paramRecycler, paramState);
  }
  
  public void scrollToPosition(int paramInt)
  {
    if ((this.mPendingSavedState != null) && (this.mPendingSavedState.mAnchorPosition != paramInt)) {
      this.mPendingSavedState.invalidateAnchorPositionInfo();
    }
    this.mPendingScrollPosition = paramInt;
    this.mPendingScrollPositionOffset = -2147483648;
    requestLayout();
  }
  
  public void scrollToPositionWithOffset(int paramInt1, int paramInt2)
  {
    if (this.mPendingSavedState != null) {
      this.mPendingSavedState.invalidateAnchorPositionInfo();
    }
    this.mPendingScrollPosition = paramInt1;
    this.mPendingScrollPositionOffset = paramInt2;
    requestLayout();
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return scrollBy(paramInt, paramRecycler, paramState);
  }
  
  public void setGapStrategy(int paramInt)
  {
    assertNotInLayoutOrScroll(null);
    if (paramInt == this.mGapStrategy) {}
    for (;;)
    {
      return;
      if ((paramInt != 0) && (paramInt != 2)) {
        throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
      }
      this.mGapStrategy = paramInt;
      requestLayout();
    }
  }
  
  public void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation.");
    }
    assertNotInLayoutOrScroll(null);
    if (paramInt == this.mOrientation) {}
    for (;;)
    {
      return;
      this.mOrientation = paramInt;
      if ((this.mPrimaryOrientation != null) && (this.mSecondaryOrientation != null))
      {
        OrientationHelper localOrientationHelper = this.mPrimaryOrientation;
        this.mPrimaryOrientation = this.mSecondaryOrientation;
        this.mSecondaryOrientation = localOrientationHelper;
      }
      requestLayout();
    }
  }
  
  public void setReverseLayout(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    if ((this.mPendingSavedState != null) && (this.mPendingSavedState.mReverseLayout != paramBoolean)) {
      this.mPendingSavedState.mReverseLayout = paramBoolean;
    }
    this.mReverseLayout = paramBoolean;
    requestLayout();
  }
  
  public void setSpanCount(int paramInt)
  {
    assertNotInLayoutOrScroll(null);
    if (paramInt != this.mSpanCount)
    {
      invalidateSpanAssignments();
      this.mSpanCount = paramInt;
      this.mRemainingSpans = new BitSet(this.mSpanCount);
      this.mSpans = new StaggeredGridLayoutManager.Span[this.mSpanCount];
      for (int i = 0; i < this.mSpanCount; i++) {
        this.mSpans[i] = new StaggeredGridLayoutManager.Span(this, i, null);
      }
      requestLayout();
    }
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt)
  {
    StaggeredGridLayoutManager.2 local2 = new StaggeredGridLayoutManager.2(this, paramRecyclerView.getContext());
    local2.setTargetPosition(paramInt);
    startSmoothScroll(local2);
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    if (this.mPendingSavedState == null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  boolean updateAnchorFromPendingData(RecyclerView.State paramState, StaggeredGridLayoutManager.AnchorInfo paramAnchorInfo)
  {
    boolean bool = false;
    int i = 1;
    if ((paramState.isPreLayout()) || (this.mPendingScrollPosition == -1)) {
      i = 0;
    }
    for (;;)
    {
      return i;
      if ((this.mPendingScrollPosition < 0) || (this.mPendingScrollPosition >= paramState.getItemCount()))
      {
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = -2147483648;
        i = 0;
      }
      else if ((this.mPendingSavedState == null) || (this.mPendingSavedState.mAnchorPosition == -1) || (this.mPendingSavedState.mSpanOffsetsSize < i))
      {
        View localView = findViewByPosition(this.mPendingScrollPosition);
        if (localView != null)
        {
          if (this.mShouldReverseLayout) {}
          for (int j = getLastChildPosition();; j = getFirstChildPosition())
          {
            paramAnchorInfo.mPosition = j;
            if (this.mPendingScrollPositionOffset == -2147483648) {
              break label211;
            }
            if (!paramAnchorInfo.mLayoutFromEnd) {
              break label182;
            }
            paramAnchorInfo.mOffset = (this.mPrimaryOrientation.getEndAfterPadding() - this.mPendingScrollPositionOffset - this.mPrimaryOrientation.getDecoratedEnd(localView));
            break;
          }
          label182:
          paramAnchorInfo.mOffset = (this.mPrimaryOrientation.getStartAfterPadding() + this.mPendingScrollPositionOffset - this.mPrimaryOrientation.getDecoratedStart(localView));
          continue;
          label211:
          if (this.mPrimaryOrientation.getDecoratedMeasurement(localView) > this.mPrimaryOrientation.getTotalSpace())
          {
            if (paramAnchorInfo.mLayoutFromEnd) {}
            for (int n = this.mPrimaryOrientation.getEndAfterPadding();; n = this.mPrimaryOrientation.getStartAfterPadding())
            {
              paramAnchorInfo.mOffset = n;
              break;
            }
          }
          int k = this.mPrimaryOrientation.getDecoratedStart(localView) - this.mPrimaryOrientation.getStartAfterPadding();
          if (k < 0)
          {
            paramAnchorInfo.mOffset = (-k);
          }
          else
          {
            int m = this.mPrimaryOrientation.getEndAfterPadding() - this.mPrimaryOrientation.getDecoratedEnd(localView);
            if (m < 0) {
              paramAnchorInfo.mOffset = m;
            } else {
              paramAnchorInfo.mOffset = -2147483648;
            }
          }
        }
        else
        {
          paramAnchorInfo.mPosition = this.mPendingScrollPosition;
          if (this.mPendingScrollPositionOffset == -2147483648)
          {
            if (calculateScrollDirectionForPosition(paramAnchorInfo.mPosition) == i) {
              bool = i;
            }
            paramAnchorInfo.mLayoutFromEnd = bool;
            paramAnchorInfo.assignCoordinateFromPadding();
          }
          for (;;)
          {
            paramAnchorInfo.mInvalidateOffsets = i;
            break;
            paramAnchorInfo.assignCoordinateFromPadding(this.mPendingScrollPositionOffset);
          }
        }
      }
      else
      {
        paramAnchorInfo.mOffset = -2147483648;
        paramAnchorInfo.mPosition = this.mPendingScrollPosition;
      }
    }
  }
  
  void updateAnchorInfoForLayout(RecyclerView.State paramState, StaggeredGridLayoutManager.AnchorInfo paramAnchorInfo)
  {
    if (updateAnchorFromPendingData(paramState, paramAnchorInfo)) {}
    for (;;)
    {
      return;
      if (!updateAnchorFromChildren(paramState, paramAnchorInfo))
      {
        paramAnchorInfo.assignCoordinateFromPadding();
        paramAnchorInfo.mPosition = 0;
      }
    }
  }
  
  void updateMeasureSpecs()
  {
    this.mSizePerSpan = (this.mSecondaryOrientation.getTotalSpace() / this.mSpanCount);
    this.mFullSizeSpec = View.MeasureSpec.makeMeasureSpec(this.mSecondaryOrientation.getTotalSpace(), 1073741824);
    if (this.mOrientation == 1)
    {
      this.mWidthSpec = View.MeasureSpec.makeMeasureSpec(this.mSizePerSpan, 1073741824);
      this.mHeightSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
    }
    for (;;)
    {
      return;
      this.mHeightSpec = View.MeasureSpec.makeMeasureSpec(this.mSizePerSpan, 1073741824);
      this.mWidthSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */