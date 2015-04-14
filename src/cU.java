public class cU
  extends cL
{
  public Float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = paramFloat1 / paramFloat4;
    Float localFloat;
    if (f1 < 0.3636364F) {
      localFloat = Float.valueOf(paramFloat2 + paramFloat3 * (f1 * (7.5625F * f1)));
    }
    for (;;)
    {
      return localFloat;
      if (f1 < 0.7272728F)
      {
        float f4 = f1 - 0.5454546F;
        localFloat = Float.valueOf(paramFloat2 + paramFloat3 * (0.75F + f4 * (7.5625F * f4)));
      }
      else if (f1 < 0.9090909090909091D)
      {
        float f3 = f1 - 0.8181818F;
        localFloat = Float.valueOf(paramFloat2 + paramFloat3 * (0.9375F + f3 * (7.5625F * f3)));
      }
      else
      {
        float f2 = f1 - 0.9545454F;
        localFloat = Float.valueOf(paramFloat2 + paramFloat3 * (0.984375F + f2 * (7.5625F * f2)));
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     cU
 * JD-Core Version:    0.7.0.1
 */