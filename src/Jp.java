import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

final class Jp
  implements ThreadFactory
{
  Jp(String paramString, AtomicLong paramAtomicLong) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    Thread localThread = Executors.defaultThreadFactory().newThread(new Jq(this, paramRunnable));
    localThread.setName(this.a + this.b.getAndIncrement());
    return localThread;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Jp
 * JD-Core Version:    0.7.0.1
 */