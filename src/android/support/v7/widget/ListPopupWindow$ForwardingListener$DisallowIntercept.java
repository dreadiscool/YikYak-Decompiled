package android.support.v7.widget;

import android.view.View;
import android.view.ViewParent;

class ListPopupWindow$ForwardingListener$DisallowIntercept
  implements Runnable
{
  private ListPopupWindow$ForwardingListener$DisallowIntercept(ListPopupWindow.ForwardingListener paramForwardingListener) {}
  
  public void run()
  {
    ListPopupWindow.ForwardingListener.access$900(this.this$0).getParent().requestDisallowInterceptTouchEvent(true);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ListPopupWindow.ForwardingListener.DisallowIntercept
 * JD-Core Version:    0.7.0.1
 */