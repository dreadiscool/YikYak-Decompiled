class gf
  extends Thread
{
  gf(ge paramge, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    synchronized (ge.a(this.a))
    {
      ge.a(this.a, this.a.d());
      ge.a(this.a, true);
      ge.a(this.a).notifyAll();
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     gf
 * JD-Core Version:    0.7.0.1
 */