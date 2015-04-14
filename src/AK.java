import java.net.ProtocolException;

public final class AK
{
  public final zy a;
  public final int b;
  public final String c;
  
  public AK(zy paramzy, int paramInt, String paramString)
  {
    this.a = paramzy;
    this.b = paramInt;
    this.c = paramString;
  }
  
  public static AK a(String paramString)
  {
    int i = 9;
    int m;
    zy localzy;
    if (paramString.startsWith("HTTP/1."))
    {
      if ((paramString.length() < i) || (paramString.charAt(8) != ' ')) {
        throw new ProtocolException("Unexpected status line: " + paramString);
      }
      m = '￐' + paramString.charAt(7);
      if (m == 0) {
        localzy = zy.a;
      }
    }
    while (paramString.length() < i + 3)
    {
      throw new ProtocolException("Unexpected status line: " + paramString);
      if (m == 1)
      {
        localzy = zy.b;
      }
      else
      {
        throw new ProtocolException("Unexpected status line: " + paramString);
        if (paramString.startsWith("ICY "))
        {
          localzy = zy.a;
          i = 4;
        }
        else
        {
          throw new ProtocolException("Unexpected status line: " + paramString);
        }
      }
    }
    int j = i + 3;
    int k;
    try
    {
      k = Integer.parseInt(paramString.substring(i, j));
      if (paramString.length() > i + 3) {
        if (paramString.charAt(i + 3) != ' ') {
          throw new ProtocolException("Unexpected status line: " + paramString);
        }
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new ProtocolException("Unexpected status line: " + paramString);
    }
    for (String str = paramString.substring(i + 4);; str = "") {
      return new AK(localzy, k, str);
    }
  }
  
  public static AK a(zF paramzF)
  {
    return new AK(paramzF.b(), paramzF.c(), paramzF.e());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.a == zy.a) {}
    for (String str = "HTTP/1.0";; str = "HTTP/1.1")
    {
      localStringBuilder.append(str);
      localStringBuilder.append(' ').append(this.b);
      if (this.c != null) {
        localStringBuilder.append(' ').append(this.c);
      }
      return localStringBuilder.toString();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     AK
 * JD-Core Version:    0.7.0.1
 */