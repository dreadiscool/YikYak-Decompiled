package android.support.v7.internal.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.ApplicationInfo;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.widget.ListPopupWindow.ForwardingListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.SpinnerAdapter;

class SpinnerCompat
  extends AbsSpinnerCompat
  implements DialogInterface.OnClickListener
{
  private static final int MAX_ITEMS_MEASURED = 15;
  public static final int MODE_DIALOG = 0;
  public static final int MODE_DROPDOWN = 1;
  private static final int MODE_THEME = -1;
  private static final String TAG = "Spinner";
  private boolean mDisableChildrenWhenDisabled;
  int mDropDownWidth;
  private ListPopupWindow.ForwardingListener mForwardingListener;
  private int mGravity;
  private SpinnerCompat.SpinnerPopup mPopup;
  private SpinnerCompat.DropDownAdapter mTempAdapter;
  private Rect mTempRect = new Rect();
  private final TintManager mTintManager;
  
  SpinnerCompat(Context paramContext)
  {
    this(paramContext, null);
  }
  
  SpinnerCompat(Context paramContext, int paramInt)
  {
    this(paramContext, null, R.attr.spinnerStyle, paramInt);
  }
  
  SpinnerCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.spinnerStyle);
  }
  
  SpinnerCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, -1);
  }
  
  SpinnerCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.Spinner, paramInt1, 0);
    setBackgroundDrawable(localTintTypedArray.getDrawable(R.styleable.Spinner_android_background));
    if (paramInt2 == -1) {
      paramInt2 = localTintTypedArray.getInt(R.styleable.Spinner_spinnerMode, 0);
    }
    switch (paramInt2)
    {
    }
    for (;;)
    {
      this.mGravity = localTintTypedArray.getInt(R.styleable.Spinner_android_gravity, 17);
      this.mPopup.setPromptText(localTintTypedArray.getString(R.styleable.Spinner_prompt));
      this.mDisableChildrenWhenDisabled = localTintTypedArray.getBoolean(R.styleable.Spinner_disableChildrenWhenDisabled, false);
      localTintTypedArray.recycle();
      if (this.mTempAdapter != null)
      {
        this.mPopup.setAdapter(this.mTempAdapter);
        this.mTempAdapter = null;
      }
      this.mTintManager = localTintTypedArray.getTintManager();
      return;
      this.mPopup = new SpinnerCompat.DialogPopup(this, null);
      continue;
      SpinnerCompat.DropdownPopup localDropdownPopup = new SpinnerCompat.DropdownPopup(this, paramContext, paramAttributeSet, paramInt1);
      this.mDropDownWidth = localTintTypedArray.getLayoutDimension(R.styleable.Spinner_android_dropDownWidth, -2);
      localDropdownPopup.setBackgroundDrawable(localTintTypedArray.getDrawable(R.styleable.Spinner_android_popupBackground));
      this.mPopup = localDropdownPopup;
      this.mForwardingListener = new SpinnerCompat.1(this, this, localDropdownPopup);
    }
  }
  
  private View makeView(int paramInt, boolean paramBoolean)
  {
    View localView;
    if (!this.mDataChanged)
    {
      localView = this.mRecycler.get(paramInt);
      if (localView != null) {
        setUpChild(localView, paramBoolean);
      }
    }
    for (;;)
    {
      return localView;
      localView = this.mAdapter.getView(paramInt, null, this);
      setUpChild(localView, paramBoolean);
    }
  }
  
  private void setUpChild(View paramView, boolean paramBoolean)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (localLayoutParams == null) {
      localLayoutParams = generateDefaultLayoutParams();
    }
    if (paramBoolean) {
      addViewInLayout(paramView, 0, localLayoutParams);
    }
    paramView.setSelected(hasFocus());
    if (this.mDisableChildrenWhenDisabled) {
      paramView.setEnabled(isEnabled());
    }
    int i = ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, this.mSpinnerPadding.top + this.mSpinnerPadding.bottom, localLayoutParams.height);
    paramView.measure(ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mSpinnerPadding.left + this.mSpinnerPadding.right, localLayoutParams.width), i);
    int j = this.mSpinnerPadding.top + (getMeasuredHeight() - this.mSpinnerPadding.bottom - this.mSpinnerPadding.top - paramView.getMeasuredHeight()) / 2;
    int k = j + paramView.getMeasuredHeight();
    paramView.layout(0, j, 0 + paramView.getMeasuredWidth(), k);
  }
  
  public int getBaseline()
  {
    int i = -1;
    View localView = null;
    if (getChildCount() > 0) {
      localView = getChildAt(0);
    }
    for (;;)
    {
      if (localView != null)
      {
        int j = localView.getBaseline();
        if (j >= 0) {
          i = j + localView.getTop();
        }
      }
      return i;
      if ((this.mAdapter != null) && (this.mAdapter.getCount() > 0))
      {
        localView = makeView(0, false);
        this.mRecycler.put(0, localView);
      }
    }
  }
  
  public int getDropDownHorizontalOffset()
  {
    return this.mPopup.getHorizontalOffset();
  }
  
  public int getDropDownVerticalOffset()
  {
    return this.mPopup.getVerticalOffset();
  }
  
  public int getDropDownWidth()
  {
    return this.mDropDownWidth;
  }
  
  public Drawable getPopupBackground()
  {
    return this.mPopup.getBackground();
  }
  
  public CharSequence getPrompt()
  {
    return this.mPopup.getHintText();
  }
  
  void layout(int paramInt, boolean paramBoolean)
  {
    int i = this.mSpinnerPadding.left;
    int j = getRight() - getLeft() - this.mSpinnerPadding.left - this.mSpinnerPadding.right;
    if (this.mDataChanged) {
      handleDataChanged();
    }
    if (this.mItemCount == 0)
    {
      resetList();
      return;
    }
    if (this.mNextSelectedPosition >= 0) {
      setSelectedPositionInt(this.mNextSelectedPosition);
    }
    recycleAllViews();
    removeAllViewsInLayout();
    this.mFirstPosition = this.mSelectedPosition;
    View localView;
    int k;
    if (this.mAdapter != null)
    {
      localView = makeView(this.mSelectedPosition, true);
      k = localView.getMeasuredWidth();
      int m = ViewCompat.getLayoutDirection(this);
      switch (0x7 & GravityCompat.getAbsoluteGravity(this.mGravity, m))
      {
      }
    }
    for (;;)
    {
      localView.offsetLeftAndRight(i);
      this.mRecycler.clear();
      invalidate();
      checkSelectionChanged();
      this.mDataChanged = false;
      this.mNeedSync = false;
      setNextSelectedPositionInt(this.mSelectedPosition);
      break;
      i = i + j / 2 - k / 2;
      continue;
      i = i + j - k;
    }
  }
  
  int measureContentWidth(SpinnerAdapter paramSpinnerAdapter, Drawable paramDrawable)
  {
    int i = 0;
    if (paramSpinnerAdapter == null) {
      return i;
    }
    int j = View.MeasureSpec.makeMeasureSpec(0, 0);
    int k = View.MeasureSpec.makeMeasureSpec(0, 0);
    int m = Math.max(0, getSelectedItemPosition());
    int n = Math.min(paramSpinnerAdapter.getCount(), m + 15);
    int i1 = Math.max(0, m - (15 - (n - m)));
    View localView1 = null;
    int i2 = 0;
    int i3 = 0;
    label74:
    int i4;
    if (i1 < n)
    {
      i4 = paramSpinnerAdapter.getItemViewType(i1);
      if (i4 == i3) {
        break label210;
      }
    }
    for (View localView2 = null;; localView2 = localView1)
    {
      localView1 = paramSpinnerAdapter.getView(i1, localView2, this);
      if (localView1.getLayoutParams() == null) {
        localView1.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      }
      localView1.measure(j, k);
      i2 = Math.max(i2, localView1.getMeasuredWidth());
      i1++;
      i3 = i4;
      break label74;
      if (paramDrawable != null)
      {
        paramDrawable.getPadding(this.mTempRect);
        i = i2 + (this.mTempRect.left + this.mTempRect.right);
        break;
      }
      i = i2;
      break;
      label210:
      i4 = i3;
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    setSelection(paramInt);
    paramDialogInterface.dismiss();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.mPopup != null) && (this.mPopup.isShowing())) {
      this.mPopup.dismiss();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mInLayout = true;
    layout(0, false);
    this.mInLayout = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.mPopup != null) && (View.MeasureSpec.getMode(paramInt1) == -2147483648)) {
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), measureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight());
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    SpinnerCompat.SavedState localSavedState = (SpinnerCompat.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (localSavedState.showDropdown)
    {
      ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      if (localViewTreeObserver != null) {
        localViewTreeObserver.addOnGlobalLayoutListener(new SpinnerCompat.2(this));
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    SpinnerCompat.SavedState localSavedState = new SpinnerCompat.SavedState(super.onSaveInstanceState());
    if ((this.mPopup != null) && (this.mPopup.isShowing())) {}
    for (boolean bool = true;; bool = false)
    {
      localSavedState.showDropdown = bool;
      return localSavedState;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.mForwardingListener != null) && (this.mForwardingListener.onTouch(this, paramMotionEvent))) {}
    for (boolean bool = true;; bool = super.onTouchEvent(paramMotionEvent)) {
      return bool;
    }
  }
  
  public boolean performClick()
  {
    boolean bool = super.performClick();
    if (!bool)
    {
      bool = true;
      if (!this.mPopup.isShowing()) {
        this.mPopup.show();
      }
    }
    return bool;
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    super.setAdapter(paramSpinnerAdapter);
    this.mRecycler.clear();
    if ((getContext().getApplicationInfo().targetSdkVersion >= 21) && (paramSpinnerAdapter != null) && (paramSpinnerAdapter.getViewTypeCount() != 1)) {
      throw new IllegalArgumentException("Spinner adapter view type count must be 1");
    }
    if (this.mPopup != null) {
      this.mPopup.setAdapter(new SpinnerCompat.DropDownAdapter(paramSpinnerAdapter));
    }
    for (;;)
    {
      return;
      this.mTempAdapter = new SpinnerCompat.DropDownAdapter(paramSpinnerAdapter);
    }
  }
  
  public void setDropDownHorizontalOffset(int paramInt)
  {
    this.mPopup.setHorizontalOffset(paramInt);
  }
  
  public void setDropDownVerticalOffset(int paramInt)
  {
    this.mPopup.setVerticalOffset(paramInt);
  }
  
  public void setDropDownWidth(int paramInt)
  {
    if (!(this.mPopup instanceof SpinnerCompat.DropdownPopup)) {}
    for (;;)
    {
      return;
      this.mDropDownWidth = paramInt;
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    if (this.mDisableChildrenWhenDisabled)
    {
      int i = getChildCount();
      for (int j = 0; j < i; j++) {
        getChildAt(j).setEnabled(paramBoolean);
      }
    }
  }
  
  public void setGravity(int paramInt)
  {
    if (this.mGravity != paramInt)
    {
      if ((paramInt & 0x7) == 0) {
        paramInt |= 0x800003;
      }
      this.mGravity = paramInt;
      requestLayout();
    }
  }
  
  public void setOnItemClickListener(AdapterViewCompat.OnItemClickListener paramOnItemClickListener)
  {
    throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
  }
  
  void setOnItemClickListenerInt(AdapterViewCompat.OnItemClickListener paramOnItemClickListener)
  {
    super.setOnItemClickListener(paramOnItemClickListener);
  }
  
  public void setPopupBackgroundDrawable(Drawable paramDrawable)
  {
    if (!(this.mPopup instanceof SpinnerCompat.DropdownPopup)) {}
    for (;;)
    {
      return;
      ((SpinnerCompat.DropdownPopup)this.mPopup).setBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setPopupBackgroundResource(int paramInt)
  {
    setPopupBackgroundDrawable(this.mTintManager.getDrawable(paramInt));
  }
  
  public void setPrompt(CharSequence paramCharSequence)
  {
    this.mPopup.setPromptText(paramCharSequence);
  }
  
  public void setPromptId(int paramInt)
  {
    setPrompt(getContext().getText(paramInt));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.SpinnerCompat
 * JD-Core Version:    0.7.0.1
 */