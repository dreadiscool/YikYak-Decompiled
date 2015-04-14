import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;

public final class hl
  extends Drawable
  implements Drawable.Callback
{
  private int a = 0;
  private long b;
  private int c;
  private int d;
  private int e = 255;
  private int f;
  private int g = 0;
  private boolean h = true;
  private boolean i;
  private hp j;
  private Drawable k;
  private Drawable l;
  private boolean m;
  private boolean n;
  private boolean o;
  private int p;
  
  public hl(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this(null);
    if (paramDrawable1 == null) {
      paramDrawable1 = hn.a();
    }
    this.k = paramDrawable1;
    paramDrawable1.setCallback(this);
    hp localhp1 = this.j;
    localhp1.b |= paramDrawable1.getChangingConfigurations();
    if (paramDrawable2 == null) {
      paramDrawable2 = hn.a();
    }
    this.l = paramDrawable2;
    paramDrawable2.setCallback(this);
    hp localhp2 = this.j;
    localhp2.b |= paramDrawable2.getChangingConfigurations();
  }
  
  hl(hp paramhp)
  {
    this.j = new hp(paramhp);
  }
  
  public void a(int paramInt)
  {
    this.c = 0;
    this.d = this.e;
    this.g = 0;
    this.f = paramInt;
    this.a = 1;
    invalidateSelf();
  }
  
  public boolean a()
  {
    if (!this.m) {
      if ((this.k.getConstantState() == null) || (this.l.getConstantState() == null)) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      this.n = bool;
      this.m = true;
      return this.n;
    }
  }
  
  public Drawable b()
  {
    return this.l;
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i1 = 1;
    int i2 = 0;
    label34:
    int i3;
    boolean bool;
    Drawable localDrawable1;
    Drawable localDrawable2;
    switch (this.a)
    {
    default: 
      i2 = i1;
      i3 = this.g;
      bool = this.h;
      localDrawable1 = this.k;
      localDrawable2 = this.l;
      if (i2 != 0)
      {
        if ((!bool) || (i3 == 0)) {
          localDrawable1.draw(paramCanvas);
        }
        if (i3 == this.e)
        {
          localDrawable2.setAlpha(this.e);
          localDrawable2.draw(paramCanvas);
        }
      }
      break;
    }
    for (;;)
    {
      return;
      this.b = SystemClock.uptimeMillis();
      this.a = 2;
      break label34;
      if (this.b < 0L) {
        break;
      }
      float f1 = (float)(SystemClock.uptimeMillis() - this.b) / this.f;
      if (f1 >= 1.0F) {}
      for (;;)
      {
        if (i1 != 0) {
          this.a = 0;
        }
        float f2 = Math.min(f1, 1.0F);
        this.g = ((int)(this.c + f2 * (this.d - this.c)));
        break;
        i1 = 0;
      }
      if (bool) {
        localDrawable1.setAlpha(this.e - i3);
      }
      localDrawable1.draw(paramCanvas);
      if (bool) {
        localDrawable1.setAlpha(this.e);
      }
      if (i3 > 0)
      {
        localDrawable2.setAlpha(i3);
        localDrawable2.draw(paramCanvas);
        localDrawable2.setAlpha(this.e);
      }
      invalidateSelf();
    }
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.j.a | this.j.b;
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if (a()) {
      this.j.a = getChangingConfigurations();
    }
    for (hp localhp = this.j;; localhp = null) {
      return localhp;
    }
  }
  
  public int getIntrinsicHeight()
  {
    return Math.max(this.k.getIntrinsicHeight(), this.l.getIntrinsicHeight());
  }
  
  public int getIntrinsicWidth()
  {
    return Math.max(this.k.getIntrinsicWidth(), this.l.getIntrinsicWidth());
  }
  
  public int getOpacity()
  {
    if (!this.o)
    {
      this.p = Drawable.resolveOpacity(this.k.getOpacity(), this.l.getOpacity());
      this.o = true;
    }
    return this.p;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (iv.a())
    {
      Drawable.Callback localCallback = getCallback();
      if (localCallback != null) {
        localCallback.invalidateDrawable(this);
      }
    }
  }
  
  public Drawable mutate()
  {
    if ((!this.i) && (super.mutate() == this))
    {
      if (!a()) {
        throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
      }
      this.k.mutate();
      this.l.mutate();
      this.i = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.k.setBounds(paramRect);
    this.l.setBounds(paramRect);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if (iv.a())
    {
      Drawable.Callback localCallback = getCallback();
      if (localCallback != null) {
        localCallback.scheduleDrawable(this, paramRunnable, paramLong);
      }
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.g == this.e) {
      this.g = paramInt;
    }
    this.e = paramInt;
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.k.setColorFilter(paramColorFilter);
    this.l.setColorFilter(paramColorFilter);
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if (iv.a())
    {
      Drawable.Callback localCallback = getCallback();
      if (localCallback != null) {
        localCallback.unscheduleDrawable(this, paramRunnable);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     hl
 * JD-Core Version:    0.7.0.1
 */