package android.support.v7.internal.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuItemWrapperICS;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;

class SupportMenuInflater$MenuState
{
  private static final int defaultGroupId = 0;
  private static final int defaultItemCategory = 0;
  private static final int defaultItemCheckable = 0;
  private static final boolean defaultItemChecked = false;
  private static final boolean defaultItemEnabled = true;
  private static final int defaultItemId = 0;
  private static final int defaultItemOrder = 0;
  private static final boolean defaultItemVisible = true;
  private int groupCategory;
  private int groupCheckable;
  private boolean groupEnabled;
  private int groupId;
  private int groupOrder;
  private boolean groupVisible;
  private ActionProvider itemActionProvider;
  private String itemActionProviderClassName;
  private String itemActionViewClassName;
  private int itemActionViewLayout;
  private boolean itemAdded;
  private char itemAlphabeticShortcut;
  private int itemCategoryOrder;
  private int itemCheckable;
  private boolean itemChecked;
  private boolean itemEnabled;
  private int itemIconResId;
  private int itemId;
  private String itemListenerMethodName;
  private char itemNumericShortcut;
  private int itemShowAsAction;
  private CharSequence itemTitle;
  private CharSequence itemTitleCondensed;
  private boolean itemVisible;
  private Menu menu;
  
  public SupportMenuInflater$MenuState(SupportMenuInflater paramSupportMenuInflater, Menu paramMenu)
  {
    this.menu = paramMenu;
    resetGroup();
  }
  
  private char getShortcut(String paramString)
  {
    char c = '\000';
    if (paramString == null) {}
    for (;;)
    {
      return c;
      c = paramString.charAt(0);
    }
  }
  
