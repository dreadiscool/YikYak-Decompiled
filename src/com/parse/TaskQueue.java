package com.parse;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import l;
import m;

class TaskQueue
{
  private final Lock lock = new ReentrantLock();
  private m<Void> tail;
  
  /* Error */
  private m<Void> getTaskToAwait()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/parse/TaskQueue:lock	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 24 1 0
    //   9: aload_0
    //   10: getfield 26	com/parse/TaskQueue:tail	Lm;
    //   13: ifnull +34 -> 47
    //   16: aload_0
    //   17: getfield 26	com/parse/TaskQueue:tail	Lm;
    //   20: astore_3
    //   21: aload_3
    //   22: new 28	com/parse/TaskQueue$1
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 31	com/parse/TaskQueue$1:<init>	(Lcom/parse/TaskQueue;)V
    //   30: invokevirtual 37	m:a	(Ll;)Lm;
    //   33: astore 4
    //   35: aload_0
    //   36: getfield 18	com/parse/TaskQueue:lock	Ljava/util/concurrent/locks/Lock;
    //   39: invokeinterface 40 1 0
    //   44: aload 4
    //   46: areturn
    //   47: aconst_null
    //   48: invokestatic 43	m:a	(Ljava/lang/Object;)Lm;
    //   51: astore_2
    //   52: aload_2
    //   53: astore_3
    //   54: goto -33 -> 21
    //   57: astore_1
    //   58: aload_0
    //   59: getfield 18	com/parse/TaskQueue:lock	Ljava/util/concurrent/locks/Lock;
    //   62: invokeinterface 40 1 0
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	TaskQueue
    //   57	11	1	localObject1	Object
    //   51	2	2	localm1	m
    //   20	34	3	localObject2	Object
    //   33	12	4	localm2	m
    // Exception table:
    //   from	to	target	type
    //   9	35	57	finally
    //   47	52	57	finally
  }
  
  static <T> l<T, m<T>> waitFor(m<Void> paramm)
  {
    return new TaskQueue.2(paramm);
  }
  
  /* Error */
  <T> m<T> enqueue(l<Void, m<T>> paraml)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/parse/TaskQueue:lock	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 24 1 0
    //   9: aload_0
    //   10: getfield 26	com/parse/TaskQueue:tail	Lm;
    //   13: ifnull +68 -> 81
    //   16: aload_0
    //   17: getfield 26	com/parse/TaskQueue:tail	Lm;
    //   20: astore 8
    //   22: aload 8
    //   24: astore_3
    //   25: aload_1
    //   26: aload_0
    //   27: invokespecial 57	com/parse/TaskQueue:getTaskToAwait	()Lm;
    //   30: invokeinterface 63 2 0
    //   35: checkcast 33	m
    //   38: astore 6
    //   40: iconst_2
    //   41: anewarray 33	m
    //   44: astore 7
    //   46: aload 7
    //   48: iconst_0
    //   49: aload_3
    //   50: aastore
    //   51: aload 7
    //   53: iconst_1
    //   54: aload 6
    //   56: aastore
    //   57: aload_0
    //   58: aload 7
    //   60: invokestatic 69	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   63: invokestatic 72	m:a	(Ljava/util/Collection;)Lm;
    //   66: putfield 26	com/parse/TaskQueue:tail	Lm;
    //   69: aload_0
    //   70: getfield 18	com/parse/TaskQueue:lock	Ljava/util/concurrent/locks/Lock;
    //   73: invokeinterface 40 1 0
    //   78: aload 6
    //   80: areturn
    //   81: aconst_null
    //   82: invokestatic 43	m:a	(Ljava/lang/Object;)Lm;
    //   85: astore_3
    //   86: goto -61 -> 25
    //   89: astore 5
    //   91: aload 5
    //   93: athrow
    //   94: astore_2
    //   95: aload_0
    //   96: getfield 18	com/parse/TaskQueue:lock	Ljava/util/concurrent/locks/Lock;
    //   99: invokeinterface 40 1 0
    //   104: aload_2
    //   105: athrow
    //   106: astore 4
    //   108: new 53	java/lang/RuntimeException
    //   111: dup
    //   112: aload 4
    //   114: invokespecial 75	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	TaskQueue
    //   0	118	1	paraml	l<Void, m<T>>
    //   94	11	2	localObject	Object
    //   24	62	3	localm1	m
    //   106	7	4	localException	java.lang.Exception
    //   89	3	5	localRuntimeException	java.lang.RuntimeException
    //   38	41	6	localm2	m
    //   44	15	7	arrayOfm	m[]
    //   20	3	8	localm3	m
    // Exception table:
    //   from	to	target	type
    //   25	40	89	java/lang/RuntimeException
    //   9	22	94	finally
    //   25	40	94	finally
    //   40	69	94	finally
    //   81	94	94	finally
    //   108	118	94	finally
    //   25	40	106	java/lang/Exception
  }
  
  Lock getLock()
  {
    return this.lock;
  }
  
  /* Error */
  void waitUntilFinished()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/parse/TaskQueue:lock	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 24 1 0
    //   9: aload_0
    //   10: getfield 26	com/parse/TaskQueue:tail	Lm;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +13 -> 28
    //   18: aload_0
    //   19: getfield 18	com/parse/TaskQueue:lock	Ljava/util/concurrent/locks/Lock;
    //   22: invokeinterface 40 1 0
    //   27: return
    //   28: aload_0
    //   29: getfield 26	com/parse/TaskQueue:tail	Lm;
    //   32: invokevirtual 81	m:g	()V
    //   35: aload_0
    //   36: getfield 18	com/parse/TaskQueue:lock	Ljava/util/concurrent/locks/Lock;
    //   39: invokeinterface 40 1 0
    //   44: goto -17 -> 27
    //   47: astore_1
    //   48: aload_0
    //   49: getfield 18	com/parse/TaskQueue:lock	Ljava/util/concurrent/locks/Lock;
    //   52: invokeinterface 40 1 0
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	TaskQueue
    //   47	11	1	localObject	Object
    //   13	2	2	localm	m
    // Exception table:
    //   from	to	target	type
    //   9	14	47	finally
    //   28	35	47	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.TaskQueue
 * JD-Core Version:    0.7.0.1
 */