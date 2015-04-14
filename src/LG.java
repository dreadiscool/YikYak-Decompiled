public abstract class LG
  implements LU
{
  private final LU a;
  
  public LG(LU paramLU)
  {
    if (paramLU == null) {
      throw new IllegalArgumentException("delegate == null");
    }
    this.a = paramLU;
  }
  
  public void a()
  {
    this.a.a();
  }
  
  public void a_(Lz paramLz, long paramLong)
  {
    this.a.a_(paramLz, paramLong);
  }
  
  public LW b()
  {
    return this.a.b();
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + "(" + this.a.toString() + ")";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     LG
 * JD-Core Version:    0.7.0.1
 */