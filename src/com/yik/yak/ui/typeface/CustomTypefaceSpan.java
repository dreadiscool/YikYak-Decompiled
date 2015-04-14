package com.yik.yak.ui.typeface;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

public class CustomTypefaceSpan
  extends TypefaceSpan
{
  private final Typeface a;
  private int b;
  
  public CustomTypefaceSpan(int paramInt, Typeface paramTypeface)
  {
    super("");
    this.a = paramTypeface;
    this.b = paramInt;
  }
  
  private void a(Paint paramPaint, Typeface paramTypeface)
  {
    Typeface localTypeface = paramPaint.getTypeface();
    if (localTypeface == null) {}
    for (int i = 0;; i = localTypeface.getStyle())
    {
      paramPaint.setColor(this.b);
      int j = i & (0xFFFFFFFF ^ paramTypeface.getStyle());
      if ((j & 0x1) != 0) {
        paramPaint.setFakeBoldText(true);
      }
      if ((j & 0x2) != 0) {
        paramPaint.setTextSkewX(-0.25F);
      }
      paramPaint.setTypeface(paramTypeface);
      return;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    a(paramTextPaint, this.a);
  }
  
  public void updateMeasureState(TextPaint paramTextPaint)
  {
    a(paramTextPaint, this.a);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.typeface.CustomTypefaceSpan
 * JD-Core Version:    0.7.0.1
 */