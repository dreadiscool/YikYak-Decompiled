public class W
  extends RuntimeException
{
  W(String paramString)
  {
    super(a(paramString));
  }
  
  private static String a(String paramString)
  {
    return "\n" + paramString + "\n";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     W
 * JD-Core Version:    0.7.0.1
 */