package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

final class FragmentTransitionCompat21$3
  extends Transition.EpicenterCallback
{
  private Rect mEpicenter;
  
  FragmentTransitionCompat21$3(FragmentTransitionCompat21.EpicenterView paramEpicenterView) {}
  
  public Rect onGetEpicenter(Transition paramTransition)
  {
    if ((this.mEpicenter == null) && (this.val$epicenterView.epicenter != null)) {
      this.mEpicenter = FragmentTransitionCompat21.access$100(this.val$epicenterView.epicenter);
    }
    return this.mEpicenter;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentTransitionCompat21.3
 * JD-Core Version:    0.7.0.1
 */