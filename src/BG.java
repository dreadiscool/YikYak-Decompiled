import java.io.EOFException;
import java.io.IOException;

final class BG
  implements LV
{
  private final Lz c = new Lz();
  private final Lz d = new Lz();
  private final long e;
  private boolean f;
  private boolean g;
  
  static
  {
    if (!BD.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  private BG(BD paramBD, long paramLong)
  {
    this.e = paramLong;
  }
  
  private void a()
  {
    BD.c(this.b).c();
    try
    {
      if (this.d.c() == 0L) {
        if ((!this.g) && (!this.f) && (BD.d(this.b) == null)) {
          BD.e(this.b);
        }
      }
      return;
    }
    finally
    {
      BD.c(this.b).b();
    }
  }
  
  private void c()
  {
    if (this.f) {
      throw new IOException("stream closed");
    }
    if (BD.d(this.b) != null) {
      throw new IOException("stream was reset: " + BD.d(this.b));
    }
  }
  
  public long a(Lz paramLz, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    long l;
    synchronized (this.b)
    {
      a();
      c();
      if (this.d.c() == 0L)
      {
        l = -1L;
      }
      else
      {
        l = this.d.a(paramLz, Math.min(paramLong, this.d.c()));
        BD localBD2 = this.b;
        localBD2.a = (l + localBD2.a);
        if (this.b.a >= BD.a(this.b).e.e(65536) / 2)
        {
          BD.a(this.b).a(BD.b(this.b), this.b.a);
          this.b.a = 0L;
        }
        synchronized (BD.a(this.b))
        {
          Br localBr2 = BD.a(this.b);
          localBr2.c = (l + localBr2.c);
          if (BD.a(this.b).c >= BD.a(this.b).e.e(65536) / 2)
          {
            BD.a(this.b).a(0, BD.a(this.b).c);
            BD.a(this.b).c = 0L;
          }
        }
      }
    }
    return l;
  }
  
  void a(LD paramLD, long paramLong)
  {
    if ((!a) && (Thread.holdsLock(this.b))) {
      throw new AssertionError();
    }
    for (;;)
    {
      Object localObject2;
      paramLong -= localObject2;
      synchronized (this.b)
      {
        if (this.d.c() == 0L)
        {
          j = 1;
          this.d.a(this.c);
          if (j != 0) {
            this.b.notifyAll();
          }
          if (paramLong > 0L) {}
          for (;;)
          {
            boolean bool;
            synchronized (this.b)
            {
              bool = this.g;
              int i;
              if (paramLong + this.d.c() > this.e)
              {
                i = 1;
                if (i != 0)
                {
                  paramLD.g(paramLong);
                  this.b.b(AP.h);
                }
              }
              else
              {
                i = 0;
              }
            }
            if (!bool) {
              break;
            }
            paramLD.g(paramLong);
          }
          long l = paramLD.a(this.c, paramLong);
          if (l != -1L) {
            continue;
          }
          throw new EOFException();
        }
        int j = 0;
      }
    }
  }
  
  public LW b()
  {
    return BD.c(this.b);
  }
  
  public void close()
  {
    synchronized (this.b)
    {
      this.f = true;
      this.d.s();
      this.b.notifyAll();
      BD.f(this.b);
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     BG
 * JD-Core Version:    0.7.0.1
 */