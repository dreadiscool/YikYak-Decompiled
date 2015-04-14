package android.support.v7.internal.widget;

import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.internal.app.WindowCallback;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.util.SparseArray;
import android.view.Menu;

public abstract interface DecorContentParent
{
  public abstract boolean canShowOverflowMenu();
  
  public abstract void dismissPopups();
  
  public abstract CharSequence getTitle();
  
  public abstract boolean hasIcon();
  
  public abstract boolean hasLogo();
  
  public abstract boolean hideOverflowMenu();
  
  public abstract void initFeature(int paramInt);
  
  public abstract boolean isOverflowMenuShowPending();
  
  public abstract boolean isOverflowMenuShowing();
  
  public abstract void restoreToolbarHierarchyState(SparseArray<Parcelable> paramSparseArray);
  
  public abstract void saveToolbarHierarchyState(SparseArray<Parcelable> paramSparseArray);
  
  public abstract void setIcon(int paramInt);
  
  public abstract void setIcon(Drawable paramDrawable);
  
  public abstract void setLogo(int paramInt);
  
  public abstract void setMenu(Menu paramMenu, MenuPresenter.Callback paramCallback);
  
  public abstract void setMenuPrepared();
  
  public abstract void setUiOptions(int paramInt);
  
  public abstract void setWindowCallback(WindowCallback paramWindowCallback);
  
  public abstract void setWindowTitle(CharSequence paramCharSequence);
  
  public abstract boolean showOverflowMenu();
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.DecorContentParent
 * JD-Core Version:    0.7.0.1
 */