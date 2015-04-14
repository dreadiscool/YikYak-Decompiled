import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class LI
  implements LV
{
  private int a = 0;
  private final LD b;
  private final Inflater c;
  private final LJ d;
  private final CRC32 e = new CRC32();
  
  public LI(LV paramLV)
  {
    if (paramLV == null) {
      throw new IllegalArgumentException("source == null");
    }
    this.c = new Inflater(true);
    this.b = LK.a(paramLV);
    this.d = new LJ(this.b, this.c);
  }
  
  private void a()
  {
    this.b.a(10L);
    int i = this.b.d().b(3L);
    if ((0x1 & i >> 1) == 1) {}
    long l2;
    for (int j = 1;; j = 0)
    {
      if (j != 0) {
        a(this.b.d(), 0L, 10L);
      }
      a("ID1ID2", 8075, this.b.l());
      this.b.g(8L);
      if ((0x1 & i >> 2) == 1)
      {
        this.b.a(2L);
        if (j != 0) {
          a(this.b.d(), 0L, 2L);
        }
        int k = this.b.d().n();
        this.b.a(k);
        if (j != 0) {
          a(this.b.d(), 0L, k);
        }
        this.b.g(k);
      }
      if ((0x1 & i >> 3) != 1) {
        break label269;
      }
      l2 = this.b.a((byte)0);
      if (l2 != -1L) {
        break;
      }
      throw new EOFException();
    }
    if (j != 0) {
      a(this.b.d(), 0L, 1L + l2);
    }
    this.b.g(1L + l2);
    label269:
    if ((0x1 & i >> 4) == 1)
    {
      long l1 = this.b.a((byte)0);
      if (l1 == -1L) {
        throw new EOFException();
      }
      if (j != 0) {
        a(this.b.d(), 0L, 1L + l1);
      }
      this.b.g(1L + l1);
    }
    if (j != 0)
    {
      a("FHCRC", this.b.n(), (short)(int)this.e.getValue());
      this.e.reset();
    }
  }
  
  private void a(Lz paramLz, long paramLong1, long paramLong2)
  {
    for (LS localLS = paramLz.a; paramLong1 >= localLS.c - localLS.b; localLS = localLS.d) {
      paramLong1 -= localLS.c - localLS.b;
    }
    while (paramLong2 > 0L)
    {
      int i = (int)(paramLong1 + localLS.b);
      int j = (int)Math.min(localLS.c - i, paramLong2);
      this.e.update(localLS.a, i, j);
      paramLong2 -= j;
      localLS = localLS.d;
      paramLong1 = 0L;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 != paramInt1)
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = Integer.valueOf(paramInt2);
      arrayOfObject[2] = Integer.valueOf(paramInt1);
      throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", arrayOfObject));
    }
  }
  
  private void c()
  {
    a("CRC", this.b.o(), (int)this.e.getValue());
    a("ISIZE", this.b.o(), this.c.getTotalOut());
  }
  
  public long a(Lz paramLz, long paramLong)
  {
    long l1 = 0L;
    if (paramLong < l1) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (paramLong == l1) {}
    for (;;)
    {
      return l1;
      if (this.a == 0)
      {
        a();
        this.a = 1;
      }
      if (this.a == 1)
      {
        long l2 = paramLz.b;
        l1 = this.d.a(paramLz, paramLong);
        if (l1 != -1L) {
          a(paramLz, l2, l1);
        } else {
          this.a = 2;
        }
      }
      else
      {
        if (this.a == 2)
        {
          c();
          this.a = 3;
          if (!this.b.h()) {
            throw new IOException("gzip finished without exhausting source");
          }
        }
        l1 = -1L;
      }
    }
  }
  
  public LW b()
  {
    return this.b.b();
  }
  
  public void close()
  {
    this.d.close();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     LI
 * JD-Core Version:    0.7.0.1
 */