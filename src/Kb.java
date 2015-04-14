import java.util.concurrent.ThreadFactory;

public final class Kb
  implements ThreadFactory
{
  private final int a;
  
  public Kb(int paramInt)
  {
    this.a = paramInt;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    Thread localThread = new Thread(paramRunnable);
    localThread.setPriority(this.a);
    localThread.setName("Queue");
    return localThread;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Kb
 * JD-Core Version:    0.7.0.1
 */