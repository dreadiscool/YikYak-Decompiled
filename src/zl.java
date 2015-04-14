import java.io.UnsupportedEncodingException;

public final class zl
{
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      String str1 = LE.a((paramString1 + ":" + paramString2).getBytes("ISO-8859-1")).b();
      String str2 = "Basic " + str1;
      return str2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new AssertionError();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zl
 * JD-Core Version:    0.7.0.1
 */