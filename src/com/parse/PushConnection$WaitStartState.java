package com.parse;

import java.util.Set;

public class PushConnection$WaitStartState
  extends PushConnection.State
{
  public PushConnection$WaitStartState(PushConnection paramPushConnection)
  {
    super(paramPushConnection);
  }
  
  public PushConnection.State runState()
  {
    Object localObject = null;
    PushConnection.EventSet localEventSet = PushConnection.access$300(this.this$0);
    PushConnection.Event[] arrayOfEvent = new PushConnection.Event[2];
    arrayOfEvent[0] = PushConnection.Event.START;
    arrayOfEvent[1] = PushConnection.Event.STOP;
    Set localSet = localEventSet.await(arrayOfEvent);
    if (localSet.contains(PushConnection.Event.STOP)) {
      localObject = new PushConnection.StoppedState(this.this$0);
    }
    for (;;)
    {
      return localObject;
      if (localSet.contains(PushConnection.Event.START)) {
        localObject = new PushConnection.ConnectState(this.this$0, 0L);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushConnection.WaitStartState
 * JD-Core Version:    0.7.0.1
 */