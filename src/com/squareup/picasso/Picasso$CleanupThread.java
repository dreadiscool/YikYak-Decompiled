package com.squareup.picasso;

import android.os.Handler;
import java.lang.ref.ReferenceQueue;

class Picasso$CleanupThread
  extends Thread
{
  private final Handler handler;
  private final ReferenceQueue<?> referenceQueue;
  
  Picasso$CleanupThread(ReferenceQueue<?> paramReferenceQueue, Handler paramHandler)
  {
    this.referenceQueue = paramReferenceQueue;
    this.handler = paramHandler;
    setDaemon(true);
    setName("Picasso-refQueue");
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: bipush 10
    //   2: invokestatic 39	android/os/Process:setThreadPriority	(I)V
    //   5: aload_0
    //   6: getfield 16	com/squareup/picasso/Picasso$CleanupThread:referenceQueue	Ljava/lang/ref/ReferenceQueue;
    //   9: invokevirtual 45	java/lang/ref/ReferenceQueue:remove	()Ljava/lang/ref/Reference;
    //   12: checkcast 47	com/squareup/picasso/Action$RequestWeakReference
    //   15: astore 4
    //   17: aload_0
    //   18: getfield 18	com/squareup/picasso/Picasso$CleanupThread:handler	Landroid/os/Handler;
    //   21: aload_0
    //   22: getfield 18	com/squareup/picasso/Picasso$CleanupThread:handler	Landroid/os/Handler;
    //   25: iconst_3
    //   26: aload 4
    //   28: getfield 51	com/squareup/picasso/Action$RequestWeakReference:action	Lcom/squareup/picasso/Action;
    //   31: invokevirtual 57	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   34: invokevirtual 61	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   37: pop
    //   38: goto -33 -> 5
    //   41: astore_3
    //   42: return
    //   43: astore_1
    //   44: aload_0
    //   45: getfield 18	com/squareup/picasso/Picasso$CleanupThread:handler	Landroid/os/Handler;
    //   48: new 63	com/squareup/picasso/Picasso$CleanupThread$1
    //   51: dup
    //   52: aload_0
    //   53: aload_1
    //   54: invokespecial 66	com/squareup/picasso/Picasso$CleanupThread$1:<init>	(Lcom/squareup/picasso/Picasso$CleanupThread;Ljava/lang/Exception;)V
    //   57: invokevirtual 70	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   60: pop
    //   61: goto -19 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	CleanupThread
    //   43	11	1	localException	java.lang.Exception
    //   41	1	3	localInterruptedException	java.lang.InterruptedException
    //   15	12	4	localRequestWeakReference	Action.RequestWeakReference
    // Exception table:
    //   from	to	target	type
    //   5	38	41	java/lang/InterruptedException
    //   5	38	43	java/lang/Exception
  }
  
  void shutdown()
  {
    interrupt();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Picasso.CleanupThread
 * JD-Core Version:    0.7.0.1
 */