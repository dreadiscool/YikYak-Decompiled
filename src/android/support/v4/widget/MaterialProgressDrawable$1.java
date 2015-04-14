package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;

class MaterialProgressDrawable$1
  extends Animation
{
  MaterialProgressDrawable$1(MaterialProgressDrawable paramMaterialProgressDrawable, MaterialProgressDrawable.Ring paramRing) {}
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (this.this$0.mFinishing) {
      MaterialProgressDrawable.access$200(this.this$0, paramFloat, this.val$ring);
    }
    for (;;)
    {
      return;
      float f1 = (float)Math.toRadians(this.val$ring.getStrokeWidth() / (6.283185307179586D * this.val$ring.getCenterRadius()));
      float f2 = this.val$ring.getStartingEndTrim();
      float f3 = this.val$ring.getStartingStartTrim();
      float f4 = this.val$ring.getStartingRotation();
      float f5 = f2 + (0.8F - f1) * MaterialProgressDrawable.access$300().getInterpolation(paramFloat);
      this.val$ring.setEndTrim(f5);
      float f6 = f3 + 0.8F * MaterialProgressDrawable.access$400().getInterpolation(paramFloat);
      this.val$ring.setStartTrim(f6);
      float f7 = f4 + 0.25F * paramFloat;
      this.val$ring.setRotation(f7);
      float f8 = 144.0F * paramFloat + 720.0F * (MaterialProgressDrawable.access$500(this.this$0) / 5.0F);
      this.this$0.setRotation(f8);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.MaterialProgressDrawable.1
 * JD-Core Version:    0.7.0.1
 */