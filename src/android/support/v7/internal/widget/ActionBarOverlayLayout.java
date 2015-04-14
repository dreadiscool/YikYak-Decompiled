package android.support.v7.internal.widget;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.widget.ScrollerCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.support.v7.internal.VersionUtils;
import android.support.v7.internal.app.WindowCallback;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class ActionBarOverlayLayout
  extends ViewGroup
  implements DecorContentParent
{
  static final int[] ATTRS;
  private static final String TAG = "ActionBarOverlayLayout";
  private final int ACTION_BAR_ANIMATE_DELAY = 600;
  private ActionBarContainer mActionBarBottom;
  private int mActionBarHeight;
  private ActionBarContainer mActionBarTop;
  private ActionBarOverlayLayout.ActionBarVisibilityCallback mActionBarVisibilityCallback;
  private final Runnable mAddActionBarHideOffset = new ActionBarOverlayLayout.4(this);
  private boolean mAnimatingForFling;
  private final Rect mBaseContentInsets = new Rect();
  private final Rect mBaseInnerInsets = new Rect();
  private final ViewPropertyAnimatorListener mBottomAnimatorListener = new ActionBarOverlayLayout.2(this);
  private ContentFrameLayout mContent;
  private final Rect mContentInsets = new Rect();
  private ViewPropertyAnimatorCompat mCurrentActionBarBottomAnimator;
  private ViewPropertyAnimatorCompat mCurrentActionBarTopAnimator;
  private DecorToolbar mDecorToolbar;
  private ScrollerCompat mFlingEstimator;
  private boolean mHasNonEmbeddedTabs;
  private boolean mHideOnContentScroll;
  private int mHideOnContentScrollReference;
  private boolean mIgnoreWindowContentOverlay;
  private final Rect mInnerInsets = new Rect();
  private final Rect mLastBaseContentInsets = new Rect();
  private final Rect mLastInnerInsets = new Rect();
  private int mLastSystemUiVisibility;
  private boolean mOverlayMode;
  private final Runnable mRemoveActionBarHideOffset = new ActionBarOverlayLayout.3(this);
  private final ViewPropertyAnimatorListener mTopAnimatorListener = new ActionBarOverlayLayout.1(this);
  private Drawable mWindowContentOverlay;
  private int mWindowVisibility = 0;
  
  static
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = R.attr.actionBarSize;
    arrayOfInt[1] = 16842841;
    ATTRS = arrayOfInt;
  }
  
  public ActionBarOverlayLayout(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public ActionBarOverlayLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void addActionBarHideOffset()
  {
    haltActionBarHideOffsetAnimations();
    this.mAddActionBarHideOffset.run();
  }
  
  private boolean applyInsets(View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    boolean bool1 = false;
    ActionBarOverlayLayout.LayoutParams localLayoutParams = (ActionBarOverlayLayout.LayoutParams)paramView.getLayoutParams();
    if ((paramBoolean1) && (localLayoutParams.leftMargin != paramRect.left))
    {
      localLayoutParams.leftMargin = paramRect.left;
      bool1 = true;
    }
    if ((paramBoolean2) && (localLayoutParams.topMargin != paramRect.top))
    {
      localLayoutParams.topMargin = paramRect.top;
      bool1 = true;
    }
    if ((paramBoolean4) && (localLayoutParams.rightMargin != paramRect.right))
    {
      localLayoutParams.rightMargin = paramRect.right;
      bool1 = true;
    }
    if ((paramBoolean3) && (localLayoutParams.bottomMargin != paramRect.bottom)) {
      localLayoutParams.bottomMargin = paramRect.bottom;
    }
    for (boolean bool2 = true;; bool2 = bool1) {
      return bool2;
    }
  }
  
  private DecorToolbar getDecorToolbar(View paramView)
  {
    if ((paramView instanceof DecorToolbar)) {}
    for (DecorToolbar localDecorToolbar = (DecorToolbar)paramView;; localDecorToolbar = ((Toolbar)paramView).getWrapper())
    {
      return localDecorToolbar;
      if (!(paramView instanceof Toolbar)) {
        break;
      }
    }
    throw new IllegalStateException("Can't make a decor toolbar out of " + paramView.getClass().getSimpleName());
  }
  
  private void haltActionBarHideOffsetAnimations()
  {
    removeCallbacks(this.mRemoveActionBarHideOffset);
    removeCallbacks(this.mAddActionBarHideOffset);
    if (this.mCurrentActionBarTopAnimator != null) {
      this.mCurrentActionBarTopAnimator.cancel();
    }
    if (this.mCurrentActionBarBottomAnimator != null) {
      this.mCurrentActionBarBottomAnimator.cancel();
    }
  }
  
  private void init(Context paramContext)
  {
    int i = 1;
    TypedArray localTypedArray = getContext().getTheme().obtainStyledAttributes(ATTRS);
    this.mActionBarHeight = localTypedArray.getDimensionPixelSize(0, 0);
    this.mWindowContentOverlay = localTypedArray.getDrawable(i);
    if (this.mWindowContentOverlay == null)
    {
      int j = i;
      setWillNotDraw(j);
      localTypedArray.recycle();
      if (paramContext.getApplicationInfo().targetSdkVersion >= 19) {
        break label87;
      }
    }
    for (;;)
    {
      this.mIgnoreWindowContentOverlay = i;
      this.mFlingEstimator = ScrollerCompat.create(paramContext);
      return;
      int k = 0;
      break;
      label87:
      i = 0;
    }
  }
  
  private void postAddActionBarHideOffset()
  {
    haltActionBarHideOffsetAnimations();
    postDelayed(this.mAddActionBarHideOffset, 600L);
  }
  
  private void postRemoveActionBarHideOffset()
  {
    haltActionBarHideOffsetAnimations();
    postDelayed(this.mRemoveActionBarHideOffset, 600L);
  }
  
  private void removeActionBarHideOffset()
  {
    haltActionBarHideOffsetAnimations();
    this.mRemoveActionBarHideOffset.run();
  }
  
  private boolean shouldHideActionBarOnFling(float paramFloat1, float paramFloat2)
  {
    boolean bool = false;
    this.mFlingEstimator.fling(0, 0, 0, (int)paramFloat2, 0, 0, -2147483648, 2147483647);
    if (this.mFlingEstimator.getFinalY() > this.mActionBarTop.getHeight()) {
      bool = true;
    }
    return bool;
  }
  
  public boolean canShowOverflowMenu()
  {
    pullChildren();
    return this.mDecorToolbar.canShowOverflowMenu();
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof ActionBarOverlayLayout.LayoutParams;
  }
  
  public void dismissPopups()
  {
    pullChildren();
    this.mDecorToolbar.dismissPopupMenus();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((this.mWindowContentOverlay != null) && (!this.mIgnoreWindowContentOverlay)) {
      if (this.mActionBarTop.getVisibility() != 0) {
        break label82;
      }
    }
    label82:
    for (int i = (int)(0.5F + (this.mActionBarTop.getBottom() + ViewCompat.getTranslationY(this.mActionBarTop)));; i = 0)
    {
      this.mWindowContentOverlay.setBounds(0, i, getWidth(), i + this.mWindowContentOverlay.getIntrinsicHeight());
      this.mWindowContentOverlay.draw(paramCanvas);
      return;
    }
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    pullChildren();
    ViewCompat.getWindowSystemUiVisibility(this);
    boolean bool = applyInsets(this.mActionBarTop, paramRect, true, true, false, true);
    if (this.mActionBarBottom != null) {
      bool |= applyInsets(this.mActionBarBottom, paramRect, true, false, true, true);
    }
    this.mBaseInnerInsets.set(paramRect);
    ViewUtils.computeFitSystemWindows(this, this.mBaseInnerInsets, this.mBaseContentInsets);
    if (!this.mLastBaseContentInsets.equals(this.mBaseContentInsets))
    {
      this.mLastBaseContentInsets.set(this.mBaseContentInsets);
      bool = true;
    }
    if (bool) {
      requestLayout();
    }
    return true;
  }
  
  protected ActionBarOverlayLayout.LayoutParams generateDefaultLayoutParams()
  {
    return new ActionBarOverlayLayout.LayoutParams(-1, -1);
  }
  
  public ActionBarOverlayLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ActionBarOverlayLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ActionBarOverlayLayout.LayoutParams(paramLayoutParams);
  }
  
  public int getActionBarHideOffset()
  {
    if (this.mActionBarTop != null) {}
    for (int i = -(int)ViewCompat.getTranslationY(this.mActionBarTop);; i = 0) {
      return i;
    }
  }
  
  public CharSequence getTitle()
  {
    pullChildren();
    return this.mDecorToolbar.getTitle();
  }
  
  public boolean hasIcon()
  {
    pullChildren();
    return this.mDecorToolbar.hasIcon();
  }
  
  public boolean hasLogo()
  {
    pullChildren();
    return this.mDecorToolbar.hasLogo();
  }
  
  public boolean hideOverflowMenu()
  {
    pullChildren();
    return this.mDecorToolbar.hideOverflowMenu();
  }
  
  public void initFeature(int paramInt)
  {
    pullChildren();
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      this.mDecorToolbar.initProgress();
      continue;
      this.mDecorToolbar.initIndeterminateProgress();
      continue;
      setOverlayMode(true);
    }
  }
  
  public boolean isHideOnContentScrollEnabled()
  {
    return this.mHideOnContentScroll;
  }
  
  public boolean isInOverlayMode()
  {
    return this.mOverlayMode;
  }
  
  public boolean isOverflowMenuShowPending()
  {
    pullChildren();
    return this.mDecorToolbar.isOverflowMenuShowPending();
  }
  
  public boolean isOverflowMenuShowing()
  {
    pullChildren();
    return this.mDecorToolbar.isOverflowMenuShowing();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    init(getContext());
    ViewCompat.requestApplyInsets(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    haltActionBarHideOffsetAnimations();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getChildCount();
    int j = getPaddingLeft();
    getPaddingRight();
    int k = getPaddingTop();
    int m = paramInt4 - paramInt2 - getPaddingBottom();
    int n = 0;
    if (n < i)
    {
      View localView = getChildAt(n);
      ActionBarOverlayLayout.LayoutParams localLayoutParams;
      int i1;
      int i2;
      int i3;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (ActionBarOverlayLayout.LayoutParams)localView.getLayoutParams();
        i1 = localView.getMeasuredWidth();
        i2 = localView.getMeasuredHeight();
        i3 = j + localLayoutParams.leftMargin;
        if (localView != this.mActionBarBottom) {
          break label143;
        }
      }
      label143:
      for (int i4 = m - i2 - localLayoutParams.bottomMargin;; i4 = k + localLayoutParams.topMargin)
      {
        localView.layout(i3, i4, i1 + i3, i2 + i4);
        n++;
        break;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    pullChildren();
    measureChildWithMargins(this.mActionBarTop, paramInt1, 0, paramInt2, 0);
    ActionBarOverlayLayout.LayoutParams localLayoutParams1 = (ActionBarOverlayLayout.LayoutParams)this.mActionBarTop.getLayoutParams();
    int i = Math.max(0, this.mActionBarTop.getMeasuredWidth() + localLayoutParams1.leftMargin + localLayoutParams1.rightMargin);
    int j = Math.max(0, this.mActionBarTop.getMeasuredHeight() + localLayoutParams1.topMargin + localLayoutParams1.bottomMargin);
    int k = ViewUtils.combineMeasuredStates(0, ViewCompat.getMeasuredState(this.mActionBarTop));
    int i1;
    int n;
    int m;
    if (this.mActionBarBottom != null)
    {
      measureChildWithMargins(this.mActionBarBottom, paramInt1, 0, paramInt2, 0);
      ActionBarOverlayLayout.LayoutParams localLayoutParams3 = (ActionBarOverlayLayout.LayoutParams)this.mActionBarBottom.getLayoutParams();
      int i10 = Math.max(i, this.mActionBarBottom.getMeasuredWidth() + localLayoutParams3.leftMargin + localLayoutParams3.rightMargin);
      int i11 = Math.max(j, this.mActionBarBottom.getMeasuredHeight() + localLayoutParams3.topMargin + localLayoutParams3.bottomMargin);
      i1 = ViewUtils.combineMeasuredStates(k, ViewCompat.getMeasuredState(this.mActionBarBottom));
      n = i10;
      m = i11;
    }
    for (;;)
    {
      int i2;
      int i3;
      if ((0x100 & ViewCompat.getWindowSystemUiVisibility(this)) != 0)
      {
        i2 = 1;
        if (i2 == 0) {
          break label559;
        }
        i3 = this.mActionBarHeight;
        if ((this.mHasNonEmbeddedTabs) && (this.mActionBarTop.getTabContainer() != null)) {
          i3 += this.mActionBarHeight;
        }
      }
      for (;;)
      {
        label242:
        int i4;
        if ((this.mDecorToolbar.isSplit()) && (this.mActionBarBottom != null)) {
          if (i2 != 0) {
            i4 = this.mActionBarHeight;
          }
        }
        for (;;)
        {
          label272:
          this.mContentInsets.set(this.mBaseContentInsets);
          this.mInnerInsets.set(this.mBaseInnerInsets);
          Rect localRect4;
          if ((!this.mOverlayMode) && (i2 == 0))
          {
            Rect localRect3 = this.mContentInsets;
            localRect3.top = (i3 + localRect3.top);
            localRect4 = this.mContentInsets;
          }
          label559:
          Rect localRect2;
          for (localRect4.bottom = (i4 + localRect4.bottom);; localRect2.bottom = (i4 + localRect2.bottom))
          {
            applyInsets(this.mContent, this.mContentInsets, true, true, true, true);
            if (!this.mLastInnerInsets.equals(this.mInnerInsets))
            {
              this.mLastInnerInsets.set(this.mInnerInsets);
              this.mContent.dispatchFitSystemWindows(this.mInnerInsets);
            }
            measureChildWithMargins(this.mContent, paramInt1, 0, paramInt2, 0);
            ActionBarOverlayLayout.LayoutParams localLayoutParams2 = (ActionBarOverlayLayout.LayoutParams)this.mContent.getLayoutParams();
            int i5 = Math.max(n, this.mContent.getMeasuredWidth() + localLayoutParams2.leftMargin + localLayoutParams2.rightMargin);
            int i6 = Math.max(m, this.mContent.getMeasuredHeight() + localLayoutParams2.topMargin + localLayoutParams2.bottomMargin);
            int i7 = ViewUtils.combineMeasuredStates(i1, ViewCompat.getMeasuredState(this.mContent));
            int i8 = i5 + (getPaddingLeft() + getPaddingRight());
            int i9 = Math.max(i6 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
            setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(i8, getSuggestedMinimumWidth()), paramInt1, i7), ViewCompat.resolveSizeAndState(i9, paramInt2, i7 << 16));
            return;
            i2 = 0;
            break;
            if (this.mActionBarTop.getVisibility() == 8) {
              break label642;
            }
            i3 = this.mActionBarTop.getMeasuredHeight();
            break label242;
            i4 = this.mActionBarBottom.getMeasuredHeight();
            break label272;
            Rect localRect1 = this.mInnerInsets;
            localRect1.top = (i3 + localRect1.top);
            localRect2 = this.mInnerInsets;
          }
          i4 = 0;
        }
        label642:
        i3 = 0;
      }
      m = j;
      n = i;
      i1 = k;
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    boolean bool = true;
    if ((!this.mHideOnContentScroll) || (!paramBoolean))
    {
      bool = false;
      return bool;
    }
    if (shouldHideActionBarOnFling(paramFloat1, paramFloat2)) {
      addActionBarHideOffset();
    }
    for (;;)
    {
      this.mAnimatingForFling = bool;
      break;
      removeActionBarHideOffset();
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mHideOnContentScrollReference = (paramInt2 + this.mHideOnContentScrollReference);
    setActionBarHideOffset(this.mHideOnContentScrollReference);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    super.onNestedScrollAccepted(paramView1, paramView2, paramInt);
    this.mHideOnContentScrollReference = getActionBarHideOffset();
    haltActionBarHideOffsetAnimations();
    if (this.mActionBarVisibilityCallback != null) {
      this.mActionBarVisibilityCallback.onContentScrollStarted();
    }
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    if (((paramInt & 0x2) == 0) || (this.mActionBarTop.getVisibility() != 0)) {}
    for (boolean bool = false;; bool = this.mHideOnContentScroll) {
      return bool;
    }
  }
  
  public void onStopNestedScroll(View paramView)
  {
    super.onStopNestedScroll(paramView);
    if ((this.mHideOnContentScroll) && (!this.mAnimatingForFling))
    {
      if (this.mHideOnContentScrollReference > this.mActionBarTop.getHeight()) {
        break label54;
      }
      postRemoveActionBarHideOffset();
    }
    for (;;)
    {
      if (this.mActionBarVisibilityCallback != null) {
        this.mActionBarVisibilityCallback.onContentScrollStopped();
      }
      return;
      label54:
      postAddActionBarHideOffset();
    }
  }
  
  public void onWindowSystemUiVisibilityChanged(int paramInt)
  {
    boolean bool1 = true;
    if (Build.VERSION.SDK_INT >= 16) {
      super.onWindowSystemUiVisibilityChanged(paramInt);
    }
    pullChildren();
    int i = paramInt ^ this.mLastSystemUiVisibility;
    this.mLastSystemUiVisibility = paramInt;
    boolean bool2;
    boolean bool3;
    if ((paramInt & 0x4) == 0)
    {
      bool2 = bool1;
      if ((paramInt & 0x100) == 0) {
        break label122;
      }
      bool3 = bool1;
      label51:
      if (this.mActionBarVisibilityCallback != null)
      {
        ActionBarOverlayLayout.ActionBarVisibilityCallback localActionBarVisibilityCallback = this.mActionBarVisibilityCallback;
        if (bool3) {
          break label128;
        }
        label69:
        localActionBarVisibilityCallback.enableContentAnimations(bool1);
        if ((!bool2) && (bool3)) {
          break label133;
        }
        this.mActionBarVisibilityCallback.showForSystem();
      }
    }
    for (;;)
    {
      if (((i & 0x100) != 0) && (this.mActionBarVisibilityCallback != null)) {
        ViewCompat.requestApplyInsets(this);
      }
      return;
      bool2 = false;
      break;
      label122:
      bool3 = false;
      break label51;
      label128:
      bool1 = false;
      break label69;
      label133:
      this.mActionBarVisibilityCallback.hideForSystem();
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    this.mWindowVisibility = paramInt;
    if (this.mActionBarVisibilityCallback != null) {
      this.mActionBarVisibilityCallback.onWindowVisibilityChanged(paramInt);
    }
  }
  
  void pullChildren()
  {
    if (this.mContent == null)
    {
      this.mContent = ((ContentFrameLayout)findViewById(R.id.action_bar_activity_content));
      this.mActionBarTop = ((ActionBarContainer)findViewById(R.id.action_bar_container));
      this.mDecorToolbar = getDecorToolbar(findViewById(R.id.action_bar));
      this.mActionBarBottom = ((ActionBarContainer)findViewById(R.id.split_action_bar));
    }
  }
  
  public void restoreToolbarHierarchyState(SparseArray<Parcelable> paramSparseArray)
  {
    pullChildren();
    this.mDecorToolbar.restoreHierarchyState(paramSparseArray);
  }
  
  public void saveToolbarHierarchyState(SparseArray<Parcelable> paramSparseArray)
  {
    pullChildren();
    this.mDecorToolbar.saveHierarchyState(paramSparseArray);
  }
  
  public void setActionBarHideOffset(int paramInt)
  {
    haltActionBarHideOffsetAnimations();
    int i = this.mActionBarTop.getHeight();
    int j = Math.max(0, Math.min(paramInt, i));
    ViewCompat.setTranslationY(this.mActionBarTop, -j);
    if ((this.mActionBarBottom != null) && (this.mActionBarBottom.getVisibility() != 8))
    {
      int k = (int)(j / i * this.mActionBarBottom.getHeight());
      ViewCompat.setTranslationY(this.mActionBarBottom, k);
    }
  }
  
  public void setActionBarVisibilityCallback(ActionBarOverlayLayout.ActionBarVisibilityCallback paramActionBarVisibilityCallback)
  {
    this.mActionBarVisibilityCallback = paramActionBarVisibilityCallback;
    if (getWindowToken() != null)
    {
      this.mActionBarVisibilityCallback.onWindowVisibilityChanged(this.mWindowVisibility);
      if (this.mLastSystemUiVisibility != 0)
      {
        onWindowSystemUiVisibilityChanged(this.mLastSystemUiVisibility);
        ViewCompat.requestApplyInsets(this);
      }
    }
  }
  
  public void setHasNonEmbeddedTabs(boolean paramBoolean)
  {
    this.mHasNonEmbeddedTabs = paramBoolean;
  }
  
  public void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.mHideOnContentScroll)
    {
      this.mHideOnContentScroll = paramBoolean;
      if (!paramBoolean)
      {
        if (VersionUtils.isAtLeastL()) {
          stopNestedScroll();
        }
        haltActionBarHideOffsetAnimations();
        setActionBarHideOffset(0);
      }
    }
  }
  
  public void setIcon(int paramInt)
  {
    pullChildren();
    this.mDecorToolbar.setIcon(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    pullChildren();
    this.mDecorToolbar.setIcon(paramDrawable);
  }
  
  public void setLogo(int paramInt)
  {
    pullChildren();
    this.mDecorToolbar.setLogo(paramInt);
  }
  
  public void setMenu(Menu paramMenu, MenuPresenter.Callback paramCallback)
  {
    pullChildren();
    this.mDecorToolbar.setMenu(paramMenu, paramCallback);
  }
  
  public void setMenuPrepared()
  {
    pullChildren();
    this.mDecorToolbar.setMenuPrepared();
  }
  
  public void setOverlayMode(boolean paramBoolean)
  {
    this.mOverlayMode = paramBoolean;
    if ((paramBoolean) && (getContext().getApplicationInfo().targetSdkVersion < 19)) {}
    for (boolean bool = true;; bool = false)
    {
      this.mIgnoreWindowContentOverlay = bool;
      return;
    }
  }
  
  public void setShowingForActionMode(boolean paramBoolean) {}
  
  public void setUiOptions(int paramInt) {}
  
  public void setWindowCallback(WindowCallback paramWindowCallback)
  {
    pullChildren();
    this.mDecorToolbar.setWindowCallback(paramWindowCallback);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    pullChildren();
    this.mDecorToolbar.setWindowTitle(paramCharSequence);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public boolean showOverflowMenu()
  {
    pullChildren();
    return this.mDecorToolbar.showOverflowMenu();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActionBarOverlayLayout
 * JD-Core Version:    0.7.0.1
 */