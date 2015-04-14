package android.support.v4.app;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class BackStackRecord$3
  implements ViewTreeObserver.OnPreDrawListener
{
  BackStackRecord$3(BackStackRecord paramBackStackRecord, View paramView, BackStackRecord.TransitionState paramTransitionState, int paramInt, Object paramObject) {}
  
  public boolean onPreDraw()
  {
    this.val$sceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
    BackStackRecord.access$300(this.this$0, this.val$state, this.val$containerId, this.val$transition);
    return true;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.BackStackRecord.3
 * JD-Core Version:    0.7.0.1
 */