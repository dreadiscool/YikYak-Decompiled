import java.util.Collections;
import java.util.List;

public final class zF
{
  private final zz a;
  private final zy b;
  private final int c;
  private final String d;
  private final zn e;
  private final zo f;
  private final zI g;
  private zF h;
  private zF i;
  private final zF j;
  private volatile yS k;
  
  private zF(zH paramzH)
  {
    this.a = zH.a(paramzH);
    this.b = zH.b(paramzH);
    this.c = zH.c(paramzH);
    this.d = zH.d(paramzH);
    this.e = zH.e(paramzH);
    this.f = zH.f(paramzH).a();
    this.g = zH.g(paramzH);
    this.h = zH.h(paramzH);
    this.i = zH.i(paramzH);
    this.j = zH.j(paramzH);
  }
  
  public String a(String paramString)
  {
    return a(paramString, null);
  }
  
  public String a(String paramString1, String paramString2)
  {
    String str = this.f.a(paramString1);
    if (str != null) {
      paramString2 = str;
    }
    return paramString2;
  }
  
  public zz a()
  {
    return this.a;
  }
  
  public zy b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    if ((this.c >= 200) && (this.c < 300)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public String e()
  {
    return this.d;
  }
  
  public zn f()
  {
    return this.e;
  }
  
  public zo g()
  {
    return this.f;
  }
  
  public zI h()
  {
    return this.g;
  }
  
  public zH i()
  {
    return new zH(this, null);
  }
  
  public zF j()
  {
    return this.h;
  }
  
  public zF k()
  {
    return this.i;
  }
  
  public List<zd> l()
  {
    String str;
    if (this.c == 401) {
      str = "WWW-Authenticate";
    }
    for (List localList = AD.b(g(), str);; localList = Collections.emptyList())
    {
      return localList;
      if (this.c == 407)
      {
        str = "Proxy-Authenticate";
        break;
      }
    }
  }
  
  public yS m()
  {
    yS localyS = this.k;
    if (localyS != null) {}
    for (;;)
    {
      return localyS;
      localyS = yS.a(this.f);
      this.k = localyS;
    }
  }
  
  public String toString()
  {
    return "Response{protocol=" + this.b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.a.c() + '}';
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zF
 * JD-Core Version:    0.7.0.1
 */