import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.yik.yak.ui.view.leonids.ParticleField;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HA
{
  private ViewGroup a;
  private int b;
  private Random c = new Random();
  private ParticleField d;
  private ArrayList<Hx> e;
  private ArrayList<Hx> f;
  private long g;
  private long h = 0L;
  private float i;
  private int j;
  private long k;
  private List<Hz> l;
  private List<Hy> m;
  private ValueAnimator n;
  private float o;
  private int[] p;
  private int q;
  private int r;
  private int s;
  private int t;
  
  public HA(Activity paramActivity, int paramInt1, int paramInt2, long paramLong)
  {
    this(paramActivity, paramInt1, paramActivity.getResources().getDrawable(paramInt2), paramLong);
  }
  
  private HA(Activity paramActivity, int paramInt, long paramLong)
  {
    this.a = ((ViewGroup)paramActivity.findViewById(16908290));
    this.l = new ArrayList();
    this.m = new ArrayList();
    this.b = paramInt;
    this.f = new ArrayList();
    this.e = new ArrayList();
    this.g = paramLong;
    this.p = new int[2];
    this.a.getLocationInWindow(this.p);
    this.o = (paramActivity.getResources().getDisplayMetrics().xdpi / 160.0F);
  }
  
  public HA(Activity paramActivity, int paramInt, Drawable paramDrawable, long paramLong)
  {
    this(paramActivity, paramInt, paramLong);
    if ((paramDrawable instanceof BitmapDrawable))
    {
      Bitmap localBitmap = ((BitmapDrawable)paramDrawable).getBitmap();
      while (i1 < this.b)
      {
        this.e.add(new Hx(localBitmap));
        i1++;
      }
    }
    if ((paramDrawable instanceof AnimationDrawable))
    {
      AnimationDrawable localAnimationDrawable = (AnimationDrawable)paramDrawable;
      while (i1 < this.b)
      {
        this.e.add(new Hw(localAnimationDrawable));
        i1++;
      }
    }
  }
  
  private void a()
  {
    this.a.removeView(this.d);
    this.d = null;
    this.a.postInvalidate();
    this.e.addAll(this.f);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 0) {}
    for (;;)
    {
      return;
      long l1 = this.h / 1000L / paramInt;
      if (l1 != 0L)
      {
        long l2 = this.h / l1;
        for (int i1 = 1; i1 <= l1; i1++) {
          b(1L + l2 * i1);
        }
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.j = 0;
    this.i = (paramInt1 / 1000.0F);
    this.d = new ParticleField(this.a.getContext());
    this.a.addView(this.d);
    this.d.a(this.f);
    a(paramInt1);
    this.k = paramInt2;
    a(new LinearInterpolator(), paramInt2 + this.g);
  }
  
  private void a(long paramLong)
  {
    Hx localHx = (Hx)this.e.remove(0);
    localHx.a();
    for (int i1 = 0; i1 < this.m.size(); i1++) {
      ((Hy)this.m.get(i1)).a(localHx, this.c);
    }
    int i2 = c(this.q, this.r);
    int i3 = c(this.s, this.t);
    localHx.a(this.g, i2, i3);
    localHx.a(paramLong, this.l);
    this.f.add(localHx);
    this.j = (1 + this.j);
  }
  
  private void a(View paramView, int paramInt)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    if (b(paramInt, 3))
    {
      this.q = (arrayOfInt[0] - this.p[0]);
      this.r = this.q;
      if (!b(paramInt, 48)) {
        break label189;
      }
      this.s = (arrayOfInt[1] - this.p[1]);
      this.t = this.s;
    }
    for (;;)
    {
      return;
      if (b(paramInt, 5))
      {
        this.q = (arrayOfInt[0] + paramView.getWidth() - this.p[0]);
        this.r = this.q;
        break;
      }
      if (b(paramInt, 1))
      {
        this.q = (arrayOfInt[0] + paramView.getWidth() / 2 - this.p[0]);
        this.r = this.q;
        break;
      }
      this.q = (arrayOfInt[0] - this.p[0]);
      this.r = (arrayOfInt[0] + paramView.getWidth() - this.p[0]);
      break;
      label189:
      if (b(paramInt, 80))
      {
        this.s = (arrayOfInt[1] + paramView.getHeight() - this.p[1]);
        this.t = this.s;
      }
      else if (b(paramInt, 16))
      {
        this.s = (arrayOfInt[1] + paramView.getHeight() / 2 - this.p[1]);
        this.t = this.s;
      }
      else
      {
        this.s = (arrayOfInt[1] - this.p[1]);
        this.t = (arrayOfInt[1] + paramView.getHeight() - this.p[1]);
      }
    }
  }
  
  private void a(Interpolator paramInterpolator, long paramLong)
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = 0;
    arrayOfInt[1] = ((int)paramLong);
    this.n = ValueAnimator.ofInt(arrayOfInt);
    this.n.setDuration(paramLong);
    this.n.addUpdateListener(new HB(this));
    this.n.addListener(new HC(this));
    this.n.setInterpolator(paramInterpolator);
    this.n.start();
  }
  
  private void b(long paramLong)
  {
    while (((this.k > 0L) && (paramLong < this.k)) || ((this.k == -1L) && (!this.e.isEmpty()) && (this.j < this.i * (float)paramLong))) {
      a(paramLong);
    }
    for (int i1 = 0; i1 < this.f.size(); i1++) {
      if (!((Hx)this.f.get(i1)).a(paramLong))
      {
        Hx localHx = (Hx)this.f.remove(i1);
        i1--;
        this.e.add(localHx);
      }
    }
    this.d.postInvalidate();
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 & paramInt2) == paramInt2) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private int c(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {}
    for (;;)
    {
      return paramInt1;
      paramInt1 += this.c.nextInt(paramInt2 - paramInt1);
    }
  }
  
  public float a(float paramFloat)
  {
    return paramFloat * this.o;
  }
  
  public HA a(float paramFloat1, float paramFloat2)
  {
    this.m.add(new HE(a(paramFloat1), a(paramFloat2), 0, 360));
    return this;
  }
  
  public HA a(Hz paramHz)
  {
    this.l.add(paramHz);
    return this;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    a(paramView, 17, paramInt1, paramInt2);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramView, paramInt1);
    a(paramInt2, paramInt3);
  }
  
  public HA b(float paramFloat)
  {
    this.m.add(new HD(paramFloat, paramFloat));
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     HA
 * JD-Core Version:    0.7.0.1
 */