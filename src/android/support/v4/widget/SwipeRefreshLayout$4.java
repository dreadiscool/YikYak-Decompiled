package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwipeRefreshLayout$4
  extends Animation
{
  SwipeRefreshLayout$4(SwipeRefreshLayout paramSwipeRefreshLayout, int paramInt1, int paramInt2) {}
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    SwipeRefreshLayout.access$100(this.this$0).setAlpha((int)(this.val$startingAlpha + paramFloat * (this.val$endingAlpha - this.val$startingAlpha)));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.SwipeRefreshLayout.4
 * JD-Core Version:    0.7.0.1
 */