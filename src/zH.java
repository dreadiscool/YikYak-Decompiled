public class zH
{
  private zz a;
  private zy b;
  private int c = -1;
  private String d;
  private zn e;
  private zq f;
  private zI g;
  private zF h;
  private zF i;
  private zF j;
  
  public zH()
  {
    this.f = new zq();
  }
  
  private zH(zF paramzF)
  {
    this.a = zF.a(paramzF);
    this.b = zF.b(paramzF);
    this.c = zF.c(paramzF);
    this.d = zF.d(paramzF);
    this.e = zF.e(paramzF);
    this.f = zF.f(paramzF).b();
    this.g = zF.g(paramzF);
    this.h = zF.h(paramzF);
    this.i = zF.i(paramzF);
    this.j = zF.j(paramzF);
  }
  
  private void a(String paramString, zF paramzF)
  {
    if (zF.g(paramzF) != null) {
      throw new IllegalArgumentException(paramString + ".body != null");
    }
    if (zF.h(paramzF) != null) {
      throw new IllegalArgumentException(paramString + ".networkResponse != null");
    }
    if (zF.i(paramzF) != null) {
      throw new IllegalArgumentException(paramString + ".cacheResponse != null");
    }
    if (zF.j(paramzF) != null) {
      throw new IllegalArgumentException(paramString + ".priorResponse != null");
    }
  }
  
  private void d(zF paramzF)
  {
    if (zF.g(paramzF) != null) {
      throw new IllegalArgumentException("priorResponse.body != null");
    }
  }
  
  public zF a()
  {
    if (this.a == null) {
      throw new IllegalStateException("request == null");
    }
    if (this.b == null) {
      throw new IllegalStateException("protocol == null");
    }
    if (this.c < 0) {
      throw new IllegalStateException("code < 0: " + this.c);
    }
    return new zF(this, null);
  }
  
  public zH a(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public zH a(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public zH a(String paramString1, String paramString2)
  {
    this.f.b(paramString1, paramString2);
    return this;
  }
  
  public zH a(zF paramzF)
  {
    if (paramzF != null) {
      a("networkResponse", paramzF);
    }
    this.h = paramzF;
    return this;
  }
  
  public zH a(zI paramzI)
  {
    this.g = paramzI;
    return this;
  }
  
  public zH a(zn paramzn)
  {
    this.e = paramzn;
    return this;
  }
  
  public zH a(zo paramzo)
  {
    this.f = paramzo.b();
    return this;
  }
  
  public zH a(zy paramzy)
  {
    this.b = paramzy;
    return this;
  }
  
  public zH a(zz paramzz)
  {
    this.a = paramzz;
    return this;
  }
  
  public zH b(String paramString1, String paramString2)
  {
    this.f.a(paramString1, paramString2);
    return this;
  }
  
  public zH b(zF paramzF)
  {
    if (paramzF != null) {
      a("cacheResponse", paramzF);
    }
    this.i = paramzF;
    return this;
  }
  
  public zH c(zF paramzF)
  {
    if (paramzF != null) {
      d(paramzF);
    }
    this.j = paramzF;
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zH
 * JD-Core Version:    0.7.0.1
 */