package com.facebook;

class Session$4
  implements Runnable
{
  Session$4(Session paramSession, SessionState paramSessionState, Exception paramException) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/facebook/Session$4:this$0	Lcom/facebook/Session;
    //   4: invokestatic 30	com/facebook/Session:access$1200	(Lcom/facebook/Session;)Ljava/util/List;
    //   7: astore_1
    //   8: aload_1
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 16	com/facebook/Session$4:this$0	Lcom/facebook/Session;
    //   14: invokestatic 30	com/facebook/Session:access$1200	(Lcom/facebook/Session;)Ljava/util/List;
    //   17: invokeinterface 36 1 0
    //   22: astore_3
    //   23: aload_3
    //   24: invokeinterface 42 1 0
    //   29: ifeq +42 -> 71
    //   32: new 44	com/facebook/Session$4$1
    //   35: dup
    //   36: aload_0
    //   37: aload_3
    //   38: invokeinterface 48 1 0
    //   43: checkcast 50	com/facebook/Session$StatusCallback
    //   46: invokespecial 53	com/facebook/Session$4$1:<init>	(Lcom/facebook/Session$4;Lcom/facebook/Session$StatusCallback;)V
    //   49: astore 4
    //   51: aload_0
    //   52: getfield 16	com/facebook/Session$4:this$0	Lcom/facebook/Session;
    //   55: invokestatic 57	com/facebook/Session:access$1300	(Lcom/facebook/Session;)Landroid/os/Handler;
    //   58: aload 4
    //   60: invokestatic 61	com/facebook/Session:access$1400	(Landroid/os/Handler;Ljava/lang/Runnable;)V
    //   63: goto -40 -> 23
    //   66: astore_2
    //   67: aload_1
    //   68: monitorexit
    //   69: aload_2
    //   70: athrow
    //   71: aload_1
    //   72: monitorexit
    //   73: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	4
    //   7	65	1	localList	java.util.List
    //   66	4	2	localObject	Object
    //   22	16	3	localIterator	java.util.Iterator
    //   49	10	4	local1	Session.4.1
    // Exception table:
    //   from	to	target	type
    //   10	69	66	finally
    //   71	73	66	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.Session.4
 * JD-Core Version:    0.7.0.1
 */