import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocketFactory;

public final class AI
{
  private final yJ a;
  private final URI b;
  private final zV c;
  private final zu d;
  private final zg e;
  private final Ad f;
  private final zz g;
  private Proxy h;
  private InetSocketAddress i;
  private zi j;
  private List<Proxy> k = Collections.emptyList();
  private int l;
  private List<InetSocketAddress> m = Collections.emptyList();
  private int n;
  private List<zi> o = Collections.emptyList();
  private int p;
  private final List<zJ> q = new ArrayList();
  
  private AI(yJ paramyJ, URI paramURI, zu paramzu, zz paramzz)
  {
    this.a = paramyJ;
    this.b = paramURI;
    this.d = paramzu;
    this.e = paramzu.m();
    this.f = zS.b.b(paramzu);
    this.c = zS.b.c(paramzu);
    this.g = paramzz;
    a(paramURI, paramyJ.d());
  }
  
  public static AI a(zz paramzz, zu paramzu)
  {
    za localza = null;
    String str = paramzz.a().getHost();
    if ((str == null) || (str.length() == 0)) {
      throw new UnknownHostException(paramzz.a().toString());
    }
    SSLSocketFactory localSSLSocketFactory;
    HostnameVerifier localHostnameVerifier;
    if (paramzz.i())
    {
      localSSLSocketFactory = paramzu.i();
      localHostnameVerifier = paramzu.j();
      localza = paramzu.k();
    }
    for (;;)
    {
      return new AI(new yJ(str, Ae.a(paramzz.a()), paramzu.h(), localSSLSocketFactory, localHostnameVerifier, localza, paramzu.l(), paramzu.d(), paramzu.s(), paramzu.t(), paramzu.e()), paramzz.b(), paramzu, paramzz);
      localHostnameVerifier = null;
      localSSLSocketFactory = null;
    }
  }
  
  static String a(InetSocketAddress paramInetSocketAddress)
  {
    InetAddress localInetAddress = paramInetSocketAddress.getAddress();
    if (localInetAddress == null) {}
    for (String str = paramInetSocketAddress.getHostName();; str = localInetAddress.getHostAddress()) {
      return str;
    }
  }
  
  private void a(Proxy paramProxy)
  {
    this.m = new ArrayList();
    String str;
    if ((paramProxy.type() == Proxy.Type.DIRECT) || (paramProxy.type() == Proxy.Type.SOCKS)) {
      str = this.a.a();
    }
    InetSocketAddress localInetSocketAddress;
    for (int i1 = Ae.a(this.b);; i1 = localInetSocketAddress.getPort())
    {
      for (InetAddress localInetAddress : this.c.a(str)) {
        this.m.add(new InetSocketAddress(localInetAddress, i1));
      }
      SocketAddress localSocketAddress = paramProxy.address();
      if (!(localSocketAddress instanceof InetSocketAddress)) {
        throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + localSocketAddress.getClass());
      }
      localInetSocketAddress = (InetSocketAddress)localSocketAddress;
      str = a(localInetSocketAddress);
    }
    this.n = 0;
  }
  
  private void a(URI paramURI, Proxy paramProxy)
  {
    if (paramProxy != null) {
      this.k = Collections.singletonList(paramProxy);
    }
    for (;;)
    {
      this.l = 0;
      return;
      this.k = new ArrayList();
      List localList = this.d.e().select(paramURI);
      if (localList != null) {
        this.k.addAll(localList);
      }
      this.k.removeAll(Collections.singleton(Proxy.NO_PROXY));
      this.k.add(Proxy.NO_PROXY);
    }
  }
  
  private boolean a(zi paramzi)
  {
    boolean bool = false;
    if ((paramzi != this.o.get(0)) && (paramzi.a())) {
      bool = true;
    }
    return bool;
  }
  
  private boolean c()
  {
    if (this.l < this.k.size()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private Proxy d()
  {
    if (!c()) {
      throw new SocketException("No route to " + this.a.a() + "; exhausted proxy configurations: " + this.k);
    }
    List localList = this.k;
    int i1 = this.l;
    this.l = (i1 + 1);
    Proxy localProxy = (Proxy)localList.get(i1);
    a(localProxy);
    return localProxy;
  }
  
  private boolean e()
  {
    if (this.n < this.m.size()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private InetSocketAddress f()
  {
    if (!e()) {
      throw new SocketException("No route to " + this.a.a() + "; exhausted inet socket addresses: " + this.m);
    }
    List localList = this.m;
    int i1 = this.n;
    this.n = (i1 + 1);
    InetSocketAddress localInetSocketAddress = (InetSocketAddress)localList.get(i1);
    g();
    return localInetSocketAddress;
  }
  
  private void g()
  {
    this.o = new ArrayList();
    List localList = this.a.c();
    int i1 = localList.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      zi localzi = (zi)localList.get(i2);
      if (this.g.i() == localzi.a()) {
        this.o.add(localzi);
      }
    }
    this.p = 0;
  }
  
  private boolean h()
  {
    if (this.p < this.o.size()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private zi i()
  {
    if (!h()) {
      throw new SocketException("No route to " + this.a.a() + "; exhausted connection specs: " + this.o);
    }
    List localList = this.o;
    int i1 = this.p;
    this.p = (i1 + 1);
    return (zi)localList.get(i1);
  }
  
  private boolean j()
  {
    if (!this.q.isEmpty()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private zJ k()
  {
    return (zJ)this.q.remove(0);
  }
  
  public zf a(Ax paramAx)
  {
    zf localzf = b();
    zS.b.a(this.d, localzf, paramAx, this.g);
    return localzf;
  }
  
  public void a(zf paramzf, IOException paramIOException)
  {
    if (zS.b.b(paramzf) > 0) {}
    for (;;)
    {
      return;
      zJ localzJ1 = paramzf.c();
      if ((localzJ1.b().type() != Proxy.Type.DIRECT) && (this.a.e() != null)) {
        this.a.e().connectFailed(this.b, localzJ1.b().address(), paramIOException);
      }
      this.f.a(localzJ1);
      if ((!(paramIOException instanceof SSLHandshakeException)) && (!(paramIOException instanceof SSLProtocolException))) {
        while (this.p < this.o.size())
        {
          List localList = this.o;
          int i1 = this.p;
          this.p = (i1 + 1);
          zi localzi = (zi)localList.get(i1);
          boolean bool = a(localzi);
          zJ localzJ2 = new zJ(this.a, this.h, this.i, localzi, bool);
          this.f.a(localzJ2);
        }
      }
    }
  }
  
  public boolean a()
  {
    if ((h()) || (e()) || (c()) || (j())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  zf b()
  {
    zf localzf = this.e.a(this.a);
    if (localzf != null) {
      if ((!this.g.d().equals("GET")) && (!zS.b.c(localzf))) {}
    }
    for (;;)
    {
      return localzf;
      localzf.d().close();
      break;
      if (!h())
      {
        if (!e())
        {
          if (!c())
          {
            if (!j()) {
              throw new NoSuchElementException();
            }
            localzf = new zf(this.e, k());
          }
          else
          {
            this.h = d();
          }
        }
        else {
          this.i = f();
        }
      }
      else
      {
        this.j = i();
        boolean bool = a(this.j);
        zJ localzJ = new zJ(this.a, this.h, this.i, this.j, bool);
        if (this.f.c(localzJ))
        {
          this.q.add(localzJ);
          localzf = b();
        }
        else
        {
          localzf = new zf(this.e, localzJ);
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     AI
 * JD-Core Version:    0.7.0.1
 */