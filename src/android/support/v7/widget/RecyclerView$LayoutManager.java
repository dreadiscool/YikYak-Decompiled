package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;

public abstract class RecyclerView$LayoutManager
{
  ChildHelper mChildHelper;
  RecyclerView mRecyclerView;
  private boolean mRequestedSimpleAnimations = false;
  RecyclerView.SmoothScroller mSmoothScroller;
  
  private void addViewInt(View paramView, int paramInt, boolean paramBoolean)
  {
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    RecyclerView.LayoutParams localLayoutParams;
    if ((paramBoolean) || (localViewHolder.isRemoved()))
    {
      RecyclerView.access$4300(this.mRecyclerView, paramView);
      localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      if ((!localViewHolder.wasReturnedFromScrap()) && (!localViewHolder.isScrap())) {
        break label120;
      }
      if (!localViewHolder.isScrap()) {
        break label112;
      }
      localViewHolder.unScrap();
      label64:
      this.mChildHelper.attachViewToParent(paramView, paramInt, paramView.getLayoutParams(), false);
    }
    for (;;)
    {
      if (localLayoutParams.mPendingInvalidate)
      {
        localViewHolder.itemView.invalidate();
        localLayoutParams.mPendingInvalidate = false;
      }
      return;
      RecyclerView.access$4400(this.mRecyclerView, paramView);
      break;
      label112:
      localViewHolder.clearReturnedFromScrapFlag();
      break label64;
      label120:
      if (paramView.getParent() == this.mRecyclerView)
      {
        int i = this.mChildHelper.indexOfChild(paramView);
        if (paramInt == -1) {
          paramInt = this.mChildHelper.getChildCount();
        }
        if (i == -1) {
          throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(paramView));
        }
        if (i != paramInt) {
          RecyclerView.access$1100(this.mRecyclerView).moveView(i, paramInt);
        }
      }
      else
      {
        this.mChildHelper.addView(paramView, paramInt, false);
        localLayoutParams.mInsetsDirty = true;
        if ((this.mSmoothScroller != null) && (this.mSmoothScroller.isRunning())) {
          this.mSmoothScroller.onChildAttachedToWindow(paramView);
        }
      }
    }
  }
  
  private void detachViewInternal(int paramInt, View paramView)
  {
    this.mChildHelper.detachViewFromParent(paramInt);
  }
  
  public static int getChildMeasureSpec(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = 1073741824;
    int j = Math.max(0, paramInt1 - paramInt2);
    if (paramBoolean) {
      if (paramInt3 < 0) {}
    }
    for (;;)
    {
      return View.MeasureSpec.makeMeasureSpec(paramInt3, i);
      i = 0;
      paramInt3 = 0;
      continue;
      if (paramInt3 < 0) {
        if (paramInt3 == -1)
        {
          paramInt3 = j;
        }
        else if (paramInt3 == -2)
        {
          i = -2147483648;
          paramInt3 = j;
        }
        else
        {
          i = 0;
          paramInt3 = 0;
        }
      }
    }
  }
  
  private void onSmoothScrollerStopped(RecyclerView.SmoothScroller paramSmoothScroller)
  {
    if (this.mSmoothScroller == paramSmoothScroller) {
      this.mSmoothScroller = null;
    }
  }
  
  private void scrapOrRecycleView(RecyclerView.Recycler paramRecycler, int paramInt, View paramView)
  {
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    if (localViewHolder.shouldIgnore()) {}
    for (;;)
    {
      return;
      if ((localViewHolder.isInvalid()) && (!localViewHolder.isRemoved()) && (!localViewHolder.isChanged()) && (!RecyclerView.access$2200(this.mRecyclerView).hasStableIds()))
      {
        removeViewAt(paramInt);
        paramRecycler.recycleViewHolderInternal(localViewHolder);
      }
      else
      {
        detachViewAt(paramInt);
        paramRecycler.scrapView(paramView);
      }
    }
  }
  
  public void addDisappearingView(View paramView)
  {
    addDisappearingView(paramView, -1);
  }
  
  public void addDisappearingView(View paramView, int paramInt)
  {
    addViewInt(paramView, paramInt, true);
  }
  
  public void addView(View paramView)
  {
    addView(paramView, -1);
  }
  
  public void addView(View paramView, int paramInt)
  {
    addViewInt(paramView, paramInt, false);
  }
  
  public void assertInLayoutOrScroll(String paramString)
  {
    if (this.mRecyclerView != null) {
      this.mRecyclerView.assertInLayoutOrScroll(paramString);
    }
  }
  
  public void assertNotInLayoutOrScroll(String paramString)
  {
    if (this.mRecyclerView != null) {
      this.mRecyclerView.assertNotInLayoutOrScroll(paramString);
    }
  }
  
  public void attachView(View paramView)
  {
    attachView(paramView, -1);
  }
  
  public void attachView(View paramView, int paramInt)
  {
    attachView(paramView, paramInt, (RecyclerView.LayoutParams)paramView.getLayoutParams());
  }
  
  public void attachView(View paramView, int paramInt, RecyclerView.LayoutParams paramLayoutParams)
  {
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    if (localViewHolder.isRemoved()) {
      RecyclerView.access$4300(this.mRecyclerView, paramView);
    }
    for (;;)
    {
      this.mChildHelper.attachViewToParent(paramView, paramInt, paramLayoutParams, localViewHolder.isRemoved());
      return;
      RecyclerView.access$4400(this.mRecyclerView, paramView);
    }
  }
  
  public void calculateItemDecorationsForChild(View paramView, Rect paramRect)
  {
    if (this.mRecyclerView == null) {
      paramRect.set(0, 0, 0, 0);
    }
    for (;;)
    {
      return;
      paramRect.set(this.mRecyclerView.getItemDecorInsetsForChild(paramView));
    }
  }
  
  public boolean canScrollHorizontally()
  {
    return false;
  }
  
  public boolean canScrollVertically()
  {
    return false;
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int computeHorizontalScrollExtent(RecyclerView.State paramState)
  {
    return 0;
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.State paramState)
  {
    return 0;
  }
  
  public int computeHorizontalScrollRange(RecyclerView.State paramState)
  {
    return 0;
  }
  
  public int computeVerticalScrollExtent(RecyclerView.State paramState)
  {
    return 0;
  }
  
  public int computeVerticalScrollOffset(RecyclerView.State paramState)
  {
    return 0;
  }
  
  public int computeVerticalScrollRange(RecyclerView.State paramState)
  {
    return 0;
  }
  
  public void detachAndScrapAttachedViews(RecyclerView.Recycler paramRecycler)
  {
    for (int i = -1 + getChildCount(); i >= 0; i--) {
      scrapOrRecycleView(paramRecycler, i, getChildAt(i));
    }
  }
  
  public void detachAndScrapView(View paramView, RecyclerView.Recycler paramRecycler)
  {
    scrapOrRecycleView(paramRecycler, this.mChildHelper.indexOfChild(paramView), paramView);
  }
  
  public void detachAndScrapViewAt(int paramInt, RecyclerView.Recycler paramRecycler)
  {
    scrapOrRecycleView(paramRecycler, paramInt, getChildAt(paramInt));
  }
  
  public void detachView(View paramView)
  {
    int i = this.mChildHelper.indexOfChild(paramView);
    if (i >= 0) {
      detachViewInternal(i, paramView);
    }
  }
  
  public void detachViewAt(int paramInt)
  {
    detachViewInternal(paramInt, getChildAt(paramInt));
  }
  
  public void endAnimation(View paramView)
  {
    if (this.mRecyclerView.mItemAnimator != null) {
      this.mRecyclerView.mItemAnimator.endAnimation(RecyclerView.getChildViewHolderInt(paramView));
    }
  }
  
  public View findViewByPosition(int paramInt)
  {
    int i = getChildCount();
    int j = 0;
    View localView;
    if (j < i)
    {
      localView = getChildAt(j);
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(localView);
      if (localViewHolder == null) {}
      while ((localViewHolder.getPosition() != paramInt) || (localViewHolder.shouldIgnore()) || ((!this.mRecyclerView.mState.isPreLayout()) && (localViewHolder.isRemoved())))
      {
        j++;
        break;
      }
    }
    for (;;)
    {
      return localView;
      localView = null;
    }
  }
  
  public abstract RecyclerView.LayoutParams generateDefaultLayoutParams();
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new RecyclerView.LayoutParams(paramContext, paramAttributeSet);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    RecyclerView.LayoutParams localLayoutParams;
    if ((paramLayoutParams instanceof RecyclerView.LayoutParams)) {
      localLayoutParams = new RecyclerView.LayoutParams((RecyclerView.LayoutParams)paramLayoutParams);
    }
    for (;;)
    {
      return localLayoutParams;
      if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        localLayoutParams = new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      } else {
        localLayoutParams = new RecyclerView.LayoutParams(paramLayoutParams);
      }
    }
  }
  
  public int getBottomDecorationHeight(View paramView)
  {
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets.bottom;
  }
  
  public View getChildAt(int paramInt)
  {
    if (this.mChildHelper != null) {}
    for (View localView = this.mChildHelper.getChildAt(paramInt);; localView = null) {
      return localView;
    }
  }
  
  public int getChildCount()
  {
    if (this.mChildHelper != null) {}
    for (int i = this.mChildHelper.getChildCount();; i = 0) {
      return i;
    }
  }
  
  public boolean getClipToPadding()
  {
    if ((this.mRecyclerView != null) && (RecyclerView.access$4200(this.mRecyclerView))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int getColumnCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    int i = 1;
    if ((this.mRecyclerView == null) || (RecyclerView.access$2200(this.mRecyclerView) == null)) {}
    for (;;)
    {
      return i;
      if (canScrollHorizontally()) {
        i = RecyclerView.access$2200(this.mRecyclerView).getItemCount();
      }
    }
  }
  
  public int getDecoratedBottom(View paramView)
  {
    return paramView.getBottom() + getBottomDecorationHeight(paramView);
  }
  
  public int getDecoratedLeft(View paramView)
  {
    return paramView.getLeft() - getLeftDecorationWidth(paramView);
  }
  
  public int getDecoratedMeasuredHeight(View paramView)
  {
    Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
    return paramView.getMeasuredHeight() + localRect.top + localRect.bottom;
  }
  
  public int getDecoratedMeasuredWidth(View paramView)
  {
    Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
    return paramView.getMeasuredWidth() + localRect.left + localRect.right;
  }
  
  public int getDecoratedRight(View paramView)
  {
    return paramView.getRight() + getRightDecorationWidth(paramView);
  }
  
  public int getDecoratedTop(View paramView)
  {
    return paramView.getTop() - getTopDecorationHeight(paramView);
  }
  
  public View getFocusedChild()
  {
    Object localObject = null;
    if (this.mRecyclerView == null) {}
    for (;;)
    {
      return localObject;
      View localView = this.mRecyclerView.getFocusedChild();
      if ((localView != null) && (!this.mChildHelper.isHidden(localView))) {
        localObject = localView;
      }
    }
  }
  
  public int getHeight()
  {
    if (this.mRecyclerView != null) {}
    for (int i = this.mRecyclerView.getHeight();; i = 0) {
      return i;
    }
  }
  
  public int getItemCount()
  {
    RecyclerView.Adapter localAdapter;
    if (this.mRecyclerView != null)
    {
      localAdapter = this.mRecyclerView.getAdapter();
      if (localAdapter == null) {
        break label31;
      }
    }
    label31:
    for (int i = localAdapter.getItemCount();; i = 0)
    {
      return i;
      localAdapter = null;
      break;
    }
  }
  
  public int getItemViewType(View paramView)
  {
    return RecyclerView.getChildViewHolderInt(paramView).getItemViewType();
  }
  
  public int getLayoutDirection()
  {
    return ViewCompat.getLayoutDirection(this.mRecyclerView);
  }
  
  public int getLeftDecorationWidth(View paramView)
  {
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets.left;
  }
  
  public int getMinimumHeight()
  {
    return ViewCompat.getMinimumHeight(this.mRecyclerView);
  }
  
  public int getMinimumWidth()
  {
    return ViewCompat.getMinimumWidth(this.mRecyclerView);
  }
  
  public int getPaddingBottom()
  {
    if (this.mRecyclerView != null) {}
    for (int i = this.mRecyclerView.getPaddingBottom();; i = 0) {
      return i;
    }
  }
  
  public int getPaddingEnd()
  {
    if (this.mRecyclerView != null) {}
    for (int i = ViewCompat.getPaddingEnd(this.mRecyclerView);; i = 0) {
      return i;
    }
  }
  
  public int getPaddingLeft()
  {
    if (this.mRecyclerView != null) {}
    for (int i = this.mRecyclerView.getPaddingLeft();; i = 0) {
      return i;
    }
  }
  
  public int getPaddingRight()
  {
    if (this.mRecyclerView != null) {}
    for (int i = this.mRecyclerView.getPaddingRight();; i = 0) {
      return i;
    }
  }
  
  public int getPaddingStart()
  {
    if (this.mRecyclerView != null) {}
    for (int i = ViewCompat.getPaddingStart(this.mRecyclerView);; i = 0) {
      return i;
    }
  }
  
  public int getPaddingTop()
  {
    if (this.mRecyclerView != null) {}
    for (int i = this.mRecyclerView.getPaddingTop();; i = 0) {
      return i;
    }
  }
  
  public int getPosition(View paramView)
  {
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewPosition();
  }
  
  public int getRightDecorationWidth(View paramView)
  {
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets.right;
  }
  
  public int getRowCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    int i = 1;
    if ((this.mRecyclerView == null) || (RecyclerView.access$2200(this.mRecyclerView) == null)) {}
    for (;;)
    {
      return i;
      if (canScrollVertically()) {
        i = RecyclerView.access$2200(this.mRecyclerView).getItemCount();
      }
    }
  }
  
  public int getSelectionModeForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return 0;
  }
  
  public int getTopDecorationHeight(View paramView)
  {
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets.top;
  }
  
  public int getWidth()
  {
    if (this.mRecyclerView != null) {}
    for (int i = this.mRecyclerView.getWidth();; i = 0) {
      return i;
    }
  }
  
  public boolean hasFocus()
  {
    if ((this.mRecyclerView != null) && (this.mRecyclerView.hasFocus())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void ignoreView(View paramView)
  {
    if ((paramView.getParent() != this.mRecyclerView) || (this.mRecyclerView.indexOfChild(paramView) == -1)) {
      throw new IllegalArgumentException("View should be fully attached to be ignored");
    }
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    localViewHolder.addFlags(128);
    this.mRecyclerView.mState.onViewIgnored(localViewHolder);
  }
  
  public boolean isFocused()
  {
    if ((this.mRecyclerView != null) && (this.mRecyclerView.isFocused())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isLayoutHierarchical(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return false;
  }
  
  public boolean isSmoothScrolling()
  {
    if ((this.mSmoothScroller != null) && (this.mSmoothScroller.isRunning())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void layoutDecorated(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
    paramView.layout(paramInt1 + localRect.left, paramInt2 + localRect.top, paramInt3 - localRect.right, paramInt4 - localRect.bottom);
  }
  
  public void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    Rect localRect = this.mRecyclerView.getItemDecorInsetsForChild(paramView);
    int i = paramInt1 + (localRect.left + localRect.right);
    int j = paramInt2 + (localRect.top + localRect.bottom);
    paramView.measure(getChildMeasureSpec(getWidth(), i + (getPaddingLeft() + getPaddingRight()), localLayoutParams.width, canScrollHorizontally()), getChildMeasureSpec(getHeight(), j + (getPaddingTop() + getPaddingBottom()), localLayoutParams.height, canScrollVertically()));
  }
  
  public void measureChildWithMargins(View paramView, int paramInt1, int paramInt2)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    Rect localRect = this.mRecyclerView.getItemDecorInsetsForChild(paramView);
    int i = paramInt1 + (localRect.left + localRect.right);
    int j = paramInt2 + (localRect.top + localRect.bottom);
    paramView.measure(getChildMeasureSpec(getWidth(), i + (getPaddingLeft() + getPaddingRight() + localLayoutParams.leftMargin + localLayoutParams.rightMargin), localLayoutParams.width, canScrollHorizontally()), getChildMeasureSpec(getHeight(), j + (getPaddingTop() + getPaddingBottom() + localLayoutParams.topMargin + localLayoutParams.bottomMargin), localLayoutParams.height, canScrollVertically()));
  }
  
  public void moveView(int paramInt1, int paramInt2)
  {
    View localView = getChildAt(paramInt1);
    if (localView == null) {
      throw new IllegalArgumentException("Cannot move a child from non-existing index:" + paramInt1);
    }
    detachViewAt(paramInt1);
    attachView(localView, paramInt2);
  }
  
  public void offsetChildrenHorizontal(int paramInt)
  {
    if (this.mRecyclerView != null) {
      this.mRecyclerView.offsetChildrenHorizontal(paramInt);
    }
  }
  
  public void offsetChildrenVertical(int paramInt)
  {
    if (this.mRecyclerView != null) {
      this.mRecyclerView.offsetChildrenVertical(paramInt);
    }
  }
  
  public void onAdapterChanged(RecyclerView.Adapter paramAdapter1, RecyclerView.Adapter paramAdapter2) {}
  
  public boolean onAddFocusables(RecyclerView paramRecyclerView, ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void onAttachedToWindow(RecyclerView paramRecyclerView) {}
  
  @Deprecated
  public void onDetachedFromWindow(RecyclerView paramRecyclerView) {}
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler)
  {
    onDetachedFromWindow(paramRecyclerView);
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return null;
  }
  
  public void onInitializeAccessibilityEvent(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, AccessibilityEvent paramAccessibilityEvent)
  {
    int i = 1;
    AccessibilityRecordCompat localAccessibilityRecordCompat = AccessibilityEventCompat.asRecord(paramAccessibilityEvent);
    if ((this.mRecyclerView == null) || (localAccessibilityRecordCompat == null)) {
      return;
    }
    if ((ViewCompat.canScrollVertically(this.mRecyclerView, i)) || (ViewCompat.canScrollVertically(this.mRecyclerView, -1)) || (ViewCompat.canScrollHorizontally(this.mRecyclerView, -1)) || (ViewCompat.canScrollHorizontally(this.mRecyclerView, i))) {}
    for (;;)
    {
      localAccessibilityRecordCompat.setScrollable(i);
      if (RecyclerView.access$2200(this.mRecyclerView) == null) {
        break;
      }
      localAccessibilityRecordCompat.setItemCount(RecyclerView.access$2200(this.mRecyclerView).getItemCount());
      break;
      int j = 0;
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    onInitializeAccessibilityEvent(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, paramAccessibilityEvent);
  }
  
  void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    onInitializeAccessibilityNodeInfo(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, paramAccessibilityNodeInfoCompat);
  }
  
  public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    paramAccessibilityNodeInfoCompat.setClassName(RecyclerView.class.getName());
    if ((ViewCompat.canScrollVertically(this.mRecyclerView, -1)) || (ViewCompat.canScrollHorizontally(this.mRecyclerView, -1)))
    {
      paramAccessibilityNodeInfoCompat.addAction(8192);
      paramAccessibilityNodeInfoCompat.setScrollable(true);
    }
    if ((ViewCompat.canScrollVertically(this.mRecyclerView, 1)) || (ViewCompat.canScrollHorizontally(this.mRecyclerView, 1)))
    {
      paramAccessibilityNodeInfoCompat.addAction(4096);
      paramAccessibilityNodeInfoCompat.setScrollable(true);
    }
    paramAccessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(paramRecycler, paramState), getColumnCountForAccessibility(paramRecycler, paramState), isLayoutHierarchical(paramRecycler, paramState), getSelectionModeForAccessibility(paramRecycler, paramState)));
  }
  
  public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    int i;
    if (canScrollVertically())
    {
      i = getPosition(paramView);
      if (!canScrollHorizontally()) {
        break label51;
      }
    }
    label51:
    for (int j = getPosition(paramView);; j = 0)
    {
      paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i, 1, j, 1, false, false));
      return;
      i = 0;
      break;
    }
  }
  
  void onInitializeAccessibilityNodeInfoForItem(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    if ((localViewHolder != null) && (!localViewHolder.isRemoved())) {
      onInitializeAccessibilityNodeInfoForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, paramView, paramAccessibilityNodeInfoCompat);
    }
  }
  
  public View onInterceptFocusSearch(View paramView, int paramInt)
  {
    return null;
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  
  public void onItemsChanged(RecyclerView paramRecyclerView) {}
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {}
  
  public void onMeasure(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt2);
    switch (i)
    {
    default: 
      k = getMinimumWidth();
    }
    switch (j)
    {
    default: 
      m = getMinimumHeight();
    }
    setMeasuredDimension(k, m);
  }
  
  public boolean onRequestChildFocus(RecyclerView paramRecyclerView, RecyclerView.State paramState, View paramView1, View paramView2)
  {
    return onRequestChildFocus(paramRecyclerView, paramView1, paramView2);
  }
  
  @Deprecated
  public boolean onRequestChildFocus(RecyclerView paramRecyclerView, View paramView1, View paramView2)
  {
    if ((isSmoothScrolling()) || (RecyclerView.access$2300(paramRecyclerView))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  public void onScrollStateChanged(int paramInt) {}
  
  boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    return performAccessibilityAction(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, paramInt, paramBundle);
  }
  
  public boolean performAccessibilityAction(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt, Bundle paramBundle)
  {
    boolean bool = false;
    if (this.mRecyclerView == null) {}
    int k;
    int j;
    for (;;)
    {
      return bool;
      switch (paramInt)
      {
      default: 
        k = 0;
        j = 0;
        if ((j != 0) || (k != 0))
        {
          this.mRecyclerView.scrollBy(k, j);
          bool = true;
        }
        break;
      }
    }
    if (ViewCompat.canScrollVertically(this.mRecyclerView, -1)) {}
    for (int i = -(getHeight() - getPaddingTop() - getPaddingBottom());; i = 0)
    {
      if (ViewCompat.canScrollHorizontally(this.mRecyclerView, -1))
      {
        int n = -(getWidth() - getPaddingLeft() - getPaddingRight());
        j = i;
        k = n;
        break;
        if (!ViewCompat.canScrollVertically(this.mRecyclerView, 1)) {
          break label217;
        }
      }
      label217:
      for (i = getHeight() - getPaddingTop() - getPaddingBottom();; i = 0)
      {
        if (ViewCompat.canScrollHorizontally(this.mRecyclerView, 1))
        {
          int m = getWidth() - getPaddingLeft() - getPaddingRight();
          j = i;
          k = m;
          break;
        }
        j = i;
        k = 0;
        break;
      }
    }
  }
  
  public boolean performAccessibilityActionForItem(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, View paramView, int paramInt, Bundle paramBundle)
  {
    return false;
  }
  
  boolean performAccessibilityActionForItem(View paramView, int paramInt, Bundle paramBundle)
  {
    return performAccessibilityActionForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, paramView, paramInt, paramBundle);
  }
  
  public void removeAllViews()
  {
    for (int i = -1 + getChildCount(); i >= 0; i--)
    {
      getChildAt(i);
      this.mChildHelper.removeViewAt(i);
    }
  }
  
  public void removeAndRecycleAllViews(RecyclerView.Recycler paramRecycler)
  {
    for (int i = -1 + getChildCount(); i >= 0; i--) {
      if (!RecyclerView.getChildViewHolderInt(getChildAt(i)).shouldIgnore()) {
        removeAndRecycleViewAt(i, paramRecycler);
      }
    }
  }
  
  void removeAndRecycleScrapInt(RecyclerView.Recycler paramRecycler)
  {
    int i = paramRecycler.getScrapCount();
    int j = 0;
    if (j < i)
    {
      View localView = paramRecycler.getScrapViewAt(j);
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(localView);
      if (localViewHolder.shouldIgnore()) {}
      for (;;)
      {
        j++;
        break;
        if (localViewHolder.isTmpDetached()) {
          this.mRecyclerView.removeDetachedView(localView, false);
        }
        paramRecycler.quickRecycleScrapView(localView);
      }
    }
    paramRecycler.clearScrap();
    if (i > 0) {
      this.mRecyclerView.invalidate();
    }
  }
  
  public void removeAndRecycleView(View paramView, RecyclerView.Recycler paramRecycler)
  {
    removeView(paramView);
    paramRecycler.recycleView(paramView);
  }
  
  public void removeAndRecycleViewAt(int paramInt, RecyclerView.Recycler paramRecycler)
  {
    View localView = getChildAt(paramInt);
    removeViewAt(paramInt);
    paramRecycler.recycleView(localView);
  }
  
  public void removeDetachedView(View paramView)
  {
    this.mRecyclerView.removeDetachedView(paramView, false);
  }
  
  public void removeView(View paramView)
  {
    this.mChildHelper.removeView(paramView);
  }
  
  public void removeViewAt(int paramInt)
  {
    if (getChildAt(paramInt) != null) {
      this.mChildHelper.removeViewAt(paramInt);
    }
  }
  
  public boolean requestChildRectangleOnScreen(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean)
  {
    int i = getPaddingLeft();
    int j = getPaddingTop();
    int k = getWidth() - getPaddingRight();
    int m = getHeight() - getPaddingBottom();
    int n = paramView.getLeft() + paramRect.left;
    int i1 = paramView.getTop() + paramRect.top;
    int i2 = n + paramRect.width();
    int i3 = i1 + paramRect.height();
    int i4 = Math.min(0, n - i);
    int i5 = Math.min(0, i1 - j);
    int i6 = Math.max(0, i2 - k);
    int i7 = Math.max(0, i3 - m);
    label135:
    int i8;
    if (ViewCompat.getLayoutDirection(paramRecyclerView) == 1) {
      if (i6 != 0)
      {
        i4 = i6;
        if (i5 == 0) {
          break label192;
        }
        i8 = i5;
        label144:
        if ((i4 == 0) && (i8 == 0)) {
          break label210;
        }
        if (!paramBoolean) {
          break label199;
        }
        paramRecyclerView.scrollBy(i4, i8);
      }
    }
    label167:
    label192:
    label199:
    label210:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i6 = i4;
      break;
      if (i4 != 0) {
        break label135;
      }
      i4 = i6;
      break label135;
      i8 = i7;
      break label144;
      paramRecyclerView.smoothScrollBy(i4, i8);
      break label167;
    }
  }
  
  public void requestLayout()
  {
    if (this.mRecyclerView != null) {
      this.mRecyclerView.requestLayout();
    }
  }
  
  public void requestSimpleAnimationsInNextLayout()
  {
    this.mRequestedSimpleAnimations = true;
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return 0;
  }
  
  public void scrollToPosition(int paramInt) {}
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return 0;
  }
  
  public void setMeasuredDimension(int paramInt1, int paramInt2)
  {
    RecyclerView.access$4500(this.mRecyclerView, paramInt1, paramInt2);
  }
  
  void setRecyclerView(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView == null) {
      this.mRecyclerView = null;
    }
    for (this.mChildHelper = null;; this.mChildHelper = paramRecyclerView.mChildHelper)
    {
      return;
      this.mRecyclerView = paramRecyclerView;
    }
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt) {}
  
  public void startSmoothScroll(RecyclerView.SmoothScroller paramSmoothScroller)
  {
    if ((this.mSmoothScroller != null) && (paramSmoothScroller != this.mSmoothScroller) && (this.mSmoothScroller.isRunning())) {
      this.mSmoothScroller.stop();
    }
    this.mSmoothScroller = paramSmoothScroller;
    this.mSmoothScroller.start(this.mRecyclerView, this);
  }
  
  public void stopIgnoringView(View paramView)
  {
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    localViewHolder.stopIgnoring();
    localViewHolder.resetInternal();
    localViewHolder.addFlags(4);
  }
  
  void stopSmoothScroller()
  {
    if (this.mSmoothScroller != null) {
      this.mSmoothScroller.stop();
    }
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return false;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.LayoutManager
 * JD-Core Version:    0.7.0.1
 */