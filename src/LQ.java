import java.io.EOFException;
import java.io.InputStream;

final class LQ
  implements LD
{
  public final Lz a;
  public final LV b;
  private boolean c;
  
  public LQ(LV paramLV)
  {
    this(paramLV, new Lz());
  }
  
  public LQ(LV paramLV, Lz paramLz)
  {
    if (paramLV == null) {
      throw new IllegalArgumentException("source == null");
    }
    this.a = paramLz;
    this.b = paramLV;
  }
  
  public long a(byte paramByte)
  {
    return a(paramByte, 0L);
  }
  
  public long a(byte paramByte, long paramLong)
  {
    long l1 = -1L;
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    do
    {
      if (paramLong < this.a.b) {
        break;
      }
    } while (this.b.a(this.a, 2048L) != l1);
    for (;;)
    {
      return l1;
      long l2;
      do
      {
        l2 = this.a.a(paramByte, paramLong);
        if (l2 != l1) {
          break;
        }
        paramLong = this.a.b;
      } while (this.b.a(this.a, 2048L) != l1);
      continue;
      l1 = l2;
    }
  }
  
  public long a(Lz paramLz, long paramLong)
  {
    long l1 = -1L;
    if (paramLz == null) {
      throw new IllegalArgumentException("sink == null");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    if ((this.a.b == 0L) && (this.b.a(this.a, 2048L) == l1)) {}
    for (;;)
    {
      return l1;
      long l2 = Math.min(paramLong, this.a.b);
      l1 = this.a.a(paramLz, l2);
    }
  }
  
  public void a(long paramLong)
  {
    if (!b(paramLong)) {
      throw new EOFException();
    }
  }
  
  public LW b()
  {
    return this.b.b();
  }
  
  public boolean b(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    do
    {
      if (this.a.b >= paramLong) {
        break;
      }
    } while (this.b.a(this.a, 2048L) != -1L);
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public LE c(long paramLong)
  {
    a(paramLong);
    return this.a.c(paramLong);
  }
  
  public void close()
  {
    if (this.c) {}
    for (;;)
    {
      return;
      this.c = true;
      this.b.close();
      this.a.s();
    }
  }
  
  public Lz d()
  {
    return this.a;
  }
  
  public byte[] f(long paramLong)
  {
    a(paramLong);
    return this.a.f(paramLong);
  }
  
  public void g(long paramLong)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    do
    {
      long l = Math.min(paramLong, this.a.c());
      this.a.g(l);
      paramLong -= l;
      if (paramLong <= 0L) {
        break;
      }
    } while ((this.a.b != 0L) || (this.b.a(this.a, 2048L) != -1L));
    throw new EOFException();
  }
  
  public boolean h()
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    if ((this.a.h()) && (this.b.a(this.a, 2048L) == -1L)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public InputStream i()
  {
    return new LR(this);
  }
  
  public byte k()
  {
    a(1L);
    return this.a.k();
  }
  
  public short l()
  {
    a(2L);
    return this.a.l();
  }
  
  public int m()
  {
    a(4L);
    return this.a.m();
  }
  
  public short n()
  {
    a(2L);
    return this.a.n();
  }
  
  public int o()
  {
    a(4L);
    return this.a.o();
  }
  
  public String q()
  {
    long l = a((byte)10);
    if (l == -1L)
    {
      Lz localLz = new Lz();
      this.a.a(localLz, 0L, Math.min(32L, this.a.c()));
      throw new EOFException("\\n not found: size=" + this.a.c() + " content=" + localLz.p().c() + "...");
    }
    return this.a.e(l);
  }
  
  public byte[] r()
  {
    this.a.a(this.b);
    return this.a.r();
  }
  
  public String toString()
  {
    return "buffer(" + this.b + ")";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     LQ
 * JD-Core Version:    0.7.0.1
 */