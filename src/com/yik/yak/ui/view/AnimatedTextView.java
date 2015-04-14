package com.yik.yak.ui.view;

import BU;
import Hf;
import Hg;
import Hi;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import java.util.Iterator;
import java.util.LinkedList;

public class AnimatedTextView
  extends View
{
  private static final String a = AnimatedTextView.class.getSimpleName();
  private final int b = 80;
  private final int c = 10;
  private LinkedList<Hg> d = new LinkedList();
  private int e;
  private int f;
  private Paint g;
  private Paint h;
  
  public AnimatedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    int i = 0;
    TypedArray localTypedArray = getContext().getTheme().obtainStyledAttributes(paramAttributeSet, BU.AnimatedTextView, 0, 0);
    int j = localTypedArray.getIndexCount();
    if (i < j)
    {
      int k = localTypedArray.getIndex(i);
      switch (k)
      {
      }
      for (;;)
      {
        i++;
        break;
        setNumber(localTypedArray.getInt(k, 10));
        continue;
        setColor(localTypedArray.getColor(k, -16777216));
        continue;
        setTextSize(localTypedArray.getDimensionPixelSize(k, 80));
      }
    }
    localTypedArray.recycle();
  }
  
  private void a(String paramString, Hi paramHi, boolean paramBoolean)
  {
    int i;
    if (g()) {
      i = 1;
    }
    for (;;)
    {
      if (i < this.d.size())
      {
        int j = Integer.valueOf("" + paramString.charAt(i)).intValue();
        ((Hg)this.d.get(i)).a(j, paramHi);
        i++;
      }
      else
      {
        if (paramBoolean) {
          requestLayout();
        }
        for (;;)
        {
          return;
          invalidate();
        }
        i = 0;
      }
    }
  }
  
  private boolean a(String paramString)
  {
    int i = paramString.replace("-", "").length();
    int k;
    if (this.f < 0)
    {
      bool = e();
      int j = h();
      if (i == j) {
        return bool;
      }
      k = j;
      label40:
      if (k == i) {
        break label82;
      }
      if (k <= i) {
        break label74;
      }
      d();
    }
    for (;;)
    {
      k = h();
      break label40;
      bool = f();
      break;
      label74:
      c();
    }
    label82:
    boolean bool = true;
    return bool;
  }
  
  private void b()
  {
    this.h = new Paint();
    this.h.setTextAlign(Paint.Align.CENTER);
    this.g = new Paint();
    this.g.setColor(-65536);
    this.g.setStyle(Paint.Style.STROKE);
  }
  
  private boolean c()
  {
    Hg localHg1 = new Hg(this);
    if (g())
    {
      Hg localHg2 = (Hg)this.d.removeFirst();
      this.d.addFirst(localHg1);
      this.d.addFirst(localHg2);
    }
    for (;;)
    {
      return true;
      this.d.addFirst(localHg1);
    }
  }
  
  private boolean d()
  {
    if (this.d.isEmpty()) {}
    for (boolean bool = false;; bool = true)
    {
      return bool;
      Hg localHg = (Hg)this.d.getFirst();
      if ((localHg instanceof Hf)) {
        localHg = (Hg)this.d.get(1);
      }
      this.d.remove(localHg);
    }
  }
  
  private boolean e()
  {
    if (!g()) {
      this.d.addFirst(new Hf(this));
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean f()
  {
    if (g()) {
      this.d.removeFirst();
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean g()
  {
    if ((!this.d.isEmpty()) && ((this.d.getFirst() instanceof Hf))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private int h()
  {
    int i = this.d.size();
    if (g()) {
      i--;
    }
    return i;
  }
  
  private void i()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((Hg)localIterator.next()).c();
    }
  }
  
  private void j()
  {
    this.e = 0;
    if (!this.d.isEmpty())
    {
      String str = ((Hg)this.d.get(0)).a();
      Rect localRect = new Rect();
      this.h.getTextBounds("4", 0, str.length(), localRect);
      this.e += localRect.width();
    }
  }
  
  public int a()
  {
    return (int)this.h.getTextSize();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getHeight() / 2;
    int j = this.e * this.d.size();
    int k = getWidth() / 2 - j / 2;
    for (int m = 0; m < this.d.size(); m++)
    {
      ((Hg)this.d.get(m)).a(paramCanvas, k + this.e / 2, i, this.h);
      k += this.e;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    j();
    int i = getPaddingLeft() + getPaddingRight();
    int j = getPaddingTop() + getPaddingBottom();
    setMeasuredDimension(24 + (i + this.e * this.d.size()), (int)(1.25D * (j + a())));
  }
  
  public void setColor(int paramInt)
  {
    this.h.setColor(paramInt);
    invalidate();
  }
  
  public void setNumber(int paramInt)
  {
    Hi localHi;
    if (paramInt > this.f) {
      if (paramInt > 0) {
        localHi = Hi.a;
      }
    }
    for (;;)
    {
      setNumber(paramInt, localHi);
      do
      {
        return;
        localHi = Hi.b;
        break;
      } while (paramInt >= this.f);
      if (paramInt >= 0) {
        localHi = Hi.b;
      } else {
        localHi = Hi.a;
      }
    }
  }
  
  public void setNumber(int paramInt, Hi paramHi)
  {
    i();
    this.f = paramInt;
    String str = String.valueOf(paramInt);
    a(str, paramHi, a(str));
  }
  
  public void setTextSize(int paramInt)
  {
    this.h.setTextSize(paramInt);
    requestLayout();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.view.AnimatedTextView
 * JD-Core Version:    0.7.0.1
 */