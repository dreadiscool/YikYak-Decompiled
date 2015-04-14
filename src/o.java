final class o
  implements Runnable
{
  o(l paraml, m paramm, y paramy) {}
  
  public void run()
  {
    try
    {
      m localm = (m)this.a.then(this.b);
      if (localm == null) {
        this.c.b(null);
      } else {
        localm.a(new p(this));
      }
    }
    catch (Exception localException)
    {
      this.c.b(localException);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     o
 * JD-Core Version:    0.7.0.1
 */