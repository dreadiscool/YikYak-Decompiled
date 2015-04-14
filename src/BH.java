import java.io.InterruptedIOException;

class BH
  extends Lu
{
  BH(BD paramBD) {}
  
  protected void a()
  {
    this.a.b(AP.l);
  }
  
  public void b()
  {
    if (d()) {
      throw new InterruptedIOException("timeout");
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     BH
 * JD-Core Version:    0.7.0.1
 */