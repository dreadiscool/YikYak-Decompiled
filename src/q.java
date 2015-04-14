import java.util.concurrent.Callable;

final class q
  implements Runnable
{
  q(y paramy, Callable paramCallable) {}
  
  public void run()
  {
    try
    {
      this.a.b(this.b.call());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.a.b(localException);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     q
 * JD-Core Version:    0.7.0.1
 */