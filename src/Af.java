import java.util.concurrent.ThreadFactory;

final class Af
  implements ThreadFactory
{
  Af(String paramString, boolean paramBoolean) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    Thread localThread = new Thread(paramRunnable, this.a);
    localThread.setDaemon(this.b);
    return localThread;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Af
 * JD-Core Version:    0.7.0.1
 */