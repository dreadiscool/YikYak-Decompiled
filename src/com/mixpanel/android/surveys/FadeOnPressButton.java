package com.mixpanel.android.surveys;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

@TargetApi(16)
public class FadeOnPressButton
  extends Button
{
  private boolean a;
  
  public FadeOnPressButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public FadeOnPressButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FadeOnPressButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(float paramFloat)
  {
    setAlpha(paramFloat);
  }
  
  protected void drawableStateChanged()
  {
    int i = 0;
    int[] arrayOfInt = getDrawableState();
    int j = arrayOfInt.length;
    for (int k = 0;; k++) {
      if (k < j)
      {
        if (arrayOfInt[k] == 16842919)
        {
          if (!this.a) {
            a(0.5F);
          }
          i = 1;
        }
      }
      else
      {
        if ((this.a) && (i == 0))
        {
          a(1.0F);
          this.a = true;
        }
        super.drawableStateChanged();
        return;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.mixpanel.android.surveys.FadeOnPressButton
 * JD-Core Version:    0.7.0.1
 */