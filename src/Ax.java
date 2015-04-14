import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.Map;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class Ax
{
  private static final zI d = new Ay();
  final zu a;
  long b = -1L;
  public final boolean c;
  private zf e;
  private AI f;
  private zJ g;
  private final zF h;
  private AL i;
  private boolean j;
  private final zz k;
  private zz l;
  private zF m;
  private zF n;
  private LU o;
  private LC p;
  private final boolean q;
  private final boolean r;
  private Ai s;
  private Aj t;
  
  public Ax(zu paramzu, zz paramzz, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, zf paramzf, AI paramAI, AH paramAH, zF paramzF)
  {
    this.a = paramzu;
    this.k = paramzz;
    this.c = paramBoolean1;
    this.q = paramBoolean2;
    this.r = paramBoolean3;
    this.e = paramzf;
    this.f = paramAI;
    this.o = paramAH;
    this.h = paramzF;
    if (paramzf != null) {
      zS.b.b(paramzf, this);
    }
    for (this.g = paramzf.c();; this.g = null) {
      return;
    }
  }
  
  public static String a(URL paramURL)
  {
    if (Ae.a(paramURL) != Ae.a(paramURL.getProtocol())) {}
    for (String str = paramURL.getHost() + ":" + paramURL.getPort();; str = paramURL.getHost()) {
      return str;
    }
  }
  
  private zF a(Ai paramAi, zF paramzF)
  {
    if (paramAi == null) {}
    for (;;)
    {
      return paramzF;
      LU localLU = paramAi.b();
      if (localLU != null)
      {
        Az localAz = new Az(this, paramzF.h().c(), paramAi, LK.a(localLU));
        paramzF = paramzF.i().a(new AF(paramzF.g(), LK.a(localAz))).a();
      }
    }
  }
  
  private static zo a(zo paramzo1, zo paramzo2)
  {
    int i1 = 0;
    zq localzq = new zq();
    int i2 = paramzo1.a();
    int i3 = 0;
    if (i3 < i2)
    {
      String str2 = paramzo1.a(i3);
      String str3 = paramzo1.b(i3);
      if (("Warning".equalsIgnoreCase(str2)) && (str3.startsWith("1"))) {}
      for (;;)
      {
        i3++;
        break;
        if ((!AD.a(str2)) || (paramzo2.a(str2) == null)) {
          localzq.a(str2, str3);
        }
      }
    }
    int i4 = paramzo2.a();
    if (i1 < i4)
    {
      String str1 = paramzo2.a(i1);
      if ("Content-Length".equalsIgnoreCase(str1)) {}
      for (;;)
      {
        i1++;
        break;
        if (AD.a(str1)) {
          localzq.a(str1, paramzo2.b(i1));
        }
      }
    }
    return localzq.a();
  }
  
  private void a(zz paramzz)
  {
    if (this.e != null) {
      throw new IllegalStateException();
    }
    if (this.f == null) {
      this.f = AI.a(paramzz, this.a);
    }
    this.e = this.f.a(this);
    this.g = this.e.c();
  }
  
  public static boolean a(zF paramzF)
  {
    boolean bool = false;
    if (paramzF.a().d().equals("HEAD")) {}
    for (;;)
    {
      return bool;
      int i1 = paramzF.c();
      if (((i1 < 100) || (i1 >= 200)) && (i1 != 204) && (i1 != 304)) {
        bool = true;
      } else if ((AD.a(paramzF) != -1L) || ("chunked".equalsIgnoreCase(paramzF.a("Transfer-Encoding")))) {
        bool = true;
      }
    }
  }
  
  private static boolean a(zF paramzF1, zF paramzF2)
  {
    boolean bool = true;
    if (paramzF2.c() == 304) {}
    for (;;)
    {
      return bool;
      Date localDate1 = paramzF1.g().b("Last-Modified");
      if (localDate1 != null)
      {
        Date localDate2 = paramzF2.g().b("Last-Modified");
        if ((localDate2 != null) && (localDate2.getTime() < localDate1.getTime())) {}
      }
      else
      {
        bool = false;
      }
    }
  }
  
  private static zF b(zF paramzF)
  {
    if ((paramzF != null) && (paramzF.h() != null)) {
      paramzF = paramzF.i().a(null).a();
    }
    return paramzF;
  }
  
  private zz b(zz paramzz)
  {
    zB localzB = paramzz.g();
    if (paramzz.a("Host") == null) {
      localzB.a("Host", a(paramzz.a()));
    }
    if (((this.e == null) || (this.e.l() != zy.a)) && (paramzz.a("Connection") == null)) {
      localzB.a("Connection", "Keep-Alive");
    }
    if (paramzz.a("Accept-Encoding") == null)
    {
      this.j = true;
      localzB.a("Accept-Encoding", "gzip");
    }
    CookieHandler localCookieHandler = this.a.f();
    if (localCookieHandler != null)
    {
      Map localMap = AD.a(localzB.b().e(), null);
      AD.a(localzB, localCookieHandler.get(paramzz.b(), localMap));
    }
    if (paramzz.a("User-Agent") == null) {
      localzB.a("User-Agent", Ag.a());
    }
    return localzB.b();
  }
  
  private boolean b(IOException paramIOException)
  {
    boolean bool = false;
    if (!this.a.p()) {}
    for (;;)
    {
      return bool;
      if ((!(paramIOException instanceof SSLPeerUnverifiedException)) && ((!(paramIOException instanceof SSLHandshakeException)) || (!(paramIOException.getCause() instanceof CertificateException))) && (!(paramIOException instanceof ProtocolException)) && (!(paramIOException instanceof InterruptedIOException))) {
        bool = true;
      }
    }
  }
  
  private zF c(zF paramzF)
  {
    if ((!this.j) || (!"gzip".equalsIgnoreCase(this.n.a("Content-Encoding")))) {}
    for (;;)
    {
      return paramzF;
      if (paramzF.h() != null)
      {
        LI localLI = new LI(paramzF.h().c());
        zo localzo = paramzF.g().b().b("Content-Encoding").b("Content-Length").a();
        paramzF = paramzF.i().a(localzo).a(new AF(localzo, LK.a(localLI))).a();
      }
    }
  }
  
  private void p()
  {
    zT localzT = zS.b.a(this.a);
    if (localzT == null) {}
    for (;;)
    {
      return;
      if (!Aj.a(this.n, this.l))
      {
        if (AB.a(this.l.d())) {
          try
          {
            localzT.b(this.l);
          }
          catch (IOException localIOException) {}
        }
      }
      else {
        this.s = localzT.a(b(this.n));
      }
    }
  }
  
  private zF q()
  {
    this.i.a();
    zF localzF = this.i.b().a(this.l).a(this.e.j()).a(AD.b, Long.toString(this.b)).a(AD.c, Long.toString(System.currentTimeMillis())).a();
    if (!this.r) {
      localzF = localzF.i().a(this.i.a(localzF)).a();
    }
    zS.b.a(this.e, localzF.b());
    return localzF;
  }
  
  public Ax a(IOException paramIOException)
  {
    return a(paramIOException, this.o);
  }
  
  public Ax a(IOException paramIOException, LU paramLU)
  {
    if ((this.f != null) && (this.e != null)) {
      this.f.a(this.e, paramIOException);
    }
    int i1;
    if ((paramLU == null) || ((paramLU instanceof AH)))
    {
      i1 = 1;
      if (((this.f != null) || (this.e != null)) && ((this.f == null) || (this.f.a())) && (b(paramIOException)) && (i1 != 0)) {
        break label93;
      }
    }
    label93:
    zf localzf;
    for (Ax localAx = null;; localAx = new Ax(this.a, this.k, this.c, this.q, this.r, localzf, this.f, (AH)paramLU, this.h))
    {
      return localAx;
      i1 = 0;
      break;
      localzf = m();
    }
  }
  
  public void a()
  {
    if (this.t != null) {}
    label277:
    for (;;)
    {
      return;
      if (this.i != null) {
        throw new IllegalStateException();
      }
      zz localzz = b(this.k);
      zT localzT = zS.b.a(this.a);
      if (localzT != null) {}
      long l1;
      for (zF localzF = localzT.a(localzz);; localzF = null)
      {
        this.t = new Al(System.currentTimeMillis(), localzz, localzF).a();
        this.l = this.t.a;
        this.m = this.t.b;
        if (localzT != null) {
          localzT.a(this.t);
        }
        if ((localzF != null) && (this.m == null)) {
          Ae.a(localzF.h());
        }
        if (this.l == null) {
          break label312;
        }
        if (this.e == null) {
          a(this.l);
        }
        this.i = zS.b.a(this.e, this);
        if ((!this.q) || (!c()) || (this.o != null)) {
          break;
        }
        l1 = AD.a(localzz);
        if (!this.c) {
          break label277;
        }
        if (l1 <= 2147483647L) {
          break label224;
        }
        throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
      }
      label224:
      if (l1 != -1L)
      {
        this.i.a(this.l);
        this.o = new AH((int)l1);
      }
      else
      {
        this.o = new AH();
        continue;
        this.i.a(this.l);
        this.o = this.i.a(this.l, l1);
      }
    }
    label312:
    if (this.e != null)
    {
      zS.b.a(this.a.m(), this.e);
      this.e = null;
    }
    if (this.m != null) {}
    for (this.n = this.m.i().a(this.k).c(b(this.h)).b(b(this.m)).a();; this.n = new zH().a(this.k).c(b(this.h)).a(zy.b).a(504).a("Unsatisfiable Request (only-if-cached)").a(d).a())
    {
      this.n = c(this.n);
      break;
    }
  }
  
  public void a(zo paramzo)
  {
    CookieHandler localCookieHandler = this.a.f();
    if (localCookieHandler != null) {
      localCookieHandler.put(this.k.b(), AD.a(paramzo, null));
    }
  }
  
  public void b()
  {
    if (this.b != -1L) {
      throw new IllegalStateException();
    }
    this.b = System.currentTimeMillis();
  }
  
  public boolean b(URL paramURL)
  {
    URL localURL = this.k.a();
    if ((localURL.getHost().equals(paramURL.getHost())) && (Ae.a(localURL) == Ae.a(paramURL)) && (localURL.getProtocol().equals(paramURL.getProtocol()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  boolean c()
  {
    return AB.c(this.k.d());
  }
  
  public LU d()
  {
    if (this.t == null) {
      throw new IllegalStateException();
    }
    return this.o;
  }
  
  public LC e()
  {
    LC localLC = this.p;
    if (localLC != null) {}
    for (;;)
    {
      return localLC;
      LU localLU = d();
      if (localLU != null)
      {
        localLC = LK.a(localLU);
        this.p = localLC;
      }
      else
      {
        localLC = null;
      }
    }
  }
  
  public boolean f()
  {
    if (this.n != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public zz g()
  {
    return this.k;
  }
  
  public zF h()
  {
    if (this.n == null) {
      throw new IllegalStateException();
    }
    return this.n;
  }
  
  public zf i()
  {
    return this.e;
  }
  
  public zJ j()
  {
    return this.g;
  }
  
  public void k()
  {
    if ((this.i != null) && (this.e != null)) {
      this.i.c();
    }
    this.e = null;
  }
  
  public void l()
  {
    if (this.i != null) {}
    try
    {
      this.i.a(this);
      label17:
      return;
    }
    catch (IOException localIOException)
    {
      break label17;
    }
  }
  
  public zf m()
  {
    Object localObject = null;
    if (this.p != null)
    {
      Ae.a(this.p);
      if (this.n != null) {
        break label64;
      }
      if (this.e != null) {
        Ae.a(this.e.d());
      }
      this.e = null;
    }
    for (;;)
    {
      return localObject;
      if (this.o == null) {
        break;
      }
      Ae.a(this.o);
      break;
      label64:
      Ae.a(this.n.h());
      if ((this.i != null) && (this.e != null) && (!this.i.d()))
      {
        Ae.a(this.e.d());
        this.e = null;
      }
      else
      {
        if ((this.e != null) && (!zS.b.a(this.e))) {
          this.e = null;
        }
        zf localzf = this.e;
        this.e = null;
        localObject = localzf;
      }
    }
  }
  
  public void n()
  {
    if (this.n != null) {}
    for (;;)
    {
      return;
      if ((this.l == null) && (this.m == null)) {
        throw new IllegalStateException("call sendRequest() first!");
      }
      if (this.l != null)
      {
        if (this.r) {
          this.i.a(this.l);
        }
        for (zF localzF = q();; localzF = new AA(this, 0, this.l).a(this.l))
        {
          a(localzF.g());
          if (this.m == null) {
            break label442;
          }
          if (!a(this.m, localzF)) {
            break label432;
          }
          this.n = this.m.i().a(this.k).c(b(this.h)).a(a(this.m.g(), localzF.g())).b(b(this.m)).a(b(localzF)).a();
          localzF.h().close();
          k();
          zT localzT = zS.b.a(this.a);
          localzT.a();
          localzT.a(this.m, b(this.n));
          this.n = c(this.n);
          break;
          if (this.q) {
            break label247;
          }
        }
        label247:
        if ((this.p != null) && (this.p.d().c() > 0L)) {
          this.p.g();
        }
        if (this.b == -1L)
        {
          if ((AD.a(this.l) == -1L) && ((this.o instanceof AH)))
          {
            long l1 = ((AH)this.o).c();
            this.l = this.l.g().a("Content-Length", Long.toString(l1)).b();
          }
          this.i.a(this.l);
        }
        if (this.o != null)
        {
          if (this.p == null) {
            break label420;
          }
          this.p.close();
        }
        for (;;)
        {
          if ((this.o instanceof AH)) {
            this.i.a((AH)this.o);
          }
          localzF = q();
          break;
          label420:
          this.o.close();
        }
        label432:
        Ae.a(this.m.h());
        label442:
        this.n = localzF.i().a(this.k).c(b(this.h)).b(b(this.m)).a(b(localzF)).a();
        if (a(this.n))
        {
          p();
          this.n = c(a(this.s, this.n));
        }
      }
    }
  }
  
  public zz o()
  {
    if (this.n == null) {
      throw new IllegalStateException();
    }
    Proxy localProxy;
    zz localzz;
    if (j() != null)
    {
      localProxy = j().b();
      switch (this.n.c())
      {
      default: 
        localzz = null;
      }
    }
    for (;;)
    {
      return localzz;
      localProxy = this.a.d();
      break;
      if (localProxy.type() != Proxy.Type.HTTP) {
        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
      }
      localzz = AD.a(this.a.l(), this.n, localProxy);
      continue;
      if ((!this.k.d().equals("GET")) && (!this.k.d().equals("HEAD")))
      {
        localzz = null;
      }
      else if (!this.a.o())
      {
        localzz = null;
      }
      else
      {
        String str = this.n.a("Location");
        if (str == null)
        {
          localzz = null;
        }
        else
        {
          URL localURL = new URL(this.k.a(), str);
          if ((!localURL.getProtocol().equals("https")) && (!localURL.getProtocol().equals("http")))
          {
            localzz = null;
          }
          else if ((!localURL.getProtocol().equals(this.k.a().getProtocol())) && (!this.a.n()))
          {
            localzz = null;
          }
          else
          {
            zB localzB = this.k.g();
            if (AB.c(this.k.d()))
            {
              localzB.a("GET", null);
              localzB.b("Transfer-Encoding");
              localzB.b("Content-Length");
              localzB.b("Content-Type");
            }
            if (!b(localURL)) {
              localzB.b("Authorization");
            }
            localzz = localzB.a(localURL).b();
          }
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ax
 * JD-Core Version:    0.7.0.1
 */