package android.support.v7.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwitchCompat$1
  extends Animation
{
  SwitchCompat$1(SwitchCompat paramSwitchCompat, float paramFloat1, float paramFloat2) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    SwitchCompat.access$000(this.this$0, this.val$startPosition + paramFloat * this.val$diff);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.SwitchCompat.1
 * JD-Core Version:    0.7.0.1
 */