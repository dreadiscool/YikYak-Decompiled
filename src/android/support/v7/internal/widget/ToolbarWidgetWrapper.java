package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.drawable;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.string;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.app.WindowCallback;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.LayoutParams;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.SpinnerAdapter;

public class ToolbarWidgetWrapper
  implements DecorToolbar
{
  private static final int AFFECTS_LOGO_MASK = 3;
  private static final String TAG = "ToolbarWidgetWrapper";
  private ActionMenuPresenter mActionMenuPresenter;
  private View mCustomView;
  private int mDefaultNavigationContentDescription = 0;
  private Drawable mDefaultNavigationIcon;
  private int mDisplayOpts;
  private CharSequence mHomeDescription;
  private Drawable mIcon;
  private Drawable mLogo;
  private boolean mMenuPrepared;
  private Drawable mNavIcon;
  private int mNavigationMode = 0;
  private SpinnerCompat mSpinner;
  private CharSequence mSubtitle;
  private View mTabView;
  private final TintManager mTintManager;
  private CharSequence mTitle;
  private boolean mTitleSet;
  private Toolbar mToolbar;
  private WindowCallback mWindowCallback;
  
  public ToolbarWidgetWrapper(Toolbar paramToolbar, boolean paramBoolean)
  {
    this(paramToolbar, paramBoolean, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_mtrl_am_alpha);
  }
  
  public ToolbarWidgetWrapper(Toolbar paramToolbar, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.mToolbar = paramToolbar;
    this.mTitle = paramToolbar.getTitle();
    this.mSubtitle = paramToolbar.getSubtitle();
    boolean bool;
    TintTypedArray localTintTypedArray;
    if (this.mTitle != null)
    {
      bool = true;
      this.mTitleSet = bool;
      if (!paramBoolean) {
        break label495;
      }
      localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramToolbar.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
      CharSequence localCharSequence1 = localTintTypedArray.getText(R.styleable.ActionBar_title);
      if (!TextUtils.isEmpty(localCharSequence1)) {
        setTitle(localCharSequence1);
      }
      CharSequence localCharSequence2 = localTintTypedArray.getText(R.styleable.ActionBar_subtitle);
      if (!TextUtils.isEmpty(localCharSequence2)) {
        setSubtitle(localCharSequence2);
      }
      Drawable localDrawable1 = localTintTypedArray.getDrawable(R.styleable.ActionBar_logo);
      if (localDrawable1 != null) {
        setLogo(localDrawable1);
      }
      Drawable localDrawable2 = localTintTypedArray.getDrawable(R.styleable.ActionBar_icon);
      if (localDrawable2 != null) {
        setIcon(localDrawable2);
      }
      Drawable localDrawable3 = localTintTypedArray.getDrawable(R.styleable.ActionBar_homeAsUpIndicator);
      if (localDrawable3 != null) {
        setNavigationIcon(localDrawable3);
      }
      setDisplayOptions(localTintTypedArray.getInt(R.styleable.ActionBar_displayOptions, 0));
      int i = localTintTypedArray.getResourceId(R.styleable.ActionBar_customNavigationLayout, 0);
      if (i != 0)
      {
        setCustomView(LayoutInflater.from(this.mToolbar.getContext()).inflate(i, this.mToolbar, false));
        setDisplayOptions(0x10 | this.mDisplayOpts);
      }
      int j = localTintTypedArray.getLayoutDimension(R.styleable.ActionBar_height, 0);
      if (j > 0)
      {
        ViewGroup.LayoutParams localLayoutParams = this.mToolbar.getLayoutParams();
        localLayoutParams.height = j;
        this.mToolbar.setLayoutParams(localLayoutParams);
      }
      int k = localTintTypedArray.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetStart, -1);
      int m = localTintTypedArray.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetEnd, -1);
      if ((k >= 0) || (m >= 0)) {
        this.mToolbar.setContentInsetsRelative(Math.max(k, 0), Math.max(m, 0));
      }
      int n = localTintTypedArray.getResourceId(R.styleable.ActionBar_titleTextStyle, 0);
      if (n != 0) {
        this.mToolbar.setTitleTextAppearance(this.mToolbar.getContext(), n);
      }
      int i1 = localTintTypedArray.getResourceId(R.styleable.ActionBar_subtitleTextStyle, 0);
      if (i1 != 0) {
        this.mToolbar.setSubtitleTextAppearance(this.mToolbar.getContext(), i1);
      }
      int i2 = localTintTypedArray.getResourceId(R.styleable.ActionBar_popupTheme, 0);
      if (i2 != 0) {
        this.mToolbar.setPopupTheme(i2);
      }
      localTintTypedArray.recycle();
    }
    for (this.mTintManager = localTintTypedArray.getTintManager();; this.mTintManager = new TintManager(paramToolbar.getContext()))
    {
      setDefaultNavigationContentDescription(paramInt1);
      this.mHomeDescription = this.mToolbar.getNavigationContentDescription();
      setDefaultNavigationIcon(this.mTintManager.getDrawable(paramInt2));
      this.mToolbar.setNavigationOnClickListener(new ToolbarWidgetWrapper.1(this));
      return;
      bool = false;
      break;
      label495:
      this.mDisplayOpts = detectDisplayOptions();
    }
  }
  
  private int detectDisplayOptions()
  {
    int i = 11;
    if (this.mToolbar.getNavigationIcon() != null) {
      i = 15;
    }
    return i;
  }
  
  private void ensureSpinner()
  {
    if (this.mSpinner == null)
    {
      this.mSpinner = new SpinnerCompat(getContext(), null, R.attr.actionDropDownStyle);
      Toolbar.LayoutParams localLayoutParams = new Toolbar.LayoutParams(-2, -2, 8388627);
      this.mSpinner.setLayoutParams(localLayoutParams);
    }
  }
  
  private void setTitleInt(CharSequence paramCharSequence)
  {
    this.mTitle = paramCharSequence;
    if ((0x8 & this.mDisplayOpts) != 0) {
      this.mToolbar.setTitle(paramCharSequence);
    }
  }
  
  private void updateHomeAccessibility()
  {
    if ((0x4 & this.mDisplayOpts) != 0)
    {
      if (!TextUtils.isEmpty(this.mHomeDescription)) {
        break label31;
      }
      this.mToolbar.setNavigationContentDescription(this.mDefaultNavigationContentDescription);
    }
    for (;;)
    {
      return;
      label31:
      this.mToolbar.setNavigationContentDescription(this.mHomeDescription);
    }
  }
  
  private void updateNavigationIcon()
  {
    Toolbar localToolbar;
    if ((0x4 & this.mDisplayOpts) != 0)
    {
      localToolbar = this.mToolbar;
      if (this.mNavIcon == null) {
        break label32;
      }
    }
    label32:
    for (Drawable localDrawable = this.mNavIcon;; localDrawable = this.mDefaultNavigationIcon)
    {
      localToolbar.setNavigationIcon(localDrawable);
      return;
    }
  }
  
  private void updateToolbarLogo()
  {
    Drawable localDrawable = null;
    if ((0x2 & this.mDisplayOpts) != 0)
    {
      if ((0x1 & this.mDisplayOpts) == 0) {
        break label49;
      }
      if (this.mLogo == null) {
        break label41;
      }
      localDrawable = this.mLogo;
    }
    for (;;)
    {
      this.mToolbar.setLogo(localDrawable);
      return;
      label41:
      localDrawable = this.mIcon;
      continue;
      label49:
      localDrawable = this.mIcon;
    }
  }
  
  public void animateToVisibility(int paramInt)
  {
    if (paramInt == 8) {
      ViewCompat.animate(this.mToolbar).alpha(0.0F).setListener(new ToolbarWidgetWrapper.2(this));
    }
    for (;;)
    {
      return;
      if (paramInt == 0) {
        ViewCompat.animate(this.mToolbar).alpha(1.0F).setListener(new ToolbarWidgetWrapper.3(this));
      }
    }
  }
  
  public boolean canShowOverflowMenu()
  {
    return this.mToolbar.canShowOverflowMenu();
  }
  
  public boolean canSplit()
  {
    return false;
  }
  
  public void collapseActionView()
  {
    this.mToolbar.collapseActionView();
  }
  
  public void dismissPopupMenus()
  {
    this.mToolbar.dismissPopupMenus();
  }
  
  public Context getContext()
  {
    return this.mToolbar.getContext();
  }
  
  public View getCustomView()
  {
    return this.mCustomView;
  }
  
  public int getDisplayOptions()
  {
    return this.mDisplayOpts;
  }
  
  public int getDropdownItemCount()
  {
    if (this.mSpinner != null) {}
    for (int i = this.mSpinner.getCount();; i = 0) {
      return i;
    }
  }
  
  public int getDropdownSelectedPosition()
  {
    if (this.mSpinner != null) {}
    for (int i = this.mSpinner.getSelectedItemPosition();; i = 0) {
      return i;
    }
  }
  
  public int getNavigationMode()
  {
    return this.mNavigationMode;
  }
  
  public CharSequence getSubtitle()
  {
    return this.mToolbar.getSubtitle();
  }
  
  public CharSequence getTitle()
  {
    return this.mToolbar.getTitle();
  }
  
  public ViewGroup getViewGroup()
  {
    return this.mToolbar;
  }
  
  public boolean hasEmbeddedTabs()
  {
    if (this.mTabView != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean hasExpandedActionView()
  {
    return this.mToolbar.hasExpandedActionView();
  }
  
  public boolean hasIcon()
  {
    if (this.mIcon != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean hasLogo()
  {
    if (this.mLogo != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean hideOverflowMenu()
  {
    return this.mToolbar.hideOverflowMenu();
  }
  
  public void initIndeterminateProgress() {}
  
  public void initProgress() {}
  
  public boolean isOverflowMenuShowPending()
  {
    return this.mToolbar.isOverflowMenuShowPending();
  }
  
  public boolean isOverflowMenuShowing()
  {
    return this.mToolbar.isOverflowMenuShowing();
  }
  
  public boolean isSplit()
  {
    return false;
  }
  
  public boolean isTitleTruncated()
  {
    return this.mToolbar.isTitleTruncated();
  }
  
  public void restoreHierarchyState(SparseArray<Parcelable> paramSparseArray)
  {
    this.mToolbar.restoreHierarchyState(paramSparseArray);
  }
  
  public void saveHierarchyState(SparseArray<Parcelable> paramSparseArray)
  {
    this.mToolbar.saveHierarchyState(paramSparseArray);
  }
  
  public void setCollapsible(boolean paramBoolean)
  {
    this.mToolbar.setCollapsible(paramBoolean);
  }
  
  public void setCustomView(View paramView)
  {
    if ((this.mCustomView != null) && ((0x10 & this.mDisplayOpts) != 0)) {
      this.mToolbar.removeView(this.mCustomView);
    }
    this.mCustomView = paramView;
    if ((paramView != null) && ((0x10 & this.mDisplayOpts) != 0)) {
      this.mToolbar.addView(this.mCustomView);
    }
  }
  
  public void setDefaultNavigationContentDescription(int paramInt)
  {
    if (paramInt == this.mDefaultNavigationContentDescription) {}
    for (;;)
    {
      return;
      this.mDefaultNavigationContentDescription = paramInt;
      if (TextUtils.isEmpty(this.mToolbar.getNavigationContentDescription())) {
        setNavigationContentDescription(this.mDefaultNavigationContentDescription);
      }
    }
  }
  
  public void setDefaultNavigationIcon(Drawable paramDrawable)
  {
    if (this.mDefaultNavigationIcon != paramDrawable)
    {
      this.mDefaultNavigationIcon = paramDrawable;
      updateNavigationIcon();
    }
  }
  
  public void setDisplayOptions(int paramInt)
  {
    int i = paramInt ^ this.mDisplayOpts;
    this.mDisplayOpts = paramInt;
    if (i != 0)
    {
      if ((i & 0x4) != 0)
      {
        if ((paramInt & 0x4) == 0) {
          break label115;
        }
        updateNavigationIcon();
        updateHomeAccessibility();
      }
      if ((i & 0x3) != 0) {
        updateToolbarLogo();
      }
      if ((i & 0x8) != 0)
      {
        if ((paramInt & 0x8) == 0) {
          break label126;
        }
        this.mToolbar.setTitle(this.mTitle);
        this.mToolbar.setSubtitle(this.mSubtitle);
      }
      label82:
      if (((i & 0x10) != 0) && (this.mCustomView != null))
      {
        if ((paramInt & 0x10) == 0) {
          break label145;
        }
        this.mToolbar.addView(this.mCustomView);
      }
    }
    for (;;)
    {
      return;
      label115:
      this.mToolbar.setNavigationIcon(null);
      break;
      label126:
      this.mToolbar.setTitle(null);
      this.mToolbar.setSubtitle(null);
      break label82;
      label145:
      this.mToolbar.removeView(this.mCustomView);
    }
  }
  
  public void setDropdownParams(SpinnerAdapter paramSpinnerAdapter, AdapterViewCompat.OnItemSelectedListener paramOnItemSelectedListener)
  {
    ensureSpinner();
    this.mSpinner.setAdapter(paramSpinnerAdapter);
    this.mSpinner.setOnItemSelectedListener(paramOnItemSelectedListener);
  }
  
  public void setDropdownSelectedPosition(int paramInt)
  {
    if (this.mSpinner == null) {
      throw new IllegalStateException("Can't set dropdown selected position without an adapter");
    }
    this.mSpinner.setSelection(paramInt);
  }
  
  public void setEmbeddedTabView(ScrollingTabContainerView paramScrollingTabContainerView)
  {
    if ((this.mTabView != null) && (this.mTabView.getParent() == this.mToolbar)) {
      this.mToolbar.removeView(this.mTabView);
    }
    this.mTabView = paramScrollingTabContainerView;
    if ((paramScrollingTabContainerView != null) && (this.mNavigationMode == 2))
    {
      this.mToolbar.addView(this.mTabView, 0);
      Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)this.mTabView.getLayoutParams();
      localLayoutParams.width = -2;
      localLayoutParams.height = -2;
      localLayoutParams.gravity = 8388691;
      paramScrollingTabContainerView.setAllowCollapse(true);
    }
  }
  
  public void setHomeButtonEnabled(boolean paramBoolean) {}
  
  public void setIcon(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = this.mTintManager.getDrawable(paramInt);; localDrawable = null)
    {
      setIcon(localDrawable);
      return;
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.mIcon = paramDrawable;
    updateToolbarLogo();
  }
  
  public void setLogo(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = this.mTintManager.getDrawable(paramInt);; localDrawable = null)
    {
      setLogo(localDrawable);
      return;
    }
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    this.mLogo = paramDrawable;
    updateToolbarLogo();
  }
  
  public void setMenu(Menu paramMenu, MenuPresenter.Callback paramCallback)
  {
    if (this.mActionMenuPresenter == null)
    {
      this.mActionMenuPresenter = new ActionMenuPresenter(this.mToolbar.getContext());
      this.mActionMenuPresenter.setId(R.id.action_menu_presenter);
    }
    this.mActionMenuPresenter.setCallback(paramCallback);
    this.mToolbar.setMenu((MenuBuilder)paramMenu, this.mActionMenuPresenter);
  }
  
  public void setMenuPrepared()
  {
    this.mMenuPrepared = true;
  }
  
  public void setNavigationContentDescription(int paramInt)
  {
    if (paramInt == 0) {}
    for (Object localObject = null;; localObject = getContext().getString(paramInt))
    {
      setNavigationContentDescription((CharSequence)localObject);
      return;
    }
  }
  
  public void setNavigationContentDescription(CharSequence paramCharSequence)
  {
    this.mHomeDescription = paramCharSequence;
    updateHomeAccessibility();
  }
  
  public void setNavigationIcon(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = this.mTintManager.getDrawable(paramInt);; localDrawable = null)
    {
      setNavigationIcon(localDrawable);
      return;
    }
  }
  
  public void setNavigationIcon(Drawable paramDrawable)
  {
    this.mNavIcon = paramDrawable;
    updateNavigationIcon();
  }
  
  public void setNavigationMode(int paramInt)
  {
    int i = this.mNavigationMode;
    if (paramInt != i)
    {
      switch (i)
      {
      }
      for (;;)
      {
        this.mNavigationMode = paramInt;
        switch (paramInt)
        {
        default: 
          throw new IllegalArgumentException("Invalid navigation mode " + paramInt);
          if ((this.mSpinner != null) && (this.mSpinner.getParent() == this.mToolbar))
          {
            this.mToolbar.removeView(this.mSpinner);
            continue;
            if ((this.mTabView != null) && (this.mTabView.getParent() == this.mToolbar)) {
              this.mToolbar.removeView(this.mTabView);
            }
          }
          break;
        }
      }
      ensureSpinner();
      this.mToolbar.addView(this.mSpinner, 0);
    }
    for (;;)
    {
      return;
      if (this.mTabView != null)
      {
        this.mToolbar.addView(this.mTabView, 0);
        Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)this.mTabView.getLayoutParams();
        localLayoutParams.width = -2;
        localLayoutParams.height = -2;
        localLayoutParams.gravity = 8388691;
      }
    }
  }
  
  public void setSplitToolbar(boolean paramBoolean)
  {
    if (paramBoolean) {
      throw new UnsupportedOperationException("Cannot split an android.widget.Toolbar");
    }
  }
  
  public void setSplitView(ViewGroup paramViewGroup) {}
  
  public void setSplitWhenNarrow(boolean paramBoolean) {}
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.mSubtitle = paramCharSequence;
    if ((0x8 & this.mDisplayOpts) != 0) {
      this.mToolbar.setSubtitle(paramCharSequence);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.mTitleSet = true;
    setTitleInt(paramCharSequence);
  }
  
  public void setWindowCallback(WindowCallback paramWindowCallback)
  {
    this.mWindowCallback = paramWindowCallback;
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    if (!this.mTitleSet) {
      setTitleInt(paramCharSequence);
    }
  }
  
  public boolean showOverflowMenu()
  {
    return this.mToolbar.showOverflowMenu();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ToolbarWidgetWrapper
 * JD-Core Version:    0.7.0.1
 */