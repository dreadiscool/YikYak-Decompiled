package com.parse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ParseTestUtils$StateTransitionListener
  implements PushConnection.StateTransitionListener
{
  private ArrayList<ParseTestUtils.StateTransition> transitions = new ArrayList();
  
  public List<ParseTestUtils.StateTransition> getTransitions()
  {
    try
    {
      List localList = Collections.unmodifiableList(this.transitions);
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void onStateChange(PushConnection paramPushConnection, PushConnection.State paramState1, PushConnection.State paramState2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/parse/ParseTestUtils$StateTransitionListener:transitions	Ljava/util/ArrayList;
    //   6: new 30	com/parse/ParseTestUtils$StateTransition
    //   9: dup
    //   10: invokestatic 36	android/os/SystemClock:elapsedRealtime	()J
    //   13: aload_1
    //   14: aload_2
    //   15: aload_3
    //   16: invokespecial 39	com/parse/ParseTestUtils$StateTransition:<init>	(JLcom/parse/PushConnection;Lcom/parse/PushConnection$State;Lcom/parse/PushConnection$State;)V
    //   19: invokevirtual 43	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   22: pop
    //   23: aload_3
    //   24: ifnull +25 -> 49
    //   27: invokestatic 49	com/parse/ParseTestUtils:access$000	()Ljava/util/concurrent/Semaphore;
    //   30: ifnull +19 -> 49
    //   33: aload_3
    //   34: instanceof 51
    //   37: ifeq +12 -> 49
    //   40: invokestatic 49	com/parse/ParseTestUtils:access$000	()Ljava/util/concurrent/Semaphore;
    //   43: invokevirtual 56	java/util/concurrent/Semaphore:release	()V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_3
    //   50: ifnull -4 -> 46
    //   53: invokestatic 59	com/parse/ParseTestUtils:access$100	()Ljava/util/concurrent/Semaphore;
    //   56: ifnull -10 -> 46
    //   59: aload_3
    //   60: instanceof 61
    //   63: ifeq -17 -> 46
    //   66: invokestatic 59	com/parse/ParseTestUtils:access$100	()Ljava/util/concurrent/Semaphore;
    //   69: invokevirtual 56	java/util/concurrent/Semaphore:release	()V
    //   72: goto -26 -> 46
    //   75: astore 4
    //   77: aload_0
    //   78: monitorexit
    //   79: aload 4
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	StateTransitionListener
    //   0	82	1	paramPushConnection	PushConnection
    //   0	82	2	paramState1	PushConnection.State
    //   0	82	3	paramState2	PushConnection.State
    //   75	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	46	75	finally
    //   53	72	75	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseTestUtils.StateTransitionListener
 * JD-Core Version:    0.7.0.1
 */