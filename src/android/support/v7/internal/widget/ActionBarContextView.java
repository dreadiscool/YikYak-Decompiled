package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.view.ViewPropertyAnimatorCompatSet;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ActionMenuView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView
  extends AbsActionBarView
  implements ViewPropertyAnimatorListener
{
  private static final int ANIMATE_IDLE = 0;
  private static final int ANIMATE_IN = 1;
  private static final int ANIMATE_OUT = 2;
  private static final String TAG = "ActionBarContextView";
  private boolean mAnimateInOnLayout;
  private int mAnimationMode;
  private View mClose;
  private int mCloseItemLayout;
  private ViewPropertyAnimatorCompatSet mCurrentAnimation;
  private View mCustomView;
  private Drawable mSplitBackground;
  private CharSequence mSubtitle;
  private int mSubtitleStyleRes;
  private TextView mSubtitleView;
  private CharSequence mTitle;
  private LinearLayout mTitleLayout;
  private boolean mTitleOptional;
  private int mTitleStyleRes;
  private TextView mTitleView;
  
  public ActionBarContextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.actionModeStyle);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.ActionMode, paramInt, 0);
    setBackgroundDrawable(localTintTypedArray.getDrawable(R.styleable.ActionMode_background));
    this.mTitleStyleRes = localTintTypedArray.getResourceId(R.styleable.ActionMode_titleTextStyle, 0);
    this.mSubtitleStyleRes = localTintTypedArray.getResourceId(R.styleable.ActionMode_subtitleTextStyle, 0);
    this.mContentHeight = localTintTypedArray.getLayoutDimension(R.styleable.ActionMode_height, 0);
    this.mSplitBackground = localTintTypedArray.getDrawable(R.styleable.ActionMode_backgroundSplit);
    this.mCloseItemLayout = localTintTypedArray.getResourceId(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
    localTintTypedArray.recycle();
  }
  
  private void finishAnimation()
  {
    ViewPropertyAnimatorCompatSet localViewPropertyAnimatorCompatSet = this.mCurrentAnimation;
    if (localViewPropertyAnimatorCompatSet != null)
    {
      this.mCurrentAnimation = null;
      localViewPropertyAnimatorCompatSet.cancel();
    }
  }
  
  private void initTitle()
  {
    int i = 8;
    int j = 1;
    if (this.mTitleLayout == null)
    {
      LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
      this.mTitleLayout = ((LinearLayout)getChildAt(-1 + getChildCount()));
      this.mTitleView = ((TextView)this.mTitleLayout.findViewById(R.id.action_bar_title));
      this.mSubtitleView = ((TextView)this.mTitleLayout.findViewById(R.id.action_bar_subtitle));
      if (this.mTitleStyleRes != 0) {
        this.mTitleView.setTextAppearance(getContext(), this.mTitleStyleRes);
      }
      if (this.mSubtitleStyleRes != 0) {
        this.mSubtitleView.setTextAppearance(getContext(), this.mSubtitleStyleRes);
      }
    }
    this.mTitleView.setText(this.mTitle);
    this.mSubtitleView.setText(this.mSubtitle);
    int k;
    label167:
    TextView localTextView;
    if (!TextUtils.isEmpty(this.mTitle))
    {
      k = j;
      if (TextUtils.isEmpty(this.mSubtitle)) {
        break label233;
      }
      localTextView = this.mSubtitleView;
      if (j == 0) {
        break label238;
      }
    }
    label233:
    label238:
    for (int m = 0;; m = i)
    {
      localTextView.setVisibility(m);
      LinearLayout localLinearLayout = this.mTitleLayout;
      if ((k != 0) || (j != 0)) {
        i = 0;
      }
      localLinearLayout.setVisibility(i);
      if (this.mTitleLayout.getParent() == null) {
        addView(this.mTitleLayout);
      }
      return;
      k = 0;
      break;
      j = 0;
      break label167;
    }
  }
  
  private ViewPropertyAnimatorCompatSet makeInAnimation()
  {
    ViewCompat.setTranslationX(this.mClose, -this.mClose.getWidth() - ((ViewGroup.MarginLayoutParams)this.mClose.getLayoutParams()).leftMargin);
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat1 = ViewCompat.animate(this.mClose).translationX(0.0F);
    localViewPropertyAnimatorCompat1.setDuration(200L);
    localViewPropertyAnimatorCompat1.setListener(this);
    localViewPropertyAnimatorCompat1.setInterpolator(new DecelerateInterpolator());
    ViewPropertyAnimatorCompatSet localViewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
    localViewPropertyAnimatorCompatSet.play(localViewPropertyAnimatorCompat1);
    if (this.mMenuView != null)
    {
      int i = this.mMenuView.getChildCount();
      if (i > 0) {
        for (int j = i - 1; j >= 0; j--)
        {
          View localView = this.mMenuView.getChildAt(j);
          ViewCompat.setScaleY(localView, 0.0F);
          ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat2 = ViewCompat.animate(localView).scaleY(1.0F);
          localViewPropertyAnimatorCompat2.setDuration(300L);
          localViewPropertyAnimatorCompatSet.play(localViewPropertyAnimatorCompat2);
        }
      }
    }
    return localViewPropertyAnimatorCompatSet;
  }
  
  private ViewPropertyAnimatorCompatSet makeOutAnimation()
  {
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(this.mClose).translationX(-this.mClose.getWidth() - ((ViewGroup.MarginLayoutParams)this.mClose.getLayoutParams()).leftMargin);
    localViewPropertyAnimatorCompat.setDuration(200L);
    localViewPropertyAnimatorCompat.setListener(this);
    localViewPropertyAnimatorCompat.setInterpolator(new DecelerateInterpolator());
    ViewPropertyAnimatorCompatSet localViewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
    localViewPropertyAnimatorCompatSet.play(localViewPropertyAnimatorCompat);
    if ((this.mMenuView != null) && (this.mMenuView.getChildCount() > 0)) {}
    return localViewPropertyAnimatorCompatSet;
  }
  
  public void closeMode()
  {
    if (this.mAnimationMode == 2) {}
    for (;;)
    {
      return;
      if (this.mClose == null)
      {
        killMode();
      }
      else
      {
        finishAnimation();
        this.mAnimationMode = 2;
        this.mCurrentAnimation = makeOutAnimation();
        this.mCurrentAnimation.start();
      }
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.MarginLayoutParams(-1, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  public CharSequence getSubtitle()
  {
    return this.mSubtitle;
  }
  
  public CharSequence getTitle()
  {
    return this.mTitle;
  }
  
  public boolean hideOverflowMenu()
  {
    if (this.mActionMenuPresenter != null) {}
    for (boolean bool = this.mActionMenuPresenter.hideOverflowMenu();; bool = false) {
      return bool;
    }
  }
  
  public void initForMode(ActionMode paramActionMode)
  {
    MenuBuilder localMenuBuilder;
    ViewGroup.LayoutParams localLayoutParams;
    if (this.mClose == null)
    {
      this.mClose = LayoutInflater.from(getContext()).inflate(this.mCloseItemLayout, this, false);
      addView(this.mClose);
      this.mClose.findViewById(R.id.action_mode_close_button).setOnClickListener(new ActionBarContextView.1(this, paramActionMode));
      localMenuBuilder = (MenuBuilder)paramActionMode.getMenu();
      if (this.mActionMenuPresenter != null) {
        this.mActionMenuPresenter.dismissPopupMenus();
      }
      this.mActionMenuPresenter = new ActionMenuPresenter(getContext());
      this.mActionMenuPresenter.setReserveOverflow(true);
      localLayoutParams = new ViewGroup.LayoutParams(-2, -1);
      if (this.mSplitActionBar) {
        break label193;
      }
      localMenuBuilder.addMenuPresenter(this.mActionMenuPresenter, this.mPopupContext);
      this.mMenuView = ((ActionMenuView)this.mActionMenuPresenter.getMenuView(this));
      this.mMenuView.setBackgroundDrawable(null);
      addView(this.mMenuView, localLayoutParams);
    }
    for (;;)
    {
      this.mAnimateInOnLayout = true;
      return;
      if (this.mClose.getParent() != null) {
        break;
      }
      addView(this.mClose);
      break;
      label193:
      this.mActionMenuPresenter.setWidthLimit(getContext().getResources().getDisplayMetrics().widthPixels, true);
      this.mActionMenuPresenter.setItemLimit(2147483647);
      localLayoutParams.width = -1;
      localLayoutParams.height = this.mContentHeight;
      localMenuBuilder.addMenuPresenter(this.mActionMenuPresenter, this.mPopupContext);
      this.mMenuView = ((ActionMenuView)this.mActionMenuPresenter.getMenuView(this));
      this.mMenuView.setBackgroundDrawable(this.mSplitBackground);
      this.mSplitView.addView(this.mMenuView, localLayoutParams);
    }
  }
  
  public boolean isOverflowMenuShowing()
  {
    if (this.mActionMenuPresenter != null) {}
    for (boolean bool = this.mActionMenuPresenter.isOverflowMenuShowing();; bool = false) {
      return bool;
    }
  }
  
  public boolean isTitleOptional()
  {
    return this.mTitleOptional;
  }
  
  public void killMode()
  {
    finishAnimation();
    removeAllViews();
    if (this.mSplitView != null) {
      this.mSplitView.removeView(this.mMenuView);
    }
    this.mCustomView = null;
    this.mMenuView = null;
    this.mAnimateInOnLayout = false;
  }
  
  public void onAnimationCancel(View paramView) {}
  
  public void onAnimationEnd(View paramView)
  {
    if (this.mAnimationMode == 2) {
      killMode();
    }
    this.mAnimationMode = 0;
  }
  
  public void onAnimationStart(View paramView) {}
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mActionMenuPresenter != null)
    {
      this.mActionMenuPresenter.hideOverflowMenu();
      this.mActionMenuPresenter.hideSubMenus();
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      if (paramAccessibilityEvent.getEventType() != 32) {
        break label53;
      }
      paramAccessibilityEvent.setSource(this);
      paramAccessibilityEvent.setClassName(getClass().getName());
      paramAccessibilityEvent.setPackageName(getContext().getPackageName());
      paramAccessibilityEvent.setContentDescription(this.mTitle);
    }
    for (;;)
    {
      return;
      label53:
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool1 = ViewUtils.isLayoutRtl(this);
    int i;
    int j;
    int k;
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    int i1;
    label87:
    int i2;
    label99:
    int n;
    label256:
    ActionMenuView localActionMenuView;
    if (bool1)
    {
      i = paramInt3 - paramInt1 - getPaddingRight();
      j = getPaddingTop();
      k = paramInt4 - paramInt2 - getPaddingTop() - getPaddingBottom();
      if ((this.mClose != null) && (this.mClose.getVisibility() != 8))
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mClose.getLayoutParams();
        if (!bool1) {
          break label302;
        }
        i1 = localMarginLayoutParams.rightMargin;
        if (!bool1) {
          break label312;
        }
        i2 = localMarginLayoutParams.leftMargin;
        int i3 = next(i, i1, bool1);
        i = next(i3 + positionChild(this.mClose, i3, j, k, bool1), i2, bool1);
        if (this.mAnimateInOnLayout)
        {
          this.mAnimationMode = 1;
          this.mCurrentAnimation = makeInAnimation();
          this.mCurrentAnimation.start();
          this.mAnimateInOnLayout = false;
        }
      }
      int m = i;
      if ((this.mTitleLayout != null) && (this.mCustomView == null) && (this.mTitleLayout.getVisibility() != 8)) {
        m += positionChild(this.mTitleLayout, m, j, k, bool1);
      }
      if (this.mCustomView != null) {
        positionChild(this.mCustomView, m, j, k, bool1);
      }
      if (!bool1) {
        break label322;
      }
      n = getPaddingLeft();
      if (this.mMenuView != null)
      {
        localActionMenuView = this.mMenuView;
        if (bool1) {
          break label336;
        }
      }
    }
    label302:
    label312:
    label322:
    label336:
    for (boolean bool2 = true;; bool2 = false)
    {
      positionChild(localActionMenuView, n, j, k, bool2);
      return;
      i = getPaddingLeft();
      break;
      i1 = localMarginLayoutParams.leftMargin;
      break label87;
      i2 = localMarginLayoutParams.rightMargin;
      break label99;
      n = paramInt3 - paramInt1 - getPaddingRight();
      break label256;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 1073741824;
    int j = 0;
    if (View.MeasureSpec.getMode(paramInt1) != i) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)");
    }
    if (View.MeasureSpec.getMode(paramInt2) == 0) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
    }
    int k = View.MeasureSpec.getSize(paramInt1);
    int m;
    int i1;
    int i2;
    int i3;
    int i11;
    label304:
    int i12;
    label330:
    label337:
    int i7;
    label366:
    int i8;
    label396:
    label416:
    int i5;
    label452:
    int i6;
    if (this.mContentHeight > 0)
    {
      m = this.mContentHeight;
      int n = getPaddingTop() + getPaddingBottom();
      i1 = k - getPaddingLeft() - getPaddingRight();
      i2 = m - n;
      i3 = View.MeasureSpec.makeMeasureSpec(i2, -2147483648);
      if (this.mClose != null)
      {
        int i13 = measureChildView(this.mClose, i1, i3, 0);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mClose.getLayoutParams();
        i1 = i13 - (localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin);
      }
      if ((this.mMenuView != null) && (this.mMenuView.getParent() == this)) {
        i1 = measureChildView(this.mMenuView, i1, i3, 0);
      }
      if ((this.mTitleLayout != null) && (this.mCustomView == null))
      {
        if (!this.mTitleOptional) {
          break label512;
        }
        int i9 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mTitleLayout.measure(i9, i3);
        int i10 = this.mTitleLayout.getMeasuredWidth();
        if (i10 > i1) {
          break label499;
        }
        i11 = 1;
        if (i11 != 0) {
          i1 -= i10;
        }
        LinearLayout localLinearLayout = this.mTitleLayout;
        if (i11 == 0) {
          break label505;
        }
        i12 = 0;
        localLinearLayout.setVisibility(i12);
      }
      if (this.mCustomView != null)
      {
        ViewGroup.LayoutParams localLayoutParams = this.mCustomView.getLayoutParams();
        if (localLayoutParams.width == -2) {
          break label530;
        }
        i7 = i;
        if (localLayoutParams.width >= 0) {
          i1 = Math.min(localLayoutParams.width, i1);
        }
        if (localLayoutParams.height == -2) {
          break label538;
        }
        if (localLayoutParams.height < 0) {
          break label545;
        }
        i8 = Math.min(localLayoutParams.height, i2);
        this.mCustomView.measure(View.MeasureSpec.makeMeasureSpec(i1, i7), View.MeasureSpec.makeMeasureSpec(i8, i));
      }
      if (this.mContentHeight > 0) {
        break label561;
      }
      int i4 = getChildCount();
      i5 = 0;
      if (j >= i4) {
        break label552;
      }
      i6 = n + getChildAt(j).getMeasuredHeight();
      if (i6 <= i5) {
        break label572;
      }
    }
    for (;;)
    {
      j++;
      i5 = i6;
      break label452;
      m = View.MeasureSpec.getSize(paramInt2);
      break;
      label499:
      i11 = 0;
      break label304;
      label505:
      i12 = 8;
      break label330;
      label512:
      i1 = measureChildView(this.mTitleLayout, i1, i3, 0);
      break label337;
      label530:
      i7 = -2147483648;
      break label366;
      label538:
      i = -2147483648;
      break label396;
      label545:
      i8 = i2;
      break label416;
      label552:
      setMeasuredDimension(k, i5);
      for (;;)
      {
        return;
        label561:
        setMeasuredDimension(k, m);
      }
      label572:
      i6 = i5;
    }
  }
  
  public void setContentHeight(int paramInt)
  {
    this.mContentHeight = paramInt;
  }
  
  public void setCustomView(View paramView)
  {
    if (this.mCustomView != null) {
      removeView(this.mCustomView);
    }
    this.mCustomView = paramView;
    if (this.mTitleLayout != null)
    {
      removeView(this.mTitleLayout);
      this.mTitleLayout = null;
    }
    if (paramView != null) {
      addView(paramView);
    }
    requestLayout();
  }
  
  public void setSplitToolbar(boolean paramBoolean)
  {
    ViewGroup.LayoutParams localLayoutParams;
    if (this.mSplitActionBar != paramBoolean) {
      if (this.mActionMenuPresenter != null)
      {
        localLayoutParams = new ViewGroup.LayoutParams(-2, -1);
        if (paramBoolean) {
          break label95;
        }
        this.mMenuView = ((ActionMenuView)this.mActionMenuPresenter.getMenuView(this));
        this.mMenuView.setBackgroundDrawable(null);
        ViewGroup localViewGroup2 = (ViewGroup)this.mMenuView.getParent();
        if (localViewGroup2 != null) {
          localViewGroup2.removeView(this.mMenuView);
        }
        addView(this.mMenuView, localLayoutParams);
      }
    }
    for (;;)
    {
      super.setSplitToolbar(paramBoolean);
      return;
      label95:
      this.mActionMenuPresenter.setWidthLimit(getContext().getResources().getDisplayMetrics().widthPixels, true);
      this.mActionMenuPresenter.setItemLimit(2147483647);
      localLayoutParams.width = -1;
      localLayoutParams.height = this.mContentHeight;
      this.mMenuView = ((ActionMenuView)this.mActionMenuPresenter.getMenuView(this));
      this.mMenuView.setBackgroundDrawable(this.mSplitBackground);
      ViewGroup localViewGroup1 = (ViewGroup)this.mMenuView.getParent();
      if (localViewGroup1 != null) {
        localViewGroup1.removeView(this.mMenuView);
      }
      this.mSplitView.addView(this.mMenuView, localLayoutParams);
    }
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.mSubtitle = paramCharSequence;
    initTitle();
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.mTitle = paramCharSequence;
    initTitle();
  }
  
  public void setTitleOptional(boolean paramBoolean)
  {
    if (paramBoolean != this.mTitleOptional) {
      requestLayout();
    }
    this.mTitleOptional = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public boolean showOverflowMenu()
  {
    if (this.mActionMenuPresenter != null) {}
    for (boolean bool = this.mActionMenuPresenter.showOverflowMenu();; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActionBarContextView
 * JD-Core Version:    0.7.0.1
 */