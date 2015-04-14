public class cR
  extends cL
{
  private float b;
  
  public Float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f = paramFloat1 / paramFloat4 - 1.0F;
    return Float.valueOf(paramFloat2 + paramFloat3 * (1.0F + f * f * (f * (1.0F + this.b) + this.b)));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     cR
 * JD-Core Version:    0.7.0.1
 */