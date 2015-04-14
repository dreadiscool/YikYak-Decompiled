import java.net.ProtocolException;

final class As
  implements LU
{
  private boolean b;
  private long c;
  
  private As(An paramAn, long paramLong)
  {
    this.c = paramLong;
  }
  
  public void a()
  {
    if (this.b) {}
    for (;;)
    {
      return;
      An.a(this.a).a();
    }
  }
  
  public void a_(Lz paramLz, long paramLong)
  {
    if (this.b) {
      throw new IllegalStateException("closed");
    }
    Ae.a(paramLz.c(), 0L, paramLong);
    if (paramLong > this.c) {
      throw new ProtocolException("expected " + this.c + " bytes but received " + paramLong);
    }
    An.a(this.a).a_(paramLz, paramLong);
    this.c -= paramLong;
  }
  
  public LW b()
  {
    return An.a(this.a).b();
  }
  
  public void close()
  {
    if (this.b) {}
    for (;;)
    {
      return;
      this.b = true;
      if (this.c > 0L) {
        throw new ProtocolException("unexpected end of stream");
      }
      An.a(this.a, 3);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     As
 * JD-Core Version:    0.7.0.1
 */