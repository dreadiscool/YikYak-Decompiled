package android.support.v7.internal.widget;

import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ListPopupWindow.ForwardingListener;
import android.view.View;

class SpinnerCompat$1
  extends ListPopupWindow.ForwardingListener
{
  SpinnerCompat$1(SpinnerCompat paramSpinnerCompat, View paramView, SpinnerCompat.DropdownPopup paramDropdownPopup)
  {
    super(paramView);
  }
  
  public ListPopupWindow getPopup()
  {
    return this.val$popup;
  }
  
  public boolean onForwardingStarted()
  {
    if (!SpinnerCompat.access$100(this.this$0).isShowing()) {
      SpinnerCompat.access$100(this.this$0).show();
    }
    return true;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.SpinnerCompat.1
 * JD-Core Version:    0.7.0.1
 */