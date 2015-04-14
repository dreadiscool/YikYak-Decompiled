package android.support.v7.internal.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportMenuItem;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Method;

@TargetApi(14)
public class MenuItemWrapperICS
  extends BaseMenuWrapper<SupportMenuItem>
  implements MenuItem
{
  static final String LOG_TAG = "MenuItemWrapper";
  private Method mSetExclusiveCheckableMethod;
  
  MenuItemWrapperICS(Context paramContext, SupportMenuItem paramSupportMenuItem)
  {
    super(paramContext, paramSupportMenuItem);
  }
  
  public boolean collapseActionView()
  {
    return ((SupportMenuItem)this.mWrappedObject).collapseActionView();
  }
  
  MenuItemWrapperICS.ActionProviderWrapper createActionProviderWrapper(android.view.ActionProvider paramActionProvider)
  {
    return new MenuItemWrapperICS.ActionProviderWrapper(this, this.mContext, paramActionProvider);
  }
  
  public boolean expandActionView()
  {
    return ((SupportMenuItem)this.mWrappedObject).expandActionView();
  }
  
  public android.view.ActionProvider getActionProvider()
  {
    android.support.v4.view.ActionProvider localActionProvider = ((SupportMenuItem)this.mWrappedObject).getSupportActionProvider();
    if ((localActionProvider instanceof MenuItemWrapperICS.ActionProviderWrapper)) {}
    for (android.view.ActionProvider localActionProvider1 = ((MenuItemWrapperICS.ActionProviderWrapper)localActionProvider).mInner;; localActionProvider1 = null) {
      return localActionProvider1;
    }
  }
  
  public View getActionView()
  {
    View localView = ((SupportMenuItem)this.mWrappedObject).getActionView();
    if ((localView instanceof MenuItemWrapperICS.CollapsibleActionViewWrapper)) {
      localView = ((MenuItemWrapperICS.CollapsibleActionViewWrapper)localView).getWrappedView();
    }
    return localView;
  }
  
  public char getAlphabeticShortcut()
  {
    return ((SupportMenuItem)this.mWrappedObject).getAlphabeticShortcut();
  }
  
  public int getGroupId()
  {
    return ((SupportMenuItem)this.mWrappedObject).getGroupId();
  }
  
  public Drawable getIcon()
  {
    return ((SupportMenuItem)this.mWrappedObject).getIcon();
  }
  
  public Intent getIntent()
  {
    return ((SupportMenuItem)this.mWrappedObject).getIntent();
  }
  
  public int getItemId()
  {
    return ((SupportMenuItem)this.mWrappedObject).getItemId();
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return ((SupportMenuItem)this.mWrappedObject).getMenuInfo();
  }
  
  public char getNumericShortcut()
  {
    return ((SupportMenuItem)this.mWrappedObject).getNumericShortcut();
  }
  
  public int getOrder()
  {
    return ((SupportMenuItem)this.mWrappedObject).getOrder();
  }
  
  public SubMenu getSubMenu()
  {
    return getSubMenuWrapper(((SupportMenuItem)this.mWrappedObject).getSubMenu());
  }
  
  public CharSequence getTitle()
  {
    return ((SupportMenuItem)this.mWrappedObject).getTitle();
  }
  
  public CharSequence getTitleCondensed()
  {
    return ((SupportMenuItem)this.mWrappedObject).getTitleCondensed();
  }
  
  public boolean hasSubMenu()
  {
    return ((SupportMenuItem)this.mWrappedObject).hasSubMenu();
  }
  
  public boolean isActionViewExpanded()
  {
    return ((SupportMenuItem)this.mWrappedObject).isActionViewExpanded();
  }
  
  public boolean isCheckable()
  {
    return ((SupportMenuItem)this.mWrappedObject).isCheckable();
  }
  
  public boolean isChecked()
  {
    return ((SupportMenuItem)this.mWrappedObject).isChecked();
  }
  
  public boolean isEnabled()
  {
    return ((SupportMenuItem)this.mWrappedObject).isEnabled();
  }
  
  public boolean isVisible()
  {
    return ((SupportMenuItem)this.mWrappedObject).isVisible();
  }
  
  public MenuItem setActionProvider(android.view.ActionProvider paramActionProvider)
  {
    SupportMenuItem localSupportMenuItem = (SupportMenuItem)this.mWrappedObject;
    if (paramActionProvider != null) {}
    for (MenuItemWrapperICS.ActionProviderWrapper localActionProviderWrapper = createActionProviderWrapper(paramActionProvider);; localActionProviderWrapper = null)
    {
      localSupportMenuItem.setSupportActionProvider(localActionProviderWrapper);
      return this;
    }
  }
  
  public MenuItem setActionView(int paramInt)
  {
    ((SupportMenuItem)this.mWrappedObject).setActionView(paramInt);
    View localView = ((SupportMenuItem)this.mWrappedObject).getActionView();
    if ((localView instanceof CollapsibleActionView)) {
      ((SupportMenuItem)this.mWrappedObject).setActionView(new MenuItemWrapperICS.CollapsibleActionViewWrapper(localView));
    }
    return this;
  }
  
  public MenuItem setActionView(View paramView)
  {
    if ((paramView instanceof CollapsibleActionView)) {
      paramView = new MenuItemWrapperICS.CollapsibleActionViewWrapper(paramView);
    }
    ((SupportMenuItem)this.mWrappedObject).setActionView(paramView);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    ((SupportMenuItem)this.mWrappedObject).setAlphabeticShortcut(paramChar);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    ((SupportMenuItem)this.mWrappedObject).setCheckable(paramBoolean);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    ((SupportMenuItem)this.mWrappedObject).setChecked(paramBoolean);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    ((SupportMenuItem)this.mWrappedObject).setEnabled(paramBoolean);
    return this;
  }
  
  public void setExclusiveCheckable(boolean paramBoolean)
  {
    try
    {
      if (this.mSetExclusiveCheckableMethod == null)
      {
        Class localClass = ((SupportMenuItem)this.mWrappedObject).getClass();
        Class[] arrayOfClass = new Class[1];
        arrayOfClass[0] = Boolean.TYPE;
        this.mSetExclusiveCheckableMethod = localClass.getDeclaredMethod("setExclusiveCheckable", arrayOfClass);
      }
      Method localMethod = this.mSetExclusiveCheckableMethod;
      Object localObject = this.mWrappedObject;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Boolean.valueOf(paramBoolean);
      localMethod.invoke(localObject, arrayOfObject);
      label79:
      return;
    }
    catch (Exception localException)
    {
      break label79;
    }
  }
  
  public MenuItem setIcon(int paramInt)
  {
    ((SupportMenuItem)this.mWrappedObject).setIcon(paramInt);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    ((SupportMenuItem)this.mWrappedObject).setIcon(paramDrawable);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    ((SupportMenuItem)this.mWrappedObject).setIntent(paramIntent);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    ((SupportMenuItem)this.mWrappedObject).setNumericShortcut(paramChar);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    SupportMenuItem localSupportMenuItem = (SupportMenuItem)this.mWrappedObject;
    if (paramOnActionExpandListener != null) {}
    for (MenuItemWrapperICS.OnActionExpandListenerWrapper localOnActionExpandListenerWrapper = new MenuItemWrapperICS.OnActionExpandListenerWrapper(this, paramOnActionExpandListener);; localOnActionExpandListenerWrapper = null)
    {
      localSupportMenuItem.setSupportOnActionExpandListener(localOnActionExpandListenerWrapper);
      return this;
    }
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    SupportMenuItem localSupportMenuItem = (SupportMenuItem)this.mWrappedObject;
    if (paramOnMenuItemClickListener != null) {}
    for (MenuItemWrapperICS.OnMenuItemClickListenerWrapper localOnMenuItemClickListenerWrapper = new MenuItemWrapperICS.OnMenuItemClickListenerWrapper(this, paramOnMenuItemClickListener);; localOnMenuItemClickListenerWrapper = null)
    {
      localSupportMenuItem.setOnMenuItemClickListener(localOnMenuItemClickListenerWrapper);
      return this;
    }
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    ((SupportMenuItem)this.mWrappedObject).setShortcut(paramChar1, paramChar2);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    ((SupportMenuItem)this.mWrappedObject).setShowAsAction(paramInt);
  }
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    ((SupportMenuItem)this.mWrappedObject).setShowAsActionFlags(paramInt);
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    ((SupportMenuItem)this.mWrappedObject).setTitle(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    ((SupportMenuItem)this.mWrappedObject).setTitle(paramCharSequence);
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    ((SupportMenuItem)this.mWrappedObject).setTitleCondensed(paramCharSequence);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    return ((SupportMenuItem)this.mWrappedObject).setVisible(paramBoolean);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.MenuItemWrapperICS
 * JD-Core Version:    0.7.0.1
 */