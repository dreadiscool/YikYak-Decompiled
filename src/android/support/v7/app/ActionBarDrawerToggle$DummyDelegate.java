package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;

class ActionBarDrawerToggle$DummyDelegate
  implements ActionBarDrawerToggle.Delegate
{
  final Activity mActivity;
  
  ActionBarDrawerToggle$DummyDelegate(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  public Context getActionBarThemedContext()
  {
    return this.mActivity;
  }
  
  public Drawable getThemeUpIndicator()
  {
    return null;
  }
  
  public void setActionBarDescription(int paramInt) {}
  
  public void setActionBarUpIndicator(Drawable paramDrawable, int paramInt) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarDrawerToggle.DummyDelegate
 * JD-Core Version:    0.7.0.1
 */