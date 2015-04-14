import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class yJ
{
  final Proxy a;
  final String b;
  final int c;
  final SocketFactory d;
  final SSLSocketFactory e;
  final HostnameVerifier f;
  final za g;
  final yK h;
  final List<zy> i;
  final List<zi> j;
  final ProxySelector k;
  
  public yJ(String paramString, int paramInt, SocketFactory paramSocketFactory, SSLSocketFactory paramSSLSocketFactory, HostnameVerifier paramHostnameVerifier, za paramza, yK paramyK, Proxy paramProxy, List<zy> paramList, List<zi> paramList1, ProxySelector paramProxySelector)
  {
    if (paramString == null) {
      throw new NullPointerException("uriHost == null");
    }
    if (paramInt <= 0) {
      throw new IllegalArgumentException("uriPort <= 0: " + paramInt);
    }
    if (paramyK == null) {
      throw new IllegalArgumentException("authenticator == null");
    }
    if (paramList == null) {
      throw new IllegalArgumentException("protocols == null");
    }
    if (paramProxySelector == null) {
      throw new IllegalArgumentException("proxySelector == null");
    }
    this.a = paramProxy;
    this.b = paramString;
    this.c = paramInt;
    this.d = paramSocketFactory;
    this.e = paramSSLSocketFactory;
    this.f = paramHostnameVerifier;
    this.g = paramza;
    this.h = paramyK;
    this.i = Ae.a(paramList);
    this.j = Ae.a(paramList1);
    this.k = paramProxySelector;
  }
  
  public String a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public List<zi> c()
  {
    return this.j;
  }
  
  public Proxy d()
  {
    return this.a;
  }
  
  public ProxySelector e()
  {
    return this.k;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if ((paramObject instanceof yJ))
    {
      yJ localyJ = (yJ)paramObject;
      if ((Ae.a(this.a, localyJ.a)) && (this.b.equals(localyJ.b)) && (this.c == localyJ.c) && (Ae.a(this.e, localyJ.e)) && (Ae.a(this.f, localyJ.f)) && (Ae.a(this.g, localyJ.g)) && (Ae.a(this.h, localyJ.h)) && (Ae.a(this.i, localyJ.i)) && (Ae.a(this.j, localyJ.j)) && (Ae.a(this.k, localyJ.k))) {
        bool = true;
      }
    }
    return bool;
  }
  
  public int hashCode()
  {
    int m = 0;
    int n;
    int i2;
    label61:
    int i3;
    if (this.a != null)
    {
      n = this.a.hashCode();
      int i1 = 31 * (31 * (31 * (n + 527) + this.b.hashCode()) + this.c);
      if (this.e == null) {
        break label169;
      }
      i2 = this.e.hashCode();
      i3 = 31 * (i2 + i1);
      if (this.f == null) {
        break label175;
      }
    }
    label169:
    label175:
    for (int i4 = this.f.hashCode();; i4 = 0)
    {
      int i5 = 31 * (i4 + i3);
      if (this.g != null) {
        m = this.g.hashCode();
      }
      return 31 * (31 * (31 * (31 * (i5 + m) + this.h.hashCode()) + this.i.hashCode()) + this.j.hashCode()) + this.k.hashCode();
      n = 0;
      break;
      i2 = 0;
      break label61;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     yJ
 * JD-Core Version:    0.7.0.1
 */