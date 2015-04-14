package android.support.v7.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

class ActionBarActivityDelegate$ActionBarDrawableToggleImpl
  implements android.support.v4.app.ActionBarDrawerToggle.Delegate, ActionBarDrawerToggle.Delegate
{
  private ActionBarActivityDelegate$ActionBarDrawableToggleImpl(ActionBarActivityDelegate paramActionBarActivityDelegate) {}
  
  public Context getActionBarThemedContext()
  {
    return this.this$0.getActionBarThemedContext();
  }
  
  public Drawable getThemeUpIndicator()
  {
    Context localContext = this.this$0.getActionBarThemedContext();
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = this.this$0.getHomeAsUpIndicatorAttrId();
    TypedArray localTypedArray = localContext.obtainStyledAttributes(arrayOfInt);
    Drawable localDrawable = localTypedArray.getDrawable(0);
    localTypedArray.recycle();
    return localDrawable;
  }
  
  public void setActionBarDescription(int paramInt)
  {
    ActionBar localActionBar = this.this$0.getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.setHomeActionContentDescription(paramInt);
    }
  }
  
  public void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
  {
    ActionBar localActionBar = this.this$0.getSupportActionBar();
    if (localActionBar != null)
    {
      localActionBar.setHomeAsUpIndicator(paramDrawable);
      localActionBar.setHomeActionContentDescription(paramInt);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegate.ActionBarDrawableToggleImpl
 * JD-Core Version:    0.7.0.1
 */