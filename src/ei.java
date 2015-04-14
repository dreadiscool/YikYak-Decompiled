class ei
  extends Thread
{
  ei(eh parameh, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    synchronized (eh.a(this.a))
    {
      eh.a(this.a, this.a.c());
      eh.a(this.a, true);
      eh.a(this.a).notifyAll();
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ei
 * JD-Core Version:    0.7.0.1
 */