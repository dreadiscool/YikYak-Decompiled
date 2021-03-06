package android.support.v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.SpinnerAdapter;

abstract class AbsSpinnerCompat
  extends AdapterViewCompat<SpinnerAdapter>
{
  SpinnerAdapter mAdapter;
  private DataSetObserver mDataSetObserver;
  int mHeightMeasureSpec;
  final AbsSpinnerCompat.RecycleBin mRecycler = new AbsSpinnerCompat.RecycleBin(this);
  int mSelectionBottomPadding = 0;
  int mSelectionLeftPadding = 0;
  int mSelectionRightPadding = 0;
  int mSelectionTopPadding = 0;
  final Rect mSpinnerPadding = new Rect();
  private Rect mTouchFrame;
  int mWidthMeasureSpec;
  
  AbsSpinnerCompat(Context paramContext)
  {
    super(paramContext);
    initAbsSpinner();
  }
  
  AbsSpinnerCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  AbsSpinnerCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initAbsSpinner();
  }
  
  private void initAbsSpinner()
  {
    setFocusable(true);
    setWillNotDraw(false);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.LayoutParams(-1, -2);
  }
  
  public SpinnerAdapter getAdapter()
  {
    return this.mAdapter;
  }
  
  int getChildHeight(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  int getChildWidth(View paramView)
  {
    return paramView.getMeasuredWidth();
  }
  
  public int getCount()
  {
    return this.mItemCount;
  }
  
  public View getSelectedView()
  {
    if ((this.mItemCount > 0) && (this.mSelectedPosition >= 0)) {}
    for (View localView = getChildAt(this.mSelectedPosition - this.mFirstPosition);; localView = null) {
      return localView;
    }
  }
  
  abstract void layout(int paramInt, boolean paramBoolean);
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = getPaddingLeft();
    int k = getPaddingTop();
    int m = getPaddingRight();
    int n = getPaddingBottom();
    Rect localRect1 = this.mSpinnerPadding;
    int i1;
    label70:
    int i2;
    label96:
    int i3;
    label122:
    int i7;
    int i6;
    int i5;
    if (j > this.mSelectionLeftPadding)
    {
      localRect1.left = j;
      Rect localRect2 = this.mSpinnerPadding;
      if (k <= this.mSelectionTopPadding) {
        break label412;
      }
      i1 = k;
      localRect2.top = i1;
      Rect localRect3 = this.mSpinnerPadding;
      if (m <= this.mSelectionRightPadding) {
        break label421;
      }
      i2 = m;
      localRect3.right = i2;
      Rect localRect4 = this.mSpinnerPadding;
      if (n <= this.mSelectionBottomPadding) {
        break label430;
      }
      i3 = n;
      localRect4.bottom = i3;
      if (this.mDataChanged) {
        handleDataChanged();
      }
      int i4 = getSelectedItemPosition();
      if ((i4 < 0) || (this.mAdapter == null) || (i4 >= this.mAdapter.getCount())) {
        break label439;
      }
      View localView = this.mRecycler.get(i4);
      if (localView == null) {
        localView = this.mAdapter.getView(i4, null, this);
      }
      if (localView == null) {
        break label439;
      }
      this.mRecycler.put(i4, localView);
      if (localView.getLayoutParams() == null)
      {
        this.mBlockLayoutRequests = true;
        localView.setLayoutParams(generateDefaultLayoutParams());
        this.mBlockLayoutRequests = false;
      }
      measureChild(localView, paramInt1, paramInt2);
      i7 = getChildHeight(localView) + this.mSpinnerPadding.top + this.mSpinnerPadding.bottom;
      i6 = getChildWidth(localView) + this.mSpinnerPadding.left + this.mSpinnerPadding.right;
      i5 = 0;
    }
    for (;;)
    {
      if (i5 != 0)
      {
        i7 = this.mSpinnerPadding.top + this.mSpinnerPadding.bottom;
        if (i == 0) {
          i6 = this.mSpinnerPadding.left + this.mSpinnerPadding.right;
        }
      }
      int i8 = Math.max(i7, getSuggestedMinimumHeight());
      int i9 = Math.max(i6, getSuggestedMinimumWidth());
      int i10 = ViewCompat.resolveSizeAndState(i8, paramInt2, 0);
      setMeasuredDimension(ViewCompat.resolveSizeAndState(i9, paramInt1, 0), i10);
      this.mHeightMeasureSpec = paramInt2;
      this.mWidthMeasureSpec = paramInt1;
      return;
      j = this.mSelectionLeftPadding;
      break;
      label412:
      i1 = this.mSelectionTopPadding;
      break label70;
      label421:
      i2 = this.mSelectionRightPadding;
      break label96;
      label430:
      i3 = this.mSelectionBottomPadding;
      break label122;
      label439:
      i5 = 1;
      i6 = 0;
      i7 = 0;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AbsSpinnerCompat.SavedState localSavedState = (AbsSpinnerCompat.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (localSavedState.selectedId >= 0L)
    {
      this.mDataChanged = true;
      this.mNeedSync = true;
      this.mSyncRowId = localSavedState.selectedId;
      this.mSyncPosition = localSavedState.position;
      this.mSyncMode = 0;
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    AbsSpinnerCompat.SavedState localSavedState = new AbsSpinnerCompat.SavedState(super.onSaveInstanceState());
    localSavedState.selectedId = getSelectedItemId();
    if (localSavedState.selectedId >= 0L) {}
    for (localSavedState.position = getSelectedItemPosition();; localSavedState.position = -1) {
      return localSavedState;
    }
  }
  
  public int pointToPosition(int paramInt1, int paramInt2)
  {
    Rect localRect = this.mTouchFrame;
    if (localRect == null)
    {
      this.mTouchFrame = new Rect();
      localRect = this.mTouchFrame;
    }
    int i = -1 + getChildCount();
    if (i >= 0)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        localView.getHitRect(localRect);
        if (!localRect.contains(paramInt1, paramInt2)) {}
      }
    }
    for (int j = i + this.mFirstPosition;; j = -1)
    {
      return j;
      i--;
      break;
    }
  }
  
  void recycleAllViews()
  {
    int i = getChildCount();
    AbsSpinnerCompat.RecycleBin localRecycleBin = this.mRecycler;
    int j = this.mFirstPosition;
    for (int k = 0; k < i; k++)
    {
      View localView = getChildAt(k);
      localRecycleBin.put(j + k, localView);
    }
  }
  
  public void requestLayout()
  {
    if (!this.mBlockLayoutRequests) {
      super.requestLayout();
    }
  }
  
  void resetList()
  {
    this.mDataChanged = false;
    this.mNeedSync = false;
    removeAllViewsInLayout();
    this.mOldSelectedPosition = -1;
    this.mOldSelectedRowId = -9223372036854775808L;
    setSelectedPositionInt(-1);
    setNextSelectedPositionInt(-1);
    invalidate();
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    int i = -1;
    if (this.mAdapter != null)
    {
      this.mAdapter.unregisterDataSetObserver(this.mDataSetObserver);
      resetList();
    }
    this.mAdapter = paramSpinnerAdapter;
    this.mOldSelectedPosition = i;
    this.mOldSelectedRowId = -9223372036854775808L;
    if (this.mAdapter != null)
    {
      this.mOldItemCount = this.mItemCount;
      this.mItemCount = this.mAdapter.getCount();
      checkFocus();
      this.mDataSetObserver = new AdapterViewCompat.AdapterDataSetObserver(this);
      this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
      if (this.mItemCount > 0) {
        i = 0;
      }
      setSelectedPositionInt(i);
      setNextSelectedPositionInt(i);
      if (this.mItemCount == 0) {
        checkSelectionChanged();
      }
    }
    for (;;)
    {
      requestLayout();
      return;
      checkFocus();
      resetList();
      checkSelectionChanged();
    }
  }
  
  public void setSelection(int paramInt)
  {
    setNextSelectedPositionInt(paramInt);
    requestLayout();
    invalidate();
  }
  
  public void setSelection(int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mFirstPosition <= paramInt) && (paramInt <= -1 + (this.mFirstPosition + getChildCount()))) {}
    for (boolean bool = true;; bool = false)
    {
      setSelectionInt(paramInt, bool);
      return;
    }
  }
  
  void setSelectionInt(int paramInt, boolean paramBoolean)
  {
    if (paramInt != this.mOldSelectedPosition)
    {
      this.mBlockLayoutRequests = true;
      int i = paramInt - this.mSelectedPosition;
      setNextSelectedPositionInt(paramInt);
      layout(i, paramBoolean);
      this.mBlockLayoutRequests = false;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.AbsSpinnerCompat
 * JD-Core Version:    0.7.0.1
 */