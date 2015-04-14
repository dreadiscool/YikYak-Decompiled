import java.math.BigDecimal;

public final class pN
  extends Number
{
  private final String a;
  
  public pN(String paramString)
  {
    this.a = paramString;
  }
  
  public double doubleValue()
  {
    return Double.parseDouble(this.a);
  }
  
  public float floatValue()
  {
    return Float.parseFloat(this.a);
  }
  
  public int intValue()
  {
    try
    {
      int j = Integer.parseInt(this.a);
      i = j;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      for (;;)
      {
        try
        {
          long l = Long.parseLong(this.a);
          i = (int)l;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          int i = new BigDecimal(this.a).intValue();
        }
      }
    }
    return i;
  }
  
  public long longValue()
  {
    try
    {
      long l2 = Long.parseLong(this.a);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        long l1 = new BigDecimal(this.a).longValue();
      }
    }
    return l1;
  }
  
  public String toString()
  {
    return this.a;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     pN
 * JD-Core Version:    0.7.0.1
 */