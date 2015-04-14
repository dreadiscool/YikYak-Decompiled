package com.mixpanel.android.surveys;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.animation.Animation;
import android.widget.CheckedTextView;
import vP;

public class SurveyChoiceView
  extends CheckedTextView
{
  private Drawable a;
  private float b;
  private float c;
  
  public SurveyChoiceView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public SurveyChoiceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public SurveyChoiceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.b = 0.0F;
    this.c = 1.5F;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = 0;
    Drawable localDrawable = this.a;
    float f = getResources().getDisplayMetrics().density;
    if ((localDrawable != null) && (isChecked())) {}
    for (int j = (int)(14.0F * f);; j = 0)
    {
      int k = (int)(12.0F * f);
      int m = (int)(f * 22.0F);
      setCheckMarkDrawable(null);
      setPadding((int)(m + this.c * j), k, m, k);
      super.onDraw(paramCanvas);
      int n = (int)(m + this.b * j);
      setPadding(n, k, m, k);
      setCheckMarkDrawable(localDrawable);
      if (localDrawable != null) {
        switch (0x70 & getGravity())
        {
        }
      }
      for (;;)
      {
        int i1 = i + j;
        int i2 = j + n;
        localDrawable.setBounds(n + getScrollX(), i, i2 + getScrollX(), i1);
        localDrawable.draw(paramCanvas);
        setPadding(m, k, m, k);
        return;
        i = getHeight() - j;
        continue;
        i = (getHeight() - j) / 2;
      }
    }
  }
  
  public void setCheckMarkDrawable(Drawable paramDrawable)
  {
    super.setCheckMarkDrawable(paramDrawable);
    this.a = paramDrawable;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    boolean bool = isChecked();
    super.setChecked(paramBoolean);
    if ((isChecked()) && (!bool))
    {
      vP localvP = new vP(this, null);
      localvP.setDuration(300L);
      startAnimation(localvP);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.mixpanel.android.surveys.SurveyChoiceView
 * JD-Core Version:    0.7.0.1
 */