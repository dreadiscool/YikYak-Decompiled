import java.util.Random;

public class HD
  implements Hy
{
  private float a;
  private float b;
  
  public HD(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  public void a(Hx paramHx, Random paramRandom)
  {
    paramHx.f = (paramRandom.nextFloat() * (this.b - this.a) + this.a);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     HD
 * JD-Core Version:    0.7.0.1
 */