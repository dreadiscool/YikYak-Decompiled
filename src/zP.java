import java.io.IOException;

class zP
  extends LG
{
  public zP(zO paramzO, LU paramLU)
  {
    super(paramLU);
  }
  
  public void a()
  {
    try
    {
      super.a();
      return;
    }
    catch (IOException localIOException)
    {
      synchronized (this.a.a)
      {
        zO.a(this.a, true);
      }
    }
  }
  
  public void a_(Lz paramLz, long paramLong)
  {
    try
    {
      super.a_(paramLz, paramLong);
      return;
    }
    catch (IOException localIOException)
    {
      synchronized (this.a.a)
      {
        zO.a(this.a, true);
      }
    }
  }
  
  public void close()
  {
    try
    {
      super.close();
      return;
    }
    catch (IOException localIOException)
    {
      synchronized (this.a.a)
      {
        zO.a(this.a, true);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zP
 * JD-Core Version:    0.7.0.1
 */