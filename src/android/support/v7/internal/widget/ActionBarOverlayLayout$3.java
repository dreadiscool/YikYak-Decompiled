package android.support.v7.internal.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;

class ActionBarOverlayLayout$3
  implements Runnable
{
  ActionBarOverlayLayout$3(ActionBarOverlayLayout paramActionBarOverlayLayout) {}
  
  public void run()
  {
    ActionBarOverlayLayout.access$300(this.this$0);
    ActionBarOverlayLayout.access$002(this.this$0, ViewCompat.animate(ActionBarOverlayLayout.access$500(this.this$0)).translationY(0.0F).setListener(ActionBarOverlayLayout.access$400(this.this$0)));
    if ((ActionBarOverlayLayout.access$600(this.this$0) != null) && (ActionBarOverlayLayout.access$600(this.this$0).getVisibility() != 8)) {
      ActionBarOverlayLayout.access$202(this.this$0, ViewCompat.animate(ActionBarOverlayLayout.access$600(this.this$0)).translationY(0.0F).setListener(ActionBarOverlayLayout.access$700(this.this$0)));
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActionBarOverlayLayout.3
 * JD-Core Version:    0.7.0.1
 */