package android.support.v7.internal.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ListPopupWindow;
import android.widget.Spinner;
import java.lang.reflect.Field;

public class TintSpinner
  extends Spinner
{
  private static final int[] TINT_ATTRS;
  
  static
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = 16842964;
    arrayOfInt[1] = 16843126;
    TINT_ATTRS = arrayOfInt;
  }
  
  public TintSpinner(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TintSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842881);
  }
  
  public TintSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, TINT_ATTRS, paramInt, 0);
    setBackgroundDrawable(localTintTypedArray.getDrawable(0));
    Drawable localDrawable;
    if (localTintTypedArray.hasValue(1))
    {
      localDrawable = localTintTypedArray.getDrawable(1);
      if (Build.VERSION.SDK_INT < 16) {
        break label66;
      }
      setPopupBackgroundDrawable(localDrawable);
    }
    for (;;)
    {
      localTintTypedArray.recycle();
      return;
      label66:
      if (Build.VERSION.SDK_INT >= 11) {
        setPopupBackgroundDrawableV11(this, localDrawable);
      }
    }
  }
  
  @TargetApi(11)
  private static void setPopupBackgroundDrawableV11(Spinner paramSpinner, Drawable paramDrawable)
  {
    try
    {
      Field localField = Spinner.class.getDeclaredField("mPopup");
      localField.setAccessible(true);
      Object localObject = localField.get(paramSpinner);
      if ((localObject instanceof ListPopupWindow)) {
        ((ListPopupWindow)localObject).setBackgroundDrawable(paramDrawable);
      }
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        localNoSuchFieldException.printStackTrace();
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.TintSpinner
 * JD-Core Version:    0.7.0.1
 */