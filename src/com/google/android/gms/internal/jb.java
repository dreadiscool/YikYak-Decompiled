package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.net.Uri;
import android.widget.ImageView;
import hr;

public final class jb
  extends ImageView
{
  private Uri a;
  private int b;
  private int c;
  private hr d;
  private int e;
  private float f;
  
  public int a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(Uri paramUri)
  {
    this.a = paramUri;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.d != null) {
      paramCanvas.clipPath(this.d.a(getWidth(), getHeight()));
    }
    super.onDraw(paramCanvas);
    if (this.c != 0) {
      paramCanvas.drawColor(this.c);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int j;
    int i;
    switch (this.e)
    {
    default: 
      return;
    case 1: 
      j = getMeasuredHeight();
      i = (int)(j * this.f);
    }
    for (;;)
    {
      setMeasuredDimension(i, j);
      break;
      i = getMeasuredWidth();
      j = (int)(i / this.f);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jb
 * JD-Core Version:    0.7.0.1
 */