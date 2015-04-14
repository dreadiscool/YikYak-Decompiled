package android.support.v7.internal.app;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.LayoutParams;
import android.support.v7.app.ActionBar.OnMenuVisibilityListener;
import android.support.v7.app.ActionBar.OnNavigationListener;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.view.ActionBarPolicy;
import android.support.v7.internal.view.ViewPropertyAnimatorCompatSet;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarOverlayLayout;
import android.support.v7.internal.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback;
import android.support.v7.internal.widget.DecorToolbar;
import android.support.v7.internal.widget.ScrollingTabContainerView;
import android.support.v7.internal.widget.TintManager;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.SpinnerAdapter;
import java.util.ArrayList;

public class WindowDecorActionBar
  extends ActionBar
  implements ActionBarOverlayLayout.ActionBarVisibilityCallback
{
  private static final boolean ALLOW_SHOW_HIDE_ANIMATIONS = false;
  private static final int CONTEXT_DISPLAY_NORMAL = 0;
  private static final int CONTEXT_DISPLAY_SPLIT = 1;
  private static final int INVALID_POSITION = -1;
  private static final String TAG = "WindowDecorActionBar";
  WindowDecorActionBar.ActionModeImpl mActionMode;
  private FragmentActivity mActivity;
  private ActionBarContainer mContainerView;
  private boolean mContentAnimations = true;
  private View mContentView;
  private Context mContext;
  private int mContextDisplayMode;
  private ActionBarContextView mContextView;
  private int mCurWindowVisibility = 0;
  private ViewPropertyAnimatorCompatSet mCurrentShowAnim;
  private DecorToolbar mDecorToolbar;
  ActionMode mDeferredDestroyActionMode;
  ActionMode.Callback mDeferredModeDestroyCallback;
  private Dialog mDialog;
  private boolean mDisplayHomeAsUpSet;
  private boolean mHasEmbeddedTabs;
  private boolean mHiddenByApp;
  private boolean mHiddenBySystem;
  final ViewPropertyAnimatorListener mHideListener = new WindowDecorActionBar.1(this);
  boolean mHideOnContentScroll;
  private boolean mLastMenuVisibility;
  private ArrayList<ActionBar.OnMenuVisibilityListener> mMenuVisibilityListeners = new ArrayList();
  private boolean mNowShowing = true;
  private ActionBarOverlayLayout mOverlayLayout;
  private int mSavedTabPosition = -1;
  private WindowDecorActionBar.TabImpl mSelectedTab;
  private boolean mShowHideAnimationEnabled;
  final ViewPropertyAnimatorListener mShowListener = new WindowDecorActionBar.2(this);
  private boolean mShowingForMode;
  private ActionBarContainer mSplitView;
  private ScrollingTabContainerView mTabScrollView;
  private ArrayList<WindowDecorActionBar.TabImpl> mTabs = new ArrayList();
  private Context mThemedContext;
  private TintManager mTintManager;
  final ViewPropertyAnimatorUpdateListener mUpdateListener = new WindowDecorActionBar.3(this);
  
  static
  {
    boolean bool1 = true;
    boolean bool2;
    if (!WindowDecorActionBar.class.desiredAssertionStatus())
    {
      bool2 = bool1;
      $assertionsDisabled = bool2;
      if (Build.VERSION.SDK_INT < 14) {
        break label34;
      }
    }
    for (;;)
    {
      ALLOW_SHOW_HIDE_ANIMATIONS = bool1;
      return;
      bool2 = false;
      break;
      label34:
      bool1 = false;
    }
  }
  
  public WindowDecorActionBar(Dialog paramDialog)
  {
    this.mDialog = paramDialog;
    init(paramDialog.getWindow().getDecorView());
  }
  
  public WindowDecorActionBar(ActionBarActivity paramActionBarActivity, boolean paramBoolean)
  {
    this.mActivity = paramActionBarActivity;
    View localView = paramActionBarActivity.getWindow().getDecorView();
    init(localView);
    if (!paramBoolean) {
      this.mContentView = localView.findViewById(16908290);
    }
  }
  
  public WindowDecorActionBar(View paramView)
  {
    assert (paramView.isInEditMode());
    init(paramView);
  }
  
  private static boolean checkShowingFlags(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool = true;
    if (paramBoolean3) {}
    for (;;)
    {
      return bool;
      if ((paramBoolean1) || (paramBoolean2)) {
        bool = false;
      }
    }
  }
  
  private void cleanupTabs()
  {
    if (this.mSelectedTab != null) {
      selectTab(null);
    }
    this.mTabs.clear();
    if (this.mTabScrollView != null) {
      this.mTabScrollView.removeAllTabs();
    }
    this.mSavedTabPosition = -1;
  }
  
  private void configureTab(ActionBar.Tab paramTab, int paramInt)
  {
    WindowDecorActionBar.TabImpl localTabImpl = (WindowDecorActionBar.TabImpl)paramTab;
    if (localTabImpl.getCallback() == null) {
      throw new IllegalStateException("Action Bar Tab must have a Callback");
    }
    localTabImpl.setPosition(paramInt);
    this.mTabs.add(paramInt, localTabImpl);
    int i = this.mTabs.size();
    for (int j = paramInt + 1; j < i; j++) {
      ((WindowDecorActionBar.TabImpl)this.mTabs.get(j)).setPosition(j);
    }
  }
  
  private void ensureTabsExist()
  {
    if (this.mTabScrollView != null) {}
    ScrollingTabContainerView localScrollingTabContainerView;
    for (;;)
    {
      return;
      localScrollingTabContainerView = new ScrollingTabContainerView(this.mContext);
      if (!this.mHasEmbeddedTabs) {
        break;
      }
      localScrollingTabContainerView.setVisibility(0);
      this.mDecorToolbar.setEmbeddedTabView(localScrollingTabContainerView);
      this.mTabScrollView = localScrollingTabContainerView;
    }
    if (getNavigationMode() == 2)
    {
      localScrollingTabContainerView.setVisibility(0);
      if (this.mOverlayLayout != null) {
        ViewCompat.requestApplyInsets(this.mOverlayLayout);
      }
    }
    for (;;)
    {
      this.mContainerView.setTabContainer(localScrollingTabContainerView);
      break;
      localScrollingTabContainerView.setVisibility(8);
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
  
  private void hideForActionMode()
  {
    if (this.mShowingForMode)
    {
      this.mShowingForMode = false;
      if (this.mOverlayLayout != null) {
        this.mOverlayLayout.setShowingForActionMode(false);
      }
      updateVisibility(false);
    }
  }
  
  private void init(View paramView)
  {
    this.mOverlayLayout = ((ActionBarOverlayLayout)paramView.findViewById(R.id.decor_content_parent));
    if (this.mOverlayLayout != null) {
      this.mOverlayLayout.setActionBarVisibilityCallback(this);
    }
    this.mDecorToolbar = getDecorToolbar(paramView.findViewById(R.id.action_bar));
    this.mContextView = ((ActionBarContextView)paramView.findViewById(R.id.action_context_bar));
    this.mContainerView = ((ActionBarContainer)paramView.findViewById(R.id.action_bar_container));
    this.mSplitView = ((ActionBarContainer)paramView.findViewById(R.id.split_action_bar));
    if ((this.mDecorToolbar == null) || (this.mContextView == null) || (this.mContainerView == null)) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
    }
    this.mContext = this.mDecorToolbar.getContext();
    int i;
    int j;
    label195:
    ActionBarPolicy localActionBarPolicy;
    if (this.mDecorToolbar.isSplit())
    {
      i = 1;
      this.mContextDisplayMode = i;
      if ((0x4 & this.mDecorToolbar.getDisplayOptions()) == 0) {
        break label311;
      }
      j = 1;
      if (j != 0) {
        this.mDisplayHomeAsUpSet = true;
      }
      localActionBarPolicy = ActionBarPolicy.get(this.mContext);
      if ((!localActionBarPolicy.enableHomeButtonByDefault()) && (j == 0)) {
        break label316;
      }
    }
    label311:
    label316:
    for (boolean bool = true;; bool = false)
    {
      setHomeButtonEnabled(bool);
      setHasEmbeddedTabs(localActionBarPolicy.hasEmbeddedTabs());
      TypedArray localTypedArray = this.mContext.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
      if (localTypedArray.getBoolean(R.styleable.ActionBar_hideOnContentScroll, false)) {
        setHideOnContentScrollEnabled(true);
      }
      int k = localTypedArray.getDimensionPixelSize(R.styleable.ActionBar_elevation, 0);
      if (k != 0) {
        setElevation(k);
      }
      localTypedArray.recycle();
      return;
      i = 0;
      break;
      j = 0;
      break label195;
    }
  }
  
  private void setHasEmbeddedTabs(boolean paramBoolean)
  {
    boolean bool1 = true;
    this.mHasEmbeddedTabs = paramBoolean;
    boolean bool2;
    label45:
    label78:
    boolean bool3;
    label98:
    ActionBarOverlayLayout localActionBarOverlayLayout;
    if (!this.mHasEmbeddedTabs)
    {
      this.mDecorToolbar.setEmbeddedTabView(null);
      this.mContainerView.setTabContainer(this.mTabScrollView);
      if (getNavigationMode() != 2) {
        break label155;
      }
      bool2 = bool1;
      if (this.mTabScrollView != null)
      {
        if (!bool2) {
          break label160;
        }
        this.mTabScrollView.setVisibility(0);
        if (this.mOverlayLayout != null) {
          ViewCompat.requestApplyInsets(this.mOverlayLayout);
        }
      }
      DecorToolbar localDecorToolbar = this.mDecorToolbar;
      if ((this.mHasEmbeddedTabs) || (!bool2)) {
        break label172;
      }
      bool3 = bool1;
      localDecorToolbar.setCollapsible(bool3);
      localActionBarOverlayLayout = this.mOverlayLayout;
      if ((this.mHasEmbeddedTabs) || (!bool2)) {
        break label178;
      }
    }
    for (;;)
    {
      localActionBarOverlayLayout.setHasNonEmbeddedTabs(bool1);
      return;
      this.mContainerView.setTabContainer(null);
      this.mDecorToolbar.setEmbeddedTabView(this.mTabScrollView);
      break;
      label155:
      bool2 = false;
      break label45;
      label160:
      this.mTabScrollView.setVisibility(8);
      break label78;
      label172:
      bool3 = false;
      break label98;
      label178:
      bool1 = false;
    }
  }
  
  private void showForActionMode()
  {
    if (!this.mShowingForMode)
    {
      this.mShowingForMode = true;
      if (this.mOverlayLayout != null) {
        this.mOverlayLayout.setShowingForActionMode(true);
      }
      updateVisibility(false);
    }
  }
  
  private void updateVisibility(boolean paramBoolean)
  {
    if (checkShowingFlags(this.mHiddenByApp, this.mHiddenBySystem, this.mShowingForMode)) {
      if (!this.mNowShowing)
      {
        this.mNowShowing = true;
        doShow(paramBoolean);
      }
    }
    for (;;)
    {
      return;
      if (this.mNowShowing)
      {
        this.mNowShowing = false;
        doHide(paramBoolean);
      }
    }
  }
  
  public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener paramOnMenuVisibilityListener)
  {
    this.mMenuVisibilityListeners.add(paramOnMenuVisibilityListener);
  }
  
  public void addTab(ActionBar.Tab paramTab)
  {
    addTab(paramTab, this.mTabs.isEmpty());
  }
  
  public void addTab(ActionBar.Tab paramTab, int paramInt)
  {
    addTab(paramTab, paramInt, this.mTabs.isEmpty());
  }
  
  public void addTab(ActionBar.Tab paramTab, int paramInt, boolean paramBoolean)
  {
    ensureTabsExist();
    this.mTabScrollView.addTab(paramTab, paramInt, paramBoolean);
    configureTab(paramTab, paramInt);
    if (paramBoolean) {
      selectTab(paramTab);
    }
  }
  
  public void addTab(ActionBar.Tab paramTab, boolean paramBoolean)
  {
    ensureTabsExist();
    this.mTabScrollView.addTab(paramTab, paramBoolean);
    configureTab(paramTab, this.mTabs.size());
    if (paramBoolean) {
      selectTab(paramTab);
    }
  }
  
  public void animateToMode(boolean paramBoolean)
  {
    int i = 0;
    int j;
    label23:
    ActionBarContextView localActionBarContextView;
    if (paramBoolean)
    {
      showForActionMode();
      DecorToolbar localDecorToolbar = this.mDecorToolbar;
      if (!paramBoolean) {
        break label55;
      }
      j = 8;
      localDecorToolbar.animateToVisibility(j);
      localActionBarContextView = this.mContextView;
      if (!paramBoolean) {
        break label61;
      }
    }
    for (;;)
    {
      localActionBarContextView.animateToVisibility(i);
      return;
      hideForActionMode();
      break;
      label55:
      j = 0;
      break label23;
      label61:
      i = 8;
    }
  }
  
  public boolean collapseActionView()
  {
    if ((this.mDecorToolbar != null) && (this.mDecorToolbar.hasExpandedActionView())) {
      this.mDecorToolbar.collapseActionView();
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  void completeDeferredDestroyActionMode()
  {
    if (this.mDeferredModeDestroyCallback != null)
    {
      this.mDeferredModeDestroyCallback.onDestroyActionMode(this.mDeferredDestroyActionMode);
      this.mDeferredDestroyActionMode = null;
      this.mDeferredModeDestroyCallback = null;
    }
  }
  
  public void dispatchMenuVisibilityChanged(boolean paramBoolean)
  {
    if (paramBoolean == this.mLastMenuVisibility) {}
    for (;;)
    {
      return;
      this.mLastMenuVisibility = paramBoolean;
      int i = this.mMenuVisibilityListeners.size();
      for (int j = 0; j < i; j++) {
        ((ActionBar.OnMenuVisibilityListener)this.mMenuVisibilityListeners.get(j)).onMenuVisibilityChanged(paramBoolean);
      }
    }
  }
  
  public void doHide(boolean paramBoolean)
  {
    if (this.mCurrentShowAnim != null) {
      this.mCurrentShowAnim.cancel();
    }
    if ((this.mCurWindowVisibility == 0) && (ALLOW_SHOW_HIDE_ANIMATIONS) && ((this.mShowHideAnimationEnabled) || (paramBoolean)))
    {
      ViewCompat.setAlpha(this.mContainerView, 1.0F);
      this.mContainerView.setTransitioning(true);
      ViewPropertyAnimatorCompatSet localViewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
      float f = -this.mContainerView.getHeight();
      if (paramBoolean)
      {
        int[] arrayOfInt = new int[2];
        arrayOfInt[0] = 0;
        arrayOfInt[1] = 0;
        this.mContainerView.getLocationInWindow(arrayOfInt);
        f -= arrayOfInt[1];
      }
      ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(this.mContainerView).translationY(f);
      localViewPropertyAnimatorCompat.setUpdateListener(this.mUpdateListener);
      localViewPropertyAnimatorCompatSet.play(localViewPropertyAnimatorCompat);
      if ((this.mContentAnimations) && (this.mContentView != null)) {
        localViewPropertyAnimatorCompatSet.play(ViewCompat.animate(this.mContentView).translationY(f));
      }
      if ((this.mSplitView != null) && (this.mSplitView.getVisibility() == 0))
      {
        ViewCompat.setAlpha(this.mSplitView, 1.0F);
        localViewPropertyAnimatorCompatSet.play(ViewCompat.animate(this.mSplitView).translationY(this.mSplitView.getHeight()));
      }
      localViewPropertyAnimatorCompatSet.setInterpolator(AnimationUtils.loadInterpolator(this.mContext, 17432581));
      localViewPropertyAnimatorCompatSet.setDuration(250L);
      localViewPropertyAnimatorCompatSet.setListener(this.mHideListener);
      this.mCurrentShowAnim = localViewPropertyAnimatorCompatSet;
      localViewPropertyAnimatorCompatSet.start();
    }
    for (;;)
    {
      return;
      this.mHideListener.onAnimationEnd(null);
    }
  }
  
  public void doShow(boolean paramBoolean)
  {
    if (this.mCurrentShowAnim != null) {
      this.mCurrentShowAnim.cancel();
    }
    this.mContainerView.setVisibility(0);
    if ((this.mCurWindowVisibility == 0) && (ALLOW_SHOW_HIDE_ANIMATIONS) && ((this.mShowHideAnimationEnabled) || (paramBoolean)))
    {
      ViewCompat.setTranslationY(this.mContainerView, 0.0F);
      float f = -this.mContainerView.getHeight();
      if (paramBoolean)
      {
        int[] arrayOfInt = new int[2];
        arrayOfInt[0] = 0;
        arrayOfInt[1] = 0;
        this.mContainerView.getLocationInWindow(arrayOfInt);
        f -= arrayOfInt[1];
      }
      ViewCompat.setTranslationY(this.mContainerView, f);
      ViewPropertyAnimatorCompatSet localViewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
      ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(this.mContainerView).translationY(0.0F);
      localViewPropertyAnimatorCompat.setUpdateListener(this.mUpdateListener);
      localViewPropertyAnimatorCompatSet.play(localViewPropertyAnimatorCompat);
      if ((this.mContentAnimations) && (this.mContentView != null))
      {
        ViewCompat.setTranslationY(this.mContentView, f);
        localViewPropertyAnimatorCompatSet.play(ViewCompat.animate(this.mContentView).translationY(0.0F));
      }
      if ((this.mSplitView != null) && (this.mContextDisplayMode == 1))
      {
        ViewCompat.setTranslationY(this.mSplitView, this.mSplitView.getHeight());
        this.mSplitView.setVisibility(0);
        localViewPropertyAnimatorCompatSet.play(ViewCompat.animate(this.mSplitView).translationY(0.0F));
      }
      localViewPropertyAnimatorCompatSet.setInterpolator(AnimationUtils.loadInterpolator(this.mContext, 17432582));
      localViewPropertyAnimatorCompatSet.setDuration(250L);
      localViewPropertyAnimatorCompatSet.setListener(this.mShowListener);
      this.mCurrentShowAnim = localViewPropertyAnimatorCompatSet;
      localViewPropertyAnimatorCompatSet.start();
    }
    for (;;)
    {
      if (this.mOverlayLayout != null) {
        ViewCompat.requestApplyInsets(this.mOverlayLayout);
      }
      return;
      ViewCompat.setAlpha(this.mContainerView, 1.0F);
      ViewCompat.setTranslationY(this.mContainerView, 0.0F);
      if ((this.mContentAnimations) && (this.mContentView != null)) {
        ViewCompat.setTranslationY(this.mContentView, 0.0F);
      }
      if ((this.mSplitView != null) && (this.mContextDisplayMode == 1))
      {
        ViewCompat.setAlpha(this.mSplitView, 1.0F);
        ViewCompat.setTranslationY(this.mSplitView, 0.0F);
        this.mSplitView.setVisibility(0);
      }
      this.mShowListener.onAnimationEnd(null);
    }
  }
  
  public void enableContentAnimations(boolean paramBoolean)
  {
    this.mContentAnimations = paramBoolean;
  }
  
  public View getCustomView()
  {
    return this.mDecorToolbar.getCustomView();
  }
  
  public int getDisplayOptions()
  {
    return this.mDecorToolbar.getDisplayOptions();
  }
  
  public float getElevation()
  {
    return ViewCompat.getElevation(this.mContainerView);
  }
  
  public int getHeight()
  {
    return this.mContainerView.getHeight();
  }
  
  public int getHideOffset()
  {
    return this.mOverlayLayout.getActionBarHideOffset();
  }
  
  public int getNavigationItemCount()
  {
    int i;
    switch (this.mDecorToolbar.getNavigationMode())
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      return i;
      i = this.mTabs.size();
      continue;
      i = this.mDecorToolbar.getDropdownItemCount();
    }
  }
  
  public int getNavigationMode()
  {
    return this.mDecorToolbar.getNavigationMode();
  }
  
  public int getSelectedNavigationIndex()
  {
    int i = -1;
    switch (this.mDecorToolbar.getNavigationMode())
    {
    }
    for (;;)
    {
      return i;
      if (this.mSelectedTab != null)
      {
        i = this.mSelectedTab.getPosition();
        continue;
        i = this.mDecorToolbar.getDropdownSelectedPosition();
      }
    }
  }
  
  public ActionBar.Tab getSelectedTab()
  {
    return this.mSelectedTab;
  }
  
  public CharSequence getSubtitle()
  {
    return this.mDecorToolbar.getSubtitle();
  }
  
  public ActionBar.Tab getTabAt(int paramInt)
  {
    return (ActionBar.Tab)this.mTabs.get(paramInt);
  }
  
  public int getTabCount()
  {
    return this.mTabs.size();
  }
  
  public Context getThemedContext()
  {
    int i;
    if (this.mThemedContext == null)
    {
      TypedValue localTypedValue = new TypedValue();
      this.mContext.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
      i = localTypedValue.resourceId;
      if (i == 0) {
        break label61;
      }
    }
    label61:
    for (this.mThemedContext = new ContextThemeWrapper(this.mContext, i);; this.mThemedContext = this.mContext) {
      return this.mThemedContext;
    }
  }
  
  TintManager getTintManager()
  {
    if (this.mTintManager == null) {
      this.mTintManager = new TintManager(this.mContext);
    }
    return this.mTintManager;
  }
  
  public CharSequence getTitle()
  {
    return this.mDecorToolbar.getTitle();
  }
  
  public boolean hasIcon()
  {
    return this.mDecorToolbar.hasIcon();
  }
  
  public boolean hasLogo()
  {
    return this.mDecorToolbar.hasLogo();
  }
  
  public void hide()
  {
    if (!this.mHiddenByApp)
    {
      this.mHiddenByApp = true;
      updateVisibility(false);
    }
  }
  
  public void hideForSystem()
  {
    if (!this.mHiddenBySystem)
    {
      this.mHiddenBySystem = true;
      updateVisibility(true);
    }
  }
  
  public boolean isHideOnContentScrollEnabled()
  {
    return this.mOverlayLayout.isHideOnContentScrollEnabled();
  }
  
  public boolean isShowing()
  {
    int i = getHeight();
    if ((this.mNowShowing) && ((i == 0) || (getHideOffset() < i))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isTitleTruncated()
  {
    if ((this.mDecorToolbar != null) && (this.mDecorToolbar.isTitleTruncated())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public ActionBar.Tab newTab()
  {
    return new WindowDecorActionBar.TabImpl(this);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    setHasEmbeddedTabs(ActionBarPolicy.get(this.mContext).hasEmbeddedTabs());
  }
  
  public void onContentScrollStarted()
  {
    if (this.mCurrentShowAnim != null)
    {
      this.mCurrentShowAnim.cancel();
      this.mCurrentShowAnim = null;
    }
  }
  
  public void onContentScrollStopped() {}
  
  public void onWindowVisibilityChanged(int paramInt)
  {
    this.mCurWindowVisibility = paramInt;
  }
  
  public void removeAllTabs()
  {
    cleanupTabs();
  }
  
  public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener paramOnMenuVisibilityListener)
  {
    this.mMenuVisibilityListeners.remove(paramOnMenuVisibilityListener);
  }
  
  public void removeTab(ActionBar.Tab paramTab)
  {
    removeTabAt(paramTab.getPosition());
  }
  
  public void removeTabAt(int paramInt)
  {
    if (this.mTabScrollView == null) {}
    int i;
    do
    {
      return;
      if (this.mSelectedTab != null) {}
      for (i = this.mSelectedTab.getPosition();; i = this.mSavedTabPosition)
      {
        this.mTabScrollView.removeTabAt(paramInt);
        WindowDecorActionBar.TabImpl localTabImpl = (WindowDecorActionBar.TabImpl)this.mTabs.remove(paramInt);
        if (localTabImpl != null) {
          localTabImpl.setPosition(-1);
        }
        int j = this.mTabs.size();
        for (int k = paramInt; k < j; k++) {
          ((WindowDecorActionBar.TabImpl)this.mTabs.get(k)).setPosition(k);
        }
      }
    } while (i != paramInt);
    if (this.mTabs.isEmpty()) {}
    for (Object localObject = null;; localObject = (WindowDecorActionBar.TabImpl)this.mTabs.get(Math.max(0, paramInt - 1)))
    {
      selectTab((ActionBar.Tab)localObject);
      break;
    }
  }
  
  public void selectTab(ActionBar.Tab paramTab)
  {
    int i = -1;
    if (getNavigationMode() != 2)
    {
      if (paramTab != null) {
        i = paramTab.getPosition();
      }
      this.mSavedTabPosition = i;
    }
    label43:
    label200:
    for (;;)
    {
      return;
      FragmentTransaction localFragmentTransaction;
      if (this.mDecorToolbar.getViewGroup().isInEditMode())
      {
        localFragmentTransaction = null;
        if (this.mSelectedTab != paramTab) {
          break label122;
        }
        if (this.mSelectedTab != null)
        {
          this.mSelectedTab.getCallback().onTabReselected(this.mSelectedTab, localFragmentTransaction);
          this.mTabScrollView.animateToTab(paramTab.getPosition());
        }
      }
      for (;;)
      {
        if ((localFragmentTransaction == null) || (localFragmentTransaction.isEmpty())) {
          break label200;
        }
        localFragmentTransaction.commit();
        break;
        localFragmentTransaction = this.mActivity.getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        break label43;
        label122:
        ScrollingTabContainerView localScrollingTabContainerView = this.mTabScrollView;
        if (paramTab != null) {
          i = paramTab.getPosition();
        }
        localScrollingTabContainerView.setTabSelected(i);
        if (this.mSelectedTab != null) {
          this.mSelectedTab.getCallback().onTabUnselected(this.mSelectedTab, localFragmentTransaction);
        }
        this.mSelectedTab = ((WindowDecorActionBar.TabImpl)paramTab);
        if (this.mSelectedTab != null) {
          this.mSelectedTab.getCallback().onTabSelected(this.mSelectedTab, localFragmentTransaction);
        }
      }
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.mContainerView.setPrimaryBackground(paramDrawable);
  }
  
  public void setCustomView(int paramInt)
  {
    setCustomView(LayoutInflater.from(getThemedContext()).inflate(paramInt, this.mDecorToolbar.getViewGroup(), false));
  }
  
  public void setCustomView(View paramView)
  {
    this.mDecorToolbar.setCustomView(paramView);
  }
  
  public void setCustomView(View paramView, ActionBar.LayoutParams paramLayoutParams)
  {
    paramView.setLayoutParams(paramLayoutParams);
    this.mDecorToolbar.setCustomView(paramView);
  }
  
  public void setDefaultDisplayHomeAsUpEnabled(boolean paramBoolean)
  {
    if (!this.mDisplayHomeAsUpSet) {
      setDisplayHomeAsUpEnabled(paramBoolean);
    }
  }
  
  public void setDisplayHomeAsUpEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      setDisplayOptions(i, 4);
      return;
    }
  }
  
  public void setDisplayOptions(int paramInt)
  {
    if ((paramInt & 0x4) != 0) {
      this.mDisplayHomeAsUpSet = true;
    }
    this.mDecorToolbar.setDisplayOptions(paramInt);
  }
  
  public void setDisplayOptions(int paramInt1, int paramInt2)
  {
    int i = this.mDecorToolbar.getDisplayOptions();
    if ((paramInt2 & 0x4) != 0) {
      this.mDisplayHomeAsUpSet = true;
    }
    this.mDecorToolbar.setDisplayOptions(paramInt1 & paramInt2 | i & (paramInt2 ^ 0xFFFFFFFF));
  }
  
  public void setDisplayShowCustomEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 16;; i = 0)
    {
      setDisplayOptions(i, 16);
      return;
    }
  }
  
  public void setDisplayShowHomeEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      setDisplayOptions(i, 2);
      return;
    }
  }
  
  public void setDisplayShowTitleEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 8;; i = 0)
    {
      setDisplayOptions(i, 8);
      return;
    }
  }
  
  public void setDisplayUseLogoEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      setDisplayOptions(i, 1);
      return;
    }
  }
  
  public void setElevation(float paramFloat)
  {
    ViewCompat.setElevation(this.mContainerView, paramFloat);
    if (this.mSplitView != null) {
      ViewCompat.setElevation(this.mSplitView, paramFloat);
    }
  }
  
  public void setHideOffset(int paramInt)
  {
    if ((paramInt != 0) && (!this.mOverlayLayout.isInOverlayMode())) {
      throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
    }
    this.mOverlayLayout.setActionBarHideOffset(paramInt);
  }
  
  public void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.mOverlayLayout.isInOverlayMode())) {
      throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }
    this.mHideOnContentScroll = paramBoolean;
    this.mOverlayLayout.setHideOnContentScrollEnabled(paramBoolean);
  }
  
  public void setHomeActionContentDescription(int paramInt)
  {
    this.mDecorToolbar.setNavigationContentDescription(paramInt);
  }
  
  public void setHomeActionContentDescription(CharSequence paramCharSequence)
  {
    this.mDecorToolbar.setNavigationContentDescription(paramCharSequence);
  }
  
  public void setHomeAsUpIndicator(int paramInt)
  {
    this.mDecorToolbar.setNavigationIcon(paramInt);
  }
  
  public void setHomeAsUpIndicator(Drawable paramDrawable)
  {
    this.mDecorToolbar.setNavigationIcon(paramDrawable);
  }
  
  public void setHomeButtonEnabled(boolean paramBoolean)
  {
    this.mDecorToolbar.setHomeButtonEnabled(paramBoolean);
  }
  
  public void setIcon(int paramInt)
  {
    this.mDecorToolbar.setIcon(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.mDecorToolbar.setIcon(paramDrawable);
  }
  
  public void setListNavigationCallbacks(SpinnerAdapter paramSpinnerAdapter, ActionBar.OnNavigationListener paramOnNavigationListener)
  {
    this.mDecorToolbar.setDropdownParams(paramSpinnerAdapter, new NavItemSelectedListener(paramOnNavigationListener));
  }
  
  public void setLogo(int paramInt)
  {
    this.mDecorToolbar.setLogo(paramInt);
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    this.mDecorToolbar.setLogo(paramDrawable);
  }
  
  public void setNavigationMode(int paramInt)
  {
    boolean bool1 = true;
    int i = this.mDecorToolbar.getNavigationMode();
    label88:
    boolean bool2;
    label109:
    ActionBarOverlayLayout localActionBarOverlayLayout;
    switch (i)
    {
    default: 
      if ((i != paramInt) && (!this.mHasEmbeddedTabs) && (this.mOverlayLayout != null)) {
        ViewCompat.requestApplyInsets(this.mOverlayLayout);
      }
      this.mDecorToolbar.setNavigationMode(paramInt);
      switch (paramInt)
      {
      default: 
        DecorToolbar localDecorToolbar = this.mDecorToolbar;
        if ((paramInt == 2) && (!this.mHasEmbeddedTabs))
        {
          bool2 = bool1;
          localDecorToolbar.setCollapsible(bool2);
          localActionBarOverlayLayout = this.mOverlayLayout;
          if ((paramInt != 2) || (this.mHasEmbeddedTabs)) {
            break label212;
          }
        }
        break;
      }
      break;
    }
    for (;;)
    {
      localActionBarOverlayLayout.setHasNonEmbeddedTabs(bool1);
      return;
      this.mSavedTabPosition = getSelectedNavigationIndex();
      selectTab(null);
      this.mTabScrollView.setVisibility(8);
      break;
      ensureTabsExist();
      this.mTabScrollView.setVisibility(0);
      if (this.mSavedTabPosition == -1) {
        break label88;
      }
      setSelectedNavigationItem(this.mSavedTabPosition);
      this.mSavedTabPosition = -1;
      break label88;
      bool2 = false;
      break label109;
      label212:
      bool1 = false;
    }
  }
  
  public void setSelectedNavigationItem(int paramInt)
  {
    switch (this.mDecorToolbar.getNavigationMode())
    {
    default: 
      throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
    case 2: 
      selectTab((ActionBar.Tab)this.mTabs.get(paramInt));
    }
    for (;;)
    {
      return;
      this.mDecorToolbar.setDropdownSelectedPosition(paramInt);
    }
  }
  
  public void setShowHideAnimationEnabled(boolean paramBoolean)
  {
    this.mShowHideAnimationEnabled = paramBoolean;
    if ((!paramBoolean) && (this.mCurrentShowAnim != null)) {
      this.mCurrentShowAnim.cancel();
    }
  }
  
  public void setSplitBackgroundDrawable(Drawable paramDrawable)
  {
    if (this.mSplitView != null) {
      this.mSplitView.setSplitBackground(paramDrawable);
    }
  }
  
  public void setStackedBackgroundDrawable(Drawable paramDrawable)
  {
    this.mContainerView.setStackedBackground(paramDrawable);
  }
  
  public void setSubtitle(int paramInt)
  {
    setSubtitle(this.mContext.getString(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.mDecorToolbar.setSubtitle(paramCharSequence);
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(this.mContext.getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.mDecorToolbar.setTitle(paramCharSequence);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    this.mDecorToolbar.setWindowTitle(paramCharSequence);
  }
  
  public void show()
  {
    if (this.mHiddenByApp)
    {
      this.mHiddenByApp = false;
      updateVisibility(false);
    }
  }
  
  public void showForSystem()
  {
    if (this.mHiddenBySystem)
    {
      this.mHiddenBySystem = false;
      updateVisibility(true);
    }
  }
  
  public ActionMode startActionMode(ActionMode.Callback paramCallback)
  {
    if (this.mActionMode != null) {
      this.mActionMode.finish();
    }
    this.mOverlayLayout.setHideOnContentScrollEnabled(false);
    this.mContextView.killMode();
    WindowDecorActionBar.ActionModeImpl localActionModeImpl = new WindowDecorActionBar.ActionModeImpl(this, paramCallback);
    if (localActionModeImpl.dispatchOnCreate())
    {
      localActionModeImpl.invalidate();
      this.mContextView.initForMode(localActionModeImpl);
      animateToMode(true);
      if ((this.mSplitView != null) && (this.mContextDisplayMode == 1) && (this.mSplitView.getVisibility() != 0))
      {
        this.mSplitView.setVisibility(0);
        if (this.mOverlayLayout != null) {
          ViewCompat.requestApplyInsets(this.mOverlayLayout);
        }
      }
      this.mContextView.sendAccessibilityEvent(32);
      this.mActionMode = localActionModeImpl;
    }
    for (;;)
    {
      return localActionModeImpl;
      localActionModeImpl = null;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.app.WindowDecorActionBar
 * JD-Core Version:    0.7.0.1
 */