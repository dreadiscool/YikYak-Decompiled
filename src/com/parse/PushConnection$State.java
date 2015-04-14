package com.parse;

import java.util.concurrent.ExecutorService;

public abstract class PushConnection$State
  implements Runnable
{
  public PushConnection$State(PushConnection paramPushConnection) {}
  
  public boolean isTerminal()
  {
    return false;
  }
  
  public void run()
  {
    State localState = runState();
    for (;;)
    {
      try
      {
        if (PushConnection.access$100() != null) {
          PushConnection.access$100().onStateChange(this.this$0, this, localState);
        }
        if (isTerminal())
        {
          Parse.logI("com.parse.PushConnection", this + " finished and is the terminal state. Thread exiting.");
          PushConnection.access$200(this.this$0).shutdown();
          return;
        }
      }
      finally {}
      if (localState == null) {
        break;
      }
      Parse.logI("com.parse.PushConnection", "PushConnection transitioning from " + this + " to " + localState);
      PushConnection.access$200(this.this$0).execute(localState);
    }
    throw new NullPointerException(this + " tried to transition to null state.");
  }
  
  public abstract State runState();
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushConnection.State
 * JD-Core Version:    0.7.0.1
 */