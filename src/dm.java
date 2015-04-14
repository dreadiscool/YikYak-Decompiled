public class dm
  extends cL
{
  public Float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f = paramFloat1 / paramFloat4 - 1.0F;
    return Float.valueOf(paramFloat2 + paramFloat3 * (1.0F + f * (f * (f * (f * f)))));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     dm
 * JD-Core Version:    0.7.0.1
 */