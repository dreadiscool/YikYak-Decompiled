import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class dM
  extends sn<dK, dM>
  implements dN
{
  private int a;
  private List<Integer> b = Collections.emptyList();
  private List<Integer> c = Collections.emptyList();
  private List<Integer> d = Collections.emptyList();
  private List<Integer> e = Collections.emptyList();
  private List<Integer> f = Collections.emptyList();
  private List<Integer> g = Collections.emptyList();
  private List<Integer> h = Collections.emptyList();
  private List<Integer> i = Collections.emptyList();
  private List<Integer> j = Collections.emptyList();
  private List<Integer> k = Collections.emptyList();
  
  private static dM k()
  {
    return new dM();
  }
  
  private void l()
  {
    if ((0x1 & this.a) != 1)
    {
      this.b = new ArrayList(this.b);
      this.a = (0x1 | this.a);
    }
  }
  
  private void m()
  {
    if ((0x2 & this.a) != 2)
    {
      this.c = new ArrayList(this.c);
      this.a = (0x2 | this.a);
    }
  }
  
  private void n()
  {
    if ((0x4 & this.a) != 4)
    {
      this.d = new ArrayList(this.d);
      this.a = (0x4 | this.a);
    }
  }
  
  private void o()
  {
    if ((0x8 & this.a) != 8)
    {
      this.e = new ArrayList(this.e);
      this.a = (0x8 | this.a);
    }
  }
  
  private void q()
  {
    if ((0x10 & this.a) != 16)
    {
      this.f = new ArrayList(this.f);
      this.a = (0x10 | this.a);
    }
  }
  
  private void s()
  {
    if ((0x20 & this.a) != 32)
    {
      this.g = new ArrayList(this.g);
      this.a = (0x20 | this.a);
    }
  }
  
  private void t()
  {
    if ((0x40 & this.a) != 64)
    {
      this.h = new ArrayList(this.h);
      this.a = (0x40 | this.a);
    }
  }
  
  private void u()
  {
    if ((0x80 & this.a) != 128)
    {
      this.i = new ArrayList(this.i);
      this.a = (0x80 | this.a);
    }
  }
  
  private void v()
  {
    if ((0x100 & this.a) != 256)
    {
      this.j = new ArrayList(this.j);
      this.a = (0x100 | this.a);
    }
  }
  
  private void w()
  {
    if ((0x200 & this.a) != 512)
    {
      this.k = new ArrayList(this.k);
      this.a = (0x200 | this.a);
    }
  }
  
  public dM a()
  {
    return k().a(d());
  }
  
  public dM a(dK paramdK)
  {
    if (paramdK == dK.a()) {
      return this;
    }
    if (!dK.b(paramdK).isEmpty())
    {
      if (this.b.isEmpty())
      {
        this.b = dK.b(paramdK);
        this.a = (0xFFFFFFFE & this.a);
      }
    }
    else
    {
      label52:
      if (!dK.c(paramdK).isEmpty())
      {
        if (!this.c.isEmpty()) {
          break label482;
        }
        this.c = dK.c(paramdK);
        this.a = (0xFFFFFFFD & this.a);
      }
      label95:
      if (!dK.d(paramdK).isEmpty())
      {
        if (!this.d.isEmpty()) {
          break label503;
        }
        this.d = dK.d(paramdK);
        this.a = (0xFFFFFFFB & this.a);
      }
      label138:
      if (!dK.e(paramdK).isEmpty())
      {
        if (!this.e.isEmpty()) {
          break label524;
        }
        this.e = dK.e(paramdK);
        this.a = (0xFFFFFFF7 & this.a);
      }
      label181:
      if (!dK.f(paramdK).isEmpty())
      {
        if (!this.f.isEmpty()) {
          break label545;
        }
        this.f = dK.f(paramdK);
        this.a = (0xFFFFFFEF & this.a);
      }
      label224:
      if (!dK.g(paramdK).isEmpty())
      {
        if (!this.g.isEmpty()) {
          break label566;
        }
        this.g = dK.g(paramdK);
        this.a = (0xFFFFFFDF & this.a);
      }
      label267:
      if (!dK.h(paramdK).isEmpty())
      {
        if (!this.h.isEmpty()) {
          break label587;
        }
        this.h = dK.h(paramdK);
        this.a = (0xFFFFFFBF & this.a);
      }
      label310:
      if (!dK.i(paramdK).isEmpty())
      {
        if (!this.i.isEmpty()) {
          break label608;
        }
        this.i = dK.i(paramdK);
        this.a = (0xFFFFFF7F & this.a);
      }
      label354:
      if (!dK.j(paramdK).isEmpty())
      {
        if (!this.j.isEmpty()) {
          break label629;
        }
        this.j = dK.j(paramdK);
        this.a = (0xFFFFFEFF & this.a);
      }
      label398:
      if (!dK.k(paramdK).isEmpty())
      {
        if (!this.k.isEmpty()) {
          break label650;
        }
        this.k = dK.k(paramdK);
        this.a = (0xFFFFFDFF & this.a);
      }
    }
    for (;;)
    {
      a(r().a(dK.l(paramdK)));
      break;
      l();
      this.b.addAll(dK.b(paramdK));
      break label52;
      label482:
      m();
      this.c.addAll(dK.c(paramdK));
      break label95;
      label503:
      n();
      this.d.addAll(dK.d(paramdK));
      break label138;
      label524:
      o();
      this.e.addAll(dK.e(paramdK));
      break label181;
      label545:
      q();
      this.f.addAll(dK.f(paramdK));
      break label224;
      label566:
      s();
      this.g.addAll(dK.g(paramdK));
      break label267;
      label587:
      t();
      this.h.addAll(dK.h(paramdK));
      break label310;
      label608:
      u();
      this.i.addAll(dK.i(paramdK));
      break label354;
      label629:
      v();
      this.j.addAll(dK.j(paramdK));
      break label398;
      label650:
      w();
      this.k.addAll(dK.k(paramdK));
    }
  }
  
  public dM a(sc paramsc, sg paramsg)
  {
    try
    {
      dK localdK3 = (dK)dK.a.b(paramsc, paramsg);
      if (localdK3 != null) {
        a(localdK3);
      }
      return this;
    }
    catch (sx localsx)
    {
      dK localdK2 = (dK)localsx.a();
      Object localObject1;
      try
      {
        throw localsx;
      }
      finally
      {
        localdK1 = localdK2;
      }
      if (localdK1 != null) {
        a(localdK1);
      }
      throw localObject1;
    }
    finally
    {
      for (;;)
      {
        dK localdK1 = null;
      }
    }
  }
  
  public dK b()
  {
    return dK.a();
  }
  
  public dK c()
  {
    dK localdK = d();
    if (!localdK.j()) {
      throw a(localdK);
    }
    return localdK;
  }
  
  public dK d()
  {
    dK localdK = new dK(this, null);
    if ((0x1 & this.a) == 1)
    {
      this.b = Collections.unmodifiableList(this.b);
      this.a = (0xFFFFFFFE & this.a);
    }
    dK.a(localdK, this.b);
    if ((0x2 & this.a) == 2)
    {
      this.c = Collections.unmodifiableList(this.c);
      this.a = (0xFFFFFFFD & this.a);
    }
    dK.b(localdK, this.c);
    if ((0x4 & this.a) == 4)
    {
      this.d = Collections.unmodifiableList(this.d);
      this.a = (0xFFFFFFFB & this.a);
    }
    dK.c(localdK, this.d);
    if ((0x8 & this.a) == 8)
    {
      this.e = Collections.unmodifiableList(this.e);
      this.a = (0xFFFFFFF7 & this.a);
    }
    dK.d(localdK, this.e);
    if ((0x10 & this.a) == 16)
    {
      this.f = Collections.unmodifiableList(this.f);
      this.a = (0xFFFFFFEF & this.a);
    }
    dK.e(localdK, this.f);
    if ((0x20 & this.a) == 32)
    {
      this.g = Collections.unmodifiableList(this.g);
      this.a = (0xFFFFFFDF & this.a);
    }
    dK.f(localdK, this.g);
    if ((0x40 & this.a) == 64)
    {
      this.h = Collections.unmodifiableList(this.h);
      this.a = (0xFFFFFFBF & this.a);
    }
    dK.g(localdK, this.h);
    if ((0x80 & this.a) == 128)
    {
      this.i = Collections.unmodifiableList(this.i);
      this.a = (0xFFFFFF7F & this.a);
    }
    dK.h(localdK, this.i);
    if ((0x100 & this.a) == 256)
    {
      this.j = Collections.unmodifiableList(this.j);
      this.a = (0xFFFFFEFF & this.a);
    }
    dK.i(localdK, this.j);
    if ((0x200 & this.a) == 512)
    {
      this.k = Collections.unmodifiableList(this.k);
      this.a = (0xFFFFFDFF & this.a);
    }
    dK.j(localdK, this.k);
    return localdK;
  }
  
  public final boolean j()
  {
    return true;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     dM
 * JD-Core Version:    0.7.0.1
 */