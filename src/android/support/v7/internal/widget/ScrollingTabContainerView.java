package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.appcompat.R.attr;
import android.support.v7.internal.view.ActionBarPolicy;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView.LayoutParams;
import android.widget.HorizontalScrollView;

public class ScrollingTabContainerView
  extends HorizontalScrollView
  implements AdapterViewCompat.OnItemClickListener
{
  private static final int FADE_DURATION = 200;
  private static final String TAG = "ScrollingTabContainerView";
  private static final Interpolator sAlphaInterpolator = new DecelerateInterpolator();
  private boolean mAllowCollapse;
  private int mContentHeight;
  int mMaxTabWidth;
  private int mSelectedTabIndex;
  int mStackedTabMaxWidth;
  private ScrollingTabContainerView.TabClickListener mTabClickListener;
  private LinearLayoutCompat mTabLayout;
  Runnable mTabSelector;
  private SpinnerCompat mTabSpinner;
  protected final ScrollingTabContainerView.VisibilityAnimListener mVisAnimListener = new ScrollingTabContainerView.VisibilityAnimListener(this);
  protected ViewPropertyAnimatorCompat mVisibilityAnim;
  
  public ScrollingTabContainerView(Context paramContext)
  {
    super(paramContext);
    setHorizontalScrollBarEnabled(false);
    ActionBarPolicy localActionBarPolicy = ActionBarPolicy.get(paramContext);
    setContentHeight(localActionBarPolicy.getTabContainerHeight());
    this.mStackedTabMaxWidth = localActionBarPolicy.getStackedTabMaxWidth();
    this.mTabLayout = createTabLayout();
    addView(this.mTabLayout, new ViewGroup.LayoutParams(-2, -1));
  }
  
  private SpinnerCompat createSpinner()
  {
    SpinnerCompat localSpinnerCompat = new SpinnerCompat(getContext(), null, R.attr.actionDropDownStyle);
    localSpinnerCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
    localSpinnerCompat.setOnItemClickListenerInt(this);
    return localSpinnerCompat;
  }
  
  private LinearLayoutCompat createTabLayout()
  {
    LinearLayoutCompat localLinearLayoutCompat = new LinearLayoutCompat(getContext(), null, R.attr.actionBarTabBarStyle);
    localLinearLayoutCompat.setMeasureWithLargestChildEnabled(true);
    localLinearLayoutCompat.setGravity(17);
    localLinearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
    return localLinearLayoutCompat;
  }
  
  private ScrollingTabContainerView.TabView createTabView(ActionBar.Tab paramTab, boolean paramBoolean)
  {
    ScrollingTabContainerView.TabView localTabView = new ScrollingTabContainerView.TabView(this, getContext(), paramTab, paramBoolean);
    if (paramBoolean)
    {
      localTabView.setBackgroundDrawable(null);
      localTabView.setLayoutParams(new AbsListView.LayoutParams(-1, this.mContentHeight));
    }
    for (;;)
    {
      return localTabView;
      localTabView.setFocusable(true);
      if (this.mTabClickListener == null) {
        this.mTabClickListener = new ScrollingTabContainerView.TabClickListener(this, null);
      }
      localTabView.setOnClickListener(this.mTabClickListener);
    }
  }
  
  private boolean isCollapsed()
  {
    if ((this.mTabSpinner != null) && (this.mTabSpinner.getParent() == this)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void performCollapse()
  {
    if (isCollapsed()) {}
    for (;;)
    {
      return;
      if (this.mTabSpinner == null) {
        this.mTabSpinner = createSpinner();
      }
      removeView(this.mTabLayout);
      addView(this.mTabSpinner, new ViewGroup.LayoutParams(-2, -1));
      if (this.mTabSpinner.getAdapter() == null) {
        this.mTabSpinner.setAdapter(new ScrollingTabContainerView.TabAdapter(this, null));
      }
      if (this.mTabSelector != null)
      {
        removeCallbacks(this.mTabSelector);
        this.mTabSelector = null;
      }
      this.mTabSpinner.setSelection(this.mSelectedTabIndex);
    }
  }
  
  private boolean performExpand()
  {
    if (!isCollapsed()) {}
    for (;;)
    {
      return false;
      removeView(this.mTabSpinner);
      addView(this.mTabLayout, new ViewGroup.LayoutParams(-2, -1));
      setTabSelected(this.mTabSpinner.getSelectedItemPosition());
    }
  }
  
  public void addTab(ActionBar.Tab paramTab, int paramInt, boolean paramBoolean)
  {
    ScrollingTabContainerView.TabView localTabView = createTabView(paramTab, false);
    this.mTabLayout.addView(localTabView, paramInt, new LinearLayoutCompat.LayoutParams(0, -1, 1.0F));
    if (this.mTabSpinner != null) {
      ((ScrollingTabContainerView.TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
    }
    if (paramBoolean) {
      localTabView.setSelected(true);
    }
    if (this.mAllowCollapse) {
      requestLayout();
    }
  }
  
  public void addTab(ActionBar.Tab paramTab, boolean paramBoolean)
  {
    ScrollingTabContainerView.TabView localTabView = createTabView(paramTab, false);
    this.mTabLayout.addView(localTabView, new LinearLayoutCompat.LayoutParams(0, -1, 1.0F));
    if (this.mTabSpinner != null) {
      ((ScrollingTabContainerView.TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
    }
    if (paramBoolean) {
      localTabView.setSelected(true);
    }
    if (this.mAllowCollapse) {
      requestLayout();
    }
  }
  
  public void animateToTab(int paramInt)
  {
    View localView = this.mTabLayout.getChildAt(paramInt);
    if (this.mTabSelector != null) {
      removeCallbacks(this.mTabSelector);
    }
    this.mTabSelector = new ScrollingTabContainerView.1(this, localView);
    post(this.mTabSelector);
  }
  
  public void animateToVisibility(int paramInt)
  {
    if (this.mVisibilityAnim != null) {
      this.mVisibilityAnim.cancel();
    }
    if (paramInt == 0)
    {
      if (getVisibility() != 0) {
        ViewCompat.setAlpha(this, 0.0F);
      }
      ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat2 = ViewCompat.animate(this).alpha(1.0F);
      localViewPropertyAnimatorCompat2.setDuration(200L);
      localViewPropertyAnimatorCompat2.setInterpolator(sAlphaInterpolator);
      localViewPropertyAnimatorCompat2.setListener(this.mVisAnimListener.withFinalVisibility(localViewPropertyAnimatorCompat2, paramInt));
      localViewPropertyAnimatorCompat2.start();
    }
    for (;;)
    {
      return;
      ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat1 = ViewCompat.animate(this).alpha(0.0F);
      localViewPropertyAnimatorCompat1.setDuration(200L);
      localViewPropertyAnimatorCompat1.setInterpolator(sAlphaInterpolator);
      localViewPropertyAnimatorCompat1.setListener(this.mVisAnimListener.withFinalVisibility(localViewPropertyAnimatorCompat1, paramInt));
      localViewPropertyAnimatorCompat1.start();
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.mTabSelector != null) {
      post(this.mTabSelector);
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    ActionBarPolicy localActionBarPolicy = ActionBarPolicy.get(getContext());
    setContentHeight(localActionBarPolicy.getTabContainerHeight());
    this.mStackedTabMaxWidth = localActionBarPolicy.getStackedTabMaxWidth();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mTabSelector != null) {
      removeCallbacks(this.mTabSelector);
    }
  }
  
  public void onItemClick(AdapterViewCompat<?> paramAdapterViewCompat, View paramView, int paramInt, long paramLong)
  {
    ((ScrollingTabContainerView.TabView)paramView).getTab().select();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = View.MeasureSpec.getMode(paramInt1);
    boolean bool;
    label76:
    label91:
    int m;
    if (j == 1073741824)
    {
      bool = i;
      setFillViewport(bool);
      int k = this.mTabLayout.getChildCount();
      if ((k <= i) || ((j != 1073741824) && (j != -2147483648))) {
        break label206;
      }
      if (k <= 2) {
        break label193;
      }
      this.mMaxTabWidth = ((int)(0.4F * View.MeasureSpec.getSize(paramInt1)));
      this.mMaxTabWidth = Math.min(this.mMaxTabWidth, this.mStackedTabMaxWidth);
      m = View.MeasureSpec.makeMeasureSpec(this.mContentHeight, 1073741824);
      if ((bool) || (!this.mAllowCollapse)) {
        break label215;
      }
      label115:
      if (i == 0) {
        break label228;
      }
      this.mTabLayout.measure(0, m);
      if (this.mTabLayout.getMeasuredWidth() <= View.MeasureSpec.getSize(paramInt1)) {
        break label220;
      }
      performCollapse();
    }
    for (;;)
    {
      int n = getMeasuredWidth();
      super.onMeasure(paramInt1, m);
      int i1 = getMeasuredWidth();
      if ((bool) && (n != i1)) {
        setTabSelected(this.mSelectedTabIndex);
      }
      return;
      bool = false;
      break;
      label193:
      this.mMaxTabWidth = (View.MeasureSpec.getSize(paramInt1) / 2);
      break label76;
      label206:
      this.mMaxTabWidth = -1;
      break label91;
      label215:
      i = 0;
      break label115;
      label220:
      performExpand();
      continue;
      label228:
      performExpand();
    }
  }
  
  public void removeAllTabs()
  {
    this.mTabLayout.removeAllViews();
    if (this.mTabSpinner != null) {
      ((ScrollingTabContainerView.TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
    }
    if (this.mAllowCollapse) {
      requestLayout();
    }
  }
  
  public void removeTabAt(int paramInt)
  {
    this.mTabLayout.removeViewAt(paramInt);
    if (this.mTabSpinner != null) {
      ((ScrollingTabContainerView.TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
    }
    if (this.mAllowCollapse) {
      requestLayout();
    }
  }
  
  public void setAllowCollapse(boolean paramBoolean)
  {
    this.mAllowCollapse = paramBoolean;
  }
  
  public void setContentHeight(int paramInt)
  {
    this.mContentHeight = paramInt;
    requestLayout();
  }
  
  public void setTabSelected(int paramInt)
  {
    this.mSelectedTabIndex = paramInt;
    int i = this.mTabLayout.getChildCount();
    int j = 0;
    if (j < i)
    {
      View localView = this.mTabLayout.getChildAt(j);
      if (j == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        if (bool) {
          animateToTab(paramInt);
        }
        j++;
        break;
      }
    }
    if ((this.mTabSpinner != null) && (paramInt >= 0)) {
      this.mTabSpinner.setSelection(paramInt);
    }
  }
  
  public void updateTab(int paramInt)
  {
    ((ScrollingTabContainerView.TabView)this.mTabLayout.getChildAt(paramInt)).update();
    if (this.mTabSpinner != null) {
      ((ScrollingTabContainerView.TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
    }
    if (this.mAllowCollapse) {
      requestLayout();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ScrollingTabContainerView
 * JD-Core Version:    0.7.0.1
 */