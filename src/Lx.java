final class Lx
  extends Thread
{
  public Lx()
  {
    super("Okio Watchdog");
    setDaemon(true);
  }
  
  public void run()
  {
    try
    {
      for (;;)
      {
        Lu localLu = Lu.e();
        if (localLu != null) {
          localLu.a();
        }
      }
    }
    catch (InterruptedException localInterruptedException) {}
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Lx
 * JD-Core Version:    0.7.0.1
 */