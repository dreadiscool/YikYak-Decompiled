import android.view.View;
import android.view.animation.Interpolator;

public abstract class bv
{
  private xj a = new xj();
  private long b = 1000L;
  
  public bv a(long paramLong)
  {
    this.b = paramLong;
    return this;
  }
  
  public bv a(Interpolator paramInterpolator)
  {
    this.a.a(paramInterpolator);
    return this;
  }
  
  public bv a(xh paramxh)
  {
    this.a.a(paramxh);
    return this;
  }
  
  public void a()
  {
    this.a.c(this.b);
    this.a.a();
  }
  
  protected abstract void a(View paramView);
  
  public long b()
  {
    return this.b;
  }
  
  public bv b(long paramLong)
  {
    c().b(paramLong);
    return this;
  }
  
  public void b(View paramView)
  {
    c(paramView);
    a(paramView);
    a();
  }
  
  public xj c()
  {
    return this.a;
  }
  
  public void c(View paramView)
  {
    ya.a(paramView, 1.0F);
    ya.g(paramView, 1.0F);
    ya.h(paramView, 1.0F);
    ya.i(paramView, 0.0F);
    ya.j(paramView, 0.0F);
    ya.d(paramView, 0.0F);
    ya.f(paramView, 0.0F);
    ya.e(paramView, 0.0F);
    ya.b(paramView, paramView.getMeasuredWidth() / 2.0F);
    ya.c(paramView, paramView.getMeasuredHeight() / 2.0F);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     bv
 * JD-Core Version:    0.7.0.1
 */