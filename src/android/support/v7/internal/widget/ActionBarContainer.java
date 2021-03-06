package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.VersionUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class ActionBarContainer
  extends FrameLayout
{
  private View mActionBarView;
  Drawable mBackground;
  private View mContextView;
  private int mHeight;
  boolean mIsSplit;
  boolean mIsStacked;
  private boolean mIsTransitioning;
  Drawable mSplitBackground;
  Drawable mStackedBackground;
  private View mTabContainer;
  
  public ActionBarContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Object localObject;
    boolean bool;
    if (VersionUtils.isAtLeastL())
    {
      localObject = new ActionBarBackgroundDrawableV21(this);
      setBackgroundDrawable((Drawable)localObject);
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionBar);
      this.mBackground = localTypedArray.getDrawable(R.styleable.ActionBar_background);
      this.mStackedBackground = localTypedArray.getDrawable(R.styleable.ActionBar_backgroundStacked);
      this.mHeight = localTypedArray.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
      if (getId() == R.id.split_action_bar)
      {
        this.mIsSplit = true;
        this.mSplitBackground = localTypedArray.getDrawable(R.styleable.ActionBar_backgroundSplit);
      }
      localTypedArray.recycle();
      if (!this.mIsSplit) {
        break label148;
      }
      if (this.mSplitBackground != null) {
        break label142;
      }
      bool = true;
    }
    for (;;)
    {
      setWillNotDraw(bool);
      return;
      localObject = new ActionBarBackgroundDrawable(this);
      break;
      label142:
      bool = false;
      continue;
      label148:
      if ((this.mBackground == null) && (this.mStackedBackground == null)) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  private int getMeasuredHeightWithMargins(View paramView)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    return paramView.getMeasuredHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
  }
  
  private boolean isCollapsed(View paramView)
  {
    if ((paramView == null) || (paramView.getVisibility() == 8) || (paramView.getMeasuredHeight() == 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.mBackground != null) && (this.mBackground.isStateful())) {
      this.mBackground.setState(getDrawableState());
    }
    if ((this.mStackedBackground != null) && (this.mStackedBackground.isStateful())) {
      this.mStackedBackground.setState(getDrawableState());
    }
    if ((this.mSplitBackground != null) && (this.mSplitBackground.isStateful())) {
      this.mSplitBackground.setState(getDrawableState());
    }
  }
  
  public View getTabContainer()
  {
    return this.mTabContainer;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      super.jumpDrawablesToCurrentState();
      if (this.mBackground != null) {
        this.mBackground.jumpToCurrentState();
      }
      if (this.mStackedBackground != null) {
        this.mStackedBackground.jumpToCurrentState();
      }
      if (this.mSplitBackground != null) {
        this.mSplitBackground.jumpToCurrentState();
      }
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.mActionBarView = findViewById(R.id.action_bar);
    this.mContextView = findViewById(R.id.action_context_bar);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.mIsTransitioning) || (super.onInterceptTouchEvent(paramMotionEvent))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool1 = true;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = this.mTabContainer;
    boolean bool2;
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      bool2 = bool1;
      if ((localView != null) && (localView.getVisibility() != 8))
      {
        int i = getMeasuredHeight();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
        localView.layout(paramInt1, i - localView.getMeasuredHeight() - localLayoutParams.bottomMargin, paramInt3, i - localLayoutParams.bottomMargin);
      }
      if (!this.mIsSplit) {
        break label147;
      }
      if (this.mSplitBackground == null) {
        break label333;
      }
      this.mSplitBackground.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }
    for (;;)
    {
      if (bool1) {
        invalidate();
      }
      return;
      bool2 = false;
      break;
      label147:
      if (this.mBackground != null) {
        if (this.mActionBarView.getVisibility() == 0) {
          this.mBackground.setBounds(this.mActionBarView.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
        }
      }
      label199:
      for (boolean bool3 = bool1;; bool3 = false)
      {
        this.mIsStacked = bool2;
        if ((bool2) && (this.mStackedBackground != null))
        {
          this.mStackedBackground.setBounds(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
          break;
          if ((this.mContextView != null) && (this.mContextView.getVisibility() == 0))
          {
            this.mBackground.setBounds(this.mContextView.getLeft(), this.mContextView.getTop(), this.mContextView.getRight(), this.mContextView.getBottom());
            break label199;
          }
          this.mBackground.setBounds(0, 0, 0, 0);
          break label199;
        }
        bool1 = bool3;
        break;
      }
      label333:
      bool1 = false;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.mActionBarView == null) && (View.MeasureSpec.getMode(paramInt2) == -2147483648) && (this.mHeight >= 0)) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.min(this.mHeight, View.MeasureSpec.getSize(paramInt2)), -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
    if (this.mActionBarView == null) {}
    int i;
    do
    {
      return;
      i = View.MeasureSpec.getMode(paramInt2);
    } while ((this.mTabContainer == null) || (this.mTabContainer.getVisibility() == 8) || (i == 1073741824));
    int j;
    if (!isCollapsed(this.mActionBarView))
    {
      j = getMeasuredHeightWithMargins(this.mActionBarView);
      label105:
      if (i != -2147483648) {
        break label174;
      }
    }
    label174:
    for (int k = View.MeasureSpec.getSize(paramInt2);; k = 2147483647)
    {
      setMeasuredDimension(getMeasuredWidth(), Math.min(j + getMeasuredHeightWithMargins(this.mTabContainer), k));
      break;
      if (!isCollapsed(this.mContextView))
      {
        j = getMeasuredHeightWithMargins(this.mContextView);
        break label105;
      }
      j = 0;
      break label105;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setPrimaryBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    if (this.mBackground != null)
    {
      this.mBackground.setCallback(null);
      unscheduleDrawable(this.mBackground);
    }
    this.mBackground = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (this.mActionBarView != null) {
        this.mBackground.setBounds(this.mActionBarView.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
      }
    }
    if (this.mIsSplit) {
      if (this.mSplitBackground != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.mBackground != null) || (this.mStackedBackground != null)) {
        bool = false;
      }
    }
  }
  
  public void setSplitBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    if (this.mSplitBackground != null)
    {
      this.mSplitBackground.setCallback(null);
      unscheduleDrawable(this.mSplitBackground);
    }
    this.mSplitBackground = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if ((this.mIsSplit) && (this.mSplitBackground != null)) {
        this.mSplitBackground.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
      }
    }
    if (this.mIsSplit) {
      if (this.mSplitBackground != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.mBackground != null) || (this.mStackedBackground != null)) {
        bool = false;
      }
    }
  }
  
  public void setStackedBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    if (this.mStackedBackground != null)
    {
      this.mStackedBackground.setCallback(null);
      unscheduleDrawable(this.mStackedBackground);
    }
    this.mStackedBackground = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if ((this.mIsStacked) && (this.mStackedBackground != null)) {
        this.mStackedBackground.setBounds(this.mTabContainer.getLeft(), this.mTabContainer.getTop(), this.mTabContainer.getRight(), this.mTabContainer.getBottom());
      }
    }
    if (this.mIsSplit) {
      if (this.mSplitBackground != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.mBackground != null) || (this.mStackedBackground != null)) {
        bool = false;
      }
    }
  }
  
  public void setTabContainer(ScrollingTabContainerView paramScrollingTabContainerView)
  {
    if (this.mTabContainer != null) {
      removeView(this.mTabContainer);
    }
    this.mTabContainer = paramScrollingTabContainerView;
    if (paramScrollingTabContainerView != null)
    {
      addView(paramScrollingTabContainerView);
      ViewGroup.LayoutParams localLayoutParams = paramScrollingTabContainerView.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      paramScrollingTabContainerView.setAllowCollapse(false);
    }
  }
  
  public void setTransitioning(boolean paramBoolean)
  {
    this.mIsTransitioning = paramBoolean;
    if (paramBoolean) {}
    for (int i = 393216;; i = 262144)
    {
      setDescendantFocusability(i);
      return;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (this.mBackground != null) {
        this.mBackground.setVisible(bool, false);
      }
      if (this.mStackedBackground != null) {
        this.mStackedBackground.setVisible(bool, false);
      }
      if (this.mSplitBackground != null) {
        this.mSplitBackground.setVisible(bool, false);
      }
      return;
    }
  }
  
  public android.support.v7.view.ActionMode startActionModeForChild(View paramView, android.support.v7.view.ActionMode.Callback paramCallback)
  {
    return null;
  }
  
  public android.view.ActionMode startActionModeForChild(View paramView, android.view.ActionMode.Callback paramCallback)
  {
    return null;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    if (((paramDrawable == this.mBackground) && (!this.mIsSplit)) || ((paramDrawable == this.mStackedBackground) && (this.mIsStacked)) || ((paramDrawable == this.mSplitBackground) && (this.mIsSplit)) || (super.verifyDrawable(paramDrawable))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActionBarContainer
 * JD-Core Version:    0.7.0.1
 */