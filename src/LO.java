import java.io.OutputStream;

final class LO
  implements LC
{
  public final Lz a;
  public final LU b;
  private boolean c;
  
  public LO(LU paramLU)
  {
    this(paramLU, new Lz());
  }
  
  public LO(LU paramLU, Lz paramLz)
  {
    if (paramLU == null) {
      throw new IllegalArgumentException("sink == null");
    }
    this.a = paramLz;
    this.b = paramLU;
  }
  
  public long a(LV paramLV)
  {
    if (paramLV == null) {
      throw new IllegalArgumentException("source == null");
    }
    long l1 = 0L;
    for (;;)
    {
      long l2 = paramLV.a(this.a, 2048L);
      if (l2 == -1L) {
        break;
      }
      l1 += l2;
      u();
    }
    return l1;
  }
  
  public void a()
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    if (this.a.b > 0L) {
      this.b.a_(this.a, this.a.b);
    }
    this.b.a();
  }
  
  public void a_(Lz paramLz, long paramLong)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.a_(paramLz, paramLong);
    u();
  }
  
  public LC b(LE paramLE)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.a(paramLE);
    return u();
  }
  
  public LC b(String paramString)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.a(paramString);
    return u();
  }
  
  public LW b()
  {
    return this.b.b();
  }
  
  public LC c(byte[] paramArrayOfByte)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.b(paramArrayOfByte);
    return u();
  }
  
  public LC c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.b(paramArrayOfByte, paramInt1, paramInt2);
    return u();
  }
  
  public void close()
  {
    if (this.c) {}
    for (;;)
    {
      return;
      Object localObject = null;
      try
      {
        if (this.a.b > 0L) {
          this.b.a_(this.a, this.a.b);
        }
        try
        {
          label42:
          this.b.close();
          this.c = true;
          if (localObject == null) {
            continue;
          }
          LY.a((Throwable)localObject);
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            if (localObject == null) {
              localObject = localThrowable2;
            }
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        break label42;
      }
    }
  }
  
  public Lz d()
  {
    return this.a;
  }
  
  public LC e(int paramInt)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.c(paramInt);
    return u();
  }
  
  public OutputStream e()
  {
    return new LP(this);
  }
  
  public LC f(int paramInt)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.b(paramInt);
    return u();
  }
  
  public LC g()
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    long l = this.a.c();
    if (l > 0L) {
      this.b.a_(this.a, l);
    }
    return this;
  }
  
  public LC g(int paramInt)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.a(paramInt);
    return u();
  }
  
  public String toString()
  {
    return "buffer(" + this.b + ")";
  }
  
  public LC u()
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    long l = this.a.j();
    if (l > 0L) {
      this.b.a_(this.a, l);
    }
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     LO
 * JD-Core Version:    0.7.0.1
 */