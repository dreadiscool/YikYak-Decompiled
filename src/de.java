public class de
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
      if (paramFloat1 == paramFloat4)
      {
        localFloat = Float.valueOf(paramFloat2 + paramFloat3);
      }
      else
      {
        float f = paramFloat1 / (paramFloat4 / 2.0F);
        if (f < 1.0F) {
          localFloat = Float.valueOf(paramFloat2 + paramFloat3 / 2.0F * (float)Math.pow(2.0D, 10.0F * (f - 1.0F)));
        } else {
          localFloat = Float.valueOf(paramFloat2 + paramFloat3 / 2.0F * (2.0F + -(float)Math.pow(2.0D, -10.0F * (f - 1.0F))));
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     de
 * JD-Core Version:    0.7.0.1
 */