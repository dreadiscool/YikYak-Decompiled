package com.yik.yak.ui.view;

import BU;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

public class VoteArrowView
  extends ImageView
{
  private boolean a = true;
  private boolean b = false;
  private int c;
  private int d;
  private int e;
  
  public VoteArrowView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  private void a()
  {
    int i;
    if (this.a) {
      if (this.b) {
        i = this.d;
      }
    }
    for (;;)
    {
      setImageDrawable(getContext().getResources().getDrawable(i));
      return;
      i = this.e;
      continue;
      i = this.c;
    }
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = getContext().getTheme().obtainStyledAttributes(paramAttributeSet, BU.VoteArrowView, 0, 0);
    int i = localTypedArray.getIndexCount();
    int j = 0;
    if (j < i)
    {
      int k = localTypedArray.getIndex(j);
      switch (k)
      {
      }
      for (;;)
      {
        j++;
        break;
        this.a = localTypedArray.getBoolean(k, this.a);
        continue;
        this.b = localTypedArray.getBoolean(k, this.b);
        continue;
        this.c = localTypedArray.getResourceId(k, 0);
        continue;
        this.d = localTypedArray.getResourceId(k, 0);
        continue;
        this.e = localTypedArray.getResourceId(k, 0);
      }
    }
    localTypedArray.recycle();
    a();
  }
  
  public boolean isEnabled()
  {
    return this.a;
  }
  
  public boolean isSelected()
  {
    return this.b;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.a != paramBoolean)
    {
      this.a = paramBoolean;
      a();
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    if (this.b != paramBoolean)
    {
      this.b = paramBoolean;
      a();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.view.VoteArrowView
 * JD-Core Version:    0.7.0.1
 */