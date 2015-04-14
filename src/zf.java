import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.URL;
import java.security.Principal;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public final class zf
{
  private final zg a;
  private final zJ b;
  private Socket c;
  private boolean d = false;
  private An e;
  private Br f;
  private zy g = zy.b;
  private long h;
  private zn i;
  private int j;
  private Object k;
  
  public zf(zg paramzg, zJ paramzJ)
  {
    this.a = paramzg;
    this.b = paramzJ;
  }
  
  private zz a(zz paramzz)
  {
    zz localzz;
    if (!this.b.c())
    {
      localzz = null;
      return localzz;
    }
    String str1 = paramzz.a().getHost();
    int m = Ae.a(paramzz.a());
    if (m == Ae.a("https")) {}
    for (String str2 = str1;; str2 = str1 + ":" + m)
    {
      zB localzB = new zB().a(new URL("https", str1, m, "/")).a("Host", str2).a("Proxy-Connection", "Keep-Alive");
      String str3 = paramzz.a("User-Agent");
      if (str3 != null) {
        localzB.a("User-Agent", str3);
      }
      String str4 = paramzz.a("Proxy-Authorization");
      if (str4 != null) {
        localzB.a("Proxy-Authorization", str4);
      }
      localzz = localzB.b();
      break;
    }
  }
  
  private void a(zz paramzz, int paramInt1, int paramInt2)
  {
    zY localzY = zY.a();
    if (paramzz != null) {
      b(paramzz, paramInt1, paramInt2);
    }
    this.c = this.b.a.e.createSocket(this.c, this.b.a.b, this.b.a.c, true);
    SSLSocket localSSLSocket = (SSLSocket)this.c;
    this.b.d.a(localSSLSocket, this.b);
    try
    {
      localSSLSocket.startHandshake();
      if (this.b.d.d())
      {
        String str = localzY.b(localSSLSocket);
        if (str != null) {
          this.g = zy.a(str);
        }
      }
      localzY.a(localSSLSocket);
      this.i = zn.a(localSSLSocket.getSession());
      if (!this.b.a.f.verify(this.b.a.b, localSSLSocket.getSession()))
      {
        X509Certificate localX509Certificate = (X509Certificate)localSSLSocket.getSession().getPeerCertificates()[0];
        throw new IOException("Hostname " + this.b.a.b + " not verified:" + "\n    certificate: " + za.a(localX509Certificate) + "\n    DN: " + localX509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + BK.a(localX509Certificate));
      }
    }
    finally
    {
      localzY.a(localSSLSocket);
    }
    this.b.a.g.a(this.b.a.b, this.i.b());
    if ((this.g == zy.c) || (this.g == zy.d))
    {
      localSSLSocket.setSoTimeout(0);
      this.f = new Bz(this.b.a.a(), true, this.c).a(this.g).a();
      this.f.e();
    }
    for (;;)
    {
      return;
      this.e = new An(this.a, this, this.c);
    }
  }
  
  private void b(zz paramzz, int paramInt1, int paramInt2)
  {
    An localAn = new An(this.a, this, this.c);
    localAn.a(paramInt1, paramInt2);
    URL localURL = paramzz.a();
    String str = "CONNECT " + localURL.getHost() + ":" + localURL.getPort() + " HTTP/1.1";
    do
    {
      localAn.a(paramzz.e(), str);
      localAn.d();
      zF localzF = localAn.g().a(paramzz).a();
      long l = AD.a(localzF);
      if (l == -1L) {
        l = 0L;
      }
      LV localLV = localAn.b(l);
      Ae.b(localLV, 2147483647, TimeUnit.MILLISECONDS);
      localLV.close();
      switch (localzF.c())
      {
      default: 
        throw new IOException("Unexpected response code for CONNECT: " + localzF.c());
      case 200: 
        if (localAn.e() <= 0L) {
          break;
        }
        throw new IOException("TLS tunnel buffered too many bytes!");
      case 407: 
        paramzz = AD.a(this.b.a.h, localzF, this.b.b);
      }
    } while (paramzz != null);
    throw new IOException("Failed to authenticate with proxy");
  }
  
  AL a(Ax paramAx)
  {
    if (this.f != null) {}
    for (Object localObject = new AJ(paramAx, this.f);; localObject = new AC(paramAx, this.e)) {
      return localObject;
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (!this.d) {
      throw new IllegalStateException("setTimeouts - not connected");
    }
    if (this.e != null)
    {
      this.c.setSoTimeout(paramInt1);
      this.e.a(paramInt1, paramInt2);
    }
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, zz paramzz)
  {
    if (this.d) {
      throw new IllegalStateException("already connected");
    }
    if ((this.b.b.type() == Proxy.Type.DIRECT) || (this.b.b.type() == Proxy.Type.HTTP))
    {
      this.c = this.b.a.d.createSocket();
      this.c.setSoTimeout(paramInt2);
      zY.a().a(this.c, this.b.c, paramInt1);
      if (this.b.a.e == null) {
        break label141;
      }
      a(paramzz, paramInt2, paramInt3);
    }
    for (;;)
    {
      this.d = true;
      return;
      this.c = new Socket(this.b.b);
      break;
      label141:
      this.e = new An(this.a, this, this.c);
    }
  }
  
  /* Error */
  void a(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 412	zf:k	()Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 41	zf:a	Lzg;
    //   12: astore_2
    //   13: aload_2
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 414	zf:k	Ljava/lang/Object;
    //   19: ifnull +19 -> 38
    //   22: new 366	java/lang/IllegalStateException
    //   25: dup
    //   26: ldc_w 416
    //   29: invokespecial 369	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   32: athrow
    //   33: astore_3
    //   34: aload_2
    //   35: monitorexit
    //   36: aload_3
    //   37: athrow
    //   38: aload_0
    //   39: aload_1
    //   40: putfield 414	zf:k	Ljava/lang/Object;
    //   43: aload_2
    //   44: monitorexit
    //   45: goto -38 -> 7
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	zf
    //   0	48	1	paramObject	Object
    //   12	32	2	localzg	zg
    //   33	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	36	33	finally
    //   38	45	33	finally
  }
  
  void a(zu paramzu, Object paramObject, zz paramzz)
  {
    a(paramObject);
    if (!b())
    {
      zz localzz = a(paramzz);
      a(paramzu.a(), paramzu.b(), paramzu.c(), localzz);
      if (k()) {
        paramzu.m().b(this);
      }
      paramzu.q().b(c());
    }
    a(paramzu.b(), paramzu.c());
  }
  
  void a(zy paramzy)
  {
    if (paramzy == null) {
      throw new IllegalArgumentException("protocol == null");
    }
    this.g = paramzy;
  }
  
  boolean a()
  {
    boolean bool;
    synchronized (this.a)
    {
      if (this.k == null)
      {
        bool = false;
      }
      else
      {
        this.k = null;
        bool = true;
      }
    }
    return bool;
  }
  
  void b(Object paramObject)
  {
    if (k()) {
      throw new IllegalStateException();
    }
    synchronized (this.a)
    {
      if (this.k == paramObject)
      {
        this.k = null;
        this.c.close();
      }
    }
  }
  
  boolean b()
  {
    return this.d;
  }
  
  public zJ c()
  {
    return this.b;
  }
  
  public Socket d()
  {
    return this.c;
  }
  
  boolean e()
  {
    if ((!this.c.isClosed()) && (!this.c.isInputShutdown()) && (!this.c.isOutputShutdown())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  boolean f()
  {
    if (this.e != null) {}
    for (boolean bool = this.e.f();; bool = true) {
      return bool;
    }
  }
  
  void g()
  {
    if (this.f != null) {
      throw new IllegalStateException("spdyConnection != null");
    }
    this.h = System.nanoTime();
  }
  
  boolean h()
  {
    if ((this.f == null) || (this.f.b())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  long i()
  {
    if (this.f == null) {}
    for (long l = this.h;; l = this.f.c()) {
      return l;
    }
  }
  
  public zn j()
  {
    return this.i;
  }
  
  boolean k()
  {
    if (this.f != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public zy l()
  {
    return this.g;
  }
  
  void m()
  {
    this.j = (1 + this.j);
  }
  
  int n()
  {
    return this.j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Connection{").append(this.b.a.b).append(":").append(this.b.a.c).append(", proxy=").append(this.b.b).append(" hostAddress=").append(this.b.c.getAddress().getHostAddress()).append(" cipherSuite=");
    if (this.i != null) {}
    for (String str = this.i.a();; str = "none") {
      return str + " protocol=" + this.g + '}';
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zf
 * JD-Core Version:    0.7.0.1
 */