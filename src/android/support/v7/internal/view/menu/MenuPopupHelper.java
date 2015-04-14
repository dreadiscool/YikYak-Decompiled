package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.dimen;
import android.support.v7.appcompat.R.layout;
import android.support.v7.widget.ListPopupWindow;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;

public class MenuPopupHelper
  implements MenuPresenter, View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  static final int ITEM_LAYOUT = R.layout.abc_popup_menu_item_layout;
  private static final String TAG = "MenuPopupHelper";
  private final MenuPopupHelper.MenuAdapter mAdapter;
  private View mAnchorView;
  private int mContentWidth;
  private final Context mContext;
  private int mDropDownGravity = 0;
  boolean mForceShowIcon;
  private boolean mHasContentWidth;
  private final LayoutInflater mInflater;
  private ViewGroup mMeasureParent;
  private final MenuBuilder mMenu;
  private final boolean mOverflowOnly;
  private ListPopupWindow mPopup;
  private final int mPopupMaxWidth;
  private final int mPopupStyleAttr;
  private final int mPopupStyleRes;
  private MenuPresenter.Callback mPresenterCallback;
  private ViewTreeObserver mTreeObserver;
  
  public MenuPopupHelper(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    this(paramContext, paramMenuBuilder, null, false, R.attr.popupMenuStyle);
  }
  
  public MenuPopupHelper(Context paramContext, MenuBuilder paramMenuBuilder, View paramView)
  {
    this(paramContext, paramMenuBuilder, paramView, false, R.attr.popupMenuStyle);
  }
  
  public MenuPopupHelper(Context paramContext, MenuBuilder paramMenuBuilder, View paramView, boolean paramBoolean, int paramInt)
  {
    this(paramContext, paramMenuBuilder, paramView, paramBoolean, paramInt, 0);
  }
  
  public MenuPopupHelper(Context paramContext, MenuBuilder paramMenuBuilder, View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.mMenu = paramMenuBuilder;
    this.mAdapter = new MenuPopupHelper.MenuAdapter(this, this.mMenu);
    this.mOverflowOnly = paramBoolean;
    this.mPopupStyleAttr = paramInt1;
    this.mPopupStyleRes = paramInt2;
    Resources localResources = paramContext.getResources();
    this.mPopupMaxWidth = Math.max(localResources.getDisplayMetrics().widthPixels / 2, localResources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    this.mAnchorView = paramView;
    paramMenuBuilder.addMenuPresenter(this, paramContext);
  }
  
  private int measureContentWidth()
  {
    MenuPopupHelper.MenuAdapter localMenuAdapter = this.mAdapter;
    int i = View.MeasureSpec.makeMeasureSpec(0, 0);
    int j = View.MeasureSpec.makeMeasureSpec(0, 0);
    int k = localMenuAdapter.getCount();
    int m = 0;
    int n = 0;
    View localView1 = null;
    int i1 = 0;
    View localView2;
    label68:
    int i3;
    if (m < k)
    {
      int i2 = localMenuAdapter.getItemViewType(m);
      if (i2 == n) {
        break label155;
      }
      n = i2;
      localView2 = null;
      if (this.mMeasureParent == null) {
        this.mMeasureParent = new FrameLayout(this.mContext);
      }
      localView1 = localMenuAdapter.getView(m, localView2, this.mMeasureParent);
      localView1.measure(i, j);
      i3 = localView1.getMeasuredWidth();
      if (i3 >= this.mPopupMaxWidth) {
        i1 = this.mPopupMaxWidth;
      }
    }
    else
    {
      return i1;
    }
    if (i3 > i1) {}
    for (;;)
    {
      m++;
      i1 = i3;
      break;
      label155:
      localView2 = localView1;
      break label68;
      i3 = i1;
    }
  }
  
  public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public void dismiss()
  {
    if (isShowing()) {
      this.mPopup.dismiss();
    }
  }
  
  public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public int getId()
  {
    return 0;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    throw new UnsupportedOperationException("MenuPopupHelpers manage their own views");
  }
  
  public ListPopupWindow getPopup()
  {
    return this.mPopup;
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder) {}
  
  public boolean isShowing()
  {
    if ((this.mPopup != null) && (this.mPopup.isShowing())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (paramMenuBuilder != this.mMenu) {}
    for (;;)
    {
      return;
      dismiss();
      if (this.mPresenterCallback != null) {
        this.mPresenterCallback.onCloseMenu(paramMenuBuilder, paramBoolean);
      }
    }
  }
  
  public void onDismiss()
  {
    this.mPopup = null;
    this.mMenu.close();
    if (this.mTreeObserver != null)
    {
      if (!this.mTreeObserver.isAlive()) {
        this.mTreeObserver = this.mAnchorView.getViewTreeObserver();
      }
      this.mTreeObserver.removeGlobalOnLayoutListener(this);
      this.mTreeObserver = null;
    }
  }
  
  public void onGlobalLayout()
  {
    if (isShowing())
    {
      View localView = this.mAnchorView;
      if ((localView != null) && (localView.isShown())) {
        break label28;
      }
      dismiss();
    }
    for (;;)
    {
      return;
      label28:
      if (isShowing()) {
        this.mPopup.show();
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    MenuPopupHelper.MenuAdapter localMenuAdapter = this.mAdapter;
    MenuPopupHelper.MenuAdapter.access$000(localMenuAdapter).performItemAction(localMenuAdapter.getItem(paramInt), 0);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    int i = 1;
    if ((paramKeyEvent.getAction() == i) && (paramInt == 82)) {
      dismiss();
    }
    for (;;)
    {
      return i;
      int j = 0;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    boolean bool1 = true;
    MenuPopupHelper localMenuPopupHelper;
    int j;
    if (paramSubMenuBuilder.hasVisibleItems())
    {
      localMenuPopupHelper = new MenuPopupHelper(this.mContext, paramSubMenuBuilder, this.mAnchorView);
      localMenuPopupHelper.setCallback(this.mPresenterCallback);
      int i = paramSubMenuBuilder.size();
      j = 0;
      if (j >= i) {
        break label125;
      }
      MenuItem localMenuItem = paramSubMenuBuilder.getItem(j);
      if ((!localMenuItem.isVisible()) || (localMenuItem.getIcon() == null)) {}
    }
    label125:
    for (boolean bool2 = bool1;; bool2 = false)
    {
      localMenuPopupHelper.setForceShowIcon(bool2);
      if (localMenuPopupHelper.tryShow()) {
        if (this.mPresenterCallback != null) {
          this.mPresenterCallback.onOpenSubMenu(paramSubMenuBuilder);
        }
      }
      for (;;)
      {
        return bool1;
        j++;
        break;
        bool1 = false;
      }
    }
  }
  
  public void setAnchorView(View paramView)
  {
    this.mAnchorView = paramView;
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback)
  {
    this.mPresenterCallback = paramCallback;
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.mForceShowIcon = paramBoolean;
  }
  
  public void setGravity(int paramInt)
  {
    this.mDropDownGravity = paramInt;
  }
  
  public void show()
  {
    if (!tryShow()) {
      throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }
  }
  
  public boolean tryShow()
  {
    int i = 0;
    boolean bool = true;
    this.mPopup = new ListPopupWindow(this.mContext, null, this.mPopupStyleAttr, this.mPopupStyleRes);
    this.mPopup.setOnDismissListener(this);
    this.mPopup.setOnItemClickListener(this);
    this.mPopup.setAdapter(this.mAdapter);
    this.mPopup.setModal(bool);
    View localView = this.mAnchorView;
    if (localView != null)
    {
      if (this.mTreeObserver == null) {
        i = bool;
      }
      this.mTreeObserver = localView.getViewTreeObserver();
      if (i != 0) {
        this.mTreeObserver.addOnGlobalLayoutListener(this);
      }
      this.mPopup.setAnchorView(localView);
      this.mPopup.setDropDownGravity(this.mDropDownGravity);
      if (!this.mHasContentWidth)
      {
        this.mContentWidth = measureContentWidth();
        this.mHasContentWidth = bool;
      }
      this.mPopup.setContentWidth(this.mContentWidth);
      this.mPopup.setInputMethodMode(2);
      this.mPopup.show();
      this.mPopup.getListView().setOnKeyListener(this);
    }
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    this.mHasContentWidth = false;
    if (this.mAdapter != null) {
      this.mAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuPopupHelper
 * JD-Core Version:    0.7.0.1
 */