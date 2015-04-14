package com.nispok.snackbar.layouts;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;

public class SnackbarLayout
  extends LinearLayout
{
  private int a = 2147483647;
  private int b = 2147483647;
  
  public SnackbarLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public SnackbarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SnackbarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    if (this.a < i)
    {
      int m = View.MeasureSpec.getMode(paramInt1);
      paramInt1 = View.MeasureSpec.makeMeasureSpec(this.a, m);
    }
    int j = View.MeasureSpec.getSize(paramInt2);
    if (this.b < j)
    {
      int k = View.MeasureSpec.getMode(paramInt2);
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.b, k);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.b = paramInt;
    requestLayout();
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.a = paramInt;
    requestLayout();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.nispok.snackbar.layouts.SnackbarLayout
 * JD-Core Version:    0.7.0.1
 */