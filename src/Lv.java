import java.io.IOException;

class Lv
  implements LU
{
  Lv(Lu paramLu, LU paramLU) {}
  
  public void a()
  {
    this.b.c();
    try
    {
      this.a.a();
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
  
  public void a_(Lz paramLz, long paramLong)
  {
    this.b.c();
    try
    {
      this.a.a_(paramLz, paramLong);
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
  
  public LW b()
  {
    return this.b;
  }
  
  public void close()
  {
    this.b.c();
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
    return "AsyncTimeout.sink(" + this.a + ")";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Lv
 * JD-Core Version:    0.7.0.1
 */