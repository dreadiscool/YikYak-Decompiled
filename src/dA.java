import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class dA
  extends sn<dy, dA>
  implements dB
{
  private int a;
  private List<Integer> b = Collections.emptyList();
  private int c;
  private int d;
  private boolean e;
  private boolean f;
  
  private static dA l()
  {
    return new dA();
  }
  
  private void m()
  {
    if ((0x1 & this.a) != 1)
    {
      this.b = new ArrayList(this.b);
      this.a = (0x1 | this.a);
    }
  }
  
  public dA a()
  {
    return l().a(d());
  }
  
  public dA a(int paramInt)
  {
    this.a = (0x2 | this.a);
    this.c = paramInt;
    return this;
  }
  
  public dA a(dy paramdy)
  {
    if (paramdy == dy.a()) {
      return this;
    }
    if (!dy.b(paramdy).isEmpty())
    {
      if (!this.b.isEmpty()) {
        break label135;
      }
      this.b = dy.b(paramdy);
      this.a = (0xFFFFFFFE & this.a);
    }
    for (;;)
    {
      if (paramdy.f()) {
        a(paramdy.g());
      }
      if (paramdy.h()) {
        b(paramdy.i());
      }
      if (paramdy.k()) {
        a(paramdy.l());
      }
      if (paramdy.m()) {
        b(paramdy.q());
      }
      a(r().a(dy.c(paramdy)));
      break;
      label135:
      m();
      this.b.addAll(dy.b(paramdy));
    }
  }
  
  public dA a(sc paramsc, sg paramsg)
  {
    try
    {
      dy localdy3 = (dy)dy.a.b(paramsc, paramsg);
      if (localdy3 != null) {
        a(localdy3);
      }
      return this;
    }
    catch (sx localsx)
    {
      dy localdy2 = (dy)localsx.a();
      Object localObject1;
      try
      {
        throw localsx;
      }
      finally
      {
        localdy1 = localdy2;
      }
      if (localdy1 != null) {
        a(localdy1);
      }
      throw localObject1;
    }
    finally
    {
      for (;;)
      {
        dy localdy1 = null;
      }
    }
  }
  
  public dA a(boolean paramBoolean)
  {
    this.a = (0x8 | this.a);
    this.e = paramBoolean;
    return this;
  }
  
  public dA b(int paramInt)
  {
    this.a = (0x4 | this.a);
    this.d = paramInt;
    return this;
  }
  
  public dA b(boolean paramBoolean)
  {
    this.a = (0x10 | this.a);
    this.f = paramBoolean;
    return this;
  }
  
  public dy b()
  {
    return dy.a();
  }
  
  public dy c()
  {
    dy localdy = d();
    if (!localdy.j()) {
      throw a(localdy);
    }
    return localdy;
  }
  
  public dy d()
  {
    int i = 1;
    dy localdy = new dy(this, null);
    int j = this.a;
    if ((0x1 & this.a) == i)
    {
      this.b = Collections.unmodifiableList(this.b);
      this.a = (0xFFFFFFFE & this.a);
    }
    dy.a(localdy, this.b);
    if ((j & 0x2) == 2) {}
    for (;;)
    {
      dy.a(localdy, this.c);
      if ((j & 0x4) == 4) {
        i |= 0x2;
      }
      dy.b(localdy, this.d);
      if ((j & 0x8) == 8) {
        i |= 0x4;
      }
      dy.a(localdy, this.e);
      if ((j & 0x10) == 16) {
        i |= 0x8;
      }
      dy.b(localdy, this.f);
      dy.c(localdy, i);
      return localdy;
      i = 0;
    }
  }
  
  public boolean i()
  {
    if ((0x2 & this.a) == 2) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean j()
  {
    if (!i()) {}
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     dA
 * JD-Core Version:    0.7.0.1
 */