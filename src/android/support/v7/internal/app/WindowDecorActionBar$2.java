package android.support.v7.internal.app;

import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.internal.widget.ActionBarContainer;
import android.view.View;

class WindowDecorActionBar$2
  extends ViewPropertyAnimatorListenerAdapter
{
  WindowDecorActionBar$2(WindowDecorActionBar paramWindowDecorActionBar) {}
  
  public void onAnimationEnd(View paramView)
  {
    WindowDecorActionBar.access$502(this.this$0, null);
    WindowDecorActionBar.access$200(this.this$0).requestLayout();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.app.WindowDecorActionBar.2
 * JD-Core Version:    0.7.0.1
 */