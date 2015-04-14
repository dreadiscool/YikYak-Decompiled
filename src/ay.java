final class ay
  extends aE
{
  private final long a;
  private final long b;
  private final String c;
  private final String d;
  
  public ay(bp parambp)
  {
    super(4, new aE[0]);
    this.a = parambp.a;
    this.b = parambp.b;
    this.c = parambp.c;
    this.d = parambp.d;
  }
  
  public int a()
  {
    int i = E.b(1, this.a);
    int j = E.b(2, this.b);
    int k = E.b(3, A.a(this.c));
    return E.b(4, A.a(this.d)) + (j + (i + k));
  }
  
  public void a(E paramE)
  {
    paramE.a(1, this.a);
    paramE.a(2, this.b);
    paramE.a(3, A.a(this.c));
    paramE.a(4, A.a(this.d));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ay
 * JD-Core Version:    0.7.0.1
 */