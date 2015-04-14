package com.mixpanel.android.surveys;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;

public class MiniCircleImageView
  extends ImageView
{
  private Paint a;
  private int b;
  private int c;
  
  public MiniCircleImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public MiniCircleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public MiniCircleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = new Paint(1);
    this.a.setColor(getResources().getColor(17170443));
    this.a.setStyle(Paint.Style.STROKE);
    float f = TypedValue.applyDimension(1, 2.0F, getResources().getDisplayMetrics());
    this.a.setStrokeWidth(f);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1 = this.b / 2;
    float f2 = this.c / 2;
    paramCanvas.drawCircle(f1, f2, 0.7F * Math.min(f1, f2), this.a);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.b = paramInt1;
    this.c = paramInt2;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.mixpanel.android.surveys.MiniCircleImageView
 * JD-Core Version:    0.7.0.1
 */