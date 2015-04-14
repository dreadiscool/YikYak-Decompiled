package com.nispok.snackbar;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.nispok.snackbar.layouts.SnackbarLayout;
import yA;
import yB;
import yD;
import yE;
import yF;
import yG;
import yd;
import yj;
import yk;
import yl;
import ym;
import yn;
import yo;
import yp;
import yq;
import yr;
import ys;
import yt;
import yu;
import yv;
import yx;
import yz;

public class Snackbar
  extends SnackbarLayout
{
  private boolean A;
  private boolean B = true;
  private yF C;
  private Typeface D;
  private Typeface E;
  private boolean F = false;
  private boolean G = true;
  private boolean H = false;
  private Rect I = new Rect();
  private Rect J = new Rect();
  private Point K = new Point();
  private Point L = new Point();
  private Activity M;
  private Float N = null;
  private boolean O;
  private Runnable P = new yq(this);
  private Runnable Q = new yr(this);
  private int a = -10000;
  private int b = -10000;
  private yD c = yD.a;
  private yz d = yz.b;
  private CharSequence e;
  private TextView f;
  private int g = this.a;
  private int h = this.a;
  private int i;
  private yA j = yA.b;
  private int k = this.b;
  private int l = 0;
  private int m = 0;
  private int n = 0;
  private int o = 0;
  private long p;
  private long q;
  private long r = -1L;
  private CharSequence s;
  private int t = this.a;
  private boolean u = true;
  private boolean v = false;
  private boolean w = false;
  private long x = -1L;
  private yE y;
  private boolean z;
  
  private Snackbar(Context paramContext)
  {
    super(paramContext);
    if (Build.VERSION.SDK_INT >= 16) {
      addView(new yB(getContext()));
    }
  }
  
  private static int a(int paramInt, float paramFloat)
  {
    return (int)(0.5F + paramFloat * paramInt);
  }
  
  public static int a(yA paramyA)
  {
    if (paramyA == yA.a) {}
    for (int i1 = yj.sb__top_in;; i1 = yj.sb__bottom_in) {
      return i1;
    }
  }
  
  private ViewGroup.MarginLayoutParams a(Context paramContext, Activity paramActivity, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    SnackbarLayout localSnackbarLayout = (SnackbarLayout)LayoutInflater.from(paramContext).inflate(yp.sb__template, this, true);
    Resources localResources = getResources();
    int i1;
    float f1;
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    TextView localTextView;
    if (this.g != this.a)
    {
      i1 = this.g;
      this.g = i1;
      this.i = localResources.getDimensionPixelOffset(ym.sb__offset);
      this.O = paramBoolean;
      f1 = localResources.getDisplayMetrics().density;
      if (!this.O) {
        break label386;
      }
      localSnackbarLayout.setMinimumHeight(a(this.c.a(), f1));
      localSnackbarLayout.setMaxHeight(a(this.c.b(), f1));
      localSnackbarLayout.setBackgroundColor(this.g);
      localMarginLayoutParams = a(paramViewGroup, -1, -2, this.j);
      if (this.k != this.b) {
        setBackgroundDrawable(localSnackbarLayout, localResources.getDrawable(this.k));
      }
      this.f = ((TextView)localSnackbarLayout.findViewById(yo.sb__text));
      this.f.setText(this.e);
      this.f.setTypeface(this.D);
      if (this.h != this.a) {
        this.f.setTextColor(this.h);
      }
      this.f.setMaxLines(this.c.c());
      localTextView = (TextView)localSnackbarLayout.findViewById(yo.sb__action);
      if (TextUtils.isEmpty(this.s)) {
        break label493;
      }
      requestLayout();
      localTextView.setText(this.s);
      localTextView.setTypeface(this.E);
      if (this.t != this.a) {
        localTextView.setTextColor(this.t);
      }
      localTextView.setOnClickListener(new ys(this));
      localTextView.setMaxLines(this.c.c());
    }
    for (;;)
    {
      setClickable(true);
      if ((this.G) && (localResources.getBoolean(yk.sb__is_swipeable))) {
        setOnTouchListener(new yG(this, null, new yt(this)));
      }
      return localMarginLayoutParams;
      i1 = localResources.getColor(yl.sb__background);
      break;
      label386:
      this.c = yD.a;
      localSnackbarLayout.setMinimumWidth(localResources.getDimensionPixelSize(ym.sb__min_width));
      if (this.N == null) {}
      for (int i2 = localResources.getDimensionPixelSize(ym.sb__max_width);; i2 = yd.a(paramActivity, this.N))
      {
        localSnackbarLayout.setMaxWidth(i2);
        localSnackbarLayout.setBackgroundResource(yn.sb__bg);
        ((GradientDrawable)localSnackbarLayout.getBackground()).setColor(this.g);
        localMarginLayoutParams = a(paramViewGroup, -2, a(this.c.b(), f1), this.j);
        break;
      }
      label493:
      localTextView.setVisibility(8);
    }
  }
  
  private static ViewGroup.MarginLayoutParams a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, yA paramyA)
  {
    Object localObject;
    if ((paramViewGroup instanceof FrameLayout))
    {
      localObject = new FrameLayout.LayoutParams(paramInt1, paramInt2);
      ((FrameLayout.LayoutParams)localObject).gravity = paramyA.a();
    }
    for (;;)
    {
      return localObject;
      if ((paramViewGroup instanceof RelativeLayout))
      {
        localObject = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
        if (paramyA == yA.a) {
          ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        } else {
          ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
        }
      }
      else
      {
        if (!(paramViewGroup instanceof LinearLayout)) {
          break;
        }
        localObject = new LinearLayout.LayoutParams(paramInt1, paramInt2);
        ((LinearLayout.LayoutParams)localObject).gravity = paramyA.a();
      }
    }
    throw new IllegalStateException("Requires FrameLayout or RelativeLayout for the parent of Snackbar");
  }
  
  public static Snackbar a(Context paramContext)
  {
    return new Snackbar(paramContext);
  }
  
  private void a(long paramLong)
  {
    postDelayed(this.P, paramLong);
  }
  
  private void a(Activity paramActivity, Rect paramRect)
  {
    paramRect.bottom = 0;
    paramRect.right = 0;
    paramRect.top = 0;
    paramRect.left = 0;
    if (paramActivity == null) {}
    for (;;)
    {
      return;
      ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
      Display localDisplay = paramActivity.getWindowManager().getDefaultDisplay();
      boolean bool1 = a(paramActivity);
      boolean bool2 = a(localViewGroup);
      Rect localRect = this.J;
      Point localPoint1 = this.L;
      Point localPoint2 = this.K;
      localViewGroup.getWindowVisibleDisplayFrame(localRect);
      yd.b(localDisplay, localPoint1);
      yd.a(localDisplay, localPoint2);
      if (localPoint2.x < localPoint1.x)
      {
        if ((bool1) || (bool2)) {
          paramRect.right = Math.max(Math.min(localPoint1.x - localPoint2.x, localPoint1.x - localRect.right), 0);
        }
      }
      else if ((localPoint2.y < localPoint1.y) && ((bool1) || (bool2))) {
        paramRect.bottom = Math.max(Math.min(localPoint1.y - localPoint2.y, localPoint1.y - localRect.bottom), 0);
      }
    }
  }
  
  private void a(Activity paramActivity, ViewGroup.MarginLayoutParams paramMarginLayoutParams, ViewGroup paramViewGroup)
  {
    paramViewGroup.removeView(this);
    paramViewGroup.addView(this, paramMarginLayoutParams);
    bringToFront();
    if (Build.VERSION.SDK_INT < 19)
    {
      paramViewGroup.requestLayout();
      paramViewGroup.invalidate();
    }
    this.F = true;
    this.M = paramActivity;
    getViewTreeObserver().addOnPreDrawListener(new yu(this));
    if (!this.u) {
      if (i()) {
        k();
      }
    }
    for (;;)
    {
      return;
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), a(this.j));
      localAnimation.setAnimationListener(new yv(this));
      startAnimation(localAnimation);
    }
  }
  
  private boolean a(Activity paramActivity)
  {
    boolean bool = false;
    if (Build.VERSION.SDK_INT < 19) {}
    for (;;)
    {
      return bool;
      if ((0x8000000 & paramActivity.getWindow().getAttributes().flags) != 0) {
        bool = true;
      }
    }
  }
  
  @TargetApi(16)
  private boolean a(ViewGroup paramViewGroup)
  {
    boolean bool = false;
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      return bool;
      if ((0x200 & paramViewGroup.getWindowSystemUiVisibility()) == 512) {
        bool = true;
      }
    }
  }
  
  public static int b(yA paramyA)
  {
    if (paramyA == yA.a) {}
    for (int i1 = yj.sb__top_out;; i1 = yj.sb__bottom_out) {
      return i1;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.H) {}
    for (;;)
    {
      return;
      this.H = true;
      if (!paramBoolean)
      {
        l();
      }
      else
      {
        Animation localAnimation = AnimationUtils.loadAnimation(getContext(), b(this.j));
        localAnimation.setAnimationListener(new yx(this));
        startAnimation(localAnimation);
      }
    }
  }
  
  public static boolean b(Context paramContext)
  {
    if (paramContext == null) {}
    for (boolean bool = true;; bool = paramContext.getResources().getBoolean(yk.sb__is_phone)) {
      return bool;
    }
  }
  
  private boolean i()
  {
    if (!j()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean j()
  {
    if (e() == yz.c.a()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void k()
  {
    postDelayed(this.P, e());
  }
  
  private void l()
  {
    clearAnimation();
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(this);
    }
    this.F = false;
    this.v = false;
    this.M = null;
  }
  
  public static void setBackgroundDrawable(View paramView, Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT < 16) {
      paramView.setBackgroundDrawable(paramDrawable);
    }
    for (;;)
    {
      return;
      paramView.setBackground(paramDrawable);
    }
  }
  
  public Snackbar a(int paramInt)
  {
    this.g = paramInt;
    return this;
  }
  
  public Snackbar a(CharSequence paramCharSequence)
  {
    this.e = paramCharSequence;
    if (this.f != null) {
      this.f.setText(this.e);
    }
    return this;
  }
  
  public Snackbar a(yD paramyD)
  {
    this.c = paramyD;
    return this;
  }
  
  public Snackbar a(yE paramyE)
  {
    this.y = paramyE;
    return this;
  }
  
  public Snackbar a(yz paramyz)
  {
    this.d = paramyz;
    return this;
  }
  
  public Snackbar a(boolean paramBoolean)
  {
    this.G = paramBoolean;
    return this;
  }
  
  public void a()
  {
    this.v = true;
    b();
  }
  
  protected void a(Activity paramActivity, ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    if (this.O)
    {
      paramMarginLayoutParams.topMargin = this.l;
      paramMarginLayoutParams.rightMargin = this.o;
      paramMarginLayoutParams.leftMargin = this.n;
    }
    for (paramMarginLayoutParams.bottomMargin = this.m;; paramMarginLayoutParams.bottomMargin = (this.m + this.i))
    {
      a(paramActivity, this.I);
      paramMarginLayoutParams.rightMargin += this.I.right;
      paramMarginLayoutParams.bottomMargin += this.I.bottom;
      return;
      paramMarginLayoutParams.topMargin = this.l;
      paramMarginLayoutParams.rightMargin = this.o;
      paramMarginLayoutParams.leftMargin = (this.n + this.i);
    }
  }
  
  public void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    this.w = true;
    b(paramViewGroup, paramBoolean);
  }
  
  public Snackbar b(CharSequence paramCharSequence)
  {
    this.s = paramCharSequence;
    return this;
  }
  
  public void b()
  {
    b(this.u);
  }
  
  public void b(int paramInt)
  {
    c(paramInt);
  }
  
  public void b(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = a(paramViewGroup.getContext(), null, paramViewGroup, paramBoolean);
    a(null, localMarginLayoutParams);
    a(null, localMarginLayoutParams, paramViewGroup);
  }
  
  public void c()
  {
    if (this.H) {}
    for (;;)
    {
      return;
      if ((ViewGroup)getParent() != null)
      {
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
        a(this.M, localMarginLayoutParams);
        setLayoutParams(localMarginLayoutParams);
      }
    }
  }
  
  protected void c(int paramInt)
  {
    if (this.Q != null) {
      post(this.Q);
    }
  }
  
  public CharSequence d()
  {
    return this.e;
  }
  
  public long e()
  {
    if (this.x == -1L) {}
    for (long l1 = this.d.a();; l1 = this.x) {
      return l1;
    }
  }
  
  public boolean f()
  {
    return this.F;
  }
  
  public boolean g()
  {
    return this.H;
  }
  
  public boolean h()
  {
    if (!this.F) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.P != null) {
      removeCallbacks(this.P);
    }
    if (this.Q != null) {
      removeCallbacks(this.Q);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.nispok.snackbar.Snackbar
 * JD-Core Version:    0.7.0.1
 */