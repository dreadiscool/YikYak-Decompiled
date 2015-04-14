public final class du
  extends sn<ds, du>
  implements dx
{
  private int a;
  private dv b = dv.a;
  private int c;
  private int d;
  
  private static du k()
  {
    return new du();
  }
  
  public du a()
  {
    return k().a(d());
  }
  
  public du a(int paramInt)
  {
    this.a = (0x2 | this.a);
    this.c = paramInt;
    return this;
  }
  
  public du a(ds paramds)
  {
    if (paramds == ds.a()) {}
    for (;;)
    {
      return this;
      if (paramds.d()) {
        a(paramds.e());
      }
      if (paramds.f()) {
        a(paramds.g());
      }
      if (paramds.h()) {
        b(paramds.i());
      }
      a(r().a(ds.b(paramds)));
    }
  }
  
  public du a(dv paramdv)
  {
    if (paramdv == null) {
      throw new NullPointerException();
    }
    this.a = (0x1 | this.a);
    this.b = paramdv;
    return this;
  }
  
  public du a(sc paramsc, sg paramsg)
  {
    try
    {
      ds localds3 = (ds)ds.a.b(paramsc, paramsg);
      if (localds3 != null) {
        a(localds3);
      }
      return this;
    }
    catch (sx localsx)
    {
      ds localds2 = (ds)localsx.a();
      Object localObject1;
      try
      {
        throw localsx;
      }
      finally
      {
        localds1 = localds2;
      }
      if (localds1 != null) {
        a(localds1);
      }
      throw localObject1;
    }
    finally
    {
      for (;;)
      {
        ds localds1 = null;
      }
    }
  }
  
  public ds b()
  {
    return ds.a();
  }
  
  public du b(int paramInt)
  {
    this.a = (0x4 | this.a);
    this.d = paramInt;
    return this;
  }
  
  public ds c()
  {
    ds localds = d();
    if (!localds.j()) {
      throw a(localds);
    }
    return localds;
  }
  
  public ds d()
  {
    int i = 1;
    ds localds = new ds(this, null);
    int j = this.a;
    if ((j & 0x1) == i) {}
    for (;;)
    {
      ds.a(localds, this.b);
      if ((j & 0x2) == 2) {
        i |= 0x2;
      }
      ds.a(localds, this.c);
      if ((j & 0x4) == 4) {
        i |= 0x4;
      }
      ds.b(localds, this.d);
      ds.c(localds, i);
      return localds;
      i = 0;
    }
  }
  
  public final boolean j()
  {
    return true;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     du
 * JD-Core Version:    0.7.0.1
 */