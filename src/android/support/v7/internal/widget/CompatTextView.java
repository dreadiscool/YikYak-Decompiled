package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.text.AllCapsTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

public class CompatTextView
  extends TextView
{
  public CompatTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CompatTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CompatTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CompatTextView, paramInt, 0);
    boolean bool = localTypedArray.getBoolean(R.styleable.CompatTextView_textAllCaps, false);
    localTypedArray.recycle();
    if (bool) {
      setTransformationMethod(new AllCapsTransformationMethod(paramContext));
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.CompatTextView
 * JD-Core Version:    0.7.0.1
 */