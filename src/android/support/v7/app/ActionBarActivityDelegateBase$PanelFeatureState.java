package android.support.v7.app;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.style;
import android.support.v7.internal.view.menu.ListMenuPresenter;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.view.menu.MenuView;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

final class ActionBarActivityDelegateBase$PanelFeatureState
{
  ViewGroup decorView;
  int featureId;
  Bundle frozenActionViewState;
  Bundle frozenMenuState;
  boolean isHandled;
  boolean isOpen;
  boolean isPrepared;
  ListMenuPresenter listMenuPresenter;
  Context listPresenterContext;
  MenuBuilder menu;
  public boolean qwertyMode;
  boolean refreshDecorView;
  boolean refreshMenuContent;
  View shownPanelView;
  boolean wasLastOpen;
  
  ActionBarActivityDelegateBase$PanelFeatureState(int paramInt)
  {
    this.featureId = paramInt;
    this.refreshDecorView = false;
  }
  
  void applyFrozenState()
  {
    if ((this.menu != null) && (this.frozenMenuState != null))
    {
      this.menu.restorePresenterStates(this.frozenMenuState);
      this.frozenMenuState = null;
    }
  }
  
  public void clearMenuPresenters()
  {
    if (this.menu != null) {
      this.menu.removeMenuPresenter(this.listMenuPresenter);
    }
    this.listMenuPresenter = null;
  }
  
  MenuView getListMenuView(MenuPresenter.Callback paramCallback)
  {
    if (this.menu == null) {}
    for (MenuView localMenuView = null;; localMenuView = this.listMenuPresenter.getMenuView(this.decorView))
    {
      return localMenuView;
      if (this.listMenuPresenter == null)
      {
        this.listMenuPresenter = new ListMenuPresenter(this.listPresenterContext, R.layout.abc_list_menu_item_layout);
        this.listMenuPresenter.setCallback(paramCallback);
        this.menu.addMenuPresenter(this.listMenuPresenter);
      }
    }
  }
  
  public boolean hasPanelItems()
  {
    boolean bool = false;
    if (this.shownPanelView == null) {}
    for (;;)
    {
      return bool;
      if (this.listMenuPresenter.getAdapter().getCount() > 0) {
        bool = true;
      }
    }
  }
  
  void onRestoreInstanceState(Parcelable paramParcelable)
  {
    ActionBarActivityDelegateBase.PanelFeatureState.SavedState localSavedState = (ActionBarActivityDelegateBase.PanelFeatureState.SavedState)paramParcelable;
    this.featureId = localSavedState.featureId;
    this.wasLastOpen = localSavedState.isOpen;
    this.frozenMenuState = localSavedState.menuState;
    this.shownPanelView = null;
    this.decorView = null;
  }
  
  Parcelable onSaveInstanceState()
  {
    ActionBarActivityDelegateBase.PanelFeatureState.SavedState localSavedState = new ActionBarActivityDelegateBase.PanelFeatureState.SavedState(null);
    localSavedState.featureId = this.featureId;
    localSavedState.isOpen = this.isOpen;
    if (this.menu != null)
    {
      localSavedState.menuState = new Bundle();
      this.menu.savePresenterStates(localSavedState.menuState);
    }
    return localSavedState;
  }
  
  void setMenu(MenuBuilder paramMenuBuilder)
  {
    if (paramMenuBuilder == this.menu) {}
    for (;;)
    {
      return;
      if (this.menu != null) {
        this.menu.removeMenuPresenter(this.listMenuPresenter);
      }
      this.menu = paramMenuBuilder;
      if ((paramMenuBuilder != null) && (this.listMenuPresenter != null)) {
        paramMenuBuilder.addMenuPresenter(this.listMenuPresenter);
      }
    }
  }
  
  void setStyle(Context paramContext)
  {
    TypedValue localTypedValue = new TypedValue();
    Resources.Theme localTheme = paramContext.getResources().newTheme();
    localTheme.setTo(paramContext.getTheme());
    localTheme.resolveAttribute(R.attr.actionBarPopupTheme, localTypedValue, true);
    if (localTypedValue.resourceId != 0) {
      localTheme.applyStyle(localTypedValue.resourceId, true);
    }
    localTheme.resolveAttribute(R.attr.panelMenuListTheme, localTypedValue, true);
    if (localTypedValue.resourceId != 0) {
      localTheme.applyStyle(localTypedValue.resourceId, true);
    }
    for (;;)
    {
      ContextThemeWrapper localContextThemeWrapper = new ContextThemeWrapper(paramContext, 0);
      localContextThemeWrapper.getTheme().setTo(localTheme);
      this.listPresenterContext = localContextThemeWrapper;
      return;
      localTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegateBase.PanelFeatureState
 * JD-Core Version:    0.7.0.1
 */