import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

class At
  extends Ap
{
  private long d;
  
  public At(An paramAn, long paramLong)
  {
    super(paramAn, null);
    this.d = paramLong;
    if (this.d == 0L) {
      a(true);
    }
  }
  
  public long a(Lz paramLz, long paramLong)
  {
    long l1 = -1L;
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.a) {
      throw new IllegalStateException("closed");
    }
    if (this.d == 0L) {}
    for (;;)
    {
      return l1;
      long l2 = An.b(this.c).a(paramLz, Math.min(this.d, paramLong));
      if (l2 == l1)
      {
        a();
        throw new ProtocolException("unexpected end of stream");
      }
      this.d -= l2;
      if (this.d == 0L) {
        a(true);
      }
      l1 = l2;
    }
  }
  
  public void close()
  {
    if (this.a) {}
    for (;;)
    {
      return;
      if ((this.d != 0L) && (!Ae.a(this, 100, TimeUnit.MILLISECONDS))) {
        a();
      }
      this.a = true;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     At
 * JD-Core Version:    0.7.0.1
 */