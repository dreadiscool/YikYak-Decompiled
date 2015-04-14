package android.support.v7.internal.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

class ListMenuPresenter$MenuAdapter
  extends BaseAdapter
{
  private int mExpandedIndex = -1;
  
  public ListMenuPresenter$MenuAdapter(ListMenuPresenter paramListMenuPresenter)
  {
    findExpandedIndex();
  }
  
  void findExpandedIndex()
  {
    MenuItemImpl localMenuItemImpl = this.this$0.mMenu.getExpandedItem();
    int j;
    if (localMenuItemImpl != null)
    {
      ArrayList localArrayList = this.this$0.mMenu.getNonActionItems();
      int i = localArrayList.size();
      j = 0;
      if (j < i) {
        if ((MenuItemImpl)localArrayList.get(j) != localMenuItemImpl) {}
      }
    }
    for (this.mExpandedIndex = j;; this.mExpandedIndex = -1)
    {
      return;
      j++;
      break;
    }
  }
  
  public int getCount()
  {
    int i = this.this$0.mMenu.getNonActionItems().size() - ListMenuPresenter.access$000(this.this$0);
    if (this.mExpandedIndex < 0) {}
    for (;;)
    {
      return i;
      i--;
    }
  }
  
  public MenuItemImpl getItem(int paramInt)
  {
    ArrayList localArrayList = this.this$0.mMenu.getNonActionItems();
    int i = paramInt + ListMenuPresenter.access$000(this.this$0);
    if ((this.mExpandedIndex >= 0) && (i >= this.mExpandedIndex)) {
      i++;
    }
    return (MenuItemImpl)localArrayList.get(i);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {}
    for (View localView = this.this$0.mInflater.inflate(this.this$0.mItemLayoutRes, paramViewGroup, false);; localView = paramView)
    {
      ((MenuView.ItemView)localView).initialize(getItem(paramInt), 0);
      return localView;
    }
  }
  
  public void notifyDataSetChanged()
  {
    findExpandedIndex();
    super.notifyDataSetChanged();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.ListMenuPresenter.MenuAdapter
 * JD-Core Version:    0.7.0.1
 */