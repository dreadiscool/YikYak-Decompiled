import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class LJ
  implements LV
{
  private final LD a;
  private final Inflater b;
  private int c;
  private boolean d;
  
  LJ(LD paramLD, Inflater paramInflater)
  {
    if (paramLD == null) {
      throw new IllegalArgumentException("source == null");
    }
    if (paramInflater == null) {
      throw new IllegalArgumentException("inflater == null");
    }
    this.a = paramLD;
    this.b = paramInflater;
  }
  
  public LJ(LV paramLV, Inflater paramInflater)
  {
    this(LK.a(paramLV), paramInflater);
  }
  
  private void c()
  {
    if (this.c == 0) {}
    for (;;)
    {
      return;
      int i = this.c - this.b.getRemaining();
      this.c -= i;
      this.a.g(i);
    }
  }
  
  public long a(Lz paramLz, long paramLong)
  {
    long l = 0L;
    if (paramLong < l) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.d) {
      throw new IllegalStateException("closed");
    }
    if (paramLong == l) {}
    for (;;)
    {
      return l;
      label64:
      boolean bool = a();
      try
      {
        LS localLS = paramLz.d(1);
        int i = this.b.inflate(localLS.a, localLS.c, 2048 - localLS.c);
        if (i > 0)
        {
          localLS.c = (i + localLS.c);
          paramLz.b += i;
          l = i;
          continue;
        }
        if ((this.b.finished()) || (this.b.needsDictionary()))
        {
          c();
          l = -1L;
          continue;
        }
        if (!bool) {
          break label64;
        }
        throw new EOFException("source exhausted prematurely");
      }
      catch (DataFormatException localDataFormatException)
      {
        throw new IOException(localDataFormatException);
      }
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (!this.b.needsInput()) {}
    for (;;)
    {
      return bool;
      c();
      if (this.b.getRemaining() != 0) {
        throw new IllegalStateException("?");
      }
      if (this.a.h())
      {
        bool = true;
      }
      else
      {
        LS localLS = this.a.d().a;
        this.c = (localLS.c - localLS.b);
        this.b.setInput(localLS.a, localLS.b, this.c);
      }
    }
  }
  
  public LW b()
  {
    return this.a.b();
  }
  
  public void close()
  {
    if (this.d) {}
    for (;;)
    {
      return;
      this.b.end();
      this.d = true;
      this.a.close();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     LJ
 * JD-Core Version:    0.7.0.1
 */