package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.Window;

class ActionBarDrawerToggle$DrawerArrowDrawableToggle
  extends DrawerArrowDrawable
  implements ActionBarDrawerToggle.DrawerToggle
{
  private final Activity mActivity;
  
  public ActionBarDrawerToggle$DrawerArrowDrawableToggle(Activity paramActivity, Context paramContext)
  {
    super(paramContext);
    this.mActivity = paramActivity;
  }
  
  public float getPosition()
  {
    return super.getProgress();
  }
  
  boolean isLayoutRtl()
  {
    int i = 1;
    if (ViewCompat.getLayoutDirection(this.mActivity.getWindow().getDecorView()) == i) {}
    for (;;)
    {
      return i;
      int j = 0;
    }
  }
  
  public void setPosition(float paramFloat)
  {
    if (paramFloat == 1.0F) {
      setVerticalMirror(true);
    }
    for (;;)
    {
      super.setProgress(paramFloat);
      return;
      if (paramFloat == 0.0F) {
        setVerticalMirror(false);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarDrawerToggle.DrawerArrowDrawableToggle
 * JD-Core Version:    0.7.0.1
 */