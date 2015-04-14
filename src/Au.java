class Au
  extends Ap
{
  private boolean d;
  
  private Au(An paramAn)
  {
    super(paramAn, null);
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
    if (this.d) {}
    for (;;)
    {
      return l1;
      long l2 = An.b(this.c).a(paramLz, paramLong);
      if (l2 == l1)
      {
        this.d = true;
        a(false);
      }
      else
      {
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
      if (!this.d) {
        a();
      }
      this.a = true;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Au
 * JD-Core Version:    0.7.0.1
 */