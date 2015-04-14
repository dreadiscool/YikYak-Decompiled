public class cQ
  extends cL
{
  private float b;
  
  public Float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = paramFloat1 / (paramFloat4 / 2.0F);
    float f6;
    float f7;
    float f8;
    if (f1 < 1.0F)
    {
      f6 = paramFloat3 / 2.0F;
      f7 = f1 * f1;
      f8 = (float)(1.525D * this.b);
      this.b = f8;
    }
    float f2;
    float f3;
    float f4;
    float f5;
    for (Float localFloat = Float.valueOf(paramFloat2 + f6 * (f7 * (f1 * (f8 + 1.0F) - this.b)));; localFloat = Float.valueOf(paramFloat2 + f2 * (2.0F + f4 * (f3 * (f5 + 1.0F) + this.b))))
    {
      return localFloat;
      f2 = paramFloat3 / 2.0F;
      f3 = f1 - 2.0F;
      f4 = f3 * f3;
      f5 = (float)(1.525D * this.b);
      this.b = f5;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     cQ
 * JD-Core Version:    0.7.0.1
 */