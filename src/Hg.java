import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.animation.OvershootInterpolator;
import com.yik.yak.ui.view.AnimatedTextView;

public class Hg
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  protected int a = 0;
  protected Rect b = new Rect();
  protected Hi c = Hi.c;
  private int d = 0;
  private int e = 0;
  private AnimatedTextView f;
  private ValueAnimator g;
  
  public Hg(AnimatedTextView paramAnimatedTextView)
  {
    this(paramAnimatedTextView, 0);
  }
  
  public Hg(AnimatedTextView paramAnimatedTextView, int paramInt)
  {
    this.f = paramAnimatedTextView;
    this.d = paramInt;
    this.e = this.d;
  }
  
  private void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 9)) {
      throw new NullPointerException("ERROR");
    }
  }
  
  private void d()
  {
    int i;
    switch (Hh.a[this.c.ordinal()])
    {
    default: 
      i = 0;
      int[] arrayOfInt = new int[2];
      arrayOfInt[0] = 0;
      arrayOfInt[1] = (i * b());
      this.g = ValueAnimator.ofInt(arrayOfInt);
      int j = 300 * Math.abs(i);
      if (j > 1000) {
        j = 1000;
      }
      this.g.setDuration(j);
      this.g.addUpdateListener(this);
      this.g.setInterpolator(new OvershootInterpolator());
      this.g.addListener(this);
      this.g.start();
    }
    for (;;)
    {
      return;
      if (this.e < this.d)
      {
        i = 10 + this.e - this.d;
        break;
      }
      i = this.e - this.d;
      break;
      if (this.e > this.d)
      {
        i = -(10 + this.d - this.e);
        break;
      }
      i = -(this.d - this.e);
      break;
      this.d = this.e;
      this.f.invalidate();
    }
  }
  
  public String a()
  {
    return "" + this.d;
  }
  
  public void a(int paramInt, Hi paramHi)
  {
    a(paramInt);
    if (paramInt == this.d) {}
    for (;;)
    {
      return;
      this.e = paramInt;
      this.c = paramHi;
      d();
    }
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint)
  {
    paramPaint.getTextBounds(a(), 0, a().length(), this.b);
    int i = this.b.height();
    int j = b();
    int k = this.d;
    int m = paramInt2 + i / 2;
    paramCanvas.drawText("" + k, paramInt1, m + this.a, paramPaint);
    int n;
    if (this.c != Hi.c)
    {
      n = 1;
      switch (Hh.a[this.c.ordinal()])
      {
      default: 
        label132:
        if (k == 10)
        {
          k = 0;
          label142:
          if (this.c != Hi.a) {
            break label244;
          }
        }
        break;
      }
    }
    label244:
    for (int i1 = n * -1;; i1 = n)
    {
      int i2 = m + i1 * j;
      paramCanvas.drawText("" + k, paramInt1, i2 + this.a, paramPaint);
      n++;
      if (k != this.e) {
        break;
      }
      return;
      k++;
      break label132;
      k--;
      break label132;
      if (k != -1) {
        break label142;
      }
      k = 9;
      break label142;
    }
  }
  
  protected int b()
  {
    return this.f.getHeight();
  }
  
  public void c()
  {
    if (this.g != null) {
      this.g.end();
    }
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.g = null;
    this.a = 0;
    this.c = Hi.c;
    this.d = this.e;
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.c == Hi.c) {}
    for (;;)
    {
      return;
      this.a = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
      this.f.invalidate();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Hg
 * JD-Core Version:    0.7.0.1
 */