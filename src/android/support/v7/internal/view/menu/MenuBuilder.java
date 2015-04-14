package android.support.v7.internal.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.appcompat.R.bool;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MenuBuilder
  implements SupportMenu
{
  private static final String ACTION_VIEW_STATES_KEY = "android:menu:actionviewstates";
  private static final String EXPANDED_ACTION_VIEW_ID = "android:menu:expandedactionview";
  private static final String PRESENTER_KEY = "android:menu:presenters";
  private static final String TAG = "MenuBuilder";
  private static final int[] sCategoryToOrder;
  private ArrayList<MenuItemImpl> mActionItems;
  private MenuBuilder.Callback mCallback;
  private final Context mContext;
  private ContextMenu.ContextMenuInfo mCurrentMenuInfo;
  private int mDefaultShowAsAction = 0;
  private MenuItemImpl mExpandedItem;
  private SparseArray<Parcelable> mFrozenViewStates;
  Drawable mHeaderIcon;
  CharSequence mHeaderTitle;
  View mHeaderView;
  private boolean mIsActionItemsStale;
  private boolean mIsClosing = false;
  private boolean mIsVisibleItemsStale;
  private ArrayList<MenuItemImpl> mItems;
  private boolean mItemsChangedWhileDispatchPrevented = false;
  private ArrayList<MenuItemImpl> mNonActionItems;
  private boolean mOptionalIconsVisible = false;
  private CopyOnWriteArrayList<WeakReference<MenuPresenter>> mPresenters = new CopyOnWriteArrayList();
  private boolean mPreventDispatchingItemsChanged = false;
  private boolean mQwertyMode;
  private final Resources mResources;
  private boolean mShortcutsVisible;
  private ArrayList<MenuItemImpl> mTempShortcutItemList = new ArrayList();
  private ArrayList<MenuItemImpl> mVisibleItems;
  
  static
  {
    int[] arrayOfInt = new int[6];
    arrayOfInt[0] = 1;
    arrayOfInt[1] = 4;
    arrayOfInt[2] = 5;
    arrayOfInt[3] = 3;
    arrayOfInt[4] = 2;
    arrayOfInt[5] = 0;
    sCategoryToOrder = arrayOfInt;
  }
  
  public MenuBuilder(Context paramContext)
  {
    this.mContext = paramContext;
    this.mResources = paramContext.getResources();
    this.mItems = new ArrayList();
    this.mVisibleItems = new ArrayList();
    this.mIsVisibleItemsStale = true;
    this.mActionItems = new ArrayList();
    this.mNonActionItems = new ArrayList();
    this.mIsActionItemsStale = true;
    setShortcutsVisibleInner(true);
  }
  
  private MenuItem addInternal(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    int i = getOrdering(paramInt3);
    MenuItemImpl localMenuItemImpl = createNewMenuItem(paramInt1, paramInt2, paramInt3, i, paramCharSequence, this.mDefaultShowAsAction);
    if (this.mCurrentMenuInfo != null) {
      localMenuItemImpl.setMenuInfo(this.mCurrentMenuInfo);
    }
    this.mItems.add(findInsertIndex(this.mItems, i), localMenuItemImpl);
    onItemsChanged(true);
    return localMenuItemImpl;
  }
  
  private MenuItemImpl createNewMenuItem(int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5)
  {
    return new MenuItemImpl(this, paramInt1, paramInt2, paramInt3, paramInt4, paramCharSequence, paramInt5);
  }
  
  private void dispatchPresenterUpdate(boolean paramBoolean)
  {
    if (this.mPresenters.isEmpty()) {}
    for (;;)
    {
      return;
      stopDispatchingItemsChanged();
      Iterator localIterator = this.mPresenters.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        MenuPresenter localMenuPresenter = (MenuPresenter)localWeakReference.get();
        if (localMenuPresenter == null) {
          this.mPresenters.remove(localWeakReference);
        } else {
          localMenuPresenter.updateMenuView(paramBoolean);
        }
      }
      startDispatchingItemsChanged();
    }
  }
  
  private void dispatchRestoreInstanceState(Bundle paramBundle)
  {
    SparseArray localSparseArray = paramBundle.getSparseParcelableArray("android:menu:presenters");
    if ((localSparseArray == null) || (this.mPresenters.isEmpty())) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.mPresenters.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        MenuPresenter localMenuPresenter = (MenuPresenter)localWeakReference.get();
        if (localMenuPresenter == null)
        {
          this.mPresenters.remove(localWeakReference);
        }
        else
        {
          int i = localMenuPresenter.getId();
          if (i > 0)
          {
            Parcelable localParcelable = (Parcelable)localSparseArray.get(i);
            if (localParcelable != null) {
              localMenuPresenter.onRestoreInstanceState(localParcelable);
            }
          }
        }
      }
    }
  }
  
  private void dispatchSaveInstanceState(Bundle paramBundle)
  {
    if (this.mPresenters.isEmpty()) {}
    for (;;)
    {
      return;
      SparseArray localSparseArray = new SparseArray();
      Iterator localIterator = this.mPresenters.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        MenuPresenter localMenuPresenter = (MenuPresenter)localWeakReference.get();
        if (localMenuPresenter == null)
        {
          this.mPresenters.remove(localWeakReference);
        }
        else
        {
          int i = localMenuPresenter.getId();
          if (i > 0)
          {
            Parcelable localParcelable = localMenuPresenter.onSaveInstanceState();
            if (localParcelable != null) {
              localSparseArray.put(i, localParcelable);
            }
          }
        }
      }
      paramBundle.putSparseParcelableArray("android:menu:presenters", localSparseArray);
    }
  }
  
  private boolean dispatchSubMenuSelected(SubMenuBuilder paramSubMenuBuilder, MenuPresenter paramMenuPresenter)
  {
    boolean bool1 = false;
    if (this.mPresenters.isEmpty()) {
      return bool1;
    }
    if (paramMenuPresenter != null) {
      bool1 = paramMenuPresenter.onSubMenuSelected(paramSubMenuBuilder);
    }
    Iterator localIterator = this.mPresenters.iterator();
    boolean bool2 = bool1;
    label38:
    MenuPresenter localMenuPresenter;
    boolean bool3;
    if (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      localMenuPresenter = (MenuPresenter)localWeakReference.get();
      if (localMenuPresenter == null)
      {
        this.mPresenters.remove(localWeakReference);
        bool3 = bool2;
      }
    }
    for (;;)
    {
      bool2 = bool3;
      break label38;
      if (!bool2)
      {
        bool3 = localMenuPresenter.onSubMenuSelected(paramSubMenuBuilder);
        continue;
        bool1 = bool2;
        break;
      }
      bool3 = bool2;
    }
  }
  
  private static int findInsertIndex(ArrayList<MenuItemImpl> paramArrayList, int paramInt)
  {
    int i = -1 + paramArrayList.size();
    if (i >= 0) {
      if (((MenuItemImpl)paramArrayList.get(i)).getOrdering() > paramInt) {}
    }
    for (int j = i + 1;; j = 0)
    {
      return j;
      i--;
      break;
    }
  }
  
  private static int getOrdering(int paramInt)
  {
    int i = (0xFFFF0000 & paramInt) >> 16;
    if ((i < 0) || (i >= sCategoryToOrder.length)) {
      throw new IllegalArgumentException("order does not contain a valid category.");
    }
    return sCategoryToOrder[i] << 16 | 0xFFFF & paramInt;
  }
  
  private void removeItemAtInt(int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 0) || (paramInt >= this.mItems.size())) {}
    for (;;)
    {
      return;
      this.mItems.remove(paramInt);
      if (paramBoolean) {
        onItemsChanged(true);
      }
    }
  }
  
  private void setHeaderInternal(int paramInt1, CharSequence paramCharSequence, int paramInt2, Drawable paramDrawable, View paramView)
  {
    Resources localResources = getResources();
    if (paramView != null)
    {
      this.mHeaderView = paramView;
      this.mHeaderTitle = null;
      this.mHeaderIcon = null;
      onItemsChanged(false);
      return;
    }
    if (paramInt1 > 0)
    {
      this.mHeaderTitle = localResources.getText(paramInt1);
      label47:
      if (paramInt2 <= 0) {
        break label83;
      }
      this.mHeaderIcon = ContextCompat.getDrawable(getContext(), paramInt2);
    }
    for (;;)
    {
      this.mHeaderView = null;
      break;
      if (paramCharSequence == null) {
        break label47;
      }
      this.mHeaderTitle = paramCharSequence;
      break label47;
      label83:
      if (paramDrawable != null) {
        this.mHeaderIcon = paramDrawable;
      }
    }
  }
  
  private void setShortcutsVisibleInner(boolean paramBoolean)
  {
    int i = 1;
    if ((paramBoolean) && (this.mResources.getConfiguration().keyboard != i) && (this.mResources.getBoolean(R.bool.abc_config_showMenuShortcutsWhenKeyboardPresent))) {}
    for (;;)
    {
      this.mShortcutsVisible = i;
      return;
      i = 0;
    }
  }
  
  public MenuItem add(int paramInt)
  {
    return addInternal(0, 0, 0, this.mResources.getString(paramInt));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return addInternal(paramInt1, paramInt2, paramInt3, this.mResources.getString(paramInt4));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return addInternal(paramInt1, paramInt2, paramInt3, paramCharSequence);
  }
  
  public MenuItem add(CharSequence paramCharSequence)
  {
    return addInternal(0, 0, 0, paramCharSequence);
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    PackageManager localPackageManager = this.mContext.getPackageManager();
    List localList = localPackageManager.queryIntentActivityOptions(paramComponentName, paramArrayOfIntent, paramIntent, 0);
    int i;
    int j;
    label52:
    ResolveInfo localResolveInfo;
    if (localList != null)
    {
      i = localList.size();
      if ((paramInt4 & 0x1) == 0) {
        removeGroup(paramInt1);
      }
      j = 0;
      if (j >= i) {
        break label211;
      }
      localResolveInfo = (ResolveInfo)localList.get(j);
      if (localResolveInfo.specificIndex >= 0) {
        break label198;
      }
    }
    label198:
    for (Intent localIntent1 = paramIntent;; localIntent1 = paramArrayOfIntent[localResolveInfo.specificIndex])
    {
      Intent localIntent2 = new Intent(localIntent1);
      localIntent2.setComponent(new ComponentName(localResolveInfo.activityInfo.applicationInfo.packageName, localResolveInfo.activityInfo.name));
      MenuItem localMenuItem = add(paramInt1, paramInt2, paramInt3, localResolveInfo.loadLabel(localPackageManager)).setIcon(localResolveInfo.loadIcon(localPackageManager)).setIntent(localIntent2);
      if ((paramArrayOfMenuItem != null) && (localResolveInfo.specificIndex >= 0)) {
        paramArrayOfMenuItem[localResolveInfo.specificIndex] = localMenuItem;
      }
      j++;
      break label52;
      i = 0;
      break;
    }
    label211:
    return i;
  }
  
  public void addMenuPresenter(MenuPresenter paramMenuPresenter)
  {
    addMenuPresenter(paramMenuPresenter, this.mContext);
  }
  
  public void addMenuPresenter(MenuPresenter paramMenuPresenter, Context paramContext)
  {
    this.mPresenters.add(new WeakReference(paramMenuPresenter));
    paramMenuPresenter.initForMenu(paramContext, this);
    this.mIsActionItemsStale = true;
  }
  
  public SubMenu addSubMenu(int paramInt)
  {
    return addSubMenu(0, 0, 0, this.mResources.getString(paramInt));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return addSubMenu(paramInt1, paramInt2, paramInt3, this.mResources.getString(paramInt4));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    MenuItemImpl localMenuItemImpl = (MenuItemImpl)addInternal(paramInt1, paramInt2, paramInt3, paramCharSequence);
    SubMenuBuilder localSubMenuBuilder = new SubMenuBuilder(this.mContext, this, localMenuItemImpl);
    localMenuItemImpl.setSubMenu(localSubMenuBuilder);
    return localSubMenuBuilder;
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    return addSubMenu(0, 0, 0, paramCharSequence);
  }
  
  public void changeMenuMode()
  {
    if (this.mCallback != null) {
      this.mCallback.onMenuModeChange(this);
    }
  }
  
  public void clear()
  {
    if (this.mExpandedItem != null) {
      collapseItemActionView(this.mExpandedItem);
    }
    this.mItems.clear();
    onItemsChanged(true);
  }
  
  public void clearAll()
  {
    this.mPreventDispatchingItemsChanged = true;
    clear();
    clearHeader();
    this.mPreventDispatchingItemsChanged = false;
    this.mItemsChangedWhileDispatchPrevented = false;
    onItemsChanged(true);
  }
  
  public void clearHeader()
  {
    this.mHeaderIcon = null;
    this.mHeaderTitle = null;
    this.mHeaderView = null;
    onItemsChanged(false);
  }
  
  public void close()
  {
    close(true);
  }
  
  public final void close(boolean paramBoolean)
  {
    if (this.mIsClosing) {}
    for (;;)
    {
      return;
      this.mIsClosing = true;
      Iterator localIterator = this.mPresenters.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        MenuPresenter localMenuPresenter = (MenuPresenter)localWeakReference.get();
        if (localMenuPresenter == null) {
          this.mPresenters.remove(localWeakReference);
        } else {
          localMenuPresenter.onCloseMenu(this, paramBoolean);
        }
      }
      this.mIsClosing = false;
    }
  }
  
  public boolean collapseItemActionView(MenuItemImpl paramMenuItemImpl)
  {
    boolean bool1 = false;
    if ((this.mPresenters.isEmpty()) || (this.mExpandedItem != paramMenuItemImpl)) {
      return bool1;
    }
    stopDispatchingItemsChanged();
    Iterator localIterator = this.mPresenters.iterator();
    boolean bool2 = false;
    if (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      MenuPresenter localMenuPresenter = (MenuPresenter)localWeakReference.get();
      if (localMenuPresenter == null)
      {
        this.mPresenters.remove(localWeakReference);
        bool1 = bool2;
      }
      do
      {
        bool2 = bool1;
        break;
        bool1 = localMenuPresenter.collapseItemActionView(this, paramMenuItemImpl);
      } while (!bool1);
    }
    for (;;)
    {
      startDispatchingItemsChanged();
      if (!bool1) {
        break;
      }
      this.mExpandedItem = null;
      break;
      bool1 = bool2;
    }
  }
  
  boolean dispatchMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    if ((this.mCallback != null) && (this.mCallback.onMenuItemSelected(paramMenuBuilder, paramMenuItem))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean expandItemActionView(MenuItemImpl paramMenuItemImpl)
  {
    boolean bool1 = false;
    if (this.mPresenters.isEmpty()) {
      return bool1;
    }
    stopDispatchingItemsChanged();
    Iterator localIterator = this.mPresenters.iterator();
    boolean bool2 = false;
    if (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      MenuPresenter localMenuPresenter = (MenuPresenter)localWeakReference.get();
      if (localMenuPresenter == null)
      {
        this.mPresenters.remove(localWeakReference);
        bool1 = bool2;
      }
      do
      {
        bool2 = bool1;
        break;
        bool1 = localMenuPresenter.expandItemActionView(this, paramMenuItemImpl);
      } while (!bool1);
    }
    for (;;)
    {
      startDispatchingItemsChanged();
      if (!bool1) {
        break;
      }
      this.mExpandedItem = paramMenuItemImpl;
      break;
      bool1 = bool2;
    }
  }
  
  public int findGroupIndex(int paramInt)
  {
    return findGroupIndex(paramInt, 0);
  }
  
  public int findGroupIndex(int paramInt1, int paramInt2)
  {
    int i = size();
    if (paramInt2 < 0) {
      paramInt2 = 0;
    }
    int j = paramInt2;
    if (j < i) {
      if (((MenuItemImpl)this.mItems.get(j)).getGroupId() != paramInt1) {}
    }
    for (int k = j;; k = -1)
    {
      return k;
      j++;
      break;
    }
  }
  
  public MenuItem findItem(int paramInt)
  {
    int i = size();
    int j = 0;
    Object localObject;
    if (j < i)
    {
      localObject = (MenuItemImpl)this.mItems.get(j);
      if (((MenuItemImpl)localObject).getItemId() != paramInt) {}
    }
    for (;;)
    {
      return localObject;
      if (((MenuItemImpl)localObject).hasSubMenu())
      {
        localObject = ((MenuItemImpl)localObject).getSubMenu().findItem(paramInt);
        if (localObject != null) {}
      }
      else
      {
        j++;
        break;
        localObject = null;
      }
    }
  }
  
  public int findItemIndex(int paramInt)
  {
    int i = size();
    int j = 0;
    if (j < i) {
      if (((MenuItemImpl)this.mItems.get(j)).getItemId() != paramInt) {}
    }
    for (int k = j;; k = -1)
    {
      return k;
      j++;
      break;
    }
  }
  
  MenuItemImpl findItemWithShortcutForKey(int paramInt, KeyEvent paramKeyEvent)
  {
    ArrayList localArrayList = this.mTempShortcutItemList;
    localArrayList.clear();
    findItemsWithShortcutForKey(localArrayList, paramInt, paramKeyEvent);
    MenuItemImpl localMenuItemImpl;
    if (localArrayList.isEmpty()) {
      localMenuItemImpl = null;
    }
    for (;;)
    {
      return localMenuItemImpl;
      int i = paramKeyEvent.getMetaState();
      KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
      paramKeyEvent.getKeyData(localKeyData);
      int j = localArrayList.size();
      if (j == 1)
      {
        localMenuItemImpl = (MenuItemImpl)localArrayList.get(0);
      }
      else
      {
        boolean bool = isQwertyMode();
        int k = 0;
        if (k < j)
        {
          localMenuItemImpl = (MenuItemImpl)localArrayList.get(k);
          if (bool) {}
          for (int m = localMenuItemImpl.getAlphabeticShortcut();; m = localMenuItemImpl.getNumericShortcut())
          {
            if (((m == localKeyData.meta[0]) && ((i & 0x2) == 0)) || ((m == localKeyData.meta[2]) && ((i & 0x2) != 0)) || ((bool) && (m == 8) && (paramInt == 67))) {
              break label185;
            }
            k++;
            break;
          }
        }
        else
        {
          label185:
          localMenuItemImpl = null;
        }
      }
    }
  }
  
  void findItemsWithShortcutForKey(List<MenuItemImpl> paramList, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = isQwertyMode();
    int i = paramKeyEvent.getMetaState();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    if ((!paramKeyEvent.getKeyData(localKeyData)) && (paramInt != 67)) {
      return;
    }
    int j = this.mItems.size();
    int k = 0;
    label49:
    MenuItemImpl localMenuItemImpl;
    if (k < j)
    {
      localMenuItemImpl = (MenuItemImpl)this.mItems.get(k);
      if (localMenuItemImpl.hasSubMenu()) {
        ((MenuBuilder)localMenuItemImpl.getSubMenu()).findItemsWithShortcutForKey(paramList, paramInt, paramKeyEvent);
      }
      if (!bool) {
        break label181;
      }
    }
    label181:
    for (int m = localMenuItemImpl.getAlphabeticShortcut();; m = localMenuItemImpl.getNumericShortcut())
    {
      if (((i & 0x5) == 0) && (m != 0) && ((m == localKeyData.meta[0]) || (m == localKeyData.meta[2]) || ((bool) && (m == 8) && (paramInt == 67))) && (localMenuItemImpl.isEnabled())) {
        paramList.add(localMenuItemImpl);
      }
      k++;
      break label49;
      break;
    }
  }
  
  public void flagActionItems()
  {
    ArrayList localArrayList = getVisibleItems();
    if (!this.mIsActionItemsStale) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.mPresenters.iterator();
      boolean bool1 = false;
      if (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        MenuPresenter localMenuPresenter = (MenuPresenter)localWeakReference.get();
        if (localMenuPresenter == null) {
          this.mPresenters.remove(localWeakReference);
        }
        for (boolean bool2 = bool1;; bool2 = bool1 | localMenuPresenter.flagActionItems())
        {
          bool1 = bool2;
          break;
        }
      }
      if (bool1)
      {
        this.mActionItems.clear();
        this.mNonActionItems.clear();
        int i = localArrayList.size();
        int j = 0;
        if (j < i)
        {
          MenuItemImpl localMenuItemImpl = (MenuItemImpl)localArrayList.get(j);
          if (localMenuItemImpl.isActionButton()) {
            this.mActionItems.add(localMenuItemImpl);
          }
          for (;;)
          {
            j++;
            break;
            this.mNonActionItems.add(localMenuItemImpl);
          }
        }
      }
      else
      {
        this.mActionItems.clear();
        this.mNonActionItems.clear();
        this.mNonActionItems.addAll(getVisibleItems());
      }
      this.mIsActionItemsStale = false;
    }
  }
  
  public ArrayList<MenuItemImpl> getActionItems()
  {
    flagActionItems();
    return this.mActionItems;
  }
  
  protected String getActionViewStatesKey()
  {
    return "android:menu:actionviewstates";
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public MenuItemImpl getExpandedItem()
  {
    return this.mExpandedItem;
  }
  
  public Drawable getHeaderIcon()
  {
    return this.mHeaderIcon;
  }
  
  public CharSequence getHeaderTitle()
  {
    return this.mHeaderTitle;
  }
  
  public View getHeaderView()
  {
    return this.mHeaderView;
  }
  
  public MenuItem getItem(int paramInt)
  {
    return (MenuItem)this.mItems.get(paramInt);
  }
  
  public ArrayList<MenuItemImpl> getNonActionItems()
  {
    flagActionItems();
    return this.mNonActionItems;
  }
  
  boolean getOptionalIconsVisible()
  {
    return this.mOptionalIconsVisible;
  }
  
  Resources getResources()
  {
    return this.mResources;
  }
  
  public MenuBuilder getRootMenu()
  {
    return this;
  }
  
  public ArrayList<MenuItemImpl> getVisibleItems()
  {
    if (!this.mIsVisibleItemsStale) {}
    for (ArrayList localArrayList = this.mVisibleItems;; localArrayList = this.mVisibleItems)
    {
      return localArrayList;
      this.mVisibleItems.clear();
      int i = this.mItems.size();
      for (int j = 0; j < i; j++)
      {
        MenuItemImpl localMenuItemImpl = (MenuItemImpl)this.mItems.get(j);
        if (localMenuItemImpl.isVisible()) {
          this.mVisibleItems.add(localMenuItemImpl);
        }
      }
      this.mIsVisibleItemsStale = false;
      this.mIsActionItemsStale = true;
    }
  }
  
  public boolean hasVisibleItems()
  {
    int i = size();
    int j = 0;
    if (j < i) {
      if (!((MenuItemImpl)this.mItems.get(j)).isVisible()) {}
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      j++;
      break;
    }
  }
  
  boolean isQwertyMode()
  {
    return this.mQwertyMode;
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    if (findItemWithShortcutForKey(paramInt, paramKeyEvent) != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isShortcutsVisible()
  {
    return this.mShortcutsVisible;
  }
  
  void onItemActionRequestChanged(MenuItemImpl paramMenuItemImpl)
  {
    this.mIsActionItemsStale = true;
    onItemsChanged(true);
  }
  
  void onItemVisibleChanged(MenuItemImpl paramMenuItemImpl)
  {
    this.mIsVisibleItemsStale = true;
    onItemsChanged(true);
  }
  
  public void onItemsChanged(boolean paramBoolean)
  {
    if (!this.mPreventDispatchingItemsChanged)
    {
      if (paramBoolean)
      {
        this.mIsVisibleItemsStale = true;
        this.mIsActionItemsStale = true;
      }
      dispatchPresenterUpdate(paramBoolean);
    }
    for (;;)
    {
      return;
      this.mItemsChangedWhileDispatchPrevented = true;
    }
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    return performItemAction(findItem(paramInt1), paramInt2);
  }
  
  public boolean performItemAction(MenuItem paramMenuItem, int paramInt)
  {
    return performItemAction(paramMenuItem, null, paramInt);
  }
  
  public boolean performItemAction(MenuItem paramMenuItem, MenuPresenter paramMenuPresenter, int paramInt)
  {
    boolean bool1 = false;
    MenuItemImpl localMenuItemImpl = (MenuItemImpl)paramMenuItem;
    if ((localMenuItemImpl == null) || (!localMenuItemImpl.isEnabled())) {}
    for (;;)
    {
      return bool1;
      boolean bool2 = localMenuItemImpl.invoke();
      ActionProvider localActionProvider = localMenuItemImpl.getSupportActionProvider();
      if ((localActionProvider != null) && (localActionProvider.hasSubMenu())) {}
      for (int i = 1;; i = 0)
      {
        if (!localMenuItemImpl.hasCollapsibleActionView()) {
          break label92;
        }
        bool1 = bool2 | localMenuItemImpl.expandActionView();
        if (!bool1) {
          break;
        }
        close(true);
        break;
      }
      label92:
      if ((localMenuItemImpl.hasSubMenu()) || (i != 0))
      {
        close(false);
        if (!localMenuItemImpl.hasSubMenu()) {
          localMenuItemImpl.setSubMenu(new SubMenuBuilder(getContext(), this, localMenuItemImpl));
        }
        SubMenuBuilder localSubMenuBuilder = (SubMenuBuilder)localMenuItemImpl.getSubMenu();
        if (i != 0) {
          localActionProvider.onPrepareSubMenu(localSubMenuBuilder);
        }
        bool1 = bool2 | dispatchSubMenuSelected(localSubMenuBuilder, paramMenuPresenter);
        if (!bool1) {
          close(true);
        }
      }
      else
      {
        if ((paramInt & 0x1) == 0) {
          close(true);
        }
        bool1 = bool2;
      }
    }
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    MenuItemImpl localMenuItemImpl = findItemWithShortcutForKey(paramInt1, paramKeyEvent);
    boolean bool = false;
    if (localMenuItemImpl != null) {
      bool = performItemAction(localMenuItemImpl, paramInt2);
    }
    if ((paramInt2 & 0x2) != 0) {
      close(true);
    }
    return bool;
  }
  
  public void removeGroup(int paramInt)
  {
    int i = findGroupIndex(paramInt);
    if (i >= 0)
    {
      int j = this.mItems.size() - i;
      int m;
      for (int k = 0;; k = m)
      {
        m = k + 1;
        if ((k >= j) || (((MenuItemImpl)this.mItems.get(i)).getGroupId() != paramInt)) {
          break;
        }
        removeItemAtInt(i, false);
      }
      onItemsChanged(true);
    }
  }
  
  public void removeItem(int paramInt)
  {
    removeItemAtInt(findItemIndex(paramInt), true);
  }
  
  public void removeItemAt(int paramInt)
  {
    removeItemAtInt(paramInt, true);
  }
  
  public void removeMenuPresenter(MenuPresenter paramMenuPresenter)
  {
    Iterator localIterator = this.mPresenters.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      MenuPresenter localMenuPresenter = (MenuPresenter)localWeakReference.get();
      if ((localMenuPresenter == null) || (localMenuPresenter == paramMenuPresenter)) {
        this.mPresenters.remove(localWeakReference);
      }
    }
  }
  
  public void restoreActionViewStates(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    for (;;)
    {
      return;
      SparseArray localSparseArray = paramBundle.getSparseParcelableArray(getActionViewStatesKey());
      int i = size();
      for (int j = 0; j < i; j++)
      {
        MenuItem localMenuItem2 = getItem(j);
        View localView = MenuItemCompat.getActionView(localMenuItem2);
        if ((localView != null) && (localView.getId() != -1)) {
          localView.restoreHierarchyState(localSparseArray);
        }
        if (localMenuItem2.hasSubMenu()) {
          ((SubMenuBuilder)localMenuItem2.getSubMenu()).restoreActionViewStates(paramBundle);
        }
      }
      int k = paramBundle.getInt("android:menu:expandedactionview");
      if (k > 0)
      {
        MenuItem localMenuItem1 = findItem(k);
        if (localMenuItem1 != null) {
          MenuItemCompat.expandActionView(localMenuItem1);
        }
      }
    }
  }
  
  public void restorePresenterStates(Bundle paramBundle)
  {
    dispatchRestoreInstanceState(paramBundle);
  }
  
  public void saveActionViewStates(Bundle paramBundle)
  {
    int i = size();
    int j = 0;
    Object localObject2;
    for (Object localObject1 = null; j < i; localObject1 = localObject2)
    {
      MenuItem localMenuItem = getItem(j);
      View localView = MenuItemCompat.getActionView(localMenuItem);
      if ((localView != null) && (localView.getId() != -1))
      {
        if (localObject1 == null) {
          localObject1 = new SparseArray();
        }
        localView.saveHierarchyState((SparseArray)localObject1);
        if (MenuItemCompat.isActionViewExpanded(localMenuItem)) {
          paramBundle.putInt("android:menu:expandedactionview", localMenuItem.getItemId());
        }
      }
      localObject2 = localObject1;
      if (localMenuItem.hasSubMenu()) {
        ((SubMenuBuilder)localMenuItem.getSubMenu()).saveActionViewStates(paramBundle);
      }
      j++;
    }
    if (localObject1 != null) {
      paramBundle.putSparseParcelableArray(getActionViewStatesKey(), (SparseArray)localObject1);
    }
  }
  
  public void savePresenterStates(Bundle paramBundle)
  {
    dispatchSaveInstanceState(paramBundle);
  }
  
  public void setCallback(MenuBuilder.Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }
  
  public void setCurrentMenuInfo(ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    this.mCurrentMenuInfo = paramContextMenuInfo;
  }
  
  public MenuBuilder setDefaultShowAsAction(int paramInt)
  {
    this.mDefaultShowAsAction = paramInt;
    return this;
  }
  
  void setExclusiveItemChecked(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getGroupId();
    int j = this.mItems.size();
    int k = 0;
    if (k < j)
    {
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)this.mItems.get(k);
      if ((localMenuItemImpl.getGroupId() != i) || (!localMenuItemImpl.isExclusiveCheckable())) {}
      while (!localMenuItemImpl.isCheckable())
      {
        k++;
        break;
      }
      if (localMenuItemImpl == paramMenuItem) {}
      for (boolean bool = true;; bool = false)
      {
        localMenuItemImpl.setCheckedInt(bool);
        break;
      }
    }
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = this.mItems.size();
    for (int j = 0; j < i; j++)
    {
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)this.mItems.get(j);
      if (localMenuItemImpl.getGroupId() == paramInt)
      {
        localMenuItemImpl.setExclusiveCheckable(paramBoolean2);
        localMenuItemImpl.setCheckable(paramBoolean1);
      }
    }
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    int i = this.mItems.size();
    for (int j = 0; j < i; j++)
    {
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)this.mItems.get(j);
      if (localMenuItemImpl.getGroupId() == paramInt) {
        localMenuItemImpl.setEnabled(paramBoolean);
      }
    }
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    int i = this.mItems.size();
    int j = 0;
    int k = 0;
    if (j < i)
    {
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)this.mItems.get(j);
      if ((localMenuItemImpl.getGroupId() != paramInt) || (!localMenuItemImpl.setVisibleInt(paramBoolean))) {
        break label76;
      }
    }
    label76:
    for (int m = 1;; m = k)
    {
      j++;
      k = m;
      break;
      if (k != 0) {
        onItemsChanged(true);
      }
      return;
    }
  }
  
  protected MenuBuilder setHeaderIconInt(int paramInt)
  {
    setHeaderInternal(0, null, paramInt, null, null);
    return this;
  }
  
  protected MenuBuilder setHeaderIconInt(Drawable paramDrawable)
  {
    setHeaderInternal(0, null, 0, paramDrawable, null);
    return this;
  }
  
  protected MenuBuilder setHeaderTitleInt(int paramInt)
  {
    setHeaderInternal(paramInt, null, 0, null, null);
    return this;
  }
  
  protected MenuBuilder setHeaderTitleInt(CharSequence paramCharSequence)
  {
    setHeaderInternal(0, paramCharSequence, 0, null, null);
    return this;
  }
  
  protected MenuBuilder setHeaderViewInt(View paramView)
  {
    setHeaderInternal(0, null, 0, null, paramView);
    return this;
  }
  
  void setOptionalIconsVisible(boolean paramBoolean)
  {
    this.mOptionalIconsVisible = paramBoolean;
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    this.mQwertyMode = paramBoolean;
    onItemsChanged(false);
  }
  
  public void setShortcutsVisible(boolean paramBoolean)
  {
    if (this.mShortcutsVisible == paramBoolean) {}
    for (;;)
    {
      return;
      setShortcutsVisibleInner(paramBoolean);
      onItemsChanged(false);
    }
  }
  
  public int size()
  {
    return this.mItems.size();
  }
  
  public void startDispatchingItemsChanged()
  {
    this.mPreventDispatchingItemsChanged = false;
    if (this.mItemsChangedWhileDispatchPrevented)
    {
      this.mItemsChangedWhileDispatchPrevented = false;
      onItemsChanged(true);
    }
  }
  
  public void stopDispatchingItemsChanged()
  {
    if (!this.mPreventDispatchingItemsChanged)
    {
      this.mPreventDispatchingItemsChanged = true;
      this.mItemsChangedWhileDispatchPrevented = false;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuBuilder
 * JD-Core Version:    0.7.0.1
 */