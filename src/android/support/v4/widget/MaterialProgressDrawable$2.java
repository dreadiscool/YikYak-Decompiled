package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class MaterialProgressDrawable$2
  implements Animation.AnimationListener
{
  MaterialProgressDrawable$2(MaterialProgressDrawable paramMaterialProgressDrawable, MaterialProgressDrawable.Ring paramRing) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    this.val$ring.storeOriginals();
    this.val$ring.goToNextColor();
    this.val$ring.setStartTrim(this.val$ring.getEndTrim());
    if (this.this$0.mFinishing)
    {
      this.this$0.mFinishing = false;
      paramAnimation.setDuration(1333L);
      this.val$ring.setShowArrow(false);
    }
    for (;;)
    {
      return;
      MaterialProgressDrawable.access$502(this.this$0, (1.0F + MaterialProgressDrawable.access$500(this.this$0)) % 5.0F);
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    MaterialProgressDrawable.access$502(this.this$0, 0.0F);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.MaterialProgressDrawable.2
 * JD-Core Version:    0.7.0.1
 */