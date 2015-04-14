import java.io.IOException;

public enum zy
{
  private final String e;
  
  static
  {
    zy[] arrayOfzy = new zy[4];
    arrayOfzy[0] = a;
    arrayOfzy[1] = b;
    arrayOfzy[2] = c;
    arrayOfzy[3] = d;
    f = arrayOfzy;
  }
  
  private zy(String paramString)
  {
    this.e = paramString;
  }
  
  public static zy a(String paramString)
  {
    zy localzy;
    if (paramString.equals(a.e)) {
      localzy = a;
    }
    for (;;)
    {
      return localzy;
      if (paramString.equals(b.e))
      {
        localzy = b;
      }
      else if (paramString.equals(d.e))
      {
        localzy = d;
      }
      else
      {
        if (!paramString.equals(c.e)) {
          break;
        }
        localzy = c;
      }
    }
    throw new IOException("Unexpected protocol: " + paramString);
  }
  
  public String toString()
  {
    return this.e;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zy
 * JD-Core Version:    0.7.0.1
 */