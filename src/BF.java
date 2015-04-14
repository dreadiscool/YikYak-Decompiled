final class BF
  implements LU
{
  private boolean c;
  private boolean d;
  
  static
  {
    if (!BD.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  BF(BD paramBD) {}
  
  public void a()
  {
    if ((!a) && (Thread.holdsLock(this.b))) {
      throw new AssertionError();
    }
    synchronized (this.b)
    {
      BD.h(this.b);
      BD.a(this.b).d();
      return;
    }
  }
  
  public void a_(Lz paramLz, long paramLong)
  {
    if ((!a) && (Thread.holdsLock(this.b))) {
      throw new AssertionError();
    }
    BD localBD1;
    try
    {
      BD.g(this.b).b();
      BD.h(this.b);
      long l = Math.min(this.b.b, paramLong);
      BD localBD2 = this.b;
      localBD2.b -= l;
      paramLong -= l;
      BD.a(this.b).a(BD.b(this.b), false, paramLz, l);
      if (paramLong > 0L)
      {
        localBD1 = this.b;
        BD.g(this.b).c();
      }
    }
    finally
    {
      try
      {
        for (;;)
        {
          if ((this.b.b <= 0L) && (!this.d) && (!this.c) && (BD.d(this.b) == null)) {
            BD.e(this.b);
          }
        }
      }
      finally
      {
        BD.g(this.b).b();
      }
    }
  }
  
  public LW b()
  {
    return BD.g(this.b);
  }
  
  public void close()
  {
    if ((!a) && (Thread.holdsLock(this.b))) {
      throw new AssertionError();
    }
    synchronized (this.b)
    {
      if (this.c) {
        return;
      }
      if (!this.b.c.d) {
        BD.a(this.b).a(BD.b(this.b), true, null, 0L);
      }
    }
    synchronized (this.b)
    {
      this.c = true;
      BD.a(this.b).d();
      BD.f(this.b);
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     BF
 * JD-Core Version:    0.7.0.1
 */