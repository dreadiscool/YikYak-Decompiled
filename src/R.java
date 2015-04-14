import java.util.concurrent.CountDownLatch;

class R
{
  private boolean b = false;
  private final CountDownLatch c = new CountDownLatch(1);
  
  private R(G paramG) {}
  
  void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    this.c.countDown();
  }
  
  boolean a()
  {
    return this.b;
  }
  
  void b()
  {
    try
    {
      this.c.await();
      label7:
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label7;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     R
 * JD-Core Version:    0.7.0.1
 */