public class di
  extends cL
{
  public Float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = paramFloat1 / (paramFloat4 / 2.0F);
    if (f1 < 1.0F) {}
    float f2;
    float f3;
    for (Float localFloat = Float.valueOf(paramFloat2 + f1 * (f1 * (paramFloat3 / 2.0F)));; localFloat = Float.valueOf(paramFloat2 + f2 * (f3 * (f3 - 2.0F) - 1.0F)))
    {
      return localFloat;
      f2 = -paramFloat3 / 2.0F;
      f3 = f1 - 1.0F;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     di
 * JD-Core Version:    0.7.0.1
 */