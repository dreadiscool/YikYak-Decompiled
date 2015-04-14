package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;

public class TintCheckBox
  extends CheckBox
{
  private static final int[] TINT_ATTRS;
  private final TintManager mTintManager;
  
  static
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 16843015;
    TINT_ATTRS = arrayOfInt;
  }
  
  public TintCheckBox(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TintCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842860);
  }
  
  public TintCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, TINT_ATTRS, paramInt, 0);
    setButtonDrawable(localTintTypedArray.getDrawable(0));
    localTintTypedArray.recycle();
    this.mTintManager = localTintTypedArray.getTintManager();
  }
  
  public void setButtonDrawable(int paramInt)
  {
    setButtonDrawable(this.mTintManager.getDrawable(paramInt));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.TintCheckBox
 * JD-Core Version:    0.7.0.1
 */