import java.io.IOException;
import java.util.concurrent.TimeUnit;

class Az
  implements LV
{
  boolean a;
  
  Az(Ax paramAx, LD paramLD, Ai paramAi, LC paramLC) {}
  
  public long a(Lz paramLz, long paramLong)
  {
    for (;;)
    {
      long l2;
      try
      {
        long l1 = this.b.a(paramLz, paramLong);
        l2 = l1;
        if (l2 == -1L)
        {
          if (!this.a)
          {
            this.a = true;
            this.d.close();
          }
          l2 = -1L;
          return l2;
        }
      }
      catch (IOException localIOException)
      {
        if (!this.a)
        {
          this.a = true;
          this.c.a();
        }
        throw localIOException;
      }
      paramLz.a(this.d.d(), paramLz.c() - l2, l2);
      this.d.u();
    }
  }
  
  public LW b()
  {
    return this.b.b();
  }
  
  public void close()
  {
    if ((!this.a) && (!Ae.a(this, 100, TimeUnit.MILLISECONDS)))
    {
      this.a = true;
      this.c.a();
    }
    this.b.close();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Az
 * JD-Core Version:    0.7.0.1
 */