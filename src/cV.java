public class cV
  extends cL
{
  public Float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = -paramFloat3;
    float f2 = paramFloat1 / paramFloat4;
    return Float.valueOf(paramFloat2 + f1 * ((float)Math.sqrt(1.0F - f2 * f2) - 1.0F));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     cV
 * JD-Core Version:    0.7.0.1
 */