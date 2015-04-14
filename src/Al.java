import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Al
{
  final long a;
  final zz b;
  final zF c;
  private Date d;
  private String e;
  private Date f;
  private String g;
  private Date h;
  private long i;
  private long j;
  private String k;
  private int l = -1;
  
  public Al(long paramLong, zz paramzz, zF paramzF)
  {
    this.a = paramLong;
    this.b = paramzz;
    this.c = paramzF;
    if (paramzF != null)
    {
      zo localzo = paramzF.g();
      int m = 0;
      int n = localzo.a();
      if (m < n)
      {
        String str1 = localzo.a(m);
        String str2 = localzo.b(m);
        if ("Date".equalsIgnoreCase(str1))
        {
          this.d = Av.a(str2);
          this.e = str2;
        }
        for (;;)
        {
          m++;
          break;
          if ("Expires".equalsIgnoreCase(str1))
          {
            this.h = Av.a(str2);
          }
          else if ("Last-Modified".equalsIgnoreCase(str1))
          {
            this.f = Av.a(str2);
            this.g = str2;
          }
          else if ("ETag".equalsIgnoreCase(str1))
          {
            this.k = str2;
          }
          else if ("Age".equalsIgnoreCase(str1))
          {
            this.l = Am.b(str2, -1);
          }
          else if (AD.b.equalsIgnoreCase(str1))
          {
            this.i = Long.parseLong(str2);
          }
          else if (AD.c.equalsIgnoreCase(str1))
          {
            this.j = Long.parseLong(str2);
          }
        }
      }
    }
  }
  
  private static boolean a(zz paramzz)
  {
    if ((paramzz.a("If-Modified-Since") != null) || (paramzz.a("If-None-Match") != null)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private Aj b()
  {
    long l1 = 0L;
    Aj localAj;
    if (this.c == null) {
      localAj = new Aj(this.b, null, null);
    }
    yS localyS1;
    for (;;)
    {
      return localAj;
      if ((this.b.i()) && (this.c.f() == null))
      {
        localAj = new Aj(this.b, null, null);
      }
      else if (!Aj.a(this.c, this.b))
      {
        localAj = new Aj(this.b, null, null);
      }
      else
      {
        localyS1 = this.b.h();
        if ((!localyS1.a()) && (!a(this.b))) {
          break;
        }
        localAj = new Aj(this.b, null, null);
      }
    }
    long l2 = d();
    long l3 = c();
    if (localyS1.c() != -1) {
      l3 = Math.min(l3, TimeUnit.SECONDS.toMillis(localyS1.c()));
    }
    if (localyS1.h() != -1) {}
    for (long l4 = TimeUnit.SECONDS.toMillis(localyS1.h());; l4 = l1)
    {
      yS localyS2 = this.c.m();
      if ((!localyS2.f()) && (localyS1.g() != -1)) {
        l1 = TimeUnit.SECONDS.toMillis(localyS1.g());
      }
      if ((!localyS2.a()) && (l2 + l4 < l1 + l3))
      {
        zH localzH = this.c.i();
        if (l4 + l2 >= l3) {
          localzH.b("Warning", "110 HttpURLConnection \"Response is stale\"");
        }
        if ((l2 > 86400000L) && (e())) {
          localzH.b("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
        }
        localAj = new Aj(null, localzH.a(), null);
        break;
      }
      zB localzB = this.b.g();
      if (this.f != null) {
        localzB.a("If-Modified-Since", this.g);
      }
      zz localzz;
      for (;;)
      {
        if (this.k != null) {
          localzB.a("If-None-Match", this.k);
        }
        localzz = localzB.b();
        if (!a(localzz)) {
          break label439;
        }
        localAj = new Aj(localzz, this.c, null);
        break;
        if (this.d != null) {
          localzB.a("If-Modified-Since", this.e);
        }
      }
      label439:
      localAj = new Aj(localzz, null, null);
      break;
    }
  }
  
  private long c()
  {
    long l1 = 0L;
    yS localyS = this.c.m();
    if (localyS.c() != -1) {
      l1 = TimeUnit.SECONDS.toMillis(localyS.c());
    }
    label56:
    label90:
    do
    {
      return l1;
      if (this.h != null)
      {
        long l4;
        long l5;
        if (this.d != null)
        {
          l4 = this.d.getTime();
          l5 = this.h.getTime() - l4;
          if (l5 <= l1) {
            break label90;
          }
        }
        for (;;)
        {
          l1 = l5;
          break;
          l4 = this.j;
          break label56;
          l5 = l1;
        }
      }
    } while ((this.f == null) || (this.c.a().a().getQuery() != null));
    if (this.d != null) {}
    for (long l2 = this.d.getTime();; l2 = this.i)
    {
      long l3 = l2 - this.f.getTime();
      if (l3 <= l1) {
        break;
      }
      l1 = l3 / 10L;
      break;
    }
  }
  
  private long d()
  {
    long l1 = 0L;
    if (this.d != null) {
      l1 = Math.max(l1, this.j - this.d.getTime());
    }
    if (this.l != -1) {
      l1 = Math.max(l1, TimeUnit.SECONDS.toMillis(this.l));
    }
    long l2 = this.j - this.i;
    return this.a - this.j + (l1 + l2);
  }
  
  private boolean e()
  {
    if ((this.c.m().c() == -1) && (this.h == null)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public Aj a()
  {
    Aj localAj = b();
    if ((localAj.a != null) && (this.b.h().i())) {
      localAj = new Aj(null, null, null);
    }
    return localAj;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Al
 * JD-Core Version:    0.7.0.1
 */