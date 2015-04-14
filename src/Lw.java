import java.io.IOException;

class Lw
  implements LV
{
  Lw(Lu paramLu, LV paramLV) {}
  
  public long a(Lz paramLz, long paramLong)
  {
    this.b.c();
    try
    {
      long l = this.a.a(paramLz, paramLong);
      this.b.a(true);
      return l;
    }
    catch (IOException localIOException)
    {
      throw this.b.a(localIOException);
    }
    finally
    {
      this.b.a(false);
    }
  }
  
  public LW b()
  {
    return this.b;
  }
  
  public void close()
  {
    try
    {
      this.a.close();
      this.b.a(true);
      return;
    }
    catch (IOException localIOException)
    {
      throw this.b.a(localIOException);
    }
    finally
    {
      this.b.a(false);
    }
  }
  
  public String toString()
  {
    return "AsyncTimeout.source(" + this.a + ")";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Lw
 * JD-Core Version:    0.7.0.1
 */