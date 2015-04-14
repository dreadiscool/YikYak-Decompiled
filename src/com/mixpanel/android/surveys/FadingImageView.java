package com.mixpanel.android.surveys;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import tn;

public class FadingImageView
  extends ImageView
{
  private Matrix a;
  private Paint b;
  private Shader c;
  private Paint d;
  private Shader e;
  private int f;
  private int g;
  
  public FadingImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public FadingImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public FadingImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = new Matrix();
    this.b = new Paint();
    int[] arrayOfInt1 = new int[4];
    arrayOfInt1[0] = -16777216;
    arrayOfInt1[1] = -16777216;
    arrayOfInt1[2] = -452984832;
    arrayOfInt1[3] = 0;
    float[] arrayOfFloat1 = new float[4];
    arrayOfFloat1[0] = 0.0F;
    arrayOfFloat1[1] = 0.7F;
    arrayOfFloat1[2] = 0.8F;
    arrayOfFloat1[3] = 1.0F;
    this.c = new LinearGradient(0.0F, 0.0F, 0.0F, 1.0F, arrayOfInt1, arrayOfFloat1, Shader.TileMode.CLAMP);
    this.b.setShader(this.c);
    this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    this.d = new Paint();
    int[] arrayOfInt2 = new int[4];
    arrayOfInt2[0] = 0;
    arrayOfInt2[1] = 0;
    arrayOfInt2[2] = -16777216;
    arrayOfInt2[3] = -16777216;
    float[] arrayOfFloat2 = new float[4];
    arrayOfFloat2[0] = 0.0F;
    arrayOfFloat2[1] = 0.85F;
    arrayOfFloat2[2] = 0.98F;
    arrayOfFloat2[3] = 1.0F;
    this.e = new LinearGradient(0.0F, 0.0F, 0.0F, 1.0F, arrayOfInt2, arrayOfFloat2, Shader.TileMode.CLAMP);
    this.d.setShader(this.e);
    this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = paramCanvas.getClipBounds();
    int i = paramCanvas.saveLayer(0.0F, 0.0F, localRect.width(), localRect.height(), null, 31);
    super.draw(paramCanvas);
    if (getResources().getConfiguration().orientation == 1) {
      paramCanvas.drawRect(0.0F, 0.0F, this.g, this.f, this.b);
    }
    for (;;)
    {
      paramCanvas.restoreToCount(i);
      return;
      paramCanvas.drawRect(getPaddingLeft(), getPaddingTop(), this.g - getPaddingRight(), this.f - getPaddingBottom(), this.d);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.f = getHeight();
    this.g = getWidth();
    int i = View.MeasureSpec.getSize(paramInt2);
    if (getResources().getConfiguration().orientation == 1)
    {
      View localView = getRootView().findViewById(tn.com_mixpanel_android_notification_bottom_wrapper);
      int j = 0;
      if ((localView != null) && (localView.getHeight() != 0)) {
        j = localView.getHeight();
      }
      float f1 = TypedValue.applyDimension(1, 15.0F, getResources().getDisplayMetrics());
      this.a.setScale(1.0F, f1 + (i - j));
    }
    for (;;)
    {
      this.c.setLocalMatrix(this.a);
      this.e.setLocalMatrix(this.a);
      return;
      this.a.setScale(1.0F, i);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.mixpanel.android.surveys.FadingImageView
 * JD-Core Version:    0.7.0.1
 */