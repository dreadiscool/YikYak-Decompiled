package android.support.v7.internal.widget;

import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.widget.Toolbar;
import android.view.View;

class ToolbarWidgetWrapper$2
  extends ViewPropertyAnimatorListenerAdapter
{
  private boolean mCanceled = false;
  
  ToolbarWidgetWrapper$2(ToolbarWidgetWrapper paramToolbarWidgetWrapper) {}
  
  public void onAnimationCancel(View paramView)
  {
    this.mCanceled = true;
  }
  
  public void onAnimationEnd(View paramView)
  {
    if (!this.mCanceled) {
      ToolbarWidgetWrapper.access$000(this.this$0).setVisibility(8);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ToolbarWidgetWrapper.2
 * JD-Core Version:    0.7.0.1
 */