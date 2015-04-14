import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class JQ<E extends JP,  extends Kc,  extends JY>
  extends PriorityBlockingQueue<E>
{
  final Queue<E> a = new LinkedList();
  private final ReentrantLock b = new ReentrantLock();
  
  public E a()
  {
    return b(0, null, null);
  }
  
  E a(int paramInt, Long paramLong, TimeUnit paramTimeUnit)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      localObject = (JP)super.take();
      continue;
      localObject = (JP)super.peek();
      continue;
      localObject = (JP)super.poll();
      continue;
      localObject = (JP)super.poll(paramLong.longValue(), paramTimeUnit);
    }
  }
  
  public E a(long paramLong, TimeUnit paramTimeUnit)
  {
    return b(3, Long.valueOf(paramLong), paramTimeUnit);
  }
  
  boolean a(int paramInt, E paramE)
  {
    try
    {
      this.b.lock();
      if (paramInt == 1) {
        super.remove(paramE);
      }
      boolean bool = this.a.offer(paramE);
      return bool;
    }
    finally
    {
      this.b.unlock();
    }
  }
  
  boolean a(E paramE)
  {
    return paramE.d();
  }
  
  <T> T[] a(T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    int i = paramArrayOfT1.length;
    int j = paramArrayOfT2.length;
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfT1.getClass().getComponentType(), i + j);
    System.arraycopy(paramArrayOfT1, 0, arrayOfObject, 0, i);
    System.arraycopy(paramArrayOfT2, 0, arrayOfObject, i, j);
    return arrayOfObject;
  }
  
  public E b()
  {
    Object localObject = null;
    try
    {
      JP localJP = b(1, null, null);
      localObject = localJP;
    }
    catch (InterruptedException localInterruptedException)
    {
      label12:
      break label12;
    }
    return localObject;
  }
  
  E b(int paramInt, Long paramLong, TimeUnit paramTimeUnit)
  {
    for (;;)
    {
      JP localJP = a(paramInt, paramLong, paramTimeUnit);
      if ((localJP == null) || (a(localJP))) {
        return localJP;
      }
      a(paramInt, localJP);
    }
  }
  
  public E c()
  {
    Object localObject = null;
    try
    {
      JP localJP = b(2, null, null);
      localObject = localJP;
    }
    catch (InterruptedException localInterruptedException)
    {
      label12:
      break label12;
    }
    return localObject;
  }
  
  public void clear()
  {
    try
    {
      this.b.lock();
      this.a.clear();
      super.clear();
      return;
    }
    finally
    {
      this.b.unlock();
    }
  }
  
  /* Error */
  public boolean contains(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	JQ:b	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 58	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial 117	java/util/concurrent/PriorityBlockingQueue:contains	(Ljava/lang/Object;)Z
    //   12: ifne +20 -> 32
    //   15: aload_0
    //   16: getfield 19	JQ:a	Ljava/util/Queue;
    //   19: aload_1
    //   20: invokeinterface 118 2 0
    //   25: istore 4
    //   27: iload 4
    //   29: ifeq +14 -> 43
    //   32: iconst_1
    //   33: istore_3
    //   34: aload_0
    //   35: getfield 24	JQ:b	Ljava/util/concurrent/locks/ReentrantLock;
    //   38: invokevirtual 70	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   41: iload_3
    //   42: ireturn
    //   43: iconst_0
    //   44: istore_3
    //   45: goto -11 -> 34
    //   48: astore_2
    //   49: aload_0
    //   50: getfield 24	JQ:b	Ljava/util/concurrent/locks/ReentrantLock;
    //   53: invokevirtual 70	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   56: aload_2
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	JQ
    //   0	58	1	paramObject	Object
    //   48	9	2	localObject	Object
    //   33	12	3	bool1	boolean
    //   25	3	4	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   0	27	48	finally
  }
  
  public void d()
  {
    try
    {
      this.b.lock();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        JP localJP = (JP)localIterator.next();
        if (a(localJP))
        {
          super.offer(localJP);
          localIterator.remove();
        }
      }
      return;
    }
    finally
    {
      this.b.unlock();
    }
  }
  
  public int drainTo(Collection<? super E> paramCollection)
  {
    try
    {
      this.b.lock();
      int i = super.drainTo(paramCollection) + this.a.size();
      if (!this.a.isEmpty()) {
        paramCollection.add(this.a.poll());
      }
      return i;
    }
    finally
    {
      this.b.unlock();
    }
  }
  
  public int drainTo(Collection<? super E> paramCollection, int paramInt)
  {
    try
    {
      this.b.lock();
      for (int i = super.drainTo(paramCollection, paramInt); (!this.a.isEmpty()) && (i <= paramInt); i++) {
        paramCollection.add(this.a.poll());
      }
      return i;
    }
    finally
    {
      this.b.unlock();
    }
  }
  
  /* Error */
  public boolean remove(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	JQ:b	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 58	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial 62	java/util/concurrent/PriorityBlockingQueue:remove	(Ljava/lang/Object;)Z
    //   12: ifne +20 -> 32
    //   15: aload_0
    //   16: getfield 19	JQ:a	Ljava/util/Queue;
    //   19: aload_1
    //   20: invokeinterface 160 2 0
    //   25: istore 4
    //   27: iload 4
    //   29: ifeq +14 -> 43
    //   32: iconst_1
    //   33: istore_3
    //   34: aload_0
    //   35: getfield 24	JQ:b	Ljava/util/concurrent/locks/ReentrantLock;
    //   38: invokevirtual 70	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   41: iload_3
    //   42: ireturn
    //   43: iconst_0
    //   44: istore_3
    //   45: goto -11 -> 34
    //   48: astore_2
    //   49: aload_0
    //   50: getfield 24	JQ:b	Ljava/util/concurrent/locks/ReentrantLock;
    //   53: invokevirtual 70	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   56: aload_2
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	JQ
    //   0	58	1	paramObject	Object
    //   48	9	2	localObject	Object
    //   33	12	3	bool1	boolean
    //   25	3	4	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   0	27	48	finally
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    try
    {
      this.b.lock();
      boolean bool1 = super.removeAll(paramCollection);
      boolean bool2 = this.a.removeAll(paramCollection);
      boolean bool3 = bool1 | bool2;
      return bool3;
    }
    finally
    {
      this.b.unlock();
    }
  }
  
  public int size()
  {
    try
    {
      this.b.lock();
      int i = this.a.size();
      int j = super.size();
      int k = i + j;
      return k;
    }
    finally
    {
      this.b.unlock();
    }
  }
  
  public Object[] toArray()
  {
    try
    {
      this.b.lock();
      Object[] arrayOfObject = a(super.toArray(), this.a.toArray());
      return arrayOfObject;
    }
    finally
    {
      this.b.unlock();
    }
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    try
    {
      this.b.lock();
      Object[] arrayOfObject = a(super.toArray(paramArrayOfT), this.a.toArray(paramArrayOfT));
      return arrayOfObject;
    }
    finally
    {
      this.b.unlock();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     JQ
 * JD-Core Version:    0.7.0.1
 */