import java.net.CookieHandler;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public class zu
  implements Cloneable
{
  private static final List<zy> a;
  private static final List<zi> b;
  private static SSLSocketFactory c;
  private int A;
  private final Ad d;
  private zm e;
  private Proxy f;
  private List<zy> g;
  private List<zi> h;
  private final List<zr> i = new ArrayList();
  private final List<zr> j = new ArrayList();
  private ProxySelector k;
  private CookieHandler l;
  private zT m;
  private yL n;
  private SocketFactory o;
  private SSLSocketFactory p;
  private HostnameVerifier q;
  private za r;
  private yK s;
  private zg t;
  private zV u;
  private boolean v = true;
  private boolean w = true;
  private boolean x = true;
  private int y;
  private int z;
  
  static
  {
    zy[] arrayOfzy = new zy[3];
    arrayOfzy[0] = zy.d;
    arrayOfzy[1] = zy.c;
    arrayOfzy[2] = zy.b;
    a = Ae.a(arrayOfzy);
    zi[] arrayOfzi = new zi[3];
    arrayOfzi[0] = zi.a;
    arrayOfzi[1] = zi.b;
    arrayOfzi[2] = zi.c;
    b = Ae.a(arrayOfzi);
    zS.b = new zv();
  }
  
  public zu()
  {
    this.d = new Ad();
    this.e = new zm();
  }
  
  private zu(zu paramzu)
  {
    this.d = paramzu.d;
    this.e = paramzu.e;
    this.f = paramzu.f;
    this.g = paramzu.g;
    this.h = paramzu.h;
    this.i.addAll(paramzu.i);
    this.j.addAll(paramzu.j);
    this.k = paramzu.k;
    this.l = paramzu.l;
    this.n = paramzu.n;
    if (this.n != null) {}
    for (zT localzT = this.n.a;; localzT = paramzu.m)
    {
      this.m = localzT;
      this.o = paramzu.o;
      this.p = paramzu.p;
      this.q = paramzu.q;
      this.r = paramzu.r;
      this.s = paramzu.s;
      this.t = paramzu.t;
      this.u = paramzu.u;
      this.v = paramzu.v;
      this.w = paramzu.w;
      this.x = paramzu.x;
      this.y = paramzu.y;
      this.z = paramzu.z;
      this.A = paramzu.A;
      return;
    }
  }
  
  /* Error */
  private SSLSocketFactory y()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 167	zu:c	Ljavax/net/ssl/SSLSocketFactory;
    //   5: astore_2
    //   6: aload_2
    //   7: ifnonnull +26 -> 33
    //   10: ldc 169
    //   12: invokestatic 175	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   15: astore 5
    //   17: aload 5
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: invokevirtual 179	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   25: aload 5
    //   27: invokevirtual 182	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   30: putstatic 167	zu:c	Ljavax/net/ssl/SSLSocketFactory;
    //   33: getstatic 167	zu:c	Ljavax/net/ssl/SSLSocketFactory;
    //   36: astore_3
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_3
    //   40: areturn
    //   41: astore 4
    //   43: new 184	java/lang/AssertionError
    //   46: dup
    //   47: invokespecial 185	java/lang/AssertionError:<init>	()V
    //   50: athrow
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	zu
    //   51	4	1	localObject	Object
    //   5	2	2	localSSLSocketFactory1	SSLSocketFactory
    //   36	4	3	localSSLSocketFactory2	SSLSocketFactory
    //   41	1	4	localGeneralSecurityException	java.security.GeneralSecurityException
    //   15	11	5	localSSLContext	javax.net.ssl.SSLContext
    // Exception table:
    //   from	to	target	type
    //   10	33	41	java/security/GeneralSecurityException
    //   2	6	51	finally
    //   10	33	51	finally
    //   33	37	51	finally
    //   43	51	51	finally
  }
  
  public final int a()
  {
    return this.y;
  }
  
  public yV a(zz paramzz)
  {
    return new yV(this, paramzz);
  }
  
  public final zu a(Proxy paramProxy)
  {
    this.f = paramProxy;
    return this;
  }
  
  public final zu a(List<zy> paramList)
  {
    List localList = Ae.a(paramList);
    if (!localList.contains(zy.b)) {
      throw new IllegalArgumentException("protocols doesn't contain http/1.1: " + localList);
    }
    if (localList.contains(zy.a)) {
      throw new IllegalArgumentException("protocols must not contain http/1.0: " + localList);
    }
    if (localList.contains(null)) {
      throw new IllegalArgumentException("protocols must not contain null");
    }
    this.g = Ae.a(localList);
    return this;
  }
  
  public final zu a(HostnameVerifier paramHostnameVerifier)
  {
    this.q = paramHostnameVerifier;
    return this;
  }
  
  public final zu a(SSLSocketFactory paramSSLSocketFactory)
  {
    this.p = paramSSLSocketFactory;
    return this;
  }
  
  public final zu a(yL paramyL)
  {
    this.n = paramyL;
    this.m = null;
    return this;
  }
  
  public final zu a(za paramza)
  {
    this.r = paramza;
    return this;
  }
  
  public final void a(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("timeout < 0");
    }
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("unit == null");
    }
    long l1 = paramTimeUnit.toMillis(paramLong);
    if (l1 > 2147483647L) {
      throw new IllegalArgumentException("Timeout too large.");
    }
    this.y = ((int)l1);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  public final int b()
  {
    return this.z;
  }
  
  public final void b(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("timeout < 0");
    }
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("unit == null");
    }
    long l1 = paramTimeUnit.toMillis(paramLong);
    if (l1 > 2147483647L) {
      throw new IllegalArgumentException("Timeout too large.");
    }
    this.z = ((int)l1);
  }
  
  public final int c()
  {
    return this.A;
  }
  
  public final Proxy d()
  {
    return this.f;
  }
  
  public final ProxySelector e()
  {
    return this.k;
  }
  
  public final CookieHandler f()
  {
    return this.l;
  }
  
  final zT g()
  {
    return this.m;
  }
  
  public final SocketFactory h()
  {
    return this.o;
  }
  
  public final SSLSocketFactory i()
  {
    return this.p;
  }
  
  public final HostnameVerifier j()
  {
    return this.q;
  }
  
  public final za k()
  {
    return this.r;
  }
  
  public final yK l()
  {
    return this.s;
  }
  
  public final zg m()
  {
    return this.t;
  }
  
  public final boolean n()
  {
    return this.v;
  }
  
  public final boolean o()
  {
    return this.w;
  }
  
  public final boolean p()
  {
    return this.x;
  }
  
  final Ad q()
  {
    return this.d;
  }
  
  public final zm r()
  {
    return this.e;
  }
  
  public final List<zy> s()
  {
    return this.g;
  }
  
  public final List<zi> t()
  {
    return this.h;
  }
  
  public List<zr> u()
  {
    return this.i;
  }
  
  public List<zr> v()
  {
    return this.j;
  }
  
  final zu w()
  {
    zu localzu = new zu(this);
    if (localzu.k == null) {
      localzu.k = ProxySelector.getDefault();
    }
    if (localzu.l == null) {
      localzu.l = CookieHandler.getDefault();
    }
    if (localzu.o == null) {
      localzu.o = SocketFactory.getDefault();
    }
    if (localzu.p == null) {
      localzu.p = y();
    }
    if (localzu.q == null) {
      localzu.q = BK.a;
    }
    if (localzu.r == null) {
      localzu.r = za.a;
    }
    if (localzu.s == null) {
      localzu.s = Ah.a;
    }
    if (localzu.t == null) {
      localzu.t = zg.a();
    }
    if (localzu.g == null) {
      localzu.g = a;
    }
    if (localzu.h == null) {
      localzu.h = b;
    }
    if (localzu.u == null) {
      localzu.u = zV.a;
    }
    return localzu;
  }
  
  public final zu x()
  {
    try
    {
      zu localzu = (zu)super.clone();
      return localzu;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zu
 * JD-Core Version:    0.7.0.1
 */