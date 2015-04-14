package com.yik.yak.ui.view;

import Hm;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class LinkIconView
  extends ImageView
{
  private Hm a = Hm.c;
  
  public LinkIconView(Context paramContext)
  {
    super(paramContext);
  }
  
  public LinkIconView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LinkIconView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public Hm a()
  {
    return this.a;
  }
  
  public void setIconState(Hm paramHm)
  {
    if (this.a == paramHm) {
      return;
    }
    switch (Hl.a[paramHm.ordinal()])
    {
    }
    for (;;)
    {
      this.a = paramHm;
      break;
      setImageResource(2130837758);
      continue;
      setImageResource(2130837759);
      continue;
      setImageResource(2130837760);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.view.LinkIconView
 * JD-Core Version:    0.7.0.1
 */