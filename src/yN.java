import java.io.IOException;

final class yN
  implements Ai
{
  private final zO b;
  private LU c;
  private boolean d;
  private LU e;
  
  public yN(yL paramyL, zO paramzO)
  {
    this.b = paramzO;
    this.c = paramzO.a(1);
    this.e = new yO(this, this.c, paramyL, paramzO);
  }
  
  public void a()
  {
    synchronized (this.a)
    {
      if (!this.d)
      {
        this.d = true;
        yL.c(this.a);
        Ae.a(this.c);
        try
        {
          this.b.b();
        }
        catch (IOException localIOException) {}
      }
    }
  }
  
  public LU b()
  {
    return this.e;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     yN
 * JD-Core Version:    0.7.0.1
 */