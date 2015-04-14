package com.yik.yak.ui.pullrefresh;

import BU;
import GV;
import GX;
import GY;
import GZ;
import Ha;
import Hb;
import Hc;
import Hd;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.ImageView;
import java.security.InvalidParameterException;

public class PullRefreshLayout
  extends ViewGroup
{
  private final Animation a = new GX(this);
  private View b;
  private ImageView c;
  private Interpolator d;
  private int e;
  private int f;
  private int g;
  private int h;
  private Hc i;
  private int j;
  private Animation.AnimationListener k = new GY(this);
  private boolean l;
  private int m;
  private boolean n;
  private float o;
  private int p;
  private final Animation q = new GZ(this);
  private boolean r;
  private Context s;
  private Hb t;
  private Animation.AnimationListener u = new Ha(this);
  private int[] v;
  private AttributeSet w;
  
  public PullRefreshLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PullRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {}
    for (;;)
    {
      return;
      this.w = paramAttributeSet;
      this.s = paramContext;
      TypedArray localTypedArray = this.s.obtainStyledAttributes(this.w, BU.PullRefreshLayout);
      int i1 = localTypedArray.getInteger(0, 1);
      int i2 = localTypedArray.getResourceId(1, 2131296258);
      localTypedArray.recycle();
      this.v = this.s.getResources().getIntArray(i2);
      this.d = new DecelerateInterpolator(2.0F);
      this.e = ViewConfiguration.get(paramContext).getScaledTouchSlop();
      this.f = getResources().getInteger(17694721);
      int i3 = a(64);
      this.h = i3;
      this.g = i3;
      this.c = new ImageView(paramContext);
      setRefreshStyle(i1);
      this.c.setVisibility(8);
      addView(this.c);
      setWillNotDraw(false);
    }
  }
  
  private float a(MotionEvent paramMotionEvent, int paramInt)
  {
    int i1 = MotionEventCompat.findPointerIndex(paramMotionEvent, paramInt);
    if (i1 < 0) {}
    for (float f1 = -1.0F;; f1 = MotionEventCompat.getY(paramMotionEvent, i1)) {
      return f1;
    }
  }
  
  private int a(int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, getContext().getResources().getDisplayMetrics());
  }
  
  private void a(float paramFloat)
  {
    a(this.p - (int)(paramFloat * this.p) - this.b.getTop(), false);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    this.c.bringToFront();
    this.b.offsetTopAndBottom(paramInt);
    this.i.a(paramInt);
    this.j = this.b.getTop();
    if ((paramBoolean) && (Build.VERSION.SDK_INT < 11)) {
      invalidate();
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i1) == this.m) {
      if (i1 != 0) {
        break label33;
      }
    }
    label33:
    for (int i2 = 1;; i2 = 0)
    {
      this.m = MotionEventCompat.getPointerId(paramMotionEvent, i2);
      return;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.l != paramBoolean1)
    {
      this.r = paramBoolean2;
      c();
      this.l = paramBoolean1;
      if (!this.l) {
        break label34;
      }
      e();
    }
    for (;;)
    {
      return;
      label34:
      d();
    }
  }
  
  private void c()
  {
    if (this.b != null) {}
    for (;;)
    {
      return;
      if (getChildCount() > 0) {
        for (int i1 = 0; i1 < getChildCount(); i1++)
        {
          View localView = getChildAt(i1);
          if (localView != this.c) {
            this.b = localView;
          }
        }
      }
    }
  }
  
  private void d()
  {
    this.p = this.j;
    this.a.reset();
    this.a.setDuration(this.f);
    this.a.setInterpolator(this.d);
    this.a.setAnimationListener(this.k);
    this.c.clearAnimation();
    this.c.startAnimation(this.a);
  }
  
  private void e()
  {
    this.p = this.j;
    this.q.reset();
    this.q.setDuration(this.f);
    this.q.setInterpolator(this.d);
    this.q.setAnimationListener(this.u);
    this.c.clearAnimation();
    this.c.startAnimation(this.q);
  }
  
  private boolean f()
  {
    boolean bool1 = true;
    boolean bool2;
    if (Build.VERSION.SDK_INT < 14) {
      if ((this.b instanceof AbsListView))
      {
        AbsListView localAbsListView = (AbsListView)this.b;
        if ((localAbsListView.getChildCount() > 0) && ((localAbsListView.getFirstVisiblePosition() > 0) || (localAbsListView.getChildAt(0).getTop() < localAbsListView.getPaddingTop()))) {
          bool2 = bool1;
        }
      }
    }
    for (;;)
    {
      return bool2;
      bool2 = false;
      continue;
      if (this.b.getScrollY() > 0) {}
      for (;;)
      {
        bool2 = bool1;
        break;
        bool1 = false;
      }
      bool2 = ViewCompat.canScrollVertically(this.b, -1);
    }
  }
  
  public boolean a()
  {
    if (this.i == null) {}
    for (boolean bool = false;; bool = this.i.isRunning()) {
      return bool;
    }
  }
  
  public int b()
  {
    return this.g;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if ((!isEnabled()) || (f()) || (this.l)) {
      return bool;
    }
    switch (MotionEventCompat.getActionMasked(paramMotionEvent))
    {
    }
    for (;;)
    {
      bool = this.n;
      break;
      a(0, true);
      this.m = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      this.n = false;
      float f2 = a(paramMotionEvent, this.m);
      if (f2 == -1.0F) {
        break;
      }
      this.o = f2;
      continue;
      if (this.m == -1) {
        break;
      }
      float f1 = a(paramMotionEvent, this.m);
      if (f1 == -1.0F) {
        break;
      }
      if ((f1 - this.o > this.e) && (!this.n))
      {
        this.n = true;
        continue;
        this.n = false;
        this.m = -1;
        continue;
        a(paramMotionEvent);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    c();
    if (this.b == null) {}
    for (;;)
    {
      return;
      int i1 = getMeasuredHeight();
      int i2 = getMeasuredWidth();
      int i3 = getPaddingLeft();
      int i4 = getPaddingTop();
      int i5 = getPaddingRight();
      int i6 = getPaddingBottom();
      this.b.layout(i3, i4 + this.j, i3 + i2 - i5, i4 + i1 - i6 + this.j);
      this.c.layout(i3, i4, i2 + i3 - i5, i1 + i4 - i6);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    c();
    if (this.b == null) {}
    for (;;)
    {
      return;
      int i1 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingRight() - getPaddingLeft(), 1073741824);
      int i2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824);
      this.b.measure(i1, i2);
      this.c.measure(i1, i2);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (!this.n) {
      bool = super.onTouchEvent(paramMotionEvent);
    }
    do
    {
      return bool;
      switch (MotionEventCompat.getActionMasked(paramMotionEvent))
      {
      case 4: 
      default: 
      case 2: 
      case 5: 
      case 6: 
        for (;;)
        {
          bool = true;
          break;
          int i1 = MotionEventCompat.findPointerIndex(paramMotionEvent, this.m);
          if (i1 < 0) {
            break;
          }
          float f2 = 0.5F * (MotionEventCompat.getY(paramMotionEvent, i1) - this.o);
          float f3 = f2 / this.h;
          if (f3 < 0.0F) {
            break;
          }
          float f4 = Math.min(1.0F, Math.abs(f3));
          float f5 = Math.abs(f2) - this.h;
          float f6 = this.g;
          float f7 = Math.max(0.0F, Math.min(f5, f6 * 2.0F) / f6);
          int i2 = (int)(2.0F * (f6 * (2.0F * (float)(f7 / 4.0F - Math.pow(f7 / 4.0F, 2.0D)))) + f4 * f6);
          if (this.c.getVisibility() != 0) {
            this.c.setVisibility(0);
          }
          a(i2 - this.j, true);
          continue;
          this.m = MotionEventCompat.getPointerId(paramMotionEvent, MotionEventCompat.getActionIndex(paramMotionEvent));
          continue;
          a(paramMotionEvent);
        }
      }
    } while (this.m == -1);
    float f1 = 0.5F * (MotionEventCompat.getY(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.m)) - this.o);
    this.n = false;
    if (f1 > this.h) {
      a(true, true);
    }
    for (;;)
    {
      this.m = -1;
      break;
      this.l = false;
      d();
    }
  }
  
  public void setAnimationBackgroundColor(int paramInt) {}
  
  public void setColorSchemeColors(int[] paramArrayOfInt)
  {
    this.v = paramArrayOfInt;
  }
  
  public void setMaxDragDistance(int paramInt)
  {
    this.h = paramInt;
    this.g = paramInt;
  }
  
  public void setOnRefreshListener(Hb paramHb)
  {
    this.t = paramHb;
  }
  
  public void setRefreshImage(int paramInt)
  {
    this.i.a(getResources().getDrawable(paramInt));
  }
  
  public void setRefreshImage(Drawable paramDrawable)
  {
    this.i.a(paramDrawable);
  }
  
  public void setRefreshStyle(int paramInt)
  {
    setRefreshing(false);
    switch (paramInt)
    {
    default: 
      throw new InvalidParameterException("Type does not exist");
    case 1: 
      this.c.setImageResource(2130837837);
    }
    for (this.i = new Hd(getContext(), this);; this.i = new GV(getContext(), this))
    {
      this.c.setImageDrawable(this.i);
      return;
    }
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if (this.l != paramBoolean) {
      a(paramBoolean, false);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.pullrefresh.PullRefreshLayout
 * JD-Core Version:    0.7.0.1
 */