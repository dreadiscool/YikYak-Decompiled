import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zt
{
  private static final Pattern a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
  private static final Pattern b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
  private final String c;
  private final String d;
  private final String e;
  private final String f;
  
  private zt(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramString4;
  }
  
  public static zt a(String paramString)
  {
    zt localzt = null;
    Matcher localMatcher1 = a.matcher(paramString);
    if (!localMatcher1.lookingAt()) {}
    for (;;)
    {
      return localzt;
      String str1 = localMatcher1.group(1).toLowerCase(Locale.US);
      String str2 = localMatcher1.group(2).toLowerCase(Locale.US);
      Matcher localMatcher2 = b.matcher(paramString);
      int i = localMatcher1.end();
      Object localObject = null;
      if (i < paramString.length())
      {
        localMatcher2.region(i, paramString.length());
        if (localMatcher2.lookingAt())
        {
          String str3 = localMatcher2.group(1);
          if ((str3 == null) || (!str3.equalsIgnoreCase("charset"))) {}
          for (;;)
          {
            i = localMatcher2.end();
            break;
            if (localMatcher2.group(2) != null) {}
            for (String str4 = localMatcher2.group(2); (localObject != null) && (!str4.equalsIgnoreCase((String)localObject)); str4 = localMatcher2.group(3)) {
              throw new IllegalArgumentException("Multiple different charsets: " + paramString);
            }
            localObject = str4;
          }
        }
      }
      else
      {
        localzt = new zt(paramString, str1, str2, (String)localObject);
      }
    }
  }
  
  public Charset a()
  {
    if (this.f != null) {}
    for (Charset localCharset = Charset.forName(this.f);; localCharset = null) {
      return localCharset;
    }
  }
  
  public Charset a(Charset paramCharset)
  {
    if (this.f != null) {
      paramCharset = Charset.forName(this.f);
    }
    return paramCharset;
  }
  
  public boolean equals(Object paramObject)
  {
    if (((paramObject instanceof zt)) && (((zt)paramObject).c.equals(this.c))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int hashCode()
  {
    return this.c.hashCode();
  }
  
  public String toString()
  {
    return this.c;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zt
 * JD-Core Version:    0.7.0.1
 */