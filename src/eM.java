import android.text.TextUtils;

class eM
{
  private String a;
  private final long b;
  private final long c;
  private String d = "https:";
  
  eM(String paramString, long paramLong1, long paramLong2)
  {
    this.a = paramString;
    this.b = paramLong1;
    this.c = paramLong2;
  }
  
  String a()
  {
    return this.a;
  }
  
  void a(String paramString)
  {
    this.a = paramString;
  }
  
  long b()
  {
    return this.b;
  }
  
  void b(String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString.trim()))) {}
    for (;;)
    {
      return;
      if (paramString.toLowerCase().startsWith("http:")) {
        this.d = "http:";
      }
    }
  }
  
  long c()
  {
    return this.c;
  }
  
  String d()
  {
    return this.d;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     eM
 * JD-Core Version:    0.7.0.1
 */