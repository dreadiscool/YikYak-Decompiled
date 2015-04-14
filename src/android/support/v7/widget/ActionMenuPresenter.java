package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ActionProvider.SubUiVisibilityListener;
import android.support.v7.appcompat.R.integer;
import android.support.v7.appcompat.R.layout;
import android.support.v7.internal.transition.ActionBarTransition;
import android.support.v7.internal.view.ActionBarPolicy;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.internal.view.menu.BaseMenuPresenter;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuPopupHelper;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.view.menu.MenuView.ItemView;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

public class ActionMenuPresenter
  extends BaseMenuPresenter
  implements ActionProvider.SubUiVisibilityListener
{
  private static final String TAG = "ActionMenuPresenter";
  private final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
  private ActionMenuPresenter.ActionButtonSubmenu mActionButtonPopup;
  private int mActionItemWidthLimit;
  private boolean mExpandedActionViewsExclusive;
  private int mMaxItems;
  private boolean mMaxItemsSet;
  private int mMinCellSize;
  int mOpenSubMenuId;
  private View mOverflowButton;
  private ActionMenuPresenter.OverflowPopup mOverflowPopup;
  private ActionMenuPresenter.ActionMenuPopupCallback mPopupCallback;
  final ActionMenuPresenter.PopupPresenterCallback mPopupPresenterCallback = new ActionMenuPresenter.PopupPresenterCallback(this, null);
  private ActionMenuPresenter.OpenOverflowRunnable mPostedOpenRunnable;
  private boolean mReserveOverflow;
  private boolean mReserveOverflowSet;
  private View mScrapActionButtonView;
  private boolean mStrictWidthLimit;
  private int mWidthLimit;
  private boolean mWidthLimitSet;
  
  public ActionMenuPresenter(Context paramContext)
  {
    super(paramContext, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
  }
  
  private View findViewForItem(MenuItem paramMenuItem)
  {
    ViewGroup localViewGroup = (ViewGroup)this.mMenuView;
    if (localViewGroup == null) {}
    label68:
    for (View localView = null;; localView = null)
    {
      return localView;
      int i = localViewGroup.getChildCount();
      for (int j = 0;; j++)
      {
        if (j >= i) {
          break label68;
        }
        localView = localViewGroup.getChildAt(j);
        if (((localView instanceof MenuView.ItemView)) && (((MenuView.ItemView)localView).getItemData() == paramMenuItem)) {
          break;
        }
      }
    }
  }
  
  public void bindItemView(MenuItemImpl paramMenuItemImpl, MenuView.ItemView paramItemView)
  {
    paramItemView.initialize(paramMenuItemImpl, 0);
    ActionMenuView localActionMenuView = (ActionMenuView)this.mMenuView;
    ActionMenuItemView localActionMenuItemView = (ActionMenuItemView)paramItemView;
    localActionMenuItemView.setItemInvoker(localActionMenuView);
    if (this.mPopupCallback == null) {
      this.mPopupCallback = new ActionMenuPresenter.ActionMenuPopupCallback(this, null);
    }
    localActionMenuItemView.setPopupCallback(this.mPopupCallback);
  }
  
  public boolean dismissPopupMenus()
  {
    return hideOverflowMenu() | hideSubMenus();
  }
  
  public boolean filterLeftoverView(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramViewGroup.getChildAt(paramInt) == this.mOverflowButton) {}
    for (boolean bool = false;; bool = super.filterLeftoverView(paramViewGroup, paramInt)) {
      return bool;
    }
  }
  
  public boolean flagActionItems()
  {
    ArrayList localArrayList = this.mMenu.getVisibleItems();
    int i = localArrayList.size();
    int j = this.mMaxItems;
    int k = this.mActionItemWidthLimit;
    int m = View.MeasureSpec.makeMeasureSpec(0, 0);
    ViewGroup localViewGroup = (ViewGroup)this.mMenuView;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    MenuItemImpl localMenuItemImpl3;
    if (i3 < i)
    {
      localMenuItemImpl3 = (MenuItemImpl)localArrayList.get(i3);
      if (localMenuItemImpl3.requiresActionButton())
      {
        n++;
        label80:
        if ((!this.mExpandedActionViewsExclusive) || (!localMenuItemImpl3.isActionViewExpanded())) {
          break label830;
        }
      }
    }
    label294:
    label431:
    label817:
    label830:
    for (int i31 = 0;; i31 = j)
    {
      i3++;
      j = i31;
      break;
      if (localMenuItemImpl3.requestsActionButton())
      {
        i1++;
        break label80;
      }
      i2 = 1;
      break label80;
      if ((this.mReserveOverflow) && ((i2 != 0) || (n + i1 > j))) {
        j--;
      }
      int i4 = j - n;
      SparseBooleanArray localSparseBooleanArray = this.mActionButtonGroups;
      localSparseBooleanArray.clear();
      int i5 = 0;
      int i30;
      if (this.mStrictWidthLimit)
      {
        i5 = k / this.mMinCellSize;
        i30 = k % this.mMinCellSize;
      }
      for (int i6 = this.mMinCellSize + i30 / i5;; i6 = 0)
      {
        int i7 = 0;
        int i8 = 0;
        int i9 = i5;
        MenuItemImpl localMenuItemImpl1;
        View localView2;
        int i10;
        int i28;
        if (i7 < i)
        {
          localMenuItemImpl1 = (MenuItemImpl)localArrayList.get(i7);
          if (localMenuItemImpl1.requiresActionButton())
          {
            localView2 = getItemView(localMenuItemImpl1, this.mScrapActionButtonView, localViewGroup);
            if (this.mScrapActionButtonView == null) {
              this.mScrapActionButtonView = localView2;
            }
            if (this.mStrictWidthLimit)
            {
              i9 -= ActionMenuView.measureChildForCells(localView2, i6, i9, m, 0);
              i10 = localView2.getMeasuredWidth();
              i28 = k - i10;
              if (i8 != 0) {
                break label817;
              }
            }
          }
        }
        for (;;)
        {
          int i29 = localMenuItemImpl1.getGroupId();
          if (i29 != 0) {
            localSparseBooleanArray.put(i29, true);
          }
          localMenuItemImpl1.setIsActionButton(true);
          int i11 = i28;
          int i12 = i4;
          i7++;
          k = i11;
          i4 = i12;
          i8 = i10;
          break;
          localView2.measure(m, m);
          break label294;
          int i13;
          boolean bool1;
          boolean bool2;
          View localView1;
          int i22;
          label499:
          int i21;
          label503:
          int i25;
          boolean bool3;
          int i14;
          int i15;
          if (localMenuItemImpl1.requestsActionButton())
          {
            i13 = localMenuItemImpl1.getGroupId();
            bool1 = localSparseBooleanArray.get(i13);
            if (((i4 > 0) || (bool1)) && (k > 0) && ((!this.mStrictWidthLimit) || (i9 > 0)))
            {
              bool2 = true;
              if (!bool2) {
                break label802;
              }
              localView1 = getItemView(localMenuItemImpl1, this.mScrapActionButtonView, localViewGroup);
              if (this.mScrapActionButtonView == null) {
                this.mScrapActionButtonView = localView1;
              }
              if (!this.mStrictWidthLimit) {
                break label622;
              }
              int i26 = ActionMenuView.measureChildForCells(localView1, i6, i9, m, 0);
              int i27 = i9 - i26;
              if (i26 != 0) {
                break label795;
              }
              i22 = 0;
              i21 = i27;
              int i23 = localView1.getMeasuredWidth();
              k -= i23;
              if (i8 == 0) {
                i8 = i23;
              }
              if (!this.mStrictWidthLimit) {
                break label652;
              }
              if (k < 0) {
                break label646;
              }
              i25 = 1;
              bool3 = i22 & i25;
              i14 = i8;
              i15 = i21;
            }
          }
          for (;;)
          {
            int i16;
            if ((bool3) && (i13 != 0))
            {
              localSparseBooleanArray.put(i13, true);
              i16 = i4;
            }
            for (;;)
            {
              if (bool3) {
                i16--;
              }
              localMenuItemImpl1.setIsActionButton(bool3);
              i10 = i14;
              i11 = k;
              int i17 = i15;
              i12 = i16;
              i9 = i17;
              break;
              bool2 = false;
              break label431;
              label622:
              localView1.measure(m, m);
              int i20 = bool2;
              i21 = i9;
              i22 = i20;
              break label503;
              i25 = 0;
              break label541;
              if (k + i8 > 0) {}
              for (int i24 = 1;; i24 = 0)
              {
                bool3 = i22 & i24;
                i14 = i8;
                i15 = i21;
                break;
              }
              if (bool1)
              {
                localSparseBooleanArray.put(i13, false);
                int i18 = i4;
                int i19 = 0;
                for (;;)
                {
                  if (i19 < i7)
                  {
                    MenuItemImpl localMenuItemImpl2 = (MenuItemImpl)localArrayList.get(i19);
                    if (localMenuItemImpl2.getGroupId() == i13)
                    {
                      if (localMenuItemImpl2.isActionButton()) {
                        i18++;
                      }
                      localMenuItemImpl2.setIsActionButton(false);
                    }
                    i19++;
                    continue;
                    localMenuItemImpl1.setIsActionButton(false);
                    i10 = i8;
                    i11 = k;
                    i12 = i4;
                    break;
                    return true;
                  }
                }
                i16 = i18;
              }
              else
              {
                i16 = i4;
              }
            }
            i22 = bool2;
            break label499;
            bool3 = bool2;
            i14 = i8;
            i15 = i9;
          }
          i10 = i8;
        }
      }
    }
  }
  
  public View getItemView(MenuItemImpl paramMenuItemImpl, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramMenuItemImpl.getActionView();
    if ((localView == null) || (paramMenuItemImpl.hasCollapsibleActionView())) {
      localView = super.getItemView(paramMenuItemImpl, paramView, paramViewGroup);
    }
    if (paramMenuItemImpl.isActionViewExpanded()) {}
    for (int i = 8;; i = 0)
    {
      localView.setVisibility(i);
      ActionMenuView localActionMenuView = (ActionMenuView)paramViewGroup;
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      if (!localActionMenuView.checkLayoutParams(localLayoutParams)) {
        localView.setLayoutParams(localActionMenuView.generateLayoutParams(localLayoutParams));
      }
      return localView;
    }
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    MenuView localMenuView = super.getMenuView(paramViewGroup);
    ((ActionMenuView)localMenuView).setPresenter(this);
    return localMenuView;
  }
  
  public boolean hideOverflowMenu()
  {
    boolean bool;
    if ((this.mPostedOpenRunnable != null) && (this.mMenuView != null))
    {
      ((View)this.mMenuView).removeCallbacks(this.mPostedOpenRunnable);
      this.mPostedOpenRunnable = null;
      bool = true;
    }
    for (;;)
    {
      return bool;
      ActionMenuPresenter.OverflowPopup localOverflowPopup = this.mOverflowPopup;
      if (localOverflowPopup != null)
      {
        localOverflowPopup.dismiss();
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public boolean hideSubMenus()
  {
    if (this.mActionButtonPopup != null) {
      this.mActionButtonPopup.dismiss();
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    super.initForMenu(paramContext, paramMenuBuilder);
    Resources localResources = paramContext.getResources();
    ActionBarPolicy localActionBarPolicy = ActionBarPolicy.get(paramContext);
    if (!this.mReserveOverflowSet) {
      this.mReserveOverflow = localActionBarPolicy.showsOverflowMenuButton();
    }
    if (!this.mWidthLimitSet) {
      this.mWidthLimit = localActionBarPolicy.getEmbeddedMenuWidthLimit();
    }
    if (!this.mMaxItemsSet) {
      this.mMaxItems = localActionBarPolicy.getMaxActionButtons();
    }
    int i = this.mWidthLimit;
    if (this.mReserveOverflow)
    {
      if (this.mOverflowButton == null)
      {
        this.mOverflowButton = new ActionMenuPresenter.OverflowMenuButton(this, this.mSystemContext);
        int j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mOverflowButton.measure(j, j);
      }
      i -= this.mOverflowButton.getMeasuredWidth();
    }
    for (;;)
    {
      this.mActionItemWidthLimit = i;
      this.mMinCellSize = ((int)(56.0F * localResources.getDisplayMetrics().density));
      this.mScrapActionButtonView = null;
      return;
      this.mOverflowButton = null;
    }
  }
  
  public boolean isOverflowMenuShowPending()
  {
    if ((this.mPostedOpenRunnable != null) || (isOverflowMenuShowing())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isOverflowMenuShowing()
  {
    if ((this.mOverflowPopup != null) && (this.mOverflowPopup.isShowing())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isOverflowReserved()
  {
    return this.mReserveOverflow;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    dismissPopupMenus();
    super.onCloseMenu(paramMenuBuilder, paramBoolean);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (!this.mMaxItemsSet) {
      this.mMaxItems = this.mContext.getResources().getInteger(R.integer.abc_max_action_buttons);
    }
    if (this.mMenu != null) {
      this.mMenu.onItemsChanged(true);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    ActionMenuPresenter.SavedState localSavedState = (ActionMenuPresenter.SavedState)paramParcelable;
    if (localSavedState.openSubMenuId > 0)
    {
      MenuItem localMenuItem = this.mMenu.findItem(localSavedState.openSubMenuId);
      if (localMenuItem != null) {
        onSubMenuSelected((SubMenuBuilder)localMenuItem.getSubMenu());
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    ActionMenuPresenter.SavedState localSavedState = new ActionMenuPresenter.SavedState();
    localSavedState.openSubMenuId = this.mOpenSubMenuId;
    return localSavedState;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    boolean bool;
    if (!paramSubMenuBuilder.hasVisibleItems()) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      for (SubMenuBuilder localSubMenuBuilder = paramSubMenuBuilder; localSubMenuBuilder.getParentMenu() != this.mMenu; localSubMenuBuilder = (SubMenuBuilder)localSubMenuBuilder.getParentMenu()) {}
      View localView = findViewForItem(localSubMenuBuilder.getItem());
      if (localView == null)
      {
        if (this.mOverflowButton == null) {
          bool = false;
        } else {
          localView = this.mOverflowButton;
        }
      }
      else
      {
        this.mOpenSubMenuId = paramSubMenuBuilder.getItem().getItemId();
        this.mActionButtonPopup = new ActionMenuPresenter.ActionButtonSubmenu(this, this.mContext, paramSubMenuBuilder);
        this.mActionButtonPopup.setAnchorView(localView);
        this.mActionButtonPopup.show();
        super.onSubMenuSelected(paramSubMenuBuilder);
        bool = true;
      }
    }
  }
  
  public void onSubUiVisibilityChanged(boolean paramBoolean)
  {
    if (paramBoolean) {
      super.onSubMenuSelected(null);
    }
    for (;;)
    {
      return;
      this.mMenu.close(false);
    }
  }
  
  public void setExpandedActionViewsExclusive(boolean paramBoolean)
  {
    this.mExpandedActionViewsExclusive = paramBoolean;
  }
  
  public void setItemLimit(int paramInt)
  {
    this.mMaxItems = paramInt;
    this.mMaxItemsSet = true;
  }
  
  public void setMenuView(ActionMenuView paramActionMenuView)
  {
    this.mMenuView = paramActionMenuView;
    paramActionMenuView.initialize(this.mMenu);
  }
  
  public void setReserveOverflow(boolean paramBoolean)
  {
    this.mReserveOverflow = paramBoolean;
    this.mReserveOverflowSet = true;
  }
  
  public void setWidthLimit(int paramInt, boolean paramBoolean)
  {
    this.mWidthLimit = paramInt;
    this.mStrictWidthLimit = paramBoolean;
    this.mWidthLimitSet = true;
  }
  
  public boolean shouldIncludeItem(int paramInt, MenuItemImpl paramMenuItemImpl)
  {
    return paramMenuItemImpl.isActionButton();
  }
  
  public boolean showOverflowMenu()
  {
    boolean bool = true;
    if ((this.mReserveOverflow) && (!isOverflowMenuShowing()) && (this.mMenu != null) && (this.mMenuView != null) && (this.mPostedOpenRunnable == null) && (!this.mMenu.getNonActionItems().isEmpty()))
    {
      this.mPostedOpenRunnable = new ActionMenuPresenter.OpenOverflowRunnable(this, new ActionMenuPresenter.OverflowPopup(this, this.mContext, this.mMenu, this.mOverflowButton, bool));
      ((View)this.mMenuView).post(this.mPostedOpenRunnable);
      super.onSubMenuSelected(null);
    }
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    int i = 1;
    int j = 0;
    ViewGroup localViewGroup1 = (ViewGroup)((View)this.mMenuView).getParent();
    if (localViewGroup1 != null) {
      ActionBarTransition.beginDelayedTransition(localViewGroup1);
    }
    super.updateMenuView(paramBoolean);
    ((View)this.mMenuView).requestLayout();
    if (this.mMenu != null)
    {
      ArrayList localArrayList2 = this.mMenu.getActionItems();
      int n = localArrayList2.size();
      for (int i1 = 0; i1 < n; i1++)
      {
        ActionProvider localActionProvider = ((MenuItemImpl)localArrayList2.get(i1)).getSupportActionProvider();
        if (localActionProvider != null) {
          localActionProvider.setSubUiVisibilityListener(this);
        }
      }
    }
    ArrayList localArrayList1;
    int k;
    int m;
    if (this.mMenu != null)
    {
      localArrayList1 = this.mMenu.getNonActionItems();
      if ((this.mReserveOverflow) && (localArrayList1 != null))
      {
        k = localArrayList1.size();
        if (k != i) {
          break label283;
        }
        if (((MenuItemImpl)localArrayList1.get(0)).isActionViewExpanded()) {
          break label277;
        }
        m = i;
        label168:
        j = m;
      }
      if (j == 0) {
        break label298;
      }
      if (this.mOverflowButton == null) {
        this.mOverflowButton = new ActionMenuPresenter.OverflowMenuButton(this, this.mSystemContext);
      }
      ViewGroup localViewGroup2 = (ViewGroup)this.mOverflowButton.getParent();
      if (localViewGroup2 != this.mMenuView)
      {
        if (localViewGroup2 != null) {
          localViewGroup2.removeView(this.mOverflowButton);
        }
        ActionMenuView localActionMenuView = (ActionMenuView)this.mMenuView;
        localActionMenuView.addView(this.mOverflowButton, localActionMenuView.generateOverflowButtonLayoutParams());
      }
    }
    for (;;)
    {
      ((ActionMenuView)this.mMenuView).setOverflowReserved(this.mReserveOverflow);
      return;
      localArrayList1 = null;
      break;
      label277:
      m = 0;
      break label168;
      label283:
      if (k > 0) {}
      for (;;)
      {
        j = i;
        break;
        i = 0;
      }
      label298:
      if ((this.mOverflowButton != null) && (this.mOverflowButton.getParent() == this.mMenuView)) {
        ((ViewGroup)this.mMenuView).removeView(this.mOverflowButton);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter
 * JD-Core Version:    0.7.0.1
 */