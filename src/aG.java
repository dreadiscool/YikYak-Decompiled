final class aG
  extends aE
{
  private final String a;
  private final String b;
  private final long c;
  
  public aG(bs parambs)
  {
    super(3, new aE[0]);
    this.a = parambs.a;
    this.b = parambs.b;
    this.c = parambs.c;
  }
  
  public int a()
  {
    return E.b(1, A.a(this.a)) + E.b(2, A.a(this.b)) + E.b(3, this.c);
  }
  
  public void a(E paramE)
  {
    paramE.a(1, A.a(this.a));
    paramE.a(2, A.a(this.b));
    paramE.a(3, this.c);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     aG
 * JD-Core Version:    0.7.0.1
 */