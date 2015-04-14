class yP
  extends zI
{
  private final zR a;
  private final LD b;
  private final String c;
  private final String d;
  
  public yP(zR paramzR, String paramString1, String paramString2)
  {
    this.a = paramzR;
    this.c = paramString1;
    this.d = paramString2;
    this.b = LK.a(new yQ(this, paramzR.a(1), paramzR));
  }
  
  public zt a()
  {
    if (this.c != null) {}
    for (zt localzt = zt.a(this.c);; localzt = null) {
      return localzt;
    }
  }
  
  public long b()
  {
    long l1 = -1L;
    try
    {
      if (this.d != null)
      {
        long l2 = Long.parseLong(this.d);
        l1 = l2;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label23:
      break label23;
    }
    return l1;
  }
  
  public LD c()
  {
    return this.b;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     yP
 * JD-Core Version:    0.7.0.1
 */