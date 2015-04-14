import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class IU
{
  private static final Pattern b = Pattern.compile("http(s?)://[^\\/]+", 2);
  protected final IM a;
  private final String c;
  private final KK d;
  private final KB e;
  private final String f;
  
  public IU(IM paramIM, String paramString1, String paramString2, KK paramKK, KB paramKB)
  {
    if (paramString2 == null) {
      throw new IllegalArgumentException("url must not be null.");
    }
    if (paramKK == null) {
      throw new IllegalArgumentException("requestFactory must not be null.");
    }
    this.a = paramIM;
    this.f = paramString1;
    this.c = a(paramString2);
    this.d = paramKK;
    this.e = paramKB;
  }
  
  private String a(String paramString)
  {
    if (!Jg.c(this.f)) {
      paramString = b.matcher(paramString).replaceFirst(this.f);
    }
    return paramString;
  }
  
  protected KC a(Map<String, String> paramMap)
  {
    return this.d.a(this.e, a(), paramMap).a(false).a(10000).a("User-Agent", "Crashlytics Android SDK/" + this.a.d()).a("X-CRASHLYTICS-DEVELOPER-TOKEN", "bca6990fc3c15a8105800c0673517a4b579634a1");
  }
  
  protected String a()
  {
    return this.c;
  }
  
  protected KC b()
  {
    return a(Collections.emptyMap());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     IU
 * JD-Core Version:    0.7.0.1
 */