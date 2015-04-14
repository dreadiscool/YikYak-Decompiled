public class cT
  extends cL
{
  private cU b;
  private cS c;
  
  public Float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramFloat1 < paramFloat4 / 2.0F) {}
    for (Float localFloat = Float.valueOf(paramFloat2 + 0.5F * this.c.a(2.0F * paramFloat1, 0.0F, paramFloat3, paramFloat4).floatValue());; localFloat = Float.valueOf(paramFloat2 + (0.5F * this.b.a(2.0F * paramFloat1 - paramFloat4, 0.0F, paramFloat3, paramFloat4).floatValue() + paramFloat3 * 0.5F))) {
      return localFloat;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     cT
 * JD-Core Version:    0.7.0.1
 */