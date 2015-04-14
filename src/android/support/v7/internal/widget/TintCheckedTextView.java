package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckedTextView;

public class TintCheckedTextView
  extends CheckedTextView
{
  private static final int[] TINT_ATTRS;
  private final TintManager mTintManager;
  
  static
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 16843016;
    TINT_ATTRS = arrayOfInt;
  }
  
  public TintCheckedTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TintCheckedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16843720);
  }
  
  public TintCheckedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, TINT_ATTRS, paramInt, 0);
    setCheckMarkDrawable(localTintTypedArray.getDrawable(0));
    localTintTypedArray.recycle();
    this.mTintManager = localTintTypedArray.getTintManager();
  }
  
  public void setCheckMarkDrawable(int paramInt)
  {
    setCheckMarkDrawable(this.mTintManager.getDrawable(paramInt));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.TintCheckedTextView
 * JD-Core Version:    0.7.0.1
 */