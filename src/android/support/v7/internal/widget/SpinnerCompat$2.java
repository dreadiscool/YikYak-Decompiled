package android.support.v7.internal.widget;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class SpinnerCompat$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  SpinnerCompat$2(SpinnerCompat paramSpinnerCompat) {}
  
  public void onGlobalLayout()
  {
    if (!SpinnerCompat.access$100(this.this$0).isShowing()) {
      SpinnerCompat.access$100(this.this$0).show();
    }
    ViewTreeObserver localViewTreeObserver = this.this$0.getViewTreeObserver();
    if (localViewTreeObserver != null) {
      localViewTreeObserver.removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.SpinnerCompat.2
 * JD-Core Version:    0.7.0.1
 */