  private <T> T newInstance(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      Object localObject2 = SupportMenuInflater.access$100(this.this$0).getClassLoader().loadClass(paramString).getConstructor(paramArrayOfClass).newInstance(paramArrayOfObject);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        new StringBuilder().append("Cannot instantiate class: ").append(paramString).toString();
        Object localObject1 = null;
      }
    }
    return localObject1;
  }
  
  private void setItem(MenuItem paramMenuItem)
  {
    int i = 1;
    MenuItem localMenuItem = paramMenuItem.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled);
    if (this.itemCheckable >= i) {}
    int m;
    for (int k = i;; m = 0)
    {
      localMenuItem.setCheckable(k).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId).setAlphabeticShortcut(this.itemAlphabeticShortcut).setNumericShortcut(this.itemNumericShortcut);
      if (this.itemShowAsAction >= 0) {
        MenuItemCompat.setShowAsAction(paramMenuItem, this.itemShowAsAction);
      }
      if (this.itemListenerMethodName == null) {
        break label163;
      }
      if (!SupportMenuInflater.access$100(this.this$0).isRestricted()) {
        break;
      }
      throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
    }
    paramMenuItem.setOnMenuItemClickListener(new SupportMenuInflater.InflatedOnMenuItemClickListener(SupportMenuInflater.access$400(this.this$0), this.itemListenerMethodName));
    label163:
    if (this.itemCheckable >= 2)
    {
      if ((paramMenuItem instanceof MenuItemImpl)) {
        ((MenuItemImpl)paramMenuItem).setExclusiveCheckable(i);
      }
    }
    else
    {
      if (this.itemActionViewClassName == null) {
        break label274;
      }
      MenuItemCompat.setActionView(paramMenuItem, (View)newInstance(this.itemActionViewClassName, SupportMenuInflater.access$500(), SupportMenuInflater.access$600(this.this$0)));
    }
    for (;;)
    {
      if ((this.itemActionViewLayout > 0) && (i == 0)) {
        MenuItemCompat.setActionView(paramMenuItem, this.itemActionViewLayout);
      }
      if (this.itemActionProvider != null) {
        MenuItemCompat.setActionProvider(paramMenuItem, this.itemActionProvider);
      }
      return;
      if (!(paramMenuItem instanceof MenuItemWrapperICS)) {
        break;
      }
      ((MenuItemWrapperICS)paramMenuItem).setExclusiveCheckable(i);
      break;
      label274:
      int j = 0;
    }
  }
  
  public void addItem()
  {
    this.itemAdded = true;
    setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
  }
  
  public SubMenu addSubMenuItem()
  {
    this.itemAdded = true;
    SubMenu localSubMenu = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
    setItem(localSubMenu.getItem());
    return localSubMenu;
  }
  
  public boolean hasAddedItem()
  {
    return this.itemAdded;
  }
  
  public void readGroup(AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = SupportMenuInflater.access$100(this.this$0).obtainStyledAttributes(paramAttributeSet, R.styleable.MenuGroup);
    this.groupId = localTypedArray.getResourceId(R.styleable.MenuGroup_android_id, 0);
    this.groupCategory = localTypedArray.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
    this.groupOrder = localTypedArray.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
    this.groupCheckable = localTypedArray.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
    this.groupVisible = localTypedArray.getBoolean(R.styleable.MenuGroup_android_visible, true);
    this.groupEnabled = localTypedArray.getBoolean(R.styleable.MenuGroup_android_enabled, true);
    localTypedArray.recycle();
  }
  
  public void readItem(AttributeSet paramAttributeSet)
  {
    int i = 1;
    TypedArray localTypedArray = SupportMenuInflater.access$100(this.this$0).obtainStyledAttributes(paramAttributeSet, R.styleable.MenuItem);
    this.itemId = localTypedArray.getResourceId(R.styleable.MenuItem_android_id, 0);
    int j = localTypedArray.getInt(R.styleable.MenuItem_android_menuCategory, this.groupCategory);
    int k = localTypedArray.getInt(R.styleable.MenuItem_android_orderInCategory, this.groupOrder);
    this.itemCategoryOrder = (j & 0xFFFF0000 | k & 0xFFFF);
    this.itemTitle = localTypedArray.getText(R.styleable.MenuItem_android_title);
    this.itemTitleCondensed = localTypedArray.getText(R.styleable.MenuItem_android_titleCondensed);
    this.itemIconResId = localTypedArray.getResourceId(R.styleable.MenuItem_android_icon, 0);
    this.itemAlphabeticShortcut = getShortcut(localTypedArray.getString(R.styleable.MenuItem_android_alphabeticShortcut));
    this.itemNumericShortcut = getShortcut(localTypedArray.getString(R.styleable.MenuItem_android_numericShortcut));
    int m;
    if (localTypedArray.hasValue(R.styleable.MenuItem_android_checkable)) {
      if (localTypedArray.getBoolean(R.styleable.MenuItem_android_checkable, false))
      {
        m = i;
        this.itemCheckable = m;
        label166:
        this.itemChecked = localTypedArray.getBoolean(R.styleable.MenuItem_android_checked, false);
        this.itemVisible = localTypedArray.getBoolean(R.styleable.MenuItem_android_visible, this.groupVisible);
        this.itemEnabled = localTypedArray.getBoolean(R.styleable.MenuItem_android_enabled, this.groupEnabled);
        this.itemShowAsAction = localTypedArray.getInt(R.styleable.MenuItem_showAsAction, -1);
        this.itemListenerMethodName = localTypedArray.getString(R.styleable.MenuItem_android_onClick);
        this.itemActionViewLayout = localTypedArray.getResourceId(R.styleable.MenuItem_actionLayout, 0);
        this.itemActionViewClassName = localTypedArray.getString(R.styleable.MenuItem_actionViewClass);
        this.itemActionProviderClassName = localTypedArray.getString(R.styleable.MenuItem_actionProviderClass);
        if (this.itemActionProviderClassName == null) {
          break label343;
        }
        label273:
        if ((i == 0) || (this.itemActionViewLayout != 0) || (this.itemActionViewClassName != null)) {
          break label348;
        }
      }
    }
    label343:
    label348:
    for (this.itemActionProvider = ((ActionProvider)newInstance(this.itemActionProviderClassName, SupportMenuInflater.access$200(), SupportMenuInflater.access$300(this.this$0)));; this.itemActionProvider = null)
    {
      localTypedArray.recycle();
      this.itemAdded = false;
      return;
      m = 0;
      break;
      this.itemCheckable = this.groupCheckable;
      break label166;
      i = 0;
      break label273;
    }
  }
  
  public void resetGroup()
  {
    this.groupId = 0;
    this.groupCategory = 0;
    this.groupOrder = 0;
    this.groupCheckable = 0;
    this.groupVisible = true;
    this.groupEnabled = true;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.SupportMenuInflater.MenuState
 * JD-Core Version:    0.7.0.1
 */