public class dc
  extends cL
{
  public Float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Float localFloat;
    if (paramFloat1 == 0.0F) {
      localFloat = Float.valueOf(paramFloat2);
    }
    for (;;)
    {
      return localFloat;
      float f1 = paramFloat1 / paramFloat4;
      if (f1 == 1.0F)
      {
        localFloat = Float.valueOf(paramFloat2 + paramFloat3);
      }
      else
      {
        float f2 = 0.3F * paramFloat4;
        float f3 = f2 / 4.0F;
        localFloat = Float.valueOf(paramFloat2 + (paramFloat3 + paramFloat3 * (float)Math.pow(2.0D, -10.0F * f1) * (float)Math.sin(6.283186F * (f1 * paramFloat4 - f3) / f2)));
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     dc
 * JD-Core Version:    0.7.0.1
 */