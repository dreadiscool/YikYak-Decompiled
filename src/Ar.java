import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

class Ar
  extends Ap
{
  private int d = -1;
  private boolean e = true;
  private final Ax f;
  
  Ar(An paramAn, Ax paramAx)
  {
    super(paramAn, null);
    this.f = paramAx;
  }
  
  private void c()
  {
    if (this.d != -1) {
      An.b(this.c).q();
    }
    String str = An.b(this.c).q();
    int i = str.indexOf(";");
    if (i != -1) {
      str = str.substring(0, i);
    }
    try
    {
      this.d = Integer.parseInt(str.trim(), 16);
      if (this.d == 0)
      {
        this.e = false;
        zq localzq = new zq();
        this.c.a(localzq);
        this.f.a(localzq.a());
        a(true);
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new ProtocolException("Expected a hex chunk size but was " + str);
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
    if (!this.e) {}
    for (;;)
    {
      return l1;
      if ((this.d == 0) || (this.d == -1))
      {
        c();
        if (!this.e) {}
      }
      else
      {
        long l2 = An.b(this.c).a(paramLz, Math.min(paramLong, this.d));
        if (l2 == l1)
        {
          a();
          throw new IOException("unexpected end of stream");
        }
        this.d = ((int)(this.d - l2));
        l1 = l2;
      }
    }
  }
  
  public void close()
  {
    if (this.a) {}
    for (;;)
    {
      return;
      if ((this.e) && (!Ae.a(this, 100, TimeUnit.MILLISECONDS))) {
        a();
      }
      this.a = true;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ar
 * JD-Core Version:    0.7.0.1
 */