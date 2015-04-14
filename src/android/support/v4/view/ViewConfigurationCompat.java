package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public class ViewConfigurationCompat
{
  static final ViewConfigurationCompat.ViewConfigurationVersionImpl IMPL;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 14) {
      IMPL = new ViewConfigurationCompat.IcsViewConfigurationVersionImpl();
    }
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT >= 11) {
        IMPL = new ViewConfigurationCompat.HoneycombViewConfigurationVersionImpl();
      } else if (Build.VERSION.SDK_INT >= 8) {
        IMPL = new ViewConfigurationCompat.FroyoViewConfigurationVersionImpl();
      } else {
        IMPL = new ViewConfigurationCompat.BaseViewConfigurationVersionImpl();
      }
    }
  }
  
  public static int getScaledPagingTouchSlop(ViewConfiguration paramViewConfiguration)
  {
    return IMPL.getScaledPagingTouchSlop(paramViewConfiguration);
  }
  
  public static boolean hasPermanentMenuKey(ViewConfiguration paramViewConfiguration)
  {
    return IMPL.hasPermanentMenuKey(paramViewConfiguration);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewConfigurationCompat
 * JD-Core Version:    0.7.0.1
 */