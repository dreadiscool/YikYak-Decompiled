package com.parse;

import java.util.Set;

public class PushConnection$WaitRetryState
  extends PushConnection.State
{
  private long delay;
  
  public PushConnection$WaitRetryState(PushConnection paramPushConnection, long paramLong)
  {
    super(paramPushConnection);
    this.delay = paramLong;
  }
  
  public long getDelay()
  {
    return this.delay;
  }
  
  public PushConnection.State runState()
  {
    PushConnection.EventSet localEventSet1 = PushConnection.access$300(this.this$0);
    PushConnection.Event[] arrayOfEvent1 = new PushConnection.Event[1];
    arrayOfEvent1[0] = PushConnection.Event.START;
    localEventSet1.removeEvents(arrayOfEvent1);
    long l = this.delay;
    if (!PushConnection.ENABLE_RETRY_DELAY) {
      l = 0L;
    }
    PushConnection.EventSet localEventSet2 = PushConnection.access$300(this.this$0);
    PushConnection.Event[] arrayOfEvent2 = new PushConnection.Event[2];
    arrayOfEvent2[0] = PushConnection.Event.STOP;
    arrayOfEvent2[1] = PushConnection.Event.START;
    Set localSet = localEventSet2.timedAwait(l, arrayOfEvent2);
    Object localObject;
    if (localSet.contains(PushConnection.Event.STOP)) {
      localObject = new PushConnection.StoppedState(this.this$0);
    }
    for (;;)
    {
      return localObject;
      if (localSet.contains(PushConnection.Event.START)) {
        localObject = new PushConnection.ConnectState(this.this$0, 0L);
      } else {
        localObject = new PushConnection.ConnectState(this.this$0, this.delay);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushConnection.WaitRetryState
 * JD-Core Version:    0.7.0.1
 */