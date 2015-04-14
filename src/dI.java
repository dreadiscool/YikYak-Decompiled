import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class dI
  extends sn<dG, dI>
  implements dJ
{
  private int a;
  private sA b = sz.a;
  private List<dQ> c = Collections.emptyList();
  private List<dC> d = Collections.emptyList();
  private List<dy> e = Collections.emptyList();
  private List<dy> f = Collections.emptyList();
  private List<dy> g = Collections.emptyList();
  private List<dK> h = Collections.emptyList();
  private Object i = "";
  private Object j = "";
  private Object k = "0";
  private Object l = "";
  private ds m = ds.a();
  private float n;
  private boolean o;
  private sA p = sz.a;
  private int q;
  
  private static dI q()
  {
    return new dI();
  }
  
  private void s()
  {
    if ((0x1 & this.a) != 1)
    {
      this.b = new sz(this.b);
      this.a = (0x1 | this.a);
    }
  }
  
  private void t()
  {
    if ((0x2 & this.a) != 2)
    {
      this.c = new ArrayList(this.c);
      this.a = (0x2 | this.a);
    }
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
    if ((0x20 & this.a) != 32)
    {
      this.g = new ArrayList(this.g);
      this.a = (0x20 | this.a);
    }
  }
  
  private void y()
  {
    if ((0x40 & this.a) != 64)
    {
      this.h = new ArrayList(this.h);
      this.a = (0x40 | this.a);
    }
  }
  
  private void z()
  {
    if ((0x4000 & this.a) != 16384)
    {
      this.p = new sz(this.p);
      this.a = (0x4000 | this.a);
    }
  }
  
  public dI a()
  {
    return q().a(d());
  }
  
  public dI a(float paramFloat)
  {
    this.a = (0x1000 | this.a);
    this.n = paramFloat;
    return this;
  }
  
  public dI a(dG paramdG)
  {
    if (paramdG == dG.a()) {
      return this;
    }
    if (!dG.b(paramdG).isEmpty())
    {
      if (this.b.isEmpty())
      {
        this.b = dG.b(paramdG);
        this.a = (0xFFFFFFFE & this.a);
      }
    }
    else
    {
      label52:
      if (!dG.c(paramdG).isEmpty())
      {
        if (!this.c.isEmpty()) {
          break label566;
        }
        this.c = dG.c(paramdG);
        this.a = (0xFFFFFFFD & this.a);
      }
      label95:
      if (!dG.d(paramdG).isEmpty())
      {
        if (!this.d.isEmpty()) {
          break label587;
        }
        this.d = dG.d(paramdG);
        this.a = (0xFFFFFFFB & this.a);
      }
      label138:
      if (!dG.e(paramdG).isEmpty())
      {
        if (!this.e.isEmpty()) {
          break label608;
        }
        this.e = dG.e(paramdG);
        this.a = (0xFFFFFFF7 & this.a);
      }
      label181:
      if (!dG.f(paramdG).isEmpty())
      {
        if (!this.f.isEmpty()) {
          break label629;
        }
        this.f = dG.f(paramdG);
        this.a = (0xFFFFFFEF & this.a);
      }
      label224:
      if (!dG.g(paramdG).isEmpty())
      {
        if (!this.g.isEmpty()) {
          break label650;
        }
        this.g = dG.g(paramdG);
        this.a = (0xFFFFFFDF & this.a);
      }
      label267:
      if (!dG.h(paramdG).isEmpty())
      {
        if (!this.h.isEmpty()) {
          break label671;
        }
        this.h = dG.h(paramdG);
        this.a = (0xFFFFFFBF & this.a);
      }
      label310:
      if (paramdG.v())
      {
        this.a = (0x80 | this.a);
        this.i = dG.i(paramdG);
      }
      if (paramdG.x())
      {
        this.a = (0x100 | this.a);
        this.j = dG.j(paramdG);
      }
      if (paramdG.z())
      {
        this.a = (0x200 | this.a);
        this.k = dG.k(paramdG);
      }
      if (paramdG.B())
      {
        this.a = (0x400 | this.a);
        this.l = dG.l(paramdG);
      }
      if (paramdG.D()) {
        a(paramdG.E());
      }
      if (paramdG.F()) {
        a(paramdG.G());
      }
      if (paramdG.H()) {
        a(paramdG.I());
      }
      if (!dG.m(paramdG).isEmpty())
      {
        if (!this.p.isEmpty()) {
          break label692;
        }
        this.p = dG.m(paramdG);
        this.a = (0xFFFFBFFF & this.a);
      }
    }
    for (;;)
    {
      if (paramdG.L()) {
        f(paramdG.M());
      }
      a(r().a(dG.n(paramdG)));
      break;
      s();
      this.b.addAll(dG.b(paramdG));
      break label52;
      label566:
      t();
      this.c.addAll(dG.c(paramdG));
      break label95;
      label587:
      u();
      this.d.addAll(dG.d(paramdG));
      break label138;
      label608:
      v();
      this.e.addAll(dG.e(paramdG));
      break label181;
      label629:
      w();
      this.f.addAll(dG.f(paramdG));
      break label224;
      label650:
      x();
      this.g.addAll(dG.g(paramdG));
      break label267;
      label671:
      y();
      this.h.addAll(dG.h(paramdG));
      break label310;
      label692:
      z();
      this.p.addAll(dG.m(paramdG));
    }
  }
  
  public dI a(ds paramds)
  {
    if (((0x800 & this.a) == 2048) && (this.m != ds.a())) {}
    for (this.m = ds.a(this.m).a(paramds).d();; this.m = paramds)
    {
      this.a = (0x800 | this.a);
      return this;
    }
  }
  
  public dI a(sc paramsc, sg paramsg)
  {
    try
    {
      dG localdG3 = (dG)dG.a.b(paramsc, paramsg);
      if (localdG3 != null) {
        a(localdG3);
      }
      return this;
    }
    catch (sx localsx)
    {
      dG localdG2 = (dG)localsx.a();
      Object localObject1;
      try
      {
        throw localsx;
      }
      finally
      {
        localdG1 = localdG2;
      }
      if (localdG1 != null) {
        a(localdG1);
      }
      throw localObject1;
    }
    finally
    {
      for (;;)
      {
        dG localdG1 = null;
      }
    }
  }
  
  public dI a(boolean paramBoolean)
  {
    this.a = (0x2000 | this.a);
    this.o = paramBoolean;
    return this;
  }
  
  public dQ a(int paramInt)
  {
    return (dQ)this.c.get(paramInt);
  }
  
  public dC b(int paramInt)
  {
    return (dC)this.d.get(paramInt);
  }
  
  public dG b()
  {
    return dG.a();
  }
  
  public dG c()
  {
    dG localdG = d();
    if (!localdG.j()) {
      throw a(localdG);
    }
    return localdG;
  }
  
  public dy c(int paramInt)
  {
    return (dy)this.e.get(paramInt);
  }
  
  public dG d()
  {
    int i1 = 1;
    dG localdG = new dG(this, null);
    int i2 = this.a;
    if ((0x1 & this.a) == i1)
    {
      this.b = new sY(this.b);
      this.a = (0xFFFFFFFE & this.a);
    }
    dG.a(localdG, this.b);
    if ((0x2 & this.a) == 2)
    {
      this.c = Collections.unmodifiableList(this.c);
      this.a = (0xFFFFFFFD & this.a);
    }
    dG.a(localdG, this.c);
    if ((0x4 & this.a) == 4)
    {
      this.d = Collections.unmodifiableList(this.d);
      this.a = (0xFFFFFFFB & this.a);
    }
    dG.b(localdG, this.d);
    if ((0x8 & this.a) == 8)
    {
      this.e = Collections.unmodifiableList(this.e);
      this.a = (0xFFFFFFF7 & this.a);
    }
    dG.c(localdG, this.e);
    if ((0x10 & this.a) == 16)
    {
      this.f = Collections.unmodifiableList(this.f);
      this.a = (0xFFFFFFEF & this.a);
    }
    dG.d(localdG, this.f);
    if ((0x20 & this.a) == 32)
    {
      this.g = Collections.unmodifiableList(this.g);
      this.a = (0xFFFFFFDF & this.a);
    }
    dG.e(localdG, this.g);
    if ((0x40 & this.a) == 64)
    {
      this.h = Collections.unmodifiableList(this.h);
      this.a = (0xFFFFFFBF & this.a);
    }
    dG.f(localdG, this.h);
    if ((i2 & 0x80) == 128) {}
    for (;;)
    {
      dG.a(localdG, this.i);
      if ((i2 & 0x100) == 256) {
        i1 |= 0x2;
      }
      dG.b(localdG, this.j);
      if ((i2 & 0x200) == 512) {
        i1 |= 0x4;
      }
      dG.c(localdG, this.k);
      if ((i2 & 0x400) == 1024) {
        i1 |= 0x8;
      }
      dG.d(localdG, this.l);
      if ((i2 & 0x800) == 2048) {
        i1 |= 0x10;
      }
      dG.a(localdG, this.m);
      if ((i2 & 0x1000) == 4096) {
        i1 |= 0x20;
      }
      dG.a(localdG, this.n);
      if ((i2 & 0x2000) == 8192) {
        i1 |= 0x40;
      }
      dG.a(localdG, this.o);
      if ((0x4000 & this.a) == 16384)
      {
        this.p = new sY(this.p);
        this.a = (0xFFFFBFFF & this.a);
      }
      dG.b(localdG, this.p);
      if ((i2 & 0x8000) == 32768) {
        i1 |= 0x80;
      }
      dG.a(localdG, this.q);
      dG.b(localdG, i1);
      return localdG;
      i1 = 0;
    }
  }
  
  public dy d(int paramInt)
  {
    return (dy)this.f.get(paramInt);
  }
  
  public dy e(int paramInt)
  {
    return (dy)this.g.get(paramInt);
  }
  
  public dI f(int paramInt)
  {
    this.a = (0x8000 | this.a);
    this.q = paramInt;
    return this;
  }
  
  public int i()
  {
    return this.c.size();
  }
  
  public final boolean j()
  {
    boolean bool = false;
    int i1 = 0;
    if (i1 < i()) {
      if (a(i1).j()) {}
    }
    for (;;)
    {
      return bool;
      i1++;
      break;
      for (int i2 = 0;; i2++)
      {
        if (i2 >= k()) {
          break label58;
        }
        if (!b(i2).j()) {
          break;
        }
      }
      label58:
      for (int i3 = 0;; i3++)
      {
        if (i3 >= l()) {
          break label88;
        }
        if (!c(i3).j()) {
          break;
        }
      }
      label88:
      for (int i4 = 0;; i4++)
      {
        if (i4 >= m()) {
          break label118;
        }
        if (!d(i4).j()) {
          break;
        }
      }
      label118:
      for (int i5 = 0;; i5++)
      {
        if (i5 >= n()) {
          break label148;
        }
        if (!e(i5).j()) {
          break;
        }
      }
      label148:
      bool = true;
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
    return this.g.size();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     dI
 * JD-Core Version:    0.7.0.1
 */