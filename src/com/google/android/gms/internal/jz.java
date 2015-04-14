package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.Button;
import ff;
import fg;
import fh;
import hZ;

public final class jz
  extends Button
{
  public jz(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public jz(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 16842824);
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt1)
    {
    default: 
      throw new IllegalStateException("Unknown color scheme: " + paramInt1);
    case 1: 
      paramInt2 = paramInt3;
    }
    return paramInt2;
  }
  
  private void a(Resources paramResources)
  {
    setTypeface(Typeface.DEFAULT_BOLD);
    setTextSize(14.0F);
    float f = paramResources.getDisplayMetrics().density;
    setMinHeight((int)(0.5F + f * 48.0F));
    setMinWidth((int)(0.5F + f * 48.0F));
  }
  
  private void b(Resources paramResources, int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      throw new IllegalStateException("Unknown button size: " + paramInt1);
    }
    for (int i = a(paramInt2, fg.common_signin_btn_text_dark, fg.common_signin_btn_text_light); i == -1; i = a(paramInt2, fg.common_signin_btn_icon_dark, fg.common_signin_btn_icon_light)) {
      throw new IllegalStateException("Could not find background resource!");
    }
    setBackgroundDrawable(paramResources.getDrawable(i));
  }
  
  private void c(Resources paramResources, int paramInt1, int paramInt2)
  {
    setTextColor(paramResources.getColorStateList(a(paramInt2, ff.common_signin_btn_text_dark, ff.common_signin_btn_text_light)));
    switch (paramInt1)
    {
    default: 
      throw new IllegalStateException("Unknown button size: " + paramInt1);
    case 0: 
      setText(paramResources.getString(fh.common_signin_button_text));
    }
    for (;;)
    {
      return;
      setText(paramResources.getString(fh.common_signin_button_text_long));
      continue;
      setText(null);
    }
  }
  
  public void a(Resources paramResources, int paramInt1, int paramInt2)
  {
    boolean bool1;
    if ((paramInt1 >= 0) && (paramInt1 < 3))
    {
      bool1 = true;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(paramInt1);
      hZ.a(bool1, "Unknown button size %d", arrayOfObject1);
      if ((paramInt2 < 0) || (paramInt2 >= 2)) {
        break label96;
      }
    }
    label96:
    for (boolean bool2 = true;; bool2 = false)
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(paramInt2);
      hZ.a(bool2, "Unknown color scheme %s", arrayOfObject2);
      a(paramResources);
      b(paramResources, paramInt1, paramInt2);
      c(paramResources, paramInt1, paramInt2);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jz
 * JD-Core Version:    0.7.0.1
 */