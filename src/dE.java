public final class dE
  extends sn<dC, dE>
  implements dF
{
  private int a;
  private int b;
  private int c;
  
  private static dE m()
  {
    return new dE();
  }
  
  public dE a()
  {
    return m().a(d());
  }
  
  public dE a(int paramInt)
  {
    this.a = (0x1 | this.a);
    this.b = paramInt;
    return this;
  }
  
  public dE a(dC paramdC)
  {
    if (paramdC == dC.a()) {}
    for (;;)
    {
      return this;
      if (paramdC.d()) {
        a(paramdC.e());
      }
      if (paramdC.f()) {
        b(paramdC.g());
      }
      a(r().a(dC.b(paramdC)));
    }
  }
  
  public dE a(sc paramsc, sg paramsg)
  {
    try
    {
      dC localdC3 = (dC)dC.a.b(paramsc, paramsg);
      if (localdC3 != null) {
        a(localdC3);
      }
      return this;
    }
    catch (sx localsx)
    {
      dC localdC2 = (dC)localsx.a();
      Object localObject1;
      try
      {
        throw localsx;
      }
      finally
      {
        localdC1 = localdC2;
      }
      if (localdC1 != null) {
        a(localdC1);
      }
      throw localObject1;
    }
    finally
    {
      for (;;)
      {
        dC localdC1 = null;
      }
    }
  }
  
  public dC b()
  {
    return dC.a();
  }
  
  public dE b(int paramInt)
  {
    this.a = (0x2 | this.a);
    this.c = paramInt;
    return this;
  }
  
  public dC c()
  {
    dC localdC = d();
    if (!localdC.j()) {
      throw a(localdC);
    }
    return localdC;
  }
  
  public dC d()
  {
    int i = 1;
    dC localdC = new dC(this, null);
    int j = this.a;
    if ((j & 0x1) == i) {}
    for (;;)
    {
      dC.a(localdC, this.b);
      if ((j & 0x2) == 2) {
        i |= 0x2;
      }
      dC.b(localdC, this.c);
      dC.c(localdC, i);
      return localdC;
      i = 0;
    }
  }
  
  public boolean i()
  {
    int i = 1;
    if ((0x1 & this.a) == i) {}
    for (;;)
    {
      return i;
      int j = 0;
    }
  }
  
  public final boolean j()
  {
    boolean bool = false;
    if (!i()) {}
    for (;;)
    {
      return bool;
      if (k()) {
        bool = true;
      }
    }
  }
  
  public boolean k()
  {
    if ((0x2 & this.a) == 2) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     dE
 * JD-Core Version:    0.7.0.1
 */