package android.support.v7.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.Toolbar;

class ActionBarDrawerToggle$ToolbarCompatDelegate
  implements ActionBarDrawerToggle.Delegate
{
  final Toolbar mToolbar;
  
  ActionBarDrawerToggle$ToolbarCompatDelegate(Toolbar paramToolbar)
  {
    this.mToolbar = paramToolbar;
  }
  
  public Context getActionBarThemedContext()
  {
    return this.mToolbar.getContext();
  }
  
  public Drawable getThemeUpIndicator()
  {
    Context localContext = this.mToolbar.getContext();
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 16908332;
    TypedArray localTypedArray = localContext.obtainStyledAttributes(arrayOfInt);
    Drawable localDrawable = localTypedArray.getDrawable(0);
    localTypedArray.recycle();
    return localDrawable;
  }
  
  public void setActionBarDescription(int paramInt)
  {
    this.mToolbar.setNavigationContentDescription(paramInt);
  }
  
  public void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
  {
    this.mToolbar.setNavigationIcon(paramDrawable);
    this.mToolbar.setNavigationContentDescription(paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarDrawerToggle.ToolbarCompatDelegate
 * JD-Core Version:    0.7.0.1
 */