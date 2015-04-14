import java.util.Random;

public class HE
  implements Hy
{
  private float a;
  private float b;
  private int c;
  private int d;
  
  public HE(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramInt1;
    this.d = paramInt2;
    while (this.c < 0) {
      this.c = (360 + this.c);
    }
    while (this.d < 0) {
      this.d = (360 + this.d);
    }
    if (this.c > this.d)
    {
      int i = this.c;
      this.c = this.d;
      this.d = i;
    }
  }
  
  public void a(Hx paramHx, Random paramRandom)
  {
    float f1 = paramRandom.nextFloat() * (this.b - this.a) + this.a;
    if (this.d == this.c) {}
    for (int i = this.c;; i = paramRandom.nextInt(this.d - this.c) + this.c)
    {
      float f2 = (float)(3.141592653589793D * i / 180.0D);
      paramHx.g = ((float)(f1 * Math.cos(f2)));
      paramHx.h = ((float)(f1 * Math.sin(f2)));
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     HE
 * JD-Core Version:    0.7.0.1
 */