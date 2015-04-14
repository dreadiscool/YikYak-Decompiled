import android.view.animation.Interpolator;

public abstract class xt
  implements Cloneable
{
  float a;
  Class b;
  boolean c = false;
  private Interpolator d = null;
  
  public static xt a(float paramFloat)
  {
    return new xu(paramFloat);
  }
  
  public static xt a(float paramFloat1, float paramFloat2)
  {
    return new xu(paramFloat1, paramFloat2);
  }
  
  public void a(Interpolator paramInterpolator)
  {
    this.d = paramInterpolator;
  }
  
  public abstract void a(Object paramObject);
  
  public boolean a()
  {
    return this.c;
  }
  
  public abstract Object b();
  
  public float c()
  {
    return this.a;
  }
  
  public Interpolator d()
  {
    return this.d;
  }
  
  public abstract xt e();
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     xt
 * JD-Core Version:    0.7.0.1
 */