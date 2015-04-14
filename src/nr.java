import java.util.Arrays;

final class nr
{
  public final String a;
  public final Object b;
  
  nr(String paramString, Object paramObject)
  {
    this.a = paramString;
    this.b = paramObject;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (!(paramObject instanceof nr)) {}
    for (;;)
    {
      return bool;
      nr localnr = (nr)paramObject;
      if ((this.a.equals(localnr.a)) && (this.b.equals(localnr.b))) {
        bool = true;
      }
    }
  }
  
  public int hashCode()
  {
    Integer[] arrayOfInteger = new Integer[2];
    arrayOfInteger[0] = Integer.valueOf(this.a.hashCode());
    arrayOfInteger[1] = Integer.valueOf(this.b.hashCode());
    return Arrays.hashCode(arrayOfInteger);
  }
  
  public String toString()
  {
    return "Key: " + this.a + " value: " + this.b.toString();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     nr
 * JD-Core Version:    0.7.0.1
 */