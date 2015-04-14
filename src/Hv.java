import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

public class Hv
  implements Hz
{
  private int a;
  private int b;
  private long c;
  private long d;
  private float e;
  private float f;
  private Interpolator g;
  
  public Hv(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this(paramInt1, paramInt2, paramLong1, paramLong2, new LinearInterpolator());
  }
  
  public Hv(int paramInt1, int paramInt2, long paramLong1, long paramLong2, Interpolator paramInterpolator)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramLong1;
    this.d = paramLong2;
    this.e = ((float)(this.d - this.c));
    this.f = (this.b - this.a);
    this.g = paramInterpolator;
  }
  
  public void a(Hx paramHx, long paramLong)
  {
    if (paramLong < this.c) {
      paramHx.d = this.a;
    }
    for (;;)
    {
      return;
      if (paramLong > this.d)
      {
        paramHx.d = this.b;
      }
      else
      {
        float f1 = this.g.getInterpolation(1.0F * (float)(paramLong - this.c) / this.e);
        paramHx.d = ((int)(this.a + f1 * this.f));
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Hv
 * JD-Core Version:    0.7.0.1
 */