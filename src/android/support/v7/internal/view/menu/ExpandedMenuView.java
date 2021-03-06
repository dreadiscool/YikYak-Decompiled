package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v7.internal.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;

public final class ExpandedMenuView
  extends ListView
  implements MenuBuilder.ItemInvoker, MenuView, AdapterView.OnItemClickListener
{
  private static final int[] TINT_ATTRS;
  private int mAnimations;
  private MenuBuilder mMenu;
  
  static
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = 16842964;
    arrayOfInt[1] = 16843049;
    TINT_ATTRS = arrayOfInt;
  }
  
  public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    setOnItemClickListener(this);
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, TINT_ATTRS, paramInt, 0);
    if (localTintTypedArray.hasValue(0)) {
      setBackgroundDrawable(localTintTypedArray.getDrawable(0));
    }
    if (localTintTypedArray.hasValue(1)) {
      setDivider(localTintTypedArray.getDrawable(1));
    }
    localTintTypedArray.recycle();
  }
  
  public int getWindowAnimations()
  {
    return this.mAnimations;
  }
  
  public void initialize(MenuBuilder paramMenuBuilder)
  {
    this.mMenu = paramMenuBuilder;
  }
  
  public boolean invokeItem(MenuItemImpl paramMenuItemImpl)
  {
    return this.mMenu.performItemAction(paramMenuItemImpl, 0);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    setChildrenDrawingCacheEnabled(false);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    invokeItem((MenuItemImpl)getAdapter().getItem(paramInt));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.ExpandedMenuView
 * JD-Core Version:    0.7.0.1
 */