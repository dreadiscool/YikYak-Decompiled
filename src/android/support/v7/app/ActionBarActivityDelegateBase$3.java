package android.support.v7.app;

import android.graphics.Rect;
import android.support.v7.internal.widget.FitWindowsViewGroup.OnFitSystemWindowsListener;

class ActionBarActivityDelegateBase$3
  implements FitWindowsViewGroup.OnFitSystemWindowsListener
{
  ActionBarActivityDelegateBase$3(ActionBarActivityDelegateBase paramActionBarActivityDelegateBase) {}
  
  public void onFitSystemWindows(Rect paramRect)
  {
    paramRect.top = ActionBarActivityDelegateBase.access$300(this.this$0, paramRect.top);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegateBase.3
 * JD-Core Version:    0.7.0.1
 */