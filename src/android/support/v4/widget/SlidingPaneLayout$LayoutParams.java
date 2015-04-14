package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class SlidingPaneLayout$LayoutParams
  extends ViewGroup.MarginLayoutParams
{
  private static final int[] ATTRS;
  Paint dimPaint;
  boolean dimWhenOffset;
  boolean slideable;
  public float weight = 0.0F;
  
  static
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 16843137;
    ATTRS = arrayOfInt;
  }
  
  public SlidingPaneLayout$LayoutParams()
  {
    super(-1, -1);
  }
  
  public SlidingPaneLayout$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public SlidingPaneLayout$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, ATTRS);
    this.weight = localTypedArray.getFloat(0, 0.0F);
    localTypedArray.recycle();
  }
  
  public SlidingPaneLayout$LayoutParams(LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    this.weight = paramLayoutParams.weight;
  }
  
  public SlidingPaneLayout$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public SlidingPaneLayout$LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.SlidingPaneLayout.LayoutParams
 * JD-Core Version:    0.7.0.1
 */