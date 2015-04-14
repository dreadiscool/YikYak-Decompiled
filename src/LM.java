import java.io.InputStream;

final class LM
  implements LV
{
  LM(LW paramLW, InputStream paramInputStream) {}
  
  public long a(Lz paramLz, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    this.a.j();
    LS localLS = paramLz.d(1);
    int i = (int)Math.min(paramLong, 2048 - localLS.c);
    int j = this.b.read(localLS.a, localLS.c, i);
    if (j == -1) {}
    for (long l = -1L;; l = j)
    {
      return l;
      localLS.c = (j + localLS.c);
      paramLz.b += j;
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
    return "source(" + this.b + ")";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     LM
 * JD-Core Version:    0.7.0.1
 */