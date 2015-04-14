package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class TintImageView
  extends ImageView
{
  private static final int[] TINT_ATTRS;
  private final TintManager mTintManager;
  
  static
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = 16842964;
    arrayOfInt[1] = 16843033;
    TINT_ATTRS = arrayOfInt;
  }
  
  public TintImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TintImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TintImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, TINT_ATTRS, paramInt, 0);
    if (localTintTypedArray.length() > 0)
    {
      if (localTintTypedArray.hasValue(0)) {
        setBackgroundDrawable(localTintTypedArray.getDrawable(0));
      }
      if (localTintTypedArray.hasValue(1)) {
        setImageDrawable(localTintTypedArray.getDrawable(1));
      }
    }
    localTintTypedArray.recycle();
    this.mTintManager = localTintTypedArray.getTintManager();
  }
  
  public void setImageResource(int paramInt)
  {
    setImageDrawable(this.mTintManager.getDrawable(paramInt));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.TintImageView
 * JD-Core Version:    0.7.0.1
 */