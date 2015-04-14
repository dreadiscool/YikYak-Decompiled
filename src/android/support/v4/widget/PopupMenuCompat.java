package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View.OnTouchListener;

public class PopupMenuCompat
{
  static final PopupMenuCompat.PopupMenuImpl IMPL;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    for (IMPL = new PopupMenuCompat.KitKatPopupMenuImpl();; IMPL = new PopupMenuCompat.BasePopupMenuImpl()) {
      return;
    }
  }
  
  public static View.OnTouchListener getDragToOpenListener(Object paramObject)
  {
    return IMPL.getDragToOpenListener(paramObject);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.PopupMenuCompat
 * JD-Core Version:    0.7.0.1
 */