package com.facebook.internal;

import com.facebook.Settings;
import java.util.concurrent.Executor;

class WorkQueue
{
  public static final int DEFAULT_MAX_CONCURRENT = 8;
  private final Executor executor;
  private final int maxConcurrent;
  private WorkQueue.WorkNode pendingJobs;
  private int runningCount = 0;
  private WorkQueue.WorkNode runningJobs = null;
  private final Object workLock = new Object();
  
  static
  {
    if (!WorkQueue.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  WorkQueue()
  {
    this(8);
  }
  
  WorkQueue(int paramInt)
  {
    this(paramInt, Settings.getExecutor());
  }
  
  WorkQueue(int paramInt, Executor paramExecutor)
  {
    this.maxConcurrent = paramInt;
    this.executor = paramExecutor;
  }
  
  private void execute(WorkQueue.WorkNode paramWorkNode)
  {
    this.executor.execute(new WorkQueue.1(this, paramWorkNode));
  }
  
  private void finishItemAndStartNew(WorkQueue.WorkNode paramWorkNode)
  {
    WorkQueue.WorkNode localWorkNode = null;
    Object localObject1 = this.workLock;
    if (paramWorkNode != null) {}
    try
    {
      this.runningJobs = paramWorkNode.removeFromList(this.runningJobs);
      this.runningCount = (-1 + this.runningCount);
      if (this.runningCount < this.maxConcurrent)
      {
        localWorkNode = this.pendingJobs;
        if (localWorkNode != null)
        {
          this.pendingJobs = localWorkNode.removeFromList(this.pendingJobs);
          this.runningJobs = localWorkNode.addToList(this.runningJobs, false);
          this.runningCount = (1 + this.runningCount);
          localWorkNode.setIsRunning(true);
        }
      }
      if (localWorkNode != null) {
        execute(localWorkNode);
      }
      return;
    }
    finally {}
  }
  
  private void startItem()
  {
    finishItemAndStartNew(null);
  }
  
  WorkQueue.WorkItem addActiveWorkItem(Runnable paramRunnable)
  {
    return addActiveWorkItem(paramRunnable, true);
  }
  
  WorkQueue.WorkItem addActiveWorkItem(Runnable paramRunnable, boolean paramBoolean)
  {
    WorkQueue.WorkNode localWorkNode = new WorkQueue.WorkNode(this, paramRunnable);
    synchronized (this.workLock)
    {
      this.pendingJobs = localWorkNode.addToList(this.pendingJobs, paramBoolean);
      startItem();
      return localWorkNode;
    }
  }
  
  /* Error */
  void validate()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	com/facebook/internal/WorkQueue:workLock	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: iconst_0
    //   8: istore_2
    //   9: aload_0
    //   10: getfield 48	com/facebook/internal/WorkQueue:runningJobs	Lcom/facebook/internal/WorkQueue$WorkNode;
    //   13: ifnull +34 -> 47
    //   16: aload_0
    //   17: getfield 48	com/facebook/internal/WorkQueue:runningJobs	Lcom/facebook/internal/WorkQueue$WorkNode;
    //   20: astore 4
    //   22: aload 4
    //   24: iconst_1
    //   25: invokevirtual 109	com/facebook/internal/WorkQueue$WorkNode:verify	(Z)V
    //   28: iinc 2 1
    //   31: aload 4
    //   33: invokevirtual 113	com/facebook/internal/WorkQueue$WorkNode:getNext	()Lcom/facebook/internal/WorkQueue$WorkNode;
    //   36: astore 4
    //   38: aload 4
    //   40: aload_0
    //   41: getfield 48	com/facebook/internal/WorkQueue:runningJobs	Lcom/facebook/internal/WorkQueue$WorkNode;
    //   44: if_acmpne -22 -> 22
    //   47: getstatic 29	com/facebook/internal/WorkQueue:$assertionsDisabled	Z
    //   50: ifne +24 -> 74
    //   53: aload_0
    //   54: getfield 50	com/facebook/internal/WorkQueue:runningCount	I
    //   57: iload_2
    //   58: if_icmpeq +16 -> 74
    //   61: new 115	java/lang/AssertionError
    //   64: dup
    //   65: invokespecial 116	java/lang/AssertionError:<init>	()V
    //   68: athrow
    //   69: astore_3
    //   70: aload_1
    //   71: monitorexit
    //   72: aload_3
    //   73: athrow
    //   74: aload_1
    //   75: monitorexit
    //   76: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	WorkQueue
    //   4	71	1	localObject1	Object
    //   8	51	2	i	int
    //   69	4	3	localObject2	Object
    //   20	19	4	localWorkNode	WorkQueue.WorkNode
    // Exception table:
    //   from	to	target	type
    //   9	72	69	finally
    //   74	76	69	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.WorkQueue
 * JD-Core Version:    0.7.0.1
 */