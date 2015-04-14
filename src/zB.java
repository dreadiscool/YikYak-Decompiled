import java.net.URL;

public class zB
{
  private String a;
  private URL b;
  private String c;
  private zq d;
  private zC e;
  private Object f;
  
  public zB()
  {
    this.c = "GET";
    this.d = new zq();
  }
  
  private zB(zz paramzz)
  {
    this.a = zz.a(paramzz);
    this.b = zz.b(paramzz);
    this.c = zz.c(paramzz);
    this.e = zz.d(paramzz);
    this.f = zz.e(paramzz);
    this.d = zz.f(paramzz).b();
  }
  
  public zB a()
  {
    return a("GET", null);
  }
  
  public zB a(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("url == null");
    }
    this.a = paramString;
    return this;
  }
  
  public zB a(String paramString1, String paramString2)
  {
    this.d.b(paramString1, paramString2);
    return this;
  }
  
  public zB a(String paramString, zC paramzC)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new IllegalArgumentException("method == null || method.length() == 0");
    }
    if ((paramzC != null) && (!AB.c(paramString))) {
      throw new IllegalArgumentException("method " + paramString + " must not have a request body.");
    }
    if ((paramzC == null) && (AB.c(paramString))) {
      paramzC = zC.a(null, Ae.a);
    }
    this.c = paramString;
    this.e = paramzC;
    return this;
  }
  
  public zB a(URL paramURL)
  {
    if (paramURL == null) {
      throw new IllegalArgumentException("url == null");
    }
    this.b = paramURL;
    this.a = paramURL.toString();
    return this;
  }
  
  public zB a(zC paramzC)
  {
    return a("POST", paramzC);
  }
  
  public zB a(zo paramzo)
  {
    this.d = paramzo.b();
    return this;
  }
  
  public zB b(String paramString)
  {
    this.d.b(paramString);
    return this;
  }
  
  public zB b(String paramString1, String paramString2)
  {
    this.d.a(paramString1, paramString2);
    return this;
  }
  
  public zB b(zC paramzC)
  {
    return a("PUT", paramzC);
  }
  
  public zz b()
  {
    if (this.a == null) {
      throw new IllegalStateException("url == null");
    }
    return new zz(this, null);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zB
 * JD-Core Version:    0.7.0.1
 */