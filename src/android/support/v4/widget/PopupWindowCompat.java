package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.PopupWindow;

public class PopupWindowCompat
{
  static final PopupWindowCompat.PopupWindowImpl IMPL;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    for (IMPL = new PopupWindowCompat.KitKatPopupWindowImpl();; IMPL = new PopupWindowCompat.BasePopupWindowImpl()) {
      return;
    }
  }
  
  public static void showAsDropDown(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    IMPL.showAsDropDown(paramPopupWindow, paramView, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.PopupWindowCompat
 * JD-Core Version:    0.7.0.1
 */