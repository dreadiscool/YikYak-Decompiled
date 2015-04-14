final class aD
  extends aE
{
  private final long a;
  private final String b;
  private final String c;
  private final long d;
  private final int e;
  
  public aD(bu parambu)
  {
    super(3, new aE[0]);
    this.a = parambu.a;
    this.b = parambu.b;
    this.c = parambu.c;
    this.d = parambu.d;
    this.e = parambu.e;
  }
  
  public int a()
  {
    return E.b(1, this.a) + E.b(2, A.a(this.b)) + E.b(3, A.a(this.c)) + E.b(4, this.d) + E.f(5, this.e);
  }
  
  public void a(E paramE)
  {
    paramE.a(1, this.a);
    paramE.a(2, A.a(this.b));
    paramE.a(3, A.a(this.c));
    paramE.a(4, this.d);
    paramE.b(5, this.e);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     aD
 * JD-Core Version:    0.7.0.1
 */