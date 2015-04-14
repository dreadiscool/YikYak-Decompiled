import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class zm
{
  private int a = 64;
  private int b = 5;
  private ExecutorService c;
  private final Deque<yY> d = new ArrayDeque();
  private final Deque<yY> e = new ArrayDeque();
  private final Deque<yV> f = new ArrayDeque();
  
  private void b()
  {
    if (this.e.size() >= this.a) {
      return;
    }
    for (;;)
    {
      if (!this.d.isEmpty())
      {
        Iterator localIterator = this.d.iterator();
        if (localIterator.hasNext())
        {
          yY localyY = (yY)localIterator.next();
          if (c(localyY) < this.b)
          {
            localIterator.remove();
            this.e.add(localyY);
            a().execute(localyY);
          }
          if (this.e.size() < this.a) {
            break;
          }
        }
      }
    }
  }
  
  private int c(yY paramyY)
  {
    Iterator localIterator = this.e.iterator();
    int i = 0;
    if (localIterator.hasNext()) {
      if (!((yY)localIterator.next()).a().equals(paramyY.a())) {
        break label56;
      }
    }
    label56:
    for (int j = i + 1;; j = i)
    {
      i = j;
      break;
      return i;
    }
  }
  
  public ExecutorService a()
  {
    try
    {
      if (this.c == null) {
        this.c = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Ae.a("OkHttp Dispatcher", false));
      }
      ExecutorService localExecutorService = this.c;
      return localExecutorService;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void a(yV paramyV)
  {
    try
    {
      this.f.add(paramyV);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  void a(yY paramyY)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	zm:e	Ljava/util/Deque;
    //   6: invokeinterface 38 1 0
    //   11: aload_0
    //   12: getfield 21	zm:a	I
    //   15: if_icmpge +39 -> 54
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial 60	zm:c	(LyY;)I
    //   23: aload_0
    //   24: getfield 23	zm:b	I
    //   27: if_icmpge +27 -> 54
    //   30: aload_0
    //   31: getfield 30	zm:e	Ljava/util/Deque;
    //   34: aload_1
    //   35: invokeinterface 67 2 0
    //   40: pop
    //   41: aload_0
    //   42: invokevirtual 70	zm:a	()Ljava/util/concurrent/ExecutorService;
    //   45: aload_1
    //   46: invokeinterface 76 2 0
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: aload_0
    //   55: getfield 28	zm:d	Ljava/util/Deque;
    //   58: aload_1
    //   59: invokeinterface 67 2 0
    //   64: pop
    //   65: goto -14 -> 51
    //   68: astore_2
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_2
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	zm
    //   0	73	1	paramyY	yY
    //   68	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	51	68	finally
    //   54	65	68	finally
  }
  
  void b(yV paramyV)
  {
    try
    {
      if (!this.f.remove(paramyV)) {
        throw new AssertionError("Call wasn't in-flight!");
      }
    }
    finally {}
  }
  
  void b(yY paramyY)
  {
    try
    {
      if (!this.e.remove(paramyY)) {
        throw new AssertionError("AsyncCall wasn't running!");
      }
    }
    finally {}
    b();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zm
 * JD-Core Version:    0.7.0.1
 */