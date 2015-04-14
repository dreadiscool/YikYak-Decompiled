import java.io.OutputStream;

final class LL
  implements LU
{
  LL(LW paramLW, OutputStream paramOutputStream) {}
  
  public void a()
  {
    this.b.flush();
  }
  
  public void a_(Lz paramLz, long paramLong)
  {
    LY.a(paramLz.b, 0L, paramLong);
    while (paramLong > 0L)
    {
      this.a.j();
      LS localLS = paramLz.a;
      int i = (int)Math.min(paramLong, localLS.c - localLS.b);
      this.b.write(localLS.a, localLS.b, i);
      localLS.b = (i + localLS.b);
      paramLong -= i;
      paramLz.b -= i;
      if (localLS.b == localLS.c)
      {
        paramLz.a = localLS.a();
        LT.a.a(localLS);
      }
    }
  }
  
  public LW b()
  {
    return this.a;
  }
  
  public void close()
  {
    this.b.close();
  }
  
  public String toString()
  {
    return "sink(" + this.b + ")";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     LL
 * JD-Core Version:    0.7.0.1
 */