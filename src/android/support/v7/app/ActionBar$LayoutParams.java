package android.support.v7.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class ActionBar$LayoutParams
  extends ViewGroup.MarginLayoutParams
{
  public int gravity = 0;
  
  public ActionBar$LayoutParams(int paramInt)
  {
    this(-2, -1, paramInt);
  }
  
  public ActionBar$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    this.gravity = 8388627;
  }
  
  public ActionBar$LayoutParams(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2);
    this.gravity = paramInt3;
  }
  
  public ActionBar$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionBarLayout);
    this.gravity = localTypedArray.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
    localTypedArray.recycle();
  }
  
  public ActionBar$LayoutParams(LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    this.gravity = paramLayoutParams.gravity;
  }
  
  public ActionBar$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBar.LayoutParams
 * JD-Core Version:    0.7.0.1
 */