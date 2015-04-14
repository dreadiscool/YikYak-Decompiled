package android.support.v4.view;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

class ViewParentCompat$ViewParentCompatStubImpl
  implements ViewParentCompat.ViewParentCompatImpl
{
  public boolean requestSendAccessibilityEvent(ViewParent paramViewParent, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramView == null) {}
    for (boolean bool = false;; bool = true)
    {
      return bool;
      ((AccessibilityManager)paramView.getContext().getSystemService("accessibility")).sendAccessibilityEvent(paramAccessibilityEvent);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewParentCompat.ViewParentCompatStubImpl
 * JD-Core Version:    0.7.0.1
 */