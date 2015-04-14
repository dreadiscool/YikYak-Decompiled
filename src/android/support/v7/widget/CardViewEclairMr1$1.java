package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

class CardViewEclairMr1$1
  implements RoundRectDrawableWithShadow.RoundRectHelper
{
  CardViewEclairMr1$1(CardViewEclairMr1 paramCardViewEclairMr1) {}
  
  public void drawRoundRect(Canvas paramCanvas, RectF paramRectF, float paramFloat, Paint paramPaint)
  {
    float f1 = 2.0F * paramFloat;
    float f2 = paramRectF.width() - f1 - 1.0F;
    float f3 = paramRectF.height() - f1 - 1.0F;
    if (paramFloat >= 1.0F)
    {
      paramFloat += 0.5F;
      this.this$0.sCornerRect.set(-paramFloat, -paramFloat, paramFloat, paramFloat);
      int i = paramCanvas.save();
      paramCanvas.translate(paramFloat + paramRectF.left, paramFloat + paramRectF.top);
      paramCanvas.drawArc(this.this$0.sCornerRect, 180.0F, 90.0F, true, paramPaint);
      paramCanvas.translate(f2, 0.0F);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawArc(this.this$0.sCornerRect, 180.0F, 90.0F, true, paramPaint);
      paramCanvas.translate(f3, 0.0F);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawArc(this.this$0.sCornerRect, 180.0F, 90.0F, true, paramPaint);
      paramCanvas.translate(f2, 0.0F);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawArc(this.this$0.sCornerRect, 180.0F, 90.0F, true, paramPaint);
      paramCanvas.restoreToCount(i);
      paramCanvas.drawRect(paramFloat + paramRectF.left - 1.0F, paramRectF.top, 1.0F + (paramRectF.right - paramFloat), paramFloat + paramRectF.top, paramPaint);
      paramCanvas.drawRect(paramFloat + paramRectF.left - 1.0F, 1.0F + (paramRectF.bottom - paramFloat), 1.0F + (paramRectF.right - paramFloat), paramRectF.bottom, paramPaint);
    }
    paramCanvas.drawRect(paramRectF.left, paramRectF.top + Math.max(0.0F, paramFloat - 1.0F), paramRectF.right, 1.0F + (paramRectF.bottom - paramFloat), paramPaint);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.CardViewEclairMr1.1
 * JD-Core Version:    0.7.0.1
 */