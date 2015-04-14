package android.support.v7.internal.widget;

import android.support.v4.view.ActionProvider;
import android.support.v7.widget.ListPopupWindow;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class ActivityChooserView$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ActivityChooserView$2(ActivityChooserView paramActivityChooserView) {}
  
  public void onGlobalLayout()
  {
    if (this.this$0.isShowingPopup())
    {
      if (this.this$0.isShown()) {
        break label31;
      }
      ActivityChooserView.access$100(this.this$0).dismiss();
    }
    for (;;)
    {
      return;
      label31:
      ActivityChooserView.access$100(this.this$0).show();
      if (this.this$0.mProvider != null) {
        this.this$0.mProvider.subUiVisibilityChanged(true);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActivityChooserView.2
 * JD-Core Version:    0.7.0.1
 */