public class xs
  implements xP<Integer>
{
  public Integer a(float paramFloat, Integer paramInteger1, Integer paramInteger2)
  {
    int i = paramInteger1.intValue();
    return Integer.valueOf((int)(i + paramFloat * (paramInteger2.intValue() - i)));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     xs
 * JD-Core Version:    0.7.0.1
 */