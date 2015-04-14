package android.support.v7.app;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.color;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.style;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.app.ToolbarActionBar;
import android.support.v7.internal.app.WindowCallback;
import android.support.v7.internal.app.WindowDecorActionBar;
import android.support.v7.internal.view.StandaloneActionMode;
import android.support.v7.internal.view.menu.ListMenuPresenter;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.DecorContentParent;
import android.support.v7.internal.widget.FitWindowsViewGroup;
import android.support.v7.internal.widget.TintCheckBox;
import android.support.v7.internal.widget.TintCheckedTextView;
import android.support.v7.internal.widget.TintEditText;
import android.support.v7.internal.widget.TintRadioButton;
import android.support.v7.internal.widget.TintSpinner;
import android.support.v7.internal.widget.ViewStubCompat;
import android.support.v7.internal.widget.ViewUtils;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.widget.Toolbar;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

class ActionBarActivityDelegateBase
  extends ActionBarActivityDelegate
  implements MenuBuilder.Callback
{
  private static final String TAG = "ActionBarActivityDelegateBase";
  private ActionBarActivityDelegateBase.ActionMenuPresenterCallback mActionMenuPresenterCallback;
  ActionMode mActionMode;
  PopupWindow mActionModePopup;
  ActionBarContextView mActionModeView;
  private boolean mClosingActionMenu;
  private DecorContentParent mDecorContentParent;
  private boolean mEnableDefaultActionBarUp;
  private boolean mFeatureIndeterminateProgress;
  private boolean mFeatureProgress;
  private int mInvalidatePanelMenuFeatures;
  private boolean mInvalidatePanelMenuPosted;
  private final Runnable mInvalidatePanelMenuRunnable = new ActionBarActivityDelegateBase.1(this);
  private ActionBarActivityDelegateBase.PanelMenuPresenterCallback mPanelMenuPresenterCallback;
  private ActionBarActivityDelegateBase.PanelFeatureState[] mPanels;
  private ActionBarActivityDelegateBase.PanelFeatureState mPreparedPanel;
  Runnable mShowActionModePopup;
  private View mStatusGuard;
  private ViewGroup mSubDecor;
  private boolean mSubDecorInstalled;
  private Rect mTempRect1;
  private Rect mTempRect2;
  private CharSequence mTitleToSet;
  private ListMenuPresenter mToolbarListMenuPresenter;
  private ViewGroup mWindowDecor;
  
  ActionBarActivityDelegateBase(ActionBarActivity paramActionBarActivity)
  {
    super(paramActionBarActivity);
  }
  
  private void applyFixedSizeWindow()
  {
    TypedValue localTypedValue1 = null;
    TypedArray localTypedArray = this.mActivity.obtainStyledAttributes(R.styleable.Theme);
    TypedValue localTypedValue2;
    if (localTypedArray.hasValue(R.styleable.Theme_windowFixedWidthMajor)) {
      if (0 == 0)
      {
        localTypedValue2 = new TypedValue();
        localTypedArray.getValue(R.styleable.Theme_windowFixedWidthMajor, localTypedValue2);
      }
    }
    for (;;)
    {
      TypedValue localTypedValue3;
      if (localTypedArray.hasValue(R.styleable.Theme_windowFixedWidthMinor)) {
        if (0 == 0)
        {
          localTypedValue3 = new TypedValue();
          localTypedArray.getValue(R.styleable.Theme_windowFixedWidthMinor, localTypedValue3);
        }
      }
      for (;;)
      {
        TypedValue localTypedValue4;
        if (localTypedArray.hasValue(R.styleable.Theme_windowFixedHeightMajor)) {
          if (0 == 0)
          {
            localTypedValue4 = new TypedValue();
            localTypedArray.getValue(R.styleable.Theme_windowFixedHeightMajor, localTypedValue4);
          }
        }
        for (;;)
        {
          if (localTypedArray.hasValue(R.styleable.Theme_windowFixedHeightMinor))
          {
            if (0 == 0) {
              localTypedValue1 = new TypedValue();
            }
            localTypedArray.getValue(R.styleable.Theme_windowFixedHeightMinor, localTypedValue1);
          }
          DisplayMetrics localDisplayMetrics = this.mActivity.getResources().getDisplayMetrics();
          int i;
          label174:
          int j;
          if (localDisplayMetrics.widthPixels < localDisplayMetrics.heightPixels)
          {
            i = 1;
            if (i == 0) {
              break label282;
            }
            if ((localTypedValue3 == null) || (localTypedValue3.type == 0)) {
              break label367;
            }
            if (localTypedValue3.type != 5) {
              break label288;
            }
            j = (int)localTypedValue3.getDimension(localDisplayMetrics);
          }
          for (;;)
          {
            label206:
            label211:
            int k;
            if (i != 0)
            {
              if ((localTypedValue4 == null) || (localTypedValue4.type == 0)) {
                break label360;
              }
              if (localTypedValue4.type != 5) {
                break label327;
              }
              k = (int)localTypedValue4.getDimension(localDisplayMetrics);
            }
            for (;;)
            {
              if ((j != -1) || (k != -1)) {
                this.mActivity.getWindow().setLayout(j, k);
              }
              localTypedArray.recycle();
              return;
              i = 0;
              break;
              label282:
              localTypedValue3 = localTypedValue2;
              break label174;
              label288:
              if (localTypedValue3.type != 6) {
                break label367;
              }
              j = (int)localTypedValue3.getFraction(localDisplayMetrics.widthPixels, localDisplayMetrics.widthPixels);
              break label206;
              localTypedValue4 = localTypedValue1;
              break label211;
              label327:
              if (localTypedValue4.type == 6) {
                k = (int)localTypedValue4.getFraction(localDisplayMetrics.heightPixels, localDisplayMetrics.heightPixels);
              } else {
                label360:
                k = -1;
              }
            }
            label367:
            j = -1;
          }
          localTypedValue4 = null;
          break;
          localTypedValue4 = null;
        }
        localTypedValue3 = null;
        break;
        localTypedValue3 = null;
      }
      localTypedValue2 = null;
      break;
      localTypedValue2 = null;
    }
  }
  
  private void callOnPanelClosed(int paramInt, ActionBarActivityDelegateBase.PanelFeatureState paramPanelFeatureState, Menu paramMenu)
  {
    if (paramMenu == null)
    {
      if ((paramPanelFeatureState == null) && (paramInt >= 0) && (paramInt < this.mPanels.length)) {
        paramPanelFeatureState = this.mPanels[paramInt];
      }
      if (paramPanelFeatureState != null) {
        paramMenu = paramPanelFeatureState.menu;
      }
    }
    if ((paramPanelFeatureState != null) && (!paramPanelFeatureState.isOpen)) {}
    for (;;)
    {
      return;
      getWindowCallback().onPanelClosed(paramInt, paramMenu);
    }
  }
  
  private void checkCloseActionMenu(MenuBuilder paramMenuBuilder)
  {
    if (this.mClosingActionMenu) {}
    for (;;)
    {
      return;
      this.mClosingActionMenu = true;
      this.mDecorContentParent.dismissPopups();
      WindowCallback localWindowCallback = getWindowCallback();
      if ((localWindowCallback != null) && (!isDestroyed())) {
        localWindowCallback.onPanelClosed(8, paramMenuBuilder);
      }
      this.mClosingActionMenu = false;
    }
  }
  
  private void closePanel(ActionBarActivityDelegateBase.PanelFeatureState paramPanelFeatureState, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramPanelFeatureState.featureId == 0) && (this.mDecorContentParent != null) && (this.mDecorContentParent.isOverflowMenuShowing())) {
      checkCloseActionMenu(paramPanelFeatureState.menu);
    }
    for (;;)
    {
      return;
      if ((paramPanelFeatureState.isOpen) && (paramBoolean)) {
        callOnPanelClosed(paramPanelFeatureState.featureId, paramPanelFeatureState, null);
      }
      paramPanelFeatureState.isPrepared = false;
      paramPanelFeatureState.isHandled = false;
      paramPanelFeatureState.isOpen = false;
      paramPanelFeatureState.shownPanelView = null;
      paramPanelFeatureState.refreshDecorView = true;
      if (this.mPreparedPanel == paramPanelFeatureState) {
        this.mPreparedPanel = null;
      }
    }
  }
  
  private void doInvalidatePanelMenu(int paramInt)
  {
    ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState1 = getPanelState(paramInt, true);
    if (localPanelFeatureState1.menu != null)
    {
      Bundle localBundle = new Bundle();
      localPanelFeatureState1.menu.saveActionViewStates(localBundle);
      if (localBundle.size() > 0) {
        localPanelFeatureState1.frozenActionViewState = localBundle;
      }
      localPanelFeatureState1.menu.stopDispatchingItemsChanged();
      localPanelFeatureState1.menu.clear();
    }
    localPanelFeatureState1.refreshMenuContent = true;
    localPanelFeatureState1.refreshDecorView = true;
    if (((paramInt == 8) || (paramInt == 0)) && (this.mDecorContentParent != null))
    {
      ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState2 = getPanelState(0, false);
      if (localPanelFeatureState2 != null)
      {
        localPanelFeatureState2.isPrepared = false;
        preparePanel(localPanelFeatureState2, null);
      }
    }
  }
  
  private void ensureToolbarListMenuPresenter()
  {
    TypedValue localTypedValue;
    ActionBarActivity localActionBarActivity;
    if (this.mToolbarListMenuPresenter == null)
    {
      localTypedValue = new TypedValue();
      this.mActivity.getTheme().resolveAttribute(R.attr.panelMenuListTheme, localTypedValue, true);
      localActionBarActivity = this.mActivity;
      if (localTypedValue.resourceId == 0) {
        break label74;
      }
    }
    label74:
    for (int i = localTypedValue.resourceId;; i = R.style.Theme_AppCompat_CompactMenu)
    {
      this.mToolbarListMenuPresenter = new ListMenuPresenter(new ContextThemeWrapper(localActionBarActivity, i), R.layout.abc_list_menu_item_layout);
      return;
    }
  }
  
  private ActionBarActivityDelegateBase.PanelFeatureState findMenuPanel(Menu paramMenu)
  {
    ActionBarActivityDelegateBase.PanelFeatureState[] arrayOfPanelFeatureState = this.mPanels;
    int i;
    int j;
    label15:
    ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState2;
    if (arrayOfPanelFeatureState != null)
    {
      i = arrayOfPanelFeatureState.length;
      j = 0;
      if (j >= i) {
        break label59;
      }
      localPanelFeatureState2 = arrayOfPanelFeatureState[j];
      if ((localPanelFeatureState2 == null) || (localPanelFeatureState2.menu != paramMenu)) {
        break label53;
      }
    }
    label53:
    label59:
    for (ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState1 = localPanelFeatureState2;; localPanelFeatureState1 = null)
    {
      return localPanelFeatureState1;
      i = 0;
      break;
      j++;
      break label15;
    }
  }
  
  private ActionBarActivityDelegateBase.PanelFeatureState getPanelState(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = this.mPanels;
    if ((localObject1 == null) || (localObject1.length <= paramInt))
    {
      ActionBarActivityDelegateBase.PanelFeatureState[] arrayOfPanelFeatureState = new ActionBarActivityDelegateBase.PanelFeatureState[paramInt + 1];
      if (localObject1 != null) {
        System.arraycopy(localObject1, 0, arrayOfPanelFeatureState, 0, localObject1.length);
      }
      this.mPanels = arrayOfPanelFeatureState;
      localObject1 = arrayOfPanelFeatureState;
    }
    Object localObject2 = localObject1[paramInt];
    ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState;
    if (localObject2 == null)
    {
      localPanelFeatureState = new ActionBarActivityDelegateBase.PanelFeatureState(paramInt);
      localObject1[paramInt] = localPanelFeatureState;
    }
    for (Object localObject3 = localPanelFeatureState;; localObject3 = localObject2) {
      return localObject3;
    }
  }
  
  private boolean initializePanelContent(ActionBarActivityDelegateBase.PanelFeatureState paramPanelFeatureState)
  {
    boolean bool1 = false;
    if (paramPanelFeatureState.menu == null) {
      return bool1;
    }
    if (this.mPanelMenuPresenterCallback == null) {
      this.mPanelMenuPresenterCallback = new ActionBarActivityDelegateBase.PanelMenuPresenterCallback(this, null);
    }
    paramPanelFeatureState.shownPanelView = ((View)paramPanelFeatureState.getListMenuView(this.mPanelMenuPresenterCallback));
    if (paramPanelFeatureState.shownPanelView != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      bool1 = bool2;
      break;
    }
  }
  
  private void initializePanelDecor(ActionBarActivityDelegateBase.PanelFeatureState paramPanelFeatureState)
  {
    paramPanelFeatureState.decorView = this.mWindowDecor;
    paramPanelFeatureState.setStyle(getActionBarThemedContext());
  }
  
  private boolean initializePanelMenu(ActionBarActivityDelegateBase.PanelFeatureState paramPanelFeatureState)
  {
    ActionBarActivity localActionBarActivity = this.mActivity;
    TypedValue localTypedValue;
    Resources.Theme localTheme1;
    Object localObject;
    if (((paramPanelFeatureState.featureId == 0) || (paramPanelFeatureState.featureId == 8)) && (this.mDecorContentParent != null))
    {
      localTypedValue = new TypedValue();
      localTheme1 = localActionBarActivity.getTheme();
      localTheme1.resolveAttribute(R.attr.actionBarTheme, localTypedValue, true);
      Resources.Theme localTheme2 = null;
      if (localTypedValue.resourceId != 0)
      {
        localTheme2 = localActionBarActivity.getResources().newTheme();
        localTheme2.setTo(localTheme1);
        localTheme2.applyStyle(localTypedValue.resourceId, true);
        localTheme2.resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
        if (localTypedValue.resourceId != 0)
        {
          if (localTheme2 == null)
          {
            localTheme2 = localActionBarActivity.getResources().newTheme();
            localTheme2.setTo(localTheme1);
          }
          localTheme2.applyStyle(localTypedValue.resourceId, true);
        }
        Resources.Theme localTheme3 = localTheme2;
        if (localTheme3 == null) {
          break label207;
        }
        localObject = new ContextThemeWrapper(localActionBarActivity, 0);
        ((Context)localObject).getTheme().setTo(localTheme3);
      }
    }
    for (;;)
    {
      MenuBuilder localMenuBuilder = new MenuBuilder((Context)localObject);
      localMenuBuilder.setCallback(this);
      paramPanelFeatureState.setMenu(localMenuBuilder);
      return true;
      localTheme1.resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
      break;
      label207:
      localObject = localActionBarActivity;
    }
  }
  
  private void invalidatePanelMenu(int paramInt)
  {
    this.mInvalidatePanelMenuFeatures |= 1 << paramInt;
    if ((!this.mInvalidatePanelMenuPosted) && (this.mWindowDecor != null))
    {
      ViewCompat.postOnAnimation(this.mWindowDecor, this.mInvalidatePanelMenuRunnable);
      this.mInvalidatePanelMenuPosted = true;
    }
  }
  
  private void openPanel(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 0) && (this.mDecorContentParent != null) && (this.mDecorContentParent.canShowOverflowMenu()) && (!ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mActivity)))) {
      this.mDecorContentParent.showOverflowMenu();
    }
    for (;;)
    {
      return;
      openPanel(getPanelState(paramInt, true), paramKeyEvent);
    }
  }
  
  private void openPanel(ActionBarActivityDelegateBase.PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if ((paramPanelFeatureState.isOpen) || (isDestroyed())) {}
    for (;;)
    {
      return;
      int i;
      if (paramPanelFeatureState.featureId == 0)
      {
        ActionBarActivity localActionBarActivity = this.mActivity;
        if ((0xF & localActionBarActivity.getResources().getConfiguration().screenLayout) != 4) {
          break label110;
        }
        i = 1;
        label49:
        if (localActionBarActivity.getApplicationInfo().targetSdkVersion < 11) {
          break label116;
        }
      }
      label110:
      label116:
      for (int j = 1;; j = 0)
      {
        if ((i != 0) && (j != 0)) {
          break label120;
        }
        WindowCallback localWindowCallback = getWindowCallback();
        if ((localWindowCallback == null) || (localWindowCallback.onMenuOpened(paramPanelFeatureState.featureId, paramPanelFeatureState.menu))) {
          break label122;
        }
        closePanel(paramPanelFeatureState, true);
        break;
        i = 0;
        break label49;
      }
      label120:
      continue;
      label122:
      if (preparePanel(paramPanelFeatureState, paramKeyEvent))
      {
        if ((paramPanelFeatureState.decorView == null) || (paramPanelFeatureState.refreshDecorView)) {
          initializePanelDecor(paramPanelFeatureState);
        }
        if ((initializePanelContent(paramPanelFeatureState)) && (paramPanelFeatureState.hasPanelItems()))
        {
          paramPanelFeatureState.isHandled = false;
          paramPanelFeatureState.isOpen = true;
        }
      }
    }
  }
  
  private boolean preparePanel(ActionBarActivityDelegateBase.PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    boolean bool1 = false;
    if (isDestroyed()) {}
    for (;;)
    {
      return bool1;
      if (paramPanelFeatureState.isPrepared)
      {
        bool1 = true;
      }
      else
      {
        if ((this.mPreparedPanel != null) && (this.mPreparedPanel != paramPanelFeatureState)) {
          closePanel(this.mPreparedPanel, false);
        }
        if ((paramPanelFeatureState.featureId == 0) || (paramPanelFeatureState.featureId == 8)) {}
        for (int i = 1;; i = 0)
        {
          if ((i != 0) && (this.mDecorContentParent != null)) {
            this.mDecorContentParent.setMenuPrepared();
          }
          if ((paramPanelFeatureState.menu != null) && (!paramPanelFeatureState.refreshMenuContent)) {
            break label244;
          }
          if ((paramPanelFeatureState.menu == null) && ((!initializePanelMenu(paramPanelFeatureState)) || (paramPanelFeatureState.menu == null))) {
            break;
          }
          if ((i != 0) && (this.mDecorContentParent != null))
          {
            if (this.mActionMenuPresenterCallback == null) {
              this.mActionMenuPresenterCallback = new ActionBarActivityDelegateBase.ActionMenuPresenterCallback(this, null);
            }
            this.mDecorContentParent.setMenu(paramPanelFeatureState.menu, this.mActionMenuPresenterCallback);
          }
          paramPanelFeatureState.menu.stopDispatchingItemsChanged();
          if (getWindowCallback().onCreatePanelMenu(paramPanelFeatureState.featureId, paramPanelFeatureState.menu)) {
            break label239;
          }
          paramPanelFeatureState.setMenu(null);
          if ((i == 0) || (this.mDecorContentParent == null)) {
            break;
          }
          this.mDecorContentParent.setMenu(null, this.mActionMenuPresenterCallback);
          break;
        }
        label239:
        paramPanelFeatureState.refreshMenuContent = false;
        label244:
        paramPanelFeatureState.menu.stopDispatchingItemsChanged();
        if (paramPanelFeatureState.frozenActionViewState != null)
        {
          paramPanelFeatureState.menu.restoreActionViewStates(paramPanelFeatureState.frozenActionViewState);
          paramPanelFeatureState.frozenActionViewState = null;
        }
        if (getWindowCallback().onPreparePanel(0, null, paramPanelFeatureState.menu)) {
          break;
        }
        if ((i != 0) && (this.mDecorContentParent != null)) {
          this.mDecorContentParent.setMenu(null, this.mActionMenuPresenterCallback);
        }
        paramPanelFeatureState.menu.startDispatchingItemsChanged();
      }
    }
    int j;
    if (paramKeyEvent != null)
    {
      j = paramKeyEvent.getDeviceId();
      label338:
      if (KeyCharacterMap.load(j).getKeyboardType() == 1) {
        break label404;
      }
    }
    label404:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramPanelFeatureState.qwertyMode = bool2;
      paramPanelFeatureState.menu.setQwertyMode(paramPanelFeatureState.qwertyMode);
      paramPanelFeatureState.menu.startDispatchingItemsChanged();
      paramPanelFeatureState.isPrepared = true;
      paramPanelFeatureState.isHandled = false;
      this.mPreparedPanel = paramPanelFeatureState;
      bool1 = true;
      break;
      j = -1;
      break label338;
    }
  }
  
  private void reopenMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if ((this.mDecorContentParent != null) && (this.mDecorContentParent.canShowOverflowMenu()) && ((!ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mActivity))) || (this.mDecorContentParent.isOverflowMenuShowPending())))
    {
      WindowCallback localWindowCallback = getWindowCallback();
      if ((!this.mDecorContentParent.isOverflowMenuShowing()) || (!paramBoolean)) {
        if ((localWindowCallback != null) && (!isDestroyed()))
        {
          if ((this.mInvalidatePanelMenuPosted) && ((0x1 & this.mInvalidatePanelMenuFeatures) != 0))
          {
            this.mWindowDecor.removeCallbacks(this.mInvalidatePanelMenuRunnable);
            this.mInvalidatePanelMenuRunnable.run();
          }
          ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState2 = getPanelState(0, true);
          if ((localPanelFeatureState2.menu != null) && (!localPanelFeatureState2.refreshMenuContent) && (localWindowCallback.onPreparePanel(0, null, localPanelFeatureState2.menu)))
          {
            localWindowCallback.onMenuOpened(8, localPanelFeatureState2.menu);
            this.mDecorContentParent.showOverflowMenu();
          }
        }
      }
    }
    for (;;)
    {
      return;
      this.mDecorContentParent.hideOverflowMenu();
      if (!isDestroyed())
      {
        ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState3 = getPanelState(0, true);
        this.mActivity.onPanelClosed(8, localPanelFeatureState3.menu);
        continue;
        ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState1 = getPanelState(0, true);
        localPanelFeatureState1.refreshDecorView = true;
        closePanel(localPanelFeatureState1, false);
        openPanel(localPanelFeatureState1, null);
      }
    }
  }
  
  private void throwFeatureRequestIfSubDecorInstalled()
  {
    if (this.mSubDecorInstalled) {
      throw new AndroidRuntimeException("supportRequestWindowFeature() must be called before adding content");
    }
  }
  
  private int updateStatusGuard(int paramInt)
  {
    int i = 1;
    int j = 0;
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    int n;
    int i1;
    label202:
    label209:
    int m;
    if ((this.mActionModeView != null) && ((this.mActionModeView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mActionModeView.getLayoutParams();
      if (this.mActionModeView.isShown())
      {
        if (this.mTempRect1 == null)
        {
          this.mTempRect1 = new Rect();
          this.mTempRect2 = new Rect();
        }
        Rect localRect1 = this.mTempRect1;
        Rect localRect2 = this.mTempRect2;
        localRect1.set(0, paramInt, 0, 0);
        ViewUtils.computeFitSystemWindows(this.mSubDecor, localRect1, localRect2);
        if (localRect2.top == 0)
        {
          n = paramInt;
          if (localMarginLayoutParams.topMargin == n) {
            break label359;
          }
          localMarginLayoutParams.topMargin = paramInt;
          if (this.mStatusGuard != null) {
            break label281;
          }
          this.mStatusGuard = new View(this.mActivity);
          this.mStatusGuard.setBackgroundColor(this.mActivity.getResources().getColor(R.color.abc_input_method_navigation_guard));
          this.mSubDecor.addView(this.mStatusGuard, -1, new ViewGroup.LayoutParams(-1, paramInt));
          i1 = i;
          if (this.mStatusGuard == null) {
            break label320;
          }
          if ((!this.mOverlayActionMode) && (i != 0)) {
            paramInt = 0;
          }
          int i2 = i1;
          m = i;
          i = i2;
          label232:
          if (i != 0) {
            this.mActionModeView.setLayoutParams(localMarginLayoutParams);
          }
        }
      }
    }
    for (int k = m;; k = 0)
    {
      View localView;
      if (this.mStatusGuard != null)
      {
        localView = this.mStatusGuard;
        if (k == 0) {
          break label345;
        }
      }
      for (;;)
      {
        localView.setVisibility(j);
        return paramInt;
        n = 0;
        break;
        label281:
        ViewGroup.LayoutParams localLayoutParams = this.mStatusGuard.getLayoutParams();
        if (localLayoutParams.height != paramInt)
        {
          localLayoutParams.height = paramInt;
          this.mStatusGuard.setLayoutParams(localLayoutParams);
        }
        i1 = i;
        break label202;
        label320:
        i = 0;
        break label209;
        if (localMarginLayoutParams.topMargin == 0) {
          break label351;
        }
        localMarginLayoutParams.topMargin = 0;
        m = 0;
        break label232;
        label345:
        j = 8;
      }
      label351:
      i = 0;
      m = 0;
      break label232;
      label359:
      i1 = 0;
      break label202;
    }
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    ensureSubDecor();
    ((ViewGroup)this.mActivity.findViewById(16908290)).addView(paramView, paramLayoutParams);
    this.mActivity.onSupportContentChanged();
  }
  
  public ActionBar createSupportActionBar()
  {
    ensureSubDecor();
    WindowDecorActionBar localWindowDecorActionBar = new WindowDecorActionBar(this.mActivity, this.mOverlayActionBar);
    localWindowDecorActionBar.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
    return localWindowDecorActionBar;
  }
  
  View createView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    int i;
    if (Build.VERSION.SDK_INT < 21) {
      i = -1;
    }
    Object localObject;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        localObject = null;
      }
      break;
    }
    for (;;)
    {
      return localObject;
      if (!paramString.equals("EditText")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("Spinner")) {
        break;
      }
      i = 1;
      break;
      if (!paramString.equals("CheckBox")) {
        break;
      }
      i = 2;
      break;
      if (!paramString.equals("RadioButton")) {
        break;
      }
      i = 3;
      break;
      if (!paramString.equals("CheckedTextView")) {
        break;
      }
      i = 4;
      break;
      localObject = new TintEditText(paramContext, paramAttributeSet);
      continue;
      localObject = new TintSpinner(paramContext, paramAttributeSet);
      continue;
      localObject = new TintCheckBox(paramContext, paramAttributeSet);
      continue;
      localObject = new TintRadioButton(paramContext, paramAttributeSet);
      continue;
      localObject = new TintCheckedTextView(paramContext, paramAttributeSet);
    }
  }
  
  final void ensureSubDecor()
  {
    Object localObject;
    if (!this.mSubDecorInstalled)
    {
      if (!this.mHasActionBar) {
        break label319;
      }
      TypedValue localTypedValue = new TypedValue();
      this.mActivity.getTheme().resolveAttribute(R.attr.actionBarTheme, localTypedValue, true);
      if (localTypedValue.resourceId == 0) {
        break label311;
      }
      localObject = new ContextThemeWrapper(this.mActivity, localTypedValue.resourceId);
      this.mSubDecor = ((ViewGroup)LayoutInflater.from((Context)localObject).inflate(R.layout.abc_screen_toolbar, null));
      this.mDecorContentParent = ((DecorContentParent)this.mSubDecor.findViewById(R.id.decor_content_parent));
      this.mDecorContentParent.setWindowCallback(getWindowCallback());
      if (this.mOverlayActionBar) {
        this.mDecorContentParent.initFeature(9);
      }
      if (this.mFeatureProgress) {
        this.mDecorContentParent.initFeature(2);
      }
      if (this.mFeatureIndeterminateProgress) {
        this.mDecorContentParent.initFeature(5);
      }
    }
    for (;;)
    {
      ViewUtils.makeOptionalFitsSystemWindows(this.mSubDecor);
      this.mActivity.superSetContentView(this.mSubDecor);
      View localView = this.mActivity.findViewById(16908290);
      localView.setId(-1);
      this.mActivity.findViewById(R.id.action_bar_activity_content).setId(16908290);
      if ((localView instanceof FrameLayout)) {
        ((FrameLayout)localView).setForeground(null);
      }
      if ((this.mTitleToSet != null) && (this.mDecorContentParent != null))
      {
        this.mDecorContentParent.setWindowTitle(this.mTitleToSet);
        this.mTitleToSet = null;
      }
      applyFixedSizeWindow();
      onSubDecorInstalled();
      this.mSubDecorInstalled = true;
      ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState = getPanelState(0, false);
      if ((!isDestroyed()) && ((localPanelFeatureState == null) || (localPanelFeatureState.menu == null))) {
        invalidatePanelMenu(8);
      }
      return;
      label311:
      localObject = this.mActivity;
      break;
      label319:
      if (this.mOverlayActionMode) {}
      for (this.mSubDecor = ((ViewGroup)LayoutInflater.from(this.mActivity).inflate(R.layout.abc_screen_simple_overlay_action_mode, null));; this.mSubDecor = ((ViewGroup)LayoutInflater.from(this.mActivity).inflate(R.layout.abc_screen_simple, null)))
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label397;
        }
        ViewCompat.setOnApplyWindowInsetsListener(this.mSubDecor, new ActionBarActivityDelegateBase.2(this));
        break;
      }
      label397:
      ((FitWindowsViewGroup)this.mSubDecor).setOnFitSystemWindowsListener(new ActionBarActivityDelegateBase.3(this));
    }
  }
  
  int getHomeAsUpIndicatorAttrId()
  {
    return R.attr.homeAsUpIndicator;
  }
  
  public boolean onBackPressed()
  {
    boolean bool = true;
    if (this.mActionMode != null) {
      this.mActionMode.finish();
    }
    for (;;)
    {
      return bool;
      ActionBar localActionBar = getSupportActionBar();
      if ((localActionBar == null) || (!localActionBar.collapseActionView())) {
        bool = false;
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((this.mHasActionBar) && (this.mSubDecorInstalled))
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.onConfigurationChanged(paramConfiguration);
      }
    }
  }
  
  public void onContentChanged() {}
  
  void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mWindowDecor = ((ViewGroup)this.mActivity.getWindow().getDecorView());
    ActionBar localActionBar;
    if (NavUtils.getParentActivityName(this.mActivity) != null)
    {
      localActionBar = peekSupportActionBar();
      if (localActionBar != null) {
        break label47;
      }
      this.mEnableDefaultActionBarUp = true;
    }
    for (;;)
    {
      return;
      label47:
      localActionBar.setDefaultDisplayHomeAsUpEnabled(true);
    }
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if (paramInt != 0) {}
    for (boolean bool = getWindowCallback().onCreatePanelMenu(paramInt, paramMenu);; bool = false) {
      return bool;
    }
  }
  
  public View onCreatePanelView(int paramInt)
  {
    ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState;
    if (this.mActionMode == null)
    {
      WindowCallback localWindowCallback = getWindowCallback();
      if (localWindowCallback != null)
      {
        localView = localWindowCallback.onCreatePanelView(paramInt);
        if ((localView == null) && (this.mToolbarListMenuPresenter == null))
        {
          localPanelFeatureState = getPanelState(paramInt, true);
          openPanel(localPanelFeatureState, null);
          if (!localPanelFeatureState.isOpen) {}
        }
      }
    }
    for (View localView = localPanelFeatureState.shownPanelView;; localView = null)
    {
      return localView;
      localView = null;
      break;
    }
  }
  
  boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return onKeyShortcut(paramInt, paramKeyEvent);
  }
  
  boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    int i = 1;
    if ((this.mPreparedPanel != null) && (performPanelShortcut(this.mPreparedPanel, paramKeyEvent.getKeyCode(), paramKeyEvent, i))) {
      if (this.mPreparedPanel != null) {
        this.mPreparedPanel.isHandled = i;
      }
    }
    for (;;)
    {
      return i;
      if (this.mPreparedPanel == null)
      {
        ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState = getPanelState(0, i);
        preparePanel(localPanelFeatureState, paramKeyEvent);
        boolean bool = performPanelShortcut(localPanelFeatureState, paramKeyEvent.getKeyCode(), paramKeyEvent, i);
        localPanelFeatureState.isPrepared = false;
        if (bool) {}
      }
      else
      {
        int j = 0;
      }
    }
  }
  
  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    WindowCallback localWindowCallback = getWindowCallback();
    ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState;
    if ((localWindowCallback != null) && (!isDestroyed()))
    {
      localPanelFeatureState = findMenuPanel(paramMenuBuilder.getRootMenu());
      if (localPanelFeatureState == null) {}
    }
    for (boolean bool = localWindowCallback.onMenuItemSelected(localPanelFeatureState.featureId, paramMenuItem);; bool = false) {
      return bool;
    }
  }
  
  public void onMenuModeChange(MenuBuilder paramMenuBuilder)
  {
    reopenMenu(paramMenuBuilder, true);
  }
  
  boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    boolean bool = true;
    if (paramInt == 8)
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.dispatchMenuVisibilityChanged(bool);
      }
    }
    for (;;)
    {
      return bool;
      bool = this.mActivity.superOnMenuOpened(paramInt, paramMenu);
    }
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState = getPanelState(paramInt, false);
    if (localPanelFeatureState != null) {
      closePanel(localPanelFeatureState, false);
    }
    if (paramInt == 8)
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.dispatchMenuVisibilityChanged(false);
      }
    }
    for (;;)
    {
      return;
      if (!isDestroyed()) {
        this.mActivity.superOnPanelClosed(paramInt, paramMenu);
      }
    }
  }
  
  public void onPostResume()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.setShowHideAnimationEnabled(true);
    }
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if (paramInt != 0) {}
    for (boolean bool = getWindowCallback().onPreparePanel(paramInt, paramView, paramMenu);; bool = false) {
      return bool;
    }
  }
  
  public void onStop()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.setShowHideAnimationEnabled(false);
    }
  }
  
  void onSubDecorInstalled() {}
  
  public void onTitleChanged(CharSequence paramCharSequence)
  {
    if (this.mDecorContentParent != null) {
      this.mDecorContentParent.setWindowTitle(paramCharSequence);
    }
    for (;;)
    {
      return;
      if (getSupportActionBar() != null) {
        getSupportActionBar().setWindowTitle(paramCharSequence);
      } else {
        this.mTitleToSet = paramCharSequence;
      }
    }
  }
  
  final boolean performPanelShortcut(ActionBarActivityDelegateBase.PanelFeatureState paramPanelFeatureState, int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    boolean bool = false;
    if (paramKeyEvent.isSystem()) {}
    for (;;)
    {
      return bool;
      if (((paramPanelFeatureState.isPrepared) || (preparePanel(paramPanelFeatureState, paramKeyEvent))) && (paramPanelFeatureState.menu != null)) {
        bool = paramPanelFeatureState.menu.performShortcut(paramInt1, paramKeyEvent, paramInt2);
      }
      if ((bool) && ((paramInt2 & 0x1) == 0) && (this.mDecorContentParent == null)) {
        closePanel(paramPanelFeatureState, true);
      }
    }
  }
  
  public void setContentView(int paramInt)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)this.mActivity.findViewById(16908290);
    localViewGroup.removeAllViews();
    this.mActivity.getLayoutInflater().inflate(paramInt, localViewGroup);
    this.mActivity.onSupportContentChanged();
  }
  
  public void setContentView(View paramView)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)this.mActivity.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    this.mActivity.onSupportContentChanged();
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)this.mActivity.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    this.mActivity.onSupportContentChanged();
  }
  
  void setSupportActionBar(Toolbar paramToolbar)
  {
    ActionBar localActionBar = getSupportActionBar();
    if ((localActionBar instanceof WindowDecorActionBar)) {
      throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }
    if ((localActionBar instanceof ToolbarActionBar)) {
      ((ToolbarActionBar)localActionBar).setListMenuPresenter(null);
    }
    ToolbarActionBar localToolbarActionBar = new ToolbarActionBar(paramToolbar, this.mActivity.getTitle(), this.mActivity.getWindow(), this.mDefaultWindowCallback);
    ensureToolbarListMenuPresenter();
    localToolbarActionBar.setListMenuPresenter(this.mToolbarListMenuPresenter);
    setSupportActionBar(localToolbarActionBar);
    setWindowCallback(localToolbarActionBar.getWrappedWindowCallback());
    localToolbarActionBar.invalidateOptionsMenu();
  }
  
  void setSupportProgress(int paramInt) {}
  
  void setSupportProgressBarIndeterminate(boolean paramBoolean) {}
  
  void setSupportProgressBarIndeterminateVisibility(boolean paramBoolean) {}
  
  void setSupportProgressBarVisibility(boolean paramBoolean) {}
  
  public ActionMode startSupportActionMode(ActionMode.Callback paramCallback)
  {
    if (paramCallback == null) {
      throw new IllegalArgumentException("ActionMode callback can not be null.");
    }
    if (this.mActionMode != null) {
      this.mActionMode.finish();
    }
    ActionBarActivityDelegateBase.ActionModeCallbackWrapper localActionModeCallbackWrapper = new ActionBarActivityDelegateBase.ActionModeCallbackWrapper(this, paramCallback);
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null)
    {
      this.mActionMode = localActionBar.startActionMode(localActionModeCallbackWrapper);
      if (this.mActionMode != null) {
        this.mActivity.onSupportActionModeStarted(this.mActionMode);
      }
    }
    if (this.mActionMode == null) {
      this.mActionMode = startSupportActionModeFromWindow(localActionModeCallbackWrapper);
    }
    return this.mActionMode;
  }
  
  ActionMode startSupportActionModeFromWindow(ActionMode.Callback paramCallback)
  {
    if (this.mActionMode != null) {
      this.mActionMode.finish();
    }
    ActionBarActivityDelegateBase.ActionModeCallbackWrapper localActionModeCallbackWrapper = new ActionBarActivityDelegateBase.ActionModeCallbackWrapper(this, paramCallback);
    Context localContext = getActionBarThemedContext();
    boolean bool;
    if (this.mActionModeView == null)
    {
      if (this.mIsFloating)
      {
        this.mActionModeView = new ActionBarContextView(localContext);
        this.mActionModePopup = new PopupWindow(localContext, null, R.attr.actionModePopupWindowStyle);
        this.mActionModePopup.setContentView(this.mActionModeView);
        this.mActionModePopup.setWidth(-1);
        TypedValue localTypedValue = new TypedValue();
        this.mActivity.getTheme().resolveAttribute(R.attr.actionBarSize, localTypedValue, true);
        int i = TypedValue.complexToDimensionPixelSize(localTypedValue.data, this.mActivity.getResources().getDisplayMetrics());
        this.mActionModeView.setContentHeight(i);
        this.mActionModePopup.setHeight(-2);
        this.mShowActionModePopup = new ActionBarActivityDelegateBase.4(this);
      }
    }
    else if (this.mActionModeView != null)
    {
      this.mActionModeView.killMode();
      ActionBarContextView localActionBarContextView = this.mActionModeView;
      if (this.mActionModePopup != null) {
        break label387;
      }
      bool = true;
      label197:
      StandaloneActionMode localStandaloneActionMode = new StandaloneActionMode(localContext, localActionBarContextView, localActionModeCallbackWrapper, bool);
      if (!paramCallback.onCreateActionMode(localStandaloneActionMode, localStandaloneActionMode.getMenu())) {
        break label393;
      }
      localStandaloneActionMode.invalidate();
      this.mActionModeView.initForMode(localStandaloneActionMode);
      this.mActionModeView.setVisibility(0);
      this.mActionMode = localStandaloneActionMode;
      if (this.mActionModePopup != null) {
        this.mActivity.getWindow().getDecorView().post(this.mShowActionModePopup);
      }
      this.mActionModeView.sendAccessibilityEvent(32);
      if (this.mActionModeView.getParent() != null) {
        ViewCompat.requestApplyInsets((View)this.mActionModeView.getParent());
      }
    }
    for (;;)
    {
      if ((this.mActionMode != null) && (this.mActivity != null)) {
        this.mActivity.onSupportActionModeStarted(this.mActionMode);
      }
      return this.mActionMode;
      ViewStubCompat localViewStubCompat = (ViewStubCompat)this.mActivity.findViewById(R.id.action_mode_bar_stub);
      if (localViewStubCompat == null) {
        break;
      }
      localViewStubCompat.setLayoutInflater(LayoutInflater.from(localContext));
      this.mActionModeView = ((ActionBarContextView)localViewStubCompat.inflate());
      break;
      label387:
      bool = false;
      break label197;
      label393:
      this.mActionMode = null;
    }
  }
  
  public void supportInvalidateOptionsMenu()
  {
    ActionBar localActionBar = getSupportActionBar();
    if ((localActionBar != null) && (localActionBar.invalidateOptionsMenu())) {}
    for (;;)
    {
      return;
      invalidatePanelMenu(0);
    }
  }
  
  public boolean supportRequestWindowFeature(int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 6: 
    case 7: 
    default: 
      bool = this.mActivity.requestWindowFeature(paramInt);
    }
    for (;;)
    {
      return bool;
      throwFeatureRequestIfSubDecorInstalled();
      this.mHasActionBar = bool;
      continue;
      throwFeatureRequestIfSubDecorInstalled();
      this.mOverlayActionBar = bool;
      continue;
      throwFeatureRequestIfSubDecorInstalled();
      this.mOverlayActionMode = bool;
      continue;
      throwFeatureRequestIfSubDecorInstalled();
      this.mFeatureProgress = bool;
      continue;
      throwFeatureRequestIfSubDecorInstalled();
      this.mFeatureIndeterminateProgress = bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegateBase
 * JD-Core Version:    0.7.0.1
 */