import android.text.TextUtils;

public class fx
{
  private String a;
  private final long b;
  private final long c;
  private final String d;
  private String e;
  private String f = "https:";
  
  public fx(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    this.a = paramString1;
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramString2;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public long b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString.trim()))) {}
    for (;;)
    {
      return;
      this.e = paramString;
      if (paramString.toLowerCase().startsWith("http:")) {
        this.f = "http:";
      }
    }
  }
  
  public long c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.f;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     fx
 * JD-Core Version:    0.7.0.1
 */