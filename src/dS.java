import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class dS
  extends so<dQ, dS>
  implements dX
{
  private int a;
  private dV b = dV.a;
  private Object c = "";
  private List<dQ> d = Collections.emptyList();
  private List<dQ> e = Collections.emptyList();
  private List<dQ> f = Collections.emptyList();
  private Object g = "";
  private Object h = "";
  private long i;
  private boolean j;
  private List<dQ> k = Collections.emptyList();
  private List<dT> l = Collections.emptyList();
  private boolean m;
  
  private static dS t()
  {
    return new dS();
  }
  
  private void u()
  {
    if ((0x4 & this.a) != 4)
    {
      this.d = new ArrayList(this.d);
      this.a = (0x4 | this.a);
    }
  }
  
  private void v()
  {
    if ((0x8 & this.a) != 8)
    {
      this.e = new ArrayList(this.e);
      this.a = (0x8 | this.a);
    }
  }
  
  private void w()
  {
    if ((0x10 & this.a) != 16)
    {
      this.f = new ArrayList(this.f);
      this.a = (0x10 | this.a);
    }
  }
  
  private void x()
  {
    if ((0x200 & this.a) != 512)
    {
      this.k = new ArrayList(this.k);
      this.a = (0x200 | this.a);
    }
  }
  
  private void y()
  {
    if ((0x400 & this.a) != 1024)
    {
      this.l = new ArrayList(this.l);
      this.a = (0x400 | this.a);
    }
  }
  
  public dQ a(int paramInt)
  {
    return (dQ)this.d.get(paramInt);
  }
  
  public dS a()
  {
    return t().a(d());
  }
  
  public dS a(long paramLong)
  {
    this.a = (0x80 | this.a);
    this.i = paramLong;
    return this;
  }
  
  public dS a(dQ paramdQ)
  {
    if (paramdQ == dQ.a()) {
      return this;
    }
    if (paramdQ.d()) {
      a(paramdQ.e());
    }
    if (paramdQ.f())
    {
      this.a = (0x2 | this.a);
      this.c = dQ.b(paramdQ);
    }
    if (!dQ.c(paramdQ).isEmpty())
    {
      if (this.d.isEmpty())
      {
        this.d = dQ.c(paramdQ);
        this.a = (0xFFFFFFFB & this.a);
      }
    }
    else
    {
      label93:
      if (!dQ.d(paramdQ).isEmpty())
      {
        if (!this.e.isEmpty()) {
          break label412;
        }
        this.e = dQ.d(paramdQ);
        this.a = (0xFFFFFFF7 & this.a);
      }
      label136:
      if (!dQ.e(paramdQ).isEmpty())
      {
        if (!this.f.isEmpty()) {
          break label433;
        }
        this.f = dQ.e(paramdQ);
        this.a = (0xFFFFFFEF & this.a);
      }
      label179:
      if (paramdQ.r())
      {
        this.a = (0x20 | this.a);
        this.g = dQ.f(paramdQ);
      }
      if (paramdQ.t())
      {
        this.a = (0x40 | this.a);
        this.h = dQ.g(paramdQ);
      }
      if (paramdQ.v()) {
        a(paramdQ.w());
      }
      if (paramdQ.x()) {
        a(paramdQ.y());
      }
      if (!dQ.h(paramdQ).isEmpty())
      {
        if (!this.k.isEmpty()) {
          break label454;
        }
        this.k = dQ.h(paramdQ);
        this.a = (0xFFFFFDFF & this.a);
      }
      label307:
      if (!dQ.i(paramdQ).isEmpty())
      {
        if (!this.l.isEmpty()) {
          break label475;
        }
        this.l = dQ.i(paramdQ);
        this.a = (0xFFFFFBFF & this.a);
      }
    }
    for (;;)
    {
      if (paramdQ.D()) {
        b(paramdQ.E());
      }
      a(paramdQ);
      a(r().a(dQ.j(paramdQ)));
      break;
      u();
      this.d.addAll(dQ.c(paramdQ));
      break label93;
      label412:
      v();
      this.e.addAll(dQ.d(paramdQ));
      break label136;
      label433:
      w();
      this.f.addAll(dQ.e(paramdQ));
      break label179;
      label454:
      x();
      this.k.addAll(dQ.h(paramdQ));
      break label307;
      label475:
      y();
      this.l.addAll(dQ.i(paramdQ));
    }
  }
  
  public dS a(dV paramdV)
  {
    if (paramdV == null) {
      throw new NullPointerException();
    }
    this.a = (0x1 | this.a);
    this.b = paramdV;
    return this;
  }
  
  public dS a(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.a = (0x2 | this.a);
    this.c = paramString;
    return this;
  }
  
  public dS a(sc paramsc, sg paramsg)
  {
    try
    {
      dQ localdQ3 = (dQ)dQ.a.b(paramsc, paramsg);
      if (localdQ3 != null) {
        a(localdQ3);
      }
      return this;
    }
    catch (sx localsx)
    {
      dQ localdQ2 = (dQ)localsx.a();
      Object localObject1;
      try
      {
        throw localsx;
      }
      finally
      {
        localdQ1 = localdQ2;
      }
      if (localdQ1 != null) {
        a(localdQ1);
      }
      throw localObject1;
    }
    finally
    {
      for (;;)
      {
        dQ localdQ1 = null;
      }
    }
  }
  
  public dS a(boolean paramBoolean)
  {
    this.a = (0x100 | this.a);
    this.j = paramBoolean;
    return this;
  }
  
  public dQ b()
  {
    return dQ.a();
  }
  
  public dQ b(int paramInt)
  {
    return (dQ)this.e.get(paramInt);
  }
  
  public dS b(dQ paramdQ)
  {
    if (paramdQ == null) {
      throw new NullPointerException();
    }
    u();
    this.d.add(paramdQ);
    return this;
  }
  
  public dS b(boolean paramBoolean)
  {
    this.a = (0x800 | this.a);
    this.m = paramBoolean;
    return this;
  }
  
  public dQ c()
  {
    dQ localdQ = d();
    if (!localdQ.j()) {
      throw a(localdQ);
    }
    return localdQ;
  }
  
  public dQ c(int paramInt)
  {
    return (dQ)this.f.get(paramInt);
  }
  
  public dS c(dQ paramdQ)
  {
    if (paramdQ == null) {
      throw new NullPointerException();
    }
    v();
    this.e.add(paramdQ);
    return this;
  }
  
  public dQ d()
  {
    int n = 1;
    dQ localdQ = new dQ(this, null);
    int i1 = this.a;
    if ((i1 & 0x1) == n) {}
    for (;;)
    {
      dQ.a(localdQ, this.b);
      if ((i1 & 0x2) == 2) {
        n |= 0x2;
      }
      dQ.a(localdQ, this.c);
      if ((0x4 & this.a) == 4)
      {
        this.d = Collections.unmodifiableList(this.d);
        this.a = (0xFFFFFFFB & this.a);
      }
      dQ.a(localdQ, this.d);
      if ((0x8 & this.a) == 8)
      {
        this.e = Collections.unmodifiableList(this.e);
        this.a = (0xFFFFFFF7 & this.a);
      }
      dQ.b(localdQ, this.e);
      if ((0x10 & this.a) == 16)
      {
        this.f = Collections.unmodifiableList(this.f);
        this.a = (0xFFFFFFEF & this.a);
      }
      dQ.c(localdQ, this.f);
      if ((i1 & 0x20) == 32) {
        n |= 0x4;
      }
      dQ.b(localdQ, this.g);
      if ((i1 & 0x40) == 64) {
        n |= 0x8;
      }
      dQ.c(localdQ, this.h);
      if ((i1 & 0x80) == 128) {
        n |= 0x10;
      }
      dQ.a(localdQ, this.i);
      if ((i1 & 0x100) == 256) {
        n |= 0x20;
      }
      dQ.a(localdQ, this.j);
      if ((0x200 & this.a) == 512)
      {
        this.k = Collections.unmodifiableList(this.k);
        this.a = (0xFFFFFDFF & this.a);
      }
      dQ.d(localdQ, this.k);
      if ((0x400 & this.a) == 1024)
      {
        this.l = Collections.unmodifiableList(this.l);
        this.a = (0xFFFFFBFF & this.a);
      }
      dQ.e(localdQ, this.l);
      if ((i1 & 0x800) == 2048) {
        n |= 0x40;
      }
      dQ.b(localdQ, this.m);
      dQ.a(localdQ, n);
      return localdQ;
      n = 0;
    }
  }
  
  public dQ d(int paramInt)
  {
    return (dQ)this.k.get(paramInt);
  }
  
  public dS d(dQ paramdQ)
  {
    if (paramdQ == null) {
      throw new NullPointerException();
    }
    w();
    this.f.add(paramdQ);
    return this;
  }
  
  public boolean i()
  {
    int n = 1;
    if ((0x1 & this.a) == n) {}
    for (;;)
    {
      return n;
      int i1 = 0;
    }
  }
  
  public final boolean j()
  {
    boolean bool = false;
    if (!i()) {}
    for (;;)
    {
      return bool;
      for (int n = 0;; n++)
      {
        if (n >= k()) {
          break label38;
        }
        if (!a(n).j()) {
          break;
        }
      }
      label38:
      for (int i1 = 0;; i1++)
      {
        if (i1 >= l()) {
          break label65;
        }
        if (!b(i1).j()) {
          break;
        }
      }
      label65:
      for (int i2 = 0;; i2++)
      {
        if (i2 >= m()) {
          break label95;
        }
        if (!c(i2).j()) {
          break;
        }
      }
      label95:
      for (int i3 = 0;; i3++)
      {
        if (i3 >= n()) {
          break label125;
        }
        if (!d(i3).j()) {
          break;
        }
      }
      label125:
      if (s()) {
        bool = true;
      }
    }
  }
  
  public int k()
  {
    return this.d.size();
  }
  
  public int l()
  {
    return this.e.size();
  }
  
  public int m()
  {
    return this.f.size();
  }
  
  public int n()
  {
    return this.k.size();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     dS
 * JD-Core Version:    0.7.0.1
 */