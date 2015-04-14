package android.support.v7.app;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

class ActionBarDrawerToggleHoneycomb$SetIndicatorInfo
{
  public Method setHomeActionContentDescription;
  public Method setHomeAsUpIndicator;
  public ImageView upIndicatorView;
  
  ActionBarDrawerToggleHoneycomb$SetIndicatorInfo(Activity paramActivity)
  {
    label137:
    for (;;)
    {
      View localView2;
      View localView3;
      try
      {
        Class[] arrayOfClass1 = new Class[1];
        arrayOfClass1[0] = Drawable.class;
        this.setHomeAsUpIndicator = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", arrayOfClass1);
        Class[] arrayOfClass2 = new Class[1];
        arrayOfClass2[0] = Integer.TYPE;
        this.setHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", arrayOfClass2);
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        View localView1 = paramActivity.findViewById(16908332);
        if (localView1 == null) {
          continue;
        }
        ViewGroup localViewGroup = (ViewGroup)localView1.getParent();
        if (localViewGroup.getChildCount() != 2) {
          continue;
        }
        localView2 = localViewGroup.getChildAt(0);
        localView3 = localViewGroup.getChildAt(1);
        if (localView2.getId() != 16908332) {}
      }
      for (;;)
      {
        if (!(localView3 instanceof ImageView)) {
          break label137;
        }
        this.upIndicatorView = ((ImageView)localView3);
        break;
        localView3 = localView2;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarDrawerToggleHoneycomb.SetIndicatorInfo
 * JD-Core Version:    0.7.0.1
 */