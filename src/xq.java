public class xq
  implements xP<Number>
{
  public Float a(float paramFloat, Number paramNumber1, Number paramNumber2)
  {
    float f = paramNumber1.floatValue();
    return Float.valueOf(f + paramFloat * (paramNumber2.floatValue() - f));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     xq
 * JD-Core Version:    0.7.0.1
 */