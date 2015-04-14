package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.shapes.OvalShape;

class CircleImageView$OvalShadow
  extends OvalShape
{
  private int mCircleDiameter;
  private RadialGradient mRadialGradient;
  private Paint mShadowPaint = new Paint();
  private int mShadowRadius;
  
  public CircleImageView$OvalShadow(CircleImageView paramCircleImageView, int paramInt1, int paramInt2)
  {
    this.mShadowRadius = paramInt1;
    this.mCircleDiameter = paramInt2;
    float f1 = this.mCircleDiameter / 2;
    float f2 = this.mCircleDiameter / 2;
    float f3 = this.mShadowRadius;
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = 1023410176;
    arrayOfInt[1] = 0;
    this.mRadialGradient = new RadialGradient(f1, f2, f3, arrayOfInt, null, Shader.TileMode.CLAMP);
    this.mShadowPaint.setShader(this.mRadialGradient);
  }
  
  public void draw(Canvas paramCanvas, Paint paramPaint)
  {
    int i = this.this$0.getWidth();
    int j = this.this$0.getHeight();
    paramCanvas.drawCircle(i / 2, j / 2, this.mCircleDiameter / 2 + this.mShadowRadius, this.mShadowPaint);
    paramCanvas.drawCircle(i / 2, j / 2, this.mCircleDiameter / 2, paramPaint);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.CircleImageView.OvalShadow
 * JD-Core Version:    0.7.0.1
 */