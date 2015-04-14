package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public class ViewParentCompat
{
  static final ViewParentCompat.ViewParentCompatImpl IMPL;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    for (IMPL = new ViewParentCompat.ViewParentCompatICSImpl();; IMPL = new ViewParentCompat.ViewParentCompatStubImpl()) {
      return;
    }
  }
  
  public static boolean requestSendAccessibilityEvent(ViewParent paramViewParent, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return IMPL.requestSendAccessibilityEvent(paramViewParent, paramView, paramAccessibilityEvent);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewParentCompat
 * JD-Core Version:    0.7.0.1
 */