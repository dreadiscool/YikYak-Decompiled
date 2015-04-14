import java.net.ProtocolException;

public final class AH
  implements LU
{
  private boolean a;
  private final int b;
  private final Lz c = new Lz();
  
  public AH()
  {
    this(-1);
  }
  
  public AH(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a() {}
  
  public void a(LU paramLU)
  {
    Lz localLz = this.c.t();
    paramLU.a_(localLz, localLz.c());
  }
  
  public void a_(Lz paramLz, long paramLong)
  {
    if (this.a) {
      throw new IllegalStateException("closed");
    }
    Ae.a(paramLz.c(), 0L, paramLong);
    if ((this.b != -1) && (this.c.c() > this.b - paramLong)) {
      throw new ProtocolException("exceeded content-length limit of " + this.b + " bytes");
    }
    this.c.a_(paramLz, paramLong);
  }
  
  public LW b()
  {
    return LW.b;
  }
  
  public long c()
  {
    return this.c.c();
  }
  
  public void close()
  {
    if (this.a) {}
    do
    {
      return;
      this.a = true;
    } while (this.c.c() >= this.b);
    throw new ProtocolException("content-length promised " + this.b + " bytes, but received " + this.c.c());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     AH
 * JD-Core Version:    0.7.0.1
 